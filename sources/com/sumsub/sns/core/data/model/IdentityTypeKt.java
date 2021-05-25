package com.sumsub.sns.core.data.model;

import com.sumsub.sns.core.R;
import com.sumsub.sns.core.data.model.IdentityType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/model/IdentityType;", "", "getIcon-wYDFDDU", "(Ljava/lang/String;)I", "icon", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class IdentityTypeKt {
    /* renamed from: getIcon-wYDFDDU  reason: not valid java name */
    public static final int m216getIconwYDFDDU(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$icon");
        IdentityType.Companion companion = IdentityType.Companion;
        if (Intrinsics.areEqual(str, companion.m213getPassportGm96dUI())) {
            return R.drawable.sns_ic_iddoc_passport;
        }
        if (Intrinsics.areEqual(str, companion.m210getDriversGm96dUI())) {
            return R.drawable.sns_ic_iddoc_driving_license;
        }
        if (Intrinsics.areEqual(str, companion.m214getResidencePermitGm96dUI())) {
            return R.drawable.sns_ic_iddoc_residence_permit;
        }
        return R.drawable.sns_ic_iddoc_id_card;
    }
}
