package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class Timeout implements TestRule {
    public final long a;
    public final TimeUnit b;
    public final boolean c;

    public static class Builder {
        public boolean a = false;
        public long b = 0;
        public TimeUnit c = TimeUnit.SECONDS;

        public Timeout build() {
            return new Timeout(this);
        }

        public boolean getLookingForStuckThread() {
            return this.a;
        }

        public TimeUnit getTimeUnit() {
            return this.c;
        }

        public long getTimeout() {
            return this.b;
        }

        public Builder withLookingForStuckThread(boolean z) {
            this.a = z;
            return this;
        }

        public Builder withTimeout(long j, TimeUnit timeUnit) {
            this.b = j;
            this.c = timeUnit;
            return this;
        }
    }

    public class a extends Statement {
        public final /* synthetic */ Exception a;

        public a(Timeout timeout, Exception exc) {
            this.a = exc;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            throw new RuntimeException("Invalid parameters for Timeout", this.a);
        }
    }

    @Deprecated
    public Timeout(int i) {
        this((long) i, TimeUnit.MILLISECONDS);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Timeout millis(long j) {
        return new Timeout(j, TimeUnit.MILLISECONDS);
    }

    public static Timeout seconds(long j) {
        return new Timeout(j, TimeUnit.SECONDS);
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        try {
            return createFailOnTimeoutStatement(statement);
        } catch (Exception e) {
            return new a(this, e);
        }
    }

    public Statement createFailOnTimeoutStatement(Statement statement) throws Exception {
        return FailOnTimeout.builder().withTimeout(this.a, this.b).withLookingForStuckThread(this.c).build(statement);
    }

    public final boolean getLookingForStuckThread() {
        return this.c;
    }

    public final long getTimeout(TimeUnit timeUnit) {
        return timeUnit.convert(this.a, this.b);
    }

    public Timeout(long j, TimeUnit timeUnit) {
        this.a = j;
        this.b = timeUnit;
        this.c = false;
    }

    public Timeout(Builder builder) {
        this.a = builder.getTimeout();
        this.b = builder.getTimeUnit();
        this.c = builder.getLookingForStuckThread();
    }
}
