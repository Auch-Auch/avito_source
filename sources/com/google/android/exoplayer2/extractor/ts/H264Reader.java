package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.f;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
public final class H264Reader implements ElementaryStreamReader {
    public final SeiReader a;
    public final boolean b;
    public final boolean c;
    public final f d = new f(7, 128);
    public final f e = new f(8, 128);
    public final f f = new f(6, 128);
    public long g;
    public final boolean[] h = new boolean[3];
    public String i;
    public TrackOutput j;
    public b k;
    public boolean l;
    public long m;
    public boolean n;
    public final ParsableByteArray o = new ParsableByteArray();

    public static final class b {
        public final TrackOutput a;
        public final boolean b;
        public final boolean c;
        public final SparseArray<NalUnitUtil.SpsData> d = new SparseArray<>();
        public final SparseArray<NalUnitUtil.PpsData> e = new SparseArray<>();
        public final ParsableNalUnitBitArray f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public a m = new a(null);
        public a n = new a(null);
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        public static final class a {
            public boolean a;
            public boolean b;
            @Nullable
            public NalUnitUtil.SpsData c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a(a aVar) {
            }
        }

        public b(TrackOutput trackOutput, boolean z, boolean z2) {
            this.a = trackOutput;
            this.b = z;
            this.c = z2;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new ParsableNalUnitBitArray(bArr, 0, 0);
            this.k = false;
            this.o = false;
            a aVar = this.n;
            aVar.b = false;
            aVar.a = false;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        this.a = seiReader;
        this.b = z;
        this.c = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0169  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sampleReader"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(byte[] r17, int r18, int r19) {
        /*
        // Method dump skipped, instructions count: 452
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.a(byte[], int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0293, code lost:
        if (r5 != 1) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01c5, code lost:
        if (r9.j == r10.j) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01cf, code lost:
        if (r14 != 0) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e3, code lost:
        if (r9.n == r10.n) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f6, code lost:
        if (r9.p == r10.p) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0204, code lost:
        if (r9.l == r10.l) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x020a, code lost:
        if (r9 == false) goto L_0x023e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x029b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02b3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x025a A[ADDED_TO_REGION] */
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r26) {
        /*
        // Method dump skipped, instructions count: 699
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.i = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.j = track;
        this.k = new b(track, this.b, this.c);
        this.a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.m = j2;
        this.n |= (i2 & 2) != 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.g = 0;
        this.n = false;
        NalUnitUtil.clearPrefixFlags(this.h);
        this.d.c();
        this.e.c();
        this.f.c();
        b bVar = this.k;
        if (bVar != null) {
            bVar.k = false;
            bVar.o = false;
            b.a aVar = bVar.n;
            aVar.b = false;
            aVar.a = false;
        }
    }
}
