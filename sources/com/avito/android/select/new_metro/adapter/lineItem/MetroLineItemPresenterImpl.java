package com.avito.android.select.new_metro.adapter.lineItem;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRJ\u0010\u0012\u001a0\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0017\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b¢\u0006\u0002\b\r0\u000b¢\u0006\u0002\b\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemView;", "view", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemView;Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "getExpandedChangeObservable", "()Lio/reactivex/rxjava3/subjects/PublishSubject;", "expandedChangeObservable", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroLineItemPresenterImpl implements MetroLineItemPresenter {
    public final PublishSubject<MetroLineItem> a = PublishSubject.create();

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MetroLineItemView a;
        public final /* synthetic */ MetroLineItemPresenterImpl b;
        public final /* synthetic */ MetroLineItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroLineItemView metroLineItemView, MetroLineItemPresenterImpl metroLineItemPresenterImpl, MetroLineItem metroLineItem) {
            super(0);
            this.a = metroLineItemView;
            this.b = metroLineItemPresenterImpl;
            this.c = metroLineItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MetroLineItem metroLineItem = this.c;
            metroLineItem.setExpanded(!metroLineItem.isExpanded());
            this.a.setIsExpanded(this.c.isExpanded(), true);
            this.b.getExpandedChangeObservable().onNext(this.c);
            return Unit.INSTANCE;
        }
    }

    public void bindView(@NotNull MetroLineItemView metroLineItemView, @NotNull MetroLineItem metroLineItem, int i) {
        Intrinsics.checkNotNullParameter(metroLineItemView, "view");
        Intrinsics.checkNotNullParameter(metroLineItem, "item");
        metroLineItemView.setIsExpanded(metroLineItem.isExpanded(), false);
        metroLineItemView.setLineColor(metroLineItem.getLineColor());
        metroLineItemView.setName(metroLineItem.getName());
        metroLineItemView.setClickListener(new a(metroLineItemView, this, metroLineItem));
    }

    @Override // com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter
    public PublishSubject<MetroLineItem> getExpandedChangeObservable() {
        return this.a;
    }
}
