package com.formation.kartina_spring.models;



import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Commande{

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    
    private Integer prixTotalHt;
   
    
    private Integer TVA;
    
    @Temporal(TemporalType.DATE)
    private Calendar date_livraison;

    @Temporal(TemporalType.DATE)
    private Calendar date_paiement;

    
}
    

