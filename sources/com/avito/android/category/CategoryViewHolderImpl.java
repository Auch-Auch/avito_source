package com.avito.android.category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020\u0017¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0007R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/category/CategoryViewHolderImpl;", "Lcom/avito/android/category/BaseViewHolderImpl;", "Lcom/avito/android/category/CategoryViewHolder;", "", "isVisible", "", "setDividerVisibility", "(Z)V", "isCollapsed", "setArrowCollapsed", "", "colorAttr", "setTextColor", "(I)V", "", "text", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "func", "setCategoryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setArrowVisibility", "Landroid/view/View;", "w", "Landroid/view/View;", "divider", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", VKApiConst.VERSION, "Landroid/widget/ImageView;", "arrow", "Landroid/content/Context;", "t", "Landroid/content/Context;", "context", "view", "<init>", "(Landroid/view/View;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryViewHolderImpl extends BaseViewHolderImpl implements CategoryViewHolder {
    public final Context t;
    public final TextView u;
    public final ImageView v;
    public final View w;

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
    public CategoryViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.t = context;
        View findViewById = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f35arrow);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.v = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.divider);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.w = findViewById3;
    }

    @Override // com.avito.android.category.CategoryViewHolder
    public void setArrowCollapsed(boolean z) {
        Drawable drawable = null;
        if (z) {
            Drawable drawable2 = getView().getContext().getDrawable(R.drawable.ic_expand_24);
            if (drawable2 != null) {
                Context context = getView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
            }
            this.v.setBackgroundDrawable(drawable);
            return;
        }
        Drawable drawable3 = getView().getContext().getDrawable(R.drawable.ic_collapse_24);
        if (drawable3 != null) {
            Context context2 = getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            drawable = DrawablesKt.wrapForTinting(drawable3, Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28));
        }
        this.v.setBackgroundDrawable(drawable);
    }

    @Override // com.avito.android.category.CategoryViewHolder
    public void setArrowVisibility(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.category.CategoryViewHolder
    public void setCategoryClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        getView().setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.category.CategoryViewHolder
    public void setDividerVisibility(boolean z) {
        Views.setVisible(this.w, z);
    }

    @Override // com.avito.android.category.CategoryViewHolder
    public void setText(@Nullable String str) {
        this.u.setText(str);
    }

    @Override // com.avito.android.category.CategoryViewHolder
    public void setTextColor(int i) {
        this.u.setTextColor(Contexts.getColorByAttr(this.t, i));
    }
}
