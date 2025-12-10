package projeto.gfp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.gfp.dto.acao.request.AcaoRequestDto;
import projeto.gfp.dto.acao.response.AcaoResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.models.*;
import projeto.gfp.repository.AcaoRepository;
import projeto.gfp.repository.GestaoRepository;
import projeto.gfp.repository.StatusRepository;
import projeto.gfp.repository.TipoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcaoService {

    private final AcaoRepository acaoRepository;
    private final GestaoRepository gestaoRepository;
    private final StatusRepository statusRepository;
    private final TipoRepository tipoRepository;

    @Transactional
    public AcaoResponseDto save(AcaoRequestDto requestDto) {
        GestaoFinanceiraModel gestao = gestaoRepository.findByCdGestao(requestDto.cdGestao())
                .orElseThrow(() -> new RuntimeException("Gestão não encontrado"));

        StatusModel status = statusRepository.findByCdStatus(requestDto.cdStatus())
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

        TipoModel tipo = tipoRepository.findByCdTipo(requestDto.cdTipo())
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));

        AcaoFinanceiraModel acao = new AcaoFinanceiraModel();
        acao.setDsTitulo(requestDto.dsTitulo());
        acao.setDsDescricao(requestDto.dsDescricao());
        acao.setVlValor(requestDto.vlValor());
        acao.setDtData(requestDto.dtData());
        acao.setFlAtivo(true);
        acao.setCdStatus(status);
        acao.setCdTipo(tipo);
        acao.setGestao(gestao);

        AcaoFinanceiraModel salvo = acaoRepository.save(acao);

        return new AcaoResponseDto(
                salvo.getCdAcao(),
                salvo.getDsTitulo(),
                salvo.getDsDescricao(),
                salvo.getVlValor(),
                salvo.getDtData(),
                salvo.getCdStatus().getNmStatus(),
                salvo.getCdTipo().getNmTipo(),
                salvo.getGestao().getNmTitulo()
        );
    }

    @Transactional
    public List<AcaoResponseDto> findAllAction() {
        return acaoRepository.findAll()
                .stream()
                .filter(acaoModel -> acaoModel.isFlAtivo())
                .map(acoes -> new AcaoResponseDto(
                        acoes.getCdAcao(),
                        acoes.getDsTitulo(),
                        acoes.getDsDescricao(),
                        acoes.getVlValor(),
                        acoes.getDtData(),
                        acoes.getCdStatus().getNmStatus(),
                        acoes.getGestao().getNmTitulo(),
                        acoes.getCdTipo().getNmTipo()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public AcaoResponseDto offOrOnFlAtivo(Long cdAcao) {
        AcaoFinanceiraModel acao = acaoRepository.findByCdAcao(cdAcao)
                .orElseThrow(() -> new RuntimeException("Ação não encontrada"));

        acao.setFlAtivo(!acao.isFlAtivo());
        acaoRepository.save(acao);

        return new AcaoResponseDto(
                acao.getCdAcao(),
                acao.getDsTitulo(),
                acao.getDsDescricao(),
                acao.getVlValor(),
                acao.getDtData(),
                acao.getCdStatus().getNmStatus(),
                acao.getCdTipo().getNmTipo(),
                acao.getGestao().getNmTitulo()
        );
    }

    @Transactional
    public List<AcaoResponseDto> findByGestao(Long cdGestao){
        return acaoRepository.findByGestaoCdGestao(cdGestao)
                .stream()
                .filter(acaoFinanceiraModel -> acaoFinanceiraModel.isFlAtivo())
                .map(acoes -> new AcaoResponseDto(
                        acoes.getCdAcao(),
                        acoes.getDsTitulo(),
                        acoes.getDsDescricao(),
                        acoes.getVlValor(),
                        acoes.getDtData(),
                        acoes.getCdStatus().getNmStatus(),
                        acoes.getCdTipo().getNmTipo(),
                        acoes.getGestao().getNmTitulo()
                ))
                .collect(Collectors.toList());
    }
}
