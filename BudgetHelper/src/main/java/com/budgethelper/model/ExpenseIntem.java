package com.budgethelper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by vyach on 08.09.2017.
 */
@Entity
@Table(name = "expense_items")
public class ExpenseIntem {

	@Getter
	@Setter
	@Id
	private long id;

	@Getter
	@Setter
	@Column(name = "item_id")
	@ManyToOne
	private Item item;

	@Getter
	@Setter
	@Column(name = "category_id")
	@ManyToOne
	private Category category;

	@Getter
	@Setter
	@Column(name = "fund_id", nullable = false)
	@ManyToOne
	private Fund fund;

	@Getter
	@Setter
	@Column(nullable = false)
	private long price;

	@Getter
	@Setter
	@Column(name = "is_regular")
	private boolean isRegular;

	@Getter
	@Setter
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Getter
	@Setter
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
}
