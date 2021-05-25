package com.avito.android.shop.detailed.item;

import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.component.search.SearchBar;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.lib.design.snackbar.util.SnackbarElementView;
import com.avito.android.public_profile.ui.SubscriptionsContainerView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0015J%\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\tJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/component/search/SearchBar;", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;", "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "", "showLoading", "()V", "hideLoading", "showRetryOverlay", "", "message", "showNotFoundError", "(Ljava/lang/String;)V", "onDataSourceChanged", "showCallButton", "", "count", "setColumnsCount", "(I)V", VKApiConst.POSITION, "scrollToPosition", "phone", "Lkotlin/Function0;", "handler", "addPhoneToDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showPhoneDialog", "closePhoneDialog", "showMessage", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopDetailedRedesignView extends FavoriteAdvertsView, SearchBar, ErrorMessageView, ViewedAdvertsView, SubscriptionsContainerView, SnackbarElementView {
    void addPhoneToDialog(@NotNull String str, @NotNull Function0<Unit> function0);

    void closePhoneDialog();

    void hideLoading();

    void onDataSourceChanged();

    void scrollToPosition(int i);

    void setColumnsCount(int i);

    void showCallButton();

    void showLoading();

    void showMessage(@NotNull String str);

    void showNotFoundError(@NotNull String str);

    void showPhoneDialog();

    void showRetryOverlay();
}
