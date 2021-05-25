package com.avito.android.advert.item.safedeal.services;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesObservable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.UrlParams;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u000e\b\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001f\u0010 J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesPresenter;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesView;", "view", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesView;Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesItem;I)V", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "viewModel", AuthSource.SEND_ABUSE, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "c", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "safeDealPresenter", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "d", "Lcom/jakewharton/rxrelay3/Relay;", "dataRelay", "<init>", "(Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;Lcom/jakewharton/rxrelay3/Relay;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealServicesPresenterImpl implements AdvertDetailsSafeDealServicesPresenter {
    public LifecycleOwner a;
    public final MyAdvertSafeDealServicesViewModel b;
    public final AdvertSafeDealPresenter c;
    public final Relay<MyAdvertSafeDeal> d;

    @Inject
    public AdvertDetailsSafeDealServicesPresenterImpl(@NotNull MyAdvertSafeDealServicesViewModel myAdvertSafeDealServicesViewModel, @NotNull AdvertSafeDealPresenter advertSafeDealPresenter, @MyAdvertSafeDealServicesObservable @NotNull Relay<MyAdvertSafeDeal> relay) {
        Intrinsics.checkNotNullParameter(myAdvertSafeDealServicesViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(advertSafeDealPresenter, "safeDealPresenter");
        Intrinsics.checkNotNullParameter(relay, "dataRelay");
        this.b = myAdvertSafeDealServicesViewModel;
        this.c = advertSafeDealPresenter;
        this.d = relay;
    }

    @Override // com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenter
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        this.a = lifecycleOwner;
    }

    public void bindView(@NotNull AdvertDetailsSafeDealServicesView advertDetailsSafeDealServicesView, @NotNull AdvertDetailsSafeDealServicesItem advertDetailsSafeDealServicesItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealServicesView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealServicesItem, "item");
        LifecycleOwner lifecycleOwner = this.a;
        if (lifecycleOwner != null) {
            advertDetailsSafeDealServicesView.showServices(advertDetailsSafeDealServicesItem.getSafeDeal(), this.b, this.d, this.c, lifecycleOwner);
        }
    }
}
