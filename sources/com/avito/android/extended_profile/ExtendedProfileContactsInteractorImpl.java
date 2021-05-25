package com.avito.android.extended_profile;

import com.avito.android.async_phone_core.UtilsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.ExtendedProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ExtendedProfilePhoneResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractorImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getPhoneAction", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "sendCallEvent", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/ExtendedProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ExtendedProfileApi;", "api", "<init>", "(Lcom/avito/android/remote/ExtendedProfileApi;Lcom/avito/android/util/SchedulersFactory3;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileContactsInteractorImpl implements ExtendedProfileContactsInteractor {
    public final ExtendedProfileApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<ExtendedProfilePhoneResponse, DeepLink> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public DeepLink apply(ExtendedProfilePhoneResponse extendedProfilePhoneResponse) {
            ExtendedProfilePhoneResponse extendedProfilePhoneResponse2 = extendedProfilePhoneResponse;
            if (extendedProfilePhoneResponse2 instanceof ExtendedProfilePhoneResponse.Ok) {
                return ((ExtendedProfilePhoneResponse.Ok) extendedProfilePhoneResponse2).getAction().getUri();
            }
            if (extendedProfilePhoneResponse2 instanceof ExtendedProfilePhoneResponse.Failure) {
                return UtilsKt.toDialogDeepLink(((ExtendedProfilePhoneResponse.Failure) extendedProfilePhoneResponse2).getDialogInfo());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public ExtendedProfileContactsInteractorImpl(@NotNull ExtendedProfileApi extendedProfileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(extendedProfileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = extendedProfileApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileContactsInteractor
    @NotNull
    public Observable<DeepLink> getPhoneAction(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable<TypedResult<ExtendedProfilePhoneResponse>> subscribeOn = this.a.getPhoneAction(str, str2).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getPhoneAction(userK…scribeOn(schedulers.io())");
        Observable<DeepLink> map = TypedObservablesKt.toTyped(subscribeOn).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getPhoneAction(userK…          }\n            }");
        return map;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileContactsInteractor
    @NotNull
    public Observable<Unit> sendCallEvent(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable<TypedResult<Unit>> subscribeOn = this.a.call(str, str2).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.call(userKey, contex…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}
