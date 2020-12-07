package com.example.hamcrest.HamcrestAssertions;


import com.example.hamcrest.HamcrestAssertions.domain.Customer;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@SpringBootTest
public class CollectionsTest {

    //Check if a customer list contains a member who doesn't updated his subscription details

    @Test
    public void shouldReturnTrue_whenCustomerHasNotUpdatedHisSubscriptionDetails() {
        List<Customer> customers =
                Arrays.asList(
                        new Customer(1, "Cristopher Columbus", true),
                        new Customer(2, "Amerigo Vespucci",true),
                        new Customer(3, "Bartolomeu Dias", false));

        assertThat(customers, Matchers.<Customer>hasItem(
                hasProperty("updated",
                is(equalTo(false)))));
    }

    @Test
    public void shouldCheckCollectionContent_whenAnItemIsPartOfACollection() {
        int[] values = new int[]{1, 2, 3};

        List<Integer> list = Arrays.asList(ArrayUtils.toObject(values));

        assertThat(list, Matchers.<Integer>hasItem(is(equalTo(1))));
        assertThat(list, Matchers.<Integer>hasItem(1));
    }

    @Test
    public void shouldCheckCollectionContent_whenSizeAndOrderDoesNotMatter() {
        int[] values = new int[]{1, 2, 3};

        List<Integer> list = Arrays.asList(ArrayUtils.toObject(values));

        assertThat(list, containsInAnyOrder(equalTo(3), equalTo(1), equalTo(2)));
    }

    @Test
    public void shouldCheckCollectionContent_whenSizeAndOrderMatters() {
        int[] values = new int[]{1, 2, 3};

        List<Integer> list = Arrays.asList(ArrayUtils.toObject(values));

        assertThat(list, contains(equalTo(1), equalTo(2), equalTo(3)));
        assertThat(list, contains(1,2,3));

    }

    @Test
    public void shouldCheckCollectionSize_whenCollectionIsNotEmpty() {
        int[] values = new int[]{1, 2, 3};

        List<Integer> list = Arrays.asList(ArrayUtils.toObject(values));

        assertThat(list, is(not(empty())));
        assertThat(list, is(not(emptyCollectionOf(Integer.class))));
    }

    @Test
    public void shouldReturnTrue_whenCollectionSizeIsTheExpectedOne() {
        int[] values = new int[]{1, 2, 3};

        List<Integer> list = Arrays.asList(ArrayUtils.toObject(values));

        assertThat(list, hasSize(3));
        assertThat(list, hasSize(is(equalTo(3))));

        assertThat(list, Matchers.<Integer>iterableWithSize(3));
        assertThat(list, Matchers.<Integer>iterableWithSize(is(3)));
        assertThat(list, Matchers.<Integer>iterableWithSize(is(equalTo(3))));
    }

}
