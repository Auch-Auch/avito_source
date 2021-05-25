package org.junit.internal.requests;

import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.Ordering;
import x6.c.b.d.a;
public class OrderingRequest extends a {
    public final Request c;
    public final Ordering d;

    public OrderingRequest(Request request, Ordering ordering) {
        this.c = request;
        this.d = ordering;
    }

    @Override // x6.c.b.d.a
    public Runner createRunner() {
        Runner runner = this.c.getRunner();
        try {
            this.d.apply(runner);
            return runner;
        } catch (InvalidOrderingException e) {
            return new ErrorReportingRunner(this.d.getClass(), e);
        }
    }
}
