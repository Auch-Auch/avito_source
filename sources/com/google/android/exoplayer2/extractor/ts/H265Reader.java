package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.f;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public final class H265Reader implements ElementaryStreamReader {
    public final SeiReader a;
    public String b;
    public TrackOutput c;
    public a d;
    public boolean e;
    public final boolean[] f = new boolean[3];
    public final f g = new f(32, 128);
    public final f h = new f(33, 128);
    public final f i = new f(34, 128);
    public final f j = new f(39, 128);
    public final f k = new f(40, 128);
    public long l;
    public long m;
    public final ParsableByteArray n = new ParsableByteArray();

    public static final class a {
        public final TrackOutput a;
        public long b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(TrackOutput trackOutput) {
            this.a = trackOutput;
        }

        public final void a(int i2) {
            boolean z = this.m;
            this.a.sampleMetadata(this.l, z ? 1 : 0, (int) (this.b - this.k), i2, null);
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.a = seiReader;
    }

    @RequiresNonNull({"sampleReader"})
    public final void a(byte[] bArr, int i2, int i3) {
        a aVar = this.d;
        if (aVar.f) {
            int i4 = aVar.d;
            int i5 = (i2 + 2) - i4;
            if (i5 < i3) {
                aVar.g = (bArr[i5] & 128) != 0;
                aVar.f = false;
            } else {
                aVar.d = (i3 - i2) + i4;
            }
        }
        if (!this.e) {
            this.g.a(bArr, i2, i3);
            this.h.a(bArr, i2, i3);
            this.i.a(bArr, i2, i3);
        }
        this.j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03a3  */
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r27) {
        /*
        // Method dump skipped, instructions count: 967
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H265Reader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.b = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.c = track;
        this.d = new a(track);
        this.a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.m = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.l = 0;
        NalUnitUtil.clearPrefixFlags(this.f);
        this.g.c();
        this.h.c();
        this.i.c();
        this.j.c();
        this.k.c();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f = false;
            aVar.g = false;
            aVar.h = false;
            aVar.i = false;
            aVar.j = false;
        }
    }
}
