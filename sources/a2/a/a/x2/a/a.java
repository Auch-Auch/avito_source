package a2.a.a.x2.a;

import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ SoaStatProfileSettingsViewModel a;

    public a(SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel) {
        this.a = soaStatProfileSettingsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.loadData();
    }
}
