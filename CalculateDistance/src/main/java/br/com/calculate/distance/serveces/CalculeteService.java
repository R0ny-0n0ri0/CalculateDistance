package br.com.calculate.distance.serveces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.com.calculate.distance.dto.AddressDTO;
import br.com.calculate.distance.dto.BatchDTO;
import br.com.calculate.distance.dto.DistanceResponseDTO;
import br.com.calculate.distance.dto.IndexDTO;
import br.com.calculate.distance.dto.MatrixAddressDTO;
import br.com.calculate.distance.dto.MatrixDTO;
import br.com.calculate.distance.dto.MatrixResponseDTO;
import br.com.calculate.distance.dto.ReturnDTO;
import br.com.calculate.distance.dto.SourcesDTO;
import br.com.calculate.distance.dto.TargetsDTO;
import br.com.calculate.distance.dto.UrlDTO;

@Service
public class CalculeteService {

	public MatrixAddressDTO requestBody(List<String> requestBody) throws Exception {

		if (requestBody.size() < 3) {

			throw new Exception("Deve ter mais de três endereços!");
		}

		String uri = "https://api.geoapify.com/v1/batch/geocode/search?&apiKey=YOUR_KEY";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(uri, requestBody, String.class);
		UrlDTO urlDTO = new ObjectMapper().readValue(result, UrlDTO.class);
		MatrixAddressDTO returnDTO = sendUrl(urlDTO);

		return returnDTO;
	}

	@Async
	public MatrixAddressDTO sendUrl(UrlDTO urlDTO) throws JsonMappingException, JsonProcessingException {

		try {
			Thread.sleep(10000);

			RestTemplate restTemplate = new RestTemplate();
			String resultUrl = restTemplate.getForObject(urlDTO.getUrl(), String.class);
			ObjectMapper mapper = new ObjectMapper();
			CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, BatchDTO.class);
			List<BatchDTO> batchDTO = mapper.readValue(resultUrl, javaType);
			MatrixAddressDTO returnDTO = bacth(batchDTO);
			return returnDTO;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MatrixAddressDTO bacth(List<BatchDTO> batchDTO) throws JsonMappingException, JsonProcessingException {

		ArrayList<TargetsDTO> targetsList = new ArrayList<TargetsDTO>();
		ArrayList<SourcesDTO> sourcesList = new ArrayList<SourcesDTO>();
		MatrixDTO matrixDTO = new MatrixDTO();

		for (BatchDTO object : batchDTO) {
			
			SourcesDTO sources = new SourcesDTO();
			TargetsDTO targets = new TargetsDTO();
			matrixDTO.setMode("walk");
			sources.setLocation(new Double[] { object.getLon(), object.getLat() });
			targets.setLocation(new Double[] { object.getLon(), object.getLat() });
			sourcesList.add(sources);
			targetsList.add(targets);

			matrixDTO.setSources(sourcesList);
			matrixDTO.setTargets(targetsList);

		}

		MatrixAddressDTO returnDTO = matrix(matrixDTO, batchDTO);

		return returnDTO;
	}

	public MatrixAddressDTO matrix(MatrixDTO matrixDTO, List<BatchDTO> batchDTO)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(matrixDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("apiKey", "YOUR_KEY");
		HttpEntity<String> request = new HttpEntity<String>(jsonStr, headers);

		String uri = "https://api.geoapify.com/v1/routematrix?apiKey=YOUR_KEY";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(uri, request, String.class);
		MatrixAddressDTO returnDTO = distance(result, batchDTO, matrixDTO);

		return returnDTO;
	}

	public MatrixAddressDTO distance(String result, List<BatchDTO> batchDTO, MatrixDTO matrixDTO)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		MatrixResponseDTO matrixResponseDTO = mapper.readValue(result, MatrixResponseDTO.class);
		MatrixAddressDTO returnDTO = matrixSet(matrixResponseDTO, batchDTO);
		return returnDTO;
	}

	public MatrixAddressDTO matrixSet(MatrixResponseDTO matrixResponseDTO, List<BatchDTO> batchDTOList)
			throws JsonMappingException, JsonProcessingException {

		ArrayList<DistanceResponseDTO[]> distanceResponseDTOArray = matrixResponseDTO.getSources_to_targets();
		ArrayList<DistanceResponseDTO> distanceResponseDTOList = new ArrayList<DistanceResponseDTO>();
		for (DistanceResponseDTO[] distanceResponseList : distanceResponseDTOArray) {
			for (DistanceResponseDTO distanceResponse : distanceResponseList) {
				DistanceResponseDTO distanceResponseDTO = new DistanceResponseDTO();
				distanceResponseDTO.setDistance(distanceResponse.getDistance());
				distanceResponseDTO.setSource_index(distanceResponse.getSourceIndex());
				distanceResponseDTO.setTarget_index(distanceResponse.getTarget_index());
				distanceResponseDTO.setTime(distanceResponse.getTime());

				distanceResponseDTOList.add(distanceResponseDTO);

			}

		}

		MatrixAddressDTO returnDTO = orderedAddress(batchDTOList, distanceResponseDTOList);
		return returnDTO;
	}

