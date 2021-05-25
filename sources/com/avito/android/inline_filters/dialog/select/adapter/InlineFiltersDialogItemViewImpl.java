package com.avito.android.inline_filters.dialog.select.adapter;

import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView;
import com.avito.android.lib.design.list_item.CheckboxListItem;
import com.avito.android.lib.design.list_item.CheckmarkListItem;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemViewImpl;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isChecked", "setChecked", "(Z)V", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersDialogItemViewImpl extends BaseViewHolder implements ItemView, InlineFiltersDialogItemView {
    public final View s;

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
    public InlineFiltersDialogItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view;
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void enableMultiselect(boolean z) {
        InlineFiltersDialogItemView.DefaultImpls.enableMultiselect(this, z);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setChecked(boolean z) {
        View view = this.s;
        if (!(view instanceof Checkable)) {
            view = null;
        }
        Checkable checkable = (Checkable) view;
        if (checkable != null) {
            checkable.setChecked(z);
        }
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setImage(@Nullable Image image) {
        InlineFiltersDialogItemView.DefaultImpls.setImage(this, image);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setOnLayoutFinishedListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        InlineFiltersDialogItemView.DefaultImpls.setOnLayoutFinishedListener(this, function0);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setSecondaryText(@Nullable String str) {
        InlineFiltersDialogItemView.DefaultImpls.setSecondaryText(this, str);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        View view = this.s;
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        } else if (view instanceof CheckboxListItem) {
            ((CheckboxListItem) view).setTitle(str);
        } else if (view instanceof CheckmarkListItem) {
            ((CheckmarkListItem) view).setTitle(str);
        } else {
            view.setContentDescription(str);
        }
    }
}
