package com.avito.android.basket.checkout.item.prolongation;

import com.avito.android.basket.checkout.ResourceProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenterImpl;", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenter;", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemView;", "view", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemView;Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItem;I)V", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "prolongationClicksSubject", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getProlongationClicks", "()Lio/reactivex/Observable;", "prolongationClicks", "Lcom/avito/android/basket/checkout/ResourceProvider;", "c", "Lcom/avito/android/basket/checkout/ResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/basket/checkout/ResourceProvider;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class ProlongationItemPresenterImpl implements ProlongationItemPresenter {
    public final PublishSubject<ProlongationItem> a;
    @NotNull
    public final Observable<ProlongationItem> b;
    public final ResourceProvider c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ProlongationItemPresenterImpl a;
        public final /* synthetic */ ProlongationItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProlongationItemPresenterImpl prolongationItemPresenterImpl, ProlongationItem prolongationItem) {
            super(0);
            this.a = prolongationItemPresenterImpl;
            this.b = prolongationItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ProlongationItem prolongationItem = this.b;
            prolongationItem.setSwitchOn(!prolongationItem.isSwitchOn());
            this.a.a.onNext(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ProlongationItemPresenterImpl(@NotNull ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        this.c = resourceProvider;
        PublishSubject<ProlongationItem> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create<ProlongationItem>()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.basket.checkout.item.prolongation.ProlongationItemPresenter
    @NotNull
    public Observable<ProlongationItem> getProlongationClicks() {
        return this.b;
    }

    public void bindView(@NotNull ProlongationItemView prolongationItemView, @NotNull ProlongationItem prolongationItem, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(prolongationItemView, "view");
        Intrinsics.checkNotNullParameter(prolongationItem, "item");
        prolongationItemView.setTitle(prolongationItem.getTitle());
        prolongationItemView.setDescription(prolongationItem.getDescription());
        prolongationItemView.setSwitcherOn(prolongationItem.isSwitchOn());
        prolongationItemView.setOnClickListener(new a(this, prolongationItem));
        if (prolongationItem.getServiceId() == null) {
            i2 = this.c.getDefaultItemOffset();
        } else {
            i2 = this.c.getProlongationTariffOffset();
        }
        prolongationItemView.setStartPadding(i2);
    }
}
