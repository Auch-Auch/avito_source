package org.junit.rules;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class Stopwatch implements TestRule {
    public final b a = new b();
    public volatile long b;
    public volatile long c;

    public static class b {
    }

    public class c extends TestWatcher {
        public c(a aVar) {
        }

        @Override // org.junit.rules.TestWatcher
        public void failed(Throwable th, Description description) {
            Stopwatch.a(Stopwatch.this);
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.failed(stopwatch.b(), th, description);
        }

        @Override // org.junit.rules.TestWatcher
        public void finished(Description description) {
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.finished(stopwatch.b(), description);
        }

        @Override // org.junit.rules.TestWatcher
        public void skipped(AssumptionViolatedException assumptionViolatedException, Description description) {
            Stopwatch.a(Stopwatch.this);
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.skipped(stopwatch.b(), assumptionViolatedException, description);
        }

        @Override // org.junit.rules.TestWatcher
        public void starting(Description description) {
            Stopwatch stopwatch = Stopwatch.this;
            Objects.requireNonNull(stopwatch.a);
            stopwatch.b = System.nanoTime();
            stopwatch.c = 0;
        }

        @Override // org.junit.rules.TestWatcher
        public void succeeded(Description description) {
            Stopwatch.a(Stopwatch.this);
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.succeeded(stopwatch.b(), description);
        }
    }

    public static void a(Stopwatch stopwatch) {
        Objects.requireNonNull(stopwatch.a);
        stopwatch.c = System.nanoTime();
    }

    @Override // org.junit.rules.TestRule
    public final Statement apply(Statement statement, Description description) {
        return new c(null).apply(statement, description);
    }

    public final long b() {
        if (this.b != 0) {
            long j = this.c;
            if (j == 0) {
                Objects.requireNonNull(this.a);
                j = System.nanoTime();
            }
            return j - this.b;
        }
        throw new IllegalStateException("Test has not started");
    }

    public void failed(long j, Throwable th, Description description) {
    }

    public void finished(long j, Description description) {
    }

    public long runtime(TimeUnit timeUnit) {
        return timeUnit.convert(b(), TimeUnit.NANOSECONDS);
    }

    public void skipped(long j, AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    public void succeeded(long j, Description description) {
    }
}
