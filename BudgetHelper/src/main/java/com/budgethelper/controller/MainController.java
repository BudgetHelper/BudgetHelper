package com.budgethelper.controller;

import com.budgethelper.model.Category;
import com.budgethelper.model.ExpenseItem;
import com.budgethelper.model.Fund;
import com.budgethelper.model.Item;
import com.budgethelper.service.ExpenseItemService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public final class MainController {

    private final ExpenseItemService expenseItemService;

	public MainController(final ExpenseItemService expenseItemService) {
		this.expenseItemService = expenseItemService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
	    this.expenseItemService.save(createExpenseItem("Bananas", LocalDateTime.now()));
		return "/angular/index.html";
	}

	private ExpenseItem createExpenseItem(final String itemTitle, final LocalDateTime createdDate) {
		return new ExpenseItem(
			null,
			new Item(null, itemTitle, new Category(null, "Food")),
			new Category(null, "Food"),
			new Fund(null, "General", 10L, false, false, false, LocalDateTime.now(), LocalDateTime.now()),
			5L, false, null, createdDate, LocalDateTime.now()
		);
	}
}
