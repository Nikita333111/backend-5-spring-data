package com.bobocode.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * todo:
 * - configure JPA entity
 * - specify table name: "product"
 * - configure auto generated identifier
 * - configure mandatory column "name" for field {@link Product#name}
 * <p>
 * - configure lazy many-to-one relation between {@link Product} and {@link Company}
 * - configure foreign key column "company_id" references company table
 * - override equals() and hashCode() considering entity id
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
}
