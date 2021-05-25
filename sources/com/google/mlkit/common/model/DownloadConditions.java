package com.google.mlkit.common.model;

import a2.j.h.a.b.a;
import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;
public class DownloadConditions {
    public final boolean a;
    public final boolean b;

    public static class Builder {
        public boolean a = false;
        public boolean b = false;

        @NonNull
        public DownloadConditions build() {
            return new DownloadConditions(this.a, this.b, null);
        }

        @NonNull
        @RequiresApi(24)
        @TargetApi(24)
        public Builder requireCharging() {
            this.a = true;
            return this;
        }

        @NonNull
        public Builder requireWifi() {
            this.b = true;
            return this;
        }
    }

    public DownloadConditions(boolean z, boolean z2, a aVar) {
        this.a = z;
        this.b = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DownloadConditions)) {
            return false;
        }
        DownloadConditions downloadConditions = (DownloadConditions) obj;
        return this.a == downloadConditions.a && this.b == downloadConditions.b;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.a), Boolean.valueOf(this.b));
    }

    public boolean isChargingRequired() {
        return this.a;
    }

    public boolean isWifiRequired() {
        return this.b;
    }
}
