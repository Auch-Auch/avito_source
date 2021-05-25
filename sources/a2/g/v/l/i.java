package a2.g.v.l;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.LikeActionController;
public class i implements GraphRequestBatch.Callback {
    public final /* synthetic */ LikeActionController.m a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ LikeActionController c;

    public i(LikeActionController likeActionController, LikeActionController.m mVar, Bundle bundle) {
        this.c = likeActionController;
        this.a = mVar;
        this.b = bundle;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        LikeActionController likeActionController = this.c;
        likeActionController.l = false;
        if (this.a.d != null) {
            likeActionController.o(true);
            Bundle bundle = new Bundle();
            bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_PUBLISH_ERROR);
            LikeActionController.c(likeActionController, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
            return;
        }
        likeActionController.h = null;
        likeActionController.k = false;
        likeActionController.g().logEventImplicitly(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, this.b);
        LikeActionController.a(this.c, this.b);
    }
}
