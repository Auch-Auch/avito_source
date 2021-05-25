package com.avito.android.phone_confirmation;

import com.avito.android.phone_confirmation.state.PhoneConfirmationResolution;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTime;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050&¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/avito/android/phone_confirmation/BasePhoneConfirmationInteractor;", "Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "getCurrentState", "()Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "", "phone", "", "isCompany", "Lio/reactivex/Observable;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "requestCode", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "code", "Lcom/avito/android/remote/model/SuccessResult;", "confirmPhone", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getState", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "state", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationResolution;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getStateResolution", "()Lio/reactivex/Observable;", "stateResolution", "Lcom/avito/android/server_time/TimeSource;", "c", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "timeStorage", "initialState", "Lcom/avito/android/util/Formatter;", "formatter", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;Lcom/avito/android/util/Formatter;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public abstract class BasePhoneConfirmationInteractor implements PhoneConfirmationInteractor {
    @NotNull
    public final BehaviorRelay<PhoneConfirmationScreenState> a;
    @NotNull
    public final Observable<PhoneConfirmationResolution> b;
    @NotNull
    public final TimeSource c;

    public static final class a<T, R> implements Function<PhoneConfirmationScreenState, PhoneConfirmationResolution> {
        public final /* synthetic */ BasePhoneConfirmationInteractor a;

        public a(BasePhoneConfirmationInteractor basePhoneConfirmationInteractor) {
            this.a = basePhoneConfirmationInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PhoneConfirmationResolution apply(PhoneConfirmationScreenState phoneConfirmationScreenState) {
            PhoneConfirmationScreenState phoneConfirmationScreenState2 = phoneConfirmationScreenState;
            Intrinsics.checkNotNullParameter(phoneConfirmationScreenState2, "it");
            if (phoneConfirmationScreenState2.getValidationStatus()) {
                return PhoneConfirmationResolution.DONE;
            }
            if (phoneConfirmationScreenState2.getHasNetworkError()) {
                return PhoneConfirmationResolution.NETWORK_ERROR;
            }
            if (phoneConfirmationScreenState2.getTooManyValidations() != null) {
                return PhoneConfirmationResolution.TOO_MANY_VALIDATION_ERRORS;
            }
            if (phoneConfirmationScreenState2.getValidationError() != null) {
                return PhoneConfirmationResolution.VALIDATION_ERROR;
            }
            if (phoneConfirmationScreenState2.getCodeRequestError() != null) {
                return PhoneConfirmationResolution.TOO_MANY_CODE_REQUESTS;
            }
            if (BasePhoneConfirmationInteractor.access$isEmptyState(this.a, phoneConfirmationScreenState2.getConfirmationTime())) {
                return PhoneConfirmationResolution.EMPTY;
            }
            if (phoneConfirmationScreenState2.getEnteredCode().length() == 5) {
                return PhoneConfirmationResolution.CODE_ENTERED;
            }
            return PhoneConfirmationResolution.NORMAL;
        }
    }

    public BasePhoneConfirmationInteractor(@NotNull TimeSource timeSource, @NotNull PhoneConfirmationTimeStorage phoneConfirmationTimeStorage, @NotNull PhoneConfirmationScreenState phoneConfirmationScreenState, @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(phoneConfirmationTimeStorage, "timeStorage");
        Intrinsics.checkNotNullParameter(phoneConfirmationScreenState, "initialState");
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.c = timeSource;
        BehaviorRelay<PhoneConfirmationScreenState> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.a = create;
        getState().accept(PhoneConfirmationScreenState.copy$default(phoneConfirmationScreenState, formatter.format(phoneConfirmationScreenState.getPhone()), false, false, false, phoneConfirmationTimeStorage.getSavedTime(), false, null, null, null, null, 1006, null));
        Observable<R> map = getState().map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "state\n        .map {\n   …}\n            }\n        }");
        this.b = map;
    }

    public static final boolean access$isEmptyState(BasePhoneConfirmationInteractor basePhoneConfirmationInteractor, PhoneConfirmationTime phoneConfirmationTime) {
        boolean z = phoneConfirmationTime == null;
        boolean z2 = !Intrinsics.areEqual(basePhoneConfirmationInteractor.getState().getValue().getPhone(), phoneConfirmationTime != null ? phoneConfirmationTime.getPhoneNumber() : null);
        boolean z3 = (phoneConfirmationTime != null ? phoneConfirmationTime.getTimeNextRequestAllowed() : 0) < basePhoneConfirmationInteractor.getTimeSource().now() && !basePhoneConfirmationInteractor.getState().getValue().getCodeRequested();
        if (z || z2 || z3) {
            return true;
        }
        return false;
    }

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public abstract Observable<SuccessResult> confirmPhone(@NotNull String str, @NotNull String str2, boolean z);

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public PhoneConfirmationScreenState getCurrentState() {
        PhoneConfirmationScreenState value = getState().getValue();
        Intrinsics.checkNotNullExpressionValue(value, "state.value");
        return value;
    }

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public Observable<PhoneConfirmationResolution> getStateResolution() {
        return this.b;
    }

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public TimeSource getTimeSource() {
        return this.c;
    }

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public abstract Observable<PhoneConfirmationTime> requestCode(@NotNull String str, boolean z);

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationInteractor
    @NotNull
    public BehaviorRelay<PhoneConfirmationScreenState> getState() {
        return this.a;
    }
}
