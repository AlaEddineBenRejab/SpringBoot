package esprit.tn.spring.gestionmagasinstock.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;
    private int qte;
    private float prixTotal;
    private int pourcentageRemise;
    private int montantRemise;

    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Facture facture;
}
