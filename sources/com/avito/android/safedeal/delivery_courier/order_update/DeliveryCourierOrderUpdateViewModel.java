package com.avito.android.safedeal.delivery_courier.order_update;

import androidx.lifecycle.LiveData;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.util.LoadingState;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0010R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001dR \u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001dR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0019R\u001e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001dR\u001e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001dR\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001dR\u001e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001dR\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020/0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u001d¨\u00066"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "onLocationSelected", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "timeInterval", "onTimeIntervalSelected", "(Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)V", "loadData", "()V", "getSelectedAddress", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "getSelectedTimeInterval", "()Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "submitData", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$SelectDeepLink;", "getSelectDeepLinkClickConsumer", "()Lio/reactivex/functions/Consumer;", "selectDeepLinkClickConsumer", "Landroidx/lifecycle/LiveData;", "getSelectDeepLinkChanges", "()Landroidx/lifecycle/LiveData;", "selectDeepLinkChanges", "", "getCloseScreenChanges", "closeScreenChanges", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "", "getSnackbarChanges", "snackbarChanges", "Lcom/avito/android/category_parameters/ParameterElement;", "getTextChangesConsumer", "textChangesConsumer", "getSubmitButtonTextChanges", "submitButtonTextChanges", "getCancelButtonTextChanges", "cancelButtonTextChanges", "", "getSubmitButtonEnabledChanges", "submitButtonEnabledChanges", "getToolbarTitleChanges", "toolbarTitleChanges", "getSubmitButtonSpinnerChanges", "submitButtonSpinnerChanges", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierOrderUpdateViewModel {
    @NotNull
    LiveData<String> getCancelButtonTextChanges();

    @NotNull
    LiveData<Integer> getCloseScreenChanges();

    @NotNull
    LiveData<LoadingState<?>> getProgressChanges();

    @NotNull
    LiveData<ParameterElement.SelectDeepLink> getSelectDeepLinkChanges();

    @NotNull
    Consumer<ParameterElement.SelectDeepLink> getSelectDeepLinkClickConsumer();

    @Nullable
    AddressParameter.Value getSelectedAddress();

    @Nullable
    TimeInterval getSelectedTimeInterval();

    @NotNull
    LiveData<String> getSnackbarChanges();

    @NotNull
    LiveData<Boolean> getSubmitButtonEnabledChanges();

    @NotNull
    LiveData<Boolean> getSubmitButtonSpinnerChanges();

    @NotNull
    LiveData<String> getSubmitButtonTextChanges();

    @NotNull
    Consumer<ParameterElement> getTextChangesConsumer();

    @NotNull
    LiveData<String> getToolbarTitleChanges();

    void loadData();

    void onLocationSelected(@NotNull AddressParameter.Value value);

    void onTimeIntervalSelected(@NotNull TimeInterval timeInterval);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);

    void submitData();
}
