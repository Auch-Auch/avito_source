package com.avito.android.phone_confirmation;

import com.avito.android.phone_confirmation.state.PhoneConfirmationResolution;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTime;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.server_time.TimeSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "", "", "phone", "", "isCompany", "Lio/reactivex/Observable;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "requestCode", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "code", "Lcom/avito/android/remote/model/SuccessResult;", "confirmPhone", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "getCurrentState", "()Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "Lcom/jakewharton/rxrelay2/Relay;", "getState", "()Lcom/jakewharton/rxrelay2/Relay;", "state", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationResolution;", "getStateResolution", "()Lio/reactivex/Observable;", "stateResolution", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneConfirmationInteractor {
    @NotNull
    Observable<SuccessResult> confirmPhone(@NotNull String str, @NotNull String str2, boolean z);

    @NotNull
    PhoneConfirmationScreenState getCurrentState();

    @NotNull
    Relay<PhoneConfirmationScreenState> getState();

    @NotNull
    Observable<PhoneConfirmationResolution> getStateResolution();

    @NotNull
    TimeSource getTimeSource();

    @NotNull
    Observable<PhoneConfirmationTime> requestCode(@NotNull String str, boolean z);
}
