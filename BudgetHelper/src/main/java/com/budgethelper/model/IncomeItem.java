package com.budgethelper.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "income_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class IncomeItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Fund fund;

	@Column(nullable = false)
	private Long amount;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_date", nullable = false)
	private LocalDateTime updatedDate;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IncomeItem)) {
			return false;
		}

		final IncomeItem incomeItem = (IncomeItem) o;

		if (this.id != null) {
			return this.id.equals(incomeItem.getId());
		}
		if (this.title != null ? !this.title.equals(incomeItem.getTitle()) : incomeItem.getTitle() != null) {
			return false;
		}
		if (this.fund != null ? !this.fund.equals(incomeItem.getFund()) : incomeItem.getFund() != null) {
			return false;
		}
		if (this.amount != null ? !this.amount.equals(incomeItem.getAmount()) : incomeItem.getAmount() != null) {
			return false;
		}
		return this.createdDate != null
			? this.createdDate.equals(incomeItem.getCreatedDate())
			: incomeItem.getCreatedDate() == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (this.title != null ? this.title.hashCode() : 0);
		result = 31 * result + (this.fund != null ? this.fund.hashCode() : 0);
		result = 31 * result + (this.amount != null ? this.amount.hashCode() : 0);
		result = 31 * result + (this.createdDate != null ? this.createdDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "IncomeItem{" +
			"id=" + this.id +
			", title='" + this.title + '\'' +
			", fund=" + this.fund +
			", amount=" + this.amount +
			", createdDate=" + this.createdDate +
			", updatedDate=" + this.updatedDate +
			'}';
	}
}
