package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public final class Constraints {
    public static final Constraints NONE = new Builder().build();
    @ColumnInfo(name = "required_network_type")
    public NetworkType a = NetworkType.NOT_REQUIRED;
    @ColumnInfo(name = "requires_charging")
    public boolean b;
    @ColumnInfo(name = "requires_device_idle")
    public boolean c;
    @ColumnInfo(name = "requires_battery_not_low")
    public boolean d;
    @ColumnInfo(name = "requires_storage_not_low")
    public boolean e;
    @ColumnInfo(name = "trigger_content_update_delay")
    public long f = -1;
    @ColumnInfo(name = "trigger_max_content_delay")
    public long g = -1;
    @ColumnInfo(name = "content_uri_triggers")
    public ContentUriTriggers h = new ContentUriTriggers();

    public static final class Builder {
        public boolean a = false;
        public boolean b = false;
        public NetworkType c = NetworkType.NOT_REQUIRED;
        public boolean d = false;
        public boolean e = false;
        public long f = -1;
        public long g = -1;
        public ContentUriTriggers h = new ContentUriTriggers();

        @NonNull
        @RequiresApi(24)
        public Builder addContentUriTrigger(@NonNull Uri uri, boolean z) {
            this.h.add(uri, z);
            return this;
        }

        @NonNull
        public Constraints build() {
            return new Constraints(this);
        }

        @NonNull
        public Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
            this.c = networkType;
            return this;
        }

        @NonNull
        public Builder setRequiresBatteryNotLow(boolean z) {
            this.d = z;
            return this;
        }

        @NonNull
        public Builder setRequiresCharging(boolean z) {
            this.a = z;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setRequiresDeviceIdle(boolean z) {
            this.b = z;
            return this;
        }

        @NonNull
        public Builder setRequiresStorageNotLow(boolean z) {
            this.e = z;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setTriggerContentMaxDelay(long j, @NonNull TimeUnit timeUnit) {
            this.g = timeUnit.toMillis(j);
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setTriggerContentUpdateDelay(long j, @NonNull TimeUnit timeUnit) {
            this.f = timeUnit.toMillis(j);
            return this;
        }

        @NonNull
        @RequiresApi(26)
        public Builder setTriggerContentMaxDelay(Duration duration) {
            this.g = duration.toMillis();
            return this;
        }

        @NonNull
        @RequiresApi(26)
        public Builder setTriggerContentUpdateDelay(Duration duration) {
            this.f = duration.toMillis();
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Constraints() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.b == constraints.b && this.c == constraints.c && this.d == constraints.d && this.e == constraints.e && this.f == constraints.f && this.g == constraints.g && this.a == constraints.a) {
            return this.h.equals(constraints.h);
        }
        return false;
    }

    @NonNull
    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ContentUriTriggers getContentUriTriggers() {
        return this.h;
    }

    @NonNull
    public NetworkType getRequiredNetworkType() {
        return this.a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerContentUpdateDelay() {
        return this.f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerMaxContentDelay() {
        return this.g;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasContentUriTriggers() {
        return this.h.size() > 0;
    }

    public int hashCode() {
        long j = this.f;
        long j2 = this.g;
        return this.h.hashCode() + (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public boolean requiresBatteryNotLow() {
        return this.d;
    }

    public boolean requiresCharging() {
        return this.b;
    }

    @RequiresApi(23)
    public boolean requiresDeviceIdle() {
        return this.c;
    }

    public boolean requiresStorageNotLow() {
        return this.e;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setContentUriTriggers(@Nullable ContentUriTriggers contentUriTriggers) {
        this.h = contentUriTriggers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiredNetworkType(@NonNull NetworkType networkType) {
        this.a = networkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresBatteryNotLow(boolean z) {
        this.d = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresCharging(boolean z) {
        this.b = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresDeviceIdle(boolean z) {
        this.c = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresStorageNotLow(boolean z) {
        this.e = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerContentUpdateDelay(long j) {
        this.f = j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerMaxContentDelay(long j) {
        this.g = j;
    }

    public Constraints(Builder builder) {
        this.b = builder.a;
        int i = Build.VERSION.SDK_INT;
        this.c = i >= 23 && builder.b;
        this.a = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        if (i >= 24) {
            this.h = builder.h;
            this.f = builder.f;
            this.g = builder.g;
        }
    }

    public Constraints(@NonNull Constraints constraints) {
        this.b = constraints.b;
        this.c = constraints.c;
        this.a = constraints.a;
        this.d = constraints.d;
        this.e = constraints.e;
        this.h = constraints.h;
    }
}
