package butterknife.internal;

import android.view.View;
import p6.b.a;
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    public static boolean a = true;

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (a) {
            a = false;
            view.post(a.a);
            doClick(view);
        }
    }
}
