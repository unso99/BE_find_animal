package com.example.animal.domain.cityprovince.entity;

import com.example.animal.domain.district.entity.District;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CityProvince {
//team
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITYPROVINCE_ID")
    private Long id;
    //시도 코드
    private String orgCd;
    //시도명
    private String orgdownNm;

    @OneToMany(mappedBy = "cityProvince")
    private List<District> districts = new ArrayList<>();

    @Builder
    public CityProvince(String orgCd, String orgdownNm) {
        this.orgCd = orgCd;
        this.orgdownNm = orgdownNm;
    }
}