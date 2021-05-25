package com.avito.android.vas_performance;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J*\u0010\n\u001a\u00020\u00022\u0019\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\u0002\b\b0\u0006H&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "", "", "onSkipButtonClick", "()V", "onRetryButtonClick", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getCompletionEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "completionEvents", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "", "getButtonTextChanges", "buttonTextChanges", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "getDataChanges", "dataChanges", "Lcom/avito/android/deep_linking/links/DeepLink;", "getOpenInfoPage", "openInfoPage", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface LegacyPerformanceVasViewModel {
    @NotNull
    LiveData<String> getButtonTextChanges();

    @NotNull
    SingleLiveEvent<Unit> getCompletionEvents();

    @NotNull
    LiveData<ListUpdate> getDataChanges();

    @NotNull
    LiveData<DeepLink> getOpenInfoPage();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onRetryButtonClick();

    void onSkipButtonClick();
}
