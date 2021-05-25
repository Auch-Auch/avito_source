package com.avito.android.safedeal.delivery_type;

import android.content.Intent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouterImpl;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;", "", "closeScreen", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showAuthScreen", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragmentDelegate;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragmentDelegate;", "fragmentDelegate", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragmentDelegate;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeRouterImpl implements DeliveryTypeRouter {
    public final DeepLinkIntentFactory a;
    public final DeliveryTypeFragmentDelegate b;

    public DeliveryTypeRouterImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull DeliveryTypeFragmentDelegate deliveryTypeFragmentDelegate) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(deliveryTypeFragmentDelegate, "fragmentDelegate");
        this.a = deepLinkIntentFactory;
        this.b = deliveryTypeFragmentDelegate;
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeRouter
    public void closeScreen() {
        this.b.closeScreen();
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeRouter
    public void followDeepLink(@Nullable DeepLink deepLink) {
        Intent intent;
        if (deepLink != null && (intent = this.a.getIntent(deepLink)) != null) {
            this.b.launchActivity(intent);
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypeRouter
    public void showAuthScreen() {
        this.b.showAuthScreen();
    }
}
