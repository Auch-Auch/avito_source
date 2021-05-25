package com.avito.android.phone_confirmation.state;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.PhoneConfirmationTimeContract;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorageImpl;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "Lcom/avito/android/util/preferences/Preferences;", "c", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "phoneKey", AuthSource.BOOKING_ORDER, "nextTimeKey", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "value", "getSavedTime", "()Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;", "setSavedTime", "(Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTime;)V", "savedTime", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationTimeStorageImpl implements PhoneConfirmationTimeStorage {
    public final String a;
    public final String b;
    public final Preferences c;

    @Inject
    public PhoneConfirmationTimeStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.c = preferences;
        PhoneConfirmationTimeContract phoneConfirmationTimeContract = PhoneConfirmationTimeContract.INSTANCE;
        this.a = phoneConfirmationTimeContract.getPHONE_NUMBER();
        this.b = phoneConfirmationTimeContract.getNEXT_TIME();
    }

    @Override // com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage
    @Nullable
    public PhoneConfirmationTime getSavedTime() {
        long j = this.c.getLong(this.b, -1);
        String string = this.c.getString(this.a, null);
        if (j == -1 || string == null) {
            return null;
        }
        return new PhoneConfirmationTime(string, j);
    }

    @Override // com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage
    public void setSavedTime(@Nullable PhoneConfirmationTime phoneConfirmationTime) {
        long timeNextRequestAllowed = phoneConfirmationTime != null ? phoneConfirmationTime.getTimeNextRequestAllowed() : -1;
        String phoneNumber = phoneConfirmationTime != null ? phoneConfirmationTime.getPhoneNumber() : null;
        this.c.putLong(this.b, timeNextRequestAllowed);
        this.c.putString(this.a, phoneNumber);
    }
}
