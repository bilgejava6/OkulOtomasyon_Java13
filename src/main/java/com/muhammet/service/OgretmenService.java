package com.muhammet.service;

import com.muhammet.dto.request.OgretmenSaveRequestDto;
import com.muhammet.dto.response.OgretmenResponseDto;
import com.muhammet.entity.Ogretmen;
import com.muhammet.mapper.OgretmenMapper;
import com.muhammet.repository.OgretmenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OgretmenService {
    private final OgretmenRepository ogretmenRepository;

    public void save(OgretmenSaveRequestDto dto){
//        Ogretmen ogretmen = Ogretmen.builder()
//                .ad(dto.getAd())
//                .soyad(dto.getSoyad())
//                .brans(dto.getBrans())
//                .build();
        Ogretmen ogretmen = OgretmenMapper.INSTANCE.ogretmeniAlDtoDan(dto);
        ogretmenRepository.save(ogretmen);
    }

    public List<OgretmenResponseDto> findAll(){
        List<OgretmenResponseDto> result = new ArrayList<>();
        ogretmenRepository.findAll().forEach(o->
//            result.add(
//                    OgretmenResponseDto.builder()
//                            .id(o.getId())
//                            .ad(o.getAd())
//                            .soyad(o.getSoyad())
//                            .brans(o.getBrans())
//                            .build()
//            )
                result.add(OgretmenMapper.INSTANCE.fromOgretmen(o))
        );
        return result;
    }
}
