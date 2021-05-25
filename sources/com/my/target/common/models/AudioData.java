package com.my.target.common.models;

import androidx.annotation.NonNull;
import com.my.target.bt;
public final class AudioData extends bt<String> {
    public int b;

    public AudioData(@NonNull String str) {
        super(str);
    }

    @NonNull
    public static AudioData newAudioData(@NonNull String str) {
        return new AudioData(str);
    }

    public int getBitrate() {
        return this.b;
    }

    public void setBitrate(int i) {
        this.b = i;
    }
}
