package a2.j.b.b.u0.k;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
public abstract class h {
    public final d a = new d();
    public TrackOutput b;
    public ExtractorOutput c;
    public f d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    @Nullable
    public b j;
    public long k;
    public boolean l;
    public boolean m;

    public static class b {
        public Format a;
        public f b;
    }

    public static final class c implements f {
        public c(a aVar) {
        }

        @Override // a2.j.b.b.u0.k.f
        public SeekMap a() {
            return new SeekMap.Unseekable(C.TIME_UNSET);
        }

        @Override // a2.j.b.b.u0.k.f
        public void b(long j) {
        }

        @Override // a2.j.b.b.u0.k.f
        public long read(ExtractorInput extractorInput) {
            return -1;
        }
    }

    public long a(long j2) {
        return (((long) this.i) * j2) / 1000000;
    }

    public void b(long j2) {
        this.g = j2;
    }

    public abstract long c(ParsableByteArray parsableByteArray);

    public abstract boolean d(ParsableByteArray parsableByteArray, long j2, b bVar) throws IOException;

    public void e(boolean z) {
        if (z) {
            this.j = new b();
            this.f = 0;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1;
        this.g = 0;
    }
}
