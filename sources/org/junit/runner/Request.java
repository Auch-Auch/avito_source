package org.junit.runner;

import java.util.Comparator;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.requests.ClassRequest;
import org.junit.internal.requests.FilterRequest;
import org.junit.internal.requests.OrderingRequest;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Ordering;
import org.junit.runners.model.InitializationError;
public abstract class Request {

    public static class a extends Request {
        public final /* synthetic */ Runner a;

        public a(Runner runner) {
            this.a = runner;
        }

        @Override // org.junit.runner.Request
        public Runner getRunner() {
            return this.a;
        }
    }

    public static Request aClass(Class<?> cls) {
        return new ClassRequest(cls);
    }

    public static Request classWithoutSuiteMethod(Class<?> cls) {
        return new ClassRequest(cls, false);
    }

    public static Request classes(Computer computer, Class<?>... clsArr) {
        try {
            return runner(computer.getSuite(new AllDefaultPossibilitiesBuilder(), clsArr));
        } catch (InitializationError e) {
            return runner(new ErrorReportingRunner(e, clsArr));
        }
    }

    public static Request errorReport(Class<?> cls, Throwable th) {
        return runner(new ErrorReportingRunner(cls, th));
    }

    public static Request method(Class<?> cls, String str) {
        return aClass(cls).filterWith(Description.createTestDescription(cls, str));
    }

    public static Request runner(Runner runner) {
        return new a(runner);
    }

    public Request filterWith(Filter filter) {
        return new FilterRequest(this, filter);
    }

    public abstract Runner getRunner();

    public Request orderWith(Ordering ordering) {
        return new OrderingRequest(this, ordering);
    }

    public Request sortWith(Comparator<Description> comparator) {
        return new SortingRequest(this, comparator);
    }

    public Request filterWith(Description description) {
        return filterWith(Filter.matchMethodDescription(description));
    }

    public static Request classes(Class<?>... clsArr) {
        return classes(new Computer(), clsArr);
    }
}
