package l6.q;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
@RequiresApi(28)
public class v extends u {
    public MediaSessionManager d;

    public v(Context context) {
        super(context);
        this.d = (MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // l6.q.u, l6.q.w, androidx.media.MediaSessionManager.a
    public boolean a(MediaSessionManager.b bVar) {
        if (bVar instanceof a) {
            return this.d.isTrustedForMediaControl(((a) bVar).a);
        }
        return false;
    }

    public static final class a implements MediaSessionManager.b {
        public final MediaSessionManager.RemoteUserInfo a;

        public a(String str, int i, int i2) {
            this.a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        @Override // androidx.media.MediaSessionManager.b
        public int a() {
            return this.a.getPid();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.a.equals(((a) obj).a);
        }

        @Override // androidx.media.MediaSessionManager.b
        public String getPackageName() {
            return this.a.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.b
        public int getUid() {
            return this.a.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.a);
        }

        public a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.a = remoteUserInfo;
        }
    }
}
