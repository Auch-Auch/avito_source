package com.google.common.net;

import a2.b.a.a.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable
@Beta
@GwtCompatible
public final class HostAndPort implements Serializable {
    private static final long serialVersionUID = 0;
    public final String a;
    public final int b;
    public final boolean c;

    public HostAndPort(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }

    public static boolean a(int i) {
        return i >= 0 && i <= 65535;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i) {
        Preconditions.checkArgument(a(i), "Port out of range: %s", i);
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.a, i, fromString.c);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        String[] strArr;
        Preconditions.checkNotNull(str);
        int i = -1;
        boolean z = false;
        if (str.startsWith("[")) {
            Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
            int indexOf = str.indexOf(58);
            int lastIndexOf = str.lastIndexOf(93);
            Preconditions.checkArgument(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
            String substring = str.substring(1, lastIndexOf);
            int i2 = lastIndexOf + 1;
            if (i2 == str.length()) {
                strArr = new String[]{substring, ""};
            } else {
                Preconditions.checkArgument(str.charAt(i2) == ':', "Only a colon may follow a close bracket: %s", str);
                int i3 = lastIndexOf + 2;
                for (int i4 = i3; i4 < str.length(); i4++) {
                    Preconditions.checkArgument(Character.isDigit(str.charAt(i4)), "Port must be numeric: %s", str);
                }
                strArr = new String[]{substring, str.substring(i3)};
            }
            str3 = strArr[0];
            str2 = strArr[1];
        } else {
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0) {
                int i5 = indexOf2 + 1;
                if (str.indexOf(58, i5) == -1) {
                    str3 = str.substring(0, indexOf2);
                    str2 = str.substring(i5);
                }
            }
            if (indexOf2 >= 0) {
                z = true;
            }
            str2 = null;
            str3 = str;
        }
        if (!Strings.isNullOrEmpty(str2)) {
            Preconditions.checkArgument(!str2.startsWith("+"), "Unparseable port number: %s", str);
            try {
                i = Integer.parseInt(str2);
                Preconditions.checkArgument(a(i), "Port number out of range: %s", str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(a.c3("Unparseable port number: ", str));
            }
        }
        return new HostAndPort(str3, i, z);
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        if (!Objects.equal(this.a, hostAndPort.a) || this.b != hostAndPort.b) {
            return false;
        }
        return true;
    }

    public String getHost() {
        return this.a;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.b;
    }

    public int getPortOrDefault(int i) {
        return hasPort() ? this.b : i;
    }

    public boolean hasPort() {
        return this.b >= 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(this.a, Integer.valueOf(this.b));
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.c, "Possible bracketless IPv6 literal: %s", this.a);
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(this.a.length() + 8);
        if (this.a.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.a);
            sb.append(']');
        } else {
            sb.append(this.a);
        }
        if (hasPort()) {
            sb.append(':');
            sb.append(this.b);
        }
        return sb.toString();
    }

    public HostAndPort withDefaultPort(int i) {
        Preconditions.checkArgument(a(i));
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(this.a, i, this.c);
    }
}
