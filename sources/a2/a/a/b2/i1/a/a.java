package a2.a.a.b2.i1.a;

import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ TfaSettingsPresenterImpl a;

    public a(TfaSettingsPresenterImpl tfaSettingsPresenterImpl) {
        this.a = tfaSettingsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        TfaSettingsView tfaSettingsView = this.a.a;
        if (tfaSettingsView != null) {
            tfaSettingsView.setToggleEnabled(false);
        }
    }
}
