package junit.extensions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
public class ActiveTestSuite extends TestSuite {
    public volatile int c;

    public class a extends Thread {
        public final /* synthetic */ Test a;
        public final /* synthetic */ TestResult b;

        public a(Test test, TestResult testResult) {
            this.a = test;
            this.b = testResult;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.a.run(this.b);
            } finally {
                ActiveTestSuite.this.runFinished();
            }
        }
    }

    public ActiveTestSuite() {
    }

    @Override // junit.framework.TestSuite, junit.framework.Test
    public void run(TestResult testResult) {
        this.c = 0;
        super.run(testResult);
        synchronized (this) {
            while (this.c < testCount()) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    public synchronized void runFinished() {
        this.c++;
        notifyAll();
    }

    @Override // junit.framework.TestSuite
    public void runTest(Test test, TestResult testResult) {
        new a(test, testResult).start();
    }

    public ActiveTestSuite(Class<? extends TestCase> cls) {
        super(cls);
    }

    public ActiveTestSuite(String str) {
        super(str);
    }

    public ActiveTestSuite(Class<? extends TestCase> cls, String str) {
        super(cls, str);
    }
}
