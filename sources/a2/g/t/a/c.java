package a2.g.t.a;

import java.io.FileInputStream;
import java.io.IOException;
public class c {
    public byte[] a = new byte[512];
    public FileInputStream b;
    public int c;
    public int d;

    public int a(byte[] bArr) throws IOException {
        int i;
        if (this.c >= this.d) {
            this.d = this.b.read(this.a);
            this.c = 0;
        }
        int i2 = 0;
        while (true) {
            i = this.d;
            if (i == -1 || i2 >= bArr.length) {
                break;
            }
            byte[] bArr2 = this.a;
            int i3 = this.c;
            if (bArr2[i3] == 10) {
                break;
            }
            bArr[i2] = bArr2[i3];
            int i4 = i3 + 1;
            this.c = i4;
            if (i4 >= i) {
                this.d = this.b.read(bArr2);
                this.c = 0;
            }
            i2++;
        }
        this.c++;
        if (i == -1) {
            return -1;
        }
        return i2;
    }

    public void b() throws IOException {
        if (this.c >= this.d) {
            this.d = this.b.read(this.a);
            this.c = 0;
        }
        while (true) {
            int i = this.d;
            if (i == -1) {
                break;
            }
            byte[] bArr = this.a;
            int i2 = this.c;
            if (bArr[i2] == 10) {
                break;
            }
            int i3 = i2 + 1;
            this.c = i3;
            if (i3 >= i) {
                this.d = this.b.read(bArr);
                this.c = 0;
            }
        }
        this.c++;
    }
}
