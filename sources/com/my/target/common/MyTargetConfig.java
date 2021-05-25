package com.my.target.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class MyTargetConfig {
    public final boolean isTrackingEnvironmentEnabled;
    public final boolean isTrackingLocationEnabled;
    @Nullable
    public final String[] testDevices;

    public static final class Builder {
        public boolean a = true;
        public boolean b = true;
        @Nullable
        public String[] c;

        @NonNull
        public MyTargetConfig build() {
            return new MyTargetConfig(this.a, this.b, this.c);
        }

        @NonNull
        public Builder from(@NonNull MyTargetConfig myTargetConfig) {
            this.b = myTargetConfig.isTrackingLocationEnabled;
            this.a = myTargetConfig.isTrackingEnvironmentEnabled;
            this.c = myTargetConfig.testDevices;
            return this;
        }

        @NonNull
        public Builder withTestDevices(@Nullable String... strArr) {
            this.c = strArr;
            return this;
        }

        @NonNull
        public Builder withTrackingEnvironment(boolean z) {
            this.a = z;
            return this;
        }

        @NonNull
        public Builder withTrackingLocation(boolean z) {
            this.b = z;
            return this;
        }
    }

    public MyTargetConfig(boolean z, boolean z2, @Nullable String[] strArr) {
        this.isTrackingEnvironmentEnabled = z;
        this.isTrackingLocationEnabled = z2;
        this.testDevices = strArr;
    }
}
