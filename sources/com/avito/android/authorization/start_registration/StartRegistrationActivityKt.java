package com.avito.android.authorization.start_registration;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a)\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "login", "createStartRegistrationActivityIntent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class StartRegistrationActivityKt {
    @NotNull
    public static final Intent createStartRegistrationActivityIntent(@NotNull Context context, @NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        return AuthParamsKt.putIntent(AuthParamsKt.putLogin(new Intent(context, StartRegistrationActivity.class), str), intent);
    }

    public static /* synthetic */ Intent createStartRegistrationActivityIntent$default(Context context, Intent intent, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return createStartRegistrationActivityIntent(context, intent, str);
    }
}
