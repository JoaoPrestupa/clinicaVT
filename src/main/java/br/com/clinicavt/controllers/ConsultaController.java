package br.com.clinicavt.controllers;

import br.com.clinicavt.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;


}
