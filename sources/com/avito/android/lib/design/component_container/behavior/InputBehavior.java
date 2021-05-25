package com.avito.android.lib.design.component_container.behavior;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import com.avito.android.lib.design.component_container.ComponentBehavior;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/design/component_container/behavior/InputBehavior;", "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "Lcom/avito/android/lib/design/input/Input;", "view", "", "onAttachView", "(Lcom/avito/android/lib/design/input/Input;)V", "onDetachView", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "state", "onStateChanged", "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;)V", "Landroid/text/TextWatcher;", "watcher", "Landroid/text/TextWatcher;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public class InputBehavior extends ComponentBehavior<Input> {
    private final TextWatcher watcher = new TextWatcher(this) { // from class: com.avito.android.lib.design.component_container.behavior.InputBehavior$watcher$1
        @NotNull
        public String a = "";
        public final /* synthetic */ InputBehavior b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.b = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            String str;
            if (charSequence == null || (str = charSequence.toString()) == null) {
                str = "";
            }
            this.a = str;
        }

        @NotNull
        public final String getBeforeText() {
            return this.a;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            String str;
            String str2 = this.a;
            if (charSequence == null || (str = charSequence.toString()) == null) {
                str = "";
            }
            if (!Intrinsics.areEqual(str2, str)) {
                int autoResetCondition = this.b.getAutoResetCondition();
                if (autoResetCondition == 1) {
                    ComponentContainer.State state = this.b.getState();
                    ComponentContainer.State state2 = ComponentContainer.State.NORMAL;
                    if (state != state2) {
                        this.b.setState(state2);
                        InputBehavior.access$notifyValueReset(this.b);
                    }
                } else if (autoResetCondition == 2) {
                    this.b.setState(ComponentContainer.State.NORMAL);
                    InputBehavior.access$notifyValueReset(this.b);
                }
            }
        }

        public final void setBeforeText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }
    };

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputBehavior(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.avito.android.lib.design.component_container.ComponentBehavior
    public void onStateChanged(@NotNull ComponentContainer.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Input input = (Input) getView();
        if (input != null) {
            input.setState(state.getIntArray());
        }
    }

    public void onAttachView(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "view");
        input.addTextChangedListener(this.watcher);
        onStateChanged(getState());
    }

    public void onDetachView(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "view");
        input.removeTextChangedListener(this.watcher);
    }
}
