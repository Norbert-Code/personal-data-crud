package com.pdm.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "Persons")
@Data
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String lastName;
  @NotBlank
  private String firstName;
  @NotBlank
  private String birthName;
  @NotBlank
  private String motherName;

  private String gender;
  @NotBlank
  private String citizenship;
  @Valid
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "zipcode", column = @Column(name = "residence_zipcode")),
      @AttributeOverride(name = "city", column = @Column(name = "residence_city")),
      @AttributeOverride(name = "street", column = @Column(name = "residence_street"))
  })
  private Address residenceAddress;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "zipcode", column = @Column(name = "mailing_zipcode")),
      @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
      @AttributeOverride(name = "street", column = @Column(name = "mailing_street"))
  })
  private Address mailingAddress;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "zipcode", column = @Column(name = "current_zipcode")),
      @AttributeOverride(name = "city", column = @Column(name = "current_city")),
      @AttributeOverride(name = "street", column = @Column(name = "current_street"))
  })
  private Address currentAddress;
  @NotBlank
  private String phoneNumber;
  @NotBlank
  @Size(min =11, max = 11, message = "Tax number must be exactly 11 characters long")
  private String taxNumber;

  private String notes;

}
