package com.avito.android.push.provider;

import android.content.Context;
import arrow.core.Option;
import com.avito.android.push.PushToken;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serviceAvailability.MobileService;
import com.avito.android.serviceAvailability.MobileServiceKt;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.GeoContract;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eR2\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/push/provider/PushTokenProviderImpl;", "Lcom/avito/android/push/provider/PushTokenProvider;", "Lcom/avito/android/serviceAvailability/MobileService;", "mobileService", GeoContract.PROVIDER, "", "registerPushTokenProvider", "(Lcom/avito/android/serviceAvailability/MobileService;Lcom/avito/android/push/provider/PushTokenProvider;)V", "", "needFresh", "Lio/reactivex/Single;", "Larrow/core/Option;", "Lcom/avito/android/push/PushToken;", "getPushToken", "(Z)Lio/reactivex/Single;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", AuthSource.SEND_ABUSE, "Ljava/util/HashMap;", "providers", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "push_release"}, k = 1, mv = {1, 4, 2})
public final class PushTokenProviderImpl implements PushTokenProvider {
    public final HashMap<MobileService, PushTokenProvider> a = new HashMap<>();
    public final Context b;

    public static final class a<T, R> implements Function<Throwable, Option<? extends PushToken>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends PushToken> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.error("PushTokenProvider", "Failed to get push token", th2);
            return Option.Companion.empty();
        }
    }

    public PushTokenProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
    }

    @Override // com.avito.android.push.provider.PushTokenProvider
    @NotNull
    public Single<Option<PushToken>> getPushToken(boolean z) {
        Single<Option<PushToken>> single;
        PushTokenProvider pushTokenProvider = this.a.get(MobileServiceKt.getAvailableMobileService(this.b));
        if (pushTokenProvider == null || (single = pushTokenProvider.getPushToken(z)) == null) {
            single = Single.just(Option.Companion.empty());
            Intrinsics.checkNotNullExpressionValue(single, "Single.just(Option.empty())");
        }
        Single<Option<PushToken>> onErrorReturn = single.onErrorReturn(a.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "tokenRequest.onErrorRetu… Option.empty()\n        }");
        return onErrorReturn;
    }

    public final void registerPushTokenProvider(@NotNull MobileService mobileService, @NotNull PushTokenProvider pushTokenProvider) {
        Intrinsics.checkNotNullParameter(mobileService, "mobileService");
        Intrinsics.checkNotNullParameter(pushTokenProvider, GeoContract.PROVIDER);
        this.a.put(mobileService, pushTokenProvider);
    }
}
