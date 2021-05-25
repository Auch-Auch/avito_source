package l6.q;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
public class w implements MediaSessionManager.a {
    public static final boolean c = MediaSessionManager.b;
    public Context a;
    public ContentResolver b;

    public static class a implements MediaSessionManager.b {
        public String a;
        public int b;
        public int c;

        public a(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.media.MediaSessionManager.b
        public int a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (TextUtils.equals(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        @Override // androidx.media.MediaSessionManager.b
        public String getPackageName() {
            return this.a;
        }

        @Override // androidx.media.MediaSessionManager.b
        public int getUid() {
            return this.c;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c));
        }
    }

    public w(Context context) {
        this.a = context;
        this.b = context.getContentResolver();
    }

    @Override // androidx.media.MediaSessionManager.a
    public boolean a(@NonNull MediaSessionManager.b bVar) {
        boolean z;
        try {
            if (this.a.getPackageManager().getApplicationInfo(bVar.getPackageName(), 0).uid != bVar.getUid()) {
                if (c) {
                    bVar.getPackageName();
                    bVar.getUid();
                }
                return false;
            }
            if (!b(bVar, "android.permission.STATUS_BAR_SERVICE") && !b(bVar, "android.permission.MEDIA_CONTENT_CONTROL") && bVar.getUid() != 1000) {
                String string = Settings.Secure.getString(this.b, "enabled_notification_listeners");
                if (string != null) {
                    String[] split = string.split(":");
                    int i = 0;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i]);
                        if (unflattenFromString != null && unflattenFromString.getPackageName().equals(bVar.getPackageName())) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            if (c) {
                bVar.getPackageName();
            }
            return false;
        }
    }

    public final boolean b(MediaSessionManager.b bVar, String str) {
        if (bVar.a() < 0) {
            if (this.a.getPackageManager().checkPermission(str, bVar.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (this.a.checkPermission(str, bVar.a(), bVar.getUid()) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
