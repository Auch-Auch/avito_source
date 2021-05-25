package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
@Deprecated
public class BrowserActionItem {
    public final String a;
    @Nullable
    public final PendingIntent b;
    @DrawableRes
    public int c;
    @Nullable
    public Uri d;
    @Nullable
    public Runnable e;

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i) {
        this.a = str;
        this.b = pendingIntent;
        this.c = i;
    }

    @NonNull
    public PendingIntent getAction() {
        PendingIntent pendingIntent = this.b;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }

    public int getIconId() {
        return this.c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Uri getIconUri() {
        return this.d;
    }

    @NonNull
    public String getTitle() {
        return this.a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @NonNull Uri uri) {
        this.a = str;
        this.b = pendingIntent;
        this.d = uri;
    }

    public BrowserActionItem(@NonNull String str, @NonNull Runnable runnable) {
        this.a = str;
        this.b = null;
        this.e = runnable;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
