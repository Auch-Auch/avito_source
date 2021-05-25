package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.util.Arrays;
public class KTSParameterSpec implements AlgorithmParameterSpec {
    public final String a;
    public final int b;
    public final AlgorithmParameterSpec c;
    public final AlgorithmIdentifier d;
    public byte[] e;

    public static final class Builder {
        public final String a;
        public final int b;
        public AlgorithmParameterSpec c;
        public AlgorithmIdentifier d;
        public byte[] e;

        public Builder(String str, int i) {
            this(str, i, null);
        }

        public KTSParameterSpec build() {
            return new KTSParameterSpec(this.a, this.b, this.c, this.d, this.e, null);
        }

        public Builder withKdfAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
            this.d = algorithmIdentifier;
            return this;
        }

        public Builder withParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            this.c = algorithmParameterSpec;
            return this;
        }

        public Builder(String str, int i, byte[] bArr) {
            byte[] bArr2;
            this.a = str;
            this.b = i;
            this.d = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));
            if (bArr == null) {
                bArr2 = new byte[0];
            } else {
                bArr2 = Arrays.clone(bArr);
            }
            this.e = bArr2;
        }
    }

    public KTSParameterSpec(String str, int i, AlgorithmParameterSpec algorithmParameterSpec, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, a aVar) {
        this.a = str;
        this.b = i;
        this.c = algorithmParameterSpec;
        this.d = algorithmIdentifier;
        this.e = bArr;
    }

    public AlgorithmIdentifier getKdfAlgorithm() {
        return this.d;
    }

    public String getKeyAlgorithmName() {
        return this.a;
    }

    public int getKeySize() {
        return this.b;
    }

    public byte[] getOtherInfo() {
        return Arrays.clone(this.e);
    }

    public AlgorithmParameterSpec getParameterSpec() {
        return this.c;
    }
}
