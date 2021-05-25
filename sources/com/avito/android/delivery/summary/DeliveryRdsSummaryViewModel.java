package com.avito.android.delivery.summary;

import androidx.lifecycle.LiveData;
import com.avito.android.SummaryState;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.delivery.analytics.summary.ChangeType;
import com.avito.android.delivery.summary.konveyor.button.ButtonState;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010#R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010#R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010#R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u001e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010#R\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002040\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001eR\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010#R\u0016\u0010;\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010#R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001eR(\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070@0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010#R\u001e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010#R\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020E0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010#R\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u001eR\u001e\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010#R\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u001eR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010#R\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020P0\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u001eR\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010#R\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00160 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010#¨\u0006W"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "success", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onCompletePaymentResult", "(ZLcom/avito/android/deep_linking/links/DeepLink;)V", "", FirebaseAnalytics.Param.QUANTITY, "Lcom/avito/android/delivery/analytics/summary/ChangeType;", "changeType", "onStepperClicked", "(ILcom/avito/android/delivery/analytics/summary/ChangeType;)V", "Lcom/avito/android/SummaryState;", "checkoutSummary", "()Lcom/avito/android/SummaryState;", "", "markerId", "fiasGuid", "serviceId", "updatePoint", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lio/reactivex/rxjava3/functions/Consumer;", "getSubmitButtonClickConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "submitButtonClickConsumer", "Landroidx/lifecycle/LiveData;", "Ljava/lang/Runnable;", "getErrorChanges", "()Landroidx/lifecycle/LiveData;", "errorChanges", "getEditPointChanges", "editPointChanges", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "getHeaderChanges", "headerChanges", "getDeepLinkChanges", "deepLinkChanges", "", "getDisabledImageAlphaChanges", "disabledImageAlphaChanges", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonState;", "getSubmitButtonStateConsumer", "submitButtonStateConsumer", "getShowContentChanges", "showContentChanges", "Lcom/avito/android/delivery/summary/ChangeAction;", "getEditActionConsumer", "editActionConsumer", "getPricePerPieceVisible", "pricePerPieceVisible", "getHeaderStepperVisible", "()Z", "headerStepperVisible", "getItemMaxQuantityChanges", "itemMaxQuantityChanges", "getEditButtonClickConsumer", "editButtonClickConsumer", "Lkotlin/Pair;", "getSnackBarErrorChanges", "snackBarErrorChanges", "getProgressChanges", "progressChanges", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "getEditContactsChanges", "editContactsChanges", "getItemQuantityConsumer", "itemQuantityConsumer", "getStepperTooltipMessages", "stepperTooltipMessages", "getImageLoadedSuccessfullyConsumer", "imageLoadedSuccessfullyConsumer", "getCloseScreenChanges", "closeScreenChanges", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "getChangeConsumer", "changeConsumer", "getDisableAllViews", "disableAllViews", "getPayUrlChanges", "payUrlChanges", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsSummaryViewModel extends OnDeepLinkClickListener {
    @Nullable
    SummaryState checkoutSummary();

    @NotNull
    Consumer<ParameterElement.Input> getChangeConsumer();

    @NotNull
    LiveData<Boolean> getCloseScreenChanges();

    @NotNull
    LiveData<DeepLink> getDeepLinkChanges();

    @NotNull
    LiveData<Boolean> getDisableAllViews();

    @NotNull
    LiveData<Float> getDisabledImageAlphaChanges();

    @NotNull
    Consumer<ChangeAction> getEditActionConsumer();

    @NotNull
    Consumer<String> getEditButtonClickConsumer();

    @NotNull
    LiveData<DeliverySummaryRds.ContactsGroup> getEditContactsChanges();

    @NotNull
    LiveData<Unit> getEditPointChanges();

    @NotNull
    LiveData<Runnable> getErrorChanges();

    @NotNull
    LiveData<DeliverySummaryRds.Header> getHeaderChanges();

    boolean getHeaderStepperVisible();

    @NotNull
    Consumer<Boolean> getImageLoadedSuccessfullyConsumer();

    @NotNull
    LiveData<Integer> getItemMaxQuantityChanges();

    @NotNull
    Consumer<Integer> getItemQuantityConsumer();

    @NotNull
    LiveData<String> getPayUrlChanges();

    @NotNull
    LiveData<Boolean> getPricePerPieceVisible();

    @NotNull
    LiveData<Unit> getProgressChanges();

    @NotNull
    LiveData<Unit> getShowContentChanges();

    @NotNull
    LiveData<Pair<String, Boolean>> getSnackBarErrorChanges();

    @NotNull
    LiveData<String> getStepperTooltipMessages();

    @NotNull
    Consumer<Unit> getSubmitButtonClickConsumer();

    @NotNull
    Consumer<ButtonState> getSubmitButtonStateConsumer();

    void onCompletePaymentResult(boolean z, @Nullable DeepLink deepLink);

    void onStepperClicked(int i, @NotNull ChangeType changeType);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);

    void updatePoint(@Nullable String str, @Nullable String str2, @Nullable String str3);
}
