package a2.a.a.i3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.header.CardState;
import com.avito.android.user_adverts.root_screen.adverts_host.header.MenuPanelState;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView;
public final class e<T> implements Observer<MenuPanelState> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public e(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(MenuPanelState menuPanelState) {
        MenuPanelState menuPanelState2 = menuPanelState;
        if (menuPanelState2 instanceof MenuPanelState.OneRowTwoCards) {
            UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a).hideTopCardContent();
            UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a).animateOrdersToParentWidth(true);
            MenuPanelState.OneRowTwoCards oneRowTwoCards = (MenuPanelState.OneRowTwoCards) menuPanelState2;
            UserAdvertsHostFragment.access$setLeftCardState(this.a, oneRowTwoCards.getLeftCard());
            UserAdvertsHostFragment.access$setRightCardState(this.a, oneRowTwoCards.getRightCard());
            return;
        }
        CardState.Loaded loaded = null;
        if (menuPanelState2 instanceof MenuPanelState.OneRowFullWidth) {
            UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a).hideTopCardContent();
            ProfileHeaderMenuPanelView.DefaultImpls.animateOrdersToParentWidth$default(UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a), false, 1, null);
            UserAdvertsHostFragment.access$setRightCardState(this.a, ((MenuPanelState.OneRowFullWidth) menuPanelState2).getData());
        } else if (menuPanelState2 instanceof MenuPanelState.TwoRows) {
            UserAdvertsHostFragment.access$getProfileHeaderView$p(this.a).animateOrdersToParentWidth(true);
            MenuPanelState.TwoRows twoRows = (MenuPanelState.TwoRows) menuPanelState2;
            CardState topCard = twoRows.getTopCard();
            if (topCard instanceof CardState.Loaded) {
                loaded = topCard;
            }
            CardState.Loaded loaded2 = loaded;
            if (loaded2 != null) {
                UserAdvertsHostFragment.access$setTopCardState(this.a, loaded2);
            }
            UserAdvertsHostFragment.access$setLeftCardState(this.a, twoRows.getLeftCard());
            UserAdvertsHostFragment.access$setRightCardState(this.a, twoRows.getRightCard());
        }
    }
}
