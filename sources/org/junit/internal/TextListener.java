package org.junit.internal;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
public class TextListener extends RunListener {
    public final PrintStream a;

    public TextListener(JUnitSystem jUnitSystem) {
        this(jUnitSystem.out());
    }

    public String elapsedTimeAsString(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    public void printFailure(Failure failure, String str) {
        PrintStream printStream = this.a;
        StringBuilder Q = a.Q(str, ") ");
        Q.append(failure.getTestHeader());
        printStream.println(Q.toString());
        this.a.print(failure.getTrimmedTrace());
    }

    public void printFailures(Result result) {
        List<Failure> failures = result.getFailures();
        if (!failures.isEmpty()) {
            int i = 1;
            if (failures.size() == 1) {
                PrintStream printStream = this.a;
                StringBuilder L = a.L("There was ");
                L.append(failures.size());
                L.append(" failure:");
                printStream.println(L.toString());
            } else {
                PrintStream printStream2 = this.a;
                StringBuilder L2 = a.L("There were ");
                L2.append(failures.size());
                L2.append(" failures:");
                printStream2.println(L2.toString());
            }
            for (Failure failure : failures) {
                StringBuilder L3 = a.L("");
                L3.append(i);
                printFailure(failure, L3.toString());
                i++;
            }
        }
    }

    public void printFooter(Result result) {
        if (result.wasSuccessful()) {
            this.a.println();
            this.a.print("OK");
            PrintStream printStream = this.a;
            StringBuilder L = a.L(" (");
            L.append(result.getRunCount());
            L.append(" test");
            L.append(result.getRunCount() == 1 ? "" : "s");
            L.append(")");
            printStream.println(L.toString());
        } else {
            this.a.println();
            this.a.println("FAILURES!!!");
            PrintStream printStream2 = this.a;
            StringBuilder L2 = a.L("Tests run: ");
            L2.append(result.getRunCount());
            L2.append(",  Failures: ");
            L2.append(result.getFailureCount());
            printStream2.println(L2.toString());
        }
        this.a.println();
    }

    public void printHeader(long j) {
        this.a.println();
        PrintStream printStream = this.a;
        StringBuilder L = a.L("Time: ");
        L.append(elapsedTimeAsString(j));
        printStream.println(L.toString());
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) {
        this.a.append('E');
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) {
        this.a.append('I');
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(Result result) {
        printHeader(result.getRunTime());
        printFailures(result);
        printFooter(result);
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) {
        this.a.append(FormatterType.defaultDecimalSeparator);
    }

    public TextListener(PrintStream printStream) {
        this.a = printStream;
    }
}
