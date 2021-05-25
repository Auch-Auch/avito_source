package com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemPresenterImpl;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemPresenter;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemView;", "view", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemView;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItem;I)V", "Lio/reactivex/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class TimeIntervalItemPresenterImpl implements TimeIntervalItemPresenter {
    public final Consumer<TimeIntervalItem> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TimeIntervalItemPresenterImpl a;
        public final /* synthetic */ TimeIntervalItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TimeIntervalItemPresenterImpl timeIntervalItemPresenterImpl, TimeIntervalItem timeIntervalItem) {
            super(0);
            this.a = timeIntervalItemPresenterImpl;
            this.b = timeIntervalItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public TimeIntervalItemPresenterImpl(@NotNull Consumer<TimeIntervalItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull TimeIntervalItemView timeIntervalItemView, @NotNull TimeIntervalItem timeIntervalItem, int i) {
        Intrinsics.checkNotNullParameter(timeIntervalItemView, "view");
        Intrinsics.checkNotNullParameter(timeIntervalItem, "item");
        timeIntervalItemView.setText(timeIntervalItem.getTitle());
        timeIntervalItemView.setCheckmarkSelected(timeIntervalItem.getSelected());
        timeIntervalItemView.setOnClickListener(new a(this, timeIntervalItem));
    }
}
