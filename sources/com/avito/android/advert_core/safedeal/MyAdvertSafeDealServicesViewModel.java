package com.avito.android.advert_core.safedeal;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR.\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\r0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR(\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "", "", "serviceID", "", "isEnabled", "", "onSwitcherToggled", "(Ljava/lang/String;Z)V", "Landroidx/lifecycle/LiveData;", "getSnackbarChanges", "()Landroidx/lifecycle/LiveData;", "snackbarChanges", "Lkotlin/Pair;", "getSwitcherIsCheckedChanges", "switcherIsCheckedChanges", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "", "getDataChanges", "dataChanges", "getSwitcherIsEnabledChanges", "switcherIsEnabledChanges", "getSwitcherIsLoadingChanges", "switcherIsLoadingChanges", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertSafeDealServicesViewModel {
    @NotNull
    LiveData<Pair<MyAdvertSafeDeal, Set<String>>> getDataChanges();

    @NotNull
    LiveData<String> getSnackbarChanges();

    @NotNull
    LiveData<Pair<String, Boolean>> getSwitcherIsCheckedChanges();

    @NotNull
    LiveData<Pair<String, Boolean>> getSwitcherIsEnabledChanges();

    @NotNull
    LiveData<Pair<String, Boolean>> getSwitcherIsLoadingChanges();

    void onSwitcherToggled(@NotNull String str, boolean z);
}
