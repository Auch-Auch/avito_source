package a2.j.b.b.v0;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Util;
@RequiresApi(23)
public final class g extends MediaCodec.Callback implements MediaCodecAdapter {
    public final Object a = new Object();
    @GuardedBy("lock")
    public final k b = new k();
    public final MediaCodec c;
    public final HandlerThread d;
    public Handler e;
    @GuardedBy("lock")
    public long f;
    public int g;
    public final l h;
    @Nullable
    @GuardedBy("lock")
    public IllegalStateException i;

    @VisibleForTesting
    public g(MediaCodec mediaCodec, boolean z, int i2, HandlerThread handlerThread) {
        l lVar;
        this.c = mediaCodec;
        this.d = handlerThread;
        if (z) {
            lVar = new h(mediaCodec, i2);
        } else {
            lVar = new n(mediaCodec);
        }
        this.h = lVar;
        this.g = 0;
    }

    public static String a(int i2) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    @GuardedBy("lock")
    public final void b() {
        IllegalStateException illegalStateException = this.i;
        if (illegalStateException == null) {
            k kVar = this.b;
            IllegalStateException illegalStateException2 = kVar.g;
            kVar.g = null;
            if (illegalStateException2 != null) {
                throw illegalStateException2;
            }
            return;
        }
        this.i = null;
        throw illegalStateException;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void configure(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i2) {
        this.d.start();
        Handler handler = new Handler(this.d.getLooper());
        this.e = handler;
        this.c.setCallback(this, handler);
        this.c.configure(mediaFormat, surface, mediaCrypto, i2);
        this.g = 1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        synchronized (this.a) {
            int i2 = -1;
            if (this.f > 0) {
                return -1;
            }
            b();
            k kVar = this.b;
            if (!kVar.a.isEmpty()) {
                i2 = kVar.a.remove();
            }
            return i2;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            if (this.f > 0) {
                return -1;
            }
            b();
            return this.b.a(bufferInfo);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        synchronized (this.a) {
            this.h.flush();
            this.c.flush();
            this.f++;
            ((Handler) Util.castNonNull(this.e)).post(new Runnable() { // from class: a2.j.b.b.v0.a
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar = g.this;
                    synchronized (gVar.a) {
                        if (gVar.g != 3) {
                            long j = gVar.f - 1;
                            gVar.f = j;
                            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                            if (i2 <= 0) {
                                if (i2 < 0) {
                                    gVar.i = new IllegalStateException();
                                } else {
                                    gVar.b.b();
                                    try {
                                        gVar.c.start();
                                    } catch (IllegalStateException e2) {
                                        gVar.i = e2;
                                    } catch (Exception e3) {
                                        gVar.i = new IllegalStateException(e3);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaCodec getCodec() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        synchronized (this.a) {
            mediaFormat = this.b.e;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.a) {
            this.b.g = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        synchronized (this.a) {
            this.b.a.add(i2);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            this.b.onOutputBufferAvailable(mediaCodec, i2, bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.a) {
            this.b.onOutputFormatChanged(mediaCodec, mediaFormat);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i2, int i3, int i4, long j, int i5) {
        this.h.queueInputBuffer(i2, i3, i4, j, i5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int i2, int i3, CryptoInfo cryptoInfo, long j, int i4) {
        this.h.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
        synchronized (this.a) {
            if (this.g == 2) {
                this.h.shutdown();
            }
            int i2 = this.g;
            if (i2 == 1 || i2 == 2) {
                this.d.quit();
                this.b.b();
                this.f++;
            }
            this.g = 3;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        this.h.start();
        this.c.start();
        this.g = 2;
    }
}
