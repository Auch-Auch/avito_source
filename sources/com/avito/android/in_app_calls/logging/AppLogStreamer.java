package com.avito.android.in_app_calls.logging;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.HashSet;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\rB\u0017\b\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R&\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/in_app_calls/logging/AppLogStreamer;", "Lcom/avito/android/in_app_calls/logging/LogStreamer;", "", Tracker.Events.CREATIVE_START, "()V", "stop", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "whiteListedTags", "Lcom/jakewharton/rxrelay3/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/Relay;", "subject", "Ltimber/log/Timber$Tree;", "c", "Ltimber/log/Timber$Tree;", "timberTree", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getLogsObservable", "()Lio/reactivex/rxjava3/core/Observable;", "logsObservable", "", "<init>", "([Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class AppLogStreamer implements LogStreamer {
    public final Relay<String> a;
    @NotNull
    public final Observable<String> b;
    public Timber.Tree c;
    public final HashSet<String> d;

    public final class a extends Timber.Tree {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // timber.log.Timber.Tree
        public boolean isLoggable(@Nullable String str, int i) {
            return i >= 5 || CollectionsKt___CollectionsKt.contains(AppLogStreamer.this.d, str);
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, @Nullable String str, @NotNull String str2, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(str2, "message");
            Relay relay = AppLogStreamer.this.a;
            relay.accept(str + " : " + str2);
        }
    }

    @Inject
    public AppLogStreamer(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "whiteListedTags");
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.b = create;
        this.d = y.hashSetOf((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // com.avito.android.in_app_calls.logging.LogStreamer
    @NotNull
    public Observable<String> getLogsObservable() {
        return this.b;
    }

    @Override // com.avito.android.in_app_calls.logging.LogStreamer
    public void start() {
        a aVar = new a();
        Timber.plant(aVar);
        this.c = aVar;
    }

    @Override // com.avito.android.in_app_calls.logging.LogStreamer
    public void stop() {
        Timber.Tree tree = this.c;
        if (tree != null) {
            Timber.uproot(tree);
        }
    }
}
