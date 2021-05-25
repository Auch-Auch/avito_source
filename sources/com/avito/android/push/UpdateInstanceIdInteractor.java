package com.avito.android.push;

import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.push.PushToken;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ResultWithSuccess;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdInteractor;", "", "Lcom/avito/android/push/PushToken;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lio/reactivex/Single;", "", "update", "(Lcom/avito/android/push/PushToken;)Lio/reactivex/Single;", "Impl", "push_release"}, k = 1, mv = {1, 4, 2})
public interface UpdateInstanceIdInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdInteractor$Impl;", "Lcom/avito/android/push/UpdateInstanceIdInteractor;", "Lcom/avito/android/push/PushToken;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lio/reactivex/Single;", "", "update", "(Lcom/avito/android/push/PushToken;)Lio/reactivex/Single;", "Lcom/avito/android/preferences/MutableTokenStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/preferences/MutableTokenStorage;", "instanceIdStorage", "Lcom/avito/android/util/BuildInfo;", "e", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/remote/NotificationsApi;", "c", "Lcom/avito/android/remote/NotificationsApi;", "notificationsApi", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics_adjust/Adjust;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "<init>", "(Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/preferences/MutableTokenStorage;Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)V", "push_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements UpdateInstanceIdInteractor {
        public final Adjust a;
        public final MutableTokenStorage b;
        public final NotificationsApi c;
        public final SchedulersFactory d;
        public final BuildInfo e;

        public static final class a<T, R> implements Function<ResultWithSuccess, Boolean> {
            public static final a a = new a();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Boolean apply(ResultWithSuccess resultWithSuccess) {
                ResultWithSuccess resultWithSuccess2 = resultWithSuccess;
                Intrinsics.checkNotNullParameter(resultWithSuccess2, "result");
                return Boolean.valueOf(resultWithSuccess2.getSuccess());
            }
        }

        public static final class b<T> implements Consumer<Boolean> {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ PushToken b;

            public b(Impl impl, PushToken pushToken) {
                this.a = impl;
                this.b = pushToken;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Boolean bool) {
                Boolean bool2 = bool;
                Intrinsics.checkNotNullExpressionValue(bool2, "success");
                if (bool2.booleanValue()) {
                    Impl.access$onSuccess(this.a, this.b);
                    return;
                }
                Logs.debug$default("FCM_UpdateInstanceIdInteractor", "Token has been rejected by the server", null, 4, null);
                Impl.access$onError(this.a, this.b, null);
            }
        }

        public static final class c<T, R> implements Function<Throwable, Boolean> {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ PushToken b;

            public c(Impl impl, PushToken pushToken) {
                this.a = impl;
                this.b = pushToken;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Boolean apply(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "error");
                Impl.access$onError(this.a, this.b, th2);
                return Boolean.FALSE;
            }
        }

        public Impl(@NotNull Adjust adjust, @NotNull MutableTokenStorage mutableTokenStorage, @NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
            Intrinsics.checkNotNullParameter(adjust, BuildConfig.FLAVOR);
            Intrinsics.checkNotNullParameter(mutableTokenStorage, "instanceIdStorage");
            Intrinsics.checkNotNullParameter(notificationsApi, "notificationsApi");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
            Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
            this.a = adjust;
            this.b = mutableTokenStorage;
            this.c = notificationsApi;
            this.d = schedulersFactory;
            this.e = buildInfo;
        }

        public static final void access$onError(Impl impl, PushToken pushToken, Throwable th) {
            Objects.requireNonNull(impl);
            if (pushToken instanceof PushToken.GcmToken) {
                impl.b.putGcmToken("");
                Logs.error("FCM_UpdateInstanceIdInteractor", "Firebase instance id registration failed", th);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }

        public static final void access$onSuccess(Impl impl, PushToken pushToken) {
            Objects.requireNonNull(impl);
            if (pushToken instanceof PushToken.GcmToken) {
                impl.a.setPushToken(pushToken.getToken());
                impl.b.putGcmToken(pushToken.getToken());
                Logs.debug$default("FCM_UpdateInstanceIdInteractor", "Google token registration succeeded", null, 4, null);
            }
        }

        @Override // com.avito.android.push.UpdateInstanceIdInteractor
        @NotNull
        public Single<Boolean> update(@NotNull PushToken pushToken) {
            Intrinsics.checkNotNullParameter(pushToken, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            Logs.debug$default("FCM_UpdateInstanceIdInteractor", "Registering new firebase instance id: " + pushToken, null, 4, null);
            if (!(pushToken instanceof PushToken.GcmToken)) {
                throw new NoWhenBranchMatchedException();
            } else if (!Intrinsics.areEqual(pushToken.getToken(), this.b.getGcmToken())) {
                Single<Boolean> onErrorReturn = TypedObservablesKt.toTyped(InteropKt.toV2(this.c.registerNotificationToken(pushToken.getToken(), PushTokenKt.getTokenTypeRemote(pushToken), this.e.isDebug()))).subscribeOn(this.d.io()).observeOn(this.d.computation()).map(a.a).first(Boolean.FALSE).doOnSuccess(new b(this, pushToken)).onErrorReturn(new c(this, pushToken));
                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "register(token)\n        …lse\n                    }");
                return onErrorReturn;
            } else {
                Logs.debug$default("FCM_UpdateInstanceIdInteractor", "This is an old token, skipping.", null, 4, null);
                Single<Boolean> just = Single.just(Boolean.TRUE);
                Intrinsics.checkNotNullExpressionValue(just, "Single.just(true)");
                return just;
            }
        }
    }

    @NotNull
    Single<Boolean> update(@NotNull PushToken pushToken);
}
