package com.avito.android.select.bottom_sheet.blueprints;

import android.view.View;
import com.avito.android.lib.design.list_item.CheckmarkListItem;
import com.avito.android.remote.model.Image;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "isChecked", "setChecked", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/list_item/CheckmarkListItem;", "s", "Lcom/avito/android/lib/design/list_item/CheckmarkListItem;", "listItem", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class CheckableItemViewImpl extends BaseViewHolder implements CheckableItemView {
    public final CheckmarkListItem s;

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
    public CheckableItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (CheckmarkListItem) view;
    }

    @Override // com.avito.android.select.bottom_sheet.blueprints.CheckableItemView
    public void enableMultiselect(boolean z) {
        CheckableItemView.DefaultImpls.enableMultiselect(this, z);
    }

    @Override // com.avito.android.select.bottom_sheet.blueprints.CheckableItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.select.bottom_sheet.blueprints.CheckableItemView
    public void setImage(@Nullable Image image) {
        CheckableItemView.DefaultImpls.setImage(this, image);
    }

    @Override // com.avito.android.select.bottom_sheet.blueprints.CheckableItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.select.bottom_sheet.blueprints.CheckableItemView
    public void setSubtitle(@Nullable String str) {
        CheckableItemView.DefaultImpls.setSubtitle(this, str);
    }

    @Override // com.avito.android.select.bottom_sheet.blueprints.CheckableItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
