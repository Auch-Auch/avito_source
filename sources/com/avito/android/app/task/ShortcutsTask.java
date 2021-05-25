package com.avito.android.app.task;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.application.R;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.deep_linking.links.ChannelsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.FavoritesLink;
import com.avito.android.deep_linking.links.StartPublishFromUserAdvertsLink;
import com.avito.android.deep_linking.links.UserAdvertsLink;
import com.avito.android.util.ShortcutInfoFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/app/task/ShortcutsTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Landroid/content/pm/ShortcutManager;", "shortcutManager", "Landroid/content/pm/ShortcutManager;", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "Lcom/avito/android/util/ShortcutInfoFactory;", "shortcutInfoFactory", "Lcom/avito/android/util/ShortcutInfoFactory;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Landroid/content/pm/ShortcutManager;Lcom/avito/android/util/ShortcutInfoFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "application_release"}, k = 1, mv = {1, 4, 2})
@TargetApi(25)
public final class ShortcutsTask implements ApplicationBlockingStartupTask {
    public final Analytics analytics;
    public final ShortcutInfoFactory shortcutInfoFactory;
    public final ShortcutManager shortcutManager;
    public final UserAdvertsTabTestGroup tabTestGroup;

    public ShortcutsTask(@NotNull ShortcutManager shortcutManager2, @NotNull ShortcutInfoFactory shortcutInfoFactory2, @NotNull Analytics analytics2, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(shortcutManager2, "shortcutManager");
        Intrinsics.checkNotNullParameter(shortcutInfoFactory2, "shortcutInfoFactory");
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        this.shortcutManager = shortcutManager2;
        this.shortcutInfoFactory = shortcutInfoFactory2;
        this.analytics = analytics2;
        this.tabTestGroup = userAdvertsTabTestGroup;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0075: APUT  
      (r9v1 android.content.pm.ShortcutInfo[])
      (3 ??[int, float, short, byte, char])
      (wrap: android.content.pm.ShortcutInfo : 0x0071: INVOKE  (r12v3 android.content.pm.ShortcutInfo) = 
      (r1v9 com.avito.android.util.ShortcutInfoFactory)
      (r12v1 android.content.Context)
      ("publication_shortcut_id")
      (r4v4 int)
      (r5v4 int)
      (r2v7 com.avito.android.deep_linking.links.DeepLink)
     type: INTERFACE call: com.avito.android.util.ShortcutInfoFactory.createShortcutInfo(android.content.Context, java.lang.String, int, int, com.avito.android.deep_linking.links.DeepLink):android.content.pm.ShortcutInfo)
     */
    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        DeepLink deepLink;
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Context baseContext = application.getBaseContext();
        try {
            ShortcutManager shortcutManager2 = this.shortcutManager;
            ShortcutInfo[] shortcutInfoArr = new ShortcutInfo[4];
            ShortcutInfoFactory shortcutInfoFactory2 = this.shortcutInfoFactory;
            Intrinsics.checkNotNullExpressionValue(baseContext, "context");
            shortcutInfoArr[0] = shortcutInfoFactory2.createShortcutInfo(baseContext, "user_adverts_shortcut_id", R.string.shortcuts_user_adverts, R.drawable.ic_shortcut_my_items, new UserAdvertsLink(null, 1, null));
            shortcutInfoArr[1] = this.shortcutInfoFactory.createShortcutInfo(baseContext, "channels_shortcut_id", R.string.shortcuts_channels, R.drawable.ic_shortcut_message, new ChannelsLink(null, 1, null));
            shortcutInfoArr[2] = this.shortcutInfoFactory.createShortcutInfo(baseContext, "favorites_shortcut_id", R.string.shortcuts_favorites, R.drawable.ic_shortcut_favorites, new FavoritesLink());
            ShortcutInfoFactory shortcutInfoFactory3 = this.shortcutInfoFactory;
            int i = R.string.shortcuts_publication;
            int i2 = R.drawable.ic_shortcut_add;
            if (this.tabTestGroup.isTest()) {
                deepLink = new StartPublishFromUserAdvertsLink();
            } else {
                deepLink = new AdvertPublicationLink(null, 1, null);
            }
            shortcutInfoArr[3] = shortcutInfoFactory3.createShortcutInfo(baseContext, "publication_shortcut_id", i, i2, deepLink);
            shortcutManager2.setDynamicShortcuts(CollectionsKt__CollectionsKt.listOf((Object[]) shortcutInfoArr));
            return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
        } catch (IllegalStateException e) {
            this.analytics.track(new NonFatalError("MC-15: Launcher activity not found", e, null, 4, null));
            return new ApplicationStartupTask.ExecutionResult.Error(null, e, 1, null);
        }
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
