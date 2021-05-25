package com.avito.android.remote.interceptors;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.app.ActivityProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/interceptors/FirewallErrorRouterImpl;", "Lcom/avito/android/remote/interceptors/FirewallErrorRouter;", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "", "followDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Lcom/avito/android/app/ActivityProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/app/ActivityProvider;", "activityProvider", "<init>", "(Lcom/avito/android/app/ActivityProvider;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class FirewallErrorRouterImpl implements FirewallErrorRouter {
    public final ActivityProvider a;
    public final DeepLinkIntentFactory b;

    public static final class a implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Intent b;

        public a(Activity activity, Intent intent) {
            this.a = activity;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.startActivity(this.b);
        }
    }

    public FirewallErrorRouterImpl(@NotNull ActivityProvider activityProvider, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "intentFactory");
        this.a = activityProvider;
        this.b = deepLinkIntentFactory;
    }

    @Override // com.avito.android.remote.interceptors.FirewallErrorRouter
    public void followDeeplink(@NotNull DeepLink deepLink) {
        Intent intent;
        Intrinsics.checkNotNullParameter(deepLink, "link");
        Activity activity = this.a.get();
        if (activity != null && (intent = this.b.getIntent(deepLink)) != null) {
            activity.runOnUiThread(new a(activity, intent));
        }
    }
}
