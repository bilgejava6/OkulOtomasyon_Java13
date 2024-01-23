package com.muhammet.mapper;

import com.muhammet.dto.request.OgretmenSaveRequestDto;
import com.muhammet.dto.response.OgretmenResponseDto;
import com.muhammet.entity.Ogretmen;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Burada ilgili entityler den DTO olara dönüşüm yapacağız. tüm işlemler
 * method tanımlama şeklinde yapılcaktır.
 * componentModel -> ilgili interface den nesne yaratma işlemlerinin yapısını belirtiyoruz.
 * unmappedTargetPolicy -> hedeflenen nesneden kaynaktaki parametrelerin olmaması durumunda
 * neler olacağını, davranış şeklini belirtiyoruz.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OgretmenMapper {
    /**
     * Aşağıdaki işlem, yaratılan nesnenin instance ını kullanabilmek için yazılmıştır.
     * burada mapstruct sizin interface inizden bir nesne yaratacak ve referansızı kullanmanız
     * için size iletecektir.
     */
    OgretmenMapper INSTANCE = Mappers.getMapper(OgretmenMapper.class);

    /**
     * Yazım Şekliniz.
     * Target -> Source
     * [oluşturmak istediğiniz sınıf] [method adı] ([verilerin alınacağı kaynak sınıf])
     * amaç
     */
    Ogretmen ogretmeniAlDtoDan(final OgretmenSaveRequestDto dto);

    OgretmenResponseDto fromOgretmen(final Ogretmen ogretmen);
}
