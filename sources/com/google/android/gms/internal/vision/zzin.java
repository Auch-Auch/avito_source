package com.google.android.gms.internal.vision;

import java.io.IOException;
public class zzin extends IOException {
    private zzjn zzyx = null;

    public zzin(String str) {
        super(str);
    }

    public static zzin zzhh() {
        return new zzin("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzin zzhi() {
        return new zzin("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzin zzhj() {
        return new zzin("CodedInputStream encountered a malformed varint.");
    }

    public static zzin zzhk() {
        return new zzin("Protocol message contained an invalid tag (zero).");
    }

    public static zzin zzhl() {
        return new zzin("Protocol message end-group tag did not match expected tag.");
    }

    public static zzim zzhm() {
        return new zzim("Protocol message tag had invalid wire type.");
    }

    public static zzin zzhn() {
        return new zzin("Failed to parse the message.");
    }

    public static zzin zzho() {
        return new zzin("Protocol message had invalid UTF-8.");
    }

    public final zzin zzg(zzjn zzjn) {
        this.zzyx = zzjn;
        return this;
    }
}
