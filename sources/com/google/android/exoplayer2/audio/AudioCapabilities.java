package com.google.android.exoplayer2.audio;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
public final class AudioCapabilities {
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[]{2}, 8);
    public static final AudioCapabilities c = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    public final int[] a;
    public final int b;

    public AudioCapabilities(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.a = new int[0];
        }
        this.b = i;
    }

    public static boolean a() {
        return Util.SDK_INT >= 17 && "Amazon".equals(Util.MANUFACTURER);
    }

    @SuppressLint({"InlinedApi"})
    public static AudioCapabilities b(Context context, @Nullable Intent intent) {
        if (a() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return c;
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return DEFAULT_AUDIO_CAPABILITIES;
        }
        return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    public static AudioCapabilities getCapabilities(Context context) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (!Arrays.equals(this.a, audioCapabilities.a) || this.b != audioCapabilities.b) {
            return false;
        }
        return true;
    }

    public int getMaxChannelCount() {
        return this.b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + this.b;
    }

    public boolean supportsEncoding(int i) {
        return Arrays.binarySearch(this.a, i) >= 0;
    }

    public String toString() {
        StringBuilder L = a.L("AudioCapabilities[maxChannelCount=");
        L.append(this.b);
        L.append(", supportedEncodings=");
        L.append(Arrays.toString(this.a));
        L.append("]");
        return L.toString();
    }
}
