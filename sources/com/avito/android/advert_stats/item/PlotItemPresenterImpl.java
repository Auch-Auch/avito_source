package com.avito.android.advert_stats.item;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b5\u00106J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R:\u0010\u0015\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000b0\u000b \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001aR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R:\u0010(\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\b0\b \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\b0\b\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0014R:\u0010,\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u001c0\u001c \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/advert_stats/item/PlotItemPresenterImpl;", "Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "Lcom/avito/android/advert_stats/item/PlotItemView;", "view", "Lcom/avito/android/advert_stats/item/PlotItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_stats/item/PlotItemView;Lcom/avito/android/advert_stats/item/PlotItem;I)V", "Lcom/avito/android/advert_stats/item/BarItem;", "barItem", "onBarClicked", "(Lcom/avito/android/advert_stats/item/BarItem;)V", "d", "Lcom/avito/android/advert_stats/item/PlotItemView;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "barSelectedRelay", "Lio/reactivex/Observable;", "h", "Lio/reactivex/Observable;", "getBarSelectedObservable", "()Lio/reactivex/Observable;", "barSelectedObservable", "Lcom/avito/android/advert_stats/item/WeekItem;", g.a, "getWeekSelectedObservable", "weekSelectedObservable", "i", "getPlotScrollObservable", "plotScrollObservable", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "j", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "dimensProvider", "c", "scrollingRelay", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "weekSelectedRelay", "", "e", "Ljava/util/List;", "items", "", "f", "Z", "lastState", "<init>", "(Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class PlotItemPresenterImpl implements PlotItemPresenter {
    public final BehaviorRelay<WeekItem> a;
    public final PublishRelay<BarItem> b;
    public final PublishRelay<Unit> c;
    public PlotItemView d;
    public List<WeekItem> e = CollectionsKt__CollectionsKt.emptyList();
    public boolean f = true;
    @NotNull
    public final Observable<WeekItem> g;
    @NotNull
    public final Observable<BarItem> h;
    @NotNull
    public final Observable<Unit> i;
    public final PlotDimensionsProvider j;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ PlotItemPresenterImpl a;
        public final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PlotItemPresenterImpl plotItemPresenterImpl, List list) {
            super(1);
            this.a = plotItemPresenterImpl;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            if (intValue >= 0 && intValue < this.b.size()) {
                this.a.a.accept(this.b.get(intValue));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ PlotItemPresenterImpl a;
        public final /* synthetic */ PlotItemView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PlotItemPresenterImpl plotItemPresenterImpl, PlotItemView plotItemView) {
            super(1);
            this.a = plotItemPresenterImpl;
            this.b = plotItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            if (booleanValue != this.a.f) {
                this.a.f = booleanValue;
                for (WeekItem weekItem : this.a.e) {
                    PlotItemPresenterImpl.access$removeItemSelection(this.a, weekItem.getDays());
                }
                this.b.setItems(this.a.e, false);
                this.b.removeDaySelection();
                if (!booleanValue) {
                    this.a.c.accept(Unit.INSTANCE);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PlotItemPresenterImpl(@NotNull PlotDimensionsProvider plotDimensionsProvider) {
        Intrinsics.checkNotNullParameter(plotDimensionsProvider, "dimensProvider");
        this.j = plotDimensionsProvider;
        BehaviorRelay<WeekItem> create = BehaviorRelay.create();
        this.a = create;
        PublishRelay<BarItem> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        this.c = create3;
        Intrinsics.checkNotNullExpressionValue(create, "weekSelectedRelay");
        this.g = create;
        Intrinsics.checkNotNullExpressionValue(create2, "barSelectedRelay");
        this.h = create2;
        Intrinsics.checkNotNullExpressionValue(create3, "scrollingRelay");
        this.i = create3;
    }

    public static final void access$removeItemSelection(PlotItemPresenterImpl plotItemPresenterImpl, List list) {
        Objects.requireNonNull(plotItemPresenterImpl);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((BarItem) it.next()).setState(BarState.DEFAULT);
        }
    }

    @Override // com.avito.android.advert_stats.item.PlotItemPresenter
    @NotNull
    public Observable<BarItem> getBarSelectedObservable() {
        return this.h;
    }

    @Override // com.avito.android.advert_stats.item.PlotItemPresenter
    @NotNull
    public Observable<Unit> getPlotScrollObservable() {
        return this.i;
    }

    @Override // com.avito.android.advert_stats.item.PlotItemPresenter
    @NotNull
    public Observable<WeekItem> getWeekSelectedObservable() {
        return this.g;
    }

    @Override // com.avito.android.advert_stats.item.OnBarItemClickListener
    public void onBarClicked(@NotNull BarItem barItem) {
        Intrinsics.checkNotNullParameter(barItem, "barItem");
        boolean z = barItem.getState() != BarState.SELECTED;
        if (z) {
            this.b.accept(barItem);
        } else {
            BehaviorRelay<WeekItem> behaviorRelay = this.a;
            Intrinsics.checkNotNullExpressionValue(behaviorRelay, "weekSelectedRelay");
            WeekItem value = behaviorRelay.getValue();
            if (value != null) {
                this.a.accept(value);
            }
        }
        BarState barState = z ? BarState.UNSELECTED : BarState.DEFAULT;
        Iterator<T> it = this.e.iterator();
        while (it.hasNext()) {
            for (T t : it.next().getDays()) {
                t.setState(Intrinsics.areEqual(t.getStringId(), barItem.getStringId()) && barItem.getState() != BarState.SELECTED ? BarState.SELECTED : barState);
            }
        }
        PlotItemView plotItemView = this.d;
        if (plotItemView != null) {
            plotItemView.setItems(this.e, z);
        }
        PlotItemView plotItemView2 = this.d;
        if (plotItemView2 != null) {
            plotItemView2.setDaySelected(barItem.getIndex(), z);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0076 */
    /* JADX DEBUG: Multi-variable search result rejected for r12v8, resolved type: com.jakewharton.rxrelay2.BehaviorRelay<com.avito.android.advert_stats.item.WeekItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public void bindView(@NotNull PlotItemView plotItemView, @NotNull PlotItem plotItem, int i2) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(plotItemView, "view");
        Intrinsics.checkNotNullParameter(plotItem, "item");
        this.d = plotItemView;
        this.e = plotItem.getWeeks();
        List<WeekItem> weeks = plotItem.getWeeks();
        plotItemView.setHeight(this.j.getPlotHeight());
        plotItemView.setWeekSelectedListener(new a(this, weeks));
        Iterator<T> it = weeks.iterator();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            t = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Iterator<T> it2 = next.getDays().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next2 = it2.next();
                if (next2.getState() == BarState.SELECTED) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t = next2;
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                t = new Pair(Integer.valueOf(i3), t2);
                break;
            }
            i3 = i4;
        }
        if (t != null) {
            z2 = true;
        }
        plotItemView.setItems(weeks, z2);
        if (t != null) {
            int intValue = ((Number) t.component1()).intValue();
            this.a.accept(weeks.get(intValue));
            this.b.accept((BarItem) t.component2());
            plotItemView.scrollToItem(intValue);
        } else {
            this.a.accept(CollectionsKt___CollectionsKt.first((List<? extends Object>) weeks));
        }
        plotItemView.setScrollStateListener(new b(this, plotItemView));
    }
}
