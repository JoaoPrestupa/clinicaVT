package br.com.clinicavt.controllers;

import br.com.clinicavt.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeterinarioController {

    @Autowired
    VeterinarioRepository veterinarioRepository;

}
