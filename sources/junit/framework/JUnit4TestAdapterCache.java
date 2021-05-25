package junit.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
public class JUnit4TestAdapterCache extends HashMap<Description, Test> {
    public static final JUnit4TestAdapterCache a = new JUnit4TestAdapterCache();
    private static final long serialVersionUID = 1;

    public class a extends RunListener {
        public final /* synthetic */ TestResult a;

        public a(TestResult testResult) {
            this.a = testResult;
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFailure(Failure failure) throws Exception {
            this.a.addError(JUnit4TestAdapterCache.this.asTest(failure.getDescription()), failure.getException());
        }

        @Override // org.junit.runner.notification.RunListener
        public void testFinished(Description description) throws Exception {
            this.a.endTest(JUnit4TestAdapterCache.this.asTest(description));
        }

        @Override // org.junit.runner.notification.RunListener
        public void testStarted(Description description) throws Exception {
            this.a.startTest(JUnit4TestAdapterCache.this.asTest(description));
        }
    }

    public static JUnit4TestAdapterCache getDefault() {
        return a;
    }

    public Test a(Description description) {
        if (description.isTest()) {
            return new JUnit4TestCaseFacade(description);
        }
        TestSuite testSuite = new TestSuite(description.getDisplayName());
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            testSuite.addTest(asTest(it.next()));
        }
        return testSuite;
    }

    public Test asTest(Description description) {
        if (description.isSuite()) {
            return a(description);
        }
        if (!containsKey(description)) {
            put(description, a(description));
        }
        return (Test) get(description);
    }

    public List<Test> asTestList(Description description) {
        if (description.isTest()) {
            return Arrays.asList(asTest(description));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(asTest(it.next()));
        }
        return arrayList;
    }

    public RunNotifier getNotifier(TestResult testResult, JUnit4TestAdapter jUnit4TestAdapter) {
        RunNotifier runNotifier = new RunNotifier();
        runNotifier.addListener(new a(testResult));
        return runNotifier;
    }
}
