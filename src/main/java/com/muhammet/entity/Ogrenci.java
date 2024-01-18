package com.muhammet.entity;

import com.muhammet.entity.enums.Cinsiyet;
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
@Table(name = "tbl_ogrenci")
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "ad",nullable = false,length = 50)
    String ad;
    @Column(name = "soyad",nullable = false,length = 50)
    String soyad;
    @Enumerated
    Cinsiyet cinsiyet;
    Integer yas;
    @Embedded
    BaseEntity baseEntity;
}
