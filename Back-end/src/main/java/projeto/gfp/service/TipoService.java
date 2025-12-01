package projeto.gfp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.gfp.dto.status.request.StatusRequestDto;
import projeto.gfp.dto.status.response.StatusResponseDto;
import projeto.gfp.dto.tipo.request.TipoRequestDto;
import projeto.gfp.dto.tipo.response.TipoResponseDto;
import projeto.gfp.models.StatusModel;
import projeto.gfp.models.TipoModel;
import projeto.gfp.repository.TipoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoRepository tipoRepository;

    @Transactional
    public TipoResponseDto save(TipoRequestDto requestDto){
        TipoModel tipo = new TipoModel();
        tipo.setNmTipo(requestDto.nmTipo());

        TipoModel salvo = tipoRepository.save(tipo);
        return new TipoResponseDto(
                salvo.getCdTipo(),
                salvo.getNmTipo()
        );
    }

    @Transactional
    public List<TipoResponseDto> findAllType(){
        return tipoRepository.findAll()
                .stream()
                .map(tipo -> new TipoResponseDto(
                        tipo.getCdTipo(),
                        tipo.getNmTipo()
                ))
                .collect(Collectors.toList());
    }
}
