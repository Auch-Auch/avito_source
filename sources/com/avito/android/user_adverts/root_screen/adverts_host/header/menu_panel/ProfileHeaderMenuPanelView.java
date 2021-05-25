package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import com.avito.android.user_adverts.root_screen.adverts_host.header.CardData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/ProfileHeaderMenuPanelView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersView;", "", "reverse", "", "animateOrdersToParentWidth", "(Z)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "data", "setTopCardData", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "hideTopCardContent", "()V", "", "text", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "onDismissClickTarget", "showTopCardTooltip", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)V", "Lio/reactivex/Observable;", "getTopCardClicks", "()Lio/reactivex/Observable;", "topCardClicks", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileHeaderMenuPanelView extends LeftCardView, OrdersView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void animateOrdersToParentWidth$default(ProfileHeaderMenuPanelView profileHeaderMenuPanelView, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                profileHeaderMenuPanelView.animateOrdersToParentWidth(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateOrdersToParentWidth");
        }
    }

    void animateOrdersToParentWidth(boolean z);

    @NotNull
    Observable<ProfileHeaderView.ClickTarget> getTopCardClicks();

    void hideTopCardContent();

    void setTopCardData(@NotNull CardData cardData);

    void showTopCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget);
}
