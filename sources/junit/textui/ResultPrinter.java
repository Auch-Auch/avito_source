package junit.textui;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.PublicConstantsKt;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;
public class ResultPrinter implements TestListener {
    public PrintStream a;
    public int b = 0;

    public ResultPrinter(PrintStream printStream) {
        this.a = printStream;
    }

    @Override // junit.framework.TestListener
    public void addError(Test test, Throwable th) {
        getWriter().print(ExifInterface.LONGITUDE_EAST);
    }

    @Override // junit.framework.TestListener
    public void addFailure(Test test, AssertionFailedError assertionFailedError) {
        getWriter().print("F");
    }

    public String elapsedTimeAsString(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    @Override // junit.framework.TestListener
    public void endTest(Test test) {
    }

    public PrintStream getWriter() {
        return this.a;
    }

    public void printDefect(TestFailure testFailure, int i) {
        printDefectHeader(testFailure, i);
        printDefectTrace(testFailure);
    }

    public void printDefectHeader(TestFailure testFailure, int i) {
        PrintStream writer = getWriter();
        writer.print(i + ") " + testFailure.failedTest());
    }

    public void printDefectTrace(TestFailure testFailure) {
        getWriter().print(BaseTestRunner.getFilteredTrace(testFailure.trace()));
    }

    public void printDefects(Enumeration<TestFailure> enumeration, int i, String str) {
        if (i != 0) {
            if (i == 1) {
                PrintStream writer = getWriter();
                writer.println("There was " + i + " " + str + ":");
            } else {
                PrintStream writer2 = getWriter();
                writer2.println("There were " + i + " " + str + "s:");
            }
            int i2 = 1;
            while (enumeration.hasMoreElements()) {
                printDefect(enumeration.nextElement(), i2);
                i2++;
            }
        }
    }

    public void printErrors(TestResult testResult) {
        printDefects(testResult.errors(), testResult.errorCount(), "error");
    }

    public void printFailures(TestResult testResult) {
        printDefects(testResult.failures(), testResult.failureCount(), PublicConstantsKt.FAILURE);
    }

    public void printFooter(TestResult testResult) {
        if (testResult.wasSuccessful()) {
            getWriter().println();
            getWriter().print("OK");
            PrintStream writer = getWriter();
            StringBuilder L = a.L(" (");
            L.append(testResult.runCount());
            L.append(" test");
            L.append(testResult.runCount() == 1 ? "" : "s");
            L.append(")");
            writer.println(L.toString());
        } else {
            getWriter().println();
            getWriter().println("FAILURES!!!");
            PrintStream writer2 = getWriter();
            StringBuilder L2 = a.L("Tests run: ");
            L2.append(testResult.runCount());
            L2.append(",  Failures: ");
            L2.append(testResult.failureCount());
            L2.append(",  Errors: ");
            L2.append(testResult.errorCount());
            writer2.println(L2.toString());
        }
        getWriter().println();
    }

    public void printHeader(long j) {
        getWriter().println();
        PrintStream writer = getWriter();
        StringBuilder L = a.L("Time: ");
        L.append(elapsedTimeAsString(j));
        writer.println(L.toString());
    }

    @Override // junit.framework.TestListener
    public void startTest(Test test) {
        getWriter().print(".");
        int i = this.b;
        this.b = i + 1;
        if (i >= 40) {
            getWriter().println();
            this.b = 0;
        }
    }
}
