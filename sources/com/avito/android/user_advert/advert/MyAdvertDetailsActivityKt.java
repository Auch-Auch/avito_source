package com.avito.android.user_advert.advert;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroid/content/Context;", "context", "", "draftId", "Landroid/content/Intent;", "createMyDraftAdvertDetailsActivity", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "itemId", "", "isNewAdvert", "Lcom/avito/android/user_advert/advert/MyAdvertPostAction;", "postAction", "statusMessage", "Lcom/avito/android/deep_linking/links/DeepLink;", "invokeActionLink", "instantMessage", "createMyAdvertDetailsActivity", "(Landroid/content/Context;Ljava/lang/String;ZLcom/avito/android/user_advert/advert/MyAdvertPostAction;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)Landroid/content/Intent;", "user-advert_release"}, k = 2, mv = {1, 4, 2})
public final class MyAdvertDetailsActivityKt {
    @NotNull
    public static final Intent createMyAdvertDetailsActivity(@NotNull Context context, @NotNull String str, boolean z, @NotNull MyAdvertPostAction myAdvertPostAction, @Nullable String str2, @Nullable DeepLink deepLink, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(myAdvertPostAction, "postAction");
        boolean z2 = false;
        Intent putExtra = new Intent(context, MyAdvertDetailsActivity.class).putExtra("itemId", str).putExtra("key_open_activate_dialog", myAdvertPostAction == MyAdvertPostAction.ACTIVATE).putExtra("key_is_new_advert", z);
        if (myAdvertPostAction == MyAdvertPostAction.RESTORE) {
            z2 = true;
        }
        Intent putExtra2 = putExtra.putExtra("key_restore_advert", z2).putExtra("status_message", str2).putExtra("key_invoke_action", deepLink).putExtra("key_instant_message", str3).putExtra(Constants.SUPPORTS_NESTED_INTENT, true);
        Intrinsics.checkNotNullExpressionValue(putExtra2, "Intent(context, MyAdvert…ORTS_NESTED_INTENT, true)");
        return putExtra2;
    }

    public static /* synthetic */ Intent createMyAdvertDetailsActivity$default(Context context, String str, boolean z, MyAdvertPostAction myAdvertPostAction, String str2, DeepLink deepLink, String str3, int i, Object obj) {
        return createMyAdvertDetailsActivity(context, str, z, myAdvertPostAction, str2, (i & 32) != 0 ? null : deepLink, (i & 64) != 0 ? null : str3);
    }

    @NotNull
    public static final Intent createMyDraftAdvertDetailsActivity(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, "draftId", context, MyAdvertDetailsActivity.class, "key_draft_id", str, "Intent(context, MyAdvert…ra(KEY_DRAFT_ID, draftId)");
    }
}
