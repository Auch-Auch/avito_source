package androidx.work;

import android.app.Notification;
import androidx.annotation.NonNull;
public final class ForegroundInfo {
    public final int a;
    public final int b;
    public final Notification c;

    public ForegroundInfo(int i, @NonNull Notification notification) {
        this(i, notification, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.a == foregroundInfo.a && this.b == foregroundInfo.b) {
            return this.c.equals(foregroundInfo.c);
        }
        return false;
    }

    public int getForegroundServiceType() {
        return this.b;
    }

    @NonNull
    public Notification getNotification() {
        return this.c;
    }

    public int getNotificationId() {
        return this.a;
    }

    public int hashCode() {
        return this.c.hashCode() + (((this.a * 31) + this.b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }

    public ForegroundInfo(int i, @NonNull Notification notification, int i2) {
        this.a = i;
        this.c = notification;
        this.b = i2;
    }
}
