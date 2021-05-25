package a2.g.v.l;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.LikeActionController;
import java.util.Objects;
public final class c implements Runnable {
    public final /* synthetic */ LikeActionController a;

    public c(LikeActionController likeActionController) {
        this.a = likeActionController;
    }

    @Override // java.lang.Runnable
    public void run() {
        LikeActionController likeActionController = this.a;
        String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
        Objects.requireNonNull(likeActionController);
        if (!AccessToken.isCurrentAccessTokenActive()) {
            l lVar = new l(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), likeActionController.a);
            if (lVar.start()) {
                lVar.setCompletedListener(new b(likeActionController));
                return;
            }
            return;
        }
        likeActionController.f(new j(likeActionController));
    }
}
