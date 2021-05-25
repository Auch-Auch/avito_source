package com.avito.android.payment.top_up.form.items.input;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemPresenterImpl;", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemPresenter;", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemView;", "view", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemView;Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItem;I)V", "Lkotlin/Function0;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "actionListener", "Lkotlin/Function2;", "", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpInputItemPresenterImpl implements TopUpInputItemPresenter {
    public final Function2<TopUpInputItem, String, Unit> a;
    public final Function0<Unit> b;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ TopUpInputItemPresenterImpl a;
        public final /* synthetic */ TopUpInputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TopUpInputItemPresenterImpl topUpInputItemPresenterImpl, TopUpInputItem topUpInputItem) {
            super(1);
            this.a = topUpInputItemPresenterImpl;
            this.b = topUpInputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newValue");
            this.a.a.invoke(this.b, str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super com.avito.android.payment.top_up.form.items.input.TopUpInputItem, ? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public TopUpInputItemPresenterImpl(@NotNull Function2<? super TopUpInputItem, ? super String, Unit> function2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(function0, "actionListener");
        this.a = function2;
        this.b = function0;
    }

    public void bindView(@NotNull TopUpInputItemView topUpInputItemView, @NotNull TopUpInputItem topUpInputItem, int i) {
        Intrinsics.checkNotNullParameter(topUpInputItemView, "view");
        Intrinsics.checkNotNullParameter(topUpInputItem, "item");
        topUpInputItemView.setRawInputListener(new a(this, topUpInputItem));
        topUpInputItemView.setActionListener(this.b);
        if (!Intrinsics.areEqual(topUpInputItem.getValue(), topUpInputItemView.getRawTextValue())) {
            topUpInputItemView.setRawTextValue(topUpInputItem.getValue());
        }
    }
}
