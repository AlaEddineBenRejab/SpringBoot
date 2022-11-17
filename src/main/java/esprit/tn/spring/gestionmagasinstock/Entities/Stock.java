package esprit.tn.spring.gestionmagasinstock.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    private int qteStock;
    private int qteMin;
    private String libelleStock;

    @OneToMany(mappedBy = "stock")
    private List<Produit> produits;
}
