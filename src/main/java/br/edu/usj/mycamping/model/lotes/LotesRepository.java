package br.edu.usj.mycamping.model.lotes;

import java.util.List;
import org.springframework.data.repository.CrudRepository;



public interface  LotesRepository extends CrudRepository<Lotes,Long> {
    List<Lotes> findAll();
    
    }
    