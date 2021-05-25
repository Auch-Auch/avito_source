package a2.j.b.b.v0;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.CryptoInfo;
public class n implements l {
    public final MediaCodec a;

    public n(MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    @Override // a2.j.b.b.v0.l
    public void flush() {
    }

    @Override // a2.j.b.b.v0.l
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // a2.j.b.b.v0.l
    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.a.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    @Override // a2.j.b.b.v0.l
    public void shutdown() {
    }

    @Override // a2.j.b.b.v0.l
    public void start() {
    }
}
