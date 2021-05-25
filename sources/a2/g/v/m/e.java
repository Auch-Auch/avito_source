package a2.g.v.m;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareDialog;
public class e implements DialogPresenter.ParameterProvider {
    public final /* synthetic */ AppCall a;
    public final /* synthetic */ ShareContent b;
    public final /* synthetic */ boolean c;

    public e(ShareDialog.d dVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.a = appCall;
        this.b = shareContent;
        this.c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.a.getCallId(), this.b, this.c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.a.getCallId(), this.b, this.c);
    }
}
