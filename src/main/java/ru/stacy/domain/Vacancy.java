package ru.stacy.domain;

import lombok.Getter;
import lombok.Setter;
import ru.stacy.domain.enums.VacancyType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private VacancyType vacancyType;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "experience", nullable = false)
    private String experience;

    @Column(name = "published_at_date", columnDefinition = "DATE")
    private LocalDateTime publishedAtDate;

    @Column(name = "published_at_time", columnDefinition = "TIME")
    private LocalTime publishedAtTime;

    @Column(name = "published_at_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime publishedAtDateTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Company company;

    public Vacancy() {
        this.publishedAtDate = LocalDateTime.now();
        this.publishedAtTime = LocalTime.now();
        this.publishedAtDateTime = LocalDateTime.now();
    }
}
