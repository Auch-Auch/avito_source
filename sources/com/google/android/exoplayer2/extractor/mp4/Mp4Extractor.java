package com.google.android.exoplayer2.extractor.mp4;

import a2.j.b.b.u0.j.c;
import a2.j.b.b.u0.j.e;
import a2.j.b.b.u0.j.j;
import a2.j.b.b.u0.j.l;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory FACTORY = c.a;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    public final int a;
    public final ParsableByteArray b;
    public final ParsableByteArray c;
    public final ParsableByteArray d;
    public final ParsableByteArray e;
    public final ArrayDeque<e.a> f;
    public int g;
    public int h;
    public long i;
    public int j;
    @Nullable
    public ParsableByteArray k;
    public int l;
    public int m;
    public int n;
    public int o;
    public ExtractorOutput p;
    public a[] q;
    public long[][] r;
    public int s;
    public long t;
    public boolean u;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class a {
        public final Track a;
        public final l b;
        public final TrackOutput c;
        public int d;

        public a(Track track, l lVar, TrackOutput trackOutput) {
            this.a = track;
            this.b = lVar;
            this.c = trackOutput;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    public static long b(l lVar, long j2, long j3) {
        int a3 = lVar.a(j2);
        if (a3 == -1) {
            a3 = lVar.b(j2);
        }
        if (a3 == -1) {
            return j3;
        }
        return Math.min(lVar.c[a3], j3);
    }

    public final void a() {
        this.g = 0;
        this.j = 0;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:284:0x01e0 */
    /* JADX DEBUG: Multi-variable search result rejected for r8v35, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r8v37, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r8v69, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x04f0 A[LOOP:10: B:241:0x04ed->B:243:0x04f0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x050e  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x02ad A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cd A[Catch:{ all -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4 A[Catch:{ all -> 0x0210 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(long r23) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 1411
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.c(long):void");
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.t;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j2) {
        long j3;
        long j4;
        long j5;
        long j6;
        int b2;
        long j7 = j2;
        if (((a[]) Assertions.checkNotNull(this.q)).length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        long j8 = -1;
        int i2 = this.s;
        if (i2 != -1) {
            l lVar = this.q[i2].b;
            int a3 = lVar.a(j7);
            if (a3 == -1) {
                a3 = lVar.b(j7);
            }
            if (a3 == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j9 = lVar.f[a3];
            j3 = lVar.c[a3];
            if (j9 >= j7 || a3 >= lVar.b - 1 || (b2 = lVar.b(j7)) == -1 || b2 == a3) {
                j6 = -9223372036854775807L;
            } else {
                long j10 = lVar.f[b2];
                long j11 = lVar.c[b2];
                j6 = j10;
                j8 = j11;
            }
            j4 = j8;
            j5 = j6;
            j7 = j9;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -1;
            j5 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.q;
            if (i3 >= aVarArr.length) {
                break;
            }
            if (i3 != this.s) {
                l lVar2 = aVarArr[i3].b;
                long b3 = b(lVar2, j7, j3);
                if (j5 != C.TIME_UNSET) {
                    j4 = b(lVar2, j5, j4);
                }
                j3 = b3;
            }
            i3++;
        }
        SeekPoint seekPoint = new SeekPoint(j7, j3);
        if (j5 == C.TIME_UNSET) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j5, j4));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.p = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:206:0x023f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03d8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r30, com.google.android.exoplayer2.extractor.PositionHolder r31) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 994
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.f.clear();
        this.j = 0;
        this.l = -1;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        if (j2 == 0) {
            a();
            return;
        }
        a[] aVarArr = this.q;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                l lVar = aVar.b;
                int a3 = lVar.a(j3);
                if (a3 == -1) {
                    a3 = lVar.b(j3);
                }
                aVar.d = a3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return j.a(extractorInput, false);
    }

    public Mp4Extractor(int i2) {
        this.a = i2;
        this.e = new ParsableByteArray(16);
        this.f = new ArrayDeque<>();
        this.b = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.c = new ParsableByteArray(4);
        this.d = new ParsableByteArray();
        this.l = -1;
    }
}
