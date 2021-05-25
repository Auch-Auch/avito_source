package com.avito.android.favorite_sellers.action;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/favorite_sellers/action/DeepLinkAction;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkAction implements FavoriteSellersItemAction {
    @NotNull
    public final DeepLink a;

    public DeepLinkAction(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a = deepLink;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.a;
    }
}
