package com.avito.android.select.new_metro.adapter.selected_stations;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0010\u001a0\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0017\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b¢\u0006\u0002\b\r0\u000b¢\u0006\u0002\b\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemView;", "view", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemView;Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "selectedItemsStream", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getValueChanges", "()Lio/reactivex/rxjava3/core/Observable;", "valueChanges", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroSelectedStationsItemPresenterImpl implements MetroSelectedStationsItemPresenter {
    public final PublishSubject<MetroSelectedStationsItem> a;
    @NotNull
    public final Observable<MetroSelectedStationsItem> b;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MetroSelectedStationsItemView a;
        public final /* synthetic */ MetroSelectedStationsItemPresenterImpl b;
        public final /* synthetic */ MetroSelectedStationsItem c;
        public final /* synthetic */ MetroSelectedStationsItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroSelectedStationsItemView metroSelectedStationsItemView, MetroSelectedStationsItemPresenterImpl metroSelectedStationsItemPresenterImpl, MetroSelectedStationsItem metroSelectedStationsItem, MetroSelectedStationsItemView metroSelectedStationsItemView2) {
            super(1);
            this.a = metroSelectedStationsItemView;
            this.b = metroSelectedStationsItemPresenterImpl;
            this.c = metroSelectedStationsItem;
            this.d = metroSelectedStationsItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "stationStringId");
            MetroSelectedStationsItemPresenterImpl.access$onStationRemoved(this.b, str2, this.a, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MetroSelectedStationsItem a;
        public final /* synthetic */ MetroSelectedStationsItemView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MetroSelectedStationsItemPresenterImpl metroSelectedStationsItemPresenterImpl, MetroSelectedStationsItem metroSelectedStationsItem, MetroSelectedStationsItemView metroSelectedStationsItemView) {
            super(0);
            this.a = metroSelectedStationsItem;
            this.b = metroSelectedStationsItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MetroSelectedStationsItem metroSelectedStationsItem = this.a;
            metroSelectedStationsItem.setShowAll(!metroSelectedStationsItem.getShowAll());
            this.b.setShowAll(this.a.getShowAll());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MetroSelectedStationsItemPresenterImpl() {
        PublishSubject<MetroSelectedStationsItem> create = PublishSubject.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "selectedItemsStream");
        this.b = create;
    }

    public static final void access$onStationRemoved(MetroSelectedStationsItemPresenterImpl metroSelectedStationsItemPresenterImpl, String str, MetroSelectedStationsItemView metroSelectedStationsItemView, MetroSelectedStationsItem metroSelectedStationsItem) {
        T t;
        Objects.requireNonNull(metroSelectedStationsItemPresenterImpl);
        Iterator<T> it = metroSelectedStationsItem.getItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getId(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            metroSelectedStationsItem.remove(t2);
            metroSelectedStationsItemView.showStations(CollectionsKt___CollectionsKt.toList(metroSelectedStationsItem.getItems()));
            metroSelectedStationsItemPresenterImpl.a.onNext(metroSelectedStationsItem);
        }
    }

    @Override // com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter
    @NotNull
    public Observable<MetroSelectedStationsItem> getValueChanges() {
        return this.b;
    }

    public void bindView(@NotNull MetroSelectedStationsItemView metroSelectedStationsItemView, @NotNull MetroSelectedStationsItem metroSelectedStationsItem, int i) {
        Intrinsics.checkNotNullParameter(metroSelectedStationsItemView, "view");
        Intrinsics.checkNotNullParameter(metroSelectedStationsItem, "item");
        metroSelectedStationsItemView.showStations(CollectionsKt___CollectionsKt.toList(metroSelectedStationsItem.getItems()));
        metroSelectedStationsItemView.setOnSelectedStationClickListener(new a(metroSelectedStationsItemView, this, metroSelectedStationsItem, metroSelectedStationsItemView));
        metroSelectedStationsItemView.setOnExpandedClickListener(new b(this, metroSelectedStationsItem, metroSelectedStationsItemView));
        metroSelectedStationsItemView.setShowAll(metroSelectedStationsItem.getShowAll());
        metroSelectedStationsItemView.setMinLines(metroSelectedStationsItem.getMinimumShowedLines());
    }
}
