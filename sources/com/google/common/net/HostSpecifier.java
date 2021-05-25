package com.google.common.net;

import a2.b.a.a.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.net.InetAddress;
import java.text.ParseException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class HostSpecifier {
    public final String a;

    public HostSpecifier(String str) {
        this.a = str;
    }

    public static HostSpecifier from(String str) throws ParseException {
        try {
            return fromValid(str);
        } catch (IllegalArgumentException e) {
            ParseException parseException = new ParseException(a.c3("Invalid host specifier: ", str), 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static HostSpecifier fromValid(String str) {
        InetAddress inetAddress;
        HostAndPort fromString = HostAndPort.fromString(str);
        Preconditions.checkArgument(!fromString.hasPort());
        String host = fromString.getHost();
        try {
            inetAddress = InetAddresses.forString(host);
        } catch (IllegalArgumentException unused) {
            inetAddress = null;
        }
        if (inetAddress != null) {
            return new HostSpecifier(InetAddresses.toUriString(inetAddress));
        }
        InternetDomainName from = InternetDomainName.from(host);
        if (from.hasPublicSuffix()) {
            return new HostSpecifier(from.toString());
        }
        throw new IllegalArgumentException(a.c3("Domain name does not have a recognized public suffix: ", host));
    }

    public static boolean isValid(String str) {
        try {
            fromValid(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostSpecifier) {
            return this.a.equals(((HostSpecifier) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
