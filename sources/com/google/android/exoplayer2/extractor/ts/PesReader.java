package com.google.android.exoplayer2.extractor.ts;

import a2.b.a.a.a;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
public final class PesReader implements TsPayloadReader {
    public final ElementaryStreamReader a;
    public final ParsableBitArray b = new ParsableBitArray(new byte[10]);
    public int c = 0;
    public int d;
    public TimestampAdjuster e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.a = elementaryStreamReader;
    }

    public final boolean a(ParsableByteArray parsableByteArray, @Nullable byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.bytesLeft(), i2 - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.skipBytes(min);
        } else {
            parsableByteArray.readBytes(bArr, this.d, min);
        }
        int i3 = this.d + min;
        this.d = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public final void b(int i2) {
        this.c = i2;
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void consume(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        boolean z;
        Assertions.checkStateNotNull(this.e);
        int i3 = -1;
        int i4 = 3;
        if ((i2 & 1) != 0) {
            int i5 = this.c;
            if (!(i5 == 0 || i5 == 1)) {
                if (i5 == 2) {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else if (i5 == 3) {
                    if (this.j != -1) {
                        StringBuilder L = a.L("Unexpected start indicator: expected ");
                        L.append(this.j);
                        L.append(" more bytes");
                        Log.w("PesReader", L.toString());
                    }
                    this.a.packetFinished();
                } else {
                    throw new IllegalStateException();
                }
            }
            b(1);
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i6 = this.c;
            if (i6 != 0) {
                int i7 = 0;
                if (i6 != 1) {
                    if (i6 == 2) {
                        if (a(parsableByteArray, this.b.data, Math.min(10, this.i)) && a(parsableByteArray, null, this.i)) {
                            this.b.setPosition(0);
                            this.l = C.TIME_UNSET;
                            if (this.f) {
                                this.b.skipBits(4);
                                this.b.skipBits(1);
                                this.b.skipBits(1);
                                long readBits = (((long) this.b.readBits(i4)) << 30) | ((long) (this.b.readBits(15) << 15)) | ((long) this.b.readBits(15));
                                this.b.skipBits(1);
                                if (!this.h && this.g) {
                                    this.b.skipBits(4);
                                    this.b.skipBits(1);
                                    this.b.skipBits(1);
                                    this.b.skipBits(1);
                                    this.e.adjustTsTimestamp((((long) this.b.readBits(i4)) << 30) | ((long) (this.b.readBits(15) << 15)) | ((long) this.b.readBits(15)));
                                    this.h = true;
                                }
                                this.l = this.e.adjustTsTimestamp(readBits);
                            }
                            i2 |= this.k ? 4 : 0;
                            this.a.packetStarted(this.l, i2);
                            b(3);
                        }
                    } else if (i6 == i4) {
                        int bytesLeft = parsableByteArray.bytesLeft();
                        int i8 = this.j;
                        if (i8 != i3) {
                            i7 = bytesLeft - i8;
                        }
                        if (i7 > 0) {
                            bytesLeft -= i7;
                            parsableByteArray.setLimit(parsableByteArray.getPosition() + bytesLeft);
                        }
                        this.a.consume(parsableByteArray);
                        int i9 = this.j;
                        if (i9 != i3) {
                            int i10 = i9 - bytesLeft;
                            this.j = i10;
                            if (i10 == 0) {
                                this.a.packetFinished();
                                b(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (a(parsableByteArray, this.b.data, 9)) {
                    this.b.setPosition(0);
                    int readBits2 = this.b.readBits(24);
                    if (readBits2 != 1) {
                        a.T0("Unexpected start code prefix: ", readBits2, "PesReader");
                        this.j = -1;
                        z = false;
                    } else {
                        this.b.skipBits(8);
                        int readBits3 = this.b.readBits(16);
                        this.b.skipBits(5);
                        this.k = this.b.readBit();
                        this.b.skipBits(2);
                        this.f = this.b.readBit();
                        this.g = this.b.readBit();
                        this.b.skipBits(6);
                        int readBits4 = this.b.readBits(8);
                        this.i = readBits4;
                        if (readBits3 == 0) {
                            this.j = -1;
                        } else {
                            int i11 = ((readBits3 + 6) - 9) - readBits4;
                            this.j = i11;
                            if (i11 < 0) {
                                StringBuilder L2 = a.L("Found negative packet payload size: ");
                                L2.append(this.j);
                                Log.w("PesReader", L2.toString());
                                this.j = -1;
                            }
                        }
                        z = true;
                    }
                    b(z ? 2 : 0);
                }
            } else {
                parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
            }
            i3 = -1;
            i4 = 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.e = timestampAdjuster;
        this.a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.seek();
    }
}
