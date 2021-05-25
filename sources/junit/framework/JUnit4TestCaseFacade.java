package junit.framework;

import org.junit.runner.Describable;
import org.junit.runner.Description;
public class JUnit4TestCaseFacade implements Test, Describable {
    public final Description a;

    public JUnit4TestCaseFacade(Description description) {
        this.a = description;
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return 1;
    }

    @Override // org.junit.runner.Describable
    public Description getDescription() {
        return this.a;
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    public String toString() {
        return getDescription().toString();
    }
}
