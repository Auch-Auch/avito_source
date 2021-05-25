package a2.g.v.l;

import android.os.Bundle;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.internal.LikeDialog;
public class k implements DialogPresenter.ParameterProvider {
    public final /* synthetic */ LikeContent a;

    public k(LikeDialog.c cVar, LikeContent likeContent) {
        this.a = likeContent;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return new Bundle();
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return LikeDialog.a(this.a);
    }
}
