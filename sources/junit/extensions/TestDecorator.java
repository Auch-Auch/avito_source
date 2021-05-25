package junit.extensions;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestResult;
public class TestDecorator extends Assert implements Test {
    public Test fTest;

    public TestDecorator(Test test) {
        this.fTest = test;
    }

    public void basicRun(TestResult testResult) {
        this.fTest.run(testResult);
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return this.fTest.countTestCases();
    }

    public Test getTest() {
        return this.fTest;
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        basicRun(testResult);
    }

    public String toString() {
        return this.fTest.toString();
    }
}
