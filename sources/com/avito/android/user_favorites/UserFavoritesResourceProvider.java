package com.avito.android.user_favorites;

import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractorImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;", "", "", "favoriteItems", "()Ljava/lang/String;", "searchSubscriptions", FavoriteSellersReadInteractorImpl.TYPE, "", "cartFabListBottomPadding", "()I", "viewedItems", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public interface UserFavoritesResourceProvider {
    int cartFabListBottomPadding();

    @NotNull
    String favoriteItems();

    @NotNull
    String favoriteSellers();

    @NotNull
    String searchSubscriptions();

    @NotNull
    String viewedItems();
}
