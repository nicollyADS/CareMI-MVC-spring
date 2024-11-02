package br.com.mapped.caremi.controller;

import br.com.mapped.caremi.dto.UseForm;
import br.com.mapped.caremi.model.SexoBiologico;
import br.com.mapped.caremi.model.Usuario;
import br.com.mapped.caremi.repository.UsuarioRepository;
import br.com.mapped.caremi.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("usuario", new UseForm());
        return "usuario/cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid UseForm useForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "usuario/cadastrar";
        }
        usuarioService.salvar(useForm.getUsername(), passwordEncoder.encode(useForm.getPassword()));
        return "redirect:/login";
    }


}