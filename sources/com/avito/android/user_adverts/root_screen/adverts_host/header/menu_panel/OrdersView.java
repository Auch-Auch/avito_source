package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import com.avito.android.user_adverts.root_screen.adverts_host.header.CardData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersView;", "", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "info", "", "setOrdersInfo", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "setOrdersLoading", "()V", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "getRightCardClicks", "()Lio/reactivex/Observable;", "rightCardClicks", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface OrdersView {
    @NotNull
    Observable<ProfileHeaderView.ClickTarget> getRightCardClicks();

    void setOrdersInfo(@NotNull CardData cardData);

    void setOrdersLoading();
}
