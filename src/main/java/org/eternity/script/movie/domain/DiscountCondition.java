package org.eternity.script.movie.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
@SequenceGenerator(
        name = "discount_seq_generator",        // Generator 이름 동일
        sequenceName = "discount_seq",          // DB 시퀀스 동일
        initialValue = 1,
        allocationSize = 50
)
public class DiscountCondition {
    public enum ConditionType {PERIOD_CONDITION, SEQUENCE_CONDITION}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq_generator")
    private Long id;

    private Long policyId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20)")
    private ConditionType conditionType;

    private Integer sequence;

    private PlayTime playTime;

    public DiscountCondition(Long policyId, ConditionType conditionType, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, Integer sequence) {
        this.policyId = policyId;
        this.conditionType = conditionType;
        this.playTime = new PlayTime(dayOfWeek, new TimeInterval(startTime, endTime));
        this.sequence = sequence;
    }

    public boolean isPeriodCondition() {
        return ConditionType.PERIOD_CONDITION.equals(conditionType);
    }

    public boolean isSequenceCondition() {
        return ConditionType.SEQUENCE_CONDITION.equals(conditionType);
    }
}
