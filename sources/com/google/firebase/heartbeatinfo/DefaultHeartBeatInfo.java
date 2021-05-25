package com.google.firebase.heartbeatinfo;

import a2.j.e.h.a;
import a2.j.e.h.b;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
public class DefaultHeartBeatInfo implements HeartBeatInfo {
    public b a;

    public DefaultHeartBeatInfo(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b.b == null) {
                b.b = new b(context);
            }
            bVar = b.b;
        }
        this.a = bVar;
    }

    @NonNull
    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).factory(a.a).build();
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    public HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        boolean a3;
        long currentTimeMillis = System.currentTimeMillis();
        boolean a4 = this.a.a(str, currentTimeMillis);
        b bVar = this.a;
        synchronized (bVar) {
            a3 = bVar.a("fire-global", currentTimeMillis);
        }
        if (a4 && a3) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (a3) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (a4) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }
}
