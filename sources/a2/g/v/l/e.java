package a2.g.v.l;

import com.facebook.FacebookException;
import com.facebook.share.internal.LikeActionController;
public final class e implements Runnable {
    public final /* synthetic */ LikeActionController.CreationCallback a;
    public final /* synthetic */ LikeActionController b;
    public final /* synthetic */ FacebookException c;

    public e(LikeActionController.CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
        this.a = creationCallback;
        this.b = likeActionController;
        this.c = facebookException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onComplete(this.b, this.c);
    }
}
