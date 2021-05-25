package com.avito.android.vas_performance.ui.items.info_action;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenterImpl;", "Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemView;", "view", "Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemView;Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItem;I)V", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "infoActionClickPublishSubject", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getInfoActionClicksObservable", "()Lio/reactivex/Observable;", "infoActionClicksObservable", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class InfoActionItemPresenterImpl implements InfoActionItemPresenter {
    public final PublishSubject<InfoActionItem> a;
    @NotNull
    public final Observable<InfoActionItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InfoActionItemPresenterImpl a;
        public final /* synthetic */ InfoActionItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InfoActionItemPresenterImpl infoActionItemPresenterImpl, InfoActionItem infoActionItem) {
            super(0);
            this.a = infoActionItemPresenterImpl;
            this.b = infoActionItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onNext(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public InfoActionItemPresenterImpl() {
        PublishSubject<InfoActionItem> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create<InfoActionItem>()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenter
    @NotNull
    public Observable<InfoActionItem> getInfoActionClicksObservable() {
        return this.b;
    }

    public void bindView(@NotNull InfoActionItemView infoActionItemView, @NotNull InfoActionItem infoActionItem, int i) {
        Intrinsics.checkNotNullParameter(infoActionItemView, "view");
        Intrinsics.checkNotNullParameter(infoActionItem, "item");
        infoActionItemView.setTitle(infoActionItem.getTitle());
        infoActionItemView.setClickListener(new a(this, infoActionItem));
    }
}
