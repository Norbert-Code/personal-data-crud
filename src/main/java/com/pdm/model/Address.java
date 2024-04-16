package com.pdm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Data
public class Address {

  @NotBlank(message = "Zipcode cannot be blank")
  @Size(min = 4, max = 4, message = "Zipcode must be exactly 5 characters long")
  private String zipcode;

  @NotBlank(message = "City cannot be blank")
  private String city;

  @NotBlank(message = "Street cannot be blank")
  private String street;
}
