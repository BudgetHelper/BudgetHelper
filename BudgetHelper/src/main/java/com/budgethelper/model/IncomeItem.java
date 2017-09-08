package com.budgethelper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by vyach on 08.09.2017.
 */
@Entity
@Table(name = "income_items")
public class IncomeItem {

	@Getter
	@Setter
	@Id
	private long id;

	@Getter
	@Setter
	@Column(nullable = false)
	private String title;

	@Getter
	@Setter
	@Column(name = "fund_id")
	@ManyToOne
	private Fund fund;

	@Getter
	@Setter
	@Column(nullable = false)
	private long amount;

	@Getter
	@Setter
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Getter
	@Setter
	@Column(name = "updated_date", nullable = false)
	private LocalDateTime updatedDate;
}
