package com.avito.android.vas_performance.ui.applied_services;

import androidx.lifecycle.LiveData;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "subscribeToItemClicks", "(Ljava/util/Set;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "getRoutingEvents", "()Landroidx/lifecycle/LiveData;", "routingEvents", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface AppliedServicesViewModel {
    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<StartActivityEvent> getRoutingEvents();

    void subscribeToItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);
}
