package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.zip.Inflater;
public final class PgsDecoder extends SimpleSubtitleDecoder {
    public final ParsableByteArray o = new ParsableByteArray();
    public final ParsableByteArray p = new ParsableByteArray();
    public final a q = new a();
    @Nullable
    public Inflater r;

    public static final class a {
        public final ParsableByteArray a = new ParsableByteArray();
        public final int[] b = new int[256];
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.reset(0);
            this.c = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        Cue cue;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        int readUnsignedInt24;
        PgsDecoder pgsDecoder = this;
        pgsDecoder.o.reset(bArr, i);
        ParsableByteArray parsableByteArray = pgsDecoder.o;
        if (parsableByteArray.bytesLeft() > 0 && parsableByteArray.peekUnsignedByte() == 120) {
            if (pgsDecoder.r == null) {
                pgsDecoder.r = new Inflater();
            }
            if (Util.inflate(parsableByteArray, pgsDecoder.p, pgsDecoder.r)) {
                parsableByteArray.reset(pgsDecoder.p.getData(), pgsDecoder.p.limit());
            }
        }
        pgsDecoder.q.a();
        ArrayList arrayList2 = new ArrayList();
        while (pgsDecoder.o.bytesLeft() >= 3) {
            ParsableByteArray parsableByteArray2 = pgsDecoder.o;
            a aVar = pgsDecoder.q;
            int limit = parsableByteArray2.limit();
            int readUnsignedByte = parsableByteArray2.readUnsignedByte();
            int readUnsignedShort = parsableByteArray2.readUnsignedShort();
            int position = parsableByteArray2.getPosition() + readUnsignedShort;
            if (position > limit) {
                parsableByteArray2.setPosition(limit);
                arrayList = arrayList2;
                cue = null;
            } else {
                boolean z2 = false;
                if (readUnsignedByte != 128) {
                    switch (readUnsignedByte) {
                        case 20:
                            Objects.requireNonNull(aVar);
                            if (readUnsignedShort % 5 == 2) {
                                parsableByteArray2.skipBytes(2);
                                Arrays.fill(aVar.b, 0);
                                int i5 = 0;
                                for (int i6 = readUnsignedShort / 5; i5 < i6; i6 = i6) {
                                    int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                                    int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                                    int readUnsignedByte4 = parsableByteArray2.readUnsignedByte();
                                    int readUnsignedByte5 = parsableByteArray2.readUnsignedByte();
                                    double d = (double) readUnsignedByte3;
                                    double d2 = (double) (readUnsignedByte4 - 128);
                                    double d3 = (double) (readUnsignedByte5 - 128);
                                    aVar.b[readUnsignedByte2] = Util.constrainValue((int) ((d3 * 1.772d) + d), 0, 255) | (Util.constrainValue((int) ((1.402d * d2) + d), 0, 255) << 16) | (parsableByteArray2.readUnsignedByte() << 24) | (Util.constrainValue((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8);
                                    i5++;
                                    arrayList2 = arrayList2;
                                }
                                arrayList = arrayList2;
                                aVar.c = true;
                                break;
                            }
                            arrayList = arrayList2;
                            break;
                        case 21:
                            Objects.requireNonNull(aVar);
                            if (readUnsignedShort >= 4) {
                                parsableByteArray2.skipBytes(3);
                                if ((parsableByteArray2.readUnsignedByte() & 128) != 0) {
                                    z2 = true;
                                }
                                int i7 = readUnsignedShort - 4;
                                if (z2) {
                                    if (i7 >= 7 && (readUnsignedInt24 = parsableByteArray2.readUnsignedInt24()) >= 4) {
                                        aVar.h = parsableByteArray2.readUnsignedShort();
                                        aVar.i = parsableByteArray2.readUnsignedShort();
                                        aVar.a.reset(readUnsignedInt24 - 4);
                                        i7 -= 7;
                                    }
                                }
                                int position2 = aVar.a.getPosition();
                                int limit2 = aVar.a.limit();
                                if (position2 < limit2 && i7 > 0) {
                                    int min = Math.min(i7, limit2 - position2);
                                    parsableByteArray2.readBytes(aVar.a.getData(), position2, min);
                                    aVar.a.setPosition(position2 + min);
                                }
                            }
                            arrayList = arrayList2;
                            break;
                        case 22:
                            Objects.requireNonNull(aVar);
                            if (readUnsignedShort >= 19) {
                                aVar.d = parsableByteArray2.readUnsignedShort();
                                aVar.e = parsableByteArray2.readUnsignedShort();
                                parsableByteArray2.skipBytes(11);
                                aVar.f = parsableByteArray2.readUnsignedShort();
                                aVar.g = parsableByteArray2.readUnsignedShort();
                            }
                            arrayList = arrayList2;
                            break;
                        default:
                            arrayList = arrayList2;
                            break;
                    }
                    cue = null;
                } else {
                    arrayList = arrayList2;
                    if (aVar.d == 0 || aVar.e == 0 || aVar.h == 0 || aVar.i == 0 || aVar.a.limit() == 0 || aVar.a.getPosition() != aVar.a.limit() || !aVar.c) {
                        cue = null;
                    } else {
                        aVar.a.setPosition(0);
                        int i8 = aVar.h * aVar.i;
                        int[] iArr = new int[i8];
                        int i9 = 0;
                        while (i9 < i8) {
                            int readUnsignedByte6 = aVar.a.readUnsignedByte();
                            if (readUnsignedByte6 != 0) {
                                i2 = i9 + 1;
                                iArr[i9] = aVar.b[readUnsignedByte6];
                            } else {
                                int readUnsignedByte7 = aVar.a.readUnsignedByte();
                                if (readUnsignedByte7 != 0) {
                                    if ((readUnsignedByte7 & 64) == 0) {
                                        i3 = readUnsignedByte7 & 63;
                                    } else {
                                        i3 = ((readUnsignedByte7 & 63) << 8) | aVar.a.readUnsignedByte();
                                    }
                                    if ((readUnsignedByte7 & 128) == 0) {
                                        i4 = 0;
                                    } else {
                                        i4 = aVar.b[aVar.a.readUnsignedByte()];
                                    }
                                    i2 = i3 + i9;
                                    Arrays.fill(iArr, i9, i2, i4);
                                }
                            }
                            i9 = i2;
                        }
                        cue = new Cue.Builder().setBitmap(Bitmap.createBitmap(iArr, aVar.h, aVar.i, Bitmap.Config.ARGB_8888)).setPosition(((float) aVar.f) / ((float) aVar.d)).setPositionAnchor(0).setLine(((float) aVar.g) / ((float) aVar.e), 0).setLineAnchor(0).setSize(((float) aVar.h) / ((float) aVar.d)).setBitmapHeight(((float) aVar.i) / ((float) aVar.e)).build();
                    }
                    aVar.a();
                }
                parsableByteArray2.setPosition(position);
            }
            if (cue != null) {
                arrayList.add(cue);
            }
            pgsDecoder = this;
            arrayList2 = arrayList;
        }
        return new a2.j.b.b.a1.e.a(Collections.unmodifiableList(arrayList2));
    }
}
