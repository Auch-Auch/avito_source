package com.avito.android.authorization.login;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.login.di.LoginModule;
import com.avito.android.util.preferences.Preference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aU\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "login", Preference.PASSWORD, "", "isHiddenLogin", "suggestKey", "skipSavedLogin", "createLoginIntent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class LoginActivityKt {
    @NotNull
    public static final Intent createLoginIntent(@NotNull Context context, @NotNull Intent intent, @Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intent putExtra = AuthParamsKt.putLogin(new Intent(context, LoginActivity.class), str).putExtra(Preference.PASSWORD, str2).putExtra("is_hidden_login", z).putExtra(LoginModule.SUGGEST_KEY, str3).putExtra("skip_saved_login", z2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ED_LOGIN, skipSavedLogin)");
        return AuthParamsKt.putIntent(putExtra, intent);
    }

    public static /* synthetic */ Intent createLoginIntent$default(Context context, Intent intent, String str, String str2, boolean z, String str3, boolean z2, int i, Object obj) {
        String str4 = null;
        String str5 = (i & 4) != 0 ? null : str;
        String str6 = (i & 8) != 0 ? null : str2;
        boolean z3 = false;
        boolean z4 = (i & 16) != 0 ? false : z;
        if ((i & 32) == 0) {
            str4 = str3;
        }
        if ((i & 64) == 0) {
            z3 = z2;
        }
        return createLoginIntent(context, intent, str5, str6, z4, str4, z3);
    }
}
