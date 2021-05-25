package a2.j.b.b.v0;

import com.google.android.exoplayer2.decoder.CryptoInfo;
public interface l {
    void flush();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3);

    void shutdown();

    void start();
}
