package com.budgethelper;

import com.budgethelper.configuration.DatabaseConfiguration;
import com.budgethelper.configuration.WebConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {WebConfiguration.class,
    DatabaseConfiguration.class})
@SuppressWarnings("squid:S2187")
public abstract class BaseTest {

    protected final SoftAssertions softAssertions = new SoftAssertions();
}
