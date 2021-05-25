package a2.g.m.b;

import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.fresco.ui.common.LoggingListener;
public class a implements FadeDrawable.OnFadeFinishedListener {
    public final /* synthetic */ AbstractDraweeController a;

    public a(AbstractDraweeController abstractDraweeController) {
        this.a = abstractDraweeController;
    }

    @Override // com.facebook.drawee.drawable.FadeDrawable.OnFadeFinishedListener
    public void onFadeFinished() {
        AbstractDraweeController abstractDraweeController = this.a;
        LoggingListener loggingListener = abstractDraweeController.mLoggingListener;
        if (loggingListener != null) {
            loggingListener.onFadeFinished(abstractDraweeController.i);
        }
    }
}
