package com.avito.android.cookie_provider;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.util.DatesKt;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "", "getTime", "()Ljava/lang/String;", "Lcom/avito/android/server_time/ServerTimeSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/server_time/ServerTimeSource;", "serverTimeSource", "<init>", "(Lcom/avito/android/server_time/ServerTimeSource;)V", "cookie-provider_release"}, k = 1, mv = {1, 4, 2})
public final class CookieExpiredTimeImpl implements CookieExpiredTime {
    public final ServerTimeSource a;

    @Inject
    public CookieExpiredTimeImpl(@NotNull ServerTimeSource serverTimeSource) {
        Intrinsics.checkNotNullParameter(serverTimeSource, "serverTimeSource");
        this.a = serverTimeSource;
    }

    @Override // com.avito.android.cookie_provider.CookieExpiredTime
    @NotNull
    public String getTime() {
        String date = DatesKt.add(new Date(this.a.now()), 6, 1).toString();
        Intrinsics.checkNotNullExpressionValue(date, "Date(serverTimeSource.no…AY_OF_YEAR, 1).toString()");
        return date;
    }
}
