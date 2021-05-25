package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
public final class TeeAudioProcessor extends BaseAudioProcessor {
    public final AudioBufferSink f;

    public interface AudioBufferSink {
        void flush(int i, int i2, int i3);

        void handleBuffer(ByteBuffer byteBuffer);
    }

    public static final class WavFileAudioBufferSink implements AudioBufferSink {
        public final String a;
        public final byte[] b;
        public final ByteBuffer c;
        public int d;
        public int e;
        public int f;
        @Nullable
        public RandomAccessFile g;
        public int h;
        public int i;

        public WavFileAudioBufferSink(String str) {
            this.a = str;
            byte[] bArr = new byte[1024];
            this.b = bArr;
            this.c = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        }

        public final void a() throws IOException {
            if (this.g == null) {
                int i2 = this.h;
                this.h = i2 + 1;
                RandomAccessFile randomAccessFile = new RandomAccessFile(Util.formatInvariant("%s-%04d.wav", this.a, Integer.valueOf(i2)), "rw");
                randomAccessFile.writeInt(WavUtil.RIFF_FOURCC);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(WavUtil.WAVE_FOURCC);
                randomAccessFile.writeInt(WavUtil.FMT_FOURCC);
                this.c.clear();
                this.c.putInt(16);
                this.c.putShort((short) WavUtil.getTypeForPcmEncoding(this.f));
                this.c.putShort((short) this.e);
                this.c.putInt(this.d);
                int pcmFrameSize = Util.getPcmFrameSize(this.f, this.e);
                this.c.putInt(this.d * pcmFrameSize);
                this.c.putShort((short) pcmFrameSize);
                this.c.putShort((short) ((pcmFrameSize * 8) / this.e));
                randomAccessFile.write(this.b, 0, this.c.position());
                randomAccessFile.writeInt(WavUtil.DATA_FOURCC);
                randomAccessFile.writeInt(-1);
                this.g = randomAccessFile;
                this.i = 44;
            }
        }

        public final void b() throws IOException {
            RandomAccessFile randomAccessFile = this.g;
            if (randomAccessFile != null) {
                try {
                    this.c.clear();
                    this.c.putInt(this.i - 8);
                    randomAccessFile.seek(4);
                    randomAccessFile.write(this.b, 0, 4);
                    this.c.clear();
                    this.c.putInt(this.i - 44);
                    randomAccessFile.seek(40);
                    randomAccessFile.write(this.b, 0, 4);
                } catch (IOException e2) {
                    Log.w("WaveFileAudioBufferSink", "Error updating file size", e2);
                }
                RandomAccessFile randomAccessFile2 = null;
                try {
                    randomAccessFile.close();
                } finally {
                    this.g = randomAccessFile2;
                }
            }
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int i2, int i3, int i4) {
            try {
                b();
            } catch (IOException e2) {
                Log.e("WaveFileAudioBufferSink", "Error resetting", e2);
            }
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(ByteBuffer byteBuffer) {
            try {
                a();
                RandomAccessFile randomAccessFile = (RandomAccessFile) Assertions.checkNotNull(this.g);
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), this.b.length);
                    byteBuffer.get(this.b, 0, min);
                    randomAccessFile.write(this.b, 0, min);
                    this.i += min;
                }
            } catch (IOException e2) {
                Log.e("WaveFileAudioBufferSink", "Error writing data", e2);
            }
        }
    }

    public TeeAudioProcessor(AudioBufferSink audioBufferSink) {
        this.f = (AudioBufferSink) Assertions.checkNotNull(audioBufferSink);
    }

    public final void a() {
        if (isActive()) {
            AudioBufferSink audioBufferSink = this.f;
            AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
            audioBufferSink.flush(audioFormat.sampleRate, audioFormat.channelCount, audioFormat.encoding);
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        a();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        a();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining != 0) {
            this.f.handleBuffer(byteBuffer.asReadOnlyBuffer());
            replaceOutputBuffer(remaining).put(byteBuffer).flip();
        }
    }
}
