package br.edu.usj.mycamping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.usj.mycamping.model.admin.Admin;
import br.edu.usj.mycamping.model.admin.AdminRepository;

@Controller
public class AdminController {
    

    @Autowired
    AdminRepository adminRepository;

     //*********************DELETAR ADMIN************************//
     @GetMapping(value="/mostrarAdmin/{id}")
     public String getDeletarAdmin(@PathVariable Long id) {
         adminRepository.deleteById(id);    
         return "redirect:/mostrarAdmin";
     }
 
     //*********************VISUALIZAR ADMIN************************//
     @GetMapping(value="/mostrarAdmin")
     public ModelAndView getAdmin() {
         List<Admin> listarAdmin = adminRepository.findAll();         
         ModelAndView md = new ModelAndView("mostrarAdmin");
         md.addObject("listarAdmin", listarAdmin);
         return md;
     }
        

    @GetMapping(value="/index")
    public String getCadastraAdmin(Admin admin) {
        return "index";
    }
     
     //*********************MAPEAR ADMIN************************//
     @GetMapping(value="/cadastrarAdmin")
     public ModelAndView getCadastraAdmin() {
         
         Admin admin = new Admin();
         ModelAndView md = new ModelAndView("cadastrarAdmin");
         md.addObject("admin", admin);
         return md;
     }
     
     //*********************INSERIR ADMIN************************//
     @PostMapping(value="/cadastrarAdmin")
     public String postInserirAdmin(Admin admin) {
        adminRepository.save(admin);
        return "redirect:/cadastrarAdmin";
         
     }
 
 
     //*********************EDITAR ADMIN************************//
     @GetMapping(value="/cadastrarAdmin/{id}")
     public ModelAndView getEditarAdmin(@PathVariable Long id) {
         Admin admin = adminRepository.findById(id).get();
         ModelAndView md = new ModelAndView("cadastrarAdmin");
         md.addObject("admin", admin);
         md.addObject("lista_admin", adminRepository.findAll());
         return md;
     }
 
}
