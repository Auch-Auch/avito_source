package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
public final class LatmReader implements ElementaryStreamReader {
    @Nullable
    public final String a;
    public final ParsableByteArray b;
    public final ParsableBitArray c;
    public TrackOutput d;
    public String e;
    public Format f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;
    public long s;
    public int t;
    @Nullable
    public String u;

    public LatmReader(@Nullable String str) {
        this.a = str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.b = parsableByteArray;
        this.c = new ParsableBitArray(parsableByteArray.getData());
    }

    public static long a(ParsableBitArray parsableBitArray) {
        return (long) parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8);
    }

    public final int b(ParsableBitArray parsableBitArray) throws ParserException {
        int bitsLeft = parsableBitArray.bitsLeft();
        AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(parsableBitArray, true);
        this.u = parseAudioSpecificConfig.codecs;
        this.r = parseAudioSpecificConfig.sampleRateHz;
        this.t = parseAudioSpecificConfig.channelCount;
        return bitsLeft - parsableBitArray.bitsLeft();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015c, code lost:
        if (r13.l == false) goto L_0x01b8;
     */
    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray r14) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 548
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.LatmReader.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.e = trackIdGenerator.getFormatId();
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
        this.g = 0;
        this.l = false;
    }
}
