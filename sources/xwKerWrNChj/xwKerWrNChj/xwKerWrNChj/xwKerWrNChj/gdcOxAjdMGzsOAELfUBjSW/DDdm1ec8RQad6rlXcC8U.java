package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW;

import a2.b.a.a.a;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.IntIterator;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
public final class DDdm1ec8RQad6rlXcC8U {
    public static AtomicLong Cwa7EHp4RmMFhwpOCPWojiqbo = new AtomicLong(0);
    @NotNull
    public static final DDdm1ec8RQad6rlXcC8U oVTxbCNkVuXyP468Xhsl9qtSE9v = new DDdm1ec8RQad6rlXcC8U();

    @NotNull
    public final byte[] Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull byte[] bArr, int i, int i2, byte b, long j) {
        int i3 = i2 - 1;
        for (int i4 = 0; i4 <= i3; i4++) {
            long j2 = ((long) i4) * j;
            long j3 = (j2 * j2) + j2;
            long j4 = (j3 << 32) | (j3 >>> 32);
            long j5 = (j4 * j4) + j2 + j;
            long j6 = (j5 >>> 32) | (j5 << 32);
            int abs = Math.abs((int) (((j6 * j6) + j2) >>> 32));
            if (i4 < i3) {
                int i5 = i + i4;
                byte b2 = bArr[i5];
                int i6 = (abs % (i2 - i4)) + i4 + i;
                bArr[i5] = bArr[i6];
                bArr[i6] = b2;
            }
            int i7 = i + i4;
            bArr[i7] = (byte) (a.G1(b, i4, abs, 1) ^ bArr[i7]);
        }
        return bArr;
    }

    @NotNull
    public final byte[] Cwa7EHp4RmMFhwpOCPWojiqbo(long j) {
        long j2;
        long j3;
        Cwa7EHp4RmMFhwpOCPWojiqbo = new AtomicLong(j);
        Integer[] numArr = new Integer[15];
        int i = 0;
        for (int i2 = 0; i2 < 15; i2++) {
            AtomicLong atomicLong = Cwa7EHp4RmMFhwpOCPWojiqbo;
            do {
                j2 = atomicLong.get();
                j3 = ((25214903917L * j2) + 11) & 281474976710655L;
            } while (!atomicLong.compareAndSet(j2, j3));
            numArr[i2] = Integer.valueOf((int) (j3 >>> 16));
        }
        int intValue = numArr[0].intValue();
        Iterator it = e.until(1, 5).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt() * 3;
            if (numArr[nextInt].intValue() > intValue) {
                intValue = numArr[nextInt].intValue();
                i = nextInt;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.putInt(numArr[i].intValue());
        allocate.putInt(numArr[i + 1].intValue());
        allocate.putInt(numArr[i + 2].intValue());
        return allocate.array();
    }
}
