package com.google.android.exoplayer2.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;
import java.util.Objects;
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {
    public final Thread a;
    public final Object b = new Object();
    public final ArrayDeque<I> c = new ArrayDeque<>();
    public final ArrayDeque<O> d = new ArrayDeque<>();
    public final I[] e;
    public final O[] f;
    public int g;
    public int h;
    public I i;
    public E j;
    public boolean k;
    public boolean l;
    public int m;

    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SimpleDecoder simpleDecoder = SimpleDecoder.this;
            Objects.requireNonNull(simpleDecoder);
            do {
                try {
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            } while (simpleDecoder.a());
        }
    }

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i2 = 0; i2 < this.g; i2++) {
            this.e[i2] = createInputBuffer();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i3 = 0; i3 < this.h; i3++) {
            this.f[i3] = createOutputBuffer();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.a = aVar;
        aVar.start();
    }

    public final boolean a() throws InterruptedException {
        I removeFirst;
        O o;
        boolean z;
        E e2;
        synchronized (this.b) {
            while (!this.l) {
                if (!this.c.isEmpty() && this.h > 0) {
                    break;
                }
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            removeFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i2 = this.h - 1;
            this.h = i2;
            o = oArr[i2];
            z = this.k;
            this.k = false;
        }
        if (removeFirst.isEndOfStream()) {
            o.addFlag(4);
        } else {
            if (removeFirst.isDecodeOnly()) {
                o.addFlag(Integer.MIN_VALUE);
            }
            try {
                e2 = decode(removeFirst, o, z);
            } catch (RuntimeException e3) {
                e2 = createUnexpectedDecodeException(e3);
            } catch (OutOfMemoryError e4) {
                e2 = createUnexpectedDecodeException(e4);
            }
            if (e2 != null) {
                synchronized (this.b) {
                    this.j = e2;
                }
                return false;
            }
        }
        synchronized (this.b) {
            if (this.k) {
                o.release();
            } else if (o.isDecodeOnly()) {
                this.m++;
                o.release();
            } else {
                o.skippedOutputBufferCount = this.m;
                this.m = 0;
                this.d.addLast(o);
            }
            d(removeFirst);
        }
        return true;
    }

    public final void b() {
        if (!this.c.isEmpty() && this.h > 0) {
            this.b.notify();
        }
    }

    public final void c() throws DecoderException {
        E e2 = this.j;
        if (e2 != null) {
            throw e2;
        }
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E createUnexpectedDecodeException(Throwable th);

    public final void d(I i2) {
        i2.clear();
        I[] iArr = this.e;
        int i3 = this.g;
        this.g = i3 + 1;
        iArr[i3] = i2;
    }

    @Nullable
    public abstract E decode(I i2, O o, boolean z);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            I i2 = this.i;
            if (i2 != null) {
                d(i2);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                d(this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                this.d.removeFirst().release();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.decoder.SimpleDecoder<I extends com.google.android.exoplayer2.decoder.DecoderInputBuffer, O extends com.google.android.exoplayer2.decoder.OutputBuffer, E extends com.google.android.exoplayer2.decoder.DecoderException> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(Object obj) throws DecoderException {
        queueInputBuffer((SimpleDecoder<I, O, E>) ((DecoderInputBuffer) obj));
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @CallSuper
    public void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @CallSuper
    public void releaseOutputBuffer(O o) {
        synchronized (this.b) {
            o.clear();
            O[] oArr = this.f;
            int i2 = this.h;
            this.h = i2 + 1;
            oArr[i2] = o;
            b();
        }
    }

    public final void setInitialInputBufferSize(int i2) {
        Assertions.checkState(this.g == this.e.length);
        for (I i3 : this.e) {
            i3.ensureSpaceForWrite(i2);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public final I dequeueInputBuffer() throws DecoderException {
        I i2;
        synchronized (this.b) {
            c();
            Assertions.checkState(this.i == null);
            int i3 = this.g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.e;
                int i4 = i3 - 1;
                this.g = i4;
                i2 = iArr[i4];
            }
            this.i = i2;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public final O dequeueOutputBuffer() throws DecoderException {
        synchronized (this.b) {
            c();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    public final void queueInputBuffer(I i2) throws DecoderException {
        synchronized (this.b) {
            c();
            Assertions.checkArgument(i2 == this.i);
            this.c.addLast(i2);
            b();
            this.i = null;
        }
    }
}
