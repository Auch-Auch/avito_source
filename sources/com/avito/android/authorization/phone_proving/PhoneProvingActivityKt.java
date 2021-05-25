package com.avito.android.authorization.phone_proving;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", "challengeId", "phonePart", "inputHint", "", "isOpenedFromPhoneList", "Landroid/content/Intent;", "createPhoneProvingActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneProvingActivityKt {
    @NotNull
    public static final Intent createPhoneProvingActivityIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "challengeId");
        Intrinsics.checkNotNullParameter(str2, "phonePart");
        Intrinsics.checkNotNullParameter(str3, "inputHint");
        Intent putExtra = new Intent(context, PhoneProvingActivity.class).putExtra("challenge_id", str).putExtra("phone_part", str2).putExtra("input_hint", str3).putExtra("is_opened_from_phone_list", z);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…T, isOpenedFromPhoneList)");
        return putExtra;
    }

    public static /* synthetic */ Intent createPhoneProvingActivityIntent$default(Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "-- --";
        }
        return createPhoneProvingActivityIntent(context, str, str2, str3, z);
    }
}
