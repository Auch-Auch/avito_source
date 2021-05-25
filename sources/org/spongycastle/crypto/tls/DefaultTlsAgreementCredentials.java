package org.spongycastle.crypto.tls;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.util.BigIntegers;
public class DefaultTlsAgreementCredentials extends AbstractTlsAgreementCredentials {
    public BasicAgreement basicAgreement;
    public Certificate certificate;
    public AsymmetricKeyParameter privateKey;
    public boolean truncateAgreement;

    public DefaultTlsAgreementCredentials(Certificate certificate2, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate2 == null) {
            throw new IllegalArgumentException("'certificate' cannot be null");
        } else if (certificate2.isEmpty()) {
            throw new IllegalArgumentException("'certificate' cannot be empty");
        } else if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("'privateKey' cannot be null");
        } else if (asymmetricKeyParameter.isPrivate()) {
            if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
                this.basicAgreement = new DHBasicAgreement();
                this.truncateAgreement = true;
            } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                this.basicAgreement = new ECDHBasicAgreement();
                this.truncateAgreement = false;
            } else {
                StringBuilder L = a.L("'privateKey' type not supported: ");
                L.append(asymmetricKeyParameter.getClass().getName());
                throw new IllegalArgumentException(L.toString());
            }
            this.certificate = certificate2;
            this.privateKey = asymmetricKeyParameter;
        } else {
            throw new IllegalArgumentException("'privateKey' must be private");
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsAgreementCredentials
    public byte[] generateAgreement(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.basicAgreement.init(this.privateKey);
        BigInteger calculateAgreement = this.basicAgreement.calculateAgreement(asymmetricKeyParameter);
        if (this.truncateAgreement) {
            return BigIntegers.asUnsignedByteArray(calculateAgreement);
        }
        return BigIntegers.asUnsignedByteArray(this.basicAgreement.getFieldSize(), calculateAgreement);
    }

    @Override // org.spongycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.certificate;
    }
}
