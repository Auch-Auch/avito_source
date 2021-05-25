package ru.avito.component.input;

import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0017\u0012\u0006\u0010)\u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0017\u0010\fJ\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0018\u0010\fR\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0016\u0010)\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lru/avito/component/input/InputWithStatus;", "Lru/avito/component/input/Input;", "Lru/avito/component/input/InputStatus;", "Lru/avito/component/input/InputState;", "state", "", "setState", "(Lru/avito/component/input/InputState;)V", "setStateWithAnimation", "", "text", "bindSubtitle", "(Ljava/lang/String;)V", "bindTitle", "", "count", "setMinLinesCount", "(I)V", "setPlaceholder", "", "singleLine", "setSingleLine", "(Z)V", "setText", "bindStatus", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/core/Observable;", "getStateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "stateChanges", "c", "Lru/avito/component/input/InputStatus;", "status", "getCurrentState", "()Lru/avito/component/input/InputState;", "currentState", "getTextChanges", "textChanges", AuthSource.BOOKING_ORDER, "Lru/avito/component/input/Input;", "input", "<init>", "(Lru/avito/component/input/Input;Lru/avito/component/input/InputStatus;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InputWithStatus implements Input, InputStatus {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Observable<InputState> a;
    public final Input b;
    public final InputStatus c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/component/input/InputWithStatus$Companion;", "", "Landroid/view/View;", "view", "Lru/avito/component/input/InputWithStatus;", "createFromContainerView", "(Landroid/view/View;)Lru/avito/component/input/InputWithStatus;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final InputWithStatus createFromContainerView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            BasicInput createFromContainerView = BasicInput.Companion.createFromContainerView(view);
            View findViewById = view.findViewById(R.id.status_view);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return new InputWithStatus(createFromContainerView, new InputStatusImpl((TextView) findViewById));
        }

        public Companion(j jVar) {
        }
    }

    public InputWithStatus(@NotNull Input input, @NotNull InputStatus inputStatus) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(inputStatus, "status");
        this.b = input;
        this.c = inputStatus;
        this.a = input.getStateChanges();
    }

    @Override // ru.avito.component.input.InputStatus
    public void bindStatus(@Nullable String str) {
        this.c.bindStatus(str);
    }

    @Override // ru.avito.component.input.InputLabel
    public void bindSubtitle(@Nullable String str) {
        this.b.bindSubtitle(str);
    }

    @Override // ru.avito.component.input.InputLabel
    public void bindTitle(@Nullable String str) {
        this.b.bindTitle(str);
    }

    @Override // ru.avito.component.input.Stateful
    @NotNull
    public InputState getCurrentState() {
        return this.b.getCurrentState();
    }

    @Override // ru.avito.component.input.Stateful
    @NotNull
    public Observable<InputState> getStateChanges() {
        return this.a;
    }

    @Override // ru.avito.component.input.Input
    @NotNull
    public Observable<String> getTextChanges() {
        return this.b.getTextChanges();
    }

    @Override // ru.avito.component.input.Input
    public void setMinLinesCount(int i) {
        this.b.setMinLinesCount(i);
    }

    @Override // ru.avito.component.input.Input
    public void setPlaceholder(@Nullable String str) {
        this.b.setPlaceholder(str);
    }

    @Override // ru.avito.component.input.Input
    public void setSingleLine(boolean z) {
        this.b.setSingleLine(z);
    }

    @Override // ru.avito.component.input.Stateful
    public void setState(@NotNull InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "state");
        this.b.setState(inputState);
        this.c.setState(inputState);
    }

    @Override // ru.avito.component.input.Stateful
    public void setStateWithAnimation(@NotNull InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "state");
        this.b.setStateWithAnimation(inputState);
        this.c.setState(inputState);
    }

    @Override // ru.avito.component.input.Input
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.b.setText(str);
    }
}
