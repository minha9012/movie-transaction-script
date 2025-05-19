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
public class DiscountCondition {
    public enum ConditionType {PERIOD_CONDITION, SEQUENCE_CONDITION}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq_generator")
    @SequenceGenerator(
            name = "discount_seq_generator",        // Generator 이름 동일
            sequenceName = "discount_seq",          // DB 시퀀스 동일
            initialValue = 1,
            allocationSize = 50
    )
    private Long id;

    private Long policyId;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition_type", columnDefinition = "varchar(20)")
    private ConditionType conditionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", columnDefinition = "varchar(10)")
    private DayOfWeek dayOfWeek;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column
    private Integer sequence;

    public DiscountCondition(Long policyId, ConditionType conditionType, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, Integer sequence) {
        this.policyId = policyId;
        this.conditionType = conditionType;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sequence = sequence;
    }

    public boolean isPeriodCondition() {
        return ConditionType.PERIOD_CONDITION.equals(conditionType);
    }

    public boolean isSequenceCondition() {
        return ConditionType.SEQUENCE_CONDITION.equals(conditionType);
    }
}
