package com.bumptech.glide.gifdecoder;

import a2.d.a.c.a;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Objects;
public class GifHeaderParser {
    public final byte[] a = new byte[256];
    public ByteBuffer b;
    public GifHeader c;
    public int d = 0;

    public final boolean a() {
        return this.c.b != 0;
    }

    public final int b() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void c() {
        int b2 = b();
        this.d = b2;
        if (b2 > 0) {
            int i = 0;
            while (true) {
                try {
                    int i2 = this.d;
                    if (i < i2) {
                        int i3 = i2 - i;
                        this.b.get(this.a, i, i3);
                        i += i3;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    Log.isLoggable("GifHeaderParser", 3);
                    this.c.b = 1;
                    return;
                }
            }
        }
    }

    public void clear() {
        this.b = null;
        this.c = null;
    }

    @Nullable
    public final int[] d(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.c.b = 1;
        }
        return iArr;
    }

    public final void e(int i) {
        boolean z = false;
        while (!z && !a() && this.c.c <= i) {
            int b2 = b();
            if (b2 == 33) {
                int b3 = b();
                if (b3 == 1) {
                    h();
                } else if (b3 == 249) {
                    this.c.d = new a();
                    b();
                    int b4 = b();
                    a aVar = this.c.d;
                    int i2 = (b4 & 28) >> 2;
                    aVar.g = i2;
                    if (i2 == 0) {
                        aVar.g = 1;
                    }
                    aVar.f = (b4 & 1) != 0;
                    int g = g();
                    if (g < 2) {
                        g = 10;
                    }
                    a aVar2 = this.c.d;
                    aVar2.i = g * 10;
                    aVar2.h = b();
                    b();
                } else if (b3 == 254) {
                    h();
                } else if (b3 != 255) {
                    h();
                } else {
                    c();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        do {
                            c();
                            byte[] bArr = this.a;
                            if (bArr[0] == 1) {
                                this.c.l = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                            }
                            if (this.d <= 0) {
                                break;
                            }
                        } while (!a());
                    } else {
                        h();
                    }
                }
            } else if (b2 == 44) {
                GifHeader gifHeader = this.c;
                if (gifHeader.d == null) {
                    gifHeader.d = new a();
                }
                gifHeader.d.a = g();
                this.c.d.b = g();
                this.c.d.c = g();
                this.c.d.d = g();
                int b5 = b();
                boolean z2 = (b5 & 128) != 0;
                int pow = (int) Math.pow(2.0d, (double) ((b5 & 7) + 1));
                a aVar3 = this.c.d;
                aVar3.e = (b5 & 64) != 0;
                if (z2) {
                    aVar3.k = d(pow);
                } else {
                    aVar3.k = null;
                }
                this.c.d.j = this.b.position();
                b();
                h();
                if (!a()) {
                    GifHeader gifHeader2 = this.c;
                    gifHeader2.c++;
                    gifHeader2.e.add(gifHeader2.d);
                }
            } else if (b2 != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    public final void f() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < 6; i++) {
            sb.append((char) b());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        this.c.f = g();
        this.c.g = g();
        int b2 = b();
        GifHeader gifHeader = this.c;
        if ((b2 & 128) != 0) {
            z = true;
        }
        gifHeader.h = z;
        gifHeader.i = (int) Math.pow(2.0d, (double) ((b2 & 7) + 1));
        this.c.j = b();
        GifHeader gifHeader2 = this.c;
        b();
        Objects.requireNonNull(gifHeader2);
        if (this.c.h && !a()) {
            GifHeader gifHeader3 = this.c;
            gifHeader3.a = d(gifHeader3.i);
            GifHeader gifHeader4 = this.c;
            gifHeader4.k = gifHeader4.a[gifHeader4.j];
        }
    }

    public final int g() {
        return this.b.getShort();
    }

    public final void h() {
        int b2;
        do {
            b2 = b();
            this.b.position(Math.min(this.b.position() + b2, this.b.limit()));
        } while (b2 > 0);
    }

    public boolean isAnimated() {
        f();
        if (!a()) {
            e(2);
        }
        return this.c.c > 1;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (a()) {
            return this.c;
        } else {
            f();
            if (!a()) {
                e(Integer.MAX_VALUE);
                GifHeader gifHeader = this.c;
                if (gifHeader.c < 0) {
                    gifHeader.b = 1;
                }
            }
            return this.c;
        }
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new GifHeader();
        this.d = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
