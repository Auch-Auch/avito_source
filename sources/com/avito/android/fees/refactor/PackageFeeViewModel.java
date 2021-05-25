package com.avito.android.fees.refactor;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.FeesLoadingState;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "Lcom/avito/android/fees/refactor/PackageClickListener;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/remote/FeesLoadingState;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "", "Lcom/avito/konveyor/blueprint/Item;", "getDataChanges", "dataChanges", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface PackageFeeViewModel extends PackageClickListener {
    @NotNull
    LiveData<List<Item>> getDataChanges();

    @NotNull
    LiveData<FeesLoadingState> getProgressChanges();
}
