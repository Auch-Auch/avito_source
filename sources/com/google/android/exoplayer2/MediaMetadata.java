package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
public final class MediaMetadata {
    @Nullable
    public final String title;

    public static final class Builder {
        @Nullable
        public String a;

        public MediaMetadata build() {
            return new MediaMetadata(this.a, null);
        }

        public Builder setTitle(@Nullable String str) {
            this.a = str;
            return this;
        }
    }

    public MediaMetadata(String str, a aVar) {
        this.title = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        return Util.areEqual(this.title, ((MediaMetadata) obj).title);
    }

    public int hashCode() {
        String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
