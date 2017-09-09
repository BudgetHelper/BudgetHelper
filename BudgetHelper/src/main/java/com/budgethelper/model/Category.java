package com.budgethelper.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Category)) {
			return false;
		}

		final Category category = (Category) o;

		if (this.id != null) {
			return this.id.equals(category.getId());
		}
		return this.title != null ? this.title.equals(category.title) : category.title == null;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return this.id.hashCode();
		}
		return this.title.hashCode();
	}

	@Override
	public String toString() {
		return "Category{" +
			"id=" + this.id +
			", title='" + this.title + '\'' +
			'}';
	}
}
