package com.avito.android.tariff.fees_methods.items.high_demand;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FeeMethodBottomSheet;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R:\u0010\u0016\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenterImpl;", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenter;", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItemView;", "view", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItemView;Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItem;I)V", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/FeeMethodBottomSheet;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getButtonClicks", "()Lio/reactivex/Observable;", "buttonClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksObservable", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class HighDemandPresenterImpl implements HighDemandPresenter {
    public final PublishRelay<FeeMethodBottomSheet> a;
    @NotNull
    public final Observable<FeeMethodBottomSheet> b;

    public static final class a extends Lambda implements Function1<Object, Unit> {
        public final /* synthetic */ HighDemandPresenterImpl a;
        public final /* synthetic */ HighDemandItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HighDemandPresenterImpl highDemandPresenterImpl, HighDemandItem highDemandItem) {
            super(1);
            this.a = highDemandPresenterImpl;
            this.b = highDemandItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            this.a.a.accept(this.b.getBottomSheet());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public HighDemandPresenterImpl() {
        PublishRelay<FeeMethodBottomSheet> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "clicksObservable");
        this.b = create;
    }

    @Override // com.avito.android.tariff.fees_methods.items.high_demand.HighDemandPresenter
    @NotNull
    public Observable<FeeMethodBottomSheet> getButtonClicks() {
        return this.b;
    }

    public void bindView(@NotNull HighDemandItemView highDemandItemView, @NotNull HighDemandItem highDemandItem, int i) {
        Intrinsics.checkNotNullParameter(highDemandItemView, "view");
        Intrinsics.checkNotNullParameter(highDemandItem, "item");
        highDemandItemView.setTitle(highDemandItem.getTitle());
        highDemandItemView.setActionText(highDemandItem.getActionTitle());
        highDemandItemView.setIcon(highDemandItem.getIcon());
        highDemandItemView.setOnClickListener(new a(this, highDemandItem));
    }
}
