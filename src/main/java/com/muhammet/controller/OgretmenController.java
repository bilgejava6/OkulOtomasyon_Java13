package com.muhammet.controller;

import com.muhammet.dto.request.OgretmenSaveRequestDto;
import com.muhammet.dto.response.OgretmenResponseDto;
import com.muhammet.entity.Ogrenci;
import com.muhammet.entity.Ogretmen;
import com.muhammet.service.OgretmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ogretmen")
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
    @PostMapping("/add")
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

    @GetMapping("get-all")
    public ResponseEntity<List<OgretmenResponseDto>> getAll(){
        return ResponseEntity.ok(ogretmenService.findAll());
    }
}
