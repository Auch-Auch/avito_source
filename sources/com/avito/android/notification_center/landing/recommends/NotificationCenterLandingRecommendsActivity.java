package com.avito.android.notification_center.landing.recommends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.landing.recommends.di.DaggerNotificationCenterLandingRecommendsActivityComponent;
import com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewFragmentKt;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewRouter;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragmentKt;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListRouter;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.ui.activity.BaseActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b#\u0010\u0013J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListRouter;", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", ContextActionHandler.MethodCall.REACTION, "openReviewListScreen", "(I)V", "closeScreen", "()V", "", "title", "showReview", "(Ljava/lang/String;)V", "backToRecommends", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "k", "Ljava/lang/String;", "id", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsActivity extends BaseActivity implements NotificationCenterLandingRecommendsRouter, NcRecommendsReviewListRouter, NcRecommendsReviewRouter {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public String k;

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewRouter
    public void backToRecommends() {
        getSupportFragmentManager().popBackStack((String) null, 1);
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsRouter, com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListRouter, com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewRouter
    public void closeScreen() {
        onBackPressed();
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerNotificationCenterLandingRecommendsActivityComponent.builder().dependencies((NotificationCenterLandingRecommendsDependencies) ComponentDependenciesKt.getDependencies(NotificationCenterLandingRecommendsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        String stringExtra = getIntent().getStringExtra("key_id");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_ID)");
        this.k = stringExtra;
        if (bundle == null) {
            if (stringExtra == null) {
                Intrinsics.throwUninitializedPropertyAccessException("id");
            }
            getSupportFragmentManager().beginTransaction().add(16908290, NotificationCenterLandingRecommendsFragmentKt.createNotificationCenterLandingRecommendsFragment(stringExtra)).commit();
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsRouter
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsRouter
    public void openReviewListScreen(int i) {
        String str = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("id");
        }
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(16908290, NcRecommendsReviewListFragmentKt.createNcRecommendsReviewListFragment(str, i)).commitAllowingStateLoss();
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListRouter
    public void showReview(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        String str2 = this.k;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("id");
        }
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(16908290, NcRecommendsReviewFragmentKt.createNcRecommendsReviewFragment(str2, str)).commitAllowingStateLoss();
    }
}
