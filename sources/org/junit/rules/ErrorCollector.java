package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.MultipleFailureException;
public class ErrorCollector extends Verifier {
    public List<Throwable> a = new ArrayList();

    public class a implements Callable<Object> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Matcher c;

        public a(ErrorCollector errorCollector, String str, Object obj, Matcher matcher) {
            this.a = str;
            this.b = obj;
            this.c = matcher;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            Assert.assertThat(this.a, this.b, this.c);
            return this.b;
        }
    }

    public void addError(Throwable th) {
        Objects.requireNonNull(th, "Error cannot be null");
        if (th instanceof AssumptionViolatedException) {
            AssertionError assertionError = new AssertionError(th.getMessage());
            assertionError.initCause(th);
            this.a.add(assertionError);
            return;
        }
        this.a.add(th);
    }

    public <T> T checkSucceeds(Callable<T> callable) {
        try {
            return callable.call();
        } catch (AssumptionViolatedException e) {
            AssertionError assertionError = new AssertionError("Callable threw AssumptionViolatedException");
            assertionError.initCause(e);
            addError(assertionError);
            return null;
        } catch (Throwable th) {
            addError(th);
            return null;
        }
    }

    public <T> void checkThat(T t, Matcher<T> matcher) {
        checkThat("", t, matcher);
    }

    public void checkThrows(Class<? extends Throwable> cls, ThrowingRunnable throwingRunnable) {
        try {
            Assert.assertThrows(cls, throwingRunnable);
        } catch (AssertionError e) {
            addError(e);
        }
    }

    @Override // org.junit.rules.Verifier
    public void verify() throws Throwable {
        MultipleFailureException.assertEmpty(this.a);
    }

    public <T> void checkThat(String str, T t, Matcher<T> matcher) {
        checkSucceeds(new a(this, str, t, matcher));
    }
}
