package ru.avito.component.input;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lru/avito/component/input/Stateful;", "", "Lru/avito/component/input/InputState;", "state", "", "setState", "(Lru/avito/component/input/InputState;)V", "setStateWithAnimation", "getCurrentState", "()Lru/avito/component/input/InputState;", "currentState", "Lio/reactivex/rxjava3/core/Observable;", "getStateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "stateChanges", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface Stateful {
    @NotNull
    InputState getCurrentState();

    @NotNull
    Observable<InputState> getStateChanges();

    void setState(@NotNull InputState inputState);

    void setStateWithAnimation(@NotNull InputState inputState);
}
