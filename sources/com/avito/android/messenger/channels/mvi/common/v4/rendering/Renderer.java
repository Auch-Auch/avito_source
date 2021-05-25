package com.avito.android.messenger.channels.mvi.common.v4.rendering;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\t\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nR(\u0010\u000f\u001a\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "", "StateT", "state", "", "render", "(Ljava/lang/Object;)V", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Ljava/lang/Object;Ljava/lang/Object;)V", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Ljava/lang/Object;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Ljava/lang/Object;)V", "lastRenderedState", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface Renderer<StateT> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <StateT> void render(@NotNull Renderer<StateT> renderer, @NotNull StateT statet) {
            Intrinsics.checkNotNullParameter(statet, "state");
            renderer.doRender(renderer, renderer.getLastRenderedState(renderer), statet);
            renderer.setLastRenderedState(renderer, statet);
        }
    }

    void doRender(@NotNull Renderer<StateT> renderer, @Nullable StateT statet, @NotNull StateT statet2);

    @Nullable
    StateT getLastRenderedState(@NotNull Renderer<StateT> renderer);

    void render(@NotNull StateT statet);

    void setLastRenderedState(@NotNull Renderer<StateT> renderer, @Nullable StateT statet);
}
