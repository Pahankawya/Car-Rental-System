package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer {
    @Id
    private String cusNicId;
    private String cusName;
    private String cusEmail;
    private String cusTel;
    private String cusPassword;
    private String cusNicFrontImg;
    private String cusNicBackImg;
}
