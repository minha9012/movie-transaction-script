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
public class DiscountPolicy {
    public enum PolicyType {PERCENT_POLICY, AMOUNT_POLICY}

    @Id
    private Long id;
    private Long movieId;

    private PolicyType policyType;

    private Long amount;
    private Double percent;

    public DiscountPolicy(Long movieId, PolicyType policyType, Long amount, Double percent) {
        this.movieId = movieId;
        this.policyType = policyType;
        this.amount = amount;
        this.percent = percent;
    }

    public boolean isAmountPolicy() {
        return PolicyType.AMOUNT_POLICY.equals(policyType);
    }

    public boolean isPercentPolicy() {
        return PolicyType.PERCENT_POLICY.equals(policyType);
    }
}
