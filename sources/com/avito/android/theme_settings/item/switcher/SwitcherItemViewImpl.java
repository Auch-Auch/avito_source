package com.avito.android.theme_settings.item.switcher;

import android.view.View;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/theme_settings/item/switcher/SwitcherItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/theme_settings/item/switcher/SwitcherItemView;", "", "checked", "", "setChecked", "(Z)V", "enabled", "setEnabled", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "s", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "getSwitcherListItem", "()Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcherListItem", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherItemViewImpl extends BaseViewHolder implements SwitcherItemView {
    @NotNull
    public final SwitcherListItem s;

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
    public SwitcherItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (SwitcherListItem) view;
    }

    @NotNull
    public final SwitcherListItem getSwitcherListItem() {
        return this.s;
    }

    @Override // com.avito.android.theme_settings.item.switcher.SwitcherItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.theme_settings.item.switcher.SwitcherItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.theme_settings.item.switcher.SwitcherItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.theme_settings.item.switcher.SwitcherItemView
    public void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        this.s.setMessage(str);
    }

    @Override // com.avito.android.theme_settings.item.switcher.SwitcherItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
