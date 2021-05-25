package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.RandomGenerator;
import org.spongycastle.crypto.tls.SessionParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import x6.e.b.e.k;
import x6.e.b.e.n;
import x6.e.b.e.o;
import x6.e.b.e.q;
public abstract class TlsProtocol {
    public static final short ADS_MODE_0_N = 1;
    public static final short ADS_MODE_0_N_FIRSTONLY = 2;
    public static final short ADS_MODE_1_Nsub1 = 0;
    public static final short CS_CERTIFICATE_REQUEST = 7;
    public static final short CS_CERTIFICATE_STATUS = 5;
    public static final short CS_CERTIFICATE_VERIFY = 12;
    public static final short CS_CLIENT_CERTIFICATE = 10;
    public static final short CS_CLIENT_FINISHED = 13;
    public static final short CS_CLIENT_HELLO = 1;
    public static final short CS_CLIENT_KEY_EXCHANGE = 11;
    public static final short CS_CLIENT_SUPPLEMENTAL_DATA = 9;
    public static final short CS_END = 16;
    public static final short CS_SERVER_CERTIFICATE = 4;
    public static final short CS_SERVER_FINISHED = 15;
    public static final short CS_SERVER_HELLO = 2;
    public static final short CS_SERVER_HELLO_DONE = 8;
    public static final short CS_SERVER_KEY_EXCHANGE = 6;
    public static final short CS_SERVER_SESSION_TICKET = 14;
    public static final short CS_SERVER_SUPPLEMENTAL_DATA = 3;
    public static final short CS_START = 0;
    public static final Integer EXT_RenegotiationInfo = Integers.valueOf(65281);
    public static final Integer EXT_SessionTicket = Integers.valueOf(35);
    public ByteQueue a;
    public boolean allowCertificateStatus;
    public ByteQueue b;
    public boolean blocking;
    public ByteQueue c;
    public Hashtable clientExtensions;
    public short connection_state;
    public k d;
    public n e;
    public boolean expectSessionTicket;
    public o f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile boolean i;
    public ByteQueueInputStream inputBuffers;
    public volatile boolean j;
    public volatile int k;
    public byte[] l;
    public int[] offeredCipherSuites;
    public short[] offeredCompressionMethods;
    public ByteQueueOutputStream outputBuffer;
    public Certificate peerCertificate;
    public boolean receivedChangeCipherSpec;
    public boolean resumedSession;
    public SecureRandom secureRandom;
    public boolean secure_renegotiation;
    public SecurityParameters securityParameters;
    public Hashtable serverExtensions;
    public SessionParameters sessionParameters;
    public TlsSession tlsSession;

    public class a extends ByteArrayOutputStream {
        public a(short s, int i) throws IOException {
            super(i + 4);
            TlsUtils.writeUint8(s, (OutputStream) this);
            ((ByteArrayOutputStream) this).count += 3;
        }

        public void a() throws IOException {
            int i = ((ByteArrayOutputStream) this).count - 4;
            TlsUtils.checkUint24(i);
            TlsUtils.writeUint24(i, ((ByteArrayOutputStream) this).buf, 1);
            TlsProtocol.this.writeHandshakeMessage(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
            ((ByteArrayOutputStream) this).buf = null;
        }
    }

    public TlsProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom2) {
        this.a = new ByteQueue(0);
        this.b = new ByteQueue(2);
        this.c = new ByteQueue(0);
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.tlsSession = null;
        this.sessionParameters = null;
        this.securityParameters = null;
        this.peerCertificate = null;
        this.offeredCipherSuites = null;
        this.offeredCompressionMethods = null;
        this.clientExtensions = null;
        this.serverExtensions = null;
        this.connection_state = 0;
        this.resumedSession = false;
        this.receivedChangeCipherSpec = false;
        this.secure_renegotiation = false;
        this.allowCertificateStatus = false;
        this.expectSessionTicket = false;
        this.blocking = true;
        this.d = new k(this, inputStream, outputStream);
        this.secureRandom = secureRandom2;
    }

    public static void assertEmpty(ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (byteArrayInputStream.available() > 0) {
            throw new TlsFatalAlert(50);
        }
    }

    public static byte[] createRandomBlock(boolean z, RandomGenerator randomGenerator) {
        byte[] bArr = new byte[32];
        randomGenerator.nextBytes(bArr);
        if (z) {
            TlsUtils.writeGMTUnixTime(bArr, 0);
        }
        return bArr;
    }

    public static byte[] createRenegotiationInfo(byte[] bArr) throws IOException {
        return TlsUtils.encodeOpaque8(bArr);
    }

