package a2.a.a.v;

import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.BottomNavigationController;
public final class a implements Runnable {
    public final /* synthetic */ BottomNavigationController a;
    public final /* synthetic */ AddButtonState b;

    public a(BottomNavigationController bottomNavigationController, AddButtonState addButtonState) {
        this.a = bottomNavigationController;
        this.b = addButtonState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h.setAddButtonState(this.b);
    }
}
