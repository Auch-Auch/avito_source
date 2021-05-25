package com.google.android.exoplayer2.source.dash.manifest;

import a2.b.a.a.a;
public final class UtcTimingElement {
    public final String schemeIdUri;
    public final String value;

    public UtcTimingElement(String str, String str2) {
        this.schemeIdUri = str;
        this.value = str2;
    }

    public String toString() {
        String str = this.schemeIdUri;
        String str2 = this.value;
        return a.s2(a.q0(str2, a.q0(str, 2)), str, ", ", str2);
    }
}
