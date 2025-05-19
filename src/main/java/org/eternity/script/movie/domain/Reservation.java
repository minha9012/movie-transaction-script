package org.eternity.script.movie.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
@TableGenerator(
        name = "reservation_table",
        table = "sequence_table",
        pkColumnName = "seq_name",
        pkColumnValue = "reservation_seq",
        initialValue = 1, allocationSize = 20
)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "reservation_table")
    private Long id;
    private Long customerId;
    private Long screeningId;
    @Column(name = "audience_count")
    private Integer audienceCount;
    @Column
    private Long fee;

    public Reservation(Long customerId, Long screeningId, Integer audienceCount, Long fee) {
        this.customerId = customerId;
        this.screeningId = screeningId;
        this.audienceCount = audienceCount;
        this.fee = fee;
    }
}
