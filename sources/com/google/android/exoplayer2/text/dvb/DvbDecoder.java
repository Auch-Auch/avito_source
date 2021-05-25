package com.google.android.exoplayer2.text.dvb;

import a2.j.b.b.a1.d.a;
import a2.j.b.b.a1.d.b;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public final class DvbDecoder extends SimpleSubtitleDecoder {
    public final a o;

    public DvbDecoder(List<byte[]> list) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        this.o = new a(parsableByteArray.readUnsignedShort(), parsableByteArray.readUnsignedShort());
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        b bVar;
        b bVar2;
        List list;
        int i2;
        int i3;
        b bVar3;
        SparseArray<a.g> sparseArray;
        SparseArray<a.e> sparseArray2;
        int[] iArr;
        a.f fVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (z) {
            a.h hVar = this.o.f;
            hVar.c.clear();
            hVar.d.clear();
            hVar.e.clear();
            hVar.f.clear();
            hVar.g.clear();
            hVar.h = null;
            hVar.i = null;
        }
        a aVar = this.o;
        Objects.requireNonNull(aVar);
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            a.h hVar2 = aVar.f;
            int readBits = parsableBitArray.readBits(8);
            int i10 = 16;
            int readBits2 = parsableBitArray.readBits(16);
            int readBits3 = parsableBitArray.readBits(16);
            int bytePosition = parsableBitArray.getBytePosition() + readBits3;
            if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
                Log.w("DvbParser", "Data field length exceeds limit");
                parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            } else {
                switch (readBits) {
                    case 16:
                        if (readBits2 == hVar2.a) {
                            a.d dVar = hVar2.i;
                            int i11 = 8;
                            int readBits4 = parsableBitArray.readBits(8);
                            int readBits5 = parsableBitArray.readBits(4);
                            int readBits6 = parsableBitArray.readBits(2);
                            parsableBitArray.skipBits(2);
                            int i12 = readBits3 - 2;
                            SparseArray sparseArray3 = new SparseArray();
                            while (i12 > 0) {
                                int readBits7 = parsableBitArray.readBits(i11);
                                parsableBitArray.skipBits(i11);
                                i12 -= 6;
                                sparseArray3.put(readBits7, new a.e(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
                                i11 = 8;
                            }
                            a.d dVar2 = new a.d(readBits4, readBits5, readBits6, sparseArray3);
                            if (readBits6 == 0) {
                                if (!(dVar == null || dVar.a == readBits5)) {
                                    hVar2.i = dVar2;
                                    break;
                                }
                            } else {
                                hVar2.i = dVar2;
                                hVar2.c.clear();
                                hVar2.d.clear();
                                hVar2.e.clear();
                                break;
                            }
                        }
                        break;
                    case 17:
                        a.d dVar3 = hVar2.i;
                        if (readBits2 == hVar2.a && dVar3 != null) {
                            int readBits8 = parsableBitArray.readBits(8);
                            parsableBitArray.skipBits(4);
                            boolean readBit = parsableBitArray.readBit();
                            parsableBitArray.skipBits(3);
                            int readBits9 = parsableBitArray.readBits(16);
                            int readBits10 = parsableBitArray.readBits(16);
                            int readBits11 = parsableBitArray.readBits(3);
                            int readBits12 = parsableBitArray.readBits(3);
                            parsableBitArray.skipBits(2);
                            int readBits13 = parsableBitArray.readBits(8);
                            int readBits14 = parsableBitArray.readBits(8);
                            int readBits15 = parsableBitArray.readBits(4);
                            int readBits16 = parsableBitArray.readBits(2);
                            parsableBitArray.skipBits(2);
                            int i13 = readBits3 - 10;
                            SparseArray sparseArray4 = new SparseArray();
                            while (i13 > 0) {
                                int readBits17 = parsableBitArray.readBits(i10);
                                int readBits18 = parsableBitArray.readBits(2);
                                int readBits19 = parsableBitArray.readBits(2);
                                int readBits20 = parsableBitArray.readBits(12);
                                parsableBitArray.skipBits(4);
                                int readBits21 = parsableBitArray.readBits(12);
                                i13 -= 6;
                                if (readBits18 == 1 || readBits18 == 2) {
                                    i13 -= 2;
                                    i5 = parsableBitArray.readBits(8);
                                    i4 = parsableBitArray.readBits(8);
                                } else {
                                    i5 = 0;
                                    i4 = 0;
                                }
                                sparseArray4.put(readBits17, new a.g(readBits18, readBits19, readBits20, readBits21, i5, i4));
                                i10 = 16;
                            }
                            a.f fVar2 = new a.f(readBits8, readBit, readBits9, readBits10, readBits11, readBits12, readBits13, readBits14, readBits15, readBits16, sparseArray4);
                            if (dVar3.b == 0 && (fVar = hVar2.c.get(readBits8)) != null) {
                                SparseArray<a.g> sparseArray5 = fVar.j;
                                for (int i14 = 0; i14 < sparseArray5.size(); i14++) {
                                    fVar2.j.put(sparseArray5.keyAt(i14), sparseArray5.valueAt(i14));
                                }
                            }
                            hVar2.c.put(fVar2.a, fVar2);
                            break;
                        }
                    case 18:
                        if (readBits2 != hVar2.a) {
                            if (readBits2 == hVar2.b) {
                                a.C0037a f = a.f(parsableBitArray, readBits3);
                                hVar2.f.put(f.a, f);
                                break;
                            }
                        } else {
                            a.C0037a f2 = a.f(parsableBitArray, readBits3);
                            hVar2.d.put(f2.a, f2);
                            break;
                        }
                        break;
                    case 19:
                        if (readBits2 != hVar2.a) {
                            if (readBits2 == hVar2.b) {
                                a.c g = a.g(parsableBitArray);
                                hVar2.g.put(g.a, g);
                                break;
                            }
                        } else {
                            a.c g2 = a.g(parsableBitArray);
                            hVar2.e.put(g2.a, g2);
                            break;
                        }
                        break;
                    case 20:
                        if (readBits2 == hVar2.a) {
                            parsableBitArray.skipBits(4);
                            boolean readBit2 = parsableBitArray.readBit();
                            parsableBitArray.skipBits(3);
                            int readBits22 = parsableBitArray.readBits(16);
                            int readBits23 = parsableBitArray.readBits(16);
                            if (readBit2) {
                                int readBits24 = parsableBitArray.readBits(16);
                                i8 = parsableBitArray.readBits(16);
                                i7 = parsableBitArray.readBits(16);
                                i6 = parsableBitArray.readBits(16);
                                i9 = readBits24;
                            } else {
                                i8 = readBits22;
                                i6 = readBits23;
                                i9 = 0;
                                i7 = 0;
                            }
                            hVar2.h = new a.b(readBits22, readBits23, i9, i8, i7, i6);
                            break;
                        }
                        break;
                }
                parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
            }
        }
        a.h hVar3 = aVar.f;
        a.d dVar4 = hVar3.i;
        if (dVar4 == null) {
            list = Collections.emptyList();
            bVar2 = bVar;
        } else {
            a.b bVar4 = hVar3.h;
            if (bVar4 == null) {
                bVar4 = aVar.d;
            }
            Bitmap bitmap = aVar.g;
            if (!(bitmap != null && bVar4.a + 1 == bitmap.getWidth() && bVar4.b + 1 == aVar.g.getHeight())) {
                Bitmap createBitmap = Bitmap.createBitmap(bVar4.a + 1, bVar4.b + 1, Bitmap.Config.ARGB_8888);
                aVar.g = createBitmap;
                aVar.c.setBitmap(createBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray<a.e> sparseArray6 = dVar4.c;
            int i15 = 0;
            while (i15 < sparseArray6.size()) {
                aVar.c.save();
                a.e valueAt = sparseArray6.valueAt(i15);
                a.f fVar3 = aVar.f.c.get(sparseArray6.keyAt(i15));
                int i16 = valueAt.a + bVar4.c;
                int i17 = valueAt.b + bVar4.e;
                aVar.c.clipRect(i16, i17, Math.min(fVar3.c + i16, bVar4.d), Math.min(fVar3.d + i17, bVar4.f));
                a.C0037a aVar2 = aVar.f.d.get(fVar3.f);
                if (aVar2 == null && (aVar2 = aVar.f.f.get(fVar3.f)) == null) {
                    aVar2 = aVar.e;
                }
                SparseArray<a.g> sparseArray7 = fVar3.j;
                int i18 = 0;
                while (i18 < sparseArray7.size()) {
                    int keyAt = sparseArray7.keyAt(i18);
                    a.g valueAt2 = sparseArray7.valueAt(i18);
                    a.c cVar = aVar.f.e.get(keyAt);
                    if (cVar == null) {
                        cVar = aVar.f.g.get(keyAt);
                    }
                    if (cVar != null) {
                        Paint paint = cVar.b ? null : aVar.a;
                        int i19 = fVar3.e;
                        sparseArray2 = sparseArray6;
                        int i20 = valueAt2.a + i16;
                        int i21 = valueAt2.b + i17;
                        sparseArray = sparseArray7;
                        Canvas canvas = aVar.c;
                        bVar3 = bVar;
                        if (i19 == 3) {
                            iArr = aVar2.d;
                        } else if (i19 == 2) {
                            iArr = aVar2.c;
                        } else {
                            iArr = aVar2.b;
                        }
                        i3 = i15;
                        a.e(cVar.c, iArr, i19, i20, i21, paint, canvas);
                        a.e(cVar.d, iArr, i19, i20, i21 + 1, paint, canvas);
                    } else {
                        bVar3 = bVar;
                        sparseArray2 = sparseArray6;
                        i3 = i15;
                        sparseArray = sparseArray7;
                    }
                    i18++;
                    sparseArray6 = sparseArray2;
                    sparseArray7 = sparseArray;
                    bVar = bVar3;
                    i15 = i3;
                }
                if (fVar3.b) {
                    int i22 = fVar3.e;
                    if (i22 == 3) {
                        i2 = aVar2.d[fVar3.g];
                    } else if (i22 == 2) {
                        i2 = aVar2.c[fVar3.h];
                    } else {
                        i2 = aVar2.b[fVar3.i];
                    }
                    aVar.b.setColor(i2);
                    aVar.c.drawRect((float) i16, (float) i17, (float) (fVar3.c + i16), (float) (fVar3.d + i17), aVar.b);
                }
                arrayList.add(new Cue.Builder().setBitmap(Bitmap.createBitmap(aVar.g, i16, i17, fVar3.c, fVar3.d)).setPosition(((float) i16) / ((float) bVar4.a)).setPositionAnchor(0).setLine(((float) i17) / ((float) bVar4.b), 0).setLineAnchor(0).setSize(((float) fVar3.c) / ((float) bVar4.a)).setBitmapHeight(((float) fVar3.d) / ((float) bVar4.b)).build());
                aVar.c.drawColor(0, PorterDuff.Mode.CLEAR);
                aVar.c.restore();
                i15++;
                sparseArray6 = sparseArray6;
                bVar = bVar;
            }
            bVar2 = bVar;
            list = Collections.unmodifiableList(arrayList);
        }
        return new b(list);
    }
}
