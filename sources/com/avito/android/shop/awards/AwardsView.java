package com.avito.android.shop.awards;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/shop/awards/AwardsView;", "Lru/avito/component/appbar/AppBar;", "", "showLoading", "()V", "hideLoading", "showContent", "showRetryOverlay", "", "error", "showError", "(Ljava/lang/String;)V", "showShopNotFoundError", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface AwardsView extends AppBar {
    void hideLoading();

    void showContent();

    void showError(@NotNull String str);

    void showLoading();

    void showRetryOverlay();

    void showShopNotFoundError(@NotNull String str);
}
