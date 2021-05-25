package com.avito.android.hints.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.bottom_sheet.BottomSheet;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tR \u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/hints/viewmodel/HintViewModel;", "", "", "onRetryClicked", "()V", "Lio/reactivex/Observable;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "visibilityObservable", "observeVisibilityChanges", "(Lio/reactivex/Observable;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "getCloseEvents", "closeEvents", "", "Lcom/avito/conveyor_item/Item;", "getDataChanges", "dataChanges", "hints_release"}, k = 1, mv = {1, 4, 2})
public interface HintViewModel {
    @NotNull
    LiveData<Unit> getCloseEvents();

    @NotNull
    LiveData<List<Item>> getDataChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    void observeVisibilityChanges(@NotNull Observable<BottomSheet.Visibility> observable);

    void onRetryClicked();
}
