package org.junit.runner.notification;

import java.io.Serializable;
import org.junit.internal.Throwables;
import org.junit.runner.Description;
public class Failure implements Serializable {
    private static final long serialVersionUID = 1;
    public final Description a;
    public final Throwable b;

    public Failure(Description description, Throwable th) {
        this.b = th;
        this.a = description;
    }

    public Description getDescription() {
        return this.a;
    }

    public Throwable getException() {
        return this.b;
    }

    public String getMessage() {
        return getException().getMessage();
    }

    public String getTestHeader() {
        return this.a.getDisplayName();
    }

    public String getTrace() {
        return Throwables.getStacktrace(getException());
    }

    public String getTrimmedTrace() {
        return Throwables.getTrimmedStackTrace(getException());
    }

    @Override // java.lang.Object
    public String toString() {
        return getTestHeader() + ": " + this.b.getMessage();
    }
}
