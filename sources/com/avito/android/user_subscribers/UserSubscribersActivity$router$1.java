package com.avito.android.user_subscribers;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.user_subscribers.UserSubscribersPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/user_subscribers/UserSubscribersActivity$router$1", "Lcom/avito/android/user_subscribers/UserSubscribersPresenter$Router;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersActivity$router$1 implements UserSubscribersPresenter.Router {
    public final /* synthetic */ UserSubscribersActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public UserSubscribersActivity$router$1(UserSubscribersActivity userSubscribersActivity) {
        this.a = userSubscribersActivity;
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.a.getDeepLinkIntentFactory().getIntent(deepLink);
        if (intent != null) {
            this.a.startActivityForResult(intent, 1);
        }
    }
}
