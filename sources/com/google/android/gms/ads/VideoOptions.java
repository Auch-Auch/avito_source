package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaac;
public final class VideoOptions {
    private final boolean zzadr;
    private final boolean zzads;
    private final boolean zzadt;

    public static final class Builder {
        private boolean zzadr = true;
        private boolean zzads = false;
        private boolean zzadt = false;

        public final VideoOptions build() {
            return new VideoOptions(this);
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzadt = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzads = z;
            return this;
        }

        public final Builder setStartMuted(boolean z) {
            this.zzadr = z;
            return this;
        }
    }

    public VideoOptions(zzaac zzaac) {
        this.zzadr = zzaac.zzadr;
        this.zzads = zzaac.zzads;
        this.zzadt = zzaac.zzadt;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzadt;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzads;
    }

    public final boolean getStartMuted() {
        return this.zzadr;
    }

    private VideoOptions(Builder builder) {
        this.zzadr = builder.zzadr;
        this.zzads = builder.zzads;
        this.zzadt = builder.zzadt;
    }
}
