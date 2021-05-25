package com.google.android.exoplayer2.source.dash.manifest;

import a2.b.a.a.a;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
public final class EventStream {
    public final EventMessage[] events;
    public final long[] presentationTimesUs;
    public final String schemeIdUri;
    public final long timescale;
    public final String value;

    public EventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.timescale = j;
        this.presentationTimesUs = jArr;
        this.events = eventMessageArr;
    }

    public String id() {
        String str = this.schemeIdUri;
        String str2 = this.value;
        return a.s2(a.q0(str2, a.q0(str, 1)), str, "/", str2);
    }
}
