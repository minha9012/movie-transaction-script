package org.eternity.script.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Reservation {
    @Id
    private Long id;
    private Long customerId;
    private Long screeningId;
    private Integer audienceCount;
    private Long fee;

    public Reservation(Long customerId, Long screeningId, Integer audienceCount, Long fee) {
        this.customerId = customerId;
        this.screeningId = screeningId;
        this.audienceCount = audienceCount;
        this.fee = fee;
    }
}
