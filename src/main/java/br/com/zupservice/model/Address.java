package br.com.zupservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String country;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Client> client;

}
