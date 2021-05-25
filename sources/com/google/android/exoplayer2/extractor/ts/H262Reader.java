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
public final class H262Reader implements ElementaryStreamReader {
    public static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public String a;
    public TrackOutput b;
    @Nullable
    public final k c;
    @Nullable
    public final ParsableByteArray d;
    @Nullable
    public final f e;
    public final boolean[] f;
    public final a g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;

    public static final class a {
        public static final byte[] e = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public byte[] d;

        public a(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b;
                if (length < i4 + i3) {
                    this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }
    }

    public H262Reader() {
        this(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0219  */
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r26) {
        /*
        // Method dump skipped, instructions count: 545
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H262Reader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.a = trackIdGenerator.getFormatId();
        this.b = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        k kVar = this.c;
        if (kVar != null) {
            kVar.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.l = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.f);
        a aVar = this.g;
        aVar.a = false;
        aVar.b = 0;
        aVar.c = 0;
        f fVar = this.e;
        if (fVar != null) {
            fVar.c();
        }
        this.h = 0;
        this.i = false;
    }

    public H262Reader(@Nullable k kVar) {
        this.c = kVar;
        this.f = new boolean[4];
        this.g = new a(128);
        if (kVar != null) {
            this.e = new f(178, 128);
            this.d = new ParsableByteArray();
            return;
        }
        this.e = null;
        this.d = null;
    }
}
