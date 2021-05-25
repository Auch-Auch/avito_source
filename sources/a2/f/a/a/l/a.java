package a2.f.a.a.l;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class a {
    public static SparseArray<Bundle> a = new SparseArray<>();

    public static synchronized void a(int i) {
        synchronized (a.class) {
            a.remove(i);
        }
    }
}
