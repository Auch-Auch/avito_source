package com.avito.android.lib.design.component_container.behavior;

import android.content.Context;
import com.avito.android.lib.design.component_container.ComponentBehavior;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/design/component_container/behavior/CompoundButtonListItemBehavior;", "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "view", "", "onAttachView", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;)V", "onDetachView", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "state", "onStateChanged", "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;)V", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public class CompoundButtonListItemBehavior extends ComponentBehavior<CompoundButtonListItem> {
    private final CompoundButtonListItem.OnCheckedChangeListener listener = new CompoundButtonListItem.OnCheckedChangeListener(this) { // from class: com.avito.android.lib.design.component_container.behavior.CompoundButtonListItemBehavior$listener$1
        public final /* synthetic */ CompoundButtonListItemBehavior a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
        public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
            Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
            int autoResetCondition = this.a.getAutoResetCondition();
            if (autoResetCondition == 1) {
                ComponentContainer.State state = this.a.getState();
                ComponentContainer.State state2 = ComponentContainer.State.NORMAL;
                if (state != state2) {
                    this.a.setState(state2);
                    CompoundButtonListItemBehavior.access$notifyValueReset(this.a);
                }
            } else if (autoResetCondition == 2) {
                this.a.setState(ComponentContainer.State.NORMAL);
                CompoundButtonListItemBehavior.access$notifyValueReset(this.a);
            }
        }
    };

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompoundButtonListItemBehavior(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.avito.android.lib.design.component_container.ComponentBehavior
    public void onStateChanged(@NotNull ComponentContainer.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    public void onAttachView(@NotNull CompoundButtonListItem compoundButtonListItem) {
        Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
        compoundButtonListItem.addOnCheckedChangeListener(this.listener);
        onStateChanged(getState());
    }

    public void onDetachView(@NotNull CompoundButtonListItem compoundButtonListItem) {
        Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
        compoundButtonListItem.removeOnCheckedChangeListener(this.listener);
    }
}
