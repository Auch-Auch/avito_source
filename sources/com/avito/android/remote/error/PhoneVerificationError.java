package com.avito.android.remote.error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.PhonePretendSpecialErrorCase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/error/PhoneVerificationError;", "Lcom/avito/android/remote/error/TypedError;", "Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase$PhoneVerificationData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase$PhoneVerificationData;", "getData", "()Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase$PhoneVerificationData;", "data", "<init>", "(Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase$PhoneVerificationData;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneVerificationError implements TypedError {
    @Nullable
    public final PhonePretendSpecialErrorCase.PhoneVerificationData a;

    public PhoneVerificationError() {
        this(null, 1, null);
    }

    public PhoneVerificationError(@Nullable PhonePretendSpecialErrorCase.PhoneVerificationData phoneVerificationData) {
        this.a = phoneVerificationData;
    }

    @Nullable
    public final PhonePretendSpecialErrorCase.PhoneVerificationData getData() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneVerificationError(PhonePretendSpecialErrorCase.PhoneVerificationData phoneVerificationData, int i, j jVar) {
        this((i & 1) != 0 ? null : phoneVerificationData);
    }
}
