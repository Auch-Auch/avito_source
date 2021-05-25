package com.avito.android.tariff.edit_info.item.manager_call;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR:\u0010\u0015\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/manager_call/ManagerCallPresenterImpl;", "Lcom/avito/android/tariff/edit_info/item/manager_call/ManagerCallPresenter;", "Lcom/avito/android/tariff/edit_info/item/manager_call/ManagerCallItemView;", "view", "Lcom/avito/android/tariff/edit_info/item/manager_call/ManagerCallItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/edit_info/item/manager_call/ManagerCallItemView;Lcom/avito/android/tariff/edit_info/item/manager_call/ManagerCallItem;I)V", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getButtonClicks", "()Lio/reactivex/Observable;", "buttonClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksObservable", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ManagerCallPresenterImpl implements ManagerCallPresenter {
    public final PublishRelay<ManagerCallItem> a;
    @NotNull
    public final Observable<ManagerCallItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ManagerCallPresenterImpl a;
        public final /* synthetic */ ManagerCallItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ManagerCallPresenterImpl managerCallPresenterImpl, ManagerCallItem managerCallItem) {
            super(0);
            this.a = managerCallPresenterImpl;
            this.b = managerCallItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ManagerCallPresenterImpl() {
        PublishRelay<ManagerCallItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "clicksObservable");
        this.b = create;
    }

    @Override // com.avito.android.tariff.edit_info.item.manager_call.ManagerCallPresenter
    @NotNull
    public Observable<ManagerCallItem> getButtonClicks() {
        return this.b;
    }

    public void bindView(@NotNull ManagerCallItemView managerCallItemView, @NotNull ManagerCallItem managerCallItem, int i) {
        Intrinsics.checkNotNullParameter(managerCallItemView, "view");
        Intrinsics.checkNotNullParameter(managerCallItem, "item");
        managerCallItemView.setOnClickListener(new a(this, managerCallItem));
        managerCallItemView.setButtonTitle(managerCallItem.getActionTitle());
    }
}
