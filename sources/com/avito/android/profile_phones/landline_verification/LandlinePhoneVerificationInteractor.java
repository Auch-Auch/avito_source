package com.avito.android.profile_phones.landline_verification;

import a2.a.a.c2.c.d;
import com.avito.android.code_confirmation.Source;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.LandlinePhoneVerificationStatusResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.registration.RequestCodeResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;", "", "", "callId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult;", "startVerificationStatusPolling", "(I)Lio/reactivex/rxjava3/core/Observable;", "", "phone", "Lio/reactivex/rxjava3/core/Single;", "", "requestManualVerificationCall", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/registration/RequestCodeResult;", "requestBotVerificationCall", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorThrowableConverter", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationInteractor {
    public final ProfileApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;

    public static final class a<T, R> implements Function<Long, SingleSource<? extends LandlinePhoneVerificationStatusResult>> {
        public final /* synthetic */ LandlinePhoneVerificationInteractor a;
        public final /* synthetic */ int b;

        public a(LandlinePhoneVerificationInteractor landlinePhoneVerificationInteractor, int i) {
            this.a = landlinePhoneVerificationInteractor;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends LandlinePhoneVerificationStatusResult> apply(Long l) {
            Single<TypedResult<LandlinePhoneVerificationStatusResult>> onErrorResumeNext = this.a.a.landlinePhoneVerificationStatus(this.b).subscribeOn(this.a.b.io()).onErrorResumeNext(new d(this));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.landlinePhoneVerific…e()\n                    }");
            Single<R> flatMap = onErrorResumeNext.flatMap(LandlinePhoneVerificationInteractor$startVerificationStatusPolling$1$$special$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            return flatMap;
        }
    }

    @Inject
    public LandlinePhoneVerificationInteractor(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorThrowableConverter");
        this.a = profileApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
    }

    @NotNull
    public final Single<TypedResult<RequestCodeResult>> requestBotVerificationCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Single<TypedResult<RequestCodeResult>> observeOn = this.a.requestCodeV2(str, false, Source.PHONE_ADD).subscribeOn(this.b.io()).observeOn(this.b.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.requestCodeV2(phone,…(schedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<Unit> requestManualVerificationCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Single flatMap = a2.b.a.a.a.e2(this.b, this.a.landlinePhoneRequestVerificationCall(str), "api.landlinePhoneRequest…scribeOn(schedulers.io())").flatMap(LandlinePhoneVerificationInteractor$requestManualVerificationCall$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single<Unit> observeOn = flatMap.observeOn(this.b.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.landlinePhoneRequest…(schedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Observable<LandlinePhoneVerificationStatusResult> startVerificationStatusPolling(int i) {
        return a2.b.a.a.a.b2(this.b, Observable.interval(4, TimeUnit.SECONDS).switchMapSingle(new a(this, i)), "Observable.interval(REQU…(schedulers.mainThread())");
    }
}
