package com.crud.smogfront.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
//    @JsonProperty("id")
//    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("addressCity")
    private String addressCity;
    @JsonProperty("addressStreet")
    private String addressStreet;
    @JsonProperty("addressProvince")
    private String addressProvince;
}
