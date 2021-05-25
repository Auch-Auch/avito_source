package com.avito.android.publish.residential_complex_search.adapter.title;

import android.view.View;
import android.widget.TextView;
import com.avito.android.publish.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestView;", "", "name", "", "bindName", "(Ljava/lang/String;)V", "description", "bindDescription", "Lkotlin/Function0;", "action", "setClickAction", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "descriptionTextView", "s", "nameTextView", "Landroid/view/View;", "u", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSuggestViewImpl extends BaseViewHolder implements ResidentialComplexSuggestView {
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
    public ResidentialComplexSuggestViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(R.id.name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.name)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.description)");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestView
    public void bindDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestView
    public void bindName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @NotNull
    public final View getView() {
        return this.u;
    }

    @Override // com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestView
    public void setClickAction(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.u.setOnClickListener(new a(function0));
    }
}
