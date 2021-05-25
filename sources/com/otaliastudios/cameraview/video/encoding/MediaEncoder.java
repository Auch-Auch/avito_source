package com.otaliastudios.cameraview.video.encoding;

import a2.b.a.a.a;
import a2.m.a.d.a.e;
import a2.m.a.d.a.j;
import android.annotation.SuppressLint;
import android.media.MediaCodec;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
@RequiresApi(api = 18)
public abstract class MediaEncoder {
    public static final CameraLogger o = CameraLogger.create(MediaEncoder.class.getSimpleName());
    public int a = 0;
    public final String b;
    public MediaEncoderEngine.Controller c;
    public int d;
    public j e;
    public MediaCodec.BufferInfo f;
    public e g;
    public final Map<String, AtomicInteger> h = new HashMap();
    public long i;
    public boolean j;
    public long k = 0;
    public long l = Long.MIN_VALUE;
    public long m = 0;
    public MediaCodec mMediaCodec;
    public WorkerHandler mWorker;
    public long n = Long.MIN_VALUE;

    public MediaEncoder(@NonNull String str) {
        this.b = str;
    }

    public final void a() {
        if (this.j) {
            o.w(this.b, "onMaxLengthReached: Called twice.");
            return;
        }
        this.j = true;
        int i2 = this.a;
        if (i2 >= 5) {
            o.w(this.b, "onMaxLengthReached: Reached in wrong state. Aborting.", Integer.valueOf(i2));
            return;
        }
        o.w(this.b, "onMaxLengthReached: Requesting a stop.");
        b(5);
        this.c.requestStop(this.d);
    }

    public void acquireInputBuffer(@NonNull InputBuffer inputBuffer) {
        do {
        } while (!tryAcquireInputBuffer(inputBuffer));
    }

    public final void b(int i2) {
        if (this.n == Long.MIN_VALUE) {
            this.n = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.n;
        this.n = System.currentTimeMillis();
        String str = null;
        switch (i2) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "PREPARING";
                break;
            case 2:
                str = "PREPARED";
                break;
            case 3:
                str = "STARTING";
                break;
            case 4:
                str = "STARTED";
                break;
            case 5:
                str = "LIMIT_REACHED";
                break;
            case 6:
                str = "STOPPING";
                break;
            case 7:
                str = "STOPPED";
                break;
        }
        o.w(this.b, "setState:", str, "millisSinceLastState:", Long.valueOf(currentTimeMillis));
        this.a = i2;
    }

