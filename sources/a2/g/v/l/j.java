package a2.g.v.l;

import com.facebook.GraphRequestBatch;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.share.internal.LikeActionController;
public class j implements LikeActionController.n {
    public final /* synthetic */ LikeActionController a;

    public class a implements GraphRequestBatch.Callback {
        public final /* synthetic */ LikeActionController.j a;
        public final /* synthetic */ LikeActionController.e b;

        public a(LikeActionController.j jVar, LikeActionController.e eVar) {
            this.a = jVar;
            this.b = eVar;
        }

        @Override // com.facebook.GraphRequestBatch.Callback
        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            LikeActionController.j jVar = this.a;
            if (((LikeActionController.c) jVar).d == null && this.b.d == null) {
                LikeActionController likeActionController = j.this.a;
                boolean b2 = jVar.b();
                LikeActionController.e eVar = this.b;
                String str = eVar.e;
                String str2 = eVar.f;
                String str3 = eVar.g;
                String str4 = eVar.h;
                String a3 = this.a.a();
                String str5 = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
                likeActionController.p(b2, str, str2, str3, str4, a3);
                return;
            }
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str6 = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Unable to refresh like state for id: '%s'", j.this.a.a);
        }
    }

    public j(LikeActionController likeActionController) {
        this.a = likeActionController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.facebook.share.internal.LikeActionController$g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.facebook.share.internal.LikeActionController.n
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onComplete() {
        /*
            r5 = this;
            com.facebook.share.internal.LikeActionController r0 = r5.a
            com.facebook.share.widget.LikeView$ObjectType r0 = r0.b
            int r0 = r0.ordinal()
            r1 = 2
            if (r0 == r1) goto L_0x0017
            com.facebook.share.internal.LikeActionController$g r0 = new com.facebook.share.internal.LikeActionController$g
            com.facebook.share.internal.LikeActionController r1 = r5.a
            java.lang.String r2 = r1.i
            com.facebook.share.widget.LikeView$ObjectType r3 = r1.b
            r0.<init>(r2, r3)
            goto L_0x0020
        L_0x0017:
            com.facebook.share.internal.LikeActionController$i r0 = new com.facebook.share.internal.LikeActionController$i
            com.facebook.share.internal.LikeActionController r1 = r5.a
            java.lang.String r2 = r1.i
            r0.<init>(r2)
        L_0x0020:
            com.facebook.share.internal.LikeActionController$e r1 = new com.facebook.share.internal.LikeActionController$e
            com.facebook.share.internal.LikeActionController r2 = r5.a
            java.lang.String r3 = r2.i
            com.facebook.share.widget.LikeView$ObjectType r4 = r2.b
            r1.<init>(r3, r4)
            com.facebook.GraphRequestBatch r2 = new com.facebook.GraphRequestBatch
            r2.<init>()
            com.facebook.GraphRequest r3 = r0.a
            r2.add(r3)
            com.facebook.GraphRequest r3 = r1.a
            r2.add(r3)
            a2.g.v.l.j$a r3 = new a2.g.v.l.j$a
            r3.<init>(r0, r1)
            r2.addCallback(r3)
            r2.executeAsync()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.g.v.l.j.onComplete():void");
    }
}
