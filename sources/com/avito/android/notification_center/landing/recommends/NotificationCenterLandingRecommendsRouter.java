package com.avito.android.notification_center.landing.recommends;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", ContextActionHandler.MethodCall.REACTION, "openReviewListScreen", "(I)V", "closeScreen", "()V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingRecommendsRouter {
    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListRouter, com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewRouter
    void closeScreen();

    void openDeepLink(@NotNull DeepLink deepLink);

    void openReviewListScreen(int i);
}
