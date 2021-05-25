package com.avito.android.profile_phones.phone_management;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "", "phone", "", "verified", "", "itemsCount", "fromProfile", "source", "Landroid/content/Intent;", "createPhoneManagementActivityIntent", "(Landroid/content/Context;Ljava/lang/String;ZIZLjava/lang/String;)Landroid/content/Intent;", "profile-phones_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneManagementActivityKt {
    @NotNull
    public static final Intent createPhoneManagementActivityIntent(@NotNull Context context, @Nullable String str, boolean z, int i, boolean z2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, PhoneManagementActivity.class).putExtra("phone", str).putExtra("verified", z).putExtra("items_count", i).putExtra("from_profile", z2).putExtra("source", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…Extra(KEY_SOURCE, source)");
        return putExtra;
    }
}
