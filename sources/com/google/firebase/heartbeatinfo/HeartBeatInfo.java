package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;
public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        public final int a;

        /* access modifiers changed from: public */
        HeartBeat(int i) {
            this.a = i;
        }

        public int getCode() {
            return this.a;
        }
    }

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);
}
