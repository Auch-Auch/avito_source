package com.avito.android.payment.top_up.form.items.bubble;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemPresenterImpl;", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemPresenter;", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemView;", "view", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemView;Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItem;I)V", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class BubbleItemPresenterImpl implements BubbleItemPresenter {
    public final Function1<BubbleItem, Unit> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BubbleItemPresenterImpl a;
        public final /* synthetic */ BubbleItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BubbleItemPresenterImpl bubbleItemPresenterImpl, BubbleItem bubbleItem) {
            super(0);
            this.a = bubbleItemPresenterImpl;
            this.b = bubbleItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.invoke(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.payment.top_up.form.items.bubble.BubbleItem, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BubbleItemPresenterImpl(@NotNull Function1<? super BubbleItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = function1;
    }

    public void bindView(@NotNull BubbleItemView bubbleItemView, @NotNull BubbleItem bubbleItem, int i) {
        Intrinsics.checkNotNullParameter(bubbleItemView, "view");
        Intrinsics.checkNotNullParameter(bubbleItem, "item");
        bubbleItemView.setText(bubbleItem.getRawValue());
        bubbleItemView.setClickListener(new a(this, bubbleItem));
    }
}
