package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.f;
import a2.j.b.b.u0.l.k;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
public final class H263Reader implements ElementaryStreamReader {
    public static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    @Nullable
    public final k a;
    @Nullable
    public final ParsableByteArray b;
    public final boolean[] c;
    public final a d;
    @Nullable
    public final f e;
    public b f;
    public long g;
    public String h;
    public TrackOutput i;
    public boolean j;
    public long k;

    public static final class a {
        public static final byte[] f = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        public void b() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    public static final class b {
        public final TrackOutput a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public b(TrackOutput trackOutput) {
            this.a = trackOutput;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 < i2) {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                    return;
                }
                this.f = (i2 - i) + i3;
            }
        }
    }

    public H263Reader() {
        this(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ff  */
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r25) {
        /*
        // Method dump skipped, instructions count: 684
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H263Reader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.h = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.i = track;
        this.f = new b(track);
        k kVar = this.a;
        if (kVar != null) {
            kVar.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.k = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.c);
        this.d.b();
        b bVar = this.f;
        if (bVar != null) {
            bVar.b = false;
            bVar.c = false;
            bVar.d = false;
            bVar.e = -1;
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.c();
        }
        this.g = 0;
    }

    public H263Reader(@Nullable k kVar) {
        this.a = kVar;
        this.c = new boolean[4];
        this.d = new a(128);
        if (kVar != null) {
            this.e = new f(178, 128);
            this.b = new ParsableByteArray();
            return;
        }
        this.e = null;
        this.b = null;
    }
}
