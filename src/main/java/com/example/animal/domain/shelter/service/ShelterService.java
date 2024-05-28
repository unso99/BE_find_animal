package com.example.animal.domain.shelter.service;

import com.example.animal.domain.district.entity.District;
import com.example.animal.domain.district.repository.DistrictRepository;
import com.example.animal.domain.shelter.dto.response.ShelterListOpenApiResponse;
import com.example.animal.domain.shelter.entity.Shelter;
import com.example.animal.domain.shelter.repository.ShelterRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final DistrictRepository districtRepository;

    //보호소 전체 정보 저장
    public List<Shelter> saveAll(ShelterListOpenApiResponse response, String orgCd) {
        District district = districtRepository.findByOrgCd(orgCd)
                .orElseThrow(() -> new IllegalArgumentException("Not Found cityProvince"));

        return shelterRepository.saveAll(response.getShelters().stream()
                .map((shelter) -> shelter.toEntity(district,district.getCityProvince()))
                .toList());
    }

    public List<Shelter> findByDistrictId(Long id) {
        return shelterRepository.findByDistrictId(id).orElse(Collections.emptyList());
    }

    public List<Shelter> findByCityProvinceId(Long id) {
        return shelterRepository.findByCityProvinceId(id).orElse(Collections.emptyList());
    }
}
