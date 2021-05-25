package ru.avito.component.input;

import android.content.Context;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.jakewharton.rxrelay3.BehaviorRelay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014RD\u0010\u001b\u001a0\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00020\u0002 \u0017*\u0017\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0016¢\u0006\u0002\b\u00180\u0016¢\u0006\u0002\b\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lru/avito/component/input/InputStatusImpl;", "Lru/avito/component/input/InputStatus;", "Lru/avito/component/input/InputState;", "state", "", "setState", "(Lru/avito/component/input/InputState;)V", "", "text", "bindStatus", "(Ljava/lang/String;)V", "setStateWithAnimation", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "statusView", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getStateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "stateChanges", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "relay", "getCurrentState", "()Lru/avito/component/input/InputState;", "currentState", "<init>", "(Landroid/widget/TextView;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InputStatusImpl implements InputStatus {
    public final BehaviorRelay<InputState> a;
    @NotNull
    public final Observable<InputState> b;
    public final TextView c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            InputState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public InputStatusImpl(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "statusView");
        this.c = textView;
        BehaviorRelay<InputState> create = BehaviorRelay.create();
        this.a = create;
        setState(InputState.NORMAL);
        Observable<InputState> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "relay.hide()");
        this.b = hide;
    }

    @Override // ru.avito.component.input.InputStatus
    public void bindStatus(@Nullable String str) {
        TextViews.bindText$default(this.c, str, false, 2, null);
    }

    @Override // ru.avito.component.input.Stateful
    @NotNull
    public InputState getCurrentState() {
        BehaviorRelay<InputState> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "relay");
        InputState value = behaviorRelay.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "relay.value");
        return value;
    }

    @Override // ru.avito.component.input.Stateful
    @NotNull
    public Observable<InputState> getStateChanges() {
        return this.b;
    }

    @Override // ru.avito.component.input.Stateful
    public void setState(@NotNull InputState inputState) {
        int i;
        Intrinsics.checkNotNullParameter(inputState, "state");
        TextView textView = this.c;
        int ordinal = inputState.ordinal();
        if (ordinal == 0) {
            i = R.attr.gray48;
        } else if (ordinal == 1) {
            i = R.attr.red;
        } else if (ordinal == 2) {
            i = R.attr.gray48;
        } else if (ordinal == 3) {
            i = R.attr.gray48;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "statusView.context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
        this.a.accept(inputState);
    }

    @Override // ru.avito.component.input.Stateful
    public void setStateWithAnimation(@NotNull InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "state");
        setState(inputState);
    }
}
