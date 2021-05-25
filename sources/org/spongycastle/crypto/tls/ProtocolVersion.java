package org.spongycastle.crypto.tls;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.util.Strings;
public final class ProtocolVersion {
    public static final ProtocolVersion DTLSv10 = new ProtocolVersion(65279, "DTLS 1.0");
    public static final ProtocolVersion DTLSv12 = new ProtocolVersion(65277, "DTLS 1.2");
    public static final ProtocolVersion SSLv3 = new ProtocolVersion(768, "SSL 3.0");
    public static final ProtocolVersion TLSv10 = new ProtocolVersion(769, "TLS 1.0");
    public static final ProtocolVersion TLSv11 = new ProtocolVersion(770, "TLS 1.1");
    public static final ProtocolVersion TLSv12 = new ProtocolVersion(771, "TLS 1.2");
    public int a;
    public String b;

    public ProtocolVersion(int i, String str) {
        this.a = i & 65535;
        this.b = str;
    }

    public static ProtocolVersion a(int i, int i2, String str) throws IOException {
        TlsUtils.checkUint8(i);
        TlsUtils.checkUint8(i2);
        int i3 = (i << 8) | i2;
        return new ProtocolVersion(i3, a.e3(str, " 0x", Strings.toUpperCase(Integer.toHexString(65536 | i3).substring(1))));
    }

    public static ProtocolVersion get(int i, int i2) throws IOException {
        if (i != 3) {
            if (i == 254) {
                switch (i2) {
                    case 253:
                        return DTLSv12;
                    case 254:
                        throw new TlsFatalAlert(47);
                    case 255:
                        return DTLSv10;
                    default:
                        return a(i, i2, "DTLS");
                }
            } else {
                throw new TlsFatalAlert(47);
            }
        } else if (i2 == 0) {
            return SSLv3;
        } else {
            if (i2 == 1) {
                return TLSv10;
            }
            if (i2 == 2) {
                return TLSv11;
            }
            if (i2 != 3) {
                return a(i, i2, "TLS");
            }
            return TLSv12;
        }
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ProtocolVersion) && equals((ProtocolVersion) obj));
    }

    public ProtocolVersion getEquivalentTLSVersion() {
        if (!isDTLS()) {
            return this;
        }
        if (this == DTLSv10) {
            return TLSv11;
        }
        return TLSv12;
    }

    public int getFullVersion() {
        return this.a;
    }

    public int getMajorVersion() {
        return this.a >> 8;
    }

    public int getMinorVersion() {
        return this.a & 255;
    }

    public int hashCode() {
        return this.a;
    }

    public boolean isDTLS() {
        return getMajorVersion() == 254;
    }

    public boolean isEqualOrEarlierVersionOf(ProtocolVersion protocolVersion) {
        if (getMajorVersion() != protocolVersion.getMajorVersion()) {
            return false;
        }
        int minorVersion = protocolVersion.getMinorVersion() - getMinorVersion();
        if (isDTLS()) {
            if (minorVersion > 0) {
                return false;
            }
        } else if (minorVersion < 0) {
            return false;
        }
        return true;
    }

    public boolean isLaterVersionOf(ProtocolVersion protocolVersion) {
        if (getMajorVersion() != protocolVersion.getMajorVersion()) {
            return false;
        }
        int minorVersion = protocolVersion.getMinorVersion() - getMinorVersion();
        if (isDTLS()) {
            if (minorVersion <= 0) {
                return false;
            }
        } else if (minorVersion >= 0) {
            return false;
        }
        return true;
    }

    public boolean isSSL() {
        return this == SSLv3;
    }

    public boolean isTLS() {
        return getMajorVersion() == 3;
    }

    public String toString() {
        return this.b;
    }

    public boolean equals(ProtocolVersion protocolVersion) {
        return protocolVersion != null && this.a == protocolVersion.a;
    }
}
