package com.budgethelper.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "regular_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class RegularItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Item item;

	@Column(nullable = false)
	private Long amount;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof RegularItem)) {
			return false;
		}

		final RegularItem regularItem = (RegularItem) o;

		if (this.id != null) {
			return this.id.equals(regularItem.getId());
		}
		if (this.item != null ? !this.item.equals(regularItem.getItem()) : regularItem.getItem() != null) {
			return false;
		}
		if (this.amount != null ? !this.amount.equals(regularItem.getAmount()) : regularItem.getAmount() != null) {
			return false;
		}
		return this.createdDate != null
			? this.createdDate.equals(regularItem.getCreatedDate())
			: regularItem.getCreatedDate() == null;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return this.id.hashCode();
		}
		int result = this.item != null ? this.item.hashCode() : 0;
		result = 31 * result + (this.amount != null ? this.amount.hashCode() : 0);
		result = 31 * result + (this.createdDate != null ? this.createdDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "RegularItem{" +
			"id=" + this.id +
			", item=" + this.item +
			", amount=" + this.amount +
			", createdDate=" + this.createdDate +
			", updatedDate=" + this.updatedDate +
			'}';
	}
}
