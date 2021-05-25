package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
public class TestResult {
    public boolean a = false;
    public List<TestFailure> fErrors = new ArrayList();
    public List<TestFailure> fFailures = new ArrayList();
    public List<TestListener> fListeners = new ArrayList();
    public int fRunTests = 0;

    public class a implements Protectable {
        public final /* synthetic */ TestCase a;

        public a(TestResult testResult, TestCase testCase) {
            this.a = testCase;
        }

        @Override // junit.framework.Protectable
        public void protect() throws Throwable {
            this.a.runBare();
        }
    }

    public final synchronized List<TestListener> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.fListeners);
        return arrayList;
    }

    public synchronized void addError(Test test, Throwable th) {
        this.fErrors.add(new TestFailure(test, th));
        Iterator it = ((ArrayList) a()).iterator();
        while (it.hasNext()) {
            ((TestListener) it.next()).addError(test, th);
        }
    }

    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        this.fFailures.add(new TestFailure(test, assertionFailedError));
        Iterator it = ((ArrayList) a()).iterator();
        while (it.hasNext()) {
            ((TestListener) it.next()).addFailure(test, assertionFailedError);
        }
    }

    public synchronized void addListener(TestListener testListener) {
        this.fListeners.add(testListener);
    }

    public void endTest(Test test) {
        Iterator it = ((ArrayList) a()).iterator();
        while (it.hasNext()) {
            ((TestListener) it.next()).endTest(test);
        }
    }

    public synchronized int errorCount() {
        return this.fErrors.size();
    }

    public synchronized Enumeration<TestFailure> errors() {
        return Collections.enumeration(this.fErrors);
    }

    public synchronized int failureCount() {
        return this.fFailures.size();
    }

    public synchronized Enumeration<TestFailure> failures() {
        return Collections.enumeration(this.fFailures);
    }

    public synchronized void removeListener(TestListener testListener) {
        this.fListeners.remove(testListener);
    }

    public void run(TestCase testCase) {
        startTest(testCase);
        runProtected(testCase, new a(this, testCase));
        endTest(testCase);
    }

    public synchronized int runCount() {
        return this.fRunTests;
    }

    public void runProtected(Test test, Protectable protectable) {
        try {
            protectable.protect();
        } catch (AssertionFailedError e) {
            addFailure(test, e);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable th) {
            addError(test, th);
        }
    }

    public synchronized boolean shouldStop() {
        return this.a;
    }

    public void startTest(Test test) {
        int countTestCases = test.countTestCases();
        synchronized (this) {
            this.fRunTests += countTestCases;
        }
        Iterator it = ((ArrayList) a()).iterator();
        while (it.hasNext()) {
            ((TestListener) it.next()).startTest(test);
        }
    }

    public synchronized void stop() {
        this.a = true;
    }

    public synchronized boolean wasSuccessful() {
        return failureCount() == 0 && errorCount() == 0;
    }
}
