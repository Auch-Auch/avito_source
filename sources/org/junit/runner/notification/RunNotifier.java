package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import x6.c.d.a.b;
public class RunNotifier {
    public final List<RunListener> a = new CopyOnWriteArrayList();
    public volatile boolean b = false;

    public abstract class a {
        public final List<RunListener> a;

        public a(List<RunListener> list) {
            this.a = list;
        }

        public abstract void a(RunListener runListener) throws Exception;

        public void b() {
            int size = this.a.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener runListener : this.a) {
                try {
                    a(runListener);
                    arrayList.add(runListener);
                } catch (Exception e) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
                }
            }
            RunNotifier runNotifier = RunNotifier.this;
            Objects.requireNonNull(runNotifier);
            if (!arrayList2.isEmpty()) {
                new x6.c.d.a.a(runNotifier, arrayList, arrayList2).b();
            }
        }
    }

    public RunListener a(RunListener runListener) {
        return runListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class) ? runListener : new b(runListener, this);
    }

    public void addFirstListener(RunListener runListener) {
        Objects.requireNonNull(runListener, "Cannot add a null listener");
        this.a.add(0, a(runListener));
    }

    public void addListener(RunListener runListener) {
        Objects.requireNonNull(runListener, "Cannot add a null listener");
        this.a.add(a(runListener));
    }

    public void fireTestAssumptionFailed(Failure failure) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testAssumptionFailure(failure);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void fireTestFailure(Failure failure) {
        List<RunListener> list = this.a;
        List<Failure> asList = Arrays.asList(failure);
        if (!asList.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener runListener : list) {
                try {
                    for (Failure failure2 : asList) {
                        runListener.testFailure(failure2);
                    }
                    arrayList.add(runListener);
                } catch (Exception e) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
                }
            }
            Objects.requireNonNull(this);
            if (!arrayList2.isEmpty()) {
                new x6.c.d.a.a(this, arrayList, arrayList2).b();
            }
        }
    }

    public void fireTestFinished(Description description) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testFinished(description);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void fireTestIgnored(Description description) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testIgnored(description);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void fireTestRunFinished(Result result) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testRunFinished(result);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void fireTestRunStarted(Description description) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testRunStarted(description);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void fireTestStarted(Description description) throws StoppedByUserException {
        if (!this.b) {
            List<RunListener> list = this.a;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener runListener : list) {
                try {
                    runListener.testStarted(description);
                    arrayList.add(runListener);
                } catch (Exception e) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
                }
            }
            Objects.requireNonNull(this);
            if (!arrayList2.isEmpty()) {
                new x6.c.d.a.a(this, arrayList, arrayList2).b();
                return;
            }
            return;
        }
        throw new StoppedByUserException();
    }

    public void fireTestSuiteFinished(Description description) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testSuiteFinished(description);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void fireTestSuiteStarted(Description description) {
        List<RunListener> list = this.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (RunListener runListener : list) {
            try {
                runListener.testSuiteStarted(description);
                arrayList.add(runListener);
            } catch (Exception e) {
                arrayList2.add(new Failure(Description.TEST_MECHANISM, e));
            }
        }
        Objects.requireNonNull(this);
        if (!arrayList2.isEmpty()) {
            new x6.c.d.a.a(this, arrayList, arrayList2).b();
        }
    }

    public void pleaseStop() {
        this.b = true;
    }

    public void removeListener(RunListener runListener) {
        Objects.requireNonNull(runListener, "Cannot remove a null listener");
        this.a.remove(a(runListener));
    }
}
