package x6.e.b.c;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
public class a {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int d;
    public BlockCipher e = null;

    public a(BlockCipher blockCipher, int i) {
        this.e = blockCipher;
        this.d = i / 8;
        this.a = new byte[blockCipher.getBlockSize()];
        this.b = new byte[blockCipher.getBlockSize()];
        this.c = new byte[blockCipher.getBlockSize()];
    }

    public int a(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3 = this.d;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            this.e.processBlock(this.b, 0, this.c, 0);
            int i4 = 0;
            while (true) {
                int i5 = this.d;
                if (i4 < i5) {
                    bArr2[i2 + i4] = (byte) (this.c[i4] ^ bArr[i + i4]);
                    i4++;
                } else {
                    byte[] bArr3 = this.b;
                    System.arraycopy(bArr3, i5, bArr3, 0, bArr3.length - i5);
                    byte[] bArr4 = this.b;
                    int length = bArr4.length;
                    int i6 = this.d;
                    System.arraycopy(bArr2, i2, bArr4, length - i6, i6);
                    return this.d;
                }
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void b() {
        byte[] bArr = this.a;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.e.reset();
    }
}