	public MatrixAddressDTO orderedAddress(List<BatchDTO> batchDTOList,
			List<DistanceResponseDTO> distanceResponseDTOList) throws JsonMappingException, JsonProcessingException {

		ArrayList<IndexDTO> indexDTOList = new ArrayList<IndexDTO>();
		ArrayList<AddressDTO> addressDTOList = new ArrayList<AddressDTO>();
		MatrixAddressDTO matrixAddressDTO = new MatrixAddressDTO();

		for (int i = 0; i <= batchDTOList.size() - 1; i++) {
			IndexDTO indexDTO = new IndexDTO();
			indexDTO.setIndex(i);
			indexDTOList.add(indexDTO);

		}
		for (BatchDTO batchDTO : batchDTOList) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setAdress(batchDTO.getQuery().getText());
			addressDTOList.add(addressDTO);
		}
		matrixAddressDTO.setAddress(addressDTOList);
		matrixAddressDTO.setIndex(indexDTOList);
		System.out.println(matrixAddressDTO);

		MatrixAddressDTO returnDTO = orderedReturn(matrixAddressDTO, distanceResponseDTOList);

		return returnDTO;
	}

	public MatrixAddressDTO orderedReturn(MatrixAddressDTO matrixAddressDTO,
			List<DistanceResponseDTO> distanceResponseDTOList) throws JsonMappingException, JsonProcessingException {

		List<ReturnDTO> returnDTOList = new ArrayList<ReturnDTO>();
		for (AddressDTO addressDTO : matrixAddressDTO.getAddress()) {
			ReturnDTO returnDTO = new ReturnDTO();
			returnDTO.setDepartureAddress(addressDTO.getAdress());
			returnDTOList.add(returnDTO);
		}
		MatrixAddressDTO returnDTO = orderedList(distanceResponseDTOList, returnDTOList, matrixAddressDTO);

		return returnDTO;
	}

	public MatrixAddressDTO orderedList(List<DistanceResponseDTO> distanceResponseDTOList,
			List<ReturnDTO> returnDTOList, MatrixAddressDTO matrixAddressDTO)
			throws JsonMappingException, JsonProcessingException {

		ArrayList<DistanceResponseDTO> distanceResponseOrdered = new ArrayList<DistanceResponseDTO>();
		ArrayList<ReturnDTO> returnAllList = new ArrayList<ReturnDTO>();

		distanceResponseDTOList.sort((d1, d2) -> Integer.compare(d1.getDistance(), d2.getDistance()));

		distanceResponseDTOList.forEach((DistanceResponseDTO distance) -> {
			DistanceResponseDTO distanceResponseDTO = new DistanceResponseDTO();
			distanceResponseDTO.setDistance(distance.getDistance());
			distanceResponseDTO.setSource_index(distance.getSourceIndex());
			distanceResponseDTO.setTarget_index(distance.getTarget_index());
			distanceResponseDTO.setTime(distance.getTime());
			distanceResponseOrdered.add(distanceResponseDTO);

		});

		distanceResponseDTOList.forEach((DistanceResponseDTO distance) -> {
			returnDTOList.forEach((ReturnDTO returnList) -> {
				ReturnDTO returnDTO = new ReturnDTO();
				returnDTO.setDistance(distance);
				returnDTO.setDepartureAddress(returnList.getDepartureAddress());

				returnAllList.add(returnDTO);

			});
		});

		MatrixAddressDTO returnDTO = finalList(returnAllList, matrixAddressDTO);
		return returnDTO;

	}

	public MatrixAddressDTO finalList(List<ReturnDTO> returnDTOList, MatrixAddressDTO matrixAddressDTO)
			throws JsonMappingException, JsonProcessingException {

		ArrayList<ReturnDTO> returnAllList = new ArrayList<ReturnDTO>();
		returnDTOList.forEach((ReturnDTO returnList) -> {
			ReturnDTO returnDTO = new ReturnDTO();
			if (returnList.getDistance().getDistance() != 0) {
				returnDTO.setDistance(returnList.getDistance());
				returnDTO.setDepartureAddress(returnList.getDepartureAddress());
				returnAllList.add(returnDTO);

			}
		});

		MatrixAddressDTO returnDTO = shortestDistance(returnAllList, matrixAddressDTO);
		return returnDTO;
	}

	public MatrixAddressDTO shortestDistance(List<ReturnDTO> returnDTOList, MatrixAddressDTO matrixAddressDTO)
			throws JsonMappingException, JsonProcessingException {

		ArrayList<ReturnDTO> returnAllList = new ArrayList<ReturnDTO>();

		returnDTOList.get(0).setDescription("Menor distância Percorrida!");
		returnDTOList.get(returnDTOList.size() - 1).setDescription("Maior distância Percorrida!");
		for (ReturnDTO returnDTOListAll : returnDTOList) {
			ReturnDTO returnDTO = new ReturnDTO();
			if (returnDTOListAll.getDescription() != null) {
				returnDTO.setDepartureAddress(returnDTOListAll.getDepartureAddress());
				returnDTO.setDistance(returnDTOListAll.getDistance());
				returnDTO.setDescription(returnDTOListAll.getDescription());
				returnAllList.add(returnDTO);
			}

		}

		matrixAddressDTO.setReturnDTO(returnAllList);

		return matrixAddressDTO;
	}

}
