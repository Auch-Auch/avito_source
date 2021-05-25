package com.avito.android.tariff.info.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.Action;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "", "", "onRetryButtonClick", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/Action;", "getButtonActionChanges", "()Landroidx/lifecycle/LiveData;", "buttonActionChanges", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/conveyor_item/Item;", "getProgressChanges", "progressChanges", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffInfoViewModel {
    @NotNull
    LiveData<Action> getButtonActionChanges();

    @NotNull
    LiveData<LoadingState<List<? extends Item>>> getProgressChanges();

    void onRetryButtonClick();
}
