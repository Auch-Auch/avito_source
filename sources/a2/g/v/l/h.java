package a2.g.v.l;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
public class h implements LikeActionController.n {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ LikeActionController b;

    public class a implements GraphRequestBatch.Callback {
        public final /* synthetic */ LikeActionController.l a;

        public a(LikeActionController.l lVar) {
            this.a = lVar;
        }

        @Override // com.facebook.GraphRequestBatch.Callback
        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            LikeActionController likeActionController = h.this.b;
            likeActionController.l = false;
            LikeActionController.l lVar = this.a;
            if (lVar.d != null) {
                likeActionController.o(false);
                Bundle bundle = new Bundle();
                bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_PUBLISH_ERROR);
                LikeActionController.c(likeActionController, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
                return;
            }
            likeActionController.h = Utility.coerceValueIfNullOrEmpty(lVar.e, null);
            LikeActionController likeActionController2 = h.this.b;
            likeActionController2.k = true;
            likeActionController2.g().logEventImplicitly(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, h.this.a);
            h hVar = h.this;
            LikeActionController.a(hVar.b, hVar.a);
        }
    }

    public h(LikeActionController likeActionController, Bundle bundle) {
        this.b = likeActionController;
        this.a = bundle;
    }

    @Override // com.facebook.share.internal.LikeActionController.n
    public void onComplete() {
        if (Utility.isNullOrEmpty(this.b.i)) {
            LikeActionController.c(this.b, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, a2.b.a.a.a.y1(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID));
            return;
        }
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        LikeActionController likeActionController = this.b;
        LikeActionController.l lVar = new LikeActionController.l(likeActionController.i, likeActionController.b);
        graphRequestBatch.add(lVar.a);
        graphRequestBatch.addCallback(new a(lVar));
        graphRequestBatch.executeAsync();
    }
}
