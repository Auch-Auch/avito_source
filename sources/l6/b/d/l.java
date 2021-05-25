package l6.b.d;

import android.view.View;
import androidx.appcompat.widget.ListPopupWindow;
public class l implements Runnable {
    public final /* synthetic */ ListPopupWindow a;

    public l(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        View anchorView = this.a.getAnchorView();
        if (anchorView != null && anchorView.getWindowToken() != null) {
            this.a.show();
        }
    }
}
