package a2.j.b.b.v0;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
@RequiresApi(23)
public class h implements l {
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<b> h = new ArrayDeque<>();
    public static final Object i = new Object();
    public final MediaCodec a;
    public final HandlerThread b;
    public Handler c;
    public final AtomicReference<RuntimeException> d;
    public final ConditionVariable e;
    public final boolean f;
    public boolean g;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            h hVar = h.this;
            Objects.requireNonNull(hVar);
            int i = message.what;
            if (i == 0) {
                bVar = (b) message.obj;
                try {
                    hVar.a.queueInputBuffer(bVar.a, bVar.b, bVar.c, bVar.e, bVar.f);
                } catch (RuntimeException e) {
                    hVar.d.set(e);
                }
            } else if (i != 1) {
                if (i != 2) {
                    hVar.d.set(new IllegalStateException(String.valueOf(message.what)));
                } else {
                    hVar.e.open();
                }
                bVar = null;
            } else {
                bVar = (b) message.obj;
                int i2 = bVar.a;
                int i3 = bVar.b;
                MediaCodec.CryptoInfo cryptoInfo = bVar.d;
                long j = bVar.e;
                int i4 = bVar.f;
                try {
                    if (hVar.f) {
                        synchronized (h.i) {
                            hVar.a.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                        }
                    } else {
                        hVar.a.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                    }
                } catch (RuntimeException e2) {
                    hVar.d.set(e2);
                }
            }
            if (bVar != null) {
                ArrayDeque<b> arrayDeque = h.h;
                synchronized (arrayDeque) {
                    arrayDeque.add(bVar);
                }
            }
        }
    }

    public static class b {
        public int a;
        public int b;
        public int c;
        public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
        public long e;
        public int f;
    }

    public h(MediaCodec mediaCodec, int i2) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecBufferEnqueuer:");
        boolean z = true;
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        ConditionVariable conditionVariable = new ConditionVariable();
        this.a = mediaCodec;
        this.b = handlerThread;
        this.e = conditionVariable;
        this.d = new AtomicReference<>();
        String lowerInvariant = Util.toLowerInvariant(Util.MANUFACTURER);
        if (!lowerInvariant.contains("samsung") && !lowerInvariant.contains("motorola")) {
            z = false;
        }
        this.f = z;
    }

    @Nullable
    public static byte[] a(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    public static int[] b(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b c() {
        ArrayDeque<b> arrayDeque = h;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    public final void d() {
        RuntimeException andSet = this.d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    @Override // a2.j.b.b.v0.l
    public void flush() {
        if (this.g) {
            try {
                Handler handler = (Handler) Util.castNonNull(this.c);
                handler.removeCallbacksAndMessages(null);
                this.e.close();
                handler.obtainMessage(2).sendToTarget();
                this.e.block();
                d();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    @Override // a2.j.b.b.v0.l
    public void queueInputBuffer(int i2, int i3, int i4, long j, int i5) {
        d();
        b c2 = c();
        c2.a = i2;
        c2.b = i3;
        c2.c = i4;
        c2.e = j;
        c2.f = i5;
        ((Handler) Util.castNonNull(this.c)).obtainMessage(0, c2).sendToTarget();
    }

    @Override // a2.j.b.b.v0.l
    public void queueSecureInputBuffer(int i2, int i3, CryptoInfo cryptoInfo, long j, int i4) {
        d();
        b c2 = c();
        c2.a = i2;
        c2.b = i3;
        c2.c = 0;
        c2.e = j;
        c2.f = i4;
        MediaCodec.CryptoInfo cryptoInfo2 = c2.d;
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        cryptoInfo2.numBytesOfClearData = b(cryptoInfo.numBytesOfClearData, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = b(cryptoInfo.numBytesOfEncryptedData, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.checkNotNull(a(cryptoInfo.key, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.checkNotNull(a(cryptoInfo.iv, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.mode;
        if (Util.SDK_INT >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
        ((Handler) Util.castNonNull(this.c)).obtainMessage(1, c2).sendToTarget();
    }

    @Override // a2.j.b.b.v0.l
    public void shutdown() {
        if (this.g) {
            flush();
            this.b.quit();
        }
        this.g = false;
    }

    @Override // a2.j.b.b.v0.l
    public void start() {
        if (!this.g) {
            this.b.start();
            this.c = new a(this.b.getLooper());
            this.g = true;
        }
    }
}
