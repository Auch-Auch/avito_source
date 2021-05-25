package com.avito.android.deep_linking;

import android.content.Context;
import android.content.Intent;
import com.avito.android.DeepLinkingIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkingIntentFactoryImpl;", "Lcom/avito/android/DeepLinkingIntentFactory;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Landroid/content/Intent;", "appShortcutsDeepLinkIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/DeepLinkContainer;", "container", "containerDeeplinkIntent", "(Lcom/avito/android/deep_linking/links/DeepLinkContainer;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkingIntentFactoryImpl implements DeepLinkingIntentFactory {
    public final Context a;

    @Inject
    public DeepLinkingIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.DeepLinkingIntentFactory
    @NotNull
    public Intent appShortcutsDeepLinkIntent(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return AppShortcutsDeepLinkActivityKt.createAppShortcutsDeepLinkActivityIntent(this.a, deepLink);
    }

    @Override // com.avito.android.DeepLinkingIntentFactory
    @NotNull
    public Intent containerDeeplinkIntent(@NotNull DeepLinkContainer deepLinkContainer) {
        Intrinsics.checkNotNullParameter(deepLinkContainer, "container");
        return DeepLinkingActivityKt.createDeeplinkContainerHandlingIntent(this.a, deepLinkContainer);
    }
}
