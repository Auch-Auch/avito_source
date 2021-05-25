package a2.j.b.b.z0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
public class s {
    public final Allocator a;
    public final int b;
    public final ParsableByteArray c = new ParsableByteArray(32);
    public a d;
    public a e;
    public a f;
    public long g;

    public static final class a {
        public final long a;
        public final long b;
        public boolean c;
        @Nullable
        public Allocation d;
        @Nullable
        public a e;

        public a(long j, int i) {
            this.a = j;
            this.b = j + ((long) i);
        }

        public int a(long j) {
            return ((int) (j - this.a)) + this.d.offset;
        }
    }

    public s(Allocator allocator) {
        this.a = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.b = individualAllocationLength;
        a aVar = new a(0, individualAllocationLength);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    public final void a(a aVar) {
        if (aVar.c) {
            a aVar2 = this.f;
            int i = (((int) (aVar2.a - aVar.a)) / this.b) + (aVar2.c ? 1 : 0);
            Allocation[] allocationArr = new Allocation[i];
            int i2 = 0;
            while (i2 < i) {
                allocationArr[i2] = aVar.d;
                aVar.d = null;
                a aVar3 = aVar.e;
                aVar.e = null;
                i2++;
                aVar = aVar3;
            }
            this.a.release(allocationArr);
        }
    }

    public void b(long j) {
        a aVar;
        if (j != -1) {
            while (true) {
                aVar = this.d;
                if (j < aVar.b) {
                    break;
                }
                this.a.release(aVar.d);
                a aVar2 = this.d;
                aVar2.d = null;
                a aVar3 = aVar2.e;
                aVar2.e = null;
                this.d = aVar3;
            }
            if (this.e.a < aVar.a) {
                this.e = aVar;
            }
        }
    }

    public final void c(int i) {
        long j = this.g + ((long) i);
        this.g = j;
        a aVar = this.f;
        if (j == aVar.b) {
            this.f = aVar.e;
        }
    }

    public final int d(int i) {
        a aVar = this.f;
        if (!aVar.c) {
            Allocation allocate = this.a.allocate();
            a aVar2 = new a(this.f.b, this.b);
            aVar.d = allocate;
            aVar.e = aVar2;
            aVar.c = true;
        }
        return Math.min(i, (int) (this.f.b - this.g));
    }

    public final void e(long j, ByteBuffer byteBuffer, int i) {
        while (true) {
            a aVar = this.e;
            if (j < aVar.b) {
                break;
            }
            this.e = aVar.e;
        }
        while (i > 0) {
            int min = Math.min(i, (int) (this.e.b - j));
            a aVar2 = this.e;
            byteBuffer.put(aVar2.d.data, aVar2.a(j), min);
            i -= min;
            j += (long) min;
            a aVar3 = this.e;
            if (j == aVar3.b) {
                this.e = aVar3.e;
            }
        }
    }

    public final void f(long j, byte[] bArr, int i) {
        while (true) {
            a aVar = this.e;
            if (j < aVar.b) {
                break;
            }
            this.e = aVar.e;
        }
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.e.b - j));
            a aVar2 = this.e;
            System.arraycopy(aVar2.d.data, aVar2.a(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            a aVar3 = this.e;
            if (j == aVar3.b) {
                this.e = aVar3.e;
            }
        }
    }
}
