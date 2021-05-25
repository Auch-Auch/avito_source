package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.c;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class AdtsExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = c.a;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public final int a;
    public final AdtsReader b;
    public final ParsableByteArray c;
    public final ParsableByteArray d;
    public final ParsableBitArray e;
    public ExtractorOutput f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    public final int a(ExtractorInput extractorInput) throws IOException {
        int i2 = 0;
        while (true) {
            extractorInput.peekFully(this.d.getData(), 0, 10);
            this.d.setPosition(0);
            if (this.d.readUnsignedInt24() != 4801587) {
                break;
            }
            this.d.skipBytes(3);
            int readSynchSafeInt = this.d.readSynchSafeInt();
            i2 += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i2);
        if (this.h == -1) {
            this.h = (long) i2;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f = extractorOutput;
        this.b.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.f);
        long length = extractorInput.getLength();
        boolean z = ((this.a & 1) == 0 || length == -1) ? false : true;
        if (z && !this.j) {
            this.i = -1;
            extractorInput.resetPeekPosition();
            long j2 = 0;
            if (extractorInput.getPosition() == 0) {
                a(extractorInput);
            }
            int i2 = 0;
            while (true) {
                try {
                    if (!extractorInput.peekFully(this.d.getData(), 0, 2, true)) {
                        break;
                    }
                    this.d.setPosition(0);
                    if (!AdtsReader.isAdtsSyncWord(this.d.readUnsignedShort())) {
                        i2 = 0;
                        break;
                    } else if (!extractorInput.peekFully(this.d.getData(), 0, 4, true)) {
                        break;
                    } else {
                        this.e.setPosition(14);
                        int readBits = this.e.readBits(13);
                        if (readBits > 6) {
                            j2 += (long) readBits;
                            i2++;
                            if (i2 != 1000) {
                                if (!extractorInput.advancePeekPosition(readBits - 6, true)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            this.j = true;
                            throw new ParserException("Malformed ADTS stream");
                        }
                    }
                } catch (EOFException unused) {
                }
            }
            extractorInput.resetPeekPosition();
            if (i2 > 0) {
                this.i = (int) (j2 / ((long) i2));
            } else {
                this.i = -1;
            }
            this.j = true;
        }
        int read = extractorInput.read(this.c.getData(), 0, 2048);
        boolean z2 = read == -1;
        if (!this.l) {
            boolean z3 = z && this.i > 0;
            if (!z3 || this.b.getSampleDurationUs() != C.TIME_UNSET || z2) {
                if (!z3 || this.b.getSampleDurationUs() == C.TIME_UNSET) {
                    this.f.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
                } else {
                    this.f.seekMap(new ConstantBitrateSeekMap(length, this.h, (int) ((((long) (this.i * 8)) * 1000000) / this.b.getSampleDurationUs()), this.i));
                }
                this.l = true;
            }
        }
        if (z2) {
            return -1;
        }
        this.c.setPosition(0);
        this.c.setLimit(read);
        if (!this.k) {
            this.b.packetStarted(this.g, 4);
            this.k = true;
        }
        this.b.consume(this.c);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.k = false;
        this.b.seek();
        this.g = j3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0023, code lost:
        r9.resetPeekPosition();
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
        if ((r3 - r0) < 8192) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        return false;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput r9) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.a(r9)
            r1 = 0
            r3 = r0
        L_0x0006:
            r2 = 0
            r4 = 0
        L_0x0008:
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.d
            byte[] r5 = r5.getData()
            r6 = 2
            r9.peekFully(r5, r1, r6)
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.d
            r5.setPosition(r1)
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.d
            int r5 = r5.readUnsignedShort()
            boolean r5 = com.google.android.exoplayer2.extractor.ts.AdtsReader.isAdtsSyncWord(r5)
            if (r5 != 0) goto L_0x0033
            r9.resetPeekPosition()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r2 < r4) goto L_0x002f
            return r1
        L_0x002f:
            r9.advancePeekPosition(r3)
            goto L_0x0006
        L_0x0033:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L_0x003d
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L_0x003d
            return r5
        L_0x003d:
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.d
            byte[] r5 = r5.getData()
            r9.peekFully(r5, r1, r6)
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r8.e
            r6 = 14
            r5.setPosition(r6)
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r8.e
            r6 = 13
            int r5 = r5.readBits(r6)
            r6 = 6
            if (r5 > r6) goto L_0x0059
            return r1
        L_0x0059:
            int r6 = r5 + -6
            r9.advancePeekPosition(r6)
            int r4 = r4 + r5
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.AdtsExtractor.sniff(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    public AdtsExtractor(int i2) {
        this.a = i2;
        this.b = new AdtsReader(true);
        this.c = new ParsableByteArray(2048);
        this.i = -1;
        this.h = -1;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.d = parsableByteArray;
        this.e = new ParsableBitArray(parsableByteArray.getData());
    }
}
