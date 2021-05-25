package com.avito.android.blueprints.switcher;

import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemView;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b#\u0010'J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0016\u0010\nR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemViewImpl;", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "", "value", "", "bindHeader", "(Ljava/lang/String;)V", "setTitle", "", "setSubTitle", "(Ljava/lang/CharSequence;)V", "", "isChecked", "setChecked", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckListener", "(Lkotlin/jvm/functions/Function1;)V", "message", "setErrorState", "setWarningState", "setNormalState", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "checkedListener", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "c", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcherListItem", "<init>", "(Lcom/avito/android/lib/design/component_container/ComponentContainer;Lcom/avito/android/lib/design/list_item/SwitcherListItem;)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateSwitcherItemViewImpl implements MultiStateSwitcherItemView {
    public CompoundButtonListItem.OnCheckedChangeListener a;
    public final ComponentContainer b;
    public final SwitcherListItem c;

    public MultiStateSwitcherItemViewImpl(@NotNull ComponentContainer componentContainer, @NotNull SwitcherListItem switcherListItem) {
        Intrinsics.checkNotNullParameter(componentContainer, "container");
        Intrinsics.checkNotNullParameter(switcherListItem, "switcherListItem");
        this.b = componentContainer;
        this.c = switcherListItem;
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void bindHeader(@Nullable String str) {
        this.b.setTitle(str);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MultiStateSwitcherItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setCheckListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        CompoundButtonListItem.OnCheckedChangeListener onCheckedChangeListener = this.a;
        if (onCheckedChangeListener != null) {
            this.c.removeOnCheckedChangeListener(onCheckedChangeListener);
        }
        MultiStateSwitcherItemViewImpl$setCheckListener$2 multiStateSwitcherItemViewImpl$setCheckListener$2 = new CompoundButtonListItem.OnCheckedChangeListener(function1) { // from class: com.avito.android.blueprints.switcher.MultiStateSwitcherItemViewImpl$setCheckListener$2
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
                Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
                this.a.invoke(Boolean.valueOf(z));
            }
        };
        this.c.addOnCheckedChangeListener(multiStateSwitcherItemViewImpl$setCheckListener$2);
        Unit unit = Unit.INSTANCE;
        this.a = multiStateSwitcherItemViewImpl$setCheckListener$2;
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setChecked(boolean z) {
        this.c.setChecked(z);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.b, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.b.showNormalForAll(charSequence);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setSubTitle(@Nullable CharSequence charSequence) {
        this.c.setLink(charSequence);
        SwitcherListItem switcherListItem = this.c;
        MovementMethod instance = LinkMovementMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "LinkMovementMethod.getInstance()");
        switcherListItem.setLinkMovementMethod(instance);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.c.setTitle(str);
    }

    @Override // com.avito.android.blueprints.switcher.MultiStateSwitcherItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.b, charSequence, null, 2, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultiStateSwitcherItemViewImpl(@org.jetbrains.annotations.NotNull android.view.View r3) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = com.avito.android.item_temporary.R.id.container
            android.view.View r0 = r3.findViewById(r0)
            java.lang.String r1 = "view.findViewById(R.id.container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.lib.design.component_container.ComponentContainer r0 = (com.avito.android.lib.design.component_container.ComponentContainer) r0
            int r1 = com.avito.android.item_temporary.R.id.switcher
            android.view.View r3 = r3.findViewById(r1)
            java.lang.String r1 = "view.findViewById(R.id.switcher)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            com.avito.android.lib.design.list_item.SwitcherListItem r3 = (com.avito.android.lib.design.list_item.SwitcherListItem) r3
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.blueprints.switcher.MultiStateSwitcherItemViewImpl.<init>(android.view.View):void");
    }
}
