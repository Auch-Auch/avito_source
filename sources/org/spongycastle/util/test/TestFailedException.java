package org.spongycastle.util.test;
public class TestFailedException extends RuntimeException {
    public TestResult a;

    public TestFailedException(TestResult testResult) {
        this.a = testResult;
    }

    public TestResult getResult() {
        return this.a;
    }
}
