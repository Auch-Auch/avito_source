package com.avito.android.vas_performance.ui;

import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J*\u0010\n\u001a\u00020\u00022\u0019\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\u0002\b\b0\u0006H&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR \u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "", "", "onContinueButtonClick", "()V", "onRetryButtonClick", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "getDataChanges", "()Landroidx/lifecycle/LiveData;", "dataChanges", "Lcom/avito/android/deep_linking/links/DeepLink;", "getContinueButtonNavigate", "continueButtonNavigate", "Lcom/avito/android/vas_performance/ui/ButtonState;", "getButtonStateChanges", "buttonStateChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface VisualVasViewModel {
    @NotNull
    LiveData<ButtonState> getButtonStateChanges();

    @NotNull
    LiveData<DeepLink> getContinueButtonNavigate();

    @NotNull
    LiveData<ListUpdate> getDataChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onContinueButtonClick();

    void onRetryButtonClick();
}
