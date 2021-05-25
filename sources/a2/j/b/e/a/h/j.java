package a2.j.b.e.a.h;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.x;
import java.util.HashSet;
import java.util.Set;
public final class j implements x {
    public final /* synthetic */ SplitCompat a;

    public j(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    @Override // com.google.android.play.core.splitinstall.x
    public final Set<String> a() {
        HashSet hashSet;
        SplitCompat splitCompat = this.a;
        synchronized (splitCompat.b) {
            hashSet = new HashSet(splitCompat.b);
        }
        return hashSet;
    }
}
