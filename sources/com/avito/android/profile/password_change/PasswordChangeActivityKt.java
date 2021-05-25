package com.avito.android.profile.password_change;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "", "isSessionsFlow", "", "source", "login", "loginType", "sessionIdHash", "deviceId", ChannelContext.Item.USER_ID, "Landroid/content/Intent;", "createPasswordChangeActivity", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class PasswordChangeActivityKt {
    @NotNull
    public static final Intent createPasswordChangeActivity(@NotNull Context context, boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, PasswordChangeActivity.class);
        intent.putExtra("is_sessions_flow", z);
        intent.putExtra("extra_source", str);
        intent.putExtra("extra_login", str2);
        intent.putExtra("extra_login_type", str3);
        intent.putExtra("extra_session_id_hash", str4);
        intent.putExtra("extra_device_id", str5);
        intent.putExtra("extra_user_id", str6);
        return intent;
    }

    public static /* synthetic */ Intent createPasswordChangeActivity$default(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        String str7 = null;
        String str8 = (i & 4) != 0 ? null : str;
        String str9 = (i & 8) != 0 ? null : str2;
        String str10 = (i & 16) != 0 ? null : str3;
        String str11 = (i & 32) != 0 ? null : str4;
        String str12 = (i & 64) != 0 ? null : str5;
        if ((i & 128) == 0) {
            str7 = str6;
        }
        return createPasswordChangeActivity(context, z, str8, str9, str10, str11, str12, str7);
    }
}
