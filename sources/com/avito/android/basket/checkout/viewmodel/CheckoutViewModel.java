package com.avito.android.basket.checkout.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemClickListener;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.konveyor.blueprint.ItemPresenter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ*\u0010\u000e\u001a\u00020\u00072\u0019\u0010\r\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b¢\u0006\u0002\b\f0\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010#R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0019R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020.0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#R\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002010\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0019R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010#¨\u00066"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemClickListener;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "()V", "onContinueButtonClick", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "Landroidx/lifecycle/LiveData;", "", "getButtonTextChanges", "()Landroidx/lifecycle/LiveData;", "buttonTextChanges", "getCloseButtonTextChanges", "closeButtonTextChanges", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "getListChanges", "listChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/paid_services/routing/DialogInfo;", "getDialogEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "dialogEvents", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutContent;", "getProgressChanges", "progressChanges", "getMessageEvents", "messageEvents", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "getStartActivityForResultEvents", "startActivityForResultEvents", "Lcom/avito/android/deep_linking/links/DeepLink;", "getRoutingEvents", "routingEvents", "", "getLoadingEvents", "loadingEvents", "getEndFlowEvents", "endFlowEvents", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface CheckoutViewModel extends CheckoutItemClickListener {
    @NotNull
    LiveData<String> getButtonTextChanges();

    @NotNull
    LiveData<String> getCloseButtonTextChanges();

    @NotNull
    SingleLiveEvent<DialogInfo> getDialogEvents();

    @NotNull
    SingleLiveEvent<Unit> getEndFlowEvents();

    @NotNull
    LiveData<ListUpdate> getListChanges();

    @NotNull
    LiveData<Boolean> getLoadingEvents();

    @NotNull
    SingleLiveEvent<String> getMessageEvents();

    @NotNull
    LiveData<LoadingState<CheckoutContent>> getProgressChanges();

    @NotNull
    SingleLiveEvent<DeepLink> getRoutingEvents();

    @NotNull
    LiveData<StartActivityForResultEvent> getStartActivityForResultEvents();

    void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set);

    void onActivityResult(int i, int i2, @Nullable Intent intent);

    void onContinueButtonClick();

    void onRetryButtonClick();

    @NotNull
    Kundle saveState();
}
