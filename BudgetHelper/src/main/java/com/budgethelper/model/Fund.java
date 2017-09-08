package com.budgethelper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by vyach on 08.09.2017.
 */
@Entity
@Table(name = "funds")
public class Fund {

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
	@Column(nullable = false)
	private long amount;

	@Getter
	@Setter
	@Column
	private boolean isAccumulative;

	@Getter
	@Setter
	@Column
	private boolean isDeposit;

	@Getter
	@Setter
	@Column
	private boolean isCredit;

	@Getter
	@Setter
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Getter
	@Setter
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
}
