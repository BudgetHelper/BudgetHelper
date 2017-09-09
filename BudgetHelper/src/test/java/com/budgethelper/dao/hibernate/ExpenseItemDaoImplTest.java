package com.budgethelper.dao.hibernate;

import com.budgethelper.BaseTest;
import com.budgethelper.model.Category;
import com.budgethelper.model.ExpenseItem;
import com.budgethelper.model.Fund;
import com.budgethelper.model.Item;
import com.budgethelper.service.ExpenseItemService;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class ExpenseItemDaoImplTest extends BaseTest{

    @Autowired
    private ExpenseItemService expenseItemService;

    @Test // todo remove this test, it's trial test
    public void givenExpenseItemsList_whenGetByDatesRange_thenReturnItemsCreateInGivenDatesRange() {
        this.expenseItemService.save(createExpenseItem("Bananas", LocalDateTime.now().minusDays(5)));
        this.expenseItemService.save(createExpenseItem("Potato", LocalDateTime.now().minusDays(3)));
        this.expenseItemService.save(createExpenseItem("Tomato", LocalDateTime.now().minusDays(1)));
        this.expenseItemService.save(createExpenseItem("Cucumber", LocalDateTime.now().minusDays(3)));

        final List<ExpenseItem> itemsDate = this.expenseItemService.getByDatePeriod(LocalDateTime.now().minusDays(5),
            LocalDateTime.now());

        this.softAssertions.assertThat(itemsDate).isNotEmpty();
        this.softAssertions.assertThat(itemsDate.size()).isEqualTo(4);
        this.softAssertions.assertThat(itemsDate.contains("Bananas"));
        this.softAssertions.assertThat(itemsDate.contains("Potato"));
        this.softAssertions.assertThat(itemsDate.contains("Tomato"));
        this.softAssertions.assertThat(itemsDate.contains("Cucumber"));
        this.softAssertions.assertAll();
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