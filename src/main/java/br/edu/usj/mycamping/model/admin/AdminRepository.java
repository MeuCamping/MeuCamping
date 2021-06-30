package br.edu.usj.mycamping.model.admin;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    List<Admin> findAll();
}