package com.fr.mailsenderrabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Utilisateur {

    private int id;

    private String nom;

    private String prenom;

    private String mail;

    private Boolean isEmailConfirmed;
}
