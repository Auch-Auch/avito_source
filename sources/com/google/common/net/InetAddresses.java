package com.google.common.net;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class InetAddresses {
    public static final Splitter a = Splitter.on((char) FormatterType.defaultDecimalSeparator).limit(4);
    public static final Splitter b = Splitter.on(':').limit(10);
    public static final Inet4Address c = ((Inet4Address) forString("127.0.0.1"));
    public static final Inet4Address d = ((Inet4Address) forString("0.0.0.0"));

    @Beta
    public static final class TeredoInfo {
        public final Inet4Address a;
        public final Inet4Address b;
        public final int c;
        public final int d;

        public TeredoInfo(@NullableDecl Inet4Address inet4Address, @NullableDecl Inet4Address inet4Address2, int i, int i2) {
            boolean z = false;
            Preconditions.checkArgument(i >= 0 && i <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i);
            if (i2 >= 0 && i2 <= 65535) {
                z = true;
            }
            Preconditions.checkArgument(z, "flags '%s' is out of range (0 <= flags <= 0xffff)", i2);
            Inet4Address inet4Address3 = InetAddresses.d;
            this.a = (Inet4Address) MoreObjects.firstNonNull(inet4Address, inet4Address3);
            this.b = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, inet4Address3);
            this.c = i;
            this.d = i2;
        }

        public Inet4Address getClient() {
            return this.b;
        }

        public int getFlags() {
            return this.d;
        }

        public int getPort() {
            return this.c;
        }

        public Inet4Address getServer() {
            return this.a;
        }
    }

    public static InetAddress a(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    @NullableDecl
    public static InetAddress b(String str) {
        int i;
        Preconditions.checkNotNull(str);
        if (!str.startsWith("[") || !str.endsWith("]")) {
            i = 4;
        } else {
            str = str.substring(1, str.length() - 1);
            i = 16;
        }
        byte[] e = e(str);
        if (e == null || e.length != i) {
            return null;
        }
        return a(e);
    }

    public static IllegalArgumentException c(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    public static Inet4Address d(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) a(bArr);
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        Preconditions.checkArgument(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return a(address);
    }

    @NullableDecl
    public static byte[] e(String str) {
        int i;
        int i2;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i4 = -1;
            if (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt == '.') {
                    z2 = true;
                } else if (charAt == ':') {
                    if (z2) {
                        return null;
                    }
                    z = true;
                } else if (Character.digit(charAt, 16) == -1) {
                    return null;
                }
                i3++;
            } else if (z) {
                if (z2) {
                    int lastIndexOf = str.lastIndexOf(58) + 1;
                    String substring = str.substring(0, lastIndexOf);
                    byte[] f = f(str.substring(lastIndexOf));
                    str = f == null ? null : a.d(substring, Integer.toHexString(((f[0] & 255) << 8) | (f[1] & 255)), ":", Integer.toHexString((f[3] & 255) | ((f[2] & 255) << 8)));
                    if (str == null) {
                        return null;
                    }
                }
                List<String> splitToList = b.splitToList(str);
                if (splitToList.size() < 3 || splitToList.size() > 9) {
                    return null;
                }
                for (int i5 = 1; i5 < splitToList.size() - 1; i5++) {
                    if (splitToList.get(i5).length() == 0) {
                        if (i4 >= 0) {
                            return null;
                        }
                        i4 = i5;
                    }
                }
                if (i4 >= 0) {
                    i2 = (splitToList.size() - i4) - 1;
                    if (splitToList.get(0).length() == 0) {
                        i = i4 - 1;
                        if (i != 0) {
                            return null;
                        }
                    } else {
                        i = i4;
                    }
                    if (((String) Iterables.getLast(splitToList)).length() == 0 && i2 - 1 != 0) {
                        return null;
                    }
                } else {
                    i = splitToList.size();
                    i2 = 0;
                }
                int i6 = 8 - (i + i2);
                if (i4 >= 0) {
                    if (i6 < 1) {
                        return null;
                    }
                } else if (i6 != 0) {
                    return null;
                }
                ByteBuffer allocate = ByteBuffer.allocate(16);
                for (int i7 = 0; i7 < i; i7++) {
                    try {
                        int parseInt = Integer.parseInt(splitToList.get(i7), 16);
                        if (parseInt <= 65535) {
                            allocate.putShort((short) parseInt);
                        } else {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                for (int i8 = 0; i8 < i6; i8++) {
                    allocate.putShort(0);
                }
                while (i2 > 0) {
                    int parseInt2 = Integer.parseInt(splitToList.get(splitToList.size() - i2), 16);
                    if (parseInt2 <= 65535) {
                        allocate.putShort((short) parseInt2);
                        i2--;
                    } else {
                        throw new NumberFormatException();
                    }
                }
                return allocate.array();
            } else if (z2) {
                return f(str);
            } else {
                return null;
            }
        }
    }

    @NullableDecl
    public static byte[] f(String str) {
        byte[] bArr = new byte[4];
        try {
            int i = 0;
            for (String str2 : a.split(str)) {
                int i2 = i + 1;
                int parseInt = Integer.parseInt(str2);
                if (parseInt > 255 || (str2.startsWith("0") && str2.length() > 1)) {
                    throw new NumberFormatException();
                }
                bArr[i] = (byte) parseInt;
                i = i2;
            }
            if (i == 4) {
                return bArr;
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static InetAddress forString(String str) {
        byte[] e = e(str);
        if (e != null) {
            return a(e);
        }
        throw c("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress b2 = b(str);
        if (b2 != null) {
            return b2;
        }
        throw c("Not a valid URI IP literal: '%s'", str);
    }

    public static Inet4Address fromInteger(int i) {
        return d(Ints.toByteArray(i));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return d(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z;
        long j;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            if (i >= 15) {
                z = true;
                break;
            } else if (address[i] != 0) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z && address[15] == 1) {
            return c;
        }
        if (z && address[15] == 0) {
            return d;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        if (hasEmbeddedIPv4ClientAddress(inet6Address)) {
            j = (long) getEmbeddedIPv4ClientAddress(inet6Address).hashCode();
        } else {
            j = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
        }
        int asInt = Hashing.murmur3_32().hashLong(j).asInt() | -536870912;
        if (asInt == -1) {
            asInt = -2;
        }
        return d(Ints.toByteArray(asInt));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return d(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw c("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return d(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address d2 = d(Arrays.copyOfRange(address, 4, 8));
        int readShort = ByteStreams.newDataInput(address, 8).readShort() & UShort.MAX_VALUE;
        int i = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i2 = 0; i2 < copyOfRange.length; i2++) {
            copyOfRange[i2] = (byte) (~copyOfRange[i2]);
        }
        return new TeredoInfo(d2, d(copyOfRange), i, readShort);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    public static InetAddress increment(InetAddress inetAddress) {
        boolean z;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            z = false;
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        if (length >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return a(address);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] == 32 && address[1] == 2) {
            return true;
        }
        return false;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if (address[12] == 0 && address[13] == 0 && address[14] == 0 && (address[15] == 0 || address[15] == 1)) {
            return false;
        }
        return true;
    }

    public static boolean isInetAddress(String str) {
        return e(str) != null;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2) {
            return true;
        }
        return false;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] e = e(str);
        if (e == null || e.length != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= 10) {
                for (int i2 = 10; i2 < 12; i2++) {
                    if (e[i2] != -1) {
                        return false;
                    }
                }
                return true;
            } else if (e[i] != 0) {
                return false;
            } else {
                i++;
            }
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        byte[] address;
        for (byte b2 : inetAddress.getAddress()) {
            if (b2 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0) {
            return true;
        }
        return false;
    }

    public static boolean isUriInetAddress(String str) {
        return b(str) != null;
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            int i2 = i * 2;
            iArr[i] = Ints.fromBytes((byte) 0, (byte) 0, address[i2], address[i2 + 1]);
        }
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < 9; i6++) {
            if (i6 >= 8 || iArr[i6] != 0) {
                if (i5 >= 0) {
                    int i7 = i6 - i5;
                    if (i7 > i3) {
                        i4 = i5;
                        i3 = i7;
                    }
                    i5 = -1;
                }
            } else if (i5 < 0) {
                i5 = i6;
            }
        }
        if (i3 >= 2) {
            Arrays.fill(iArr, i4, i3 + i4, -1);
        }
        StringBuilder sb = new StringBuilder(39);
        int i8 = 0;
        boolean z = false;
        while (i8 < 8) {
            boolean z2 = iArr[i8] >= 0;
            if (z2) {
                if (z) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i8]));
            } else if (i8 == 0 || z) {
                sb.append("::");
            }
            i8++;
            z = z2;
        }
        return sb.toString();
    }

    public static String toUriString(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return toAddrString(inetAddress);
        }
        StringBuilder L = a.L("[");
        L.append(toAddrString(inetAddress));
        L.append("]");
        return L.toString();
    }
}
