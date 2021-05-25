package com.avito.android.user_advert.soa_with_price.blueprint;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.soa_with_price.CloseReasonItem;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR:\u0010\u0015\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenterImpl;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemView;", "view", "Lcom/avito/android/user_advert/soa_with_price/CloseReasonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemView;Lcom/avito/android/user_advert/soa_with_price/CloseReasonItem;I)V", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getItemSelectedObservable", "()Lio/reactivex/Observable;", "itemSelectedObservable", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemSelectedRelay", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class CloseReasonItemPresenterImpl implements CloseReasonItemPresenter {
    public final PublishRelay<CloseReasonItem> a;
    @NotNull
    public final Observable<CloseReasonItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CloseReasonItemPresenterImpl a;
        public final /* synthetic */ CloseReasonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CloseReasonItemPresenterImpl closeReasonItemPresenterImpl, CloseReasonItem closeReasonItem) {
            super(0);
            this.a = closeReasonItemPresenterImpl;
            this.b = closeReasonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CloseReasonItemPresenterImpl() {
        PublishRelay<CloseReasonItem> create = PublishRelay.create();
        this.a = create;
        Observable<CloseReasonItem> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "itemSelectedRelay.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenter
    @NotNull
    public Observable<CloseReasonItem> getItemSelectedObservable() {
        return this.b;
    }

    public void bindView(@NotNull CloseReasonItemView closeReasonItemView, @NotNull CloseReasonItem closeReasonItem, int i) {
        Intrinsics.checkNotNullParameter(closeReasonItemView, "view");
        Intrinsics.checkNotNullParameter(closeReasonItem, "item");
        closeReasonItemView.setText(closeReasonItem.getTitle());
        closeReasonItemView.setChecked(closeReasonItem.isSelected());
        closeReasonItemView.setClickListener(new a(this, closeReasonItem));
    }
}
