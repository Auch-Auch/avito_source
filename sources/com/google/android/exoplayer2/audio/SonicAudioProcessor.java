package com.google.android.exoplayer2.audio;

import a2.j.b.b.r0.r;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Objects;
public final class SonicAudioProcessor implements AudioProcessor {
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    public int a;
    public float b = 1.0f;
    public float c = 1.0f;
    public AudioProcessor.AudioFormat d;
    public AudioProcessor.AudioFormat e;
    public AudioProcessor.AudioFormat f;
    public AudioProcessor.AudioFormat g;
    public boolean h;
    @Nullable
    public r i;
    public ByteBuffer j;
    public ShortBuffer k;
    public ByteBuffer l;
    public long m;
    public long n;
    public boolean o;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.d = audioFormat;
        this.e = audioFormat;
        this.f = audioFormat;
        this.g = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.j = byteBuffer;
        this.k = byteBuffer.asShortBuffer();
        this.l = byteBuffer;
        this.a = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            int i2 = this.a;
            if (i2 == -1) {
                i2 = audioFormat.sampleRate;
            }
            this.d = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i2, audioFormat.channelCount, 2);
            this.e = audioFormat2;
            this.h = true;
            return audioFormat2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.d;
            this.f = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.e;
            this.g = audioFormat2;
            if (this.h) {
                this.i = new r(audioFormat.sampleRate, audioFormat.channelCount, this.b, this.c, audioFormat2.sampleRate);
            } else {
                r rVar = this.i;
                if (rVar != null) {
                    rVar.k = 0;
                    rVar.m = 0;
                    rVar.o = 0;
                    rVar.p = 0;
                    rVar.q = 0;
                    rVar.r = 0;
                    rVar.s = 0;
                    rVar.t = 0;
                    rVar.u = 0;
                    rVar.v = 0;
                }
            }
        }
        this.l = AudioProcessor.EMPTY_BUFFER;
        this.m = 0;
        this.n = 0;
        this.o = false;
    }

    public long getMediaDuration(long j2) {
        if (this.n < 1024) {
            return (long) (((double) this.b) * ((double) j2));
        }
        long j3 = this.m;
        r rVar = (r) Assertions.checkNotNull(this.i);
        long j4 = j3 - ((long) ((rVar.k * rVar.b) * 2));
        int i2 = this.g.sampleRate;
        int i3 = this.f.sampleRate;
        if (i2 == i3) {
            return Util.scaleLargeTimestamp(j2, j4, this.n);
        }
        return Util.scaleLargeTimestamp(j2, j4 * ((long) i2), this.n * ((long) i3));
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.l;
        this.l = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.e.sampleRate != -1 && (Math.abs(this.b - 1.0f) >= 0.01f || Math.abs(this.c - 1.0f) >= 0.01f || this.e.sampleRate != this.d.sampleRate);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        r rVar;
        return this.o && ((rVar = this.i) == null || (rVar.m * rVar.b) * 2 == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        int i2;
        r rVar = this.i;
        if (rVar != null) {
            int i3 = rVar.k;
            float f2 = rVar.c;
            float f3 = rVar.d;
            float f4 = rVar.e * f3;
            int i4 = rVar.m + ((int) ((((((float) i3) / (f2 / f3)) + ((float) rVar.o)) / f4) + 0.5f));
            rVar.j = rVar.c(rVar.j, i3, (rVar.h * 2) + i3);
            int i5 = 0;
            while (true) {
                i2 = rVar.h * 2;
                int i6 = rVar.b;
                if (i5 >= i2 * i6) {
                    break;
                }
                rVar.j[(i6 * i3) + i5] = 0;
                i5++;
            }
            rVar.k = i2 + rVar.k;
            rVar.f();
            if (rVar.m > i4) {
                rVar.m = i4;
            }
            rVar.k = 0;
            rVar.r = 0;
            rVar.o = 0;
        }
        this.o = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        r rVar = (r) Assertions.checkNotNull(this.i);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.m += (long) remaining;
            Objects.requireNonNull(rVar);
            int remaining2 = asShortBuffer.remaining();
            int i2 = rVar.b;
            int i3 = remaining2 / i2;
            short[] c2 = rVar.c(rVar.j, rVar.k, i3);
            rVar.j = c2;
            asShortBuffer.get(c2, rVar.k * rVar.b, ((i2 * i3) * 2) / 2);
            rVar.k += i3;
            rVar.f();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i4 = rVar.m * rVar.b * 2;
        if (i4 > 0) {
            if (this.j.capacity() < i4) {
                ByteBuffer order = ByteBuffer.allocateDirect(i4).order(ByteOrder.nativeOrder());
                this.j = order;
                this.k = order.asShortBuffer();
            } else {
                this.j.clear();
                this.k.clear();
            }
            ShortBuffer shortBuffer = this.k;
            int min = Math.min(shortBuffer.remaining() / rVar.b, rVar.m);
            shortBuffer.put(rVar.l, 0, rVar.b * min);
            int i5 = rVar.m - min;
            rVar.m = i5;
            short[] sArr = rVar.l;
            int i6 = rVar.b;
            System.arraycopy(sArr, min * i6, sArr, 0, i5 * i6);
            this.n += (long) i4;
            this.j.limit(i4);
            this.l = this.j;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.b = 1.0f;
        this.c = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.d = audioFormat;
        this.e = audioFormat;
        this.f = audioFormat;
        this.g = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.j = byteBuffer;
        this.k = byteBuffer.asShortBuffer();
        this.l = byteBuffer;
        this.a = -1;
        this.h = false;
        this.i = null;
        this.m = 0;
        this.n = 0;
        this.o = false;
    }

    public void setOutputSampleRateHz(int i2) {
        this.a = i2;
    }

    public void setPitch(float f2) {
        if (this.c != f2) {
            this.c = f2;
            this.h = true;
        }
    }

    public void setSpeed(float f2) {
        if (this.b != f2) {
            this.b = f2;
            this.h = true;
        }
    }
}
