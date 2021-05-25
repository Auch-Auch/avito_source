package com.otaliastudios.cameraview.video.encoding;

import a2.m.a.d.a.d;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
@RequiresApi(api = 18)
public class AudioMediaEncoder extends MediaEncoder {
    public static final CameraLogger y = CameraLogger.create(AudioMediaEncoder.class.getSimpleName());
    public boolean p = false;
    public b q;
    public c r;
    public a2.m.a.d.a.c s;
    public final a2.m.a.d.a.b t;
    public AudioConfig u;
    public d v = new d();
    public final LinkedBlockingQueue<InputBuffer> w = new LinkedBlockingQueue<>();
    public a2.m.a.d.a.a x;

    public class b extends Thread {
        public b(a aVar) {
        }

        public final void a(@NonNull InputBuffer inputBuffer) {
            long nanoTime = System.nanoTime() / 1000000;
            CameraLogger cameraLogger = AudioMediaEncoder.y;
            cameraLogger.v("encoding thread - performing pending operation for timestamp:", Long.valueOf(inputBuffer.timestamp), "- encoding.");
            inputBuffer.data.put(inputBuffer.source);
            AudioMediaEncoder.this.s.recycle(inputBuffer.source);
            AudioMediaEncoder.this.w.remove(inputBuffer);
            AudioMediaEncoder.this.encodeInputBuffer(inputBuffer);
            boolean z = inputBuffer.isEndOfStream;
            AudioMediaEncoder.this.v.recycle(inputBuffer);
            cameraLogger.v("encoding thread - performing pending operation for timestamp:", Long.valueOf(inputBuffer.timestamp), "- draining.");
            AudioMediaEncoder.this.drainOutput(z);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (!AudioMediaEncoder.this.w.isEmpty()) {
                    AudioMediaEncoder.y.v("encoding thread - performing", Integer.valueOf(AudioMediaEncoder.this.w.size()), "pending operations.");
                    while (true) {
                        InputBuffer peek = AudioMediaEncoder.this.w.peek();
                        if (peek == null) {
                            continue;
                            break;
                        } else if (peek.isEndOfStream) {
                            AudioMediaEncoder.this.acquireInputBuffer(peek);
                            a(peek);
                            AudioMediaEncoder.this.v.clear();
                            return;
                        } else if (AudioMediaEncoder.this.tryAcquireInputBuffer(peek)) {
                            a(peek);
                        } else {
                            AudioMediaEncoder.c(AudioMediaEncoder.this, 3);
                        }
                    }
                } else {
                    AudioMediaEncoder.c(AudioMediaEncoder.this, 3);
                }
            }
        }
    }

    public class c extends Thread {
        public AudioRecord a;
        public ByteBuffer b;
        public int c;
        public long d;
        public long e = Long.MIN_VALUE;

        public c(a aVar) {
            setPriority(10);
            AudioConfig audioConfig = AudioMediaEncoder.this.u;
            int i = audioConfig.samplingFrequency;
            int a3 = audioConfig.a();
            AudioMediaEncoder.this.u.getClass();
            int minBufferSize = AudioRecord.getMinBufferSize(i, a3, 2);
            int i2 = AudioMediaEncoder.this.u.channels * 1024 * 50;
            while (i2 < minBufferSize) {
                i2 += AudioMediaEncoder.this.u.channels * 1024;
            }
            AudioConfig audioConfig2 = AudioMediaEncoder.this.u;
            int i3 = audioConfig2.samplingFrequency;
            int a4 = audioConfig2.a();
            AudioMediaEncoder.this.u.getClass();
            this.a = new AudioRecord(5, i3, a4, 2, i2);
        }

        public final void a(@NonNull ByteBuffer byteBuffer, long j, boolean z) {
            int remaining = byteBuffer.remaining();
            InputBuffer inputBuffer = (InputBuffer) AudioMediaEncoder.this.v.get();
            inputBuffer.source = byteBuffer;
            inputBuffer.timestamp = j;
            inputBuffer.length = remaining;
            inputBuffer.isEndOfStream = z;
            AudioMediaEncoder.this.w.add(inputBuffer);
        }

        public final boolean b(boolean z) {
            long j;
            int i;
            ByteBuffer byteBuffer = (ByteBuffer) AudioMediaEncoder.this.s.get();
            this.b = byteBuffer;
            if (byteBuffer == null) {
                if (z) {
                    AudioMediaEncoder.y.v("read thread - eos: true - No buffer, retrying.");
                } else {
                    AudioMediaEncoder.y.w("read thread - eos: false - Skipping audio frame,", "encoding is too slow.");
                    AudioMediaEncoder.c(AudioMediaEncoder.this, 6);
                }
                return false;
            }
            byteBuffer.clear();
            this.c = this.a.read(this.b, AudioMediaEncoder.this.u.channels * 1024);
            CameraLogger cameraLogger = AudioMediaEncoder.y;
            cameraLogger.v("read thread - eos:", Boolean.valueOf(z), "- Read new audio frame. Bytes:", Integer.valueOf(this.c));
            int i2 = this.c;
            if (i2 > 0) {
                a2.m.a.d.a.b bVar = AudioMediaEncoder.this.t;
                long j2 = (long) i2;
                long a3 = a2.m.a.d.a.b.a(j2, bVar.a);
                long nanoTime = (System.nanoTime() / 1000) - a3;
                long j3 = bVar.c;
                if (j3 == 0) {
                    bVar.b = nanoTime;
                }
                long a4 = a2.m.a.d.a.b.a(j3, bVar.a) + bVar.b;
                long j4 = nanoTime - a4;
                if (j4 >= a3 * 2) {
                    bVar.b = nanoTime;
                    j = j2;
                    bVar.c = j;
                    bVar.d = j4;
                } else {
                    j = j2;
                    bVar.d = 0;
                    bVar.c += j;
                    nanoTime = a4;
                }
                this.d = nanoTime;
                if (this.e == Long.MIN_VALUE) {
                    this.e = nanoTime;
                    AudioMediaEncoder.this.notifyFirstFrameMillis(System.currentTimeMillis() - ((j * 1000) / ((long) AudioMediaEncoder.this.u.b())));
                }
                if (!AudioMediaEncoder.this.hasReachedMaxLength()) {
                    if ((this.d - this.e > AudioMediaEncoder.this.getMaxLengthUs()) && !z) {
                        cameraLogger.w("read thread - this frame reached the maxLength! deltaUs:", Long.valueOf(this.d - this.e));
                        AudioMediaEncoder.this.notifyMaxLengthReached();
                    }
                }
                AudioMediaEncoder audioMediaEncoder = AudioMediaEncoder.this;
                a2.m.a.d.a.b bVar2 = audioMediaEncoder.t;
                int i3 = audioMediaEncoder.u.channels * 1024;
                if (bVar2.d == 0) {
                    i = 0;
                } else {
                    i = (int) (bVar2.d / a2.m.a.d.a.b.a((long) i3, bVar2.a));
                }
                if (i > 0) {
                    AudioMediaEncoder audioMediaEncoder2 = AudioMediaEncoder.this;
                    long j5 = this.d - audioMediaEncoder2.t.d;
                    AudioConfig audioConfig = audioMediaEncoder2.u;
                    long a5 = a2.m.a.d.a.b.a((long) (audioConfig.channels * 1024), audioConfig.b());
                    int i4 = 8;
                    cameraLogger.w("read thread - GAPS: trying to add", Integer.valueOf(i), "noise buffers. PERFORMANCE_MAX_GAPS:", 8);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= Math.min(i, i4)) {
                            break;
                        }
                        ByteBuffer byteBuffer2 = (ByteBuffer) AudioMediaEncoder.this.s.get();
                        if (byteBuffer2 == null) {
                            AudioMediaEncoder.y.e("read thread - GAPS: aborting because we have no free buffer.");
                            break;
                        }
                        byteBuffer2.clear();
                        a2.m.a.d.a.a aVar = AudioMediaEncoder.this.x;
                        aVar.a.clear();
                        if (aVar.a.capacity() == byteBuffer2.remaining()) {
                            aVar.a.position(0);
                        } else {
                            ByteBuffer byteBuffer3 = aVar.a;
                            byteBuffer3.position(a2.m.a.d.a.a.b.nextInt(byteBuffer3.capacity() - byteBuffer2.remaining()));
                        }
                        ByteBuffer byteBuffer4 = aVar.a;
                        byteBuffer4.limit(byteBuffer2.remaining() + byteBuffer4.position());
                        byteBuffer2.put(aVar.a);
                        byteBuffer2.rewind();
                        a(byteBuffer2, j5, false);
                        j5 += a5;
                        i5++;
                        i4 = 8;
                    }
                }
                AudioMediaEncoder.y.v("read thread - eos:", Boolean.valueOf(z), "- mLastTimeUs:", Long.valueOf(this.d));
                this.b.limit(this.c);
                a(this.b, this.d, z);
            } else if (i2 == -3) {
                cameraLogger.e("read thread - eos:", Boolean.valueOf(z), "- Got AudioRecord.ERROR_INVALID_OPERATION");
            } else if (i2 == -2) {
                cameraLogger.e("read thread - eos:", Boolean.valueOf(z), "- Got AudioRecord.ERROR_BAD_VALUE");
                return true;
            }
            return true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z;
            this.a.startRecording();
            while (true) {
                AudioMediaEncoder audioMediaEncoder = AudioMediaEncoder.this;
                z = false;
                if (audioMediaEncoder.p) {
                    break;
                } else if (!audioMediaEncoder.hasReachedMaxLength()) {
                    b(false);
                }
            }
            AudioMediaEncoder.y.w("Stop was requested. We're out of the loop. Will post an endOfStream.");
            while (!z) {
                z = b(true);
            }
            this.a.stop();
            this.a.release();
            this.a = null;
        }
    }

    public AudioMediaEncoder(@NonNull AudioConfig audioConfig) {
        super("AudioEncoder");
        new HashMap();
        Objects.requireNonNull(audioConfig);
        AudioConfig audioConfig2 = new AudioConfig();
        audioConfig2.bitRate = audioConfig.bitRate;
        audioConfig2.channels = audioConfig.channels;
        audioConfig2.encoder = audioConfig.encoder;
        audioConfig2.mimeType = audioConfig.mimeType;
        audioConfig2.samplingFrequency = audioConfig.samplingFrequency;
        this.u = audioConfig2;
        this.t = new a2.m.a.d.a.b(audioConfig2.b());
        this.q = new b(null);
        this.r = new c(null);
    }

    public static void c(AudioMediaEncoder audioMediaEncoder, int i) {
        Objects.requireNonNull(audioMediaEncoder);
        try {
            AudioConfig audioConfig = audioMediaEncoder.u;
            Thread.sleep((((long) ((audioConfig.channels * 1024) * i)) * 1000) / ((long) audioConfig.b()));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public int getEncodedBitRate() {
        return this.u.bitRate;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onPrepare(@NonNull MediaEncoderEngine.Controller controller, long j) {
        AudioConfig audioConfig = this.u;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(audioConfig.mimeType, audioConfig.samplingFrequency, audioConfig.channels);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", this.u.a());
        createAudioFormat.setInteger("bitrate", this.u.bitRate);
        try {
            AudioConfig audioConfig2 = this.u;
            String str = audioConfig2.encoder;
            if (str != null) {
                this.mMediaCodec = MediaCodec.createByCodecName(str);
            } else {
                this.mMediaCodec = MediaCodec.createEncoderByType(audioConfig2.mimeType);
            }
            this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mMediaCodec.start();
            AudioConfig audioConfig3 = this.u;
            Objects.requireNonNull(audioConfig3);
            this.s = new a2.m.a.d.a.c(audioConfig3.channels * 1024, 500);
            this.x = new a2.m.a.d.a.a(this.u);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onStart() {
        this.p = false;
        this.r.start();
        this.q.start();
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onStop() {
        this.p = true;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void onStopped() {
        super.onStopped();
        this.p = false;
        this.q = null;
        this.r = null;
        a2.m.a.d.a.c cVar = this.s;
        if (cVar != null) {
            cVar.clear();
            this.s = null;
        }
    }
}
