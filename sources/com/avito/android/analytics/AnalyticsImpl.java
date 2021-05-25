package com.avito.android.analytics;

import a2.a.a.i.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/avito/android/analytics/AnalyticsImpl;", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Event;", "event", "", "track", "(Lcom/avito/android/analytics/Event;)V", "", "d", "Z", "logEvents", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "relay", "", "Lcom/avito/android/analytics/EventObserver;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "consumers", "e", "dropGraphiteEvents", "", "observers", "<init>", "(Ljava/util/Set;ZZ)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticsImpl implements Analytics {
    public final PublishRelay<Event> a;
    public final List<EventObserver> b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final boolean d;
    public final boolean e;

    public AnalyticsImpl(@NotNull Set<? extends EventObserver> set, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(set, "observers");
        this.d = z;
        this.e = z2;
        PublishRelay<Event> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.a = create;
        List<EventObserver> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.toList(set));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(observers.toList())");
        this.b = unmodifiableList;
        Iterator<T> it = unmodifiableList.iterator();
        while (it.hasNext()) {
            DisposableKt.plusAssign(this.c, it.next().observe(this.a, new a(this)));
        }
    }

    public static final void access$logExceptionToAnalytics(AnalyticsImpl analyticsImpl, Throwable th) {
        Objects.requireNonNull(analyticsImpl);
        Logs.error("Analytics", "Failed to send analytics", th);
    }

    @Override // com.avito.android.analytics.Analytics
    public void track(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.e || !(event instanceof GraphiteEvent)) {
            if (this.d && !(event instanceof HasCustomLogger)) {
                Logs.debug$default("Analytics", event.toString(), null, 4, null);
            }
            this.a.accept(event);
        }
    }
}
