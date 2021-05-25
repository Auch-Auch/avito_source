package junit.textui;

import a2.b.a.a.a;
import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.Version;
public class TestRunner extends BaseTestRunner {
    public static final int EXCEPTION_EXIT = 2;
    public static final int FAILURE_EXIT = 1;
    public static final int SUCCESS_EXIT = 0;
    public ResultPrinter e;

    public TestRunner() {
        this(System.out);
    }

    public static void main(String[] strArr) {
        try {
            if (!new TestRunner().start(strArr).wasSuccessful()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e2) {
            System.err.println(e2.getMessage());
            System.exit(2);
        }
    }

    public static void run(Class<? extends TestCase> cls) {
        run(new TestSuite(cls));
    }

    public static void runAndWait(Test test) {
        new TestRunner().doRun(test, true);
    }

    public TestResult createTestResult() {
        return new TestResult();
    }

    public TestResult doRun(Test test) {
        return doRun(test, false);
    }

    public void pause(boolean z) {
        if (z) {
            ResultPrinter resultPrinter = this.e;
            resultPrinter.getWriter().println();
            resultPrinter.getWriter().println("<RETURN> to continue");
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
    }

    @Override // junit.runner.BaseTestRunner
    public void runFailed(String str) {
        System.err.println(str);
        System.exit(1);
    }

    public TestResult runSingleMethod(String str, String str2, boolean z) throws Exception {
        return doRun(TestSuite.createTest(loadSuiteClass(str).asSubclass(TestCase.class), str2), z);
    }

    public void setPrinter(ResultPrinter resultPrinter) {
        this.e = resultPrinter;
    }

    public TestResult start(String[] strArr) throws Exception {
        int i = 0;
        boolean z = false;
        String str = "";
        String str2 = str;
        while (i < strArr.length) {
            if (strArr[i].equals("-wait")) {
                z = true;
            } else if (strArr[i].equals("-c")) {
                i++;
                str = extractClassName(strArr[i]);
            } else if (strArr[i].equals("-m")) {
                i++;
                String str3 = strArr[i];
                int lastIndexOf = str3.lastIndexOf(46);
                String substring = str3.substring(0, lastIndexOf);
                str2 = str3.substring(lastIndexOf + 1);
                str = substring;
            } else if (strArr[i].equals("-v")) {
                PrintStream printStream = System.err;
                StringBuilder L = a.L("JUnit ");
                L.append(Version.id());
                L.append(" by Kent Beck and Erich Gamma");
                printStream.println(L.toString());
            } else {
                str = strArr[i];
            }
            i++;
        }
        if (!str.equals("")) {
            try {
                if (!str2.equals("")) {
                    return runSingleMethod(str, str2, z);
                }
                return doRun(getTest(str), z);
            } catch (Exception e2) {
                throw new Exception(a.a3("Could not create and run test suite: ", e2));
            }
        } else {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
    }

    @Override // junit.runner.BaseTestRunner
    public void testEnded(String str) {
    }

    @Override // junit.runner.BaseTestRunner
    public void testFailed(int i, Test test, Throwable th) {
    }

    @Override // junit.runner.BaseTestRunner
    public void testStarted(String str) {
    }

    public TestRunner(PrintStream printStream) {
        this(new ResultPrinter(printStream));
    }

    public static TestResult run(Test test) {
        return new TestRunner().doRun(test);
    }

    public TestResult doRun(Test test, boolean z) {
        TestResult createTestResult = createTestResult();
        createTestResult.addListener(this.e);
        long currentTimeMillis = System.currentTimeMillis();
        test.run(createTestResult);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ResultPrinter resultPrinter = this.e;
        synchronized (resultPrinter) {
            resultPrinter.printHeader(currentTimeMillis2);
            resultPrinter.printErrors(createTestResult);
            resultPrinter.printFailures(createTestResult);
            resultPrinter.printFooter(createTestResult);
        }
        pause(z);
        return createTestResult;
    }

    public TestRunner(ResultPrinter resultPrinter) {
        this.e = resultPrinter;
    }
}
