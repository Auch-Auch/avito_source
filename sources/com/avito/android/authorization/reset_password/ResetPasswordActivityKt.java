package com.avito.android.authorization.reset_password;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "login", "", "skipLoginEntry", "src", "Landroid/content/Intent;", "createResetPasswordIntent", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class ResetPasswordActivityKt {
    @NotNull
    public static final Intent createResetPasswordIntent(@NotNull Context context, @Nullable String str, boolean z, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = AuthParamsKt.putLogin(new Intent(context, ResetPasswordActivity.class), str).putExtra("src", str2).putExtra("skipLoginEntry", z);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…IN_ENTRY, skipLoginEntry)");
        return putExtra;
    }

    public static /* synthetic */ Intent createResetPasswordIntent$default(Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return createResetPasswordIntent(context, str, z, str2);
    }
}
