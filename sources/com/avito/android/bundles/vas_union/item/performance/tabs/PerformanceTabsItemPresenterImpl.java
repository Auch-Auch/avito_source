package com.avito.android.bundles.vas_union.item.performance.tabs;

import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenterImpl;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemView;", "view", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemView;Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "checkedChangeSubject", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getTabCheckedObservable", "()Lio/reactivex/rxjava3/core/Observable;", "tabCheckedObservable", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceTabsItemPresenterImpl implements PerformanceTabsItemPresenter {
    public final PublishSubject<Tab> a;
    @NotNull
    public final Observable<Tab> b;

    public static final class a extends Lambda implements Function1<Tab, Unit> {
        public final /* synthetic */ PerformanceTabsItemPresenterImpl a;
        public final /* synthetic */ PerformanceTabsItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PerformanceTabsItemPresenterImpl performanceTabsItemPresenterImpl, PerformanceTabsItem performanceTabsItem) {
            super(1);
            this.a = performanceTabsItemPresenterImpl;
            this.b = performanceTabsItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Tab tab) {
            Tab tab2 = tab;
            Intrinsics.checkNotNullParameter(tab2, "it");
            this.b.setSelectedIndex(tab2.getPosition());
            this.a.a.onNext(tab2);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PerformanceTabsItemPresenterImpl() {
        PublishSubject<Tab> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemPresenter
    @NotNull
    public Observable<Tab> getTabCheckedObservable() {
        return this.b;
    }

    public void bindView(@NotNull PerformanceTabsItemView performanceTabsItemView, @NotNull PerformanceTabsItem performanceTabsItem, int i) {
        Intrinsics.checkNotNullParameter(performanceTabsItemView, "view");
        Intrinsics.checkNotNullParameter(performanceTabsItem, "item");
        performanceTabsItemView.setTabs(performanceTabsItem.getTabs(), performanceTabsItem.getSelectedIndex());
        performanceTabsItemView.setTabSelectedListener(new a(this, performanceTabsItem));
    }
}
