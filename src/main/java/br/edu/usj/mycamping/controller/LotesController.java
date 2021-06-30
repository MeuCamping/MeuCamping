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
import br.edu.usj.mycamping.model.lotes.Lotes;
import br.edu.usj.mycamping.model.lotes.LotesRepository;



@Controller
public class LotesController {

    @Autowired
    LotesRepository lotesRepository;

    @Autowired
    LocacaoRepository locacaoRepository;

    @GetMapping(value="/paginaInicial")
    public ModelAndView getpaginaInicial() {
        List<Lotes> listarLotes = lotesRepository.findAll();
        Locacao locacao = new Locacao();
        ModelAndView md = new ModelAndView("paginaInicial");
        md.addObject("listarLotes", listarLotes);
        md.addObject("locacao", locacao);
        return md;
    }

    @GetMapping(value="/mostrarLotes/{id}")
    public String getDeletarLtes(@PathVariable Long id) {
        lotesRepository.deleteById(id);    
        return "redirect:/mostrarLotes";
    }


    @GetMapping(value="/mostrarLotes")
    public ModelAndView getMostrarLotes() {
        List<Lotes> listarLotes = lotesRepository.findAll();
        ModelAndView md = new ModelAndView("mostrarLotes");
        md.addObject("listarLotes", listarLotes);
        return md;
    }
 

    @GetMapping(value="/cadastrarLote")
    public ModelAndView getCadastrarLotes() {
        ModelAndView md = new ModelAndView("cadastrarLote");
        md.addObject("lotes", new Lotes());
        md.addObject("lote", lotesRepository.findAll());
        md.addObject("locacoes", locacaoRepository.findAll());
        return md;
    }
    
    @PostMapping(value="/cadastrarLote")
    public String postInserirLotes(Lotes lotes) {
        lotesRepository.save(lotes);
        return "redirect:/cadastrarLote";
    }


    @GetMapping(value="/cadastrarLote/{id_lote}")
    public ModelAndView getEditarLotes(@PathVariable Long id_lote) {
        Lotes lotes = lotesRepository.findById(id_lote).get();
        ModelAndView md = new ModelAndView("cadastrarLote");
        md.addObject("lotes", lotes);
        md.addObject("lista_lotes", lotesRepository.findAll());
        return md;
    }



}
