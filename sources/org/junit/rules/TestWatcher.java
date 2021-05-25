package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
public abstract class TestWatcher implements TestRule {

    public class a extends Statement {
        public final /* synthetic */ Description a;
        public final /* synthetic */ Statement b;

        public a(Description description, Statement statement) {
            this.a = description;
            this.b = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            ArrayList arrayList = new ArrayList();
            TestWatcher testWatcher = TestWatcher.this;
            Description description = this.a;
            Objects.requireNonNull(testWatcher);
            try {
                testWatcher.starting(description);
            } catch (Throwable th) {
                arrayList.add(th);
            }
            try {
                this.b.evaluate();
                TestWatcher testWatcher2 = TestWatcher.this;
                Description description2 = this.a;
                Objects.requireNonNull(testWatcher2);
                try {
                    testWatcher2.succeeded(description2);
                } catch (Throwable th2) {
                    arrayList.add(th2);
                }
            } catch (AssumptionViolatedException e) {
                arrayList.add(e);
                TestWatcher testWatcher3 = TestWatcher.this;
                Description description3 = this.a;
                Objects.requireNonNull(testWatcher3);
                if (e instanceof org.junit.AssumptionViolatedException) {
                    testWatcher3.skipped((org.junit.AssumptionViolatedException) e, description3);
                } else {
                    testWatcher3.skipped(e, description3);
                }
            } catch (Throwable th3) {
                arrayList.add(th3);
            }
            TestWatcher.a(TestWatcher.this, this.a, arrayList);
            MultipleFailureException.assertEmpty(arrayList);
        }
    }

    public static void a(TestWatcher testWatcher, Description description, List list) {
        Objects.requireNonNull(testWatcher);
        try {
            testWatcher.finished(description);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new a(description, statement);
    }

    public void failed(Throwable th, Description description) {
    }

    public void finished(Description description) {
    }

    public void skipped(org.junit.AssumptionViolatedException assumptionViolatedException, Description description) {
        skipped((AssumptionViolatedException) assumptionViolatedException, description);
    }

    @Deprecated
    public void skipped(AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    public void starting(Description description) {
    }

    public void succeeded(Description description) {
    }
}
