package io.github.moizesjr.controller;

import io.github.moizesjr.model.Usuario;
import io.github.moizesjr.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    private final UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar (@RequestBody @Valid Usuario usuario){
        repository.save(usuario);
    }


}
