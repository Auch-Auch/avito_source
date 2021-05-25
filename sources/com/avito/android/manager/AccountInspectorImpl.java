package com.avito.android.manager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.LastUserStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ExceptionEvent;
import com.avito.android.app.ActivityProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.BuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/manager/AccountInspectorImpl;", "Lcom/avito/android/manager/AccountInspector;", "", ChannelContext.Item.USER_ID, "", "onUserLogged", "(Ljava/lang/String;)V", "Lcom/avito/android/account/LastUserStorage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/LastUserStorage;", "lastUserStorage", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/ActivityIntentFactory;", "e", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/app/ActivityProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/app/ActivityProvider;", "activityProvider", "Lcom/avito/android/util/BuildInfo;", "d", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/account/LastUserStorage;Lcom/avito/android/app/ActivityProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/ActivityIntentFactory;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class AccountInspectorImpl implements AccountInspector {
    public final LastUserStorage a;
    public final ActivityProvider b;
    public final Analytics c;
    public final BuildInfo d;
    public final ActivityIntentFactory e;

    public AccountInspectorImpl(@NotNull LastUserStorage lastUserStorage, @NotNull ActivityProvider activityProvider, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(lastUserStorage, "lastUserStorage");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        this.a = lastUserStorage;
        this.b = activityProvider;
        this.c = analytics;
        this.d = buildInfo;
        this.e = activityIntentFactory;
    }

    @Override // com.avito.android.account.AccountUpdateInteractor.UserLoggedListener
    public void onUserLogged(@NotNull String str) {
        Activity activity;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        String userId = this.a.getUserId();
        if (!(userId == null) && (!Intrinsics.areEqual(userId, str)) && (activity = this.b.get()) != null) {
            Intent flags = this.e.homeIntent().setFlags(603979776);
            Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.ho…FLAG_ACTIVITY_SINGLE_TOP)");
            Intent profilePreviewIntent = this.e.profilePreviewIntent();
            try {
                activity.startActivities(new Intent[]{flags, profilePreviewIntent});
            } catch (Throwable th) {
                if (!this.d.isDebug()) {
                    this.c.track(new ExceptionEvent(th, null, 2, null));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Can't start ");
                sb.append(profilePreviewIntent);
                sb.append(" from ");
                ComponentName componentName = activity.getComponentName();
                Intrinsics.checkNotNullExpressionValue(componentName, "activity.componentName");
                sb.append(componentName.getClassName());
                throw new IllegalStateException(sb.toString());
            }
        }
    }
}