    @SuppressLint({"LogNotTimber"})
    public final void drainOutput(boolean z) {
        CameraLogger cameraLogger = o;
        cameraLogger.i(this.b, "DRAINING - EOS:", Boolean.valueOf(z));
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            cameraLogger.e("drain() was called before prepare() or after releasing.");
            return;
        }
        if (this.g == null) {
            this.g = new e(mediaCodec);
        }
        while (true) {
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.f, 0);
            CameraLogger cameraLogger2 = o;
            cameraLogger2.i(this.b, "DRAINING - Got status:", Integer.valueOf(dequeueOutputBuffer));
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                Objects.requireNonNull(this.g);
            } else if (dequeueOutputBuffer == -2) {
                if (!this.c.isStarted()) {
                    this.d = this.c.notifyStarted(this.mMediaCodec.getOutputFormat());
                    b(4);
                    this.e = new j(this.d);
                } else {
                    throw new RuntimeException("MediaFormat changed twice.");
                }
            } else if (dequeueOutputBuffer < 0) {
                cameraLogger2.e(a.M2("Unexpected result from dequeueOutputBuffer: ", dequeueOutputBuffer));
            } else {
                ByteBuffer outputBuffer = this.g.a.getOutputBuffer(dequeueOutputBuffer);
                if (!((this.f.flags & 2) != 0) && this.c.isStarted()) {
                    MediaCodec.BufferInfo bufferInfo = this.f;
                    if (bufferInfo.size != 0) {
                        outputBuffer.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.f;
                        outputBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                        if (this.l == Long.MIN_VALUE) {
                            long j2 = this.f.presentationTimeUs;
                            this.l = j2;
                            cameraLogger2.w(this.b, "DRAINING - Got the first presentation time:", Long.valueOf(j2));
                        }
                        MediaCodec.BufferInfo bufferInfo3 = this.f;
                        long j3 = bufferInfo3.presentationTimeUs;
                        this.m = j3;
                        long j4 = ((this.k * 1000) + j3) - this.l;
                        bufferInfo3.presentationTimeUs = j4;
                        cameraLogger2.v(this.b, "DRAINING - About to write(). Adjusted presentation:", Long.valueOf(j4));
                        OutputBuffer outputBuffer2 = (OutputBuffer) this.e.get();
                        outputBuffer2.info = this.f;
                        outputBuffer2.trackIndex = this.d;
                        outputBuffer2.data = outputBuffer;
                        onWriteOutput(this.e, outputBuffer2);
                    }
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (!z && !this.j) {
                    long j5 = this.l;
                    if (j5 != Long.MIN_VALUE) {
                        long j6 = this.m;
                        if (j6 - j5 > this.i) {
                            cameraLogger2.w(this.b, "DRAINING - Reached maxLength! mLastTimeUs:", Long.valueOf(j6), "mStartTimeUs:", Long.valueOf(this.l), "mDeltaUs:", Long.valueOf(this.m - this.l), "mMaxLengthUs:", Long.valueOf(this.i));
                            a();
                            return;
                        }
                    }
                }
                if ((this.f.flags & 4) != 0) {
                    cameraLogger2.w(this.b, "DRAINING - Got EOS. Releasing the codec.");
                    onStopped();
                    return;
                }
            }
        }
    }

    public void encodeInputBuffer(InputBuffer inputBuffer) {
        o.v(this.b, "ENCODING - Buffer:", Integer.valueOf(inputBuffer.index), "Bytes:", Integer.valueOf(inputBuffer.length), "Presentation:", Long.valueOf(inputBuffer.timestamp));
        if (inputBuffer.isEndOfStream) {
            this.mMediaCodec.queueInputBuffer(inputBuffer.index, 0, 0, inputBuffer.timestamp, 4);
        } else {
            this.mMediaCodec.queueInputBuffer(inputBuffer.index, 0, inputBuffer.length, inputBuffer.timestamp, 0);
        }
    }

    public abstract int getEncodedBitRate();

    public long getMaxLengthUs() {
        return this.i;
    }

    public final int getPendingEvents(@NonNull String str) {
        return this.h.get(str).intValue();
    }

    public boolean hasReachedMaxLength() {
        return this.j;
    }

    public final void notifyFirstFrameMillis(long j2) {
        this.k = j2;
    }

    public void notifyMaxLengthReached() {
        a();
    }

    @EncoderThread
    public void onEvent(@NonNull String str, @Nullable Object obj) {
    }

    @EncoderThread
    public abstract void onPrepare(@NonNull MediaEncoderEngine.Controller controller, long j2);

    @EncoderThread
    public abstract void onStart();

    @EncoderThread
    public abstract void onStop();

    @CallSuper
    public void onStopped() {
        o.w(this.b, "is being released. Notifying controller and releasing codecs.");
        this.c.notifyStopped(this.d);
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        this.mMediaCodec = null;
        this.e.clear();
        this.e = null;
        this.g = null;
        b(7);
        this.mWorker.destroy();
    }

    @CallSuper
    public void onWriteOutput(@NonNull j jVar, @NonNull OutputBuffer outputBuffer) {
        this.c.write(jVar, outputBuffer);
    }

    public boolean tryAcquireInputBuffer(@NonNull InputBuffer inputBuffer) {
        if (this.g == null) {
            this.g = new e(this.mMediaCodec);
        }
        int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(0);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        inputBuffer.index = dequeueInputBuffer;
        inputBuffer.data = this.g.a.getInputBuffer(dequeueInputBuffer);
        return true;
    }
}
