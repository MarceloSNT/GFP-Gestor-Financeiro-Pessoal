package projeto.gfp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.gfp.dto.gestao.request.GestaoRequestDto;
import projeto.gfp.dto.gestao.response.GestaoResponseDto;
import projeto.gfp.models.AcaoFinanceiraModel;
import projeto.gfp.models.GestaoFinanceiraModel;
import projeto.gfp.models.UsuarioModel;
import projeto.gfp.repository.AcaoRepository;
import projeto.gfp.repository.GestaoRepository;
import projeto.gfp.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class GestaoService {

    private final GestaoRepository gestaoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public GestaoResponseDto save(GestaoRequestDto requestDto){

        UsuarioModel usuario = usuarioRepository.findByCdUsuario(requestDto.cdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        GestaoFinanceiraModel gestao = new GestaoFinanceiraModel();
        gestao.setNmTitulo(requestDto.nmTitulo());
        gestao.setCdUsuario(usuario);

        GestaoFinanceiraModel salvo = gestaoRepository.save(gestao);

        return new GestaoResponseDto(
                salvo.getCdGestao(),
                salvo.getNmTitulo(),
                salvo.getCdUsuario().getNmUsuario(),
                salvo.isFlAtivo()
        );
    }
}
