package com.avito.android.user_advert.advert.verification;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VerificationStatus;
import com.avito.android.user_advert.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_advert/advert/verification/VerificationItemConverterImpl;", "Lcom/avito/android/user_advert/advert/verification/VerificationItemConverter;", "Lcom/avito/android/remote/model/VerificationStatus;", "verificationStatus", "", "isSupportNeeded", "Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;", "convert", "(Lcom/avito/android/remote/model/VerificationStatus;Z)Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationItemConverterImpl implements VerificationItemConverter {
    public final Features a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VerificationStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            VerificationStatus verificationStatus = VerificationStatus.OFFER;
            iArr[0] = 1;
            VerificationStatus verificationStatus2 = VerificationStatus.CHECKING;
            iArr[1] = 2;
            VerificationStatus verificationStatus3 = VerificationStatus.RETRY;
            iArr[2] = 3;
            VerificationStatus verificationStatus4 = VerificationStatus.APPROVED;
            iArr[3] = 4;
        }
    }

    @Inject
    public VerificationItemConverterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationItemConverter
    @Nullable
    public VerificationBlockItem convert(@Nullable VerificationStatus verificationStatus, boolean z) {
        boolean z2 = this.a.getHardcodedVerificationSupportButton().invoke().booleanValue() && z;
        if (verificationStatus == null) {
            return null;
        }
        int ordinal = verificationStatus.ordinal();
        if (ordinal == 0) {
            return new VerificationBlockItem(verificationStatus, R.string.verification_offer_title, R.string.verification_offer_description, Integer.valueOf(R.string.verification_offer_button_title), true, false, false, 96, null);
        }
        if (ordinal == 1) {
            return new VerificationBlockItem(verificationStatus, R.string.verification_checking_title, R.string.verification_checking_description, null, false, false, z2, 56, null);
        }
        if (ordinal == 2) {
            return new VerificationBlockItem(verificationStatus, R.string.verification_retry_title, R.string.verification_retry_description, Integer.valueOf(R.string.verification_retry_button_title), false, false, z2, 48, null);
        }
        if (ordinal == 3) {
            return new VerificationBlockItem(verificationStatus, R.string.verification_approved_title, R.string.verification_approved_description, null, false, true, z2, 24, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
