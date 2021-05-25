package com.avito.android.authorization.complete_registration;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a/\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "login", "hash", "createCompleteRegistrationActivityIntent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class CompleteRegistrationActivityKt {
    @NotNull
    public static final Intent createCompleteRegistrationActivityIntent(@NotNull Context context, @NotNull Intent intent, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        return AuthParamsKt.putHash(AuthParamsKt.putLogin(AuthParamsKt.putIntent(new Intent(context, CompleteRegistrationActivity.class), intent), str), str2);
    }
}
