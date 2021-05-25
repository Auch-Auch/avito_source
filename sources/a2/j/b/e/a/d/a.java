package a2.j.b.e.a.d;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
public final class a implements o {
    public final ByteBuffer a;

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // a2.j.b.e.a.d.o
    public final long a() {
        return (long) this.a.capacity();
    }

    @Override // a2.j.b.e.a.d.o
    public final void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.a) {
            int i2 = (int) j;
            this.a.position(i2);
            this.a.limit(i2 + i);
            slice = this.a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
