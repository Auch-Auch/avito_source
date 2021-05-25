package x6.c.d.a;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
@RunListener.ThreadSafe
public final class b extends RunListener {
    public final RunListener a;
    public final Object b;

    public b(RunListener runListener, Object obj) {
        this.a = runListener;
        this.b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.a.equals(((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // org.junit.runner.notification.RunListener
    public void testAssumptionFailure(Failure failure) {
        synchronized (this.b) {
            this.a.testAssumptionFailure(failure);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) throws Exception {
        synchronized (this.b) {
            this.a.testFailure(failure);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) throws Exception {
        synchronized (this.b) {
            this.a.testFinished(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) throws Exception {
        synchronized (this.b) {
            this.a.testIgnored(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(Result result) throws Exception {
        synchronized (this.b) {
            this.a.testRunFinished(result);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunStarted(Description description) throws Exception {
        synchronized (this.b) {
            this.a.testRunStarted(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) throws Exception {
        synchronized (this.b) {
            this.a.testStarted(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testSuiteFinished(Description description) throws Exception {
        synchronized (this.b) {
            this.a.testSuiteFinished(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testSuiteStarted(Description description) throws Exception {
        synchronized (this.b) {
            this.a.testSuiteStarted(description);
        }
    }

    public String toString() {
        return this.a.toString() + " (with synchronization wrapper)";
    }
}
