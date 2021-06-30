package br.edu.usj.mycamping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.usj.mycamping.model.locacao.Locacao;
import br.edu.usj.mycamping.model.locacao.LocacaoRepository;
import br.edu.usj.mycamping.model.lotes.LotesRepository;




@Controller
public class LocacaoController {
    

    @Autowired
    LocacaoRepository locacaoRepository;

    @Autowired
    LotesRepository lotesRepository;
    


    //*********************DELETAR LOCAÇÃO************************//
    @GetMapping(value="/mostrarLocacao/{id}")
    public String getDeletarLocacao(@PathVariable Long id) {
        locacaoRepository.deleteById(id);    
        return "redirect:/mostrarLocacao";
    }

    //*********************VISUALIZAR LOCAÇÃO************************//
    @GetMapping(value="/mostrarLocacao")
    public ModelAndView getLocacao() {
        List<Locacao> listarLocacao = locacaoRepository.findAll();
        
        ModelAndView md = new ModelAndView("mostrarLocacao");
        md.addObject("listarLocacao", listarLocacao);
        md.addObject("lista_lotes", lotesRepository.findAll());
        return md;
    }

    
    //*********************MAPEAR LOCAÇÃO************************//
    @GetMapping(value="/cadastrarLocacao")
    public ModelAndView getCadastraLocacao() {
        
        Locacao locacao = new Locacao();
        ModelAndView md = new ModelAndView("cadastrarLocacao");
        md.addObject("locacao", locacao);
        md.addObject("lista_locacao", locacaoRepository.findAll());
        md.addObject("lista_lotes", lotesRepository.findAll());
        // locacao.setFlagReservar(true);
        return md;
    }
    
    //*********************INSERIR LOCAÇÃO************************//
    @PostMapping(value="/cadastrarLocacao")
    public String postInserirLocacao(Locacao locacao) {
        
        locacaoRepository.save(locacao);
        ModelAndView md = new ModelAndView("/cadastrarLocacao");
        md.addObject("lista_locacao", locacaoRepository.findAll());
        md.addObject("lista_lotes", lotesRepository.findAll());
        
        return "redirect:/paginaInicial";
        
    }


    //*********************EDITAR LOCAÇÃO************************//
    @GetMapping(value="/cadastrarLocacao/{id}")
    public ModelAndView getEditarLocacoes(@PathVariable Long id) {
        Locacao locacao = locacaoRepository.findById(id).get();
        ModelAndView md = new ModelAndView("cadastrarLocacao");
        md.addObject("locacao", locacao);
        md.addObject("lista_locacao", locacaoRepository.findAll());
        md.addObject("lista_lotes", lotesRepository.findAll());
        return md;
    }

}