package com.avito.android.delivery.order_cancellation;

import androidx.lifecycle.LiveData;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItem;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.util.LoadingState;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R \u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0011¨\u0006#"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "", "", "force", "", "requestReasons", "(Z)V", "", "getCommentMaxLength", "()I", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/lifecycle/LiveData;", "", "getSnackbarChanges", "()Landroidx/lifecycle/LiveData;", "snackbarChanges", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItem;", "getReasonClickConsumer", "()Lio/reactivex/functions/Consumer;", "reasonClickConsumer", "", "Lcom/avito/android/remote/model/ReasonRds;", "getDataChanges", "dataChanges", "getReasonDetailsChanges", "reasonDetailsChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "getCloseScreenChanges", "closeScreenChanges", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface RdsOrderCancellationReasonsViewModel {
    @NotNull
    LiveData<Integer> getCloseScreenChanges();

    int getCommentMaxLength();

    @NotNull
    LiveData<List<ReasonRds>> getDataChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    Consumer<ReasonItem> getReasonClickConsumer();

    @NotNull
    LiveData<ReasonRds> getReasonDetailsChanges();

    @NotNull
    LiveData<String> getSnackbarChanges();

    void requestReasons(boolean z);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
