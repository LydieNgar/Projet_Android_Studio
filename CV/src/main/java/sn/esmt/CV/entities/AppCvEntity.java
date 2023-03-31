package sn.esmt.CV.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "appcv")

public class AppCvEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String nom;
    @Column(length = 150, nullable = false)
    private String prenom;
    @Column(length = 50, nullable = false)
    private int age;
    @Column(length = 200, nullable = false)
    private String adresse;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 150, nullable = false)
    private String telephone;
    @Column(length = 250, nullable = false)
    private String specialite;
    @Column(length = 100, nullable = false)
    private String niveauEtude;
    @Column(length = 500, nullable = false)
    private String experienceProfessionnelle;


}
