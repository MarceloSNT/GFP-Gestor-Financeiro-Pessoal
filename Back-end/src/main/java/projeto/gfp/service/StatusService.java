package projeto.gfp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.gfp.dto.status.request.StatusRequestDto;
import projeto.gfp.dto.status.response.StatusResponseDto;
import projeto.gfp.models.StatusModel;
import projeto.gfp.repository.StatusRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    @Transactional
    public StatusResponseDto save(StatusRequestDto requestDto){
        StatusModel status = new StatusModel();
        status.setNmStatus(requestDto.nmStatus());

        StatusModel salvo = statusRepository.save(status);
        return new StatusResponseDto(
                salvo.getCdStatus(),
                salvo.getNmStatus()
        );
    }

    @Transactional
    public List<StatusResponseDto> findAllStatus(){
        return statusRepository.findAll()
                .stream()
                .map(status -> new StatusResponseDto(
                        status.getCdStatus(),
                        status.getNmStatus()
                ))
                .collect(Collectors.toList());
    }
}
