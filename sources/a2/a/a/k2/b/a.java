package a2.a.a.k2.b;

import android.view.View;
import com.avito.android.util.Views;
public final class a implements Runnable {
    public final /* synthetic */ View a;

    public a(View view) {
        this.a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setAlpha(0.0f);
        Views.show(this.a);
    }
}
