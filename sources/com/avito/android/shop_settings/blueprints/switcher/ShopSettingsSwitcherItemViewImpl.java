package com.avito.android.shop_settings.blueprints.switcher;

import android.view.View;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.service_subscription.R;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u0011\u001a\u00020\u00052\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemViewImpl;", "Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setMessage", "", "value", "setValue", "(Z)V", "isEnabled", "setEnabled", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "t", "Lkotlin/jvm/functions/Function1;", "checkedListener", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "s", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switchView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSwitcherItemViewImpl extends BaseViewHolder implements ShopSettingsSwitcherItemView {
    public final SwitcherListItem s;
    public Function1<? super Boolean, Unit> t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopSettingsSwitcherItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.shop_settings_switcher);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.SwitcherListItem");
        SwitcherListItem switcherListItem = (SwitcherListItem) findViewById;
        this.s = switcherListItem;
        switcherListItem.addOnCheckedChangeListener(new CompoundButtonListItem.OnCheckedChangeListener(this) { // from class: com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemViewImpl.1
            public final /* synthetic */ ShopSettingsSwitcherItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
                Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
                Function1 function1 = this.a.t;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Boolean.valueOf(z));
                }
            }
        });
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShopSettingsSwitcherItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemView
    public void setMessage(@Nullable String str) {
        this.s.setMessage(str);
    }

    @Override // com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemView
    public void setValue(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemView
    public void setValueChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.t = function1;
    }
}
