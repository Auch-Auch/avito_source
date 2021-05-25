package com.avito.android.util.preferences;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/preferences/PhoneConfirmationTimeContract;", "", "", "PHONE_NUMBER", "Ljava/lang/String;", "getPHONE_NUMBER", "()Ljava/lang/String;", "NEXT_TIME", "getNEXT_TIME", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationTimeContract {
    @NotNull
    public static final PhoneConfirmationTimeContract INSTANCE = new PhoneConfirmationTimeContract();

    @NotNull
    public final String getNEXT_TIME() {
        return "phone_confirmation_time_next_time";
    }

    @NotNull
    public final String getPHONE_NUMBER() {
        return "phone_confirmation_time_phone";
    }
}