    public static void establishMasterSecret(TlsContext tlsContext, TlsKeyExchange tlsKeyExchange) throws IOException {
        byte[] generatePremasterSecret = tlsKeyExchange.generatePremasterSecret();
        byte b2 = 0;
        try {
            tlsContext.getSecurityParameters().f = TlsUtils.c(tlsContext, generatePremasterSecret);
        } finally {
            if (generatePremasterSecret != null) {
                Arrays.fill(generatePremasterSecret, b2);
            }
        }
    }

    public static byte[] getCurrentPRFHash(TlsContext tlsContext, TlsHandshakeHash tlsHandshakeHash, byte[] bArr) {
        Digest forkPRFHash = tlsHandshakeHash.forkPRFHash();
        if (bArr != null && TlsUtils.isSSL(tlsContext)) {
            forkPRFHash.update(bArr, 0, bArr.length);
        }
        byte[] bArr2 = new byte[forkPRFHash.getDigestSize()];
        forkPRFHash.doFinal(bArr2, 0);
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getPRFAlgorithm(org.spongycastle.crypto.tls.TlsContext r4, int r5) throws java.io.IOException {
        /*
            boolean r4 = org.spongycastle.crypto.tls.TlsUtils.isTLSv12(r4)
            r0 = 1
            r1 = 47
            switch(r5) {
                case 59: goto L_0x0038;
                case 60: goto L_0x0038;
                case 61: goto L_0x0038;
                case 62: goto L_0x0038;
                case 63: goto L_0x0038;
                case 64: goto L_0x0038;
                default: goto L_0x000a;
            }
        L_0x000a:
            switch(r5) {
                case 103: goto L_0x0038;
                case 104: goto L_0x0038;
                case 105: goto L_0x0038;
                case 106: goto L_0x0038;
                case 107: goto L_0x0038;
                case 108: goto L_0x0038;
                case 109: goto L_0x0038;
                default: goto L_0x000d;
            }
        L_0x000d:
            r2 = 2
            switch(r5) {
                case 156: goto L_0x0038;
                case 157: goto L_0x002f;
                case 158: goto L_0x0038;
                case 159: goto L_0x002f;
                case 160: goto L_0x0038;
                case 161: goto L_0x002f;
                case 162: goto L_0x0038;
                case 163: goto L_0x002f;
                case 164: goto L_0x0038;
                case 165: goto L_0x002f;
                case 166: goto L_0x0038;
                case 167: goto L_0x002f;
                case 168: goto L_0x0038;
                case 169: goto L_0x002f;
                case 170: goto L_0x0038;
                case 171: goto L_0x002f;
                case 172: goto L_0x0038;
                case 173: goto L_0x002f;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = 0
            switch(r5) {
                case 175: goto L_0x002b;
                case 177: goto L_0x002b;
                case 179: goto L_0x002b;
                case 181: goto L_0x002b;
                case 183: goto L_0x002b;
                case 49208: goto L_0x002b;
                case 49211: goto L_0x002b;
                case 49266: goto L_0x0038;
                case 49267: goto L_0x002f;
                case 49268: goto L_0x0038;
                case 49269: goto L_0x002f;
                case 49270: goto L_0x0038;
                case 49271: goto L_0x002f;
                case 49272: goto L_0x0038;
                case 49273: goto L_0x002f;
                case 49274: goto L_0x0038;
                case 49275: goto L_0x002f;
                case 49276: goto L_0x0038;
                case 49277: goto L_0x002f;
                case 49278: goto L_0x0038;
                case 49279: goto L_0x002f;
                case 49280: goto L_0x0038;
                case 49281: goto L_0x002f;
                case 49282: goto L_0x0038;
                case 49283: goto L_0x002f;
                case 49284: goto L_0x0038;
                case 49285: goto L_0x002f;
                case 49286: goto L_0x0038;
                case 49287: goto L_0x002f;
                case 49288: goto L_0x0038;
                case 49289: goto L_0x002f;
                case 49290: goto L_0x0038;
                case 49291: goto L_0x002f;
                case 49292: goto L_0x0038;
                case 49293: goto L_0x002f;
                case 49294: goto L_0x0038;
                case 49295: goto L_0x002f;
                case 49296: goto L_0x0038;
                case 49297: goto L_0x002f;
                case 49298: goto L_0x0038;
                case 49299: goto L_0x002f;
                case 49301: goto L_0x002b;
                case 49303: goto L_0x002b;
                case 49305: goto L_0x002b;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r5) {
                case 185: goto L_0x002b;
                case 186: goto L_0x0038;
                case 187: goto L_0x0038;
                case 188: goto L_0x0038;
                case 189: goto L_0x0038;
                case 190: goto L_0x0038;
                case 191: goto L_0x0038;
                case 192: goto L_0x0038;
                case 193: goto L_0x0038;
                case 194: goto L_0x0038;
                case 195: goto L_0x0038;
                case 196: goto L_0x0038;
                case 197: goto L_0x0038;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r5) {
                case 49187: goto L_0x0038;
                case 49188: goto L_0x002f;
                case 49189: goto L_0x0038;
                case 49190: goto L_0x002f;
                case 49191: goto L_0x0038;
                case 49192: goto L_0x002f;
                case 49193: goto L_0x0038;
                case 49194: goto L_0x002f;
                case 49195: goto L_0x0038;
                case 49196: goto L_0x002f;
                case 49197: goto L_0x0038;
                case 49198: goto L_0x002f;
                case 49199: goto L_0x0038;
                case 49200: goto L_0x002f;
                case 49201: goto L_0x0038;
                case 49202: goto L_0x002f;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r5) {
                case 49307: goto L_0x002b;
                case 49308: goto L_0x0038;
                case 49309: goto L_0x0038;
                case 49310: goto L_0x0038;
                case 49311: goto L_0x0038;
                case 49312: goto L_0x0038;
                case 49313: goto L_0x0038;
                case 49314: goto L_0x0038;
                case 49315: goto L_0x0038;
                case 49316: goto L_0x0038;
                case 49317: goto L_0x0038;
                case 49318: goto L_0x0038;
                case 49319: goto L_0x0038;
                case 49320: goto L_0x0038;
                case 49321: goto L_0x0038;
                case 49322: goto L_0x0038;
                case 49323: goto L_0x0038;
                case 49324: goto L_0x0038;
                case 49325: goto L_0x0038;
                case 49326: goto L_0x0038;
                case 49327: goto L_0x0038;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r5) {
                case 52392: goto L_0x0038;
                case 52393: goto L_0x0038;
                case 52394: goto L_0x0038;
                case 52395: goto L_0x0038;
                case 52396: goto L_0x0038;
                case 52397: goto L_0x0038;
                case 52398: goto L_0x0038;
                default: goto L_0x0021;
            }
        L_0x0021:
            switch(r5) {
                case 65280: goto L_0x0038;
                case 65281: goto L_0x0038;
                case 65282: goto L_0x0038;
                case 65283: goto L_0x0038;
                case 65284: goto L_0x0038;
                case 65285: goto L_0x0038;
                default: goto L_0x0024;
            }
        L_0x0024:
            switch(r5) {
                case 65296: goto L_0x0038;
                case 65297: goto L_0x0038;
                case 65298: goto L_0x0038;
                case 65299: goto L_0x0038;
                case 65300: goto L_0x0038;
                case 65301: goto L_0x0038;
                default: goto L_0x0027;
            }
        L_0x0027:
            if (r4 == 0) goto L_0x002a
            return r0
        L_0x002a:
            return r3
        L_0x002b:
            if (r4 == 0) goto L_0x002e
            return r2
        L_0x002e:
            return r3
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            return r2
        L_0x0032:
            org.spongycastle.crypto.tls.TlsFatalAlert r4 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r4.<init>(r1)
            throw r4
        L_0x0038:
            if (r4 == 0) goto L_0x003b
            return r0
        L_0x003b:
            org.spongycastle.crypto.tls.TlsFatalAlert r4 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r4.<init>(r1)
            throw r4
            switch-data {59->0x0038, 60->0x0038, 61->0x0038, 62->0x0038, 63->0x0038, 64->0x0038, }
            switch-data {103->0x0038, 104->0x0038, 105->0x0038, 106->0x0038, 107->0x0038, 108->0x0038, 109->0x0038, }
            switch-data {156->0x0038, 157->0x002f, 158->0x0038, 159->0x002f, 160->0x0038, 161->0x002f, 162->0x0038, 163->0x002f, 164->0x0038, 165->0x002f, 166->0x0038, 167->0x002f, 168->0x0038, 169->0x002f, 170->0x0038, 171->0x002f, 172->0x0038, 173->0x002f, }
            switch-data {175->0x002b, 177->0x002b, 179->0x002b, 181->0x002b, 183->0x002b, 49208->0x002b, 49211->0x002b, 49266->0x0038, 49267->0x002f, 49268->0x0038, 49269->0x002f, 49270->0x0038, 49271->0x002f, 49272->0x0038, 49273->0x002f, 49274->0x0038, 49275->0x002f, 49276->0x0038, 49277->0x002f, 49278->0x0038, 49279->0x002f, 49280->0x0038, 49281->0x002f, 49282->0x0038, 49283->0x002f, 49284->0x0038, 49285->0x002f, 49286->0x0038, 49287->0x002f, 49288->0x0038, 49289->0x002f, 49290->0x0038, 49291->0x002f, 49292->0x0038, 49293->0x002f, 49294->0x0038, 49295->0x002f, 49296->0x0038, 49297->0x002f, 49298->0x0038, 49299->0x002f, 49301->0x002b, 49303->0x002b, 49305->0x002b, }
            switch-data {185->0x002b, 186->0x0038, 187->0x0038, 188->0x0038, 189->0x0038, 190->0x0038, 191->0x0038, 192->0x0038, 193->0x0038, 194->0x0038, 195->0x0038, 196->0x0038, 197->0x0038, }
            switch-data {49187->0x0038, 49188->0x002f, 49189->0x0038, 49190->0x002f, 49191->0x0038, 49192->0x002f, 49193->0x0038, 49194->0x002f, 49195->0x0038, 49196->0x002f, 49197->0x0038, 49198->0x002f, 49199->0x0038, 49200->0x002f, 49201->0x0038, 49202->0x002f, }
            switch-data {49307->0x002b, 49308->0x0038, 49309->0x0038, 49310->0x0038, 49311->0x0038, 49312->0x0038, 49313->0x0038, 49314->0x0038, 49315->0x0038, 49316->0x0038, 49317->0x0038, 49318->0x0038, 49319->0x0038, 49320->0x0038, 49321->0x0038, 49322->0x0038, 49323->0x0038, 49324->0x0038, 49325->0x0038, 49326->0x0038, 49327->0x0038, }
            switch-data {52392->0x0038, 52393->0x0038, 52394->0x0038, 52395->0x0038, 52396->0x0038, 52397->0x0038, 52398->0x0038, }
            switch-data {65280->0x0038, 65281->0x0038, 65282->0x0038, 65283->0x0038, 65284->0x0038, 65285->0x0038, }
            switch-data {65296->0x0038, 65297->0x0038, 65298->0x0038, 65299->0x0038, 65300->0x0038, 65301->0x0038, }
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsProtocol.getPRFAlgorithm(org.spongycastle.crypto.tls.TlsContext, int):int");
    }

    public static Hashtable readExtensions(ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (byteArrayInputStream.available() < 1) {
            return null;
        }
        byte[] readOpaque16 = TlsUtils.readOpaque16(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(readOpaque16);
        Hashtable hashtable = new Hashtable();
        while (byteArrayInputStream2.available() > 0) {
            if (hashtable.put(Integers.valueOf(TlsUtils.readUint16(byteArrayInputStream2)), TlsUtils.readOpaque16(byteArrayInputStream2)) != null) {
                throw new TlsFatalAlert(47);
            }
        }
        return hashtable;
    }

    public static Vector readSupplementalDataMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] readOpaque24 = TlsUtils.readOpaque24(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(readOpaque24);
        Vector vector = new Vector();
        while (byteArrayInputStream2.available() > 0) {
            vector.addElement(new SupplementalDataEntry(TlsUtils.readUint16(byteArrayInputStream2), TlsUtils.readOpaque16(byteArrayInputStream2)));
        }
        return vector;
    }

    public static void writeExtensions(OutputStream outputStream, Hashtable hashtable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeSelectedExtensions(byteArrayOutputStream, hashtable, true);
        writeSelectedExtensions(byteArrayOutputStream, hashtable, false);
        TlsUtils.writeOpaque16(byteArrayOutputStream.toByteArray(), outputStream);
    }

    public static void writeSelectedExtensions(OutputStream outputStream, Hashtable hashtable, boolean z) throws IOException {
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            int intValue = num.intValue();
            byte[] bArr = (byte[]) hashtable.get(num);
            if (z == (bArr.length == 0)) {
                TlsUtils.checkUint16(intValue);
                TlsUtils.writeUint16(intValue, outputStream);
                TlsUtils.writeOpaque16(bArr, outputStream);
            }
        }
    }

    public static void writeSupplementalData(OutputStream outputStream, Vector vector) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < vector.size(); i2++) {
            SupplementalDataEntry supplementalDataEntry = (SupplementalDataEntry) vector.elementAt(i2);
            int dataType = supplementalDataEntry.getDataType();
            TlsUtils.checkUint16(dataType);
            TlsUtils.writeUint16(dataType, byteArrayOutputStream);
            TlsUtils.writeOpaque16(supplementalDataEntry.getData(), byteArrayOutputStream);
        }
        TlsUtils.writeOpaque24(byteArrayOutputStream.toByteArray(), outputStream);
    }

    public abstract x6.e.b.e.a a();

    public int applicationDataAvailable() {
        return this.a.available();
    }

    public void applyMaxFragmentLengthExtension() throws IOException {
        short s = this.securityParameters.l;
        if (s < 0) {
            return;
        }
        if (MaxFragmentLength.isValid(s)) {
            int i2 = 1 << (this.securityParameters.l + 8);
            k kVar = this.d;
            kVar.r = i2;
            int i3 = i2 + 1024;
            kVar.s = i3;
            kVar.t = i3 + 1024;
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public final void b(ByteQueue byteQueue) throws IOException {
        while (byteQueue.available() >= 4) {
            byte[] bArr = new byte[4];
            boolean z = false;
            byteQueue.read(bArr, 0, 4, 0);
            short readUint8 = TlsUtils.readUint8(bArr, 0);
            int readUint24 = TlsUtils.readUint24(bArr, 1);
            int i2 = readUint24 + 4;
            if (byteQueue.available() >= i2) {
                if (this.connection_state == 16 || readUint8 == 20) {
                    z = true;
                }
                checkReceivedChangeCipherSpec(z);
                if (readUint8 != 0) {
                    if (readUint8 == 20) {
                        TlsContext context = getContext();
                        if (this.l == null && context.getSecurityParameters().getMasterSecret() != null) {
                            this.l = createVerifyData(!context.isServer());
                        }
                    }
                    byteQueue.copyTo(this.d.n, i2);
                }
                byteQueue.removeData(4);
                handleHandshakeMessage(readUint8, byteQueue.readFrom(readUint24));
            } else {
                return;
            }
        }
    }

    public void blockForHandshake() throws IOException {
        if (this.blocking) {
            while (this.connection_state != 16) {
                if (!this.g) {
                    safeReadRecord();
                } else {
                    throw new TlsFatalAlert(80);
                }
            }
        }
    }

    public void checkReceivedChangeCipherSpec(boolean z) throws IOException {
        if (z != this.receivedChangeCipherSpec) {
            throw new TlsFatalAlert(10);
        }
    }

    public void cleanupHandshake() {
        byte[] bArr = this.l;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
            this.l = null;
        }
        this.securityParameters.a();
        this.peerCertificate = null;
        this.offeredCipherSuites = null;
        this.offeredCompressionMethods = null;
        this.clientExtensions = null;
        this.serverExtensions = null;
        this.resumedSession = false;
        this.receivedChangeCipherSpec = false;
        this.secure_renegotiation = false;
        this.allowCertificateStatus = false;
        this.expectSessionTicket = false;
    }

    public void close() throws IOException {
        handleClose(true);
    }

    public void closeInput() throws IOException {
        if (this.blocking) {
            throw new IllegalStateException("Cannot use closeInput() in blocking mode!");
        } else if (!this.g) {
            if (this.inputBuffers.available() > 0) {
                throw new EOFException();
            } else if (!this.i) {
                throw new TlsFatalAlert(40);
            } else {
                throw new TlsNoCloseNotifyException();
            }
        }
    }

    public void completeHandshake() throws IOException {
        TlsCipher tlsCipher;
        try {
            this.connection_state = 16;
            this.b.shrink();
            this.c.shrink();
            k kVar = this.d;
            TlsCompression tlsCompression = kVar.e;
            TlsCompression tlsCompression2 = kVar.d;
            if (tlsCompression == tlsCompression2 && kVar.f == tlsCompression2 && kVar.h == (tlsCipher = kVar.g) && kVar.i == tlsCipher) {
                kVar.d = null;
                kVar.g = null;
                this.j = !TlsUtils.isTLSv11(getContext());
                if (!this.i) {
                    this.i = true;
                    if (this.blocking) {
                        this.e = new n(this);
                        this.f = new o(this);
                    }
                }
                if (this.tlsSession != null) {
                    if (this.sessionParameters == null) {
                        this.sessionParameters = new SessionParameters.Builder().setCipherSuite(this.securityParameters.getCipherSuite()).setCompressionAlgorithm(this.securityParameters.getCompressionAlgorithm()).setMasterSecret(this.securityParameters.getMasterSecret()).setPeerCertificate(this.peerCertificate).setPSKIdentity(this.securityParameters.getPSKIdentity()).setSRPIdentity(this.securityParameters.getSRPIdentity()).setServerExtensions(this.serverExtensions).build();
                        this.tlsSession = new q(this.tlsSession.getSessionID(), this.sessionParameters);
                    }
                    a().f = this.tlsSession;
                }
                getPeer().notifyHandshakeComplete();
                return;
            }
            throw new TlsFatalAlert(40);
        } finally {
            cleanupHandshake();
        }
    }

    public byte[] createVerifyData(boolean z) {
        TlsContext context = getContext();
        return TlsUtils.d(context, z ? ExporterLabel.server_finished : ExporterLabel.client_finished, getCurrentPRFHash(context, this.d.m, z ? TlsUtils.b : TlsUtils.a));
    }

    public void flush() throws IOException {
        this.d.c.flush();
    }

    public int getAvailableInputBytes() {
        if (!this.blocking) {
            return applicationDataAvailable();
        }
        throw new IllegalStateException("Cannot use getAvailableInputBytes() in blocking mode! Use getInputStream().available() instead.");
    }

    public int getAvailableOutputBytes() {
        if (!this.blocking) {
            return this.outputBuffer.getBuffer().available();
        }
        throw new IllegalStateException("Cannot use getAvailableOutputBytes() in blocking mode! Use getOutputStream() instead.");
    }

    public abstract TlsContext getContext();

    public InputStream getInputStream() {
        if (this.blocking) {
            return this.e;
        }
        throw new IllegalStateException("Cannot use InputStream in non-blocking mode! Use offerInput() instead.");
    }

    public OutputStream getOutputStream() {
        if (this.blocking) {
            return this.f;
        }
        throw new IllegalStateException("Cannot use OutputStream in non-blocking mode! Use offerOutput() instead.");
    }

    public abstract TlsPeer getPeer();

    public void handleAlertMessage(short s, short s2) throws IOException {
        getPeer().notifyAlertReceived(s, s2);
        if (s == 1) {
            handleAlertWarningMessage(s2);
        } else {
            handleFailure();
            throw new TlsFatalAlertReceived(s2);
        }
    }

    public void handleAlertWarningMessage(short s) throws IOException {
        if (s != 0) {
            return;
        }
        if (this.i) {
            handleClose(false);
            return;
        }
        throw new TlsFatalAlert(40);
    }

    public void handleChangeCipherSpecMessage() throws IOException {
    }

    public void handleClose(boolean z) throws IOException {
        if (!this.g) {
            this.g = true;
            if (z && !this.i) {
                raiseAlertWarning(90, "User canceled handshake");
            }
            raiseAlertWarning(0, "Connection closed");
            k kVar = this.d;
            Objects.requireNonNull(kVar);
            try {
                kVar.b.close();
            } catch (IOException unused) {
            }
            try {
                kVar.c.close();
            } catch (IOException unused2) {
            }
            if (!this.i) {
                cleanupHandshake();
            }
        }
    }

    public void handleException(short s, String str, Throwable th) throws IOException {
        if (!this.g) {
            raiseAlertFatal(s, str, th);
            handleFailure();
        }
    }

    public void handleFailure() {
        this.g = true;
        this.h = true;
        invalidateSession();
        k kVar = this.d;
        Objects.requireNonNull(kVar);
        try {
            kVar.b.close();
        } catch (IOException unused) {
        }
        try {
            kVar.c.close();
        } catch (IOException unused2) {
        }
        if (!this.i) {
            cleanupHandshake();
        }
    }

    public abstract void handleHandshakeMessage(short s, ByteArrayInputStream byteArrayInputStream) throws IOException;

    public void invalidateSession() {
        SessionParameters sessionParameters2 = this.sessionParameters;
        if (sessionParameters2 != null) {
            sessionParameters2.clear();
            this.sessionParameters = null;
        }
        TlsSession tlsSession2 = this.tlsSession;
        if (tlsSession2 != null) {
            tlsSession2.invalidate();
            this.tlsSession = null;
        }
    }

    public boolean isClosed() {
        return this.g;
    }

    public void offerInput(byte[] bArr) throws IOException {
        if (this.blocking) {
            throw new IllegalStateException("Cannot use offerInput() in blocking mode! Use getInputStream() instead.");
        } else if (!this.g) {
            this.inputBuffers.addBytes(bArr);
            while (this.inputBuffers.available() >= 5) {
                byte[] bArr2 = new byte[5];
                this.inputBuffers.peek(bArr2);
                if (this.inputBuffers.available() < TlsUtils.readUint16(bArr2, 3) + 5) {
                    safeCheckRecordHeader(bArr2);
                    return;
                }
                safeReadRecord();
                if (this.g) {
                    if (this.connection_state != 16) {
                        throw new TlsFatalAlert(80);
                    }
                    return;
                }
            }
        } else {
            throw new IOException("Connection is closed, cannot accept any more input");
        }
    }

    public void offerOutput(byte[] bArr, int i2, int i3) throws IOException {
        if (this.blocking) {
            throw new IllegalStateException("Cannot use offerOutput() in blocking mode! Use getOutputStream() instead.");
        } else if (this.i) {
            writeData(bArr, i2, i3);
        } else {
            throw new IOException("Application data cannot be sent until the handshake is complete!");
        }
    }

    public void processFinishedMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] bArr = this.l;
        if (bArr != null) {
            byte[] readFully = TlsUtils.readFully(bArr.length, byteArrayInputStream);
            assertEmpty(byteArrayInputStream);
            if (!Arrays.constantTimeAreEqual(this.l, readFully)) {
                throw new TlsFatalAlert(51);
            }
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public short processMaxFragmentLengthExtension(Hashtable hashtable, Hashtable hashtable2, short s) throws IOException {
        short maxFragmentLengthExtension = TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable2);
        if (maxFragmentLengthExtension < 0 || (MaxFragmentLength.isValid(maxFragmentLengthExtension) && (this.resumedSession || maxFragmentLengthExtension == TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable)))) {
            return maxFragmentLengthExtension;
        }
        throw new TlsFatalAlert(s);
    }

    public void processRecord(short s, byte[] bArr, int i2, int i3) throws IOException {
        TlsCipher tlsCipher;
        switch (s) {
            case 20:
                break;
            case 21:
                this.b.addData(bArr, i2, i3);
                while (this.b.available() >= 2) {
                    byte[] removeData = this.b.removeData(2, 0);
                    handleAlertMessage((short) removeData[0], (short) removeData[1]);
                }
                return;
            case 22:
                if (this.c.available() > 0) {
                    this.c.addData(bArr, i2, i3);
                    b(this.c);
                    return;
                }
                ByteQueue byteQueue = new ByteQueue(bArr, i2, i3);
                b(byteQueue);
                int available = byteQueue.available();
                if (available > 0) {
                    this.c.addData(bArr, (i2 + i3) - available, available);
                    return;
                }
                return;
            case 23:
                if (this.i) {
                    this.a.addData(bArr, i2, i3);
                    return;
                }
                throw new TlsFatalAlert(10);
            default:
                throw new TlsFatalAlert(80);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (TlsUtils.readUint8(bArr, i2 + i4) != 1) {
                throw new TlsFatalAlert(50);
            } else if (this.receivedChangeCipherSpec || this.b.available() > 0 || this.c.available() > 0) {
                throw new TlsFatalAlert(10);
            } else {
                k kVar = this.d;
                TlsCompression tlsCompression = kVar.d;
                if (tlsCompression == null || (tlsCipher = kVar.g) == null) {
                    throw new TlsFatalAlert(40);
                }
                kVar.e = tlsCompression;
                kVar.h = tlsCipher;
                kVar.j = new k.b(null);
                this.receivedChangeCipherSpec = true;
                handleChangeCipherSpecMessage();
            }
        }
    }

    public void raiseAlertFatal(short s, String str, Throwable th) throws IOException {
        getPeer().notifyAlertRaised(2, s, str, th);
        try {
            this.d.f(21, new byte[]{2, (byte) s}, 0, 2);
        } catch (Exception unused) {
        }
    }

    public void raiseAlertWarning(short s, String str) throws IOException {
        getPeer().notifyAlertRaised(1, s, str, null);
        safeWriteRecord(21, new byte[]{1, (byte) s}, 0, 2);
    }

    public int readApplicationData(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 < 1) {
            return 0;
        }
        while (this.a.available() == 0) {
            if (!this.g) {
                safeReadRecord();
            } else if (this.h) {
                throw new IOException("Cannot read application data on failed TLS connection");
            } else if (this.i) {
                return -1;
            } else {
                throw new IllegalStateException("Cannot read application data until initial handshake completed.");
            }
        }
        int min = Math.min(i3, this.a.available());
        this.a.removeData(bArr, i2, min, 0);
        return min;
    }

    public int readInput(byte[] bArr, int i2, int i3) {
        if (!this.blocking) {
            try {
                return readApplicationData(bArr, i2, Math.min(i3, applicationDataAvailable()));
            } catch (IOException e2) {
                throw new RuntimeException(e2.toString());
            }
        } else {
            throw new IllegalStateException("Cannot use readInput() in blocking mode! Use getInputStream() instead.");
        }
    }

    public int readOutput(byte[] bArr, int i2, int i3) {
        if (!this.blocking) {
            int min = Math.min(getAvailableOutputBytes(), i3);
            this.outputBuffer.getBuffer().removeData(bArr, i2, min, 0);
            return min;
        }
        throw new IllegalStateException("Cannot use readOutput() in blocking mode! Use getOutputStream() instead.");
    }

    public void refuseRenegotiation() throws IOException {
        if (!TlsUtils.isSSL(getContext())) {
            raiseAlertWarning(100, "Renegotiation not supported");
            return;
        }
        throw new TlsFatalAlert(40);
    }

    public void safeCheckRecordHeader(byte[] bArr) throws IOException {
        try {
            this.d.b(bArr);
        } catch (TlsFatalAlert e2) {
            handleException(e2.getAlertDescription(), "Failed to read record", e2);
            throw e2;
        } catch (IOException e3) {
            handleException(80, "Failed to read record", e3);
            throw e3;
        } catch (RuntimeException e4) {
            handleException(80, "Failed to read record", e4);
            throw new TlsFatalAlert(80, e4);
        }
    }

    public void safeReadRecord() throws IOException {
        try {
            if (!this.d.e()) {
                if (!this.i) {
                    throw new TlsFatalAlert(40);
                }
                handleFailure();
                throw new TlsNoCloseNotifyException();
            }
        } catch (TlsFatalAlertReceived e2) {
            throw e2;
        } catch (TlsFatalAlert e3) {
            handleException(e3.getAlertDescription(), "Failed to read record", e3);
            throw e3;
        } catch (IOException e4) {
            handleException(80, "Failed to read record", e4);
            throw e4;
        } catch (RuntimeException e5) {
            handleException(80, "Failed to read record", e5);
            throw new TlsFatalAlert(80, e5);
        }
    }

    public void safeWriteRecord(short s, byte[] bArr, int i2, int i3) throws IOException {
        try {
            this.d.f(s, bArr, i2, i3);
        } catch (TlsFatalAlert e2) {
            handleException(e2.getAlertDescription(), "Failed to write record", e2);
            throw e2;
        } catch (IOException e3) {
            handleException(80, "Failed to write record", e3);
            throw e3;
        } catch (RuntimeException e4) {
            handleException(80, "Failed to write record", e4);
            throw new TlsFatalAlert(80, e4);
        }
    }

    public void sendCertificateMessage(Certificate certificate) throws IOException {
        if (certificate == null) {
            certificate = Certificate.EMPTY_CHAIN;
        }
        if (certificate.isEmpty() && !getContext().isServer()) {
            ProtocolVersion serverVersion = getContext().getServerVersion();
            if (serverVersion.isSSL()) {
                raiseAlertWarning(41, serverVersion.toString() + " client didn't provide credentials");
                return;
            }
        }
        a aVar = new a(11, 60);
        certificate.encode(aVar);
        aVar.a();
    }

    public void sendChangeCipherSpecMessage() throws IOException {
        TlsCipher tlsCipher;
        safeWriteRecord(20, new byte[]{1}, 0, 1);
        k kVar = this.d;
        TlsCompression tlsCompression = kVar.d;
        if (tlsCompression == null || (tlsCipher = kVar.g) == null) {
            throw new TlsFatalAlert(40);
        }
        kVar.f = tlsCompression;
        kVar.i = tlsCipher;
        kVar.k = new k.b(null);
    }

    public void sendFinishedMessage() throws IOException {
        byte[] createVerifyData = createVerifyData(getContext().isServer());
        a aVar = new a(20, createVerifyData.length);
        aVar.write(createVerifyData);
        aVar.a();
    }

    public void sendSupplementalDataMessage(Vector vector) throws IOException {
        a aVar = new a(23, 60);
        writeSupplementalData(aVar, vector);
        aVar.a();
    }

    public void setAppDataSplitMode(int i2) {
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Illegal appDataSplitMode mode: ", i2));
        }
        this.k = i2;
    }

    public void writeData(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.g) {
            while (i3 > 0) {
                if (this.j) {
                    int i4 = this.k;
                    if (i4 != 1) {
                        if (i4 != 2) {
                            safeWriteRecord(23, bArr, i2, 1);
                            i2++;
                            i3--;
                        } else {
                            this.j = false;
                        }
                    }
                    safeWriteRecord(23, TlsUtils.EMPTY_BYTES, 0, 0);
                }
                if (i3 > 0) {
                    int min = Math.min(i3, this.d.r);
                    safeWriteRecord(23, bArr, i2, min);
                    i2 += min;
                    i3 -= min;
                }
            }
            return;
        }
        throw new IOException("Cannot write application data on closed/failed TLS connection");
    }

    public void writeHandshakeMessage(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 >= 4) {
            if (TlsUtils.readUint8(bArr, i2) != 0) {
                this.d.n.write(bArr, i2, i3);
            }
            int i4 = 0;
            do {
                int min = Math.min(i3 - i4, this.d.r);
                safeWriteRecord(22, bArr, i2 + i4, min);
                i4 += min;
            } while (i4 < i3);
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public TlsProtocol(SecureRandom secureRandom2) {
        this.a = new ByteQueue(0);
        this.b = new ByteQueue(2);
        this.c = new ByteQueue(0);
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.tlsSession = null;
        this.sessionParameters = null;
        this.securityParameters = null;
        this.peerCertificate = null;
        this.offeredCipherSuites = null;
        this.offeredCompressionMethods = null;
        this.clientExtensions = null;
        this.serverExtensions = null;
        this.connection_state = 0;
        this.resumedSession = false;
        this.receivedChangeCipherSpec = false;
        this.secure_renegotiation = false;
        this.allowCertificateStatus = false;
        this.expectSessionTicket = false;
        this.blocking = false;
        this.inputBuffers = new ByteQueueInputStream();
        ByteQueueOutputStream byteQueueOutputStream = new ByteQueueOutputStream();
        this.outputBuffer = byteQueueOutputStream;
        this.d = new k(this, this.inputBuffers, byteQueueOutputStream);
        this.secureRandom = secureRandom2;
    }
}
