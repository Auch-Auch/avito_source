package org.junit.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
public final class Throwables {
    public static final Method a;
    public static final String[] b = {"org.junit.runner.", "org.junit.runners.", "org.junit.experimental.runners.", "org.junit.internal.", "junit."};
    public static final String[] c = {"org.junit.internal.StackTracesTest"};
    public static final String[] d = {"sun.reflect.", "java.lang.reflect.", "jdk.internal.reflect.", "org.junit.rules.RunRules.<init>(", "org.junit.rules.RunRules.applyAll(", "org.junit.runners.RuleContainer.apply(", "junit.framework.TestCase.runBare("};

    public enum a {
        PROCESSING_OTHER_CODE {
            @Override // org.junit.internal.Throwables.a
            public a a(String str) {
                return Throwables.a(str) ? a.PROCESSING_TEST_FRAMEWORK_CODE : this;
            }
        },
        PROCESSING_TEST_FRAMEWORK_CODE {
            @Override // org.junit.internal.Throwables.a
            public a a(String str) {
                if (Throwables.c(str, Throwables.d)) {
                    return a.PROCESSING_REFLECTION_CODE;
                }
                if (Throwables.a(str)) {
                    return this;
                }
                return a.PROCESSING_OTHER_CODE;
            }
        },
        PROCESSING_REFLECTION_CODE {
            @Override // org.junit.internal.Throwables.a
            public a a(String str) {
                if (Throwables.c(str, Throwables.d)) {
                    return this;
                }
                if (Throwables.a(str)) {
                    return a.PROCESSING_TEST_FRAMEWORK_CODE;
                }
                return a.DONE;
            }
        },
        DONE {
            @Override // org.junit.internal.Throwables.a
            public a a(String str) {
                return this;
            }
        };

        /* access modifiers changed from: public */
        a(x6.c.b.b bVar) {
        }

        public abstract a a(String str);
    }

    static {
        Method method;
        try {
            method = Throwable.class.getMethod("getSuppressed", new Class[0]);
        } catch (Throwable unused) {
            method = null;
        }
        a = method;
    }

    public static boolean a(String str) {
        return c(str, b) && !c(str, c);
    }

    public static void b(List<String> list, StringBuilder sb) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(String.format("%s%n", it.next()));
        }
    }

    public static boolean c(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String getStacktrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0148 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ef, code lost:
        if (r5 == false) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0123 A[Catch:{ IOException -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0144 A[EDGE_INSN: B:47:0x0144->B:40:0x0144 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getTrimmedStackTrace(java.lang.Throwable r8) {
        /*
        // Method dump skipped, instructions count: 336
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.internal.Throwables.getTrimmedStackTrace(java.lang.Throwable):java.lang.String");
    }

    public static Exception rethrowAsException(Throwable th) throws Exception {
        throw th;
    }
}
