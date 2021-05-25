package l6.q;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.media.MediaSessionManager;
@RequiresApi(21)
public class u extends w {
    public u(Context context) {
        super(context);
        this.a = context;
    }

    @Override // l6.q.w, androidx.media.MediaSessionManager.a
    public boolean a(@NonNull MediaSessionManager.b bVar) {
        if ((this.a.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", bVar.a(), bVar.getUid()) == 0) || super.a(bVar)) {
            return true;
        }
        return false;
    }
}
