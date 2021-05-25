package com.avito.android.screen_opener;

import android.content.Context;
import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.util.Intents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "userKey", "contextId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroid/content/Intent;", "createProfileScreenResolverActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "public-profile_release"}, k = 2, mv = {1, 4, 2})
public final class ProfileScreenResolverActivityKt {
    @NotNull
    public static final Intent createProfileScreenResolverActivityIntent(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intent putExtra = new Intent(context, ProfileScreenResolverActivity.class).putExtra("user_key", str).putExtra("context_id", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…RA_CONTEXT_ID, contextId)");
        if (treeClickStreamParent != null) {
            Intents.putTreeAnalyticsParent(putExtra, treeClickStreamParent);
        }
        return putExtra;
    }

    public static /* synthetic */ Intent createProfileScreenResolverActivityIntent$default(Context context, String str, String str2, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            treeClickStreamParent = null;
        }
        return createProfileScreenResolverActivityIntent(context, str, str2, treeClickStreamParent);
    }
}
