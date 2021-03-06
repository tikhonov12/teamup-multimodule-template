package ru.team.up.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Сущность интересы
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INTERESTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users"})
public class Interests {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название
     */
    @Column(name = "TITLE", nullable = false)
    private String title;

    /**
     * Краткое описание
     */
    @Column(name = "SHORT_DESCRIPTION", nullable = false)
    private String shortDescription;

    /**
     * Пользователи
     */
    @ManyToMany
    @JoinTable(name = "USER_ACCOUNT_INTERESTS",
            joinColumns = @JoinColumn(name = "INTERESTS_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> users;

    /**
     * ID мероприятия
     */
    @ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
    @JoinColumn(name="EVENT_ID")
    private Set<Event> event;
}
