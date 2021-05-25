package com.avito.android.user_advert;

import android.content.Context;
import android.content.Intent;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.advert.MyAdvertDetailsActivityKt;
import com.avito.android.user_advert.advert.MyAdvertPostAction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_advert/UserAdvertIntentFactoryImpl;", "Lcom/avito/android/UserAdvertIntentFactory;", "", "draftId", "Landroid/content/Intent;", "myDraftAdvertDetailsIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "itemId", "statusMessage", "Lcom/avito/android/deep_linking/links/DeepLink;", "invokeActionLink", "", "isNewAdvert", "myAdvertDetailsIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Z)Landroid/content/Intent;", "myAdvertDetailsActivateIntent", "myAdvertDetailsRestoreIntent", "message", "myAdvertDetailsWithMessageIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertIntentFactoryImpl implements UserAdvertIntentFactory {
    public final Context a;

    @Inject
    public UserAdvertIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.UserAdvertIntentFactory
    @NotNull
    public Intent myAdvertDetailsActivateIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return MyAdvertDetailsActivityKt.createMyAdvertDetailsActivity$default(this.a, str, false, MyAdvertPostAction.ACTIVATE, null, null, null, 64, null);
    }

    @Override // com.avito.android.UserAdvertIntentFactory
    @NotNull
    public Intent myAdvertDetailsIntent(@NotNull String str, @Nullable String str2, @Nullable DeepLink deepLink, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return MyAdvertDetailsActivityKt.createMyAdvertDetailsActivity$default(this.a, str, z, MyAdvertPostAction.NONE, str2, deepLink, null, 64, null);
    }

    @Override // com.avito.android.UserAdvertIntentFactory
    @NotNull
    public Intent myAdvertDetailsRestoreIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return MyAdvertDetailsActivityKt.createMyAdvertDetailsActivity$default(this.a, str, false, MyAdvertPostAction.RESTORE, null, null, null, 64, null);
    }

    @Override // com.avito.android.UserAdvertIntentFactory
    @NotNull
    public Intent myAdvertDetailsWithMessageIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "message");
        return MyAdvertDetailsActivityKt.createMyAdvertDetailsActivity$default(this.a, str, false, MyAdvertPostAction.NONE, null, null, str2, 32, null);
    }

    @Override // com.avito.android.UserAdvertIntentFactory
    @NotNull
    public Intent myDraftAdvertDetailsIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        return MyAdvertDetailsActivityKt.createMyDraftAdvertDetailsActivity(this.a, str);
    }
}
