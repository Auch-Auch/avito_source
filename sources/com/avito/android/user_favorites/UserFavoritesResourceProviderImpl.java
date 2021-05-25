package com.avito.android.user_favorites;

import android.content.res.Resources;
import com.avito.android.cart_fab.R;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractorImpl;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesResourceProviderImpl;", "Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;", "", "favoriteItems", "()Ljava/lang/String;", "searchSubscriptions", FavoriteSellersReadInteractorImpl.TYPE, "", "cartFabListBottomPadding", "()I", "viewedItems", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesResourceProviderImpl implements UserFavoritesResourceProvider {
    public final Resources a;

    @Inject
    public UserFavoritesResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.user_favorites.UserFavoritesResourceProvider
    public int cartFabListBottomPadding() {
        return this.a.getDimensionPixelSize(R.dimen.cart_bottom_space_for_list);
    }

    @Override // com.avito.android.user_favorites.UserFavoritesResourceProvider
    @NotNull
    public String favoriteItems() {
        String string = this.a.getString(R.string.favorite_items_tab);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.favorite_items_tab)");
        return string;
    }

    @Override // com.avito.android.user_favorites.UserFavoritesResourceProvider
    @NotNull
    public String favoriteSellers() {
        String string = this.a.getString(R.string.favorite_sellers_tab);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.favorite_sellers_tab)");
        return string;
    }

    @Override // com.avito.android.user_favorites.UserFavoritesResourceProvider
    @NotNull
    public String searchSubscriptions() {
        String string = this.a.getString(R.string.search_subscriptions_tab);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…search_subscriptions_tab)");
        return string;
    }

    @Override // com.avito.android.user_favorites.UserFavoritesResourceProvider
    @NotNull
    public String viewedItems() {
        String string = this.a.getString(R.string.favorite_viewed_items_tab);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…avorite_viewed_items_tab)");
        return string;
    }
}
