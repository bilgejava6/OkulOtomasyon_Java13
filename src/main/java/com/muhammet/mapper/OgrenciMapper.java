package com.muhammet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OgrenciMapper {
    OgrenciMapper INSTANCE = Mappers.getMapper(OgrenciMapper.class);
}
