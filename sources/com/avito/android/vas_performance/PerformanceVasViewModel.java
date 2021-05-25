package com.avito.android.vas_performance;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR \u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/avito/android/vas_performance/PerformanceVasViewModel;", "", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onSkipButtonClick", "()V", "onRetryButtonClick", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplinkNavigate", "()Landroidx/lifecycle/LiveData;", "deeplinkNavigate", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "getDataChanges", "dataChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "", "getButtonTextChanges", "buttonTextChanges", "getOpenInfoPage", "openInfoPage", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface PerformanceVasViewModel {
    @NotNull
    LiveData<String> getButtonTextChanges();

    @NotNull
    LiveData<ListUpdate> getDataChanges();

    @NotNull
    LiveData<DeepLink> getDeeplinkNavigate();

    @NotNull
    LiveData<DeepLink> getOpenInfoPage();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set);

    void onRetryButtonClick();

    void onSkipButtonClick();
}
