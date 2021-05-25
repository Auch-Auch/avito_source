package com.avito.android.category;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/category/SubcategoryViewHolderImpl;", "Lcom/avito/android/category/BaseViewHolderImpl;", "Lcom/avito/android/category/SubcategoryViewHolder;", "", "isVisible", "", "setDividerVisibility", "(Z)V", "", "colorAttr", "setTextColor", "(I)V", "", "text", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "func", "setSubcategoryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "t", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "title", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "divider", "view", "<init>", "(Landroid/view/View;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class SubcategoryViewHolderImpl extends BaseViewHolderImpl implements SubcategoryViewHolder {
    public final Context t;
    public final TextView u;
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
    public SubcategoryViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.t = context;
        View findViewById = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.divider)");
        this.v = findViewById2;
    }

    @Override // com.avito.android.category.SubcategoryViewHolder
    public void setDividerVisibility(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.category.SubcategoryViewHolder
    public void setSubcategoryClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        getView().setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.category.SubcategoryViewHolder
    public void setText(@Nullable String str) {
        this.u.setText(str);
    }

    @Override // com.avito.android.category.SubcategoryViewHolder
    public void setTextColor(int i) {
        this.u.setTextColor(Contexts.getColorByAttr(this.t, i));
    }
}
