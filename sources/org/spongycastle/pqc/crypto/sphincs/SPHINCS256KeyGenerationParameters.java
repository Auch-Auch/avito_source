package org.spongycastle.pqc.crypto.sphincs;

import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
public class SPHINCS256KeyGenerationParameters extends KeyGenerationParameters {
    public final Digest e;

    public SPHINCS256KeyGenerationParameters(SecureRandom secureRandom, Digest digest) {
        super(secureRandom, 8448);
        this.e = digest;
    }

    public Digest getTreeDigest() {
        return this.e;
    }
}
