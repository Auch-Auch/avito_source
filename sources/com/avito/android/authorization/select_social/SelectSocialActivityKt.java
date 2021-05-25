package com.avito.android.authorization.select_social;

import android.content.Context;
import android.content.Intent;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.login.di.LoginModule;
import com.avito.android.remote.model.registration.ProfileSocial;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a9\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "socialList", "", "suggestKey", "createSelectSocialActivityIntent", "(Landroid/content/Context;Landroid/content/Intent;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class SelectSocialActivityKt {
    @NotNull
    public static final Intent createSelectSocialActivityIntent(@NotNull Context context, @NotNull Intent intent, @NotNull List<ProfileSocial> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(list, "socialList");
        Intent putExtra = AuthParamsKt.putIntent(new Intent(context, SelectSocialActivity.class), intent).putParcelableArrayListExtra("social", new ArrayList<>(list)).putExtra(LoginModule.SUGGEST_KEY, str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…_SUGGEST_KEY, suggestKey)");
        return putExtra;
    }

    public static /* synthetic */ Intent createSelectSocialActivityIntent$default(Context context, Intent intent, List list, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        return createSelectSocialActivityIntent(context, intent, list, str);
    }
}
