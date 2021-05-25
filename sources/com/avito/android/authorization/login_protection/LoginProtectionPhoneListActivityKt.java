package com.avito.android.authorization.login_protection;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a?\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "", "login", "", "phones", "challengeId", "", "isAntihackMode", "Landroid/content/Intent;", "createLoginProtectionPhoneListActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)Landroid/content/Intent;", "EXTRA_IS_ANTIHACK_MODE", "Ljava/lang/String;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class LoginProtectionPhoneListActivityKt {
    @NotNull
    public static final String EXTRA_IS_ANTIHACK_MODE = "is_antihack_mode";

    @NotNull
    public static final Intent createLoginProtectionPhoneListActivityIntent(@NotNull Context context, @Nullable String str, @NotNull List<String> list, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "phones");
        Intent intent = new Intent(context, LoginProtectionPhoneListActivity.class);
        intent.putExtra("extra_phones", new ArrayList(list));
        intent.putExtra("challenge_id", str2);
        intent.putExtra(EXTRA_IS_ANTIHACK_MODE, z);
        intent.putExtra("login", str);
        return intent;
    }
}
