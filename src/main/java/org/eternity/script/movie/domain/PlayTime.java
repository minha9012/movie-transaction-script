package org.eternity.script.movie.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PlayTime {
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10)")
    private DayOfWeek dayOfWeek;

    @AttributeOverrides(
            value = {
                    @AttributeOverride(name = "start_time", column = @Column(name = "start_time")),
                    @AttributeOverride(name = "end_time", column = @Column(name = "end_time"))
            }
    )
    private TimeInterval timeInterval;
}
