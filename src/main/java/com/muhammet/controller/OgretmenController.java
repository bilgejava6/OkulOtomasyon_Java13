package com.muhammet.controller;

import com.muhammet.dto.request.OgretmenSaveRequestDto;
import com.muhammet.dto.response.OgretmenResponseDto;
import com.muhammet.exception.ErrorType;
import com.muhammet.exception.OkulOtomasyonuException;
import com.muhammet.service.OgretmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.muhammet.constants.RestApiUrls.*;

@RestController
@RequestMapping(OGRETMEN)
@RequiredArgsConstructor
public class OgretmenController {
    private final OgretmenService ogretmenService;
    /**
     *  Normal durumda
     *  public String -> string metin:  response: 200 Ok.
     *  İstisna olsa ne olacak?
     *  siz elle hatalı bir durumu rapor etmek isteseniz ne olacak?
     *  Boş bir nesne ile cevap veremezsiniz. Bu nedenle cevap ı
     *  manipule edebileceğiniz bir sınıfa ihtiyacınız var.
     *  ResponseEntity -> istenilen türde cevap döner.
     *  200, 300, 400, 500 şeklinde cevap dönebilir.
     *
     *  Post ->
     *  form element(form-data) içinde
     *  @RequestBody raw-> json body
     *  *** DİKKAT!!!!!!
     *  controller, iş katmanı değildir bu nedenle burada iş yapmıyoruz.
     *  temel amacı işlenmiş veriyi almak ve servise iletmektir. Bu nedenle
     *  burada sadece  tutarlı veriyi iletme işlemi yapıyorsunuz.
     */
    @PostMapping(ADD)
    public ResponseEntity<Void> save(@RequestBody OgretmenSaveRequestDto dto){
//        Ogretmen ogretmen = Ogretmen.builder()
//                .ad(dto.getAd())
//                .soyad(dto.getSoyad())
//                .brans(dto.getBrans())
//                .build();
//        ogretmenService.save(ogretmen);
        ogretmenService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<OgretmenResponseDto>> getAll(){
        return ResponseEntity.ok(ogretmenService.findAll());
    }

    @GetMapping(CREATE_ERROR)
    public ResponseEntity<String> hataOlustur(String ad){
        if(ad.equalsIgnoreCase("Muhammet")){
            throw new OkulOtomasyonuException(ErrorType.ERROR_OGRETMEN_EKLEME_HATASI,
                    "Kullanıcıdan gelen ad parametresi hatalıdır. lütden özel karakter olmadığından emin olun");
        }else {
            return ResponseEntity.ok(ad);
        }
    }
}
