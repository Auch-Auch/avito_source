package com.avito.android.remote.notification.deep_link;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.CalledFrom;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.app.task.DeepLinkProxyComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.remote.notification.NotificationIdentifier;
import com.avito.android.remote.notification.deep_link.di.DaggerNotificationDeepLinkComponent;
import com.avito.android.remote.notification.deep_link.di.NotificationDeepLinkDependencies;
import com.avito.android.ui_components.R;
import com.avito.android.util.Intents;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkActivity;", "Landroid/app/Activity;", "Lcom/avito/android/app/task/DeepLinkProxyComponent;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "targetDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenter;", "presenter", "Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenter;", "getPresenter", "()Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenter;", "setPresenter", "(Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "()V", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationDeepLinkActivity extends Activity implements DeepLinkProxyComponent {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public NotificationDeepLinkPresenter presenter;

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final NotificationDeepLinkPresenter getPresenter() {
        NotificationDeepLinkPresenter notificationDeepLinkPresenter = this.presenter;
        if (notificationDeepLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationDeepLinkPresenter;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LastClick.Updater.updateFromDeeplink();
        DaggerNotificationDeepLinkComponent.builder().dependencies((NotificationDeepLinkDependencies) ComponentDependenciesKt.getDependencies(NotificationDeepLinkDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withRouter(new NotificationDeepLinkRouter() { // from class: com.avito.android.remote.notification.deep_link.NotificationDeepLinkActivity$createRouter$1
            @Override // com.avito.android.remote.notification.deep_link.NotificationDeepLinkRouter
            public void closeScreen() {
                NotificationDeepLinkActivity.this.finish();
            }

            @Override // com.avito.android.remote.notification.deep_link.NotificationDeepLinkRouter
            public boolean openDeepLink(@NotNull DeepLink deepLink, @NotNull CalledFrom.Push push) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                Intrinsics.checkNotNullParameter(push, "calledFrom");
                Intent intent = NotificationDeepLinkActivity.this.getDeepLinkIntentFactory().getIntent(deepLink);
                if (intent == null) {
                    return false;
                }
                Intents.setCalledFrom(intent, push);
                try {
                    NotificationDeepLinkActivity.this.startActivity(IntentsKt.makeSafeForExternalApps(intent));
                    return true;
                } catch (Exception unused) {
                    ToastsKt.showToast$default(NotificationDeepLinkActivity.this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
                    return false;
                }
            }

            @Override // com.avito.android.remote.notification.deep_link.NotificationDeepLinkRouter
            public void openPromoScreen(@NotNull Uri uri, @NotNull CalledFrom.Push push) {
                Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                Intrinsics.checkNotNullParameter(push, "calledFrom");
                Intent promoIntent = NotificationDeepLinkActivity.this.getActivityIntentFactory().promoIntent(uri, push);
                Intents.setCalledFrom(promoIntent, push);
                NotificationDeepLinkActivity.this.startActivity(promoIntent);
            }
        }).build().inject(this);
        Intent intent = getIntent();
        DeepLink targetDeepLink = targetDeepLink();
        NotificationIdentifier notificationIdentifier = (NotificationIdentifier) intent.getParcelableExtra("key_identifier");
        Payload payload = (Payload) intent.getParcelableExtra("key_payload");
        AnalyticParams analyticParams = (AnalyticParams) intent.getParcelableExtra("key_analytics");
        NotificationDeepLinkPresenter notificationDeepLinkPresenter = this.presenter;
        if (notificationDeepLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationDeepLinkPresenter.start(targetDeepLink, notificationIdentifier, payload, analyticParams);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull NotificationDeepLinkPresenter notificationDeepLinkPresenter) {
        Intrinsics.checkNotNullParameter(notificationDeepLinkPresenter, "<set-?>");
        this.presenter = notificationDeepLinkPresenter;
    }

    @Override // com.avito.android.app.task.DeepLinkProxyComponent
    @Nullable
    public DeepLink targetDeepLink() {
        try {
            return (DeepLink) getIntent().getParcelableExtra("key_deep_link");
        } catch (Throwable th) {
            NonFatalError nonFatalError = new NonFatalError(a.c3("Bad deep link: ", getIntent().getStringExtra("key_deep_link_uri")), th, null, 4, null);
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(nonFatalError);
            return null;
        }
    }
}
