package org.junit.experimental.results;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
public class PrintableResult {
    public Result a;

    public PrintableResult(List<Failure> list) {
        Result result = new Result();
        RunListener createListener = result.createListener();
        for (Failure failure : list) {
            try {
                createListener.testFailure(failure);
            } catch (Exception unused) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        this.a = result;
    }

    public static PrintableResult testResult(Class<?> cls) {
        return testResult(Request.aClass(cls));
    }

    public int failureCount() {
        return this.a.getFailures().size();
    }

    public List<Failure> failures() {
        return this.a.getFailures();
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new TextListener(new PrintStream(byteArrayOutputStream)).testRunFinished(this.a);
        return byteArrayOutputStream.toString();
    }

    public static PrintableResult testResult(Request request) {
        return new PrintableResult(new JUnitCore().run(request));
    }

    public PrintableResult(Result result) {
        this.a = result;
    }
}
