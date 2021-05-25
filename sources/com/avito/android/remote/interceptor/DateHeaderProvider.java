package com.avito.android.remote.interceptor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", AuthSource.BOOKING_ORDER, "Z", "isMandatory", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "Lcom/avito/android/server_time/TimeSource;", "c", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "getValue", "value", "<init>", "(Lcom/avito/android/server_time/TimeSource;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class DateHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "X-Date";
    public final boolean b = true;
    public final TimeSource c;

    public DateHeaderProvider(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.c = timeSource;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        return String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.c.now()));
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.b;
    }
}
