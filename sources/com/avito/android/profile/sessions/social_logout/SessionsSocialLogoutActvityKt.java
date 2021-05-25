package com.avito.android.profile.sessions.social_logout;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.sumsub.sns.core.common.SNSConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", "source", ChannelContext.Item.USER_ID, "loginType", "sessionIdHash", "deviceId", "Landroid/content/Intent;", "createSessionsSocialLogoutActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class SessionsSocialLogoutActvityKt {
    @NotNull
    public static final Intent createSessionsSocialLogoutActivityIntent(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, SessionsSocialLogoutActivity.class);
        intent.putExtra("source", str);
        intent.putExtra("user_id", str2);
        intent.putExtra("login_type", str3);
        intent.putExtra("session_id_hash", str4);
        intent.putExtra(SNSConstants.Preference.KEY_DEVICE_ID, str5);
        return intent;
    }
}
