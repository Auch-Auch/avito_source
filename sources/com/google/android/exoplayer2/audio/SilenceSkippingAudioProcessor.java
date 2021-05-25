package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    public static final long DEFAULT_MINIMUM_SILENCE_DURATION_US = 150000;
    public static final long DEFAULT_PADDING_SILENCE_US = 20000;
    public static final short DEFAULT_SILENCE_THRESHOLD_LEVEL = 1024;
    public final long f;
    public final long g;
    public final short h;
    public int i;
    public boolean j;
    public byte[] k;
    public byte[] l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;

    public SilenceSkippingAudioProcessor() {
        this(DEFAULT_MINIMUM_SILENCE_DURATION_US, DEFAULT_PADDING_SILENCE_US, DEFAULT_SILENCE_THRESHOLD_LEVEL);
    }

    public final int a(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.h) {
                int i2 = this.i;
                return (position / i2) * i2;
            }
        }
        return byteBuffer.limit();
    }

    public final void b(byte[] bArr, int i2) {
        replaceOutputBuffer(i2).put(bArr, 0, i2).flip();
        if (i2 > 0) {
            this.p = true;
        }
    }

    public final void c(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int min = Math.min(byteBuffer.remaining(), this.o);
        int i3 = this.o - min;
        System.arraycopy(bArr, i2 - i3, this.l, 0, i3);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.l, i3, min);
    }

    public long getSkippedFrames() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            return this.j ? audioFormat : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.j) {
            AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
            int i2 = audioFormat.bytesPerFrame;
            this.i = i2;
            long j2 = this.f;
            long j3 = (long) audioFormat.sampleRate;
            int i3 = ((int) ((j2 * j3) / 1000000)) * i2;
            if (this.k.length != i3) {
                this.k = new byte[i3];
            }
            int i4 = ((int) ((this.g * j3) / 1000000)) * i2;
            this.o = i4;
            if (this.l.length != i4) {
                this.l = new byte[i4];
            }
        }
        this.m = 0;
        this.q = 0;
        this.n = 0;
        this.p = false;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        int i2 = this.n;
        if (i2 > 0) {
            b(this.k, i2);
        }
        if (!this.p) {
            this.q += (long) (this.o / this.i);
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.j = false;
        this.o = 0;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.k = bArr;
        this.l = bArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !hasPendingOutput()) {
            int i2 = this.m;
            if (i2 == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.k.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.getShort(limit2)) > this.h) {
                            int i3 = this.i;
                            position = ((limit2 / i3) * i3) + i3;
                            break;
                        }
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.m = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    replaceOutputBuffer(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.p = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i2 == 1) {
                int limit3 = byteBuffer.limit();
                int a = a(byteBuffer);
                int position2 = a - byteBuffer.position();
                byte[] bArr = this.k;
                int length = bArr.length;
                int i4 = this.n;
                int i5 = length - i4;
                if (a >= limit3 || position2 >= i5) {
                    int min = Math.min(position2, i5);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.k, this.n, min);
                    int i6 = this.n + min;
                    this.n = i6;
                    byte[] bArr2 = this.k;
                    if (i6 == bArr2.length) {
                        if (this.p) {
                            b(bArr2, this.o);
                            this.q += (long) ((this.n - (this.o * 2)) / this.i);
                        } else {
                            this.q += (long) ((i6 - this.o) / this.i);
                        }
                        c(byteBuffer, this.k, this.n);
                        this.n = 0;
                        this.m = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    b(bArr, i4);
                    this.n = 0;
                    this.m = 0;
                }
            } else if (i2 == 2) {
                int limit4 = byteBuffer.limit();
                int a3 = a(byteBuffer);
                byteBuffer.limit(a3);
                this.q += (long) (byteBuffer.remaining() / this.i);
                c(byteBuffer, this.l, this.o);
                if (a3 < limit4) {
                    b(this.l, this.o);
                    this.m = 0;
                    byteBuffer.limit(limit4);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void setEnabled(boolean z) {
        this.j = z;
    }

    public SilenceSkippingAudioProcessor(long j2, long j3, short s) {
        Assertions.checkArgument(j3 <= j2);
        this.f = j2;
        this.g = j3;
        this.h = s;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.k = bArr;
        this.l = bArr;
    }
}
