package a2.g.v.l;

import android.content.Context;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.LikeActionController;
public final class f extends AccessTokenTracker {
    @Override // com.facebook.AccessTokenTracker
    public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (accessToken2 == null) {
            LikeActionController.v = (LikeActionController.v + 1) % 1000;
            applicationContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.v).apply();
            LikeActionController.p.clear();
            LikeActionController.o.clearCache();
        }
        LikeActionController.c(null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET, null);
    }
}
