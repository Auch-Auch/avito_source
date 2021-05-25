package a2.a.a.k2.b;

import android.view.View;
import com.avito.android.util.Views;
public final class b implements Runnable {
    public final /* synthetic */ View a;

    public b(View view) {
        this.a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Views.hide(this.a);
    }
}
