package com.avito.android.delivery.suggest.konveyor.suggest;

import android.view.View;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "subTitle", "setData", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "titleTextView", "Landroid/view/View;", "u", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "t", "subTitleTextView", "<init>", "(Landroid/view/View;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestItemViewHolder extends BaseViewHolder implements SuggestItemView {
    public final TextView s;
    public final TextView t;
    @NotNull
    public final View u;

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
    public SuggestItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.sub_title);
    }

    @NotNull
    public final View getView() {
        return this.u;
    }

    @Override // com.avito.android.delivery.suggest.konveyor.suggest.SuggestItemView
    public void setActionClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.delivery.suggest.konveyor.suggest.SuggestItemView
    public void setData(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleTextView");
        textView.setText(str);
        TextView textView2 = this.t;
        Intrinsics.checkNotNullExpressionValue(textView2, "subTitleTextView");
        textView2.setText(str2);
    }
}
