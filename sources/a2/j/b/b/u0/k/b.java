package a2.j.b.b.u0.k;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public final class b implements f {
    public final e a;
    public final long b;
    public final long c;
    public final h d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* renamed from: a2.j.b.b.u0.k.b$b  reason: collision with other inner class name */
    public final class C0039b implements SeekMap {
        public C0039b(a aVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            b bVar = b.this;
            return (bVar.f * 1000000) / ((long) bVar.d.i);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            b bVar = b.this;
            long j2 = bVar.b;
            long j3 = bVar.c;
            return new SeekMap.SeekPoints(new SeekPoint(j, Util.constrainValue(((((j3 - j2) * ((((long) bVar.d.i) * j) / 1000000)) / bVar.f) + j2) - 30000, j2, j3 - 1)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public b(h hVar, long j2, long j3, long j4, long j5, boolean z) {
        Assertions.checkArgument(j2 >= 0 && j3 > j2);
        this.d = hVar;
        this.b = j2;
        this.c = j3;
        if (j4 == j3 - j2 || z) {
            this.f = j5;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new e();
    }

    @Override // a2.j.b.b.u0.k.f
    @Nullable
    public SeekMap a() {
        if (this.f != 0) {
            return new C0039b(null);
        }
        return null;
    }

    @Override // a2.j.b.b.u0.k.f
    public void b(long j2) {
        this.h = Util.constrainValue(j2, 0, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0;
        this.l = this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    @Override // a2.j.b.b.u0.k.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(com.google.android.exoplayer2.extractor.ExtractorInput r23) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 350
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.u0.k.b.read(com.google.android.exoplayer2.extractor.ExtractorInput):long");
    }
}
