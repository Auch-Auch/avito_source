package com.avito.android.phone_confirmation;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTime;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.model.PhoneConfirmationStatus;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e¢\u0006\u0004\b \u0010!J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractorImpl;", "Lcom/avito/android/phone_confirmation/BasePhoneConfirmationInteractor;", "", "phone", "", "isCompany", "Lio/reactivex/Observable;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "requestCode", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "code", "Lcom/avito/android/remote/model/SuccessResult;", "confirmPhone", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ProfileApi;", "d", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/server_time/TimeSource;", "e", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "f", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "timeStorage", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "initialState", "Lcom/avito/android/util/Formatter;", "formatter", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;Lcom/avito/android/util/Formatter;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationInteractorImpl extends BasePhoneConfirmationInteractor {
    public final ProfileApi d;
    @NotNull
    public final TimeSource e;
    public final PhoneConfirmationTimeStorage f;

    public static final class a<T, R> implements Function<PhoneConfirmationStatus, PhoneConfirmationTime> {
        public final /* synthetic */ PhoneConfirmationInteractorImpl a;
        public final /* synthetic */ String b;

        public a(PhoneConfirmationInteractorImpl phoneConfirmationInteractorImpl, String str) {
            this.a = phoneConfirmationInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PhoneConfirmationTime apply(PhoneConfirmationStatus phoneConfirmationStatus) {
            PhoneConfirmationStatus phoneConfirmationStatus2 = phoneConfirmationStatus;
            Intrinsics.checkNotNullParameter(phoneConfirmationStatus2, "it");
            long nextTryTime = phoneConfirmationStatus2.getNextTryTime() - phoneConfirmationStatus2.getLastTryTime();
            return new PhoneConfirmationTime(this.b, TimeUnit.MILLISECONDS.convert(nextTryTime, TimeUnit.SECONDS) + this.a.getTimeSource().now());
        }
    }

    public static final class b<T> implements Consumer<PhoneConfirmationTime> {
        public final /* synthetic */ PhoneConfirmationInteractorImpl a;

        public b(PhoneConfirmationInteractorImpl phoneConfirmationInteractorImpl) {
            this.a = phoneConfirmationInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PhoneConfirmationTime phoneConfirmationTime) {
            this.a.f.setSavedTime(phoneConfirmationTime);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public PhoneConfirmationInteractorImpl(@NotNull ProfileApi profileApi, @NotNull TimeSource timeSource, @NotNull PhoneConfirmationTimeStorage phoneConfirmationTimeStorage, @NotNull PhoneConfirmationScreenState phoneConfirmationScreenState, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter) {
        super(timeSource, phoneConfirmationTimeStorage, phoneConfirmationScreenState, formatter);
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(phoneConfirmationTimeStorage, "timeStorage");
        Intrinsics.checkNotNullParameter(phoneConfirmationScreenState, "initialState");
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.d = profileApi;
        this.e = timeSource;
        this.f = phoneConfirmationTimeStorage;
    }

    @Override // com.avito.android.phone_confirmation.BasePhoneConfirmationInteractor, com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public Observable<SuccessResult> confirmPhone(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "code");
        return InteropKt.toV2(ProfileApi.DefaultImpls.confirmPhone$default(this.d, str, str2, z, false, 8, null));
    }

    @Override // com.avito.android.phone_confirmation.BasePhoneConfirmationInteractor, com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public TimeSource getTimeSource() {
        return this.e;
    }

    @Override // com.avito.android.phone_confirmation.BasePhoneConfirmationInteractor, com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public Observable<PhoneConfirmationTime> requestCode(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Observable<PhoneConfirmationTime> doOnNext = InteropKt.toV2(ProfileApi.DefaultImpls.requestPhoneConfirmationCode$default(this.d, str, z, false, 4, null)).map(new a(this, str)).doOnNext(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api.requestPhoneConfirma…eStorage.savedTime = it }");
        return doOnNext;
    }
}
