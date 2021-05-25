package com.avito.android.tariff.change.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.Action;
import com.avito.android.tariff.change.page.TariffTab;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR \u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "", "", "onRetryButtonClick", "()V", "", VKApiConst.POSITION, "onPageSelected", "(I)V", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/Action;", "getButtonChanges", "()Landroidx/lifecycle/LiveData;", "buttonChanges", "", "Lcom/avito/android/tariff/change/page/TariffTab;", "getTabsListChanges", "tabsListChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffChangeViewModel {
    @NotNull
    LiveData<Action> getButtonChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<List<TariffTab>> getTabsListChanges();

    void onPageSelected(int i);

    void onRetryButtonClick();

    @NotNull
    Kundle saveState();
}
