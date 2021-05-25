package com.avito.android.push.provider;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.push.PushToken;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GmsTasksKt;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.Constants;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/push/provider/GcmPushTokenProviderImpl;", "Lcom/avito/android/push/provider/GcmPushTokenProvider;", "", "needFresh", "Lio/reactivex/Single;", "Larrow/core/Option;", "Lcom/avito/android/push/PushToken;", "getPushToken", "(Z)Lio/reactivex/Single;", "Lcom/google/firebase/iid/FirebaseInstanceId;", AuthSource.SEND_ABUSE, "Lcom/google/firebase/iid/FirebaseInstanceId;", Constants.FirelogAnalytics.PARAM_INSTANCE_ID, "Lcom/avito/android/preferences/TokenStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/preferences/TokenStorage;", "storage", "<init>", "(Lcom/google/firebase/iid/FirebaseInstanceId;Lcom/avito/android/preferences/TokenStorage;)V", "push_release"}, k = 1, mv = {1, 4, 2})
public final class GcmPushTokenProviderImpl implements GcmPushTokenProvider {
    public final FirebaseInstanceId a;
    public final TokenStorage b;

    public static final class a<T, R> implements Function<Option<? extends InstanceIdResult>, Option<? extends PushToken>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends PushToken> apply(Option<? extends InstanceIdResult> option) {
            String token;
            Option<? extends InstanceIdResult> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "result");
            InstanceIdResult instanceIdResult = (InstanceIdResult) option2.orNull();
            if (!(instanceIdResult == null || (token = instanceIdResult.getToken()) == null)) {
                Intrinsics.checkNotNullExpressionValue(token, "it");
                Option<? extends PushToken> option3 = OptionKt.toOption(new PushToken.GcmToken(token));
                if (option3 != null) {
                    return option3;
                }
            }
            return Option.Companion.empty();
        }
    }

    public static final class b<T, R> implements Function<Throwable, Option<? extends PushToken>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends PushToken> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Option.Companion.empty();
        }
    }

    @Inject
    public GcmPushTokenProviderImpl(@NotNull FirebaseInstanceId firebaseInstanceId, @NotNull TokenStorage tokenStorage) {
        Intrinsics.checkNotNullParameter(firebaseInstanceId, Constants.FirelogAnalytics.PARAM_INSTANCE_ID);
        Intrinsics.checkNotNullParameter(tokenStorage, "storage");
        this.a = firebaseInstanceId;
        this.b = tokenStorage;
    }

    @Override // com.avito.android.push.provider.PushTokenProvider
    @NotNull
    public Single<Option<PushToken>> getPushToken(boolean z) {
        String gcmToken = this.b.getGcmToken();
        if (!(!m.isBlank(gcmToken)) || z) {
            Task<InstanceIdResult> instanceId = this.a.getInstanceId();
            Intrinsics.checkNotNullExpressionValue(instanceId, "instanceId.instanceId");
            Single<Option<PushToken>> onErrorReturn = GmsTasksKt.toSingle(instanceId).map(a.a).onErrorReturn(b.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "instanceId.instanceId\n  …empty()\n                }");
            return onErrorReturn;
        }
        Single<Option<PushToken>> just = Single.just(OptionKt.toOption(new PushToken.GcmToken(gcmToken)));
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(PushToken.GcmToken(token).toOption())");
        return just;
    }
}
