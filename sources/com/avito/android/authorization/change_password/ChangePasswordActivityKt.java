package com.avito.android.authorization.change_password;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "", "login", "hash", "source", "Landroid/content/Intent;", "createChangePasswordActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class ChangePasswordActivityKt {
    @NotNull
    public static final Intent createChangePasswordActivityIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intent putExtra = AuthParamsKt.putLogin(AuthParamsKt.putHash(new Intent(context, ChangePasswordActivity.class), str2), str).putExtra("source", str3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…Extra(KEY_SOURCE, source)");
        return putExtra;
    }
}
