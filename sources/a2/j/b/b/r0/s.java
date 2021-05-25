package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
public final class s extends BaseAudioProcessor {
    public int f;
    public int g;
    public boolean h;
    public int i;
    public byte[] j = Util.EMPTY_BYTE_ARRAY;
    public int k;
    public long l;

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i2;
        if (super.isEnded() && (i2 = this.k) > 0) {
            replaceOutputBuffer(i2).put(this.j, 0, this.k).flip();
            this.k = 0;
        }
        return super.getOutput();
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.k == 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            this.h = true;
            return (this.f == 0 && this.g == 0) ? AudioProcessor.AudioFormat.NOT_SET : audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onFlush() {
        if (this.h) {
            this.h = false;
            int i2 = this.g;
            int i3 = this.inputAudioFormat.bytesPerFrame;
            this.j = new byte[(i2 * i3)];
            this.i = this.f * i3;
        }
        this.k = 0;
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onQueueEndOfStream() {
        if (this.h) {
            int i2 = this.k;
            if (i2 > 0) {
                this.l += (long) (i2 / this.inputAudioFormat.bytesPerFrame);
            }
            this.k = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.BaseAudioProcessor
    public void onReset() {
        this.j = Util.EMPTY_BYTE_ARRAY;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            int min = Math.min(i2, this.i);
            this.l += (long) (min / this.inputAudioFormat.bytesPerFrame);
            this.i -= min;
            byteBuffer.position(position + min);
            if (this.i <= 0) {
                int i3 = i2 - min;
                int length = (this.k + i3) - this.j.length;
                ByteBuffer replaceOutputBuffer = replaceOutputBuffer(length);
                int constrainValue = Util.constrainValue(length, 0, this.k);
                replaceOutputBuffer.put(this.j, 0, constrainValue);
                int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i3);
                byteBuffer.limit(byteBuffer.position() + constrainValue2);
                replaceOutputBuffer.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - constrainValue2;
                int i5 = this.k - constrainValue;
                this.k = i5;
                byte[] bArr = this.j;
                System.arraycopy(bArr, constrainValue, bArr, 0, i5);
                byteBuffer.get(this.j, this.k, i4);
                this.k += i4;
                replaceOutputBuffer.flip();
            }
        }
    }
}
