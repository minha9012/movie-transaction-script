package org.eternity.script.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Movie {
    @Id
    private Long id;
    private Long policyId;
    private String title;
    private Integer runningTime;
    private Long fee;

    public Movie(Long policyId, String title, Integer runningTime, Long fee) {
        this.policyId = policyId;
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }
}
