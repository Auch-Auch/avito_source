package a2.a.a.v;

import com.avito.android.bottom_navigation.BottomNavigationController;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
public final class b implements Runnable {
    public final /* synthetic */ BottomNavigationController a;
    public final /* synthetic */ NavigationTabSetItem b;

    public b(BottomNavigationController bottomNavigationController, NavigationTabSetItem navigationTabSetItem) {
        this.a = bottomNavigationController;
        this.b = navigationTabSetItem;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.i.navigationStateIsAvailable(this.b)) {
            NavigationState currentState = this.a.i.currentState(this.b);
            this.a.h.setVisible(currentState != null ? currentState.getShowNavigation() : true);
        }
    }
}
