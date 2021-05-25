package com.avito.android.contact_access;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", "itemId", "serviceId", "externalId", "Landroid/content/Intent;", "createContactAccessServiceActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_ARGS", "Ljava/lang/String;", "contact-access_release"}, k = 2, mv = {1, 4, 2})
public final class ContactAccessServiceActivityKt {
    @NotNull
    public static final String EXTRA_ARGS = "extra_contact_access_args";

    @NotNull
    public static final Intent createContactAccessServiceActivityIntent(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intent putExtra = new Intent(context, ContactAccessServiceActivity.class).putExtra(EXTRA_ARGS, new ContactAccessServiceArguments(str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(putExtra, "context\n        .createA…, serviceId, externalId))");
        return putExtra;
    }

    public static /* synthetic */ Intent createContactAccessServiceActivityIntent$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return createContactAccessServiceActivityIntent(context, str, str2, str3);
    }
}
