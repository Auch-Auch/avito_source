package com.avito.android.shop.info;

import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\nJ\u001d\u0010\u0015\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop/info/ShopInfoView;", "Lru/avito/component/appbar/AppBar;", "", "showLoading", "()V", "hideLoading", "showRetryOverlay", "", "error", "showError", "(Ljava/lang/String;)V", "title", "showTitle", MessengerShareContentUtility.SUBTITLE, "showSubtitle", "description", "showDescription", "showShopNotFoundError", "setAwards", "Lkotlin/Function0;", "onClick", "setAwardsOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopInfoView extends AppBar {
    void hideLoading();

    void setAwards(@NotNull String str);

    void setAwardsOnClickListener(@NotNull Function0<Unit> function0);

    void showDescription(@NotNull String str);

    void showError(@NotNull String str);

    void showLoading();

    void showRetryOverlay();

    void showShopNotFoundError(@NotNull String str);

    void showSubtitle(@NotNull String str);

    void showTitle(@NotNull String str);
}
