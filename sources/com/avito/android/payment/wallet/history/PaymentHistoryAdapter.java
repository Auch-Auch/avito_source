package com.avito.android.payment.wallet.history;

import a2.a.a.t1.f.c.b;
import a2.a.a.t1.f.c.c;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.payment.R;
import com.avito.android.payment.wallet.history.HistoryLoadingState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B=\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f0!\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\f0!\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001d¢\u0006\u0004\b)\u0010*J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\f0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010$¨\u0006+"}, d2 = {"Lcom/avito/android/payment/wallet/history/PaymentHistoryAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "Lcom/avito/android/payment/wallet/history/HistoryLoadingState;", "historyLoadingState", "setNetworkState", "(Lcom/avito/android/payment/wallet/history/HistoryLoadingState;)V", "", AuthSource.SEND_ABUSE, "()Z", "e", "Lcom/avito/android/payment/wallet/history/HistoryLoadingState;", "loadingState", "Lkotlin/Function0;", "h", "Lkotlin/jvm/functions/Function0;", "onRefreshButtonClickListener", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Order;", "f", "Lkotlin/jvm/functions/Function1;", "onOrderClickListener", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Operation;", g.a, "onOperationClickListener", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryAdapter extends PagedListAdapter<PaymentHistoryListElement, RecyclerView.ViewHolder> {
    public HistoryLoadingState e = HistoryLoadingState.Loaded.INSTANCE;
    public final Function1<PaymentHistoryListElement.Order, Unit> f;
    public final Function1<PaymentHistoryListElement.Operation, Unit> g;
    public final Function0<Unit> h;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.payment.history.PaymentHistoryListElement$Order, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.payment.history.PaymentHistoryListElement$Operation, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentHistoryAdapter(@NotNull Function1<? super PaymentHistoryListElement.Order, Unit> function1, @NotNull Function1<? super PaymentHistoryListElement.Operation, Unit> function12, @NotNull Function0<Unit> function0) {
        super(PaymentHistoryAdapterKt.a);
        Intrinsics.checkNotNullParameter(function1, "onOrderClickListener");
        Intrinsics.checkNotNullParameter(function12, "onOperationClickListener");
        Intrinsics.checkNotNullParameter(function0, "onRefreshButtonClickListener");
        this.f = function1;
        this.g = function12;
        this.h = function0;
    }

    public final boolean a() {
        return !Intrinsics.areEqual(this.e, HistoryLoadingState.Loaded.INSTANCE);
    }

    @Override // androidx.paging.PagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount() + (a() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (a() && i == getItemCount() - 1) {
            return 0;
        }
        PaymentHistoryListElement paymentHistoryListElement = (PaymentHistoryListElement) getItem(i);
        if (paymentHistoryListElement instanceof PaymentHistoryListElement.Header) {
            return 1;
        }
        if (paymentHistoryListElement instanceof PaymentHistoryListElement.Operation) {
            return 2;
        }
        if (paymentHistoryListElement instanceof PaymentHistoryListElement.Order) {
            return 3;
        }
        throw new IllegalStateException("Unknown item type");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof OrderViewHolder) {
            OrderViewHolder orderViewHolder = (OrderViewHolder) viewHolder;
            Object item = getItem(i);
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.avito.android.remote.model.payment.history.PaymentHistoryListElement.Order");
            PaymentHistoryListElement.Order order = (PaymentHistoryListElement.Order) item;
            Objects.requireNonNull(orderViewHolder);
            Intrinsics.checkNotNullParameter(order, "operation");
            TextViews.bindText$default(orderViewHolder.s, order.getAmount(), false, 2, null);
            TextViews.bindText$default(orderViewHolder.t, order.getTitle(), false, 2, null);
            TextViews.bindText$default(orderViewHolder.u, order.getDescription(), false, 2, null);
            TextViews.bindText$default(orderViewHolder.v, order.getDate(), false, 2, null);
            int ordinal = order.getStatus().ordinal();
            if (ordinal == 0) {
                Views.show(orderViewHolder.w);
                orderViewHolder.w.setImageDrawable(orderViewHolder.x.getContext().getDrawable(R.drawable.payment_state_time_24dp));
            } else if (ordinal == 1) {
                Views.hide(orderViewHolder.w);
            } else if (ordinal == 2) {
                Views.show(orderViewHolder.w);
                orderViewHolder.w.setImageDrawable(orderViewHolder.x.getContext().getDrawable(R.drawable.payment_state_error_24dp));
            } else if (ordinal == 3) {
                Views.show(orderViewHolder.w);
                orderViewHolder.w.setImageDrawable(orderViewHolder.x.getContext().getDrawable(R.drawable.payment_state_error_24dp));
            }
            orderViewHolder.x.setOnClickListener(new c(orderViewHolder, order));
        } else if (viewHolder instanceof OperationViewHolder) {
            OperationViewHolder operationViewHolder = (OperationViewHolder) viewHolder;
            Object item2 = getItem(i);
            Objects.requireNonNull(item2, "null cannot be cast to non-null type com.avito.android.remote.model.payment.history.PaymentHistoryListElement.Operation");
            PaymentHistoryListElement.Operation operation = (PaymentHistoryListElement.Operation) item2;
            Objects.requireNonNull(operationViewHolder);
            Intrinsics.checkNotNullParameter(operation, "operation");
            TextViews.bindText$default(operationViewHolder.s, operation.getAmount(), false, 2, null);
            TextViews.bindText$default(operationViewHolder.t, operation.getTitle(), false, 2, null);
            TextViews.bindText$default(operationViewHolder.u, operation.getDescription(), false, 2, null);
            TextViews.bindText$default(operationViewHolder.v, operation.getDate(), false, 2, null);
            int ordinal2 = operation.getStatus().ordinal();
            if (ordinal2 == 0) {
                Views.show(operationViewHolder.w);
                operationViewHolder.w.setImageDrawable(operationViewHolder.x.getContext().getDrawable(R.drawable.payment_state_time_24dp));
            } else if (ordinal2 == 1) {
                Views.hide(operationViewHolder.w);
            } else if (ordinal2 == 2) {
                Views.show(operationViewHolder.w);
                operationViewHolder.w.setImageDrawable(operationViewHolder.x.getContext().getDrawable(R.drawable.payment_state_error_24dp));
            } else if (ordinal2 == 3) {
                Views.show(operationViewHolder.w);
                operationViewHolder.w.setImageDrawable(operationViewHolder.x.getContext().getDrawable(R.drawable.payment_state_error_24dp));
            }
            operationViewHolder.x.setOnClickListener(new b(operationViewHolder, operation));
        } else if (viewHolder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
            Object item3 = getItem(i);
            Objects.requireNonNull(item3, "null cannot be cast to non-null type com.avito.android.remote.model.payment.history.PaymentHistoryListElement.Header");
            PaymentHistoryListElement.Header header = (PaymentHistoryListElement.Header) item3;
            Objects.requireNonNull(headerViewHolder);
            Intrinsics.checkNotNullParameter(header, TariffPackageInfoConverterKt.HEADER_STRING_ID);
            View view = headerViewHolder.s;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextViews.bindText$default((TextView) view, header.getTitle(), false, 2, null);
        } else if (viewHolder instanceof LoadingStateViewHolder) {
            LoadingStateViewHolder loadingStateViewHolder = (LoadingStateViewHolder) viewHolder;
            HistoryLoadingState historyLoadingState = this.e;
            Objects.requireNonNull(loadingStateViewHolder);
            Intrinsics.checkNotNullParameter(historyLoadingState, "historyLoadingState");
            if (historyLoadingState instanceof HistoryLoadingState.Loading) {
                Views.show(loadingStateViewHolder.s);
                Views.hide(loadingStateViewHolder.t);
            } else if (historyLoadingState instanceof HistoryLoadingState.Error) {
                Views.hide(loadingStateViewHolder.s);
                Views.show(loadingStateViewHolder.t);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return LoadingStateViewHolder.v.create(viewGroup, this.h);
        }
        if (i == 1) {
            return HeaderViewHolder.t.create(viewGroup);
        }
        if (i == 2) {
            return OperationViewHolder.z.create(viewGroup, this.g);
        }
        if (i == 3) {
            return OrderViewHolder.z.create(viewGroup, this.f);
        }
        throw new IllegalStateException("ViewTypeNotRegistered");
    }

    public final void setNetworkState(@NotNull HistoryLoadingState historyLoadingState) {
        Intrinsics.checkNotNullParameter(historyLoadingState, "historyLoadingState");
        HistoryLoadingState historyLoadingState2 = this.e;
        boolean a = a();
        this.e = historyLoadingState;
        if (a != a()) {
            if (a) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (a() && (!Intrinsics.areEqual(historyLoadingState2, historyLoadingState))) {
            notifyItemChanged(getItemCount() - 1);
        }
    }
}
