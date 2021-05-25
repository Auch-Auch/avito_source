package a2.a.a.b2.i1.a;

import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsView;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ TfaSettingsPresenterImpl a;

    public b(TfaSettingsPresenterImpl tfaSettingsPresenterImpl) {
        this.a = tfaSettingsPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        TfaSettingsView tfaSettingsView = this.a.a;
        if (tfaSettingsView != null) {
            tfaSettingsView.setToggleEnabled(true);
        }
    }
}
