package com.avito.android.delivery.order_cancellation.konveyor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemView;", "Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItemView;Lcom/avito/android/delivery/order_cancellation/konveyor/ReasonItem;I)V", "Lio/reactivex/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ReasonItemPresenter implements ItemPresenter<ReasonItemView, ReasonItem> {
    public final Consumer<ReasonItem> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ReasonItemPresenter a;
        public final /* synthetic */ ReasonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ReasonItemPresenter reasonItemPresenter, ReasonItem reasonItem) {
            super(0);
            this.a = reasonItemPresenter;
            this.b = reasonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public ReasonItemPresenter(@NotNull Consumer<ReasonItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ReasonItemView reasonItemView, @NotNull ReasonItem reasonItem, int i) {
        Intrinsics.checkNotNullParameter(reasonItemView, "view");
        Intrinsics.checkNotNullParameter(reasonItem, "item");
        reasonItemView.setText(reasonItem.getText());
        reasonItemView.setClickListener(new a(this, reasonItem));
    }
}
