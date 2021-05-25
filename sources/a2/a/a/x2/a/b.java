package a2.a.a.x2.a;

import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Boolean> {
    public final /* synthetic */ SoaStatProfileSettingsViewModel a;

    public b(SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel) {
        this.a = soaStatProfileSettingsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel = this.a;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        soaStatProfileSettingsViewModel.toggleSettingTo(bool2.booleanValue());
    }
}
