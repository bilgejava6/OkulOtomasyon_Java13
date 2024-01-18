package com.muhammet.service;

import com.muhammet.entity.BaseEntity;
import com.muhammet.entity.Ebeveyn;
import com.muhammet.entity.enums.State;
import com.muhammet.repository.EbeveynRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EbeveynService {
    private final EbeveynRepository ebeveynRepository;

    public void save(Ebeveyn ebeveyn){
        ebeveyn.setBaseEntity(
                BaseEntity.builder()
                        .state(State.AKTIF)
                        .createAt(System.currentTimeMillis())
                        .updateAt(System.currentTimeMillis())
                        .build()
        );
        ebeveynRepository.save(ebeveyn);
    }

    public List<Ebeveyn> findAll(){
        return ebeveynRepository.findAll();
    }

}
