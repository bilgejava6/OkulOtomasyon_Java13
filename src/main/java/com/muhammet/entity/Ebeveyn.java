package com.muhammet.entity;

import com.muhammet.entity.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_ebeveyn")
public class Ebeveyn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "ad",nullable = false,length = 50)
    String ad;
    @Column(name = "soyad",nullable = false,length = 50)
    String soyad;
    @Column(name = "telefon",nullable = false,length = 20) // +090 (555) 555 55 55
    String telefon;
    @Column(name = "adres",nullable = false,length = 300)
    String adres;
    @Embedded
    BaseEntity baseEntity;
}
