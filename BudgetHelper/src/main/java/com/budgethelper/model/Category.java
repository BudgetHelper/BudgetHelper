package com.budgethelper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vyach on 08.09.2017.
 */
@Entity
@Table(name = "item_categories")
public class Category {

	@Getter
	@Setter
	@Id
	private long id;

	@Getter
	@Setter
	@Column
	private String title;
}
