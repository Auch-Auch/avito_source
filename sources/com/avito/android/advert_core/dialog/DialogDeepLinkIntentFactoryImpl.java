package com.avito.android.advert_core.dialog;

import android.app.Application;
import android.content.Intent;
import com.avito.android.DialogDeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DialogDeepLink;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_core/dialog/DialogDeepLinkIntentFactoryImpl;", "Lcom/avito/android/DialogDeepLinkIntentFactory;", "Lcom/avito/android/deep_linking/links/DialogDeepLink;", "deepLink", "Landroid/content/Intent;", "createDialogIntent", "(Lcom/avito/android/deep_linking/links/DialogDeepLink;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class DialogDeepLinkIntentFactoryImpl implements DialogDeepLinkIntentFactory {
    public final Application a;

    @Inject
    public DialogDeepLinkIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "app");
        this.a = application;
    }

    @Override // com.avito.android.DialogDeepLinkIntentFactory
    @NotNull
    public Intent createDialogIntent(@NotNull DialogDeepLink dialogDeepLink) {
        Intrinsics.checkNotNullParameter(dialogDeepLink, "deepLink");
        return DialogDeepLinkActivity.Companion.createIntent(this.a, dialogDeepLink);
    }
}
