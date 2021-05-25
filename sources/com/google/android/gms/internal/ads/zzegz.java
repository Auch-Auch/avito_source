package com.google.android.gms.internal.ads;

import java.io.IOException;
public class zzegz extends IOException {
    private zzehz zzigo = null;

    public zzegz(String str) {
        super(str);
    }

    public static zzegz zzbgb() {
        return new zzegz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzegz zzbgc() {
        return new zzegz("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzegz zzbgd() {
        return new zzegz("CodedInputStream encountered a malformed varint.");
    }

    public static zzegz zzbge() {
        return new zzegz("Protocol message contained an invalid tag (zero).");
    }

    public static zzegz zzbgf() {
        return new zzegz("Protocol message end-group tag did not match expected tag.");
    }

    public static zzehc zzbgg() {
        return new zzehc("Protocol message tag had invalid wire type.");
    }

    public static zzegz zzbgh() {
        return new zzegz("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static zzegz zzbgi() {
        return new zzegz("Failed to parse the message.");
    }

    public static zzegz zzbgj() {
        return new zzegz("Protocol message had invalid UTF-8.");
    }

    public final zzegz zzl(zzehz zzehz) {
        this.zzigo = zzehz;
        return this;
    }
}
