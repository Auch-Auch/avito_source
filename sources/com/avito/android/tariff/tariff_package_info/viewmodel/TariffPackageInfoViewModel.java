package com.avito.android.tariff.tariff_package_info.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR \u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "", "", "onRetryButtonClick", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitleChanges", "()Landroidx/lifecycle/LiveData;", "titleChanges", "", "Lcom/avito/conveyor_item/Item;", "getListChanges", "listChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffPackageInfoViewModel {
    @NotNull
    LiveData<List<Item>> getListChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<AttributedText> getTitleChanges();

    void onRetryButtonClick();
}
