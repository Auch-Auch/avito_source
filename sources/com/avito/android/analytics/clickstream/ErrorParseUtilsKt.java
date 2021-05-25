package com.avito.android.analytics.clickstream;

import a2.a.a.i.d.e;
import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLinkKt;
import com.avito.android.remote.auth.AuthSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\r\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "", "parseErrorText", "(Ljava/lang/Throwable;)Ljava/lang/String;", "parseStackTrace", "throwable", "getActualThrowable", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "text", "appendAndTrim", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "size", "trimPayload", "(Ljava/lang/String;I)Ljava/lang/String;", "", "set", "La2/a/a/i/d/e;", AuthSource.SEND_ABUSE, "(Ljava/lang/Throwable;Ljava/util/Set;)La2/a/a/i/d/e;", "", "Ljava/lang/StackTraceElement;", AuthSource.BOOKING_ORDER, "([Ljava/lang/StackTraceElement;)Ljava/lang/StackTraceElement;", "analytics-clickstream_release"}, k = 2, mv = {1, 4, 2})
public final class ErrorParseUtilsKt {
    public static final e a(Throwable th, Set<Throwable> set) {
        e eVar;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        StackTraceElement b = b(stackTrace);
        if (b != null) {
            return new e(th, b);
        }
        Throwable cause = th.getCause();
        if (cause == null || set.contains(cause)) {
            eVar = null;
        } else {
            set.add(cause);
            eVar = a(cause, set);
        }
        StackTraceElement[] stackTrace2 = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace2, "stackTrace");
        if (!(stackTrace2.length == 0)) {
            stackTraceElement = th.getStackTrace()[0];
        } else {
            stackTraceElement = new StackTraceElement("", "", "", 0);
        }
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.checkNotNullExpressionValue(stackTraceElement, "topElement");
        return new e(th, stackTraceElement);
    }

    @NotNull
    public static final String appendAndTrim(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$appendAndTrim");
        if (str2 == null) {
            return trimPayload$default(str, 0, 1, null);
        }
        if (str2.length() + str.length() > 1000) {
            str = trimPayload(str, (1000 - Math.min(str2.length(), 100)) - 1);
        }
        return trimPayload$default(a.L2(str, ' ', str2), 0, 1, null);
    }

    public static /* synthetic */ String appendAndTrim$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        return appendAndTrim(str, str2);
    }

    public static final StackTraceElement b(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            if (!m.startsWith$default(className, "com.avito.android", false, 2, null)) {
                String className2 = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "it.className");
                if (!m.startsWith$default(className2, DeepLinkKt.DEEPLINK_URI_SCHEME, false, 2, null)) {
                }
            }
            return stackTraceElement;
        }
        return null;
    }

    @Nullable
    public static final Throwable getActualThrowable(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
        if (b(stackTrace) != null) {
            return th;
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return null;
        }
        return getActualThrowable(cause);
    }

    @NotNull
    public static final String parseErrorText(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$parseErrorText");
        e a = a(th, y.mutableSetOf(th));
        Throwable th2 = a.a;
        StackTraceElement stackTraceElement = a.b;
        StringBuilder sb = new StringBuilder();
        String fileName = stackTraceElement.getFileName();
        sb.append(fileName != null ? StringsKt__StringsKt.replaceAfterLast$default(fileName, ".", "", (String) null, 4, (Object) null) : null);
        sb.append(stackTraceElement.getMethodName());
        sb.append(" line ");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(" ");
        sb.append(th2.getClass().getSimpleName());
        sb.append(":");
        sb.append(th2.getLocalizedMessage());
        return sb.toString();
    }

    @NotNull
    public static final String parseStackTrace(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$parseStackTrace");
        Throwable actualThrowable = getActualThrowable(th);
        if (actualThrowable != null) {
            th = actualThrowable;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "this.toString()");
        return stringWriter2;
    }

    @NotNull
    public static final String trimPayload(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$trimPayload");
        if (str.length() <= i) {
            return str;
        }
        String substring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimPayload$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1000;
        }
        return trimPayload(str, i);
    }
}
