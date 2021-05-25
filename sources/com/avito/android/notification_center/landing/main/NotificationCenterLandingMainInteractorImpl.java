package com.avito.android.notification_center.landing.main;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingMain;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractorImpl;", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractor;", "", "id", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingMain;", "getNotificationCenterLandingMain", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/NotificationsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/NotificationsApi;", "api", "<init>", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingMainInteractorImpl implements NotificationCenterLandingMainInteractor {
    public final NotificationsApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<NotificationCenterLandingMain>, LoadingState<? super NotificationCenterLandingMain>> {
        public final /* synthetic */ NotificationCenterLandingMainInteractorImpl a;

        public a(NotificationCenterLandingMainInteractorImpl notificationCenterLandingMainInteractorImpl) {
            this.a = notificationCenterLandingMainInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super NotificationCenterLandingMain> apply(TypedResult<NotificationCenterLandingMain> typedResult) {
            TypedResult<NotificationCenterLandingMain> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return NotificationCenterLandingMainInteractorImpl.access$convert(this.a, typedResult2);
        }
    }

    @Inject
    public NotificationCenterLandingMainInteractorImpl(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = notificationsApi;
        this.b = schedulersFactory;
    }

    public static final LoadingState access$convert(NotificationCenterLandingMainInteractorImpl notificationCenterLandingMainInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(notificationCenterLandingMainInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainInteractor
    @NotNull
    public Observable<LoadingState<NotificationCenterLandingMain>> getNotificationCenterLandingMain(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable<LoadingState<NotificationCenterLandingMain>> startWith = InteropKt.toV2(this.a.getNotificationCenterLandingMain(str)).subscribeOn(this.b.io()).map(new a(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getNotificationCente…ith(LoadingState.Loading)");
        return startWith;
    }
}
