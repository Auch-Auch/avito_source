package com.avito.android.home.appending_item.retry;

import android.view.View;
import android.widget.TextView;
import com.avito.android.home.appending_item.retry.AppendingRetryItemView;
import com.avito.android.serp.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/home/appending_item/retry/AppendingRetryItemImpl;", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lkotlin/Function0;", "", "callback", "setRetryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "buttonRetry", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public class AppendingRetryItemImpl extends BaseViewHolder implements AppendingRetryItemView {
    public final TextView s;

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
    public AppendingRetryItemImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.panel_error_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.panel_error_retry)");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AppendingRetryItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.home.appending_item.retry.AppendingRetryItemView
    public void setRetryClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.s.setOnClickListener(new a(function0));
    }
}
