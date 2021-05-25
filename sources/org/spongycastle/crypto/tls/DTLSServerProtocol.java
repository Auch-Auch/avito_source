package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import x6.e.b.e.f;
import x6.e.b.e.g;
import x6.e.b.e.p;
public class DTLSServerProtocol extends DTLSProtocol {
    public boolean verifyRequests = true;

    public static class ServerHandshakeState {
        public TlsServer a = null;
        public p b = null;
        public int[] c = null;
        public short[] d = null;
        public Hashtable e = null;
        public Hashtable f = null;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public TlsKeyExchange j = null;
        public TlsCredentials k = null;
        public CertificateRequest l = null;
        public short m = -1;
        public Certificate n = null;
    }

    public DTLSServerProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }

    public void abortServerHandshake(ServerHandshakeState serverHandshakeState, f fVar, short s) {
        fVar.b(s);
        invalidateSession(serverHandshakeState);
    }

    public DTLSTransport accept(TlsServer tlsServer, DatagramTransport datagramTransport) throws IOException {
        if (tlsServer == null) {
            throw new IllegalArgumentException("'server' cannot be null");
        } else if (datagramTransport != null) {
            SecurityParameters securityParameters = new SecurityParameters();
            securityParameters.a = 0;
            ServerHandshakeState serverHandshakeState = new ServerHandshakeState();
            serverHandshakeState.a = tlsServer;
            serverHandshakeState.b = new p(this.secureRandom, securityParameters);
            securityParameters.h = TlsProtocol.createRandomBlock(tlsServer.shouldUseGMTUnixTime(), serverHandshakeState.b.a);
            tlsServer.init(serverHandshakeState.b);
            f fVar = new f(datagramTransport, serverHandshakeState.b, tlsServer);
            try {
                DTLSTransport serverHandshake = serverHandshake(serverHandshakeState, fVar);
                securityParameters.a();
                return serverHandshake;
            } catch (TlsFatalAlert e) {
                abortServerHandshake(serverHandshakeState, fVar, e.getAlertDescription());
                throw e;
            } catch (IOException e2) {
                abortServerHandshake(serverHandshakeState, fVar, 80);
                throw e2;
            } catch (RuntimeException e3) {
                abortServerHandshake(serverHandshakeState, fVar, 80);
                throw new TlsFatalAlert(80, e3);
            } catch (Throwable th) {
                securityParameters.a();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("'transport' cannot be null");
        }
    }

    public boolean expectCertificateVerifyMessage(ServerHandshakeState serverHandshakeState) {
        short s = serverHandshakeState.m;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }

    public byte[] generateCertificateRequest(ServerHandshakeState serverHandshakeState, CertificateRequest certificateRequest) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificateRequest.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateCertificateStatus(ServerHandshakeState serverHandshakeState, CertificateStatus certificateStatus) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificateStatus.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateNewSessionTicket(ServerHandshakeState serverHandshakeState, NewSessionTicket newSessionTicket) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        newSessionTicket.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateServerHello(ServerHandshakeState serverHandshakeState) throws IOException {
        SecurityParameters securityParameters = serverHandshakeState.b.c;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion serverVersion = serverHandshakeState.a.getServerVersion();
        if (serverVersion.isEqualOrEarlierVersionOf(serverHandshakeState.b.d)) {
            serverHandshakeState.b.e = serverVersion;
            TlsUtils.writeVersion(serverVersion, byteArrayOutputStream);
            byteArrayOutputStream.write(securityParameters.getServerRandom());
            byte[] bArr = TlsUtils.EMPTY_BYTES;
            TlsUtils.writeOpaque8(bArr, byteArrayOutputStream);
            int selectedCipherSuite = serverHandshakeState.a.getSelectedCipherSuite();
            if (!Arrays.contains(serverHandshakeState.c, selectedCipherSuite) || selectedCipherSuite == 0 || CipherSuite.isSCSV(selectedCipherSuite) || !TlsUtils.isValidCipherSuiteForVersion(selectedCipherSuite, serverHandshakeState.b.e)) {
                throw new TlsFatalAlert(80);
            }
            DTLSProtocol.validateSelectedCipherSuite(selectedCipherSuite, 80);
            securityParameters.b = selectedCipherSuite;
            short selectedCompressionMethod = serverHandshakeState.a.getSelectedCompressionMethod();
            if (Arrays.contains(serverHandshakeState.d, selectedCompressionMethod)) {
                securityParameters.c = selectedCompressionMethod;
                TlsUtils.writeUint16(selectedCipherSuite, byteArrayOutputStream);
                TlsUtils.writeUint8(selectedCompressionMethod, (OutputStream) byteArrayOutputStream);
                Hashtable serverExtensions = serverHandshakeState.a.getServerExtensions();
                serverHandshakeState.f = serverExtensions;
                boolean z = true;
                if (serverHandshakeState.g) {
                    Integer num = TlsProtocol.EXT_RenegotiationInfo;
                    if (TlsUtils.getExtensionData(serverExtensions, num) == null) {
                        Hashtable ensureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(serverHandshakeState.f);
                        serverHandshakeState.f = ensureExtensionsInitialised;
                        ensureExtensionsInitialised.put(num, TlsProtocol.createRenegotiationInfo(bArr));
                    }
                }
                if (securityParameters.o) {
                    Hashtable ensureExtensionsInitialised2 = TlsExtensionsUtils.ensureExtensionsInitialised(serverHandshakeState.f);
                    serverHandshakeState.f = ensureExtensionsInitialised2;
                    TlsExtensionsUtils.addExtendedMasterSecretExtension(ensureExtensionsInitialised2);
                }
                Hashtable hashtable = serverHandshakeState.f;
                if (hashtable != null) {
                    securityParameters.n = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable);
                    securityParameters.l = DTLSProtocol.evaluateMaxFragmentLengthExtension(false, serverHandshakeState.e, serverHandshakeState.f, 80);
                    securityParameters.m = TlsExtensionsUtils.hasTruncatedHMacExtension(serverHandshakeState.f);
                    serverHandshakeState.h = TlsUtils.hasExpectedEmptyExtensionData(serverHandshakeState.f, TlsExtensionsUtils.EXT_status_request, 80);
                    if (!TlsUtils.hasExpectedEmptyExtensionData(serverHandshakeState.f, TlsProtocol.EXT_SessionTicket, 80)) {
                        z = false;
                    }
                    serverHandshakeState.i = z;
                    TlsProtocol.writeExtensions(byteArrayOutputStream, serverHandshakeState.f);
                }
                securityParameters.d = TlsProtocol.getPRFAlgorithm(serverHandshakeState.b, securityParameters.getCipherSuite());
                securityParameters.e = 12;
                return byteArrayOutputStream.toByteArray();
            }
            throw new TlsFatalAlert(80);
        }
        throw new TlsFatalAlert(80);
    }

    public boolean getVerifyRequests() {
        return this.verifyRequests;
    }

    public void invalidateSession(ServerHandshakeState serverHandshakeState) {
        Objects.requireNonNull(serverHandshakeState);
    }

    public void notifyClientCertificate(ServerHandshakeState serverHandshakeState, Certificate certificate) throws IOException {
        if (serverHandshakeState.l == null) {
            throw new IllegalStateException();
        } else if (serverHandshakeState.n == null) {
            serverHandshakeState.n = certificate;
            if (certificate.isEmpty()) {
                serverHandshakeState.j.skipClientCredentials();
            } else {
                serverHandshakeState.k.getCertificate();
                serverHandshakeState.m = TlsUtils.f(certificate);
                serverHandshakeState.j.processClientCertificate(certificate);
            }
            serverHandshakeState.a.notifyClientCertificate(certificate);
        } else {
            throw new TlsFatalAlert(10);
        }
    }

    public void processCertificateVerify(ServerHandshakeState serverHandshakeState, byte[] bArr, TlsHandshakeHash tlsHandshakeHash) throws IOException {
        byte[] bArr2;
        if (serverHandshakeState.l != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            p pVar = serverHandshakeState.b;
            DigitallySigned parse = DigitallySigned.parse(pVar, byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            try {
                SignatureAndHashAlgorithm algorithm = parse.getAlgorithm();
                if (TlsUtils.isTLSv12(pVar)) {
                    TlsUtils.verifySupportedSignatureAlgorithm(serverHandshakeState.l.getSupportedSignatureAlgorithms(), algorithm);
                    bArr2 = tlsHandshakeHash.getFinalHash(algorithm.getHash());
                } else {
                    bArr2 = pVar.c.getSessionHash();
                }
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(serverHandshakeState.n.getCertificateAt(0).getSubjectPublicKeyInfo());
                TlsSigner createTlsSigner = TlsUtils.createTlsSigner(serverHandshakeState.m);
                createTlsSigner.init(pVar);
                if (!createTlsSigner.verifyRawSignature(algorithm, parse.getSignature(), createKey, bArr2)) {
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

    public void processClientCertificate(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate parse = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        notifyClientCertificate(serverHandshakeState, parse);
    }

    public void processClientHello(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        if (readVersion.isDTLS()) {
            byte[] readFully = TlsUtils.readFully(32, byteArrayInputStream);
            if (TlsUtils.readOpaque8(byteArrayInputStream).length <= 32) {
                TlsUtils.readOpaque8(byteArrayInputStream);
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (readUint16 < 2 || (readUint16 & 1) != 0) {
                    throw new TlsFatalAlert(50);
                }
                serverHandshakeState.c = TlsUtils.readUint16Array(readUint16 / 2, byteArrayInputStream);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (readUint8 >= 1) {
                    serverHandshakeState.d = TlsUtils.readUint8Array(readUint8, byteArrayInputStream);
                    Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                    serverHandshakeState.e = readExtensions;
                    p pVar = serverHandshakeState.b;
                    SecurityParameters securityParameters = pVar.c;
                    securityParameters.o = TlsExtensionsUtils.hasExtendedMasterSecretExtension(readExtensions);
                    pVar.d = readVersion;
                    serverHandshakeState.a.notifyClientVersion(readVersion);
                    serverHandshakeState.a.notifyFallback(Arrays.contains(serverHandshakeState.c, (int) CipherSuite.TLS_FALLBACK_SCSV));
                    securityParameters.g = readFully;
                    serverHandshakeState.a.notifyOfferedCipherSuites(serverHandshakeState.c);
                    serverHandshakeState.a.notifyOfferedCompressionMethods(serverHandshakeState.d);
                    if (Arrays.contains(serverHandshakeState.c, 255)) {
                        serverHandshakeState.g = true;
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(serverHandshakeState.e, TlsProtocol.EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        serverHandshakeState.g = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert(40);
                        }
                    }
                    serverHandshakeState.a.notifySecureRenegotiation(serverHandshakeState.g);
                    Hashtable hashtable = serverHandshakeState.e;
                    if (hashtable != null) {
                        TlsExtensionsUtils.getPaddingExtension(hashtable);
                        serverHandshakeState.a.processClientExtensions(serverHandshakeState.e);
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

    public void processClientKeyExchange(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        serverHandshakeState.j.processClientKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    public void processClientSupplementalData(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        serverHandshakeState.a.processClientSupplementalData(TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(bArr)));
    }

    public DTLSTransport serverHandshake(ServerHandshakeState serverHandshakeState, f fVar) throws IOException {
        Certificate certificate;
        CertificateStatus certificateStatus;
        p pVar = serverHandshakeState.b;
        SecurityParameters securityParameters = pVar.c;
        g gVar = new g(pVar, fVar);
        g.b e = gVar.e();
        boolean z = true;
        if (e.b == 1) {
            processClientHello(serverHandshakeState, e.c);
            byte[] generateServerHello = generateServerHello(serverHandshakeState);
            DTLSProtocol.applyMaxFragmentLengthExtension(fVar, securityParameters.l);
            ProtocolVersion protocolVersion = serverHandshakeState.b.e;
            fVar.g = protocolVersion;
            fVar.h = protocolVersion;
            gVar.i(2, generateServerHello);
            gVar.b = gVar.b.notifyPRFDetermined();
            Vector serverSupplementalData = serverHandshakeState.a.getServerSupplementalData();
            if (serverSupplementalData != null) {
                gVar.i(23, DTLSProtocol.generateSupplementalData(serverSupplementalData));
            }
            TlsKeyExchange keyExchange = serverHandshakeState.a.getKeyExchange();
            serverHandshakeState.j = keyExchange;
            keyExchange.init(serverHandshakeState.b);
            TlsCredentials credentials = serverHandshakeState.a.getCredentials();
            serverHandshakeState.k = credentials;
            if (credentials == null) {
                serverHandshakeState.j.skipServerCredentials();
                certificate = null;
            } else {
                serverHandshakeState.j.processServerCredentials(credentials);
                certificate = serverHandshakeState.k.getCertificate();
                gVar.i(11, DTLSProtocol.generateCertificate(certificate));
            }
            if (certificate == null || certificate.isEmpty()) {
                serverHandshakeState.h = false;
            }
            if (serverHandshakeState.h && (certificateStatus = serverHandshakeState.a.getCertificateStatus()) != null) {
                gVar.i(22, generateCertificateStatus(serverHandshakeState, certificateStatus));
            }
            byte[] generateServerKeyExchange = serverHandshakeState.j.generateServerKeyExchange();
            if (generateServerKeyExchange != null) {
                gVar.i(12, generateServerKeyExchange);
            }
            if (serverHandshakeState.k != null) {
                CertificateRequest certificateRequest = serverHandshakeState.a.getCertificateRequest();
                serverHandshakeState.l = certificateRequest;
                if (certificateRequest != null) {
                    boolean isTLSv12 = TlsUtils.isTLSv12(serverHandshakeState.b);
                    if (serverHandshakeState.l.getSupportedSignatureAlgorithms() == null) {
                        z = false;
                    }
                    if (isTLSv12 == z) {
                        serverHandshakeState.j.validateCertificateRequest(serverHandshakeState.l);
                        gVar.i(13, generateCertificateRequest(serverHandshakeState, serverHandshakeState.l));
                        TlsUtils.h(gVar.b, serverHandshakeState.l.getSupportedSignatureAlgorithms());
                    } else {
                        throw new TlsFatalAlert(80);
                    }
                }
            }
            gVar.i(14, TlsUtils.EMPTY_BYTES);
            gVar.b.sealHashAlgorithms();
            g.b e2 = gVar.e();
            if (e2.b == 23) {
                processClientSupplementalData(serverHandshakeState, e2.c);
                e2 = gVar.e();
            } else {
                serverHandshakeState.a.processClientSupplementalData(null);
            }
            if (serverHandshakeState.l == null) {
                serverHandshakeState.j.skipClientCredentials();
            } else if (e2.b == 11) {
                processClientCertificate(serverHandshakeState, e2.c);
                e2 = gVar.e();
            } else if (!TlsUtils.isTLSv12(serverHandshakeState.b)) {
                notifyClientCertificate(serverHandshakeState, Certificate.EMPTY_CHAIN);
            } else {
                throw new TlsFatalAlert(10);
            }
            if (e2.b == 16) {
                processClientKeyExchange(serverHandshakeState, e2.c);
                TlsHandshakeHash tlsHandshakeHash = gVar.b;
                gVar.b = tlsHandshakeHash.stopTracking();
                securityParameters.i = TlsProtocol.getCurrentPRFHash(serverHandshakeState.b, tlsHandshakeHash, null);
                TlsProtocol.establishMasterSecret(serverHandshakeState.b, serverHandshakeState.j);
                fVar.c(serverHandshakeState.a.getCipher());
                if (expectCertificateVerifyMessage(serverHandshakeState)) {
                    processCertificateVerify(serverHandshakeState, gVar.f(15), tlsHandshakeHash);
                }
                p pVar2 = serverHandshakeState.b;
                processFinished(gVar.f(20), TlsUtils.d(pVar2, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(pVar2, gVar.b, null)));
                if (serverHandshakeState.i) {
                    gVar.i(4, generateNewSessionTicket(serverHandshakeState, serverHandshakeState.a.getNewSessionTicket()));
                }
                p pVar3 = serverHandshakeState.b;
                gVar.i(20, TlsUtils.d(pVar3, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(pVar3, gVar.b, null)));
                gVar.b();
                serverHandshakeState.a.notifyHandshakeComplete();
                return new DTLSTransport(fVar);
            }
            throw new TlsFatalAlert(10);
        }
        throw new TlsFatalAlert(10);
    }

    public void setVerifyRequests(boolean z) {
        this.verifyRequests = z;
    }
}
