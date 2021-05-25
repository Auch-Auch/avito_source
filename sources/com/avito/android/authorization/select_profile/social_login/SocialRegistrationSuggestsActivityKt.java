package com.avito.android.authorization.select_profile.social_login;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.social.SocialActivity;
import com.avito.android.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001aC\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "title", "suggestKey", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "socialType", "createSocialRegistrationSuggestsIntent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class SocialRegistrationSuggestsActivityKt {
    @NotNull
    public static final Intent createSocialRegistrationSuggestsIntent(@NotNull Context context, @NotNull Intent intent, @NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "suggestKey");
        Intrinsics.checkNotNullParameter(list, "profiles");
        Intrinsics.checkNotNullParameter(str3, "socialType");
        Intent intent2 = new Intent(context, SocialRegistrationSuggestsActivity.class);
        AuthParamsKt.putIntent(intent2, intent);
        intent2.putExtra("extra_title", str);
        intent2.putExtra("extra_suggest_key", str2);
        intent2.putParcelableArrayListExtra("extra_profiles", Collections.asArrayList(list));
        intent2.putExtra(SocialActivity.EXTRA_SOCIAL_TYPE, str3);
        return intent2;
    }
}
