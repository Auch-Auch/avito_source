package org.junit.runner;

import junit.framework.Test;
import junit.runner.Version;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
public class JUnitCore {
    public final RunNotifier a = new RunNotifier();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b6, code lost:
        r8 = new java.lang.String[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String... r12) {
        /*
        // Method dump skipped, instructions count: 308
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runner.JUnitCore.main(java.lang.String[]):void");
    }

    public static Result runClasses(Computer computer, Class<?>... clsArr) {
        return new JUnitCore().run(computer, clsArr);
    }

    public void addListener(RunListener runListener) {
        this.a.addListener(runListener);
    }

    public String getVersion() {
        return Version.id();
    }

    public void removeListener(RunListener runListener) {
        this.a.removeListener(runListener);
    }

    public Result run(Computer computer, Class<?>... clsArr) {
        return run(Request.classes(computer, clsArr));
    }

    public static Result runClasses(Class<?>... clsArr) {
        return runClasses(new Computer(), clsArr);
    }

    public Result run(Request request) {
        return run(request.getRunner());
    }

    public Result run(Test test) {
        return run(new JUnit38ClassRunner(test));
    }

    public Result run(Runner runner) {
        Result result = new Result();
        RunListener createListener = result.createListener();
        this.a.addFirstListener(createListener);
        try {
            this.a.fireTestRunStarted(runner.getDescription());
            runner.run(this.a);
            this.a.fireTestRunFinished(result);
            return result;
        } finally {
            removeListener(createListener);
        }
    }

    public Result run(Class<?>... clsArr) {
        return run(new Computer(), clsArr);
    }
}
