package com.avito.android.profile.sessions.info;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "isForPasswordChange", "Landroid/content/Intent;", "createSessionsInfoActivityIntent", "(Landroid/content/Context;Z)Landroid/content/Intent;", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class SessionsInfoActvityKt {
    @NotNull
    public static final Intent createSessionsInfoActivityIntent(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, SessionsInfoActivity.class);
        intent.putExtra("password_change", z);
        return intent;
    }
}
