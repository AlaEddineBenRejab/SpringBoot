package esprit.tn.spring.gestionmagasinstock.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private float montantRemise;
    private float monatantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private Boolean active;

    @OneToMany(mappedBy = "facture")
    private List<DetailFacture> detailFactures;

    @ManyToOne
    private Client client;
}
