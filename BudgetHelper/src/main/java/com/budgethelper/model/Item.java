package com.budgethelper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by vyach on 08.09.2017.
 */
@Entity
@Table(name = "items")
public class Item {

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
	@Column(name = "category_id")
	@ManyToOne
	private Category category;
}
