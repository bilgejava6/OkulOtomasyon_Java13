package com.muhammet.repository;

import com.muhammet.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * TODO: REPOSITORY, Temel veritabanı işlemlerini yapmak için kullandığımız sınıfı ifade eder.
 * Spring bu sınıftan bir Bean yaratır, Ancak burada dikkat edilmesi gerekli olan bir r
 * hususvardır, Spring Boot 3.x den önceki sürümlerde bu sınıftan bir bean yaratılabilmesi için
 * @Respoitory anotasyonu eklemek zorunlu idi, Ancak artık ilgili sınıf JpaRepository den extends olması
 * yeterli olmaktadır.
 *
 */
// @Repository before 3.x
public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {

    /**
     * TODO: Jpa Keywords, spring kedisine özgü kelimelerin bir araya gelmesi ile oluşan
     * methodların gövdelerini oluşturabilmektedir.
     * Select * from tblogrenci where ad=? and soyad=? and yas>? and yas<?
     * List<Ogrenci> findAll By Ad And Soyad And Between Yas(String ad, String soyad,Integer yasStart,Integer yasEnd);
     * TODO: Jpa REpository Keywordleri kullanılarak nasıl sorgu methodu oluşturulur?
     * 1- [find - count - get - delete] bu key wordler den birisi ile başlamınız gereklidir.
     * 2- By: ilk seçilecek property belirleniyor.
     * 3- [Entity değişkeninin adı]: Dikkat entity değişkeni yazılırken mutlaka başharfi büyük olacak
     * şekilde yazılmalıdır. büyüklü küçüklü olsa bile ilk fark büyük diğer kelimelerin harfleri yazım
     * şeklinize göre yazılmalıdır.
     * örn: User{
     *     ad,  -> findByAd
     *     adSoyad -> findByAdSoyad
     *     adsoyad -> findByAdsoyad
     * }
     * 4- Eğer başka sorgular ek parametreler eklenecek ise, And, Or [In, Not, True] ile devam edilmelidir.
     * 5- Eğer method yazımında parametre talep edecek şekilde oluşturulmuş ise, parantezler içinde yazılan
     * parametrelerin sırası ile eklenmesi gereklidir. aşağıdki örnekte olduğu gibi method adında Ad ve Soyad
     * için iki parametre talep edildiği açıktır.
     * 6- her methodun geri dönüş tipi belirtilmelidir, burada sorgu neticesinde ne talep ediliyor ise
     * ona göre geri dönüş tipi belirleyiniz.
     */
    /**
     * select * from where ad=? and soyad=?
     */
    Ogrenci findByAdAndSoyad(String ahmet_amca_nasilsin, String iyidir_yegen);
    Optional<Ogrenci> findOptionalByAdAndSoyad(String ad, String soyad);

    /**
     *
     * select * from tblogrenci where ad=?
     */
    List<Ogrenci> findAllByAd(String ad);

    /**
     *
     * select * from tblogrenci where yas>?
     */
    List<Ogrenci> findAllByYasGreaterThan(Integer yas);

    /**
     * Like -> _ %
     * select * from tblogrenci where ad like ?1 -> '%al%'
     */
    List<Ogrenci> findAllByAdLike(String ad);


}
