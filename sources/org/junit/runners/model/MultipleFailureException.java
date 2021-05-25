package org.junit.runners.model;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.TestCouldNotBeSkippedException;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.Throwables;
public class MultipleFailureException extends Exception {
    private static final long serialVersionUID = 1;
    public final List<Throwable> a;

    public MultipleFailureException(List<Throwable> list) {
        if (!list.isEmpty()) {
            this.a = new ArrayList(list.size());
            for (Throwable th : list) {
                if (th instanceof AssumptionViolatedException) {
                    th = new TestCouldNotBeSkippedException((AssumptionViolatedException) th);
                }
                this.a.add(th);
            }
            return;
        }
        throw new IllegalArgumentException("List of Throwables must not be empty");
    }

    public static void assertEmpty(List<Throwable> list) throws Exception {
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                throw Throwables.rethrowAsException(list.get(0));
            }
            throw new org.junit.internal.runners.model.MultipleFailureException(list);
        }
    }

    public List<Throwable> getFailures() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(String.format("There were %d errors:", Integer.valueOf(this.a.size())));
        for (Throwable th : this.a) {
            sb.append(String.format("%n  %s(%s)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        for (Throwable th : this.a) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        for (Throwable th : this.a) {
            th.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        for (Throwable th : this.a) {
            th.printStackTrace(printWriter);
        }
    }
}
