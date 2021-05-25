package a2.j.d.g;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
public class b implements Hasher {
    public final /* synthetic */ Hasher[] a;
    public final /* synthetic */ c b;

    public b(c cVar, Hasher[] hasherArr) {
        this.b = cVar;
        this.a = hasherArr;
    }

    @Override // com.google.common.hash.Hasher
    public HashCode hash() {
        c cVar = this.b;
        Hasher[] hasherArr = this.a;
        byte[] bArr = new byte[(((Hashing.c) cVar).bits() / 8)];
        int i = 0;
        for (Hasher hasher : hasherArr) {
            HashCode hash = hasher.hash();
            i += hash.writeBytesTo(bArr, i, hash.bits() / 8);
        }
        char[] cArr = HashCode.a;
        return new HashCode.a(bArr);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBoolean */
    public Hasher mo50putBoolean(boolean z) {
        for (Hasher hasher : this.a) {
            hasher.mo50putBoolean(z);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar */
    public Hasher mo62putChar(char c) {
        for (Hasher hasher : this.a) {
            hasher.mo62putChar(c);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putDouble */
    public Hasher mo51putDouble(double d) {
        for (Hasher hasher : this.a) {
            hasher.mo51putDouble(d);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putFloat */
    public Hasher mo52putFloat(float f) {
        for (Hasher hasher : this.a) {
            hasher.mo52putFloat(f);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        for (Hasher hasher : this.a) {
            hasher.putObject(t, funnel);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort */
    public Hasher mo60putShort(short s) {
        for (Hasher hasher : this.a) {
            hasher.mo60putShort(s);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putByte */
    public Hasher mo61putByte(byte b2) {
        for (Hasher hasher : this.a) {
            hasher.mo61putByte(b2);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putInt */
    public Hasher mo63putInt(int i) {
        for (Hasher hasher : this.a) {
            hasher.mo63putInt(i);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putLong */
    public Hasher mo59putLong(long j) {
        for (Hasher hasher : this.a) {
            hasher.mo59putLong(j);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence charSequence, Charset charset) {
        for (Hasher hasher : this.a) {
            hasher.putString(charSequence, charset);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence charSequence) {
        for (Hasher hasher : this.a) {
            hasher.putUnencodedChars(charSequence);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBoolean  reason: collision with other method in class */
    public PrimitiveSink mo50putBoolean(boolean z) {
        for (Hasher hasher : this.a) {
            hasher.mo50putBoolean(z);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo45putBytes(byte[] bArr) {
        for (Hasher hasher : this.a) {
            hasher.mo45putBytes(bArr);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putChar  reason: collision with other method in class */
    public PrimitiveSink mo62putChar(char c) {
        for (Hasher hasher : this.a) {
            hasher.mo62putChar(c);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putDouble  reason: collision with other method in class */
    public PrimitiveSink mo51putDouble(double d) {
        for (Hasher hasher : this.a) {
            hasher.mo51putDouble(d);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putFloat  reason: collision with other method in class */
    public PrimitiveSink mo52putFloat(float f) {
        for (Hasher hasher : this.a) {
            hasher.mo52putFloat(f);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putShort  reason: collision with other method in class */
    public PrimitiveSink mo60putShort(short s) {
        for (Hasher hasher : this.a) {
            hasher.mo60putShort(s);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes  reason: collision with other method in class */
    public PrimitiveSink mo45putBytes(byte[] bArr) {
        for (Hasher hasher : this.a) {
            hasher.mo45putBytes(bArr);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo55putBytes(byte[] bArr, int i, int i2) {
        for (Hasher hasher : this.a) {
            hasher.mo55putBytes(bArr, i, i2);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    /* renamed from: putBytes */
    public Hasher mo54putBytes(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        Hasher[] hasherArr = this.a;
        for (Hasher hasher : hasherArr) {
            byteBuffer.position(position);
            hasher.mo54putBytes(byteBuffer);
        }
        return this;
    }
}
