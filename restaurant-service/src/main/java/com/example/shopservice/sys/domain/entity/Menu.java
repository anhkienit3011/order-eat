package com.example.shopservice.sys.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false,insertable=false, updatable=false)
    Restaurant restaurant;

    String name;
    @ColumnDefault("null")
    String description ;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<MenuItem> menuItems;
}
