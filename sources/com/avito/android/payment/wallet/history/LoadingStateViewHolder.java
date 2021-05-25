package com.avito.android.payment.wallet.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.payment.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class LoadingStateViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public static final Companion v = new Companion(null);
    public final ProgressBar s;
    public final LinearLayout t;
    public final View u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/wallet/history/LoadingStateViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "parent", "Lkotlin/Function0;", "", "refreshButtonClickListener", "Lcom/avito/android/payment/wallet/history/LoadingStateViewHolder;", "create", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)Lcom/avito/android/payment/wallet/history/LoadingStateViewHolder;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LoadingStateViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(function0, "refreshButtonClickListener");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.payment_history_loading_state, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new LoadingStateViewHolder(inflate, function0);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingStateViewHolder(@NotNull View view, @NotNull Function0<Unit> function0) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "refreshButtonClickListener");
        this.u = view;
        this.s = (ProgressBar) view.findViewById(R.id.progress_bar);
        ((Button) view.findViewById(R.id.refresh_button)).setOnClickListener(new a(function0));
        Unit unit = Unit.INSTANCE;
        this.t = (LinearLayout) view.findViewById(R.id.refresh);
    }
}
