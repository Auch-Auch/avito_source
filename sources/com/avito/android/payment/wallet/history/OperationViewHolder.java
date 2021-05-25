package com.avito.android.payment.wallet.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.payment.R;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.remote.model.payment.history.PaymentOrderStatus;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class OperationViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public static final Companion z = new Companion(null);
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final ImageView w;
    public final View x;
    public final Function1<PaymentHistoryListElement.Operation, Unit> y;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/wallet/history/OperationViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "parent", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Operation;", "", "onOperationClickListener", "Lcom/avito/android/payment/wallet/history/OperationViewHolder;", "create", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/payment/wallet/history/OperationViewHolder;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final OperationViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Function1<? super PaymentHistoryListElement.Operation, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(function1, "onOperationClickListener");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.payment_history_operation, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new OperationViewHolder(inflate, function1);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PaymentOrderStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            PaymentOrderStatus paymentOrderStatus = PaymentOrderStatus.ACTIVE;
            iArr[0] = 1;
            PaymentOrderStatus paymentOrderStatus2 = PaymentOrderStatus.DONE;
            iArr[1] = 2;
            PaymentOrderStatus paymentOrderStatus3 = PaymentOrderStatus.CANCELED;
            iArr[2] = 3;
            PaymentOrderStatus paymentOrderStatus4 = PaymentOrderStatus.FAILED;
            iArr[3] = 4;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.payment.history.PaymentHistoryListElement$Operation, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OperationViewHolder(@NotNull View view, @NotNull Function1<? super PaymentHistoryListElement.Operation, Unit> function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, "onOperationClickListener");
        this.x = view;
        this.y = function1;
        View findViewById = view.findViewById(R.id.payment_operation_amount);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.payment_operation_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.payment_operation_description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.payment_operation_date);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.payment_operation_icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.w = (ImageView) findViewById5;
    }
}
