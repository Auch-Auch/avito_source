package com.avito.android.authorization.phone_proving;

import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/phone_proving/PhoneProvingInteractorImpl;", "Lcom/avito/android/authorization/phone_proving/PhoneProvingInteractor;", "", "challengeId", "phone", "Lio/reactivex/Completable;", "provePhone", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneProvingInteractorImpl implements PhoneProvingInteractor {
    public final ProfileApi a;
    public final SchedulersFactory b;

    @Inject
    public PhoneProvingInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = profileApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingInteractor
    @NotNull
    public Completable provePhone(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "challengeId");
        Intrinsics.checkNotNullParameter(str2, "phone");
        Observable subscribeOn = InteropKt.toV2(this.a.proviePhone(str, str2)).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.proviePhone(challeng…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.proviePhone(challeng…        .ignoreElements()");
        return ignoreElements;
    }
}
