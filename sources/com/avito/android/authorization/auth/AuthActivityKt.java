package com.avito.android.authorization.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.avito.android.authorization.AuthParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "src", "Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "createAuthIntent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class AuthActivityKt {
    @NotNull
    public static final Intent createAuthIntent(@NotNull Context context, @Nullable Intent intent, @Nullable String str, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = AuthParamsKt.putIntent(new Intent(context, AuthActivity.class), intent).putExtra("src", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…  .putExtra(KEY_SRC, src)");
        return AuthParamsKt.putSuccessAuthResultData(putExtra, parcelable);
    }

    public static /* synthetic */ Intent createAuthIntent$default(Context context, Intent intent, String str, Parcelable parcelable, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            parcelable = null;
        }
        return createAuthIntent(context, intent, str, parcelable);
    }
}
