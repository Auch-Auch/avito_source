package l6.b.a;

import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
public class j implements ContentFrameLayout.OnAttachListener {
    public final /* synthetic */ AppCompatDelegateImpl a;

    public j(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public void onAttachedFromWindow() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public void onDetachedFromWindow() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        DecorContentParent decorContentParent = appCompatDelegateImpl.l;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (appCompatDelegateImpl.q != null) {
            appCompatDelegateImpl.f.getDecorView().removeCallbacks(appCompatDelegateImpl.r);
            if (appCompatDelegateImpl.q.isShowing()) {
                try {
                    appCompatDelegateImpl.q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            appCompatDelegateImpl.q = null;
        }
        appCompatDelegateImpl.j();
        MenuBuilder menuBuilder = appCompatDelegateImpl.p(0).h;
        if (menuBuilder != null) {
            menuBuilder.close();
        }
    }
}
