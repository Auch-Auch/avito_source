package junit.extensions;

import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestResult;
public class TestSetup extends TestDecorator {

    public class a implements Protectable {
        public final /* synthetic */ TestResult a;

        public a(TestResult testResult) {
            this.a = testResult;
        }

        @Override // junit.framework.Protectable
        public void protect() throws Exception {
            TestSetup.this.setUp();
            TestSetup.this.basicRun(this.a);
            TestSetup.this.tearDown();
        }
    }

    public TestSetup(Test test) {
        super(test);
    }

    @Override // junit.extensions.TestDecorator, junit.framework.Test
    public void run(TestResult testResult) {
        testResult.runProtected(this, new a(testResult));
    }

    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }
}
