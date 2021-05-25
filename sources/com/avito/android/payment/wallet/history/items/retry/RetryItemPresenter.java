package com.avito.android.payment.wallet.history.items.retry;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/wallet/history/items/retry/RetryItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/payment/wallet/history/items/retry/RetryViewHolder;", "Lcom/avito/android/payment/wallet/history/items/retry/RetryItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/payment/wallet/history/items/retry/RetryViewHolder;Lcom/avito/android/payment/wallet/history/items/retry/RetryItem;I)V", "Lkotlin/Function1;", "", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "clickListener", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class RetryItemPresenter implements ItemPresenter<RetryViewHolder, RetryItem> {
    public final Function1<String, Unit> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RetryItemPresenter a;
        public final /* synthetic */ RetryItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RetryItemPresenter retryItemPresenter, RetryItem retryItem) {
            super(0);
            this.a = retryItemPresenter;
            this.b = retryItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.invoke(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public RetryItemPresenter(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.a = function1;
    }

    public void bindView(@NotNull RetryViewHolder retryViewHolder, @NotNull RetryItem retryItem, int i) {
        Intrinsics.checkNotNullParameter(retryViewHolder, "view");
        Intrinsics.checkNotNullParameter(retryItem, "item");
        retryViewHolder.setOnButtonClickListener(new a(this, retryItem));
    }
}
