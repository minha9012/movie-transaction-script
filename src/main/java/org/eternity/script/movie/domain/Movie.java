package org.eternity.script.movie.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long policyId;

    @Column
    private String title;
    @Column(name = "running_time")
    private Integer runningTime;
    @Column
    private Long fee;

    public Movie(Long policyId, String title, Integer runningTime, Long fee) {
        this.policyId = policyId;
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }
}
