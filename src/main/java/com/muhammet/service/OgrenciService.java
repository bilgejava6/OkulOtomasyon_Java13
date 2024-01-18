package com.muhammet.service;

import com.muhammet.entity.BaseEntity;
import com.muhammet.entity.Ogrenci;
import com.muhammet.entity.enums.State;
import com.muhammet.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OgrenciService {
    /**
     * Bir bağımlılığın Enjekte edilmesi için temelde kullandığımız 2 yöntem vardir;
     * 1- @Autowired ile işaretlemek
     * 2- constructorInjection ile spring application context in DI ile bağımlılık enjeksiyonu yapmak.
     */
    // 1. yöntem
    //@Autowired
    //private OgrenciRepository ogrenciRepository;

    // 2. yöntem - ConstructorInjection
    private final OgrenciRepository ogrenciRepository;
    // DİKKAT!!!!!
    // constructor u yazmadan yazılmış gibi kullanmak için
    // lombok anotasyonlarını kullababilirsiniz.
//    public OgrenciService(OgrenciRepository ogrenciRepository){
//        this.ogrenciRepository = ogrenciRepository;
//    }

    public void save(Ogrenci ogrenci){
        ogrenci.setBaseEntity(
                BaseEntity.builder()
                        .state(State.AKTIF)
                        .createAt(System.currentTimeMillis())
                        .updateAt(System.currentTimeMillis())
                        .build()
        );
        ogrenciRepository.save(ogrenci);
    }

    public List<Ogrenci> findAll(){
        return ogrenciRepository.findAll();
    }

    public List<Ogrenci> getirOgrencileriTumunuAdinaGore(String ad){
        return  ogrenciRepository.findAllByAd(ad);
    }

    public List<Ogrenci> findAllByAdLike(String ad) {
        return ogrenciRepository.findAllByAdLike(ad);
    }
}
