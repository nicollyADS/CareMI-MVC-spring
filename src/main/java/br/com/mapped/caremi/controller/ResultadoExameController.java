package br.com.mapped.caremi.controller;

import br.com.mapped.caremi.model.ResultadoExame;
import br.com.mapped.caremi.repository.ExameRepository;
import br.com.mapped.caremi.repository.ResultadoExameRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("resultado-exame")
public class ResultadoExameController {

    @Autowired
    private ResultadoExameRepository resultadoExameRepository;

    @Autowired
    private ExameRepository exameRepository;

    @GetMapping("cadastrar")
    public String cadastrar(ResultadoExame resultadoExame, Model model){

        model.addAttribute("resultadoExame", new ResultadoExame());
        model.addAttribute("exames", exameRepository.findAll());
        return "resultado-exame/cadastrar";
    }


    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid ResultadoExame resultadoExame, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            return "resultado-exame/cadastrar";
        }
        resultadoExameRepository.save(resultadoExame);
        redirectAttributes.addFlashAttribute("mensagem", "resultado do exame cadastrado com sucesso!");
        return "redirect:/resultado-exame/cadastrar";
    }


    @GetMapping("listar")
    public String listar(Model model) {
        model.addAttribute("resultadosExames", resultadoExameRepository.findAll());
        return "resultado-exame/listar";
    }


    @GetMapping("detalhes/{id}")
    public String detalhesResultadosExames(@PathVariable Long id, Model model) {
        Optional<ResultadoExame> optionalResultadoExame = resultadoExameRepository.findById(id);
        if (optionalResultadoExame.isPresent()) {
            model.addAttribute("resultadoExame", optionalResultadoExame.get());
        } else {
            model.addAttribute("erro", "resultado do exame não encontrado");
            return "error";
        }
        return "resultado-exame/detalhes";
    }



    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Optional<ResultadoExame> optionalResultadoExame = resultadoExameRepository.findById(id);
        if (optionalResultadoExame.isPresent()) {
            model.addAttribute("resultadoExame", optionalResultadoExame.get());
        } else {
            model.addAttribute("erro", "resultado do exame não encontrado");
            return "error";
        }
        return "resultado-exame/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid ResultadoExame resultadoExame, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("resultadoExame", resultadoExame);
            return "resultado-exame/editar";
        }
        resultadoExameRepository.save(resultadoExame);
        redirectAttributes.addFlashAttribute("mensagem", "o resultado do exame foi atualizado!");
        return "redirect:/resultado-exame/listar";
    }


    @PostMapping("remover")
    @Transactional
    public String remover(Long id, RedirectAttributes redirectAttributes) {
        resultadoExameRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "o resultado do exame foi removido com sucesso");
        return "redirect:/resultado-exame/listar";
    }

}