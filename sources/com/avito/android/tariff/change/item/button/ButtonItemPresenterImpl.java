package com.avito.android.tariff.change.item.button;

import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR:\u0010\u000f\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/change/item/button/ButtonItemPresenterImpl;", "Lcom/avito/android/tariff/change/item/button/ButtonItemPresenter;", "Lcom/avito/android/tariff/change/item/button/ButtonItemView;", "view", "Lcom/avito/android/tariff/change/item/button/ButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/change/item/button/ButtonItemView;Lcom/avito/android/tariff/change/item/button/ButtonItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "buttonItemClickSubject", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getButtonItemClicks", "()Lio/reactivex/Observable;", "buttonItemClicks", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemPresenterImpl implements ButtonItemPresenter {
    public final PublishRelay<ButtonItem> a;
    @NotNull
    public final Observable<ButtonItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ButtonItemPresenterImpl a;
        public final /* synthetic */ ButtonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ButtonItemPresenterImpl buttonItemPresenterImpl, ButtonItem buttonItem) {
            super(0);
            this.a = buttonItemPresenterImpl;
            this.b = buttonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ButtonItemPresenterImpl() {
        PublishRelay<ButtonItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "buttonItemClickSubject");
        this.b = create;
    }

    @Override // com.avito.android.tariff.change.item.button.ButtonItemPresenter
    @NotNull
    public Observable<ButtonItem> getButtonItemClicks() {
        return this.b;
    }

    public void bindView(@NotNull ButtonItemView buttonItemView, @NotNull ButtonItem buttonItem, int i) {
        Intrinsics.checkNotNullParameter(buttonItemView, "view");
        Intrinsics.checkNotNullParameter(buttonItem, "item");
        buttonItemView.setText(buttonItem.getText());
        buttonItemView.setOnClickListener(new a(this, buttonItem));
    }
}
