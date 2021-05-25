package a2.j.b.e.a.h;

import com.google.android.play.core.splitcompat.SplitCompat;
public final class l implements Runnable {
    public final /* synthetic */ SplitCompat a;

    public l(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a.a();
        } catch (Exception unused) {
        }
    }
}
