package com.avito.android.authorization.login_suggests;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "createLoginSuggestsActivityIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class LoginSuggestsActivityKt {
    @NotNull
    public static final Intent createLoginSuggestsActivityIntent(@NotNull Context context) {
        return a.X0(context, "context", context, LoginSuggestsActivity.class);
    }
}
