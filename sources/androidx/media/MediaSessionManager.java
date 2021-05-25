package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import l6.q.u;
import l6.q.v;
import l6.q.w;
public final class MediaSessionManager {
    public static final boolean b = Log.isLoggable("MediaSessionManager", 3);
    public static final Object c = new Object();
    public static volatile MediaSessionManager d;
    public a a;

    public interface a {
        boolean a(b bVar);
    }

    public interface b {
        int a();

        String getPackageName();

        int getUid();
    }

    public MediaSessionManager(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new v(context);
        } else {
            this.a = new u(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = d;
        if (mediaSessionManager == null) {
            synchronized (c) {
                mediaSessionManager = d;
                if (mediaSessionManager == null) {
                    d = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = d;
                }
            }
        }
        return mediaSessionManager;
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.a.a(remoteUserInfo.a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        public b a;

        public RemoteUserInfo(@NonNull String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.a = new v.a(str, i, i2);
            } else {
                this.a = new w.a(str, i, i2);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.a.equals(((RemoteUserInfo) obj).a);
        }

        @NonNull
        public String getPackageName() {
            return this.a.getPackageName();
        }

        public int getPid() {
            return this.a.a();
        }

        public int getUid() {
            return this.a.getUid();
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.a = new v.a(remoteUserInfo);
        }
    }
}
