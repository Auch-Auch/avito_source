package com.avito.android.notification_center.counter;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.notification.NotificationsCount;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aRD\u0010!\u001a0\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\t0\t \u001d*\u0017\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\t0\t\u0018\u00010\u001c¢\u0006\u0002\b\u001e0\u001c¢\u0006\u0002\b\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/notification_center/counter/NotificationCenterCounterImpl;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounter;", "", "clear", "()V", "", "hasCount", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/notification/NotificationsCount;", "getCount", "()Lio/reactivex/rxjava3/core/Observable;", "", "notificationId", "markAsRead", "(Ljava/lang/String;)V", "update", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/notification/NotificationsCount;", "notificationsCount", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/NotificationsApi;", "c", "Lcom/avito/android/remote/NotificationsApi;", "api", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "relay", "<init>", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterCounterImpl implements NotificationCenterCounter {
    public final PublishRelay<NotificationsCount> a = PublishRelay.create();
    public NotificationsCount b;
    public final NotificationsApi c;
    public final SchedulersFactory3 d;

    public static final class a<T> implements Predicate<TypedResult<NotificationsCount>> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(TypedResult<NotificationsCount> typedResult) {
            return typedResult instanceof TypedResult.OfResult;
        }
    }

    public static final class b<T, R> implements Function<TypedResult<NotificationsCount>, NotificationsCount> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public NotificationsCount apply(TypedResult<NotificationsCount> typedResult) {
            TypedResult<NotificationsCount> typedResult2 = typedResult;
            Objects.requireNonNull(typedResult2, "null cannot be cast to non-null type com.avito.android.remote.model.TypedResult.OfResult<com.avito.android.remote.model.notification.NotificationsCount>");
            return (NotificationsCount) ((TypedResult.OfResult) typedResult2).getResult();
        }
    }

    public static final class c<T> implements Consumer<NotificationsCount> {
        public final /* synthetic */ NotificationCenterCounterImpl a;

        public c(NotificationCenterCounterImpl notificationCenterCounterImpl) {
            this.a = notificationCenterCounterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(NotificationsCount notificationsCount) {
            this.a.b = notificationsCount;
        }
    }

    public static final class d<T> implements Predicate<TypedResult<NotificationsCount>> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(TypedResult<NotificationsCount> typedResult) {
            return typedResult instanceof TypedResult.OfResult;
        }
    }

    public static final class e<T, R> implements Function<TypedResult<NotificationsCount>, NotificationsCount> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public NotificationsCount apply(TypedResult<NotificationsCount> typedResult) {
            TypedResult<NotificationsCount> typedResult2 = typedResult;
            Objects.requireNonNull(typedResult2, "null cannot be cast to non-null type com.avito.android.remote.model.TypedResult.OfResult<com.avito.android.remote.model.notification.NotificationsCount>");
            return (NotificationsCount) ((TypedResult.OfResult) typedResult2).getResult();
        }
    }

    public static final class f<T> implements Consumer<NotificationsCount> {
        public final /* synthetic */ NotificationCenterCounterImpl a;

        public f(NotificationCenterCounterImpl notificationCenterCounterImpl) {
            this.a = notificationCenterCounterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(NotificationsCount notificationsCount) {
            this.a.b = notificationsCount;
        }
    }

    public NotificationCenterCounterImpl(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.c = notificationsApi;
        this.d = schedulersFactory3;
    }

    @Override // com.avito.android.notification_center.counter.NotificationCenterCounterCleaner
    public void clear() {
        NotificationsCount notificationsCount = new NotificationsCount(0);
        this.b = notificationsCount;
        this.a.accept(notificationsCount);
    }

    @Override // com.avito.android.notification_center.counter.NotificationCenterCounterInteractor
    @NotNull
    public Observable<NotificationsCount> getCount() {
        NotificationsCount notificationsCount = this.b;
        if (notificationsCount == null) {
            PublishRelay<NotificationsCount> publishRelay = this.a;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
            return publishRelay;
        }
        Observable<NotificationsCount> startWith = this.a.startWith(Observable.just(notificationsCount));
        Intrinsics.checkNotNullExpressionValue(startWith, "relay.startWith(Observab…just(notificationsCount))");
        return startWith;
    }

    @Override // com.avito.android.notification_center.counter.NotificationCenterCounterInteractor
    public boolean hasCount() {
        NotificationsCount notificationsCount = this.b;
        if (notificationsCount == null || notificationsCount.getUnread() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.avito.android.notification_center.counter.NotificationCenterCounterMarker
    public void markAsRead(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        this.c.markNotificationAsRead(str).subscribeOn(this.d.io()).filter(a.a).map(b.a).doOnNext(new c(this)).subscribe(this.a, Functions.emptyConsumer());
    }

    @Override // com.avito.android.notification_center.counter.NotificationCenterCounterUpdater
    public void update() {
        this.c.getNotificationsCount().subscribeOn(this.d.io()).filter(d.a).map(e.a).doOnNext(new f(this)).subscribe(this.a, Functions.emptyConsumer());
    }
}
