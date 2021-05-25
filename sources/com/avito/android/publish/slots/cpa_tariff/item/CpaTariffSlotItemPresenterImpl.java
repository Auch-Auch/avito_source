package com.avito.android.publish.slots.cpa_tariff.item;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR:\u0010\u0015\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItemPresenterImpl;", "Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItemPresenter;", "Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotView;", "view", "Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotView;Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItem;I)V", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getCpaTariffSlotClickObservable", "()Lio/reactivex/Observable;", "cpaTariffSlotClickObservable", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "cpaTariffSlotClickStream", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffSlotItemPresenterImpl implements CpaTariffSlotItemPresenter {
    public final PublishRelay<CpaTariffSlotItem> a;
    @NotNull
    public final Observable<CpaTariffSlotItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CpaTariffSlotItemPresenterImpl a;
        public final /* synthetic */ CpaTariffSlotItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CpaTariffSlotItemPresenterImpl cpaTariffSlotItemPresenterImpl, CpaTariffSlotItem cpaTariffSlotItem) {
            super(0);
            this.a = cpaTariffSlotItemPresenterImpl;
            this.b = cpaTariffSlotItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public CpaTariffSlotItemPresenterImpl() {
        PublishRelay<CpaTariffSlotItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "cpaTariffSlotClickStream");
        this.b = create;
    }

    @Override // com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter
    @NotNull
    public Observable<CpaTariffSlotItem> getCpaTariffSlotClickObservable() {
        return this.b;
    }

    public void bindView(@NotNull CpaTariffSlotView cpaTariffSlotView, @NotNull CpaTariffSlotItem cpaTariffSlotItem, int i) {
        Intrinsics.checkNotNullParameter(cpaTariffSlotView, "view");
        Intrinsics.checkNotNullParameter(cpaTariffSlotItem, "item");
        cpaTariffSlotView.setTitle(cpaTariffSlotItem.getTitle());
        cpaTariffSlotView.setText(cpaTariffSlotItem.getDescription());
        cpaTariffSlotView.setClickListener(cpaTariffSlotItem.getButtonTitle(), new a(this, cpaTariffSlotItem));
    }
}
