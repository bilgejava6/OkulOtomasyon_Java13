package com.muhammet.repository;

import com.muhammet.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    List<Ogrenci> findAllByAdLikeIgnoreCase(String ad); // ilike

    /**
     * StartingWith
     * aranılan ifade ile başlıyor mu?
     * search: ay
     * select * from tblogrenci where ad like 'ay%'
     */
    List<Ogrenci> findAllByAdStartingWith(String ad);

    /**
     *
     * select * from tblogrenci where ad like 'a%' and soyad like 'ab%'
     */
    List<Ogrenci> findAllByAdStartingWithAndSoyadStartingWith(String ad, String soyad);

    /**
     * Sıralama işlemleri
     * select * from tblogrenci order by ad [desc-asc]
     * OrerBy
     * ASC -> a....z, 0.....9
     * DESC-> z...a, 9.....0
     */
    List<Ogrenci> findByOrderByYas(); //a...z
    List<Ogrenci> findAllByOrderByYasDesc(); // z...a

    /**
     * select * from tlbogrenci where ad like 'a%' order by soyad desc
     */
    List<Ogrenci> findAllByAdStartingWithOrderBySoyadDesc(String ad);

    /**
     * Sorgularda gelen datanını kısıtlanması
     * select * from tblogrenci limit 3 -(TOP)
     */
    List<Ogrenci> findTop5ByYasGreaterThan(Integer yas);

    /**
     * select * from tblogrenci order by yas desc limit 1
     */
    Ogrenci findTopByOrderByYasDesc();

    /**
     * Between -> iki değer aralığında sorgulamalar için
     * DİKKAT!!! -> yas<=? and yas>=? [50,60]
     */
    List<Ogrenci> findAllByYasBetween(Integer start, Integer end);

    /**
     * select * from tblogrenci where ad like 'a%' and yas<=? and yas>=?
     */
    List<Ogrenci> findAllByAdStartingWithAndYasBetween(String ad,Integer start, Integer end);

    /**
     * DİKKAT!!!!!!
     * sorgulamalar da her zaman değer gelmeye bilir bu nedenle çektiğiniz bilgi
     * null olacktır. Bu nedenle null chechk yapmanız gerekecek. Bu doğru bir yöntem
     * değildir. bunu yönetmek için Optional
     * ÖNEMLİ!!!!
     * optional kullanırken DB den mutlaka en fazla 1 kayıt geleceğinden enim olun.
     * neden, çünkü DB den birden fazla kayıt gelirse sorgu sonucu Optional a
     * atayamaz ve uygulama exception fırlatır.
     */
    Optional<Ogrenci> findOptionalByAdAndSoyadAndYas(String ad,String soyad, Integer yas);

    /**
     * Boolean değeri sorgulamak için True/False direkt olarak kullanılabilir.
     * select * from tblogrenci where isactive = true
     */
//    List<Ogrenci> findAllByIsactiveTrue(); // aktif öğrenciler
//    List<Ogrenci> findAllByIsactiveFalse(); // pasif öğrenciler
//    List<Ogrenci> findAllByIsActive(Boolean isActive);

    List<Ogrenci> findDistinctByAdAndSoyad(String ad, String soyad);

    List<Ogrenci> findAllByYasIsNull();
    List<Ogrenci> findAllByYasIsNotNull();

    /**
     *
     * select * from tblogrenci where ad like '%?%'
     */
    List<Ogrenci> findAllByAdContaining(String ad);

    /**
     * Performanlı aramalarda sıklıkla kullanıyorum.
     *
     * select * from tblogrenci where ad in(?,?,?,?,?)
     */
    List<Ogrenci> findAllByAdIn(List<String> adlar);


    /**
     * HQL -> Hibernate Query Language
     * JPQL -> Jakarta Persistence Query Language
     * NativeSQL -> Native Structure Query Language
     */

    @Query("select o from Ogrenci o where o.soyad= ?1")
    List<Ogrenci> senGetirBanaTumVerileriSoyadinaGore(String soyad);

    @Query("select o from Ogrenci o where o.ad= ?1 and o.yas= ?2")
    List<Ogrenci> birBakBakayimOgrencilerSiniftaMi(String ad, Integer yas);

    /**
     * Native SQL
     */
    @Query(nativeQuery = true, value = "select * from Ogrenci")
    List<Ogrenci> tumOgrenicleriGetir();

    /**
     * select count(o) from tblogrenci as o where yas > 15
     */
    @Query("select count(o) from Ogrenci o where o.yas> ?1")
    Integer kacOgrenciVar(Integer yas);
}
