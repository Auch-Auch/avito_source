package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l6.a.a;
public abstract class OnBackPressedCallback {
    public boolean a;
    public CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    public OnBackPressedCallback(boolean z) {
        this.a = z;
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.a;
    }

    @MainThread
    public final void remove() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.a = z;
    }
}
