package com.crud.smogfront.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String addressCity;
    private String addressStreet;
    private String addressProvince;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getAddressCity() != null ? !getAddressCity().equals(user.getAddressCity()) : user.getAddressCity() != null)
            return false;
        if (getAddressStreet() != null ? !getAddressStreet().equals(user.getAddressStreet()) : user.getAddressStreet() != null)
            return false;
        return getAddressProvince() != null ? getAddressProvince().equals(user.getAddressProvince()) : user.getAddressProvince() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getAddressCity() != null ? getAddressCity().hashCode() : 0);
        result = 31 * result + (getAddressStreet() != null ? getAddressStreet().hashCode() : 0);
        result = 31 * result + (getAddressProvince() != null ? getAddressProvince().hashCode() : 0);
        return result;
    }
}

