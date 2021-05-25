package com.avito.android.remote.model;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.payment.SberbankOnlineKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult;", "", "Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult$VerificationStatus;", "status", "Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult$VerificationStatus;", "getStatus", "()Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult$VerificationStatus;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult$VerificationStatus;Lcom/avito/android/deep_linking/links/DeepLink;)V", "VerificationStatus", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationStatusResult {
    @SerializedName("deeplink")
    @Nullable
    private final DeepLink deeplink;
    @SerializedName("status")
    @Nullable
    private final VerificationStatus status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/LandlinePhoneVerificationStatusResult$VerificationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ERROR", SberbankOnlineKt.RESULT_SUCCESS, "PROCESSING", "FAILED", "profile_release"}, k = 1, mv = {1, 4, 2})
    public enum VerificationStatus {
        ERROR,
        SUCCESS,
        PROCESSING,
        FAILED
    }

    public LandlinePhoneVerificationStatusResult(@Nullable VerificationStatus verificationStatus, @Nullable DeepLink deepLink) {
        this.status = verificationStatus;
        this.deeplink = deepLink;
    }

    @Nullable
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final VerificationStatus getStatus() {
        return this.status;
    }
}
