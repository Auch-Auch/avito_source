package a2.j.b.e.a.h;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.e;
import java.util.Set;
public final class m implements Runnable {
    public final /* synthetic */ Set a;
    public final /* synthetic */ SplitCompat b;

    public m(SplitCompat splitCompat, Set set) {
        this.b = splitCompat;
        this.a = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            for (String str : this.a) {
                e.c(this.b.a.b(str));
            }
        } catch (Exception unused) {
        }
    }
}
