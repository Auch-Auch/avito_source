package com.avito.android.advert.item.sellersubscription;

import android.view.View;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView$UnbindListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setUnbindListener", "(Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView$UnbindListener;)V", "onUnbind", "()V", "Lio/reactivex/rxjava3/core/Observable;", "subscribeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;", "state", "setSubscribeState", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionState;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "subscribeButton", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", "u", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", "resourceProvider", "t", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView$UnbindListener;", "unbindListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSellerSubscriptionViewImpl extends BaseViewHolder implements AdvertDetailsSellerSubscriptionView {
    public final Button s;
    public AdvertDetailsSellerSubscriptionView.UnbindListener t;
    public final SellerSubscriptionResourceProvider u;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SellerSubscriptionState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSellerSubscriptionViewImpl(@NotNull View view, @NotNull SellerSubscriptionResourceProvider sellerSubscriptionResourceProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sellerSubscriptionResourceProvider, "resourceProvider");
        this.u = sellerSubscriptionResourceProvider;
        View findViewById = view.findViewById(R.id.subscribe_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.s = (Button) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdvertDetailsSellerSubscriptionView.UnbindListener unbindListener = this.t;
        if (unbindListener != null) {
            unbindListener.onUnbind();
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionView
    public void setSubscribeState(@NotNull SellerSubscriptionState sellerSubscriptionState) {
        Intrinsics.checkNotNullParameter(sellerSubscriptionState, "state");
        int ordinal = sellerSubscriptionState.ordinal();
        if (ordinal == 0) {
            Button button = this.s;
            button.setLoading(false);
            button.setClickable(true);
            this.s.setText(this.u.settingsText());
        } else if (ordinal == 1) {
            Button button2 = this.s;
            button2.setLoading(false);
            button2.setClickable(true);
            this.s.setText(this.u.subscribeButtonText());
        } else if (ordinal == 2) {
            Button button3 = this.s;
            button3.setLoading(true);
            button3.setClickable(false);
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionView
    public void setUnbindListener(@Nullable AdvertDetailsSellerSubscriptionView.UnbindListener unbindListener) {
        this.t = unbindListener;
    }

    @Override // com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionView
    @NotNull
    public Observable<Unit> subscribeClicks() {
        return InteropKt.toV3(RxView.clicks(this.s));
    }
}
