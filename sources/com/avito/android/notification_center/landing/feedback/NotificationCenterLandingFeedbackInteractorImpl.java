package com.avito.android.notification_center.landing.feedback;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedback;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedbackResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractorImpl;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;", "", "id", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;", "getNotificationCenterLandingFeedback", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "isPositiveResult", "sendNotificationCenterLandingFeedbackResult", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lcom/avito/android/remote/NotificationsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/NotificationsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingFeedbackInteractorImpl implements NotificationCenterLandingFeedbackInteractor {
    public final NotificationsApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<NotificationCenterLandingFeedback>, LoadingState<? super NotificationCenterLandingFeedback>> {
        public final /* synthetic */ NotificationCenterLandingFeedbackInteractorImpl a;

        public a(NotificationCenterLandingFeedbackInteractorImpl notificationCenterLandingFeedbackInteractorImpl) {
            this.a = notificationCenterLandingFeedbackInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super NotificationCenterLandingFeedback> apply(TypedResult<NotificationCenterLandingFeedback> typedResult) {
            TypedResult<NotificationCenterLandingFeedback> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return NotificationCenterLandingFeedbackInteractorImpl.access$convertFeedback(this.a, typedResult2);
        }
    }

    public static final class b<T, R> implements Function<TypedResult<NotificationCenterLandingFeedbackResult>, LoadingState<? super String>> {
        public final /* synthetic */ NotificationCenterLandingFeedbackInteractorImpl a;

        public b(NotificationCenterLandingFeedbackInteractorImpl notificationCenterLandingFeedbackInteractorImpl) {
            this.a = notificationCenterLandingFeedbackInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super String> apply(TypedResult<NotificationCenterLandingFeedbackResult> typedResult) {
            TypedResult<NotificationCenterLandingFeedbackResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return NotificationCenterLandingFeedbackInteractorImpl.access$convertFeedbackResult(this.a, typedResult2);
        }
    }

    @Inject
    public NotificationCenterLandingFeedbackInteractorImpl(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = notificationsApi;
        this.b = schedulersFactory;
    }

    public static final LoadingState access$convertFeedback(NotificationCenterLandingFeedbackInteractorImpl notificationCenterLandingFeedbackInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(notificationCenterLandingFeedbackInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final LoadingState access$convertFeedbackResult(NotificationCenterLandingFeedbackInteractorImpl notificationCenterLandingFeedbackInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(notificationCenterLandingFeedbackInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((NotificationCenterLandingFeedbackResult) ((TypedResult.OfResult) typedResult).getResult()).getMessage());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractor
    @NotNull
    public Observable<LoadingState<NotificationCenterLandingFeedback>> getNotificationCenterLandingFeedback(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable<LoadingState<NotificationCenterLandingFeedback>> startWith = InteropKt.toV2(this.a.getNotificationCenterLandingFeedback(str)).subscribeOn(this.b.io()).map(new a(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getNotificationCente…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractor
    @NotNull
    public Observable<LoadingState<String>> sendNotificationCenterLandingFeedbackResult(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable<LoadingState<String>> startWith = InteropKt.toV2(this.a.sendNotificationCenterLandingFeedbackResult(str, z)).subscribeOn(this.b.io()).map(new b(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.sendNotificationCent…ith(LoadingState.Loading)");
        return startWith;
    }
}
