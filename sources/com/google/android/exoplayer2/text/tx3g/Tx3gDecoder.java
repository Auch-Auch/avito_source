package com.google.android.exoplayer2.text.tx3g;

import a2.j.b.b.a1.i.a;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.util.List;
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    public final ParsableByteArray o = new ParsableByteArray();
    public boolean p;
    public int q;
    public int r;
    public String s;
    public float t;
    public int u;

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = C.SANS_SERIF_NAME;
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.q = bArr[24];
            this.r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.s = "Serif".equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
            int i = bArr[25] * Ascii.DC4;
            this.u = i;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.p = z;
            if (z) {
                float f = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i);
                this.t = f;
                this.t = Util.constrainValue(f, 0.0f, 0.95f);
                return;
            }
            this.t = 0.85f;
            return;
        }
        this.q = 0;
        this.r = -1;
        this.s = str;
        this.p = false;
        this.t = 0.85f;
    }

    public static void e(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void f(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = true;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        String str;
        char peekChar;
        this.o.reset(bArr, i);
        ParsableByteArray parsableByteArray = this.o;
        int i2 = 2;
        int i3 = 1;
        e(parsableByteArray.bytesLeft() >= 2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        if (readUnsignedShort == 0) {
            str = "";
        } else if (parsableByteArray.bytesLeft() < 2 || !((peekChar = parsableByteArray.peekChar()) == 65279 || peekChar == 65534)) {
            str = parsableByteArray.readString(readUnsignedShort, Charsets.UTF_8);
        } else {
            str = parsableByteArray.readString(readUnsignedShort, Charsets.UTF_16);
        }
        if (str.isEmpty()) {
            return a.b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        f(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        int i4 = this.r;
        int length = spannableStringBuilder.length();
        if (i4 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i4 >>> 8) | ((i4 & 255) << 24)), 0, length, 16711713);
        }
        String str2 = this.s;
        int length2 = spannableStringBuilder.length();
        if (str2 != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length2, 16711713);
        }
        float f = this.t;
        for (int i5 = 8; this.o.bytesLeft() >= i5; i5 = 8) {
            int position = this.o.getPosition();
            int readInt = this.o.readInt();
            int readInt2 = this.o.readInt();
            if (readInt2 == 1937013100) {
                e(this.o.bytesLeft() >= i2);
                int readUnsignedShort2 = this.o.readUnsignedShort();
                int i6 = 0;
                while (i6 < readUnsignedShort2) {
                    ParsableByteArray parsableByteArray2 = this.o;
                    e(parsableByteArray2.bytesLeft() >= 12);
                    int readUnsignedShort3 = parsableByteArray2.readUnsignedShort();
                    int readUnsignedShort4 = parsableByteArray2.readUnsignedShort();
                    parsableByteArray2.skipBytes(i2);
                    int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                    parsableByteArray2.skipBytes(i3);
                    int readInt3 = parsableByteArray2.readInt();
                    if (readUnsignedShort4 > spannableStringBuilder.length()) {
                        StringBuilder M = a2.b.a.a.a.M("Truncating styl end (", readUnsignedShort4, ") to cueText.length() (");
                        M.append(spannableStringBuilder.length());
                        M.append(").");
                        Log.w("Tx3gDecoder", M.toString());
                        readUnsignedShort4 = spannableStringBuilder.length();
                    }
                    if (readUnsignedShort3 >= readUnsignedShort4) {
                        Log.w("Tx3gDecoder", a2.b.a.a.a.S2("Ignoring styl with start (", readUnsignedShort3, ") >= end (", readUnsignedShort4, ")."));
                    } else {
                        f(spannableStringBuilder, readUnsignedByte, this.q, readUnsignedShort3, readUnsignedShort4, 0);
                        if (readInt3 != this.r) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(((readInt3 & 255) << 24) | (readInt3 >>> 8)), readUnsignedShort3, readUnsignedShort4, 33);
                        }
                    }
                    i6++;
                    i2 = 2;
                    i3 = 1;
                }
            } else {
                if (readInt2 == 1952608120 && this.p) {
                    e(this.o.bytesLeft() >= 2);
                    f = Util.constrainValue(((float) this.o.readUnsignedShort()) / ((float) this.u), 0.0f, 0.95f);
                }
                i2 = 2;
            }
            this.o.setPosition(position + readInt);
            i3 = 1;
        }
        return new a(new Cue.Builder().setText(spannableStringBuilder).setLine(f, 0).setLineAnchor(0).build());
    }
}
