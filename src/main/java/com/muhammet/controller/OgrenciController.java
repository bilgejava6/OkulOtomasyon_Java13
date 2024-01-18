package com.muhammet.controller;

import com.muhammet.entity.Ogrenci;
import com.muhammet.entity.enums.Cinsiyet;
import com.muhammet.service.OgrenciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ogrenci")
@RequiredArgsConstructor
public class OgrenciController {
    private final OgrenciService ogrenciService;
    /**
     * TODO: DİKKAT!!!! IDEMPOTENT DESIGN PATTERN
     * "Idempotent" terimi, bir işlemin aynıyla tekrar tekrar uygulansa dahi, sonuçlarının ve sunucu tarafındaki
     * işlemlerinin değişmemesi durumudur. Idempotent bir işlemi tekrar tekrar uygulama sonucu değiştirmemelidir.
     * Uygulamalarımızda, tutarlılık ve ön görülebilirlik için kullanılır.
     *
     * HTTP İsteklerinde Idempotent olanlar;
     * GET, PUT, DELETE
     *
     * İdempotent sistemimizde oluşabilecek hatalarla başaçıkmada yardımcı olabilecek bir tasarım prensibidir.
     *
     *
     */

    /**
     * POST isteği, end-point tüm istek türlerinde aynıdır değşimez sadece client ın geliş şekli değişir.
     * http://localhost:8080/ogrenci/save
     * DİKKAT!!!!
     * POST isteğinde parmetrele BODY içinde sunucuya iletilir. Böylece GET isteğinde açık bir şekilde
     * iletilen datalar güvenli bir şekilde sunucuya iletilmiş olur.
     */
    @PostMapping("/save")
    public void save(String ad,
                     Integer yas,
                     String soyad,
                     Cinsiyet cinsiyet){
        System.out.println();
        Ogrenci ogrenci = Ogrenci.builder()
                .ad(ad)
                .yas(yas)
                .soyad(soyad)
                .cinsiyet(cinsiyet)
                .build();
        ogrenciService.save(ogrenci);
    }

    @GetMapping("/get-all")
    public List<Ogrenci> getAll(){
        return ogrenciService.findAll();
    }

    @GetMapping("/get-all-by-ad")
    public List<Ogrenci> getAllByAd(String ad){
        return ogrenciService.getirOgrencileriTumunuAdinaGore(ad);
    }

    @GetMapping("/get-all-by-ad-like")
    public List<Ogrenci> getAllByAdLike(String ad){
        return ogrenciService.findAllByAdLike("%"+ad+"%");
    }
}
