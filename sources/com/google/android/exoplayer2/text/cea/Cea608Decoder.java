package com.google.android.exoplayer2.text.cea;

import a2.j.b.b.a1.c.c;
import a2.j.b.b.a1.c.d;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class Cea608Decoder extends c {
    public static final int[] A = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public static final long MIN_DATA_CHANNEL_TIMEOUT_MS = 16000;
    public static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    public final ParsableByteArray g = new ParsableByteArray();
    public final int h;
    public final int i;
    public final int j;
    public final long k;
    public final ArrayList<a> l = new ArrayList<>();
    public a m = new a(0, 4);
    @Nullable
    public List<Cue> n;
    @Nullable
    public List<Cue> o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public byte t;
    public byte u;
    public int v = 0;
    public boolean w;
    public long x;

    public static final class a {
        public final List<C0187a> a = new ArrayList();
        public final List<SpannableString> b = new ArrayList();
        public final StringBuilder c = new StringBuilder();
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        /* renamed from: com.google.android.exoplayer2.text.cea.Cea608Decoder$a$a  reason: collision with other inner class name */
        public static class C0187a {
            public final int a;
            public final boolean b;
            public int c;

            public C0187a(int i, boolean z, int i2) {
                this.a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            f(i);
            this.h = i2;
        }

        public void a(char c2) {
            if (this.c.length() < 32) {
                this.c.append(c2);
            }
        }

        public void b() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    C0187a aVar = this.a.get(size);
                    int i = aVar.c;
                    if (i == length) {
                        aVar.c = i - 1;
                    } else {
                        return;
                    }
                }
            }
        }

        @Nullable
        public Cue c(int i) {
            float f2;
            int i2 = this.e + this.f;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                spannableStringBuilder.append(Util.truncateAscii(this.b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(Util.truncateAscii(d(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                if (this.g != 2 || (Math.abs(i5) >= 3 && length >= 0)) {
                    i = (this.g != 2 || i5 <= 0) ? 0 : 2;
                } else {
                    i = 1;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f2 = ((((float) i2) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i6 = this.d;
            if (i6 > 7) {
                i6 = (i6 - 15) - 2;
            } else if (this.g == 1) {
                i6 -= this.h - 1;
            }
            return new Cue.Builder().setText(spannableStringBuilder).setTextAlignment(Layout.Alignment.ALIGN_NORMAL).setLine((float) i6, 1).setPosition(f2).setPositionAnchor(i).build();
        }

        public final SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            boolean z = false;
            int i6 = -1;
            while (i < this.a.size()) {
                C0187a aVar = this.a.get(i);
                boolean z2 = aVar.b;
                int i7 = aVar.a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = Cea608Decoder.A[i7];
                    }
                    z = z3;
                }
                int i8 = aVar.c;
                i++;
                if (i8 != (i < this.a.size() ? this.a.get(i).c : length)) {
                    if (i2 != -1 && !z2) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i8, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i3, i8, 33);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        if (i5 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, i8, 33);
                        }
                        i4 = i8;
                        i5 = i6;
                    }
                }
            }
            if (!(i2 == -1 || i2 == length)) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
            }
            if (!(i3 == -1 || i3 == length)) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
            }
            if (!(i4 == length || i5 == -1)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean e() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void f(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }
    }

    public Cea608Decoder(String str, int i2, long j2) {
        this.k = j2 > 0 ? j2 * 1000 : -9223372036854775807L;
        this.h = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i2 == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i2 == 2) {
            this.j = 1;
            this.i = 0;
        } else if (i2 == 3) {
            this.j = 0;
            this.i = 1;
        } else if (i2 != 4) {
            Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.j = 0;
            this.i = 0;
        } else {
            this.j = 1;
            this.i = 1;
        }
        d(0);
        c();
        this.w = true;
        this.x = C.TIME_UNSET;
    }

    public final List<Cue> b() {
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            Cue c = this.l.get(i3).c(Integer.MIN_VALUE);
            arrayList.add(c);
            if (c != null) {
                i2 = Math.min(i2, c.positionAnchor);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            Cue cue = (Cue) arrayList.get(i4);
            if (cue != null) {
                if (cue.positionAnchor != i2) {
                    cue = (Cue) Assertions.checkNotNull(this.l.get(i4).c(i2));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    public final void c() {
        this.m.f(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    @Override // a2.j.b.b.a1.c.c
    public Subtitle createSubtitle() {
        List<Cue> list = this.n;
        this.o = list;
        return new d((List) Assertions.checkNotNull(list));
    }

    public final void d(int i2) {
        int i3 = this.p;
        if (i3 != i2) {
            this.p = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.l.size(); i4++) {
                    this.l.get(i4).g = i2;
                }
                return;
            }
            c();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.n = Collections.emptyList();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:203:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0018 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    @Override // a2.j.b.b.a1.c.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer r14) {
        /*
        // Method dump skipped, instructions count: 762
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea608Decoder.decode(com.google.android.exoplayer2.text.SubtitleInputBuffer):void");
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    public final void e(int i2) {
        this.q = i2;
        this.m.h = i2;
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        d(0);
        e(4);
        c();
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = true;
        this.x = C.TIME_UNSET;
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // a2.j.b.b.a1.c.c
    public boolean isNewSubtitleDataAvailable() {
        return this.n != this.o;
    }

    @Override // a2.j.b.b.a1.c.c
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j2) {
        super.setPositionUs(j2);
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        SubtitleOutputBuffer availableOutputBuffer;
        SubtitleOutputBuffer dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        boolean z2 = false;
        if (!(this.k == C.TIME_UNSET || this.x == C.TIME_UNSET || getPositionUs() - this.x < this.k)) {
            z2 = true;
        }
        if (!z2 || (availableOutputBuffer = getAvailableOutputBuffer()) == null) {
            return null;
        }
        this.n = Collections.emptyList();
        this.x = C.TIME_UNSET;
        availableOutputBuffer.setContent(getPositionUs(), createSubtitle(), Long.MAX_VALUE);
        return availableOutputBuffer;
    }
}
