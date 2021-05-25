package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECVKOAgreement;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
public class KeyAgreementSpi extends BaseAgreementSpi {
    public String h;
    public ECDomainParameters i;
    public ECVKOAgreement j;
    public byte[] k;

    public static class ECVKO extends KeyAgreementSpi {
        public ECVKO() {
            super("ECGOST3410", new ECVKOAgreement(new GOST3411Digest()), null);
        }
    }

    public class a extends InvalidKeyException {
        public final /* synthetic */ Exception a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KeyAgreementSpi keyAgreementSpi, String str, Exception exc) {
            super(str);
            this.a = exc;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.a;
        }
    }

    static {
        new X9IntegerConverter();
    }

    public KeyAgreementSpi(String str, ECVKOAgreement eCVKOAgreement, DerivationFunction derivationFunction) {
        super(str, derivationFunction);
        this.h = str;
        this.j = eCVKOAgreement;
    }

    public final void a(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        if (key instanceof PrivateKey) {
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter((PrivateKey) key);
            this.i = eCPrivateKeyParameters.getParameters();
            byte[] userKeyingMaterial = algorithmParameterSpec instanceof UserKeyingMaterialSpec ? ((UserKeyingMaterialSpec) algorithmParameterSpec).getUserKeyingMaterial() : null;
            this.ukmParameters = userKeyingMaterial;
            this.j.init(new ParametersWithUKM(eCPrivateKeyParameters, userKeyingMaterial));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.h);
        sb.append(" key agreement requires ");
        String name = ECPrivateKey.class.getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(" for initialisation");
        throw new InvalidKeyException(sb.toString());
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public byte[] calcSecret() {
        return this.k;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        CipherParameters cipherParameters;
        if (this.i == null) {
            throw new IllegalStateException(a2.b.a.a.a.t(new StringBuilder(), this.h, " not initialised."));
        } else if (!z) {
            throw new IllegalStateException(a2.b.a.a.a.t(new StringBuilder(), this.h, " can only be between two parties."));
        } else if (key instanceof PublicKey) {
            PublicKey publicKey = (PublicKey) key;
            if (publicKey instanceof BCECPublicKey) {
                cipherParameters = ((BCECGOST3410PublicKey) publicKey).c;
            } else {
                cipherParameters = ECUtil.generatePublicKeyParameter(publicKey);
            }
            try {
                this.k = this.j.calculateAgreement(cipherParameters);
                return null;
            } catch (Exception e) {
                throw new a(this, a2.b.a.a.a.F2(e, a2.b.a.a.a.L("calculation failed: ")), e);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append(" key agreement requires ");
            String name = ECPublicKey.class.getName();
            sb.append(name.substring(name.lastIndexOf(46) + 1));
            sb.append(" for doPhase");
            throw new InvalidKeyException(sb.toString());
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
            a(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        a(key, null);
    }
}
