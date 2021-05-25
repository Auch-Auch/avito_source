package a2.j.b.e.a.h;

import com.google.android.play.core.splitcompat.l;
import com.google.android.play.core.splitcompat.m;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
public final class e implements h {
    public final /* synthetic */ n a;
    public final /* synthetic */ Set b;
    public final /* synthetic */ AtomicBoolean c;
    public final /* synthetic */ m d;

    public e(m mVar, n nVar, Set set, AtomicBoolean atomicBoolean) {
        this.d = mVar;
        this.a = nVar;
        this.b = set;
        this.c = atomicBoolean;
    }

    @Override // a2.j.b.e.a.h.h
    public final void a(ZipFile zipFile, Set<l> set) throws IOException {
        m mVar = this.d;
        n nVar = this.a;
        d dVar = new d(this);
        Pattern pattern = m.c;
        mVar.c(nVar, set, dVar);
    }
}
