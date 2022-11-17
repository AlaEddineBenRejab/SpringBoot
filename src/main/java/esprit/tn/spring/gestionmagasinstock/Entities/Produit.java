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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prixUnitaire;

    @ManyToOne
    private Rayon rayon;
    @ManyToMany
    private List<Fournisseur> fournisseurs;
    @ManyToOne
    private Stock stock;
    @OneToOne
    private DetailProduit detailProduit;
    @OneToMany(mappedBy = "produit")
    private List<DetailProduit> detailProduits;

}
