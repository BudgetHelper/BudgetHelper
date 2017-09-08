package com.budgethelper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by vyach on 08.09.2017.
 */
@Entity
@Table(name = "regular_items")
public class RegularItem {

	@Getter
	@Setter
	@Id
	private long id;

	@Getter
	@Setter
	@Column(name = "item_id", nullable = false)
	@ManyToOne
	private Item item;

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
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
}
