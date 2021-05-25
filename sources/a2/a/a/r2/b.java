package a2.a.a.r2;

import com.avito.android.settings.SettingsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ SettingsPresenterImpl a;

    public b(SettingsPresenterImpl settingsPresenterImpl) {
        this.a = settingsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        SettingsPresenterImpl.access$onClearSearchHistoryError(this.a, null);
    }
}
