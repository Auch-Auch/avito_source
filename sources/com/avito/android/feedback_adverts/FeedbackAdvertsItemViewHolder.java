package com.avito.android.feedback_adverts;

import android.view.View;
import android.widget.TextView;
import com.avito.android.ui.view.CheckableLinearLayout;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010%\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setPrice", "Lkotlin/Function0;", "func", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "selected", "setSelected", "(Z)V", "Lcom/avito/android/ui/view/CheckableLinearLayout;", "u", "Lcom/avito/android/ui/view/CheckableLinearLayout;", "getCheckableContent", "()Lcom/avito/android/ui/view/CheckableLinearLayout;", "checkableContent", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "t", "getPrice", "price", "<init>", "(Landroid/view/View;)V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsItemViewHolder extends BaseViewHolder implements FeedbackAdvertsItemView {
    @NotNull
    public final TextView s;
    @NotNull
    public final TextView t;
    @NotNull
    public final CheckableLinearLayout u;
    @NotNull
    public final View v;

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
    public FeedbackAdvertsItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.checkable_content);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.ui.view.CheckableLinearLayout");
        this.u = (CheckableLinearLayout) findViewById3;
    }

    @NotNull
    public final CheckableLinearLayout getCheckableContent() {
        return this.u;
    }

    @NotNull
    public final TextView getPrice() {
        return this.t;
    }

    @NotNull
    public final TextView getTitle() {
        return this.s;
    }

    @NotNull
    public final View getView() {
        return this.v;
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsItemView
    public void setOnItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        this.v.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsItemView
    public void setPrice(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsItemView
    public void setSelected(boolean z) {
        this.u.setChecked(z);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}
