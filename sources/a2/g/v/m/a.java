package a2.g.v.m;

import android.os.Bundle;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.widget.AppInviteDialog;
public class a implements DialogPresenter.ParameterProvider {
    public final /* synthetic */ AppInviteContent a;

    public a(AppInviteDialog.c cVar, AppInviteContent appInviteContent) {
        this.a = appInviteContent;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return new Bundle();
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return AppInviteDialog.a(this.a);
    }
}
