package org.junit.internal.runners.model;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.MultipleFailureException;
public class EachTestNotifier {
    public final RunNotifier a;
    public final Description b;

    public EachTestNotifier(RunNotifier runNotifier, Description description) {
        this.a = runNotifier;
        this.b = description;
    }

    public void addFailedAssumption(AssumptionViolatedException assumptionViolatedException) {
        this.a.fireTestAssumptionFailed(new Failure(this.b, assumptionViolatedException));
    }

    public void addFailure(Throwable th) {
        if (th instanceof MultipleFailureException) {
            for (Throwable th2 : ((MultipleFailureException) th).getFailures()) {
                addFailure(th2);
            }
            return;
        }
        this.a.fireTestFailure(new Failure(this.b, th));
    }

    public void fireTestFinished() {
        this.a.fireTestFinished(this.b);
    }

    public void fireTestIgnored() {
        this.a.fireTestIgnored(this.b);
    }

    public void fireTestStarted() {
        this.a.fireTestStarted(this.b);
    }

    public void fireTestSuiteFinished() {
        this.a.fireTestSuiteFinished(this.b);
    }

    public void fireTestSuiteStarted() {
        this.a.fireTestSuiteStarted(this.b);
    }
}
