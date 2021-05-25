package a2.j.b.b.d1.i;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import java.io.File;
import java.util.regex.Pattern;
public final class i extends CacheSpan {
    public static final Pattern a = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern b = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern c = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public i(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0084, code lost:
        if (r16.renameTo(r1) == false) goto L_0x004b;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a2.j.b.b.d1.i.i a(java.io.File r16, long r17, long r19, a2.j.b.b.d1.i.f r21) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.d1.i.i.a(java.io.File, long, long, a2.j.b.b.d1.i.f):a2.j.b.b.d1.i.i");
    }

    public static File b(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(".");
        sb.append(j);
        sb.append(".");
        return new File(file, a.l(sb, j2, ".v3.exo"));
    }
}
