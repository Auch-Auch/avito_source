package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.tls.SessionParameters;
import org.spongycastle.util.Arrays;
import x6.e.b.e.f;
import x6.e.b.e.g;
import x6.e.b.e.m;
import x6.e.b.e.q;
public class DTLSClientProtocol extends DTLSProtocol {

    public static class ClientHandshakeState {
        public TlsClient a = null;
        public m b = null;
        public TlsSession c = null;
        public SessionParameters d = null;
        public int[] e = null;
        public short[] f = null;
        public Hashtable g = null;
        public Hashtable h = null;
        public byte[] i = null;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;
        public boolean m = false;
        public TlsKeyExchange n = null;
        public TlsAuthentication o = null;
        public CertificateRequest p = null;
        public TlsCredentials q = null;
    }

    public DTLSClientProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }

    public static byte[] patchClientHelloWithCookie(byte[] bArr, byte[] bArr2) throws IOException {
        int readUint8 = TlsUtils.readUint8(bArr, 34) + 35;
        int i = readUint8 + 1;
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, readUint8);
        TlsUtils.checkUint8(bArr2.length);
        TlsUtils.writeUint8(bArr2.length, bArr3, readUint8);
        System.arraycopy(bArr2, 0, bArr3, i, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length + i, bArr.length - i);
        return bArr3;
    }

    public void abortClientHandshake(ClientHandshakeState clientHandshakeState, f fVar, short s) {
        fVar.b(s);
        invalidateSession(clientHandshakeState);
    }

    public DTLSTransport clientHandshake(ClientHandshakeState clientHandshakeState, f fVar) throws IOException {
        g.b bVar;
        Certificate certificate;
        byte[] bArr;
        m mVar = clientHandshakeState.b;
        SecurityParameters securityParameters = mVar.c;
        g gVar = new g(mVar, fVar);
        byte[] generateClientHello = generateClientHello(clientHandshakeState, clientHandshakeState.a);
        fVar.h = ProtocolVersion.DTLSv10;
        gVar.i(1, generateClientHello);
        g.b e = gVar.e();
        while (true) {
            short s = e.b;
            if (s == 3) {
                if (fVar.g.isEqualOrEarlierVersionOf(clientHandshakeState.b.d)) {
                    fVar.g = null;
                    byte[] patchClientHelloWithCookie = patchClientHelloWithCookie(generateClientHello, processHelloVerifyRequest(clientHandshakeState, e.c));
                    gVar.b.reset();
                    gVar.i(1, patchClientHelloWithCookie);
                    e = gVar.e();
                } else {
                    throw new TlsFatalAlert(47);
                }
            } else if (s == 2) {
                ProtocolVersion protocolVersion = fVar.g;
                reportServerVersion(clientHandshakeState, protocolVersion);
                fVar.h = protocolVersion;
                processServerHello(clientHandshakeState, e.c);
                gVar.b = gVar.b.notifyPRFDetermined();
                DTLSProtocol.applyMaxFragmentLengthExtension(fVar, securityParameters.l);
                if (clientHandshakeState.j) {
                    securityParameters.f = Arrays.clone(clientHandshakeState.d.getMasterSecret());
                    fVar.c(clientHandshakeState.a.getCipher());
                    m mVar2 = clientHandshakeState.b;
                    processFinished(gVar.f(20), TlsUtils.d(mVar2, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(mVar2, gVar.b, null)));
                    m mVar3 = clientHandshakeState.b;
                    gVar.i(20, TlsUtils.d(mVar3, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(mVar3, gVar.b, null)));
                    gVar.b();
                    clientHandshakeState.b.f = clientHandshakeState.c;
                    clientHandshakeState.a.notifyHandshakeComplete();
                    return new DTLSTransport(fVar);
                }
                invalidateSession(clientHandshakeState);
                byte[] bArr2 = clientHandshakeState.i;
                if (bArr2.length > 0) {
                    clientHandshakeState.c = new q(bArr2, null);
                }
                g.b e2 = gVar.e();
                if (e2.b == 23) {
                    processServerSupplementalData(clientHandshakeState, e2.c);
                    e2 = gVar.e();
                } else {
                    clientHandshakeState.a.processServerSupplementalData(null);
                }
                TlsKeyExchange keyExchange = clientHandshakeState.a.getKeyExchange();
                clientHandshakeState.n = keyExchange;
                keyExchange.init(clientHandshakeState.b);
                if (e2.b == 11) {
                    certificate = processServerCertificate(clientHandshakeState, e2.c);
                    bVar = gVar.e();
                } else {
                    clientHandshakeState.n.skipServerCredentials();
                    bVar = e2;
                    certificate = null;
                }
                if (certificate == null || certificate.isEmpty()) {
                    clientHandshakeState.l = false;
                }
                if (bVar.b == 22) {
                    processCertificateStatus(clientHandshakeState, bVar.c);
                    bVar = gVar.e();
                }
                if (bVar.b == 12) {
                    processServerKeyExchange(clientHandshakeState, bVar.c);
                    bVar = gVar.e();
                } else {
                    clientHandshakeState.n.skipServerKeyExchange();
                }
                if (bVar.b == 13) {
                    processCertificateRequest(clientHandshakeState, bVar.c);
                    TlsUtils.h(gVar.b, clientHandshakeState.p.getSupportedSignatureAlgorithms());
                    bVar = gVar.e();
                }
                if (bVar.b != 14) {
                    throw new TlsFatalAlert(10);
                } else if (bVar.c.length == 0) {
                    gVar.b.sealHashAlgorithms();
                    Vector clientSupplementalData = clientHandshakeState.a.getClientSupplementalData();
                    if (clientSupplementalData != null) {
                        gVar.i(23, DTLSProtocol.generateSupplementalData(clientSupplementalData));
                    }
                    CertificateRequest certificateRequest = clientHandshakeState.p;
                    if (certificateRequest != null) {
                        TlsCredentials clientCredentials = clientHandshakeState.o.getClientCredentials(certificateRequest);
                        clientHandshakeState.q = clientCredentials;
                        Certificate certificate2 = clientCredentials != null ? clientCredentials.getCertificate() : null;
                        if (certificate2 == null) {
                            certificate2 = Certificate.EMPTY_CHAIN;
                        }
                        gVar.i(11, DTLSProtocol.generateCertificate(certificate2));
                    }
                    TlsCredentials tlsCredentials = clientHandshakeState.q;
                    if (tlsCredentials != null) {
                        clientHandshakeState.n.processClientCredentials(tlsCredentials);
                    } else {
                        clientHandshakeState.n.skipClientCredentials();
                    }
                    gVar.i(16, generateClientKeyExchange(clientHandshakeState));
                    TlsHandshakeHash tlsHandshakeHash = gVar.b;
                    gVar.b = tlsHandshakeHash.stopTracking();
                    securityParameters.i = TlsProtocol.getCurrentPRFHash(clientHandshakeState.b, tlsHandshakeHash, null);
                    TlsProtocol.establishMasterSecret(clientHandshakeState.b, clientHandshakeState.n);
                    fVar.c(clientHandshakeState.a.getCipher());
                    TlsCredentials tlsCredentials2 = clientHandshakeState.q;
                    if (tlsCredentials2 != null && (tlsCredentials2 instanceof TlsSignerCredentials)) {
                        TlsSignerCredentials tlsSignerCredentials = (TlsSignerCredentials) tlsCredentials2;
                        SignatureAndHashAlgorithm signatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(clientHandshakeState.b, tlsSignerCredentials);
                        if (signatureAndHashAlgorithm == null) {
                            bArr = securityParameters.getSessionHash();
                        } else {
                            bArr = tlsHandshakeHash.getFinalHash(signatureAndHashAlgorithm.getHash());
                        }
                        gVar.i(15, generateCertificateVerify(clientHandshakeState, new DigitallySigned(signatureAndHashAlgorithm, tlsSignerCredentials.generateCertificateSignature(bArr))));
                    }
                    m mVar4 = clientHandshakeState.b;
                    gVar.i(20, TlsUtils.d(mVar4, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(mVar4, gVar.b, null)));
                    if (clientHandshakeState.m) {
                        g.b e3 = gVar.e();
                        if (e3.b == 4) {
                            processNewSessionTicket(clientHandshakeState, e3.c);
                        } else {
                            throw new TlsFatalAlert(10);
                        }
                    }
                    m mVar5 = clientHandshakeState.b;
                    processFinished(gVar.f(20), TlsUtils.d(mVar5, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(mVar5, gVar.b, null)));
                    gVar.b();
                    if (clientHandshakeState.c != null) {
                        clientHandshakeState.d = new SessionParameters.Builder().setCipherSuite(securityParameters.getCipherSuite()).setCompressionAlgorithm(securityParameters.getCompressionAlgorithm()).setMasterSecret(securityParameters.getMasterSecret()).setPeerCertificate(certificate).setPSKIdentity(securityParameters.getPSKIdentity()).setSRPIdentity(securityParameters.getSRPIdentity()).setServerExtensions(clientHandshakeState.h).build();
                        TlsSession importSession = TlsUtils.importSession(clientHandshakeState.c.getSessionID(), clientHandshakeState.d);
                        clientHandshakeState.c = importSession;
                        clientHandshakeState.b.f = importSession;
                    }
                    clientHandshakeState.a.notifyHandshakeComplete();
                    return new DTLSTransport(fVar);
                } else {
                    throw new TlsFatalAlert(50);
                }
            } else {
                throw new TlsFatalAlert(10);
            }
        }
    }

    public DTLSTransport connect(TlsClient tlsClient, DatagramTransport datagramTransport) throws IOException {
        SessionParameters exportSessionParameters;
        if (tlsClient == null) {
            throw new IllegalArgumentException("'client' cannot be null");
        } else if (datagramTransport != null) {
            SecurityParameters securityParameters = new SecurityParameters();
            securityParameters.a = 1;
            ClientHandshakeState clientHandshakeState = new ClientHandshakeState();
            clientHandshakeState.a = tlsClient;
            clientHandshakeState.b = new m(this.secureRandom, securityParameters);
            securityParameters.g = TlsProtocol.createRandomBlock(tlsClient.shouldUseGMTUnixTime(), clientHandshakeState.b.a);
            tlsClient.init(clientHandshakeState.b);
            f fVar = new f(datagramTransport, clientHandshakeState.b, tlsClient);
            TlsSession sessionToResume = clientHandshakeState.a.getSessionToResume();
            if (!(sessionToResume == null || !sessionToResume.isResumable() || (exportSessionParameters = sessionToResume.exportSessionParameters()) == null)) {
                clientHandshakeState.c = sessionToResume;
                clientHandshakeState.d = exportSessionParameters;
            }
            try {
                DTLSTransport clientHandshake = clientHandshake(clientHandshakeState, fVar);
                securityParameters.a();
                return clientHandshake;
            } catch (TlsFatalAlert e) {
                abortClientHandshake(clientHandshakeState, fVar, e.getAlertDescription());
                throw e;
            } catch (IOException e2) {
                abortClientHandshake(clientHandshakeState, fVar, 80);
                throw e2;
            } catch (RuntimeException e3) {
                abortClientHandshake(clientHandshakeState, fVar, 80);
                throw new TlsFatalAlert(80, e3);
            } catch (Throwable th) {
                securityParameters.a();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("'transport' cannot be null");
        }
    }

    public byte[] generateCertificateVerify(ClientHandshakeState clientHandshakeState, DigitallySigned digitallySigned) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        digitallySigned.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateClientHello(ClientHandshakeState clientHandshakeState, TlsClient tlsClient) throws IOException {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion clientVersion = tlsClient.getClientVersion();
        if (clientVersion.isDTLS()) {
            m mVar = clientHandshakeState.b;
            mVar.d = clientVersion;
            TlsUtils.writeVersion(clientVersion, byteArrayOutputStream);
            byteArrayOutputStream.write(mVar.c.getClientRandom());
            byte[] bArr2 = TlsUtils.EMPTY_BYTES;
            TlsSession tlsSession = clientHandshakeState.c;
            if (tlsSession == null || (bArr = tlsSession.getSessionID()) == null || bArr.length > 32) {
                bArr = bArr2;
            }
            TlsUtils.writeOpaque8(bArr, byteArrayOutputStream);
            TlsUtils.writeOpaque8(bArr2, byteArrayOutputStream);
            boolean isFallback = tlsClient.isFallback();
            clientHandshakeState.e = tlsClient.getCipherSuites();
            Hashtable clientExtensions = tlsClient.getClientExtensions();
            clientHandshakeState.g = clientExtensions;
            boolean z = TlsUtils.getExtensionData(clientExtensions, TlsProtocol.EXT_RenegotiationInfo) == null;
            boolean z2 = !Arrays.contains(clientHandshakeState.e, 255);
            if (z && z2) {
                clientHandshakeState.e = Arrays.append(clientHandshakeState.e, 255);
            }
            if (isFallback && !Arrays.contains(clientHandshakeState.e, (int) CipherSuite.TLS_FALLBACK_SCSV)) {
                clientHandshakeState.e = Arrays.append(clientHandshakeState.e, (int) CipherSuite.TLS_FALLBACK_SCSV);
            }
            TlsUtils.writeUint16ArrayWithUint16Length(clientHandshakeState.e, byteArrayOutputStream);
            short[] sArr = {0};
            clientHandshakeState.f = sArr;
            TlsUtils.writeUint8ArrayWithUint8Length(sArr, byteArrayOutputStream);
            Hashtable hashtable = clientHandshakeState.g;
            if (hashtable != null) {
                TlsProtocol.writeExtensions(byteArrayOutputStream, hashtable);
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new TlsFatalAlert(80);
    }

    public byte[] generateClientKeyExchange(ClientHandshakeState clientHandshakeState) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        clientHandshakeState.n.generateClientKeyExchange(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void invalidateSession(ClientHandshakeState clientHandshakeState) {
        SessionParameters sessionParameters = clientHandshakeState.d;
        if (sessionParameters != null) {
            sessionParameters.clear();
            clientHandshakeState.d = null;
        }
        TlsSession tlsSession = clientHandshakeState.c;
        if (tlsSession != null) {
            tlsSession.invalidate();
            clientHandshakeState.c = null;
        }
    }

    public void processCertificateRequest(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        if (clientHandshakeState.o != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            clientHandshakeState.p = CertificateRequest.parse(clientHandshakeState.b, byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            clientHandshakeState.n.validateCertificateRequest(clientHandshakeState.p);
            return;
        }
        throw new TlsFatalAlert(40);
    }

    public void processCertificateStatus(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        if (clientHandshakeState.l) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            CertificateStatus.parse(byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            return;
        }
        throw new TlsFatalAlert(10);
    }

    public byte[] processHelloVerifyRequest(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        if (!readVersion.isEqualOrEarlierVersionOf(clientHandshakeState.b.d)) {
            throw new TlsFatalAlert(47);
        } else if (ProtocolVersion.DTLSv12.isEqualOrEarlierVersionOf(readVersion) || readOpaque8.length <= 32) {
            return readOpaque8;
        } else {
            throw new TlsFatalAlert(47);
        }
    }

    public void processNewSessionTicket(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        NewSessionTicket parse = NewSessionTicket.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.a.notifyNewSessionTicket(parse);
    }

    public Certificate processServerCertificate(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate parse = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.n.processServerCertificate(parse);
        TlsAuthentication authentication = clientHandshakeState.a.getAuthentication();
        clientHandshakeState.o = authentication;
        authentication.notifyServerCertificate(parse);
        return parse;
    }

    public void processServerHello(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        TlsSession tlsSession;
        SecurityParameters securityParameters = clientHandshakeState.b.c;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        reportServerVersion(clientHandshakeState, TlsUtils.readVersion(byteArrayInputStream));
        securityParameters.h = TlsUtils.readFully(32, byteArrayInputStream);
        byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
        clientHandshakeState.i = readOpaque8;
        if (readOpaque8.length <= 32) {
            clientHandshakeState.a.notifySessionID(readOpaque8);
            byte[] bArr2 = clientHandshakeState.i;
            boolean z = false;
            clientHandshakeState.j = bArr2.length > 0 && (tlsSession = clientHandshakeState.c) != null && Arrays.areEqual(bArr2, tlsSession.getSessionID());
            int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
            if (!Arrays.contains(clientHandshakeState.e, readUint16) || readUint16 == 0 || CipherSuite.isSCSV(readUint16) || !TlsUtils.isValidCipherSuiteForVersion(readUint16, clientHandshakeState.b.e)) {
                throw new TlsFatalAlert(47);
            }
            DTLSProtocol.validateSelectedCipherSuite(readUint16, 47);
            clientHandshakeState.a.notifySelectedCipherSuite(readUint16);
            short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
            if (Arrays.contains(clientHandshakeState.f, readUint8)) {
                clientHandshakeState.a.notifySelectedCompressionMethod(readUint8);
                Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                clientHandshakeState.h = readExtensions;
                if (readExtensions != null) {
                    Enumeration keys = readExtensions.keys();
                    while (keys.hasMoreElements()) {
                        Integer num = (Integer) keys.nextElement();
                        if (!num.equals(TlsProtocol.EXT_RenegotiationInfo) && TlsUtils.getExtensionData(clientHandshakeState.g, num) == null) {
                            throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                        }
                    }
                }
                byte[] extensionData = TlsUtils.getExtensionData(clientHandshakeState.h, TlsProtocol.EXT_RenegotiationInfo);
                if (extensionData != null) {
                    clientHandshakeState.k = true;
                    if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                        throw new TlsFatalAlert(40);
                    }
                }
                clientHandshakeState.a.notifySecureRenegotiation(clientHandshakeState.k);
                Hashtable hashtable = clientHandshakeState.g;
                Hashtable hashtable2 = clientHandshakeState.h;
                if (clientHandshakeState.j) {
                    if (readUint16 == clientHandshakeState.d.getCipherSuite() && readUint8 == clientHandshakeState.d.getCompressionAlgorithm()) {
                        hashtable = null;
                        hashtable2 = clientHandshakeState.d.readServerExtensions();
                    } else {
                        throw new TlsFatalAlert(47);
                    }
                }
                securityParameters.b = readUint16;
                securityParameters.c = readUint8;
                if (hashtable2 != null) {
                    boolean hasEncryptThenMACExtension = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable2);
                    if (!hasEncryptThenMACExtension || TlsUtils.isBlockCipherSuite(securityParameters.getCipherSuite())) {
                        securityParameters.n = hasEncryptThenMACExtension;
                        securityParameters.o = TlsExtensionsUtils.hasExtendedMasterSecretExtension(hashtable2);
                        securityParameters.l = DTLSProtocol.evaluateMaxFragmentLengthExtension(clientHandshakeState.j, hashtable, hashtable2, 47);
                        securityParameters.m = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable2);
                        clientHandshakeState.l = !clientHandshakeState.j && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsExtensionsUtils.EXT_status_request, 47);
                        if (!clientHandshakeState.j && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsProtocol.EXT_SessionTicket, 47)) {
                            z = true;
                        }
                        clientHandshakeState.m = z;
                    } else {
                        throw new TlsFatalAlert(47);
                    }
                }
                if (hashtable != null) {
                    clientHandshakeState.a.processServerExtensions(hashtable2);
                }
                securityParameters.d = TlsProtocol.getPRFAlgorithm(clientHandshakeState.b, securityParameters.getCipherSuite());
                securityParameters.e = 12;
                return;
            }
            throw new TlsFatalAlert(47);
        }
        throw new TlsFatalAlert(47);
    }

    public void processServerKeyExchange(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        clientHandshakeState.n.processServerKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    public void processServerSupplementalData(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        clientHandshakeState.a.processServerSupplementalData(TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(bArr)));
    }

    public void reportServerVersion(ClientHandshakeState clientHandshakeState, ProtocolVersion protocolVersion) throws IOException {
        m mVar = clientHandshakeState.b;
        ProtocolVersion protocolVersion2 = mVar.e;
        if (protocolVersion2 == null) {
            mVar.e = protocolVersion;
            clientHandshakeState.a.notifyServerVersion(protocolVersion);
        } else if (!protocolVersion2.equals(protocolVersion)) {
            throw new TlsFatalAlert(47);
        }
    }
}
