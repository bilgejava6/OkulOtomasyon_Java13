package com.muhammet.entity;

import com.muhammet.entity.enums.State;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class BaseEntity {
    @Enumerated
    State state;
    Long createAt;
    Long updateAt;
}
