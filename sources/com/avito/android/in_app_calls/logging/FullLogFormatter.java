package com.avito.android.in_app_calls.logging;

import android.os.Process;
import android.text.format.DateFormat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.y.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00060\nj\u0002`\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/logging/FullLogFormatter;", "Lcom/avito/android/in_app_calls/logging/LogFormatter;", "", "message", "format", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", AuthSource.SEND_ABUSE, "Ljava/lang/StringBuilder;", "builder", "<init>", "(Lcom/avito/android/server_time/TimeSource;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class FullLogFormatter implements LogFormatter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final StringBuilder a = new StringBuilder();
    public final TimeSource b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/in_app_calls/logging/FullLogFormatter$Companion;", "", "", "FULL_LOG_DATE_TIME_FORMAT", "Ljava/lang/String;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public FullLogFormatter(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.b = timeSource;
    }

    @Override // com.avito.android.in_app_calls.logging.LogFormatter
    @NotNull
    public String format(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        CharSequence format = DateFormat.format("yyyy-MM-dd HH:mm:ss.sss", this.b.now());
        int myPid = Process.myPid();
        StringBuilder sb = this.a;
        sb.append(format);
        sb.append(" ");
        sb.append(myPid);
        sb.append(" ");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "builder\n            .app…         .append(message)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder\n            .app…)\n            .toString()");
        i.clear(this.a);
        return sb2;
    }
}
