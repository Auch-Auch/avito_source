package com.voximplant.sdk.internal.call;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.List;
public class EndpointTracks {
    public int a;
    public List<String> b = new ArrayList();
    public List<String> c = new ArrayList();
    public List<String> d = new ArrayList();

    public EndpointTracks(int i) {
        this.a = i;
    }

    public void addAudioTrack(String str) {
        this.b.add(str);
    }

    public void addScreenSharingTrack(String str) {
        this.d.add(str);
    }

    public void addVideoTrack(String str) {
        this.c.add(str);
    }

    public String toString() {
        StringBuilder L = a.L("EndpointTracks: place: ");
        L.append(this.a);
        L.append(", audio tracks: ");
        L.append(this.b);
        L.append(", video tracks: ");
        L.append(this.c);
        L.append(", sharing: ");
        L.append(this.d);
        return L.toString();
    }
}
