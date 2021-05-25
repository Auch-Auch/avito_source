package a2.j.b.b.u0.h;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mkv.EbmlProcessor;
import java.io.IOException;
import java.util.ArrayDeque;
public final class b implements c {
    public final byte[] a = new byte[8];
    public final ArrayDeque<C0038b> b = new ArrayDeque<>();
    public final e c = new e();
    public EbmlProcessor d;
    public int e;
    public int f;
    public long g;

    /* renamed from: a2.j.b.b.u0.h.b$b  reason: collision with other inner class name */
    public static final class C0038b {
        public final int a;
        public final long b;

        public C0038b(int i, long j, a aVar) {
            this.a = i;
            this.b = j;
        }
    }

    public final long a(ExtractorInput extractorInput, int i) throws IOException {
        extractorInput.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.a[i2] & 255));
        }
        return j;
    }
}
