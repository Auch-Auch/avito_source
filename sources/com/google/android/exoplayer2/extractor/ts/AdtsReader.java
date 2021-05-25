package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
public final class AdtsReader implements ElementaryStreamReader {
    public static final byte[] v = {73, 68, 51};
    public final boolean a;
    public final ParsableBitArray b;
    public final ParsableByteArray c;
    @Nullable
    public final String d;
    public String e;
    public TrackOutput f;
    public TrackOutput g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;
    public long s;
    public TrackOutput t;
    public long u;

    public AdtsReader(boolean z) {
        this(z, null);
    }

    public static boolean isAdtsSyncWord(int i2) {
        return (i2 & 65526) == 65520;
    }

    public final boolean a(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.bytesLeft(), i2 - this.i);
        parsableByteArray.readBytes(bArr, this.i, min);
        int i3 = this.i + min;
        this.i = i3;
        return i3 == i2;
    }

    public final void b() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    public final boolean c(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        if (parsableByteArray.bytesLeft() < i2) {
            return false;
        }
        parsableByteArray.readBytes(bArr, 0, i2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0279 A[EDGE_INSN: B:140:0x0279->B:91:0x0279 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r18) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 754
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.AdtsReader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.e = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.f = track;
        this.t = track;
        if (this.a) {
            trackIdGenerator.generateNewId();
            TrackOutput track2 = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
            this.g = track2;
            track2.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
            return;
        }
        this.g = new DummyTrackOutput();
    }

    public long getSampleDurationUs() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        this.s = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.l = false;
        b();
    }

    public AdtsReader(boolean z, @Nullable String str) {
        this.b = new ParsableBitArray(new byte[7]);
        this.c = new ParsableByteArray(Arrays.copyOf(v, 10));
        b();
        this.m = -1;
        this.n = -1;
        this.q = C.TIME_UNSET;
        this.a = z;
        this.d = str;
    }
}
