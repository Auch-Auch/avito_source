package com.avito.android.advert.item.safedeal.services;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesView;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.remote.model.SafeDeal;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.jakewharton.rxrelay3.Relay;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesViewHolder;", "Lcom/avito/android/advert/item/safedeal/services/AdvertDetailsSafeDealServicesView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/SafeDeal;", "safeDeal", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "viewModel", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "dataRelay", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;", "router", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "showServices", "(Lcom/avito/android/remote/model/SafeDeal;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;Lcom/jakewharton/rxrelay3/Relay;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "u", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "container", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView;", "s", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView;", "servicesView", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealServicesViewHolder extends BaseViewHolder implements AdvertDetailsSafeDealServicesView {
    public MyAdvertSafeDealServicesView s;
    public final ViewGroup t;
    public final DeepLinkFactory u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSafeDealServicesViewHolder(@NotNull ViewGroup viewGroup, @NotNull DeepLinkFactory deepLinkFactory) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        this.t = viewGroup;
        this.u = deepLinkFactory;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdvertDetailsSafeDealServicesView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesView
    public void showServices(@NotNull SafeDeal safeDeal, @NotNull MyAdvertSafeDealServicesViewModel myAdvertSafeDealServicesViewModel, @NotNull Relay<MyAdvertSafeDeal> relay, @NotNull MyAdvertSafeDealServicesView.Router router, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(safeDeal, "safeDeal");
        Intrinsics.checkNotNullParameter(myAdvertSafeDealServicesViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(relay, "dataRelay");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (this.s == null) {
            this.s = new MyAdvertSafeDealServicesView(this.t, myAdvertSafeDealServicesViewModel, this.u, router, lifecycleOwner);
        }
        List<MyAdvertSafeDeal.Service> services = safeDeal.getServices();
        if (services != null) {
            relay.accept(new MyAdvertSafeDeal(services));
        }
    }
}
