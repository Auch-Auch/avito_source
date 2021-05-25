package com.avito.android.basket_legacy.viewmodels.checkout;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.avito.android.basket_legacy.utils.CheckoutNavigationIcon;
import com.avito.android.basket_legacy.utils.CloseEvent;
import com.avito.android.basket_legacy.utils.CrossClickListener;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.util.architecture_components.MessageEvent;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0012R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0012¨\u0006&"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "Lcom/avito/android/basket_legacy/utils/CrossClickListener;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Lio/reactivex/Observable;", "clickObservable", "observeButtonClicks", "(Lio/reactivex/Observable;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/basket_legacy/utils/CloseEvent;", "getCloseEvents", "()Landroidx/lifecycle/LiveData;", "closeEvents", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "getStartActivityForResultEvents", "startActivityForResultEvents", "Lcom/avito/android/util/architecture_components/MessageEvent;", "getMessageEvents", "messageEvents", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "getListUpdates", "listUpdates", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "getStartActivityEvents", "startActivityEvents", "", "getButtonTextChanges", "buttonTextChanges", "Lcom/avito/android/basket_legacy/utils/CheckoutNavigationIcon;", "getNavigationChanges", "navigationChanges", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface LegacyCheckoutViewModel extends CrossClickListener, OnDeepLinkClickListener {
    @NotNull
    LiveData<String> getButtonTextChanges();

    @NotNull
    LiveData<CloseEvent> getCloseEvents();

    @NotNull
    LiveData<ListUpdate> getListUpdates();

    @NotNull
    LiveData<MessageEvent> getMessageEvents();

    @NotNull
    LiveData<CheckoutNavigationIcon> getNavigationChanges();

    @NotNull
    LiveData<StartActivityEvent> getStartActivityEvents();

    @NotNull
    LiveData<StartActivityForResultEvent> getStartActivityForResultEvents();

    void observeButtonClicks(@NotNull Observable<Unit> observable);

    void onActivityResult(int i, int i2, @Nullable Intent intent);
}
