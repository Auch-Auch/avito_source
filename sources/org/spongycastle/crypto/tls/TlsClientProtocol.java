package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.util.Arrays;
import x6.e.b.e.a;
import x6.e.b.e.k;
import x6.e.b.e.m;
import x6.e.b.e.q;
public class TlsClientProtocol extends TlsProtocol {
    public TlsAuthentication authentication = null;
    public CertificateRequest certificateRequest = null;
    public CertificateStatus certificateStatus = null;
    public TlsKeyExchange keyExchange = null;
    public m m = null;
    public byte[] selectedSessionID = null;
    public TlsClient tlsClient = null;

    public TlsClientProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public a a() {
        return this.m;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }

    public void connect(TlsClient tlsClient2) throws IOException {
        SessionParameters exportSessionParameters;
        if (tlsClient2 == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        } else if (this.tlsClient == null) {
            this.tlsClient = tlsClient2;
            SecurityParameters securityParameters = new SecurityParameters();
            this.securityParameters = securityParameters;
            securityParameters.a = 1;
            this.m = new m(this.secureRandom, this.securityParameters);
            this.securityParameters.g = TlsProtocol.createRandomBlock(tlsClient2.shouldUseGMTUnixTime(), this.m.a);
            this.tlsClient.init(this.m);
            this.d.d(this.m);
            TlsSession sessionToResume = tlsClient2.getSessionToResume();
            if (!(sessionToResume == null || !sessionToResume.isResumable() || (exportSessionParameters = sessionToResume.exportSessionParameters()) == null)) {
                this.tlsSession = sessionToResume;
                this.sessionParameters = exportSessionParameters;
            }
            sendClientHelloMessage();
            this.connection_state = 1;
            blockForHandshake();
        } else {
            throw new IllegalStateException("'connect' can only be called once");
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public TlsContext getContext() {
        return this.m;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public TlsPeer getPeer() {
        return this.tlsClient;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void handleHandshakeMessage(short s, ByteArrayInputStream byteArrayInputStream) throws IOException {
        TlsCredentials tlsCredentials;
        byte[] bArr;
        if (this.resumedSession) {
            if (s == 20 && this.connection_state == 2) {
                processFinishedMessage(byteArrayInputStream);
                this.connection_state = 15;
                sendFinishedMessage();
                this.connection_state = 13;
                completeHandshake();
                return;
            }
            throw new TlsFatalAlert(10);
        } else if (s == 0) {
            TlsProtocol.assertEmpty(byteArrayInputStream);
            if (this.connection_state == 16) {
                refuseRenegotiation();
            }
        } else if (s != 2) {
            if (s != 4) {
                if (s == 20) {
                    short s2 = this.connection_state;
                    if (s2 != 13) {
                        if (s2 != 14) {
                            throw new TlsFatalAlert(10);
                        }
                    } else if (this.expectSessionTicket) {
                        throw new TlsFatalAlert(10);
                    }
                    processFinishedMessage(byteArrayInputStream);
                    this.connection_state = 15;
                    completeHandshake();
                } else if (s != 22) {
                    if (s != 23) {
                        switch (s) {
                            case 11:
                                short s3 = this.connection_state;
                                if (s3 == 2) {
                                    handleSupplementalData(null);
                                } else if (s3 != 3) {
                                    throw new TlsFatalAlert(10);
                                }
                                this.peerCertificate = Certificate.parse(byteArrayInputStream);
                                TlsProtocol.assertEmpty(byteArrayInputStream);
                                Certificate certificate = this.peerCertificate;
                                if (certificate == null || certificate.isEmpty()) {
                                    this.allowCertificateStatus = false;
                                }
                                this.keyExchange.processServerCertificate(this.peerCertificate);
                                TlsAuthentication authentication2 = this.tlsClient.getAuthentication();
                                this.authentication = authentication2;
                                authentication2.notifyServerCertificate(this.peerCertificate);
                                this.connection_state = 4;
                                return;
                            case 12:
                                short s4 = this.connection_state;
                                if (s4 == 2) {
                                    handleSupplementalData(null);
                                } else if (s4 != 3) {
                                    if (!(s4 == 4 || s4 == 5)) {
                                        throw new TlsFatalAlert(10);
                                    }
                                    this.keyExchange.processServerKeyExchange(byteArrayInputStream);
                                    TlsProtocol.assertEmpty(byteArrayInputStream);
                                    this.connection_state = 6;
                                    return;
                                }
                                this.keyExchange.skipServerCredentials();
                                this.authentication = null;
                                this.keyExchange.processServerKeyExchange(byteArrayInputStream);
                                TlsProtocol.assertEmpty(byteArrayInputStream);
                                this.connection_state = 6;
                                return;
                            case 13:
                                short s5 = this.connection_state;
                                if (s5 == 4 || s5 == 5) {
                                    this.keyExchange.skipServerKeyExchange();
                                } else if (s5 != 6) {
                                    throw new TlsFatalAlert(10);
                                }
                                if (this.authentication != null) {
                                    this.certificateRequest = CertificateRequest.parse(getContext(), byteArrayInputStream);
                                    TlsProtocol.assertEmpty(byteArrayInputStream);
                                    this.keyExchange.validateCertificateRequest(this.certificateRequest);
                                    TlsUtils.h(this.d.m, this.certificateRequest.getSupportedSignatureAlgorithms());
                                    this.connection_state = 7;
                                    return;
                                }
                                throw new TlsFatalAlert(40);
                            case 14:
                                switch (this.connection_state) {
                                    case 2:
                                        handleSupplementalData(null);
                                    case 3:
                                        this.keyExchange.skipServerCredentials();
                                        this.authentication = null;
                                    case 4:
                                    case 5:
                                        this.keyExchange.skipServerKeyExchange();
                                        break;
                                    case 6:
                                    case 7:
                                        break;
                                    default:
                                        throw new TlsFatalAlert(10);
                                }
                                TlsProtocol.assertEmpty(byteArrayInputStream);
                                this.connection_state = 8;
                                this.d.m.sealHashAlgorithms();
                                Vector clientSupplementalData = this.tlsClient.getClientSupplementalData();
                                if (clientSupplementalData != null) {
                                    sendSupplementalDataMessage(clientSupplementalData);
                                }
                                this.connection_state = 9;
                                CertificateRequest certificateRequest2 = this.certificateRequest;
                                if (certificateRequest2 == null) {
                                    this.keyExchange.skipClientCredentials();
                                    tlsCredentials = null;
                                } else {
                                    tlsCredentials = this.authentication.getClientCredentials(certificateRequest2);
                                    if (tlsCredentials == null) {
                                        this.keyExchange.skipClientCredentials();
                                        sendCertificateMessage(Certificate.EMPTY_CHAIN);
                                    } else {
                                        this.keyExchange.processClientCredentials(tlsCredentials);
                                        sendCertificateMessage(tlsCredentials.getCertificate());
                                    }
                                }
                                this.connection_state = 10;
                                sendClientKeyExchangeMessage();
                                this.connection_state = 11;
                                if (TlsUtils.isSSL(getContext())) {
                                    TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
                                }
                                k kVar = this.d;
                                TlsHandshakeHash tlsHandshakeHash = kVar.m;
                                kVar.m = tlsHandshakeHash.stopTracking();
                                this.securityParameters.i = TlsProtocol.getCurrentPRFHash(getContext(), tlsHandshakeHash, null);
                                if (!TlsUtils.isSSL(getContext())) {
                                    TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
                                }
                                k kVar2 = this.d;
                                TlsCompression compression = getPeer().getCompression();
                                TlsCipher cipher = getPeer().getCipher();
                                kVar2.d = compression;
                                kVar2.g = cipher;
                                if (tlsCredentials != null && (tlsCredentials instanceof TlsSignerCredentials)) {
                                    TlsSignerCredentials tlsSignerCredentials = (TlsSignerCredentials) tlsCredentials;
                                    SignatureAndHashAlgorithm signatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(getContext(), tlsSignerCredentials);
                                    if (signatureAndHashAlgorithm == null) {
                                        bArr = this.securityParameters.getSessionHash();
                                    } else {
                                        bArr = tlsHandshakeHash.getFinalHash(signatureAndHashAlgorithm.getHash());
                                    }
                                    sendCertificateVerifyMessage(new DigitallySigned(signatureAndHashAlgorithm, tlsSignerCredentials.generateCertificateSignature(bArr)));
                                    this.connection_state = 12;
                                }
                                sendChangeCipherSpecMessage();
                                sendFinishedMessage();
                                this.connection_state = 13;
                                return;
                            default:
                                throw new TlsFatalAlert(10);
                        }
                    } else if (this.connection_state == 2) {
                        handleSupplementalData(TlsProtocol.readSupplementalDataMessage(byteArrayInputStream));
                    } else {
                        throw new TlsFatalAlert(10);
                    }
                } else if (this.connection_state != 4) {
                    throw new TlsFatalAlert(10);
                } else if (this.allowCertificateStatus) {
                    this.certificateStatus = CertificateStatus.parse(byteArrayInputStream);
                    TlsProtocol.assertEmpty(byteArrayInputStream);
                    this.connection_state = 5;
                } else {
                    throw new TlsFatalAlert(10);
                }
            } else if (this.connection_state != 13) {
                throw new TlsFatalAlert(10);
            } else if (this.expectSessionTicket) {
                invalidateSession();
                receiveNewSessionTicketMessage(byteArrayInputStream);
                this.connection_state = 14;
            } else {
                throw new TlsFatalAlert(10);
            }
        } else if (this.connection_state == 1) {
            receiveServerHelloMessage(byteArrayInputStream);
            this.connection_state = 2;
            k kVar3 = this.d;
            kVar3.m = kVar3.m.notifyPRFDetermined();
            applyMaxFragmentLengthExtension();
            if (this.resumedSession) {
                this.securityParameters.f = Arrays.clone(this.sessionParameters.getMasterSecret());
                k kVar4 = this.d;
                TlsCompression compression2 = getPeer().getCompression();
                TlsCipher cipher2 = getPeer().getCipher();
                kVar4.d = compression2;
                kVar4.g = cipher2;
                sendChangeCipherSpecMessage();
                return;
            }
            invalidateSession();
            byte[] bArr2 = this.selectedSessionID;
            if (bArr2.length > 0) {
                this.tlsSession = new q(bArr2, null);
            }
        } else {
            throw new TlsFatalAlert(10);
        }
    }

    public void handleSupplementalData(Vector vector) throws IOException {
        this.tlsClient.processServerSupplementalData(vector);
        this.connection_state = 3;
        TlsKeyExchange keyExchange2 = this.tlsClient.getKeyExchange();
        this.keyExchange = keyExchange2;
        keyExchange2.init(getContext());
    }

    public void receiveNewSessionTicketMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        NewSessionTicket parse = NewSessionTicket.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        this.tlsClient.notifyNewSessionTicket(parse);
    }

    public void receiveServerHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        TlsSession tlsSession;
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        if (readVersion.isDTLS()) {
            throw new TlsFatalAlert(47);
        } else if (!readVersion.equals(this.d.o)) {
            throw new TlsFatalAlert(47);
        } else if (readVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            this.d.p = readVersion;
            this.m.e = readVersion;
            this.tlsClient.notifyServerVersion(readVersion);
            this.securityParameters.h = TlsUtils.readFully(32, byteArrayInputStream);
            byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
            this.selectedSessionID = readOpaque8;
            if (readOpaque8.length <= 32) {
                this.tlsClient.notifySessionID(readOpaque8);
                byte[] bArr = this.selectedSessionID;
                boolean z = false;
                this.resumedSession = bArr.length > 0 && (tlsSession = this.tlsSession) != null && Arrays.areEqual(bArr, tlsSession.getSessionID());
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (!Arrays.contains(this.offeredCipherSuites, readUint16) || readUint16 == 0 || CipherSuite.isSCSV(readUint16) || !TlsUtils.isValidCipherSuiteForVersion(readUint16, getContext().getServerVersion())) {
                    throw new TlsFatalAlert(47);
                }
                this.tlsClient.notifySelectedCipherSuite(readUint16);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (Arrays.contains(this.offeredCompressionMethods, readUint8)) {
                    this.tlsClient.notifySelectedCompressionMethod(readUint8);
                    Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                    this.serverExtensions = readExtensions;
                    if (readExtensions != null) {
                        Enumeration keys = readExtensions.keys();
                        while (keys.hasMoreElements()) {
                            Integer num = (Integer) keys.nextElement();
                            if (!num.equals(TlsProtocol.EXT_RenegotiationInfo) && TlsUtils.getExtensionData(this.clientExtensions, num) == null) {
                                throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                            }
                        }
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(this.serverExtensions, TlsProtocol.EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        this.secure_renegotiation = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert(40);
                        }
                    }
                    this.tlsClient.notifySecureRenegotiation(this.secure_renegotiation);
                    Hashtable hashtable = this.clientExtensions;
                    Hashtable hashtable2 = this.serverExtensions;
                    if (this.resumedSession) {
                        if (readUint16 == this.sessionParameters.getCipherSuite() && readUint8 == this.sessionParameters.getCompressionAlgorithm()) {
                            hashtable = null;
                            hashtable2 = this.sessionParameters.readServerExtensions();
                        } else {
                            throw new TlsFatalAlert(47);
                        }
                    }
                    SecurityParameters securityParameters = this.securityParameters;
                    securityParameters.b = readUint16;
                    securityParameters.c = readUint8;
                    if (hashtable2 != null) {
                        boolean hasEncryptThenMACExtension = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable2);
                        if (!hasEncryptThenMACExtension || TlsUtils.isBlockCipherSuite(readUint16)) {
                            SecurityParameters securityParameters2 = this.securityParameters;
                            securityParameters2.n = hasEncryptThenMACExtension;
                            securityParameters2.o = TlsExtensionsUtils.hasExtendedMasterSecretExtension(hashtable2);
                            this.securityParameters.l = processMaxFragmentLengthExtension(hashtable, hashtable2, 47);
                            this.securityParameters.m = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable2);
                            this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsExtensionsUtils.EXT_status_request, 47);
                            if (!this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsProtocol.EXT_SessionTicket, 47)) {
                                z = true;
                            }
                            this.expectSessionTicket = z;
                        } else {
                            throw new TlsFatalAlert(47);
                        }
                    }
                    if (hashtable != null) {
                        this.tlsClient.processServerExtensions(hashtable2);
                    }
                    this.securityParameters.d = TlsProtocol.getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                    this.securityParameters.e = 12;
                    return;
                }
                throw new TlsFatalAlert(47);
            }
            throw new TlsFatalAlert(47);
        } else {
            throw new TlsFatalAlert(47);
        }
    }

    public void sendCertificateVerifyMessage(DigitallySigned digitallySigned) throws IOException {
        TlsProtocol.a aVar = new TlsProtocol.a(15, 60);
        digitallySigned.encode(aVar);
        aVar.a();
    }

    public void sendClientHelloMessage() throws IOException {
        byte[] bArr;
        SessionParameters sessionParameters;
        this.d.p = this.tlsClient.getClientHelloRecordLayerVersion();
        ProtocolVersion clientVersion = this.tlsClient.getClientVersion();
        if (!clientVersion.isDTLS()) {
            this.m.d = clientVersion;
            byte[] bArr2 = TlsUtils.EMPTY_BYTES;
            TlsSession tlsSession = this.tlsSession;
            if (tlsSession == null || (bArr = tlsSession.getSessionID()) == null || bArr.length > 32) {
                bArr = bArr2;
            }
            boolean isFallback = this.tlsClient.isFallback();
            this.offeredCipherSuites = this.tlsClient.getCipherSuites();
            this.offeredCompressionMethods = this.tlsClient.getCompressionMethods();
            if (bArr.length <= 0 || (sessionParameters = this.sessionParameters) == null || (Arrays.contains(this.offeredCipherSuites, sessionParameters.getCipherSuite()) && Arrays.contains(this.offeredCompressionMethods, this.sessionParameters.getCompressionAlgorithm()))) {
                bArr2 = bArr;
            }
            this.clientExtensions = this.tlsClient.getClientExtensions();
            TlsProtocol.a aVar = new TlsProtocol.a(1, 60);
            TlsUtils.writeVersion(clientVersion, aVar);
            aVar.write(this.securityParameters.getClientRandom());
            TlsUtils.writeOpaque8(bArr2, aVar);
            boolean z = TlsUtils.getExtensionData(this.clientExtensions, TlsProtocol.EXT_RenegotiationInfo) == null;
            boolean z2 = !Arrays.contains(this.offeredCipherSuites, 255);
            if (z && z2) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, 255);
            }
            if (isFallback && !Arrays.contains(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV)) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV);
            }
            TlsUtils.writeUint16ArrayWithUint16Length(this.offeredCipherSuites, aVar);
            TlsUtils.writeUint8ArrayWithUint8Length(this.offeredCompressionMethods, aVar);
            Hashtable hashtable = this.clientExtensions;
            if (hashtable != null) {
                TlsProtocol.writeExtensions(aVar, hashtable);
            }
            aVar.a();
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public void sendClientKeyExchangeMessage() throws IOException {
        TlsProtocol.a aVar = new TlsProtocol.a(16, 60);
        this.keyExchange.generateClientKeyExchange(aVar);
        aVar.a();
    }

    public TlsClientProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }
}
