package a2.g.v.l;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.internal.Utility;
import com.facebook.share.internal.VideoUploader;
public final class m extends AccessTokenTracker {
    @Override // com.facebook.AccessTokenTracker
    public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        if (accessToken != null) {
            if (accessToken2 == null || !Utility.areObjectsEqual(accessToken2.getUserId(), accessToken.getUserId())) {
                boolean z = VideoUploader.a;
                synchronized (VideoUploader.class) {
                    for (VideoUploader.d dVar : VideoUploader.d) {
                        dVar.n = true;
                    }
                }
            }
        }
    }
}
