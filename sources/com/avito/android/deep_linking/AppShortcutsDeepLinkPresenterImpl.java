package com.avito.android.deep_linking;

import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.OpenAndroidShortcutEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/deep_linking/AppShortcutsDeepLinkPresenterImpl;", "Lcom/avito/android/deep_linking/AppShortcutsDeepLinkPresenter;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_START, "(Landroid/net/Uri;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/deep_linking/DeepLinkFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/AppShortcutsDeepLinkRouter;", "c", "Lcom/avito/android/deep_linking/AppShortcutsDeepLinkRouter;", "router", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/deep_linking/AppShortcutsDeepLinkRouter;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppShortcutsDeepLinkPresenterImpl implements AppShortcutsDeepLinkPresenter {
    public final Analytics a;
    public final DeepLinkFactory b;
    public final AppShortcutsDeepLinkRouter c;

    @Inject
    public AppShortcutsDeepLinkPresenterImpl(@NotNull Analytics analytics, @NotNull DeepLinkFactory deepLinkFactory, @NotNull AppShortcutsDeepLinkRouter appShortcutsDeepLinkRouter) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(appShortcutsDeepLinkRouter, "router");
        this.a = analytics;
        this.b = deepLinkFactory;
        this.c = appShortcutsDeepLinkRouter;
    }

    @Override // com.avito.android.deep_linking.AppShortcutsDeepLinkPresenter
    public void start(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.b.createFromUri(uri);
        CalledFrom.AndroidShortcuts androidShortcuts = new CalledFrom.AndroidShortcuts(createFromUri.getPath());
        if (this.c.openDeepLink(createFromUri, androidShortcuts)) {
            this.a.track(new OpenAndroidShortcutEvent(androidShortcuts.getPath()));
        }
        this.c.closeScreen();
    }
}
