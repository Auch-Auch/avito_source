package com.avito.android.phone_confirmation;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTime;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.model.ConsultationPhoneConfirmationResult;
import com.avito.android.remote.model.ConsultationPhoneConfirmationStatus;
import com.avito.android.remote.model.Error;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.AvitoResponseException;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e¢\u0006\u0004\b \u0010!J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/avito/android/phone_confirmation/ConsultationFormPhoneConfirmationInteractorImpl;", "Lcom/avito/android/phone_confirmation/BasePhoneConfirmationInteractor;", "", "phone", "", "isCompany", "Lio/reactivex/Observable;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "requestCode", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "code", "Lcom/avito/android/remote/model/SuccessResult;", "confirmPhone", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "f", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "timeStorage", "Lcom/avito/android/server_time/TimeSource;", "e", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/remote/ProfileApi;", "d", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "initialState", "Lcom/avito/android/util/Formatter;", "formatter", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;Lcom/avito/android/util/Formatter;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormPhoneConfirmationInteractorImpl extends BasePhoneConfirmationInteractor {
    public final ProfileApi d;
    @NotNull
    public final TimeSource e;
    public final PhoneConfirmationTimeStorage f;

    public static final class a<T, R> implements Function<TypedResult<ConsultationPhoneConfirmationResult>, ObservableSource<? extends SuccessResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends SuccessResult> apply(TypedResult<ConsultationPhoneConfirmationResult> typedResult) {
            TypedResult<ConsultationPhoneConfirmationResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                ConsultationPhoneConfirmationResult consultationPhoneConfirmationResult = (ConsultationPhoneConfirmationResult) ofResult.getResult();
                if (consultationPhoneConfirmationResult instanceof ConsultationPhoneConfirmationResult.Ok) {
                    return Observable.just(new SuccessResult(null, 1, null));
                }
                if (consultationPhoneConfirmationResult instanceof ConsultationPhoneConfirmationResult.Failure) {
                    Object result = ofResult.getResult();
                    Objects.requireNonNull(result, "null cannot be cast to non-null type com.avito.android.remote.model.ConsultationPhoneConfirmationResult.Failure");
                    return Observable.error(new AvitoResponseException(new Error(200, ((ConsultationPhoneConfirmationResult.Failure) result).getMessage())));
                }
                throw new NoWhenBranchMatchedException();
            } else if (typedResult2 instanceof TypedResult.OfError) {
                return Observable.error(new UnknownError(((TypedResult.OfError) typedResult2).getError().getMessage()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<TypedResult<ConsultationPhoneConfirmationStatus>, ObservableSource<? extends Long>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Long> apply(TypedResult<ConsultationPhoneConfirmationStatus> typedResult) {
            TypedResult<ConsultationPhoneConfirmationStatus> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                ConsultationPhoneConfirmationStatus consultationPhoneConfirmationStatus = (ConsultationPhoneConfirmationStatus) ofResult.getResult();
                if (consultationPhoneConfirmationStatus instanceof ConsultationPhoneConfirmationStatus.Ok) {
                    Object result = ofResult.getResult();
                    Objects.requireNonNull(result, "null cannot be cast to non-null type com.avito.android.remote.model.ConsultationPhoneConfirmationStatus.Ok");
                    return Observable.just(Long.valueOf(((ConsultationPhoneConfirmationStatus.Ok) result).getTimer()));
                } else if (consultationPhoneConfirmationStatus instanceof ConsultationPhoneConfirmationStatus.Failure) {
                    Object result2 = ofResult.getResult();
                    Objects.requireNonNull(result2, "null cannot be cast to non-null type com.avito.android.remote.model.ConsultationPhoneConfirmationStatus.Failure");
                    return Observable.error(new AvitoResponseException(new Error(200, ((ConsultationPhoneConfirmationStatus.Failure) result2).getMessage())));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (typedResult2 instanceof TypedResult.OfError) {
                return Observable.error(new UnknownError(""));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class c<T, R> implements Function<Long, PhoneConfirmationTime> {
        public final /* synthetic */ ConsultationFormPhoneConfirmationInteractorImpl a;
        public final /* synthetic */ String b;

        public c(ConsultationFormPhoneConfirmationInteractorImpl consultationFormPhoneConfirmationInteractorImpl, String str) {
            this.a = consultationFormPhoneConfirmationInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PhoneConfirmationTime apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "it");
            return new PhoneConfirmationTime(this.b, TimeUnit.MILLISECONDS.convert(l2.longValue(), TimeUnit.SECONDS) + this.a.getTimeSource().now());
        }
    }

    public static final class d<T> implements Consumer<PhoneConfirmationTime> {
        public final /* synthetic */ ConsultationFormPhoneConfirmationInteractorImpl a;

        public d(ConsultationFormPhoneConfirmationInteractorImpl consultationFormPhoneConfirmationInteractorImpl) {
            this.a = consultationFormPhoneConfirmationInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PhoneConfirmationTime phoneConfirmationTime) {
            this.a.f.setSavedTime(phoneConfirmationTime);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ConsultationFormPhoneConfirmationInteractorImpl(@NotNull ProfileApi profileApi, @NotNull TimeSource timeSource, @NotNull PhoneConfirmationTimeStorage phoneConfirmationTimeStorage, @NotNull PhoneConfirmationScreenState phoneConfirmationScreenState, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter) {
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
        Observable<SuccessResult> flatMap = InteropKt.toV2(this.d.confirmPhoneConsultation(str, str2)).flatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.confirmPhoneConsulta…}\n            }\n        }");
        return flatMap;
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
        Observable<PhoneConfirmationTime> doOnNext = InteropKt.toV2(this.d.getConfirmCodeConsultation(str)).flatMap(b.a).map(new c(this, str)).doOnNext(new d(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api.getConfirmCodeConsul…eStorage.savedTime = it }");
        return doOnNext;
    }
}
