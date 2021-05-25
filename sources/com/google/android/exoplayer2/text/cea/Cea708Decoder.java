package com.google.android.exoplayer2.text.cea;

import a2.j.b.b.a1.c.d;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import okio.Utf8;
public final class Cea708Decoder extends a2.j.b.b.a1.c.c {
    public final ParsableByteArray g = new ParsableByteArray();
    public final ParsableBitArray h = new ParsableBitArray();
    public final int i;
    public final b[] j;
    public b k;
    @Nullable
    public List<Cue> l;
    @Nullable
    public List<Cue> m;
    @Nullable
    public c n;
    public int o;

    public static final class a {
        public final Cue a;
        public final int b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            Cue.Builder size = new Cue.Builder().setText(charSequence).setTextAlignment(alignment).setLine(f, i).setLineAnchor(i2).setPosition(f2).setPositionAnchor(i3).setSize(f3);
            if (z) {
                size.setWindowColor(i4);
            }
            this.a = size.build();
            this.b = i5;
        }
    }

    public static final class b {
        public static final int[] A = {0, 0, 0, 0, 0, 0, 2};
        public static final int[] B = {3, 3, 3, 3, 3, 3, 1};
        public static final boolean[] C = {false, false, false, true, true, true, false};
        public static final int[] D;
        public static final int[] E = {0, 1, 2, 3, 4, 3, 4};
        public static final int[] F = {0, 0, 0, 0, 0, 3, 3};
        public static final int[] G;
        public static final int w = d(2, 2, 2, 0);
        public static final int x;
        public static final int y;
        public static final int[] z = {0, 0, 0, 0, 0, 2, 0};
        public final List<SpannableString> a = new ArrayList();
        public final SpannableStringBuilder b = new SpannableStringBuilder();
        public boolean c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;

        static {
            int d2 = d(0, 0, 0, 0);
            x = d2;
            int d3 = d(0, 0, 0, 3);
            y = d3;
            D = new int[]{d2, d3, d2, d2, d3, d2, d2};
            G = new int[]{d2, d2, d2, d2, d2, d3, d3};
        }

        public b() {
            f();
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int d(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.Assertions.checkIndex(r4, r0, r1)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r5, r0, r1)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r6, r0, r1)
                com.google.android.exoplayer2.util.Assertions.checkIndex(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = 0
                goto L_0x0023
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0023
            L_0x0021:
                r7 = 255(0xff, float:3.57E-43)
            L_0x0023:
                if (r4 <= r1) goto L_0x0028
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r5 <= r1) goto L_0x002e
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002f
            L_0x002e:
                r5 = 0
            L_0x002f:
                if (r6 <= r1) goto L_0x0033
                r0 = 255(0xff, float:3.57E-43)
            L_0x0033:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.b.d(int, int, int, int):int");
        }

        public void a(char c2) {
            if (c2 == '\n') {
                this.a.add(b());
                this.b.clear();
                if (this.p != -1) {
                    this.p = 0;
                }
                if (this.q != -1) {
                    this.q = 0;
                }
                if (this.r != -1) {
                    this.r = 0;
                }
                if (this.t != -1) {
                    this.t = 0;
                }
                while (true) {
                    if ((this.k && this.a.size() >= this.j) || this.a.size() >= 15) {
                        this.a.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.b.append(c2);
            }
        }

        public SpannableString b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void c() {
            this.a.clear();
            this.b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }

        public boolean e() {
            return !this.c || (this.a.isEmpty() && this.b.length() == 0);
        }

        public void f() {
            c();
            this.c = false;
            this.d = false;
            this.e = 4;
            this.f = false;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 15;
            this.k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            int i2 = x;
            this.o = i2;
            this.s = w;
            this.u = i2;
        }

        public void g(boolean z2, boolean z3) {
            if (this.p != -1) {
                if (!z2) {
                    this.b.setSpan(new StyleSpan(2), this.p, this.b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.b.length();
            }
            if (this.q != -1) {
                if (!z3) {
                    this.b.setSpan(new UnderlineSpan(), this.q, this.b.length(), 33);
                    this.q = -1;
                }
            } else if (z3) {
                this.q = this.b.length();
            }
        }

        public void h(int i2, int i3) {
            if (!(this.r == -1 || this.s == i2)) {
                this.b.setSpan(new ForegroundColorSpan(this.s), this.r, this.b.length(), 33);
            }
            if (i2 != w) {
                this.r = this.b.length();
                this.s = i2;
            }
            if (!(this.t == -1 || this.u == i3)) {
                this.b.setSpan(new BackgroundColorSpan(this.u), this.t, this.b.length(), 33);
            }
            if (i3 != x) {
                this.t = this.b.length();
                this.u = i3;
            }
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final byte[] c;
        public int d = 0;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = new byte[((i2 * 2) - 1)];
        }
    }

    public Cea708Decoder(int i2, @Nullable List<byte[]> list) {
        this.i = i2 == -1 ? 1 : i2;
        if (list != null) {
            CodecSpecificDataUtil.parseCea708InitializationData(list);
        }
        this.j = new b[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.j[i3] = new b();
        }
        this.k = this.j[0];
    }

    public final void b() {
        c cVar = this.n;
        if (cVar != null) {
            int i2 = cVar.d;
            if (i2 != (cVar.b * 2) - 1) {
                StringBuilder L = a2.b.a.a.a.L("DtvCcPacket ended prematurely; size is ");
                L.append((this.n.b * 2) - 1);
                L.append(", but current index is ");
                L.append(this.n.d);
                L.append(" (sequence number ");
                L.append(this.n.a);
                L.append("); ignoring packet");
                Log.w("Cea708Decoder", L.toString());
            } else {
                this.h.reset(cVar.c, i2);
                int i3 = 3;
                int readBits = this.h.readBits(3);
                int readBits2 = this.h.readBits(5);
                int i4 = 7;
                int i5 = 6;
                if (readBits == 7) {
                    this.h.skipBits(2);
                    readBits = this.h.readBits(6);
                    if (readBits < 7) {
                        a2.b.a.a.a.T0("Invalid extended service number: ", readBits, "Cea708Decoder");
                    }
                }
                if (readBits2 == 0) {
                    if (readBits != 0) {
                        Log.w("Cea708Decoder", "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
                    }
                } else if (readBits == this.i) {
                    boolean z = false;
                    while (this.h.bitsLeft() > 0) {
                        int readBits3 = this.h.readBits(8);
                        if (readBits3 != 16) {
                            if (readBits3 <= 31) {
                                if (readBits3 != 0) {
                                    if (readBits3 == i3) {
                                        this.l = c();
                                    } else if (readBits3 != 8) {
                                        switch (readBits3) {
                                            case 12:
                                                d();
                                                continue;
                                            case 13:
                                                this.k.a('\n');
                                                continue;
                                            case 14:
                                                break;
                                            default:
                                                if (readBits3 < 17 || readBits3 > 23) {
                                                    if (readBits3 < 24 || readBits3 > 31) {
                                                        a2.b.a.a.a.T0("Invalid C0 command: ", readBits3, "Cea708Decoder");
                                                        break;
                                                    } else {
                                                        a2.b.a.a.a.T0("Currently unsupported COMMAND_P16 Command: ", readBits3, "Cea708Decoder");
                                                        this.h.skipBits(16);
                                                        break;
                                                    }
                                                } else {
                                                    a2.b.a.a.a.T0("Currently unsupported COMMAND_EXT1 Command: ", readBits3, "Cea708Decoder");
                                                    this.h.skipBits(8);
                                                    continue;
                                                }
                                        }
                                    } else {
                                        b bVar = this.k;
                                        int length = bVar.b.length();
                                        if (length > 0) {
                                            bVar.b.delete(length - 1, length);
                                        }
                                    }
                                }
                            } else if (readBits3 <= 127) {
                                if (readBits3 == 127) {
                                    this.k.a(9835);
                                } else {
                                    this.k.a((char) (readBits3 & 255));
                                }
                            } else if (readBits3 <= 159) {
                                switch (readBits3) {
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                        int i6 = readBits3 - 128;
                                        if (this.o != i6) {
                                            this.o = i6;
                                            this.k = this.j[i6];
                                            break;
                                        }
                                        break;
                                    case 136:
                                        for (int i7 = 1; i7 <= 8; i7++) {
                                            if (this.h.readBit()) {
                                                this.j[8 - i7].c();
                                            }
                                        }
                                        break;
                                    case 137:
                                        for (int i8 = 1; i8 <= 8; i8++) {
                                            if (this.h.readBit()) {
                                                this.j[8 - i8].d = true;
                                            }
                                        }
                                        break;
                                    case 138:
                                        for (int i9 = 1; i9 <= 8; i9++) {
                                            if (this.h.readBit()) {
                                                this.j[8 - i9].d = false;
                                            }
                                        }
                                        break;
                                    case 139:
                                        for (int i10 = 1; i10 <= 8; i10++) {
                                            if (this.h.readBit()) {
                                                b bVar2 = this.j[8 - i10];
                                                bVar2.d = !bVar2.d;
                                            }
                                        }
                                        break;
                                    case 140:
                                        for (int i11 = 1; i11 <= 8; i11++) {
                                            if (this.h.readBit()) {
                                                this.j[8 - i11].f();
                                            }
                                        }
                                        break;
                                    case 141:
                                        this.h.skipBits(8);
                                        break;
                                    case 142:
                                        break;
                                    case 143:
                                        d();
                                        break;
                                    case 144:
                                        if (!this.k.c) {
                                            this.h.skipBits(16);
                                            break;
                                        } else {
                                            this.h.readBits(4);
                                            this.h.readBits(2);
                                            this.h.readBits(2);
                                            boolean readBit = this.h.readBit();
                                            boolean readBit2 = this.h.readBit();
                                            this.h.readBits(3);
                                            this.h.readBits(3);
                                            this.k.g(readBit, readBit2);
                                            break;
                                        }
                                    case 145:
                                        if (!this.k.c) {
                                            this.h.skipBits(24);
                                            break;
                                        } else {
                                            int d = b.d(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
                                            int d2 = b.d(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
                                            this.h.skipBits(2);
                                            b.d(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), 0);
                                            this.k.h(d, d2);
                                            break;
                                        }
                                    case 146:
                                        if (!this.k.c) {
                                            this.h.skipBits(16);
                                            break;
                                        } else {
                                            this.h.skipBits(4);
                                            int readBits4 = this.h.readBits(4);
                                            this.h.skipBits(2);
                                            this.h.readBits(6);
                                            b bVar3 = this.k;
                                            if (bVar3.v != readBits4) {
                                                bVar3.a('\n');
                                            }
                                            bVar3.v = readBits4;
                                            break;
                                        }
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    default:
                                        a2.b.a.a.a.T0("Invalid C1 command: ", readBits3, "Cea708Decoder");
                                        break;
                                    case 151:
                                        if (!this.k.c) {
                                            this.h.skipBits(32);
                                            break;
                                        } else {
                                            int d3 = b.d(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), this.h.readBits(2));
                                            this.h.readBits(2);
                                            b.d(this.h.readBits(2), this.h.readBits(2), this.h.readBits(2), 0);
                                            this.h.readBit();
                                            this.h.readBit();
                                            this.h.readBits(2);
                                            this.h.readBits(2);
                                            int readBits5 = this.h.readBits(2);
                                            this.h.skipBits(8);
                                            b bVar4 = this.k;
                                            bVar4.o = d3;
                                            bVar4.l = readBits5;
                                            break;
                                        }
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                        int i12 = readBits3 - 152;
                                        b bVar5 = this.j[i12];
                                        this.h.skipBits(2);
                                        boolean readBit3 = this.h.readBit();
                                        boolean readBit4 = this.h.readBit();
                                        this.h.readBit();
                                        int readBits6 = this.h.readBits(i3);
                                        boolean readBit5 = this.h.readBit();
                                        int readBits7 = this.h.readBits(i4);
                                        int readBits8 = this.h.readBits(8);
                                        int readBits9 = this.h.readBits(4);
                                        int readBits10 = this.h.readBits(4);
                                        this.h.skipBits(2);
                                        this.h.readBits(i5);
                                        this.h.skipBits(2);
                                        int readBits11 = this.h.readBits(i3);
                                        int readBits12 = this.h.readBits(i3);
                                        bVar5.c = true;
                                        bVar5.d = readBit3;
                                        bVar5.k = readBit4;
                                        bVar5.e = readBits6;
                                        bVar5.f = readBit5;
                                        bVar5.g = readBits7;
                                        bVar5.h = readBits8;
                                        bVar5.i = readBits9;
                                        int i13 = readBits10 + 1;
                                        if (bVar5.j != i13) {
                                            bVar5.j = i13;
                                            while (true) {
                                                if ((readBit4 && bVar5.a.size() >= bVar5.j) || bVar5.a.size() >= 15) {
                                                    bVar5.a.remove(0);
                                                }
                                            }
                                        }
                                        if (!(readBits11 == 0 || bVar5.m == readBits11)) {
                                            bVar5.m = readBits11;
                                            int i14 = readBits11 - 1;
                                            int i15 = b.D[i14];
                                            boolean z2 = b.C[i14];
                                            int i16 = b.A[i14];
                                            int i17 = b.B[i14];
                                            int i18 = b.z[i14];
                                            bVar5.o = i15;
                                            bVar5.l = i18;
                                        }
                                        if (!(readBits12 == 0 || bVar5.n == readBits12)) {
                                            bVar5.n = readBits12;
                                            int i19 = readBits12 - 1;
                                            int i20 = b.F[i19];
                                            int i21 = b.E[i19];
                                            bVar5.g(false, false);
                                            bVar5.h(b.w, b.G[i19]);
                                        }
                                        if (this.o != i12) {
                                            this.o = i12;
                                            this.k = this.j[i12];
                                            break;
                                        }
                                        break;
                                }
                            } else if (readBits3 <= 255) {
                                this.k.a((char) (readBits3 & 255));
                            } else {
                                a2.b.a.a.a.T0("Invalid base command: ", readBits3, "Cea708Decoder");
                            }
                            i3 = 3;
                            i4 = 7;
                            i5 = 6;
                        } else {
                            int readBits13 = this.h.readBits(8);
                            if (readBits13 <= 31) {
                                if (readBits13 > 7) {
                                    if (readBits13 <= 15) {
                                        this.h.skipBits(8);
                                    } else if (readBits13 <= 23) {
                                        this.h.skipBits(16);
                                    } else if (readBits13 <= 31) {
                                        this.h.skipBits(24);
                                    }
                                }
                            } else if (readBits13 <= 127) {
                                if (readBits13 == 32) {
                                    this.k.a(' ');
                                } else if (readBits13 == 33) {
                                    this.k.a(Typography.nbsp);
                                } else if (readBits13 == 37) {
                                    this.k.a(Typography.ellipsis);
                                } else if (readBits13 == 42) {
                                    this.k.a(352);
                                } else if (readBits13 == 44) {
                                    this.k.a(338);
                                } else if (readBits13 == 63) {
                                    this.k.a(376);
                                } else if (readBits13 == 57) {
                                    this.k.a(Typography.tm);
                                } else if (readBits13 == 58) {
                                    this.k.a(353);
                                } else if (readBits13 == 60) {
                                    this.k.a(339);
                                } else if (readBits13 != 61) {
                                    switch (readBits13) {
                                        case 48:
                                            this.k.a(9608);
                                            break;
                                        case 49:
                                            this.k.a(Typography.leftSingleQuote);
                                            break;
                                        case 50:
                                            this.k.a(Typography.rightSingleQuote);
                                            break;
                                        case 51:
                                            this.k.a(Typography.leftDoubleQuote);
                                            break;
                                        case 52:
                                            this.k.a(Typography.rightDoubleQuote);
                                            break;
                                        case 53:
                                            this.k.a(Typography.bullet);
                                            break;
                                        default:
                                            switch (readBits13) {
                                                case 118:
                                                    this.k.a(8539);
                                                    break;
                                                case 119:
                                                    this.k.a(8540);
                                                    break;
                                                case 120:
                                                    this.k.a(8541);
                                                    break;
                                                case 121:
                                                    this.k.a(8542);
                                                    break;
                                                case 122:
                                                    this.k.a(9474);
                                                    break;
                                                case 123:
                                                    this.k.a(9488);
                                                    break;
                                                case 124:
                                                    this.k.a(9492);
                                                    break;
                                                case 125:
                                                    this.k.a(9472);
                                                    break;
                                                case 126:
                                                    this.k.a(9496);
                                                    break;
                                                case 127:
                                                    this.k.a(9484);
                                                    break;
                                                default:
                                                    a2.b.a.a.a.T0("Invalid G2 character: ", readBits13, "Cea708Decoder");
                                                    break;
                                            }
                                    }
                                } else {
                                    this.k.a(8480);
                                }
                            } else if (readBits13 <= 159) {
                                if (readBits13 <= 135) {
                                    this.h.skipBits(32);
                                } else if (readBits13 <= 143) {
                                    this.h.skipBits(40);
                                } else if (readBits13 <= 159) {
                                    this.h.skipBits(2);
                                    this.h.skipBits(this.h.readBits(6) * 8);
                                }
                            } else if (readBits13 > 255) {
                                a2.b.a.a.a.T0("Invalid extended command: ", readBits13, "Cea708Decoder");
                            } else if (readBits13 == 160) {
                                this.k.a(13252);
                            } else {
                                a2.b.a.a.a.T0("Invalid G3 character: ", readBits13, "Cea708Decoder");
                                this.k.a('_');
                            }
                            i3 = 3;
                            i4 = 7;
                            i5 = 6;
                        }
                        z = true;
                        i3 = 3;
                        i4 = 7;
                        i5 = 6;
                    }
                    if (z) {
                        this.l = c();
                    }
                }
            }
            this.n = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.exoplayer2.text.Cue> c() {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.c():java.util.List");
    }

    @Override // a2.j.b.b.a1.c.c
    public Subtitle createSubtitle() {
        List<Cue> list = this.l;
        this.m = list;
        return new d((List) Assertions.checkNotNull(list));
    }

    public final void d() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.j[i2].f();
        }
    }

    @Override // a2.j.b.b.a1.c.c
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
        this.g.reset(byteBuffer.array(), byteBuffer.limit());
        while (this.g.bytesLeft() >= 3) {
            int readUnsignedByte = this.g.readUnsignedByte() & 7;
            int i2 = readUnsignedByte & 3;
            boolean z = false;
            boolean z2 = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.g.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.g.readUnsignedByte();
            if (i2 == 2 || i2 == 3) {
                if (z2) {
                    if (i2 == 3) {
                        b();
                        int i3 = (readUnsignedByte2 & 192) >> 6;
                        int i4 = readUnsignedByte2 & Utf8.REPLACEMENT_BYTE;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        c cVar = new c(i3, i4);
                        this.n = cVar;
                        byte[] bArr = cVar.c;
                        int i5 = cVar.d;
                        cVar.d = i5 + 1;
                        bArr[i5] = readUnsignedByte3;
                    } else {
                        if (i2 == 2) {
                            z = true;
                        }
                        Assertions.checkArgument(z);
                        c cVar2 = this.n;
                        if (cVar2 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.c;
                            int i6 = cVar2.d;
                            int i7 = i6 + 1;
                            cVar2.d = i7;
                            bArr2[i6] = readUnsignedByte2;
                            cVar2.d = i7 + 1;
                            bArr2[i7] = readUnsignedByte3;
                        }
                    }
                    c cVar3 = this.n;
                    if (cVar3.d == (cVar3.b * 2) - 1) {
                        b();
                    }
                }
            }
        }
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.l = null;
        this.m = null;
        this.o = 0;
        this.k = this.j[0];
        d();
        this.n = null;
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea708Decoder";
    }

    @Override // a2.j.b.b.a1.c.c
    public boolean isNewSubtitleDataAvailable() {
        return this.l != this.m;
    }

    @Override // a2.j.b.b.a1.c.c
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // a2.j.b.b.a1.c.c, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j2) {
        super.setPositionUs(j2);
    }
}
