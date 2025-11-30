package projeto.gfp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.gfp.Role;
import projeto.gfp.dto.usuario.request.UsuarioRequestDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseListarDto;
import projeto.gfp.models.UsuarioModel;
import projeto.gfp.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioResponseDto save(UsuarioRequestDto usuarioRequest){
        if (usuarioRepository.findByDsEmail(usuarioRequest.dsEmail().toLowerCase()).isPresent()){
            throw new RuntimeException("E-mail já cadastrado");
        }
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNmUsuario(usuarioRequest.nmUsuario());
        usuario.setDsEmail(usuarioRequest.dsEmail());
        usuario.setDsSenha(usuarioRequest.dsSenha());
        usuario.setROLE(Role.USER);
        usuario.setFlAtivo(true);

        UsuarioModel salvo = usuarioRepository.save(usuario);
        return new UsuarioResponseDto(
                salvo.getNmUsuario(),
                salvo.getDsEmail(),
                salvo.isFlAtivo(),
                salvo.getROLE()
        );
    }

    @Transactional
    public UsuarioResponseDto offOrOnFlAtivo(String dsEmail){
        UsuarioModel usuario =usuarioRepository.findByDsEmail(dsEmail)
                .orElseThrow(() -> new RuntimeException("E-mail não encontrado"));

        usuario.setFlAtivo(!usuario.isFlAtivo());
        usuarioRepository.save(usuario);

        return new UsuarioResponseDto(
                usuario.getNmUsuario(),
                usuario.getDsEmail(),
                usuario.isFlAtivo(),
                usuario.getROLE()
        );
    }

    @Transactional
    public List<UsuarioResponseListarDto> findAllUser(){
            return usuarioRepository.findAll()
                    .stream()
                    .filter(usuarioModel -> usuarioModel.isFlAtivo())
                    .map(usuarios -> new UsuarioResponseListarDto(
                                    usuarios.getNmUsuario(),
                                    usuarios.getDsEmail(),
                                    usuarios.getROLE()
                    )
                    )
                    .collect(Collectors.toList());
    }

    @Transactional
    public Optional<UsuarioResponseDto> findById(Long cdUsuario){
        return usuarioRepository.findByCdUsuario(cdUsuario)
                .filter(usuarioModel -> usuarioModel.isFlAtivo())
                .map(usuario -> new UsuarioResponseDto(
                        usuario.getNmUsuario(),
                        usuario.getDsEmail(),
                        usuario.isFlAtivo(),
                        usuario.getROLE()
                ));
    }

    @Transactional
    public Optional<UsuarioResponseDto> findByEmail(String dsEmail){
        return usuarioRepository.findByDsEmail(dsEmail)
                .filter(usuarioModel -> usuarioModel.isFlAtivo())
                .map(usuario -> new UsuarioResponseDto(
                        usuario.getNmUsuario(),
                        usuario.getDsEmail(),
                        usuario.isFlAtivo(),
                        usuario.getROLE()
                ));
    }

}