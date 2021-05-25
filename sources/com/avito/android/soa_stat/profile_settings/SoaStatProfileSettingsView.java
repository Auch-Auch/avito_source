package com.avito.android.soa_stat.profile_settings;

import androidx.appcompat.widget.Toolbar;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsView;", "", "Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "data", "", "showContent", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;)V", "showLoading", "()V", "showError", "", "textResId", "showSnackBar", "(I)V", "Lio/reactivex/Observable;", "", "getSwitchObserver", "()Lio/reactivex/Observable;", "switchObserver", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "getOnRefreshObserver", "onRefreshObserver", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public interface SoaStatProfileSettingsView {
    @NotNull
    Observable<Unit> getOnRefreshObserver();

    @NotNull
    Observable<Boolean> getSwitchObserver();

    @NotNull
    Toolbar getToolbar();

    void showContent(@NotNull SoaStatSettingsPageData soaStatSettingsPageData);

    void showError();

    void showLoading();

    void showSnackBar(int i);
}
