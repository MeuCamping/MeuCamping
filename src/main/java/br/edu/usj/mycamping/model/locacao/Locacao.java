package br.edu.usj.mycamping.model.locacao;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.usj.mycamping.model.lotes.Lotes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    
    String nome;
    String email;
    String telefone;
    String cpf;

    @Column(name = "data_entrada_lote")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataCheckin;

    @Column(name = "data_saida_lote")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataCheckout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_lote")
     public Lotes lotes;

    
}
