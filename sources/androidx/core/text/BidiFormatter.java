package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
public final class BidiFormatter {
    public static final TextDirectionHeuristicCompat d;
    public static final String e = Character.toString(8206);
    public static final String f = Character.toString(8207);
    public static final BidiFormatter g;
    public static final BidiFormatter h;
    public final boolean a;
    public final int b;
    public final TextDirectionHeuristicCompat c;

    public static class a {
        public static final byte[] e = new byte[1792];
        public final CharSequence a;
        public final int b;
        public int c;
        public char d;

        static {
            for (int i = 0; i < 1792; i++) {
                e[i] = Character.getDirectionality(i);
            }
        }

        public a(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = charSequence.length();
        }

        public byte a() {
            char charAt = this.a.charAt(this.c - 1);
            this.d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.c);
                this.c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.c--;
            char c2 = this.d;
            return c2 < 1792 ? e[c2] : Character.getDirectionality(c2);
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        d = textDirectionHeuristicCompat;
        g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    public BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.a = z;
        this.b = i;
        this.c = textDirectionHeuristicCompat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        if (r3 != 0) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r4 == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        if (r0.c <= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        switch(r0.a()) {
            case 14: goto L_0x008a;
            case 15: goto L_0x008a;
            case 16: goto L_0x0086;
            case 17: goto L_0x0086;
            case 18: goto L_0x0083;
            default: goto L_0x0082;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r3 != r5) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        if (r3 != r5) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.CharSequence r9) {
        /*
            androidx.core.text.BidiFormatter$a r0 = new androidx.core.text.BidiFormatter$a
            r1 = 0
            r0.<init>(r9, r1)
            r0.c = r1
            r9 = -1
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000d:
            int r6 = r0.c
            int r7 = r0.b
            if (r6 >= r7) goto L_0x0070
            if (r3 != 0) goto L_0x0070
            java.lang.CharSequence r7 = r0.a
            char r6 = r7.charAt(r6)
            r0.d = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L_0x0039
            java.lang.CharSequence r6 = r0.a
            int r7 = r0.c
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.c
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.c = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L_0x004d
        L_0x0039:
            int r6 = r0.c
            int r6 = r6 + r2
            r0.c = r6
            char r6 = r0.d
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L_0x0049
            byte[] r7 = androidx.core.text.BidiFormatter.a.e
            byte r6 = r7[r6]
            goto L_0x004d
        L_0x0049:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L_0x004d:
            if (r6 == 0) goto L_0x006b
            if (r6 == r2) goto L_0x0068
            r7 = 2
            if (r6 == r7) goto L_0x0068
            r7 = 9
            if (r6 == r7) goto L_0x000d
            switch(r6) {
                case 14: goto L_0x0064;
                case 15: goto L_0x0064;
                case 16: goto L_0x0060;
                case 17: goto L_0x0060;
                case 18: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x006e
        L_0x005c:
            int r5 = r5 + -1
            r4 = 0
            goto L_0x000d
        L_0x0060:
            int r5 = r5 + 1
            r4 = 1
            goto L_0x000d
        L_0x0064:
            int r5 = r5 + 1
            r4 = -1
            goto L_0x000d
        L_0x0068:
            if (r5 != 0) goto L_0x006e
            goto L_0x0088
        L_0x006b:
            if (r5 != 0) goto L_0x006e
            goto L_0x008c
        L_0x006e:
            r3 = r5
            goto L_0x000d
        L_0x0070:
            if (r3 != 0) goto L_0x0073
            goto L_0x0091
        L_0x0073:
            if (r4 == 0) goto L_0x0077
            r1 = r4
            goto L_0x0091
        L_0x0077:
            int r4 = r0.c
            if (r4 <= 0) goto L_0x0091
            byte r4 = r0.a()
            switch(r4) {
                case 14: goto L_0x008a;
                case 15: goto L_0x008a;
                case 16: goto L_0x0086;
                case 17: goto L_0x0086;
                case 18: goto L_0x0083;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x0077
        L_0x0083:
            int r5 = r5 + 1
            goto L_0x0077
        L_0x0086:
            if (r3 != r5) goto L_0x008e
        L_0x0088:
            r1 = 1
            goto L_0x0091
        L_0x008a:
            if (r3 != r5) goto L_0x008e
        L_0x008c:
            r1 = -1
            goto L_0x0091
        L_0x008e:
            int r5 = r5 + -1
            goto L_0x0077
        L_0x0091:
            return r1
            switch-data {14->0x0064, 15->0x0064, 16->0x0060, 17->0x0060, 18->0x005c, }
            switch-data {14->0x008a, 15->0x008a, 16->0x0086, 17->0x0086, 18->0x0083, }
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.a(java.lang.CharSequence):int");
    }

    public static int b(CharSequence charSequence) {
        a aVar = new a(charSequence, false);
        aVar.c = aVar.b;
        int i = 0;
        int i2 = 0;
        while (aVar.c > 0) {
            byte a3 = aVar.a();
            if (a3 != 0) {
                if (a3 == 1 || a3 == 2) {
                    if (i != 0) {
                        if (i2 == 0) {
                            i2 = i;
                        }
                    }
                } else if (a3 != 9) {
                    switch (a3) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                break;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                break;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                    }
                } else {
                    continue;
                }
                return 1;
            } else if (i != 0) {
                if (i2 == 0) {
                    i2 = i;
                }
            }
            return -1;
        }
        return 0;
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public boolean getStereoReset() {
        return (this.b & 2) != 0;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.a;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.c.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = "";
        if (getStereoReset() && z) {
            boolean isRtl2 = (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR).isRtl(charSequence, 0, charSequence.length());
            if (this.a || (!isRtl2 && a(charSequence) != 1)) {
                str = (!this.a || (isRtl2 && a(charSequence) != -1)) ? str2 : f;
            } else {
                str = e;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        if (isRtl != this.a) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean isRtl3 = (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR).isRtl(charSequence, 0, charSequence.length());
            if (!this.a && (isRtl3 || b(charSequence) == 1)) {
                str2 = e;
            } else if (this.a && (!isRtl3 || b(charSequence) == -1)) {
                str2 = f;
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static final class Builder {
        public boolean a;
        public int b;
        public TextDirectionHeuristicCompat c;

        public Builder() {
            Locale locale = Locale.getDefault();
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = BidiFormatter.d;
            a(TextUtilsCompat.getLayoutDirectionFromLocale(locale) != 1 ? false : true);
        }

        public final void a(boolean z) {
            this.a = z;
            this.c = BidiFormatter.d;
            this.b = 2;
        }

        public BidiFormatter build() {
            if (this.b == 2 && this.c == BidiFormatter.d) {
                return this.a ? BidiFormatter.h : BidiFormatter.g;
            }
            return new BidiFormatter(this.a, this.b, this.c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.b |= 2;
            } else {
                this.b &= -3;
            }
            return this;
        }

        public Builder(boolean z) {
            this.a = z;
            this.c = BidiFormatter.d;
            this.b = 2;
        }

        public Builder(Locale locale) {
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = BidiFormatter.d;
            a(TextUtilsCompat.getLayoutDirectionFromLocale(locale) != 1 ? false : true);
        }
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.c, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.c, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.c, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.c, true);
    }
}
