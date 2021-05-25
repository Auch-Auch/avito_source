package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Util;
public final class AudioAttributes {
    public static final AudioAttributes DEFAULT = new Builder().build();
    @Nullable
    public android.media.AudioAttributes a;
    public final int allowedCapturePolicy;
    public final int contentType;
    public final int flags;
    public final int usage;

    public static final class Builder {
        public int a = 0;
        public int b = 0;
        public int c = 1;
        public int d = 1;

        public AudioAttributes build() {
            return new AudioAttributes(this.a, this.b, this.c, this.d, null);
        }

        public Builder setAllowedCapturePolicy(int i) {
            this.d = i;
            return this;
        }

        public Builder setContentType(int i) {
            this.a = i;
            return this;
        }

        public Builder setFlags(int i) {
            this.b = i;
            return this;
        }

        public Builder setUsage(int i) {
            this.c = i;
            return this;
        }
    }

    public AudioAttributes(int i, int i2, int i3, int i4, a aVar) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
        this.allowedCapturePolicy = i4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy) {
            return true;
        }
        return false;
    }

    @RequiresApi(21)
    public android.media.AudioAttributes getAudioAttributesV21() {
        if (this.a == null) {
            AudioAttributes.Builder usage2 = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage);
            if (Util.SDK_INT >= 29) {
                usage2.setAllowedCapturePolicy(this.allowedCapturePolicy);
            }
            this.a = usage2.build();
        }
        return this.a;
    }

    public int hashCode() {
        return ((((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy;
    }
}
