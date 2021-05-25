package org.junit.internal.requests;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Sorter;
public class SortingRequest extends Request {
    public final Request a;
    public final Comparator<Description> b;

    public SortingRequest(Request request, Comparator<Description> comparator) {
        this.a = request;
        this.b = comparator;
    }

    @Override // org.junit.runner.Request
    public Runner getRunner() {
        Runner runner = this.a.getRunner();
        new Sorter(this.b).apply(runner);
        return runner;
    }
}
