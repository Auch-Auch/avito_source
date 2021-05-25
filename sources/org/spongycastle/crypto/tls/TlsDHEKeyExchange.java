package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.util.io.TeeInputStream;
import x6.e.b.e.j;
import x6.e.b.e.l;
public class TlsDHEKeyExchange extends TlsDHKeyExchange {
    public TlsSignerCredentials serverCredentials = null;

    public TlsDHEKeyExchange(int i, Vector vector, DHParameters dHParameters) {
        super(i, vector, dHParameters);
    }

    @Override // org.spongycastle.crypto.tls.TlsDHKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        if (this.dhParameters != null) {
            j jVar = new j();
            this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, jVar);
            SignatureAndHashAlgorithm signatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(this.context, this.serverCredentials);
            Digest createHash = TlsUtils.createHash(signatureAndHashAlgorithm);
            SecurityParameters securityParameters = this.context.getSecurityParameters();
            byte[] bArr = securityParameters.g;
            createHash.update(bArr, 0, bArr.length);
            byte[] bArr2 = securityParameters.h;
            createHash.update(bArr2, 0, bArr2.length);
            jVar.a(createHash);
            byte[] bArr3 = new byte[createHash.getDigestSize()];
            createHash.doFinal(bArr3, 0);
            new DigitallySigned(signatureAndHashAlgorithm, this.serverCredentials.generateCertificateSignature(bArr3)).encode(jVar);
            return jVar.toByteArray();
        }
        throw new TlsFatalAlert(80);
    }

    public Signer initVerifyer(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner.createVerifyer(signatureAndHashAlgorithm, this.serverPublicKey);
        byte[] bArr = securityParameters.g;
        createVerifyer.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.h;
        createVerifyer.update(bArr2, 0, bArr2.length);
        return createVerifyer;
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsSignerCredentials) {
            processServerCertificate(tlsCredentials.getCertificate());
            this.serverCredentials = (TlsSignerCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert(80);
    }

    @Override // org.spongycastle.crypto.tls.TlsDHKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        l lVar = new l();
        ServerDHParams parse = ServerDHParams.parse(new TeeInputStream(inputStream, lVar));
        DigitallySigned parseSignature = parseSignature(inputStream);
        Signer initVerifyer = initVerifyer(this.tlsSigner, parseSignature.getAlgorithm(), securityParameters);
        lVar.a(initVerifyer);
        if (initVerifyer.verifySignature(parseSignature.getSignature())) {
            DHPublicKeyParameters validateDHPublicKey = TlsDHUtils.validateDHPublicKey(parse.getPublicKey());
            this.dhAgreePublicKey = validateDHPublicKey;
            this.dhParameters = validateDHParameters(validateDHPublicKey.getParameters());
            return;
        }
        throw new TlsFatalAlert(51);
    }
}
