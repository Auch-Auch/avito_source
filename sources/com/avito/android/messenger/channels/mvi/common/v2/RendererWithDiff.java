package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000b\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0011\u001a\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;", "", "StateT", "state", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "", "render", "(Ljava/lang/Object;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;Ljava/lang/Object;Ljava/lang/Object;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;)Ljava/lang/Object;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;Ljava/lang/Object;)V", "lastRenderedState", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface RendererWithDiff<StateT> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <StateT> void render(@NotNull RendererWithDiff<StateT> rendererWithDiff, @NotNull StateT statet, @Nullable DiffUtil.DiffResult diffResult) {
            Intrinsics.checkNotNullParameter(statet, "state");
            rendererWithDiff.doRender(rendererWithDiff, rendererWithDiff.getLastRenderedState(rendererWithDiff), statet, diffResult);
            rendererWithDiff.setLastRenderedState(rendererWithDiff, statet);
        }
    }

    void doRender(@NotNull RendererWithDiff<StateT> rendererWithDiff, @Nullable StateT statet, @NotNull StateT statet2, @Nullable DiffUtil.DiffResult diffResult);

    @Nullable
    StateT getLastRenderedState(@NotNull RendererWithDiff<StateT> rendererWithDiff);

    void render(@NotNull StateT statet, @Nullable DiffUtil.DiffResult diffResult);

    void setLastRenderedState(@NotNull RendererWithDiff<StateT> rendererWithDiff, @Nullable StateT statet);
}
