package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.tab.list.items.ChartItem;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eRD\u0010\u0014\u001a0\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004 \u0010*\u0017\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000f¢\u0006\u0002\b\u00110\u000f¢\u0006\u0002\b\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemView;", "view", "Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemView;Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;I)V", "", "", "payloads", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemView;Lcom/avito/android/user_stats/tab/list/items/ChartItem$BarItem;ILjava/util/List;)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "clicksRelay", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getClicksObservable", "()Lio/reactivex/rxjava3/core/Observable;", "clicksObservable", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemPresenterImpl implements BarItemPresenter {
    public final PublishRelay<ChartItem.BarItem> a;
    @NotNull
    public final Observable<ChartItem.BarItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BarItemPresenterImpl a;
        public final /* synthetic */ ChartItem.BarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BarItemPresenterImpl barItemPresenterImpl, ChartItem.BarItem barItem) {
            super(0);
            this.a = barItemPresenterImpl;
            this.b = barItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BarItemPresenterImpl a;
        public final /* synthetic */ ChartItem.BarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BarItemPresenterImpl barItemPresenterImpl, ChartItem.BarItem barItem) {
            super(0);
            this.a = barItemPresenterImpl;
            this.b = barItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public BarItemPresenterImpl() {
        PublishRelay<ChartItem.BarItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "clicksRelay");
        this.b = create;
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPresenter
    @NotNull
    public Observable<ChartItem.BarItem> getClicksObservable() {
        return this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(BarItemView barItemView, ChartItem.BarItem barItem, int i, List list) {
        bindView(barItemView, barItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull BarItemView barItemView, @NotNull ChartItem.BarItem barItem, int i) {
        Intrinsics.checkNotNullParameter(barItemView, "view");
        Intrinsics.checkNotNullParameter(barItem, "item");
        barItemView.setLabel(barItem.getLabel());
        barItemView.setBarValue(barItem.getValue());
        barItemView.setSelected(barItem.isSelected());
        barItemView.setColor(barItem.getColor());
        barItemView.setOnClickListener(new a(this, barItem));
    }

    public void bindView(@NotNull BarItemView barItemView, @NotNull ChartItem.BarItem barItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(barItemView, "view");
        Intrinsics.checkNotNullParameter(barItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof BarItemPayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(barItemView, barItem, i);
            return;
        }
        barItemView.setSelected(t3.isSelected());
        barItemView.setColor(t3.getColor());
        barItemView.setOnClickListener(new b(this, barItem));
    }
}
