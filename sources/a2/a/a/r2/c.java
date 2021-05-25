package a2.a.a.r2;

import com.avito.android.remote.model.Location;
import com.avito.android.settings.SettingsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Location> {
    public final /* synthetic */ SettingsPresenterImpl a;

    public c(SettingsPresenterImpl settingsPresenterImpl) {
        this.a = settingsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Location location) {
        this.a.f = location;
        this.a.a();
    }
}
