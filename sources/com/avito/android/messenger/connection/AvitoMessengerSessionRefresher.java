package com.avito.android.messenger.connection;

import a2.a.a.o1.c.h;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.session_refresh.SessionRefresher;
import com.avito.android.util.Logs;
import dagger.Lazy;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerSessionRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/connection/AvitoMessengerSessionRefresher;", "Lru/avito/messenger/MessengerSessionRefresher;", "", "originalSession", "source", "Lio/reactivex/Single;", "", "refreshSession", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "okClient", "Lcom/avito/android/session_refresh/SessionRefresher;", AuthSource.SEND_ABUSE, "Lcom/avito/android/session_refresh/SessionRefresher;", "sessionRefresher", "<init>", "(Lcom/avito/android/session_refresh/SessionRefresher;Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMessengerSessionRefresher implements MessengerSessionRefresher {
    public final SessionRefresher a;
    public final Lazy<OkHttpClient> b;

    public static final class a<V> implements Callable<Boolean> {
        public final /* synthetic */ AvitoMessengerSessionRefresher a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(AvitoMessengerSessionRefresher avitoMessengerSessionRefresher, String str, String str2) {
            this.a = avitoMessengerSessionRefresher;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Logs.verbose$default("MessengerSessionRefresher", "Refreshing session...", null, 4, null);
            return Boolean.valueOf(this.a.a.refreshSession(this.b, this.c, new h(this)));
        }
    }

    public AvitoMessengerSessionRefresher(@NotNull SessionRefresher sessionRefresher, @NotNull Lazy<OkHttpClient> lazy) {
        Intrinsics.checkNotNullParameter(sessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(lazy, "okClient");
        this.a = sessionRefresher;
        this.b = lazy;
    }

    @Override // ru.avito.messenger.MessengerSessionRefresher
    @NotNull
    public Single<Boolean> refreshSession(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "originalSession");
        Single<Boolean> fromCallable = Single.fromCallable(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …)\n            }\n        }");
        return fromCallable;
    }
}
