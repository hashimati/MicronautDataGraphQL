package com.mygroup.countrygraphql.domains;

import io.micronaut.data.annotation.*;

import lombok.*;
import javax.validation.constraints.*;

import java.util.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@MappedEntity("countries")
public class Country {

  @Id
  @GeneratedValue(GeneratedValue.Type.AUTO)
  @EqualsAndHashCode.Exclude
  private Long id;

  private String name;

  @DateCreated private Date dateCreated;

  @DateUpdated private Date dateUpdated;
}