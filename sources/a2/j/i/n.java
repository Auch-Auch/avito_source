package a2.j.i;

import java.nio.ByteBuffer;
public final class n {
    public static final a a = (m.c && m.b ? new d() : new b());

    public static abstract class a {
        public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        public final void b(CharSequence charSequence, ByteBuffer byteBuffer) {
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i = 0;
            while (i < length) {
                try {
                    char charAt = charSequence.charAt(i);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i, (byte) charAt);
                    i++;
                } catch (IndexOutOfBoundsException unused) {
                    int position2 = byteBuffer.position();
                    StringBuilder L = a2.b.a.a.a.L("Failed writing ");
                    L.append(charSequence.charAt(i));
                    L.append(" at index ");
                    L.append(Math.max(i, (position - byteBuffer.position()) + 1) + position2);
                    throw new ArrayIndexOutOfBoundsException(L.toString());
                }
            }
            if (i == length) {
                byteBuffer.position(position + i);
                return;
            }
            position += i;
            while (i < length) {
                char charAt2 = charSequence.charAt(i);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i2 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i2, (byte) ((charAt2 & '?') | 128));
                        position = i2;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i2;
                        int position2 = byteBuffer.position();
                        StringBuilder L = a2.b.a.a.a.L("Failed writing ");
                        L.append(charSequence.charAt(i));
                        L.append(" at index ");
                        L.append(Math.max(i, (position - byteBuffer.position()) + 1) + position2);
                        throw new ArrayIndexOutOfBoundsException(L.toString());
                    }
                } else if (charAt2 < 55296 || 57343 < charAt2) {
                    int i3 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                    position = i3 + 1;
                    byteBuffer.put(i3, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                } else {
                    int i4 = i + 1;
                    if (i4 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i5 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    int i6 = i5 + 1;
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    int i7 = i6 + 1;
                                    byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i7, (byte) ((codePoint & 63) | 128));
                                    position = i7;
                                    i = i4;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i5;
                                    i = i4;
                                    int position2 = byteBuffer.position();
                                    StringBuilder L = a2.b.a.a.a.L("Failed writing ");
                                    L.append(charSequence.charAt(i));
                                    L.append(" at index ");
                                    L.append(Math.max(i, (position - byteBuffer.position()) + 1) + position2);
                                    throw new ArrayIndexOutOfBoundsException(L.toString());
                                }
                            } else {
                                i = i4;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                            i = i4;
                            int position2 = byteBuffer.position();
                            StringBuilder L = a2.b.a.a.a.L("Failed writing ");
                            L.append(charSequence.charAt(i));
                            L.append(" at index ");
                            L.append(Math.max(i, (position - byteBuffer.position()) + 1) + position2);
                            throw new ArrayIndexOutOfBoundsException(L.toString());
                        }
                    }
                    throw new c(i, length);
                }
                i++;
                position++;
            }
            byteBuffer.position(position);
        }

        public abstract void c(CharSequence charSequence, ByteBuffer byteBuffer);

        public final int d(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return e(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
            } else if (byteBuffer.isDirect()) {
                return g(i, byteBuffer, i2, i3);
            } else {
                return f(i, byteBuffer, i2, i3);
            }
        }

        public abstract int e(int i, byte[] bArr, int i2, int i3);

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
            if (r21.get(r0) > -65) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x009e, code lost:
            if (r21.get(r0) > -65) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int f(int r20, java.nio.ByteBuffer r21, int r22, int r23) {
            /*
            // Method dump skipped, instructions count: 309
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.i.n.a.f(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int g(int i, ByteBuffer byteBuffer, int i2, int i3);
    }

    public static final class b extends a {
        @Override // a2.j.i.n.a
        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i4 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> '\f') | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new c(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new c(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }

        @Override // a2.j.i.n.a
        public void c(CharSequence charSequence, ByteBuffer byteBuffer) {
            b(charSequence, byteBuffer);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            if (r13[r14] > -65) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            if (r13[r14] > -65) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x0022;
         */
        @Override // a2.j.i.n.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(int r12, byte[] r13, int r14, int r15) {
            /*
            // Method dump skipped, instructions count: 242
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.i.n.b.e(int, byte[], int, int):int");
        }

        @Override // a2.j.i.n.a
        public int g(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return f(i, byteBuffer, i2, i3);
        }
    }

    public static class c extends IllegalArgumentException {
        public c(int i, int i2) {
            super(a2.b.a.a.a.R2("Unpaired surrogate at index ", i, " of ", i2));
        }
    }

    public static final class d extends a {
        public static int h(long j, int i, int i2) {
            if (i2 == 0) {
                return n.e(i);
            }
            if (i2 == 1) {
                return n.f(i, m.d(j));
            }
            if (i2 == 2) {
                return n.g(i, m.d(j), m.d(j + 1));
            }
            throw new AssertionError();
        }

        public static int i(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return n.e(i);
            }
            if (i2 == 1) {
                return n.f(i, m.e(bArr, j));
            }
            if (i2 == 2) {
                return n.g(i, m.e(bArr, j), m.e(bArr, j + 1));
            }
            throw new AssertionError();
        }

        @Override // a2.j.i.n.a
        public int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            char c;
            long j;
            long j2;
            long j3;
            int i3;
            char charAt;
            long j4 = m.d + ((long) i);
            long j5 = ((long) i2) + j4;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                StringBuilder L = a2.b.a.a.a.L("Failed writing ");
                L.append(charSequence.charAt(length - 1));
                L.append(" at index ");
                L.append(i + i2);
                throw new ArrayIndexOutOfBoundsException(L.toString());
            }
            int i4 = 0;
            while (true) {
                c = 128;
                j = 1;
                if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                m.j(bArr, j4, (byte) charAt);
                i4++;
                j4 = 1 + j4;
            }
            if (i4 == length) {
                j2 = m.d;
            } else {
                while (i4 < length) {
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 < c && j4 < j5) {
                        j3 = j4 + j;
                        m.j(bArr, j4, (byte) charAt2);
                    } else if (charAt2 < 2048 && j4 <= j5 - 2) {
                        long j6 = j4 + j;
                        m.j(bArr, j4, (byte) ((charAt2 >>> 6) | 960));
                        m.j(bArr, j6, (byte) ((charAt2 & '?') | 128));
                        j4 = j6 + j;
                        i4++;
                        c = 128;
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && j4 <= j5 - 3) {
                        long j7 = j4 + j;
                        m.j(bArr, j4, (byte) ((charAt2 >>> '\f') | 480));
                        long j8 = j + j7;
                        m.j(bArr, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j3 = j8 + 1;
                        m.j(bArr, j8, (byte) ((charAt2 & '?') | 128));
                        j = 1;
                    } else if (j4 <= j5 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j9 = j4 + 1;
                                m.j(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j10 = 1 + j9;
                                m.j(bArr, j9, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = 1 + j10;
                                m.j(bArr, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                                j = 1;
                                m.j(bArr, j11, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                                j4 = j11 + 1;
                                i4++;
                                c = 128;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new c(i4 - 1, length);
                    } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j4);
                    } else {
                        throw new c(i4, length);
                    }
                    j4 = j3;
                    i4++;
                    c = 128;
                }
                j2 = m.d;
            }
            return (int) (j4 - j2);
        }

        @Override // a2.j.i.n.a
        public void c(CharSequence charSequence, ByteBuffer byteBuffer) {
            char c;
            long j;
            long j2;
            long j3;
            int i;
            char charAt;
            long a = m.a(byteBuffer);
            long position = ((long) byteBuffer.position()) + a;
            long limit = ((long) byteBuffer.limit()) + a;
            int length = charSequence.length();
            if (((long) length) <= limit - position) {
                int i2 = 0;
                while (true) {
                    c = 128;
                    if (i2 >= length || (charAt = charSequence.charAt(i2)) >= 128) {
                        break;
                    }
                    m.i(position, (byte) charAt);
                    i2++;
                    position = 1 + position;
                }
                if (i2 == length) {
                    byteBuffer.position((int) (position - a));
                    return;
                }
                while (i2 < length) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 >= c || position >= limit) {
                        if (charAt2 >= 2048 || position > limit - 2) {
                            j2 = a;
                            if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                                long j4 = position + 1;
                                m.i(position, (byte) ((charAt2 >>> '\f') | 480));
                                long j5 = j4 + 1;
                                m.i(j4, (byte) (((charAt2 >>> 6) & 63) | 128));
                                m.i(j5, (byte) ((charAt2 & '?') | 128));
                                j3 = j5 + 1;
                            } else if (position <= limit - 4) {
                                int i3 = i2 + 1;
                                if (i3 != length) {
                                    char charAt3 = charSequence.charAt(i3);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        j = limit;
                                        long j6 = position + 1;
                                        m.i(position, (byte) ((codePoint >>> 18) | 240));
                                        long j7 = j6 + 1;
                                        m.i(j6, (byte) (((codePoint >>> 12) & 63) | 128));
                                        long j8 = j7 + 1;
                                        m.i(j7, (byte) (((codePoint >>> 6) & 63) | 128));
                                        m.i(j8, (byte) ((codePoint & 63) | 128));
                                        i2 = i3;
                                        position = j8 + 1;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                throw new c(i2 - 1, length);
                            } else if (55296 > charAt2 || charAt2 > 57343 || ((i = i2 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i)))) {
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                            } else {
                                throw new c(i2, length);
                            }
                        } else {
                            j2 = a;
                            long j9 = position + 1;
                            m.i(position, (byte) ((charAt2 >>> 6) | 960));
                            j3 = j9 + 1;
                            m.i(j9, (byte) ((charAt2 & '?') | 128));
                        }
                        position = j3;
                        j = limit;
                    } else {
                        m.i(position, (byte) charAt2);
                        j = limit;
                        position++;
                        j2 = a;
                    }
                    i2++;
                    c = 128;
                    a = j2;
                    limit = j;
                }
                byteBuffer.position((int) (position - a));
                return;
            }
            StringBuilder L = a2.b.a.a.a.L("Failed writing ");
            L.append(charSequence.charAt(length - 1));
            L.append(" at index ");
            L.append(byteBuffer.limit());
            throw new ArrayIndexOutOfBoundsException(L.toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
            if (a2.j.i.m.e(r26, r10) > -65) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
            if (a2.j.i.m.e(r26, r10) > -65) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b0, code lost:
            if (a2.j.i.m.e(r26, r10) > -65) goto L_0x00b2;
         */
        @Override // a2.j.i.n.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(int r25, byte[] r26, int r27, int r28) {
            /*
            // Method dump skipped, instructions count: 413
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.i.n.d.e(int, byte[], int, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
            if (a2.j.i.m.d(r6) > -65) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
            if (a2.j.i.m.d(r6) > -65) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
            if (a2.j.i.m.d(r6) > -65) goto L_0x00b5;
         */
        @Override // a2.j.i.n.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int g(int r24, java.nio.ByteBuffer r25, int r26, int r27) {
            /*
            // Method dump skipped, instructions count: 415
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.i.n.d.g(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    public static int a(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 == 0) {
            return e(i);
        }
        if (i3 == 1) {
            return f(i, byteBuffer.get(i2));
        }
        if (i3 == 2) {
            return g(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new AssertionError();
    }

    public static int b(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return e(b2);
        }
        if (i3 == 1) {
            return f(b2, bArr[i]);
        }
        if (i3 == 2) {
            return g(b2, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static int c(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return a.a(charSequence, bArr, i, i2);
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new c(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder L = a2.b.a.a.a.L("UTF-8 length does not fit in int: ");
        L.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(L.toString());
    }

    public static int e(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int f(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int g(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }
}
