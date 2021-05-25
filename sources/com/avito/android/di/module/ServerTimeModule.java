package com.avito.android.di.module;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.server_time.UtcTimeSource;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R:\u0010\u0019\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\b0\b \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\b0\b\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/di/module/ServerTimeModule;", "", "Lcom/avito/android/server_time/ServerTimeSource;", "serverTimeSource", "Lcom/avito/android/server_time/TimeSource;", "provideTimeSource", "(Lcom/avito/android/server_time/ServerTimeSource;)Lcom/avito/android/server_time/TimeSource;", "Lio/reactivex/Observable;", "", "timeDiffObservable", "provideServerTimeSource", "(Lio/reactivex/Observable;)Lcom/avito/android/server_time/ServerTimeSource;", "timeSource", "Lcom/avito/android/server_time/UtcTimeSource;", "provideUtcTimeSource", "(Lcom/avito/android/server_time/ServerTimeSource;)Lcom/avito/android/server_time/UtcTimeSource;", "provideTimeDiffObservable", "()Lio/reactivex/Observable;", "Lio/reactivex/functions/Consumer;", "provideTimeDiffAction", "()Lio/reactivex/functions/Consumer;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "timeDiffRelay", "<init>", "()V", "server-time_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ServerTimeModule {
    @NotNull
    public static final ServerTimeModule INSTANCE = new ServerTimeModule();
    public static final PublishRelay<Long> a = PublishRelay.create();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final ServerTimeSource provideServerTimeSource(@NotNull Observable<Long> observable) {
        Intrinsics.checkNotNullParameter(observable, "timeDiffObservable");
        return new ServerTimeSource(TimeSource.DEFAULT, observable);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final Consumer<Long> provideTimeDiffAction() {
        PublishRelay<Long> publishRelay = a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "timeDiffRelay");
        return publishRelay;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final Observable<Long> provideTimeDiffObservable() {
        PublishRelay<Long> publishRelay = a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "timeDiffRelay");
        return publishRelay;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final TimeSource provideTimeSource(@NotNull ServerTimeSource serverTimeSource) {
        Intrinsics.checkNotNullParameter(serverTimeSource, "serverTimeSource");
        return serverTimeSource;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final UtcTimeSource provideUtcTimeSource(@NotNull ServerTimeSource serverTimeSource) {
        Intrinsics.checkNotNullParameter(serverTimeSource, "timeSource");
        return new UtcTimeSource(serverTimeSource);
    }
}
