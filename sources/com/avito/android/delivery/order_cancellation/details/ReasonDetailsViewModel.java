package com.avito.android.delivery.order_cancellation.details;

import androidx.lifecycle.LiveData;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "getSelectedRadioButtonId", "()Ljava/lang/Integer;", "Landroidx/lifecycle/LiveData;", "", "getSnackbarChanges", "()Landroidx/lifecycle/LiveData;", "snackbarChanges", "", "getButtonStateChanges", "buttonStateChanges", "Lio/reactivex/functions/Consumer;", "", "getCommentChangesConsumer", "()Lio/reactivex/functions/Consumer;", "commentChangesConsumer", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "getRadioGroupChangesConsumer", "radioGroupChangesConsumer", "getCancelOrderButtonClickConsumer", "cancelOrderButtonClickConsumer", "getCloseScreenChanges", "closeScreenChanges", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface ReasonDetailsViewModel {
    @NotNull
    LiveData<Boolean> getButtonStateChanges();

    @NotNull
    Consumer<Unit> getCancelOrderButtonClickConsumer();

    @NotNull
    LiveData<Integer> getCloseScreenChanges();

    @NotNull
    Consumer<CharSequence> getCommentChangesConsumer();

    @NotNull
    Consumer<ParameterElement.Select> getRadioGroupChangesConsumer();

    @Nullable
    Integer getSelectedRadioButtonId();

    @NotNull
    LiveData<String> getSnackbarChanges();

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
