package com.budgethelper.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funds")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Fund {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Long amount;

	@Column(name = "is_accumulative")
	private boolean isAccumulative;

	@Column(name = "is_deposit")
	private boolean isDeposit;

	@Column(name = "is_credit")
	private boolean isCredit;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
            return true;
        }
        if (!(o instanceof Fund)) {
            return false;
        }

        final Fund fund = (Fund) o;

		if (this.id != null) {
			return this.id.equals(fund.getId());
		}
		if (this.title != null ? !this.title.equals(fund.getTitle()) : fund.getTitle() != null) {
			return false;
		}
		if (this.amount != null ? !this.amount.equals(fund.getAmount()) : fund.getAmount() != null) {
			return false;
		}
		return this.createdDate != null ? this.createdDate.equals(fund.getCreatedDate()) : fund.getCreatedDate() == null;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return this.id.hashCode();
		}
		int result = this.title != null ? this.title.hashCode() : 0;
		result = 31 * result + (this.amount != null ? this.amount.hashCode() : 0);
		result = 31 * result + (this.createdDate != null ? this.createdDate.hashCode() : 0);
		return result;
	}

    @Override
    public String toString() {
        return "Fund{" +
            "id=" + this.id +
            ", title='" + this.title + '\'' +
            ", amount=" + this.amount +
            ", isAccumulative=" + this.isAccumulative +
            ", isDeposit=" + this.isDeposit +
            ", isCredit=" + this.isCredit +
            ", createdDate=" + this.createdDate +
            ", updatedDate=" + this.updatedDate +
            '}';
    }
}
