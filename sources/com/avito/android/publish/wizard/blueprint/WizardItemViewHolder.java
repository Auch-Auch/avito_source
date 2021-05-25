package com.avito.android.publish.wizard.blueprint;

import android.view.View;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/wizard/blueprint/WizardItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/wizard/blueprint/WizardItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubtitle", "Lkotlin/Function0;", "func", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardItemViewHolder extends BaseViewHolder implements WizardItemView {
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
    public WizardItemViewHolder(@NotNull View view) {
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

    @Override // com.avito.android.publish.wizard.blueprint.WizardItemView
    public void setOnItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.publish.wizard.blueprint.WizardItemView
    public void setSubtitle(@Nullable String str) {
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.publish.wizard.blueprint.WizardItemView
    public void setTitle(@Nullable String str) {
        this.s.setTitle(str);
    }
}
