package com.example.leedstrinity.lab_4_week_6;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class registerTest {

    @Rule
    public ActivityScenarioRule<register> mActivityScenarioRule =
            new ActivityScenarioRule<>(register.class);

    @Test
    public void registerTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.register_email), withText("email"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("email")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.register_password), withText("password"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText2.check(matches(withText("password")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_phone), withText("Phone"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText3.check(matches(withText("Phone")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.fullName), withText("Full Name"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText4.check(matches(withText("Full Name")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.fullName), withText("Full Name"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText5.check(matches(withText("Full Name")));
    }
}
