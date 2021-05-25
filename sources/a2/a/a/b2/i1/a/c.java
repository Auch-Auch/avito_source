package a2.a.a.b2.i1.a;

import com.avito.android.profile.tfa.settings.TfaSettingsData;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsView;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<TfaSettingsData> {
    public final /* synthetic */ TfaSettingsPresenterImpl a;

    public c(TfaSettingsPresenterImpl tfaSettingsPresenterImpl) {
        this.a = tfaSettingsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TfaSettingsData tfaSettingsData) {
        TfaSettingsData tfaSettingsData2 = tfaSettingsData;
        this.a.c = tfaSettingsData2.isEnabled();
        this.a.d = tfaSettingsData2.getWarning();
        TfaSettingsView tfaSettingsView = this.a.a;
        if (tfaSettingsView != null) {
            tfaSettingsView.showToggleChecked(this.a.c);
        }
        TfaSettingsView tfaSettingsView2 = this.a.a;
        if (tfaSettingsView2 != null) {
            tfaSettingsView2.bindWarning(this.a.d);
        }
    }
}
