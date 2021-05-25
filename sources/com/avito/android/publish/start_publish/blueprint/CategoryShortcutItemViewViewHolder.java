package com.avito.android.publish.start_publish.blueprint;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemViewViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "", "iconId", "setIcon", "(I)V", "Lkotlin/Function0;", "func", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryShortcutItemViewViewHolder extends BaseViewHolder implements CategoryShortcutItemView {
    public final ListItem s;
    @NotNull
    public final View t;

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
    public CategoryShortcutItemViewViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.ListItem");
        this.s = (ListItem) view;
    }

    @NotNull
    public final View getView() {
        return this.t;
    }

    @Override // com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemView
    public void setIcon(@DrawableRes int i) {
        Drawable drawable;
        ListItem listItem = this.s;
        Drawable drawable2 = ContextCompat.getDrawable(this.t.getContext(), i);
        if (drawable2 != null) {
            Context context = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, R.attr.black));
        } else {
            drawable = null;
        }
        ListItem.setImageDrawable$default(listItem, drawable, null, 2, null);
    }

    @Override // com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemView
    public void setOnItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemView
    public void setTitle(@Nullable String str) {
        this.s.setTitle(str);
    }
}
