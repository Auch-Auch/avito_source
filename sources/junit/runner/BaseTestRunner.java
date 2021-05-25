package junit.runner;

import a2.b.a.a.a;
import com.facebook.internal.ServerProtocol;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;
import org.junit.internal.Throwables;
public abstract class BaseTestRunner implements TestListener {
    public static final String SUITE_METHODNAME = "suite";
    public static Properties b = null;
    public static int c = getPreference("maxmessage", 500);
    public static boolean d = true;
    public boolean a = true;

    public static File a() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    public static String getFilteredTrace(Throwable th) {
        return getFilteredTrace(Throwables.getStacktrace(th));
    }

    public static String getPreference(String str) {
        return getPreferences().getProperty(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r0 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (r0 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        r0.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046 A[SYNTHETIC, Splitter:B:17:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Properties getPreferences() {
        /*
            java.util.Properties r0 = junit.runner.BaseTestRunner.b
            if (r0 != 0) goto L_0x0054
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            junit.runner.BaseTestRunner.b = r0
            java.lang.String r1 = "loading"
            java.lang.String r2 = "true"
            r0.put(r1, r2)
            java.util.Properties r0 = junit.runner.BaseTestRunner.b
            java.lang.String r1 = "filterstack"
            r0.put(r1, r2)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004a, all -> 0x0043 }
            java.io.File r2 = a()     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004a, all -> 0x0043 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004a, all -> 0x0043 }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ IOException -> 0x0041, SecurityException -> 0x003f, all -> 0x003a }
            java.util.Properties r2 = getPreferences()     // Catch:{ IOException -> 0x0041, SecurityException -> 0x003f, all -> 0x003a }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0041, SecurityException -> 0x003f, all -> 0x003a }
            setPreferences(r0)     // Catch:{ IOException -> 0x0041, SecurityException -> 0x003f, all -> 0x003a }
            java.util.Properties r0 = getPreferences()     // Catch:{ IOException -> 0x0041, SecurityException -> 0x003f, all -> 0x003a }
            r0.load(r1)     // Catch:{ IOException -> 0x0041, SecurityException -> 0x003f, all -> 0x003a }
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0054
        L_0x003a:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0044
        L_0x003f:
            r0 = r1
            goto L_0x004b
        L_0x0041:
            r0 = r1
            goto L_0x004f
        L_0x0043:
            r1 = move-exception
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            throw r1
        L_0x004a:
        L_0x004b:
            if (r0 == 0) goto L_0x0054
            goto L_0x0051
        L_0x004e:
        L_0x004f:
            if (r0 == 0) goto L_0x0054
        L_0x0051:
            r0.close()
        L_0x0054:
            java.util.Properties r0 = junit.runner.BaseTestRunner.b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: junit.runner.BaseTestRunner.getPreferences():java.util.Properties");
    }

    public static void savePreferences() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(System.getProperty("user.home"), "junit.properties"));
        try {
            getPreferences().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    public static void setPreference(String str, String str2) {
        getPreferences().put(str, str2);
    }

    public static void setPreferences(Properties properties) {
        b = properties;
    }

    public static boolean showStackRaw() {
        return !getPreference("filterstack").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || !d;
    }

    public static String truncate(String str) {
        if (c == -1 || str.length() <= c) {
            return str;
        }
        return str.substring(0, c) + "...";
    }

    @Override // junit.framework.TestListener
    public synchronized void addError(Test test, Throwable th) {
        testFailed(1, test, th);
    }

    @Override // junit.framework.TestListener
    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        testFailed(2, test, assertionFailedError);
    }

    public void clearStatus() {
    }

    public String elapsedTimeAsString(long j) {
        return NumberFormat.getInstance().format(((double) j) / 1000.0d);
    }

    @Override // junit.framework.TestListener
    public synchronized void endTest(Test test) {
        testEnded(test.toString());
    }

    public String extractClassName(String str) {
        return str.startsWith("Default package for") ? str.substring(str.lastIndexOf(".") + 1) : str;
    }

    public Test getTest(String str) {
        Class cls;
        if (str.length() <= 0) {
            clearStatus();
            return null;
        }
        try {
            try {
                Method method = loadSuiteClass(str).getMethod(SUITE_METHODNAME, new Class[0]);
                if (!Modifier.isStatic(method.getModifiers())) {
                    runFailed("Suite() method must be static");
                    return null;
                }
                try {
                    Test test = (Test) method.invoke(null, new Object[0]);
                    if (test == null) {
                        return test;
                    }
                    clearStatus();
                    return test;
                } catch (InvocationTargetException e) {
                    StringBuilder L = a.L("Failed to invoke suite():");
                    L.append(e.getTargetException().toString());
                    runFailed(L.toString());
                    return null;
                } catch (IllegalAccessException e2) {
                    StringBuilder L2 = a.L("Failed to invoke suite():");
                    L2.append(e2.toString());
                    runFailed(L2.toString());
                    return null;
                }
            } catch (Exception unused) {
                clearStatus();
                return new TestSuite(cls);
            }
        } catch (ClassNotFoundException e3) {
            String message = e3.getMessage();
            if (message != null) {
                str = message;
            }
            runFailed("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e4) {
            StringBuilder L3 = a.L("Error: ");
            L3.append(e4.toString());
            runFailed(L3.toString());
            return null;
        }
    }

    public Class<?> loadSuiteClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public String processArguments(String[] strArr) {
        String str = null;
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].equals("-noloading")) {
                setLoading(false);
            } else if (strArr[i].equals("-nofilterstack")) {
                d = false;
            } else if (strArr[i].equals("-c")) {
                i++;
                if (strArr.length > i) {
                    str = extractClassName(strArr[i]);
                } else {
                    System.out.println("Missing Test class name");
                }
            } else {
                str = strArr[i];
            }
            i++;
        }
        return str;
    }

    public abstract void runFailed(String str);

    public void setLoading(boolean z) {
        this.a = z;
    }

    @Override // junit.framework.TestListener
    public synchronized void startTest(Test test) {
        testStarted(test.toString());
    }

    public abstract void testEnded(String str);

    public abstract void testFailed(int i, Test test, Throwable th);

    public abstract void testStarted(String str);

    public boolean useReloadingTestSuiteLoader() {
        return getPreference("loading").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) && this.a;
    }

    public static String getFilteredTrace(String str) {
        if (showStackRaw()) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringWriter.toString();
                }
                String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= 8) {
                        break;
                    } else if (readLine.indexOf(strArr[i]) > 0) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    printWriter.println(readLine);
                }
            } catch (Exception unused) {
                return str;
            }
        }
    }

    public static int getPreference(String str, int i) {
        String preference = getPreference(str);
        if (preference == null) {
            return i;
        }
        try {
            return Integer.parseInt(preference);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
