package com.avito.android.social;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/social/SocialType;", "type", "Landroid/content/Intent;", "createSocialActivityLoginIntent", "(Landroid/content/Context;Lcom/avito/android/social/SocialType;)Landroid/content/Intent;", "createSocialActivityLogoutIntent", "social_release"}, k = 2, mv = {1, 4, 2})
public final class SocialActivityKt {
    @NotNull
    public static final Intent createSocialActivityLoginIntent(@NotNull Context context, @Nullable SocialType socialType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, SocialActivity.class).putExtra(SocialActivity.SOCIAL_TYPE_PARAM, socialType).putExtra("social_action", "login");
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…TION_PARAM, ACTION_LOGIN)");
        return putExtra;
    }

    @NotNull
    public static final Intent createSocialActivityLogoutIntent(@NotNull Context context, @Nullable SocialType socialType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, SocialActivity.class).putExtra(SocialActivity.SOCIAL_TYPE_PARAM, socialType).putExtra("social_action", "logout");
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ION_PARAM, ACTION_LOGOUT)");
        return putExtra;
    }
}
