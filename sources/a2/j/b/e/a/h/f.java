package a2.j.b.e.a.h;

import com.google.android.play.core.splitcompat.l;
import com.google.android.play.core.splitcompat.m;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
public final class f implements h {
    public final /* synthetic */ Set a;
    public final /* synthetic */ n b;
    public final /* synthetic */ m c;

    public f(m mVar, Set set, n nVar) {
        this.c = mVar;
        this.a = set;
        this.b = nVar;
    }

    @Override // a2.j.b.e.a.h.h
    public final void a(ZipFile zipFile, Set<l> set) throws IOException {
        Set set2 = this.a;
        m mVar = this.c;
        n nVar = this.b;
        Pattern pattern = m.c;
        HashSet hashSet = new HashSet();
        mVar.c(nVar, set, new g(hashSet, nVar, zipFile));
        set2.addAll(hashSet);
    }
}
