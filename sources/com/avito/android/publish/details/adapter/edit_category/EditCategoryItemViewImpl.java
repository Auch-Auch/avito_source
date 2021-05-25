package com.avito.android.publish.details.adapter.edit_category;

import android.text.TextUtils;
import android.view.View;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemView;", "", "text", "", "setTag", "(Ljava/lang/String;)V", "", "setText", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setNormalState", "()V", "error", "setErrorState", "", "isEnabled", "setEnabled", "(Z)V", "onUnbind", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "Lcom/avito/android/lib/design/input/Input;", "t", "Lcom/avito/android/lib/design/input/Input;", "select", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class EditCategoryItemViewImpl extends BaseViewHolder implements EditCategoryItemView {
    public final ComponentContainer s;
    public final Input t;

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
    public EditCategoryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        ComponentContainer componentContainer = (ComponentContainer) view;
        this.s = componentContainer;
        View findViewById = view.findViewById(R.id.select);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById;
        this.t = input;
        componentContainer.setTitle(com.avito.android.publish.R.string.category_title);
        input.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.t.setOnClickListener(null);
    }

    @Override // com.avito.android.publish.details.adapter.edit_category.EditCategoryItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.publish.details.adapter.edit_category.EditCategoryItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "error");
        ComponentContainer.showErrorForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.publish.details.adapter.edit_category.EditCategoryItemView
    public void setNormalState() {
        ComponentContainer.showNormalForAll$default(this.s, null, 1, null);
    }

    @Override // com.avito.android.publish.details.adapter.edit_category.EditCategoryItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.publish.details.adapter.edit_category.EditCategoryItemView
    public void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setTag(str);
    }

    @Override // com.avito.android.publish.details.adapter.edit_category.EditCategoryItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Input.setText$default(this.t, charSequence, false, 2, null);
    }
}
