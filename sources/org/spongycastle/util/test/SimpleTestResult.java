package org.spongycastle.util.test;

import a2.b.a.a.a;
import org.spongycastle.util.Strings;
public class SimpleTestResult implements TestResult {
    public static final String d = Strings.lineSeparator();
    public boolean a;
    public String b;
    public Throwable c;

    public SimpleTestResult(boolean z, String str) {
        this.a = z;
        this.b = str;
    }

    public static TestResult failed(Test test, String str) {
        return new SimpleTestResult(false, test.getName() + ": " + str);
    }

    public static String failedMessage(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(" failing ");
        stringBuffer.append(str2);
        String str5 = d;
        stringBuffer.append(str5);
        stringBuffer.append("    expected: ");
        stringBuffer.append(str3);
        stringBuffer.append(str5);
        stringBuffer.append("    got     : ");
        stringBuffer.append(str4);
        return stringBuffer.toString();
    }

    public static TestResult successful(Test test, String str) {
        return new SimpleTestResult(true, test.getName() + ": " + str);
    }

    @Override // org.spongycastle.util.test.TestResult
    public Throwable getException() {
        return this.c;
    }

    @Override // org.spongycastle.util.test.TestResult
    public boolean isSuccessful() {
        return this.a;
    }

    @Override // org.spongycastle.util.test.TestResult
    public String toString() {
        return this.b;
    }

    public static TestResult failed(Test test, String str, Throwable th) {
        return new SimpleTestResult(false, test.getName() + ": " + str, th);
    }

    public static TestResult failed(Test test, String str, Object obj, Object obj2) {
        StringBuilder L = a.L(str);
        String str2 = d;
        L.append(str2);
        L.append("Expected: ");
        L.append(obj);
        L.append(str2);
        L.append("Found   : ");
        L.append(obj2);
        return failed(test, L.toString());
    }

    public SimpleTestResult(boolean z, String str, Throwable th) {
        this.a = z;
        this.b = str;
        this.c = th;
    }
}
