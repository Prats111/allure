package com.example.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    @Description("This is a sample test to demonstrate Allure reporting")
    @Severity(SeverityLevel.NORMAL)
    public void sampleTestMethod() {
        System.out.println("Running sample test...");
        assert true;
    }
}