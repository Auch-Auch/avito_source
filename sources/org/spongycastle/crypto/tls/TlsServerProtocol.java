package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import x6.e.b.e.a;
import x6.e.b.e.k;
import x6.e.b.e.p;
public class TlsServerProtocol extends TlsProtocol {
    public CertificateRequest certificateRequest = null;
    public short clientCertificateType = -1;
    public TlsKeyExchange keyExchange = null;
    public p m = null;
    public TlsHandshakeHash prepareFinishHash = null;
    public TlsCredentials serverCredentials = null;
    public TlsServer tlsServer = null;

    public TlsServerProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public a a() {
        return this.m;
    }

    public void accept(TlsServer tlsServer2) throws IOException {
        if (tlsServer2 == null) {
            throw new IllegalArgumentException("'tlsServer' cannot be null");
        } else if (this.tlsServer == null) {
            this.tlsServer = tlsServer2;
            SecurityParameters securityParameters = new SecurityParameters();
            this.securityParameters = securityParameters;
            securityParameters.a = 0;
            this.m = new p(this.secureRandom, this.securityParameters);
            this.securityParameters.h = TlsProtocol.createRandomBlock(tlsServer2.shouldUseGMTUnixTime(), this.m.a);
            this.tlsServer.init(this.m);
            this.d.d(this.m);
            this.d.q = false;
            blockForHandshake();
        } else {
            throw new IllegalStateException("'accept' can only be called once");
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.prepareFinishHash = null;
    }

    public boolean expectCertificateVerifyMessage() {
        short s = this.clientCertificateType;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public TlsContext getContext() {
        return this.m;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public TlsPeer getPeer() {
        return this.tlsServer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r3 == 9) goto L_0x0029;
     */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleAlertWarningMessage(short r3) throws java.io.IOException {
        /*
            r2 = this;
            super.handleAlertWarningMessage(r3)
            r0 = 41
            if (r3 == r0) goto L_0x0008
            return
        L_0x0008:
            org.spongycastle.crypto.tls.TlsContext r3 = r2.getContext()
            boolean r3 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r3)
            r0 = 10
            if (r3 == 0) goto L_0x0031
            org.spongycastle.crypto.tls.CertificateRequest r3 = r2.certificateRequest
            if (r3 == 0) goto L_0x0031
            short r3 = r2.connection_state
            r1 = 8
            if (r3 == r1) goto L_0x0023
            r1 = 9
            if (r3 != r1) goto L_0x0031
            goto L_0x0029
        L_0x0023:
            org.spongycastle.crypto.tls.TlsServer r3 = r2.tlsServer
            r1 = 0
            r3.processClientSupplementalData(r1)
        L_0x0029:
            org.spongycastle.crypto.tls.Certificate r3 = org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN
            r2.notifyClientCertificate(r3)
            r2.connection_state = r0
            return
        L_0x0031:
            org.spongycastle.crypto.tls.TlsFatalAlert r3 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsServerProtocol.handleAlertWarningMessage(short):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleHandshakeMessage(short r10, java.io.ByteArrayInputStream r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 500
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsServerProtocol.handleHandshakeMessage(short, java.io.ByteArrayInputStream):void");
    }

    public void notifyClientCertificate(Certificate certificate) throws IOException {
        if (this.certificateRequest == null) {
            throw new IllegalStateException();
        } else if (this.peerCertificate == null) {
            this.peerCertificate = certificate;
            if (certificate.isEmpty()) {
                this.keyExchange.skipClientCredentials();
            } else {
                this.serverCredentials.getCertificate();
                this.clientCertificateType = TlsUtils.f(certificate);
                this.keyExchange.processClientCertificate(certificate);
            }
            this.tlsServer.notifyClientCertificate(certificate);
        } else {
            throw new TlsFatalAlert(10);
        }
    }

    public void receiveCertificateMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        Certificate parse = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        notifyClientCertificate(parse);
    }

    public void receiveCertificateVerifyMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] bArr;
        if (this.certificateRequest != null) {
            DigitallySigned parse = DigitallySigned.parse(getContext(), byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            try {
                SignatureAndHashAlgorithm algorithm = parse.getAlgorithm();
                if (TlsUtils.isTLSv12(getContext())) {
                    TlsUtils.verifySupportedSignatureAlgorithm(this.certificateRequest.getSupportedSignatureAlgorithms(), algorithm);
                    bArr = this.prepareFinishHash.getFinalHash(algorithm.getHash());
                } else {
                    bArr = this.securityParameters.getSessionHash();
                }
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(this.peerCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
                TlsSigner createTlsSigner = TlsUtils.createTlsSigner(this.clientCertificateType);
                createTlsSigner.init(getContext());
                if (!createTlsSigner.verifyRawSignature(algorithm, parse.getSignature(), createKey, bArr)) {
                    throw new TlsFatalAlert(51);
                }
            } catch (TlsFatalAlert e) {
                throw e;
            } catch (Exception e2) {
                throw new TlsFatalAlert(51, e2);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public void receiveClientHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        this.d.p = readVersion;
        if (!readVersion.isDTLS()) {
            byte[] readFully = TlsUtils.readFully(32, byteArrayInputStream);
            if (TlsUtils.readOpaque8(byteArrayInputStream).length <= 32) {
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (readUint16 < 2 || (readUint16 & 1) != 0) {
                    throw new TlsFatalAlert(50);
                }
                this.offeredCipherSuites = TlsUtils.readUint16Array(readUint16 / 2, byteArrayInputStream);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (readUint8 >= 1) {
                    this.offeredCompressionMethods = TlsUtils.readUint8Array(readUint8, byteArrayInputStream);
                    Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                    this.clientExtensions = readExtensions;
                    this.securityParameters.o = TlsExtensionsUtils.hasExtendedMasterSecretExtension(readExtensions);
                    this.m.d = readVersion;
                    this.tlsServer.notifyClientVersion(readVersion);
                    this.tlsServer.notifyFallback(Arrays.contains(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV));
                    this.securityParameters.g = readFully;
                    this.tlsServer.notifyOfferedCipherSuites(this.offeredCipherSuites);
                    this.tlsServer.notifyOfferedCompressionMethods(this.offeredCompressionMethods);
                    if (Arrays.contains(this.offeredCipherSuites, 255)) {
                        this.secure_renegotiation = true;
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(this.clientExtensions, TlsProtocol.EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        this.secure_renegotiation = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert(40);
                        }
                    }
                    this.tlsServer.notifySecureRenegotiation(this.secure_renegotiation);
                    Hashtable hashtable = this.clientExtensions;
                    if (hashtable != null) {
                        TlsExtensionsUtils.getPaddingExtension(hashtable);
                        this.tlsServer.processClientExtensions(this.clientExtensions);
                        return;
                    }
                    return;
                }
                throw new TlsFatalAlert(47);
            }
            throw new TlsFatalAlert(47);
        }
        throw new TlsFatalAlert(47);
    }

    public void receiveClientKeyExchangeMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        this.keyExchange.processClientKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        if (TlsUtils.isSSL(getContext())) {
            TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
        }
        k kVar = this.d;
        TlsHandshakeHash tlsHandshakeHash = kVar.m;
        kVar.m = tlsHandshakeHash.stopTracking();
        this.prepareFinishHash = tlsHandshakeHash;
        this.securityParameters.i = TlsProtocol.getCurrentPRFHash(getContext(), this.prepareFinishHash, null);
        if (!TlsUtils.isSSL(getContext())) {
            TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
        }
        k kVar2 = this.d;
        TlsCompression compression = getPeer().getCompression();
        TlsCipher cipher = getPeer().getCipher();
        kVar2.d = compression;
        kVar2.g = cipher;
        if (!this.expectSessionTicket) {
            sendChangeCipherSpecMessage();
        }
    }

    public void sendCertificateRequestMessage(CertificateRequest certificateRequest2) throws IOException {
        TlsProtocol.a aVar = new TlsProtocol.a(13, 60);
        certificateRequest2.encode(aVar);
        aVar.a();
    }

    public void sendCertificateStatusMessage(CertificateStatus certificateStatus) throws IOException {
        TlsProtocol.a aVar = new TlsProtocol.a(22, 60);
        certificateStatus.encode(aVar);
        aVar.a();
    }

    public void sendNewSessionTicketMessage(NewSessionTicket newSessionTicket) throws IOException {
        if (newSessionTicket != null) {
            TlsProtocol.a aVar = new TlsProtocol.a(4, 60);
            newSessionTicket.encode(aVar);
            aVar.a();
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public void sendServerHelloDoneMessage() throws IOException {
        byte[] bArr = new byte[4];
        TlsUtils.writeUint8((short) 14, bArr, 0);
        TlsUtils.writeUint24(0, bArr, 1);
        writeHandshakeMessage(bArr, 0, 4);
    }

    public void sendServerHelloMessage() throws IOException {
        TlsProtocol.a aVar = new TlsProtocol.a(2, 60);
        ProtocolVersion serverVersion = this.tlsServer.getServerVersion();
        if (serverVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            k kVar = this.d;
            kVar.o = serverVersion;
            kVar.p = serverVersion;
            boolean z = true;
            kVar.q = true;
            this.m.e = serverVersion;
            TlsUtils.writeVersion(serverVersion, aVar);
            aVar.write(this.securityParameters.h);
            byte[] bArr = TlsUtils.EMPTY_BYTES;
            TlsUtils.writeOpaque8(bArr, aVar);
            int selectedCipherSuite = this.tlsServer.getSelectedCipherSuite();
            if (!Arrays.contains(this.offeredCipherSuites, selectedCipherSuite) || selectedCipherSuite == 0 || CipherSuite.isSCSV(selectedCipherSuite) || !TlsUtils.isValidCipherSuiteForVersion(selectedCipherSuite, getContext().getServerVersion())) {
                throw new TlsFatalAlert(80);
            }
            this.securityParameters.b = selectedCipherSuite;
            short selectedCompressionMethod = this.tlsServer.getSelectedCompressionMethod();
            if (Arrays.contains(this.offeredCompressionMethods, selectedCompressionMethod)) {
                this.securityParameters.c = selectedCompressionMethod;
                TlsUtils.writeUint16(selectedCipherSuite, aVar);
                TlsUtils.writeUint8(selectedCompressionMethod, (OutputStream) aVar);
                Hashtable serverExtensions = this.tlsServer.getServerExtensions();
                this.serverExtensions = serverExtensions;
                if (this.secure_renegotiation) {
                    Integer num = TlsProtocol.EXT_RenegotiationInfo;
                    if (TlsUtils.getExtensionData(serverExtensions, num) == null) {
                        Hashtable ensureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                        this.serverExtensions = ensureExtensionsInitialised;
                        ensureExtensionsInitialised.put(num, TlsProtocol.createRenegotiationInfo(bArr));
                    }
                }
                if (this.securityParameters.o) {
                    Hashtable ensureExtensionsInitialised2 = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                    this.serverExtensions = ensureExtensionsInitialised2;
                    TlsExtensionsUtils.addExtendedMasterSecretExtension(ensureExtensionsInitialised2);
                }
                Hashtable hashtable = this.serverExtensions;
                if (hashtable != null) {
                    this.securityParameters.n = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable);
                    this.securityParameters.l = processMaxFragmentLengthExtension(this.clientExtensions, this.serverExtensions, 80);
                    this.securityParameters.m = TlsExtensionsUtils.hasTruncatedHMacExtension(this.serverExtensions);
                    this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsExtensionsUtils.EXT_status_request, 80);
                    if (this.resumedSession || !TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsProtocol.EXT_SessionTicket, 80)) {
                        z = false;
                    }
                    this.expectSessionTicket = z;
                    TlsProtocol.writeExtensions(aVar, this.serverExtensions);
                }
                this.securityParameters.d = TlsProtocol.getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                this.securityParameters.e = 12;
                applyMaxFragmentLengthExtension();
                aVar.a();
                return;
            }
            throw new TlsFatalAlert(80);
        }
        throw new TlsFatalAlert(80);
    }

    public void sendServerKeyExchangeMessage(byte[] bArr) throws IOException {
        TlsProtocol.a aVar = new TlsProtocol.a(12, bArr.length);
        aVar.write(bArr);
        aVar.a();
    }

    public TlsServerProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }
}
