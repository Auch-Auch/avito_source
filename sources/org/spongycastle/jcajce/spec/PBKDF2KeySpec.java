package org.spongycastle.jcajce.spec;

import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class PBKDF2KeySpec extends PBEKeySpec {
    public static final AlgorithmIdentifier b = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
    public AlgorithmIdentifier a;

    public PBKDF2KeySpec(char[] cArr, byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        super(cArr, bArr, i, i2);
        this.a = algorithmIdentifier;
    }

    public AlgorithmIdentifier getPrf() {
        return this.a;
    }

    public boolean isDefaultPrf() {
        return b.equals(this.a);
    }
}
