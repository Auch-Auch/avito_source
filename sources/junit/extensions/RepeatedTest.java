package junit.extensions;

import a2.b.a.a.a;
import junit.framework.Test;
import junit.framework.TestResult;
public class RepeatedTest extends TestDecorator {
    public int a;

    public RepeatedTest(Test test, int i) {
        super(test);
        if (i >= 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("Repetition count must be >= 0");
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public int countTestCases() {
        return super.countTestCases() * this.a;
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public void run(TestResult testResult) {
        for (int i = 0; i < this.a && !testResult.shouldStop(); i++) {
            super.run(testResult);
        }
    }

    @Override // junit.extensions.TestDecorator
    public String toString() {
        return a.t(new StringBuilder(), super.toString(), "(repeated)");
    }
}
