package br.edu.usj.mycamping.model.lotes;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import br.edu.usj.mycamping.model.locacao.Locacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Lotes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer numero_lote;
    Double preco;
    String area;
    String descricao;

    @OneToMany
    @JoinColumn(name="id_lote")
    List<Locacao> locacao;

}


