package com.budgethelper.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "expense_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class ExpenseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Item item;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Category category;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Fund fund;

	@Column(nullable = false)
	private Long price;

	@Column(name = "is_regular")
	private boolean isRegular;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(
		name = "expense_item_tag_map",
		joinColumns = @JoinColumn(name = "expense_item_id", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
	)
	private List<Tag> tag;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ExpenseItem)) {
			return false;
		}

		final ExpenseItem exItem = (ExpenseItem) o;

		if (id != null) {
			return this.id.equals(exItem.getId());
		}
		if (this.item != null ? !this.item.equals(exItem.getItem()) : exItem.getItem() != null) {
			return false;
		}
		if (this.category != null ? !this.category.equals(exItem.getCategory()) : exItem.getCategory() != null) {
			return false;
		}
		if (this.fund != null ? !this.fund.equals(exItem.getFund()) : exItem.getFund() != null) {
			return false;
		}
		if (this.price != null ? !this.price.equals(exItem.getPrice()) : exItem.getPrice() != null) {
			return false;
		}
		return this.createdDate != null ? this.createdDate.equals(exItem.getCreatedDate()) : exItem.getCreatedDate() == null;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return this.id.hashCode();
		}
		int result = this.item != null ? this.item.hashCode() : 0;
		result = 31 * result + (this.category != null ? this.category.hashCode() : 0);
		result = 31 * result + (this.fund != null ? this.fund.hashCode() : 0);
		result = 31 * result + (this.price != null ? this.price.hashCode() : 0);
		result = 31 * result + (this.createdDate != null ? this.createdDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ExpenseItem{" +
			"id=" + this.id +
			", item=" + this.item +
			", category=" + this.category +
			", fund=" + this.fund +
			", price=" + this.price +
			", isRegular=" + this.isRegular +
			", createdDate=" + this.createdDate +
			", updatedDate=" + this.updatedDate +
			'}';
	}
}
