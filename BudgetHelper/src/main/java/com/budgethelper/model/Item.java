package com.budgethelper.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "category_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Category category;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Item)) {
			return false;
		}

		final Item item = (Item) o;

		if (this.id != null) {
			return this.id.equals(item.getId());
		}
		if (this.title != null ? !this.title.equals(item.getTitle()) : item.getTitle() != null) {
			return false;
		}
		return this.category != null ? this.category.equals(item.getCategory()) : item.getCategory() == null;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return this.id.hashCode();
		}
		int result = this.title != null ? this.title.hashCode() : 0;
		result = 31 * result + (this.category != null ? this.category.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Item{" +
			"id=" + this.id +
			", title='" + this.title + '\'' +
			", category=" + this.category +
			'}';
	}
}
