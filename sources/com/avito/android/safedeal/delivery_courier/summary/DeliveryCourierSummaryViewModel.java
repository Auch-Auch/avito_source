package com.avito.android.safedeal.delivery_courier.summary;

import androidx.lifecycle.LiveData;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.DialogState;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0016R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0016\u0010-\u001a\u00020*8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020'0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010 R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020*0\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0016R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010 R\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002040\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010 R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020$0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010 R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010 R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010 ¨\u0006="}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "location", "onLocationSelected", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "", "success", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onCompletePaymentResult", "(ZLcom/avito/android/deep_linking/links/DeepLink;)V", "getSelectedAddress", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement;", "getChangeConsumer", "()Lio/reactivex/functions/Consumer;", "changeConsumer", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "getCourierServiceChangeConsumer", "courierServiceChangeConsumer", "getSubmitButtonClickConsumer", "submitButtonClickConsumer", "Landroidx/lifecycle/LiveData;", "Ljava/lang/Runnable;", "getErrorChanges", "()Landroidx/lifecycle/LiveData;", "errorChanges", "getDeepLinkChanges", "deepLinkChanges", "Lcom/avito/android/category_parameters/ParameterElement$SelectDeepLink;", "getSelectDeepLinkClickConsumer", "selectDeepLinkClickConsumer", "", "getSnackBarChanges", "snackBarChanges", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", "getDialogState", "()Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", "dialogState", "getPayUrlChanges", "payUrlChanges", "getDialogStateConsumer", "dialogStateConsumer", "getProgressChanges", "progressChanges", "", "getErrorPositionChanges", "errorPositionChanges", "getSelectDeepLinkChanges", "selectDeepLinkChanges", "getShowContentChanges", "showContentChanges", "getCloseScreenChanges", "closeScreenChanges", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierSummaryViewModel extends OnDeepLinkClickListener {
    @NotNull
    Consumer<ParameterElement> getChangeConsumer();

    @NotNull
    LiveData<Boolean> getCloseScreenChanges();

    @NotNull
    Consumer<BaseCourierServiceItem> getCourierServiceChangeConsumer();

    @NotNull
    LiveData<DeepLink> getDeepLinkChanges();

    @NotNull
    DialogState getDialogState();

    @NotNull
    Consumer<DialogState> getDialogStateConsumer();

    @NotNull
    LiveData<Runnable> getErrorChanges();

    @NotNull
    LiveData<Integer> getErrorPositionChanges();

    @NotNull
    LiveData<String> getPayUrlChanges();

    @NotNull
    LiveData<Unit> getProgressChanges();

    @NotNull
    LiveData<ParameterElement.SelectDeepLink> getSelectDeepLinkChanges();

    @NotNull
    Consumer<ParameterElement.SelectDeepLink> getSelectDeepLinkClickConsumer();

    @Nullable
    AddressParameter.Value getSelectedAddress();

    @NotNull
    LiveData<Unit> getShowContentChanges();

    @NotNull
    LiveData<String> getSnackBarChanges();

    @NotNull
    Consumer<Unit> getSubmitButtonClickConsumer();

    void onCompletePaymentResult(boolean z, @Nullable DeepLink deepLink);

    void onLocationSelected(@NotNull AddressParameter.Value value);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
