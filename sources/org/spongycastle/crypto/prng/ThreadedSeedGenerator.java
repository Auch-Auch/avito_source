package org.spongycastle.crypto.prng;
public class ThreadedSeedGenerator {

    public class b implements Runnable {
        public volatile int a = 0;
        public volatile boolean b = false;

        public b(ThreadedSeedGenerator threadedSeedGenerator, a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.b) {
                this.a++;
            }
        }
    }

    public byte[] generateSeed(int i, boolean z) {
        b bVar = new b(this, null);
        Thread thread = new Thread(bVar);
        byte[] bArr = new byte[i];
        bVar.a = 0;
        bVar.b = false;
        thread.start();
        if (!z) {
            i *= 8;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            while (bVar.a == i2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException unused) {
                }
            }
            i2 = bVar.a;
            if (z) {
                bArr[i3] = (byte) (i2 & 255);
            } else {
                int i4 = i3 / 8;
                bArr[i4] = (byte) ((bArr[i4] << 1) | (i2 & 1));
            }
        }
        bVar.b = true;
        return bArr;
    }
}
