package com.learn.david.web_mvc_cas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {
    @Id
    private String ref;
    private String name;
}
