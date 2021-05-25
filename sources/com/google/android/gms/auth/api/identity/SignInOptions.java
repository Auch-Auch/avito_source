package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
public final class SignInOptions implements Api.ApiOptions.Optional {
    private final String zzau;

    public static class Builder {
        private String zzau;

        private Builder() {
        }

        public static Builder zzc(SignInOptions signInOptions) {
            Builder builder = new Builder();
            String zzg = signInOptions.zzg();
            if (zzg != null) {
                builder.zze(zzg);
            }
            return builder;
        }

        public SignInOptions build() {
            return new SignInOptions(this.zzau);
        }

        public final Builder zze(@NonNull String str) {
            this.zzau = Preconditions.checkNotEmpty(str);
            return this;
        }
    }

    public SignInOptions(String str) {
        this.zzau = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public final boolean equals(@Nullable Object obj) {
        return obj instanceof SignInOptions;
    }

    public final int hashCode() {
        return Objects.hashCode(SignInOptions.class);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.zzau);
        return bundle;
    }

    public final String zzg() {
        return this.zzau;
    }
}
