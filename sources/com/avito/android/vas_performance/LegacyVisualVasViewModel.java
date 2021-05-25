package com.avito.android.vas_performance;

import androidx.lifecycle.LiveData;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.ui.ButtonState;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J*\u0010\n\u001a\u00020\u00022\u0019\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\u0002\b\b0\u0006H&¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "", "", "onContinueButtonClick", "()V", "onRetryButtonClick", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "Landroidx/lifecycle/LiveData;", "", "Lcom/avito/conveyor_item/Item;", "getDataChanges", "()Landroidx/lifecycle/LiveData;", "dataChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCompletionEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "completionEvents", "Lcom/avito/android/vas_performance/ui/ButtonState;", "getButtonStateChanges", "buttonStateChanges", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface LegacyVisualVasViewModel {
    @NotNull
    LiveData<ButtonState> getButtonStateChanges();

    @NotNull
    SingleLiveEvent<Unit> getCompletionEvents();

    @NotNull
    LiveData<List<Item>> getDataChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onContinueButtonClick();

    void onRetryButtonClick();
}
