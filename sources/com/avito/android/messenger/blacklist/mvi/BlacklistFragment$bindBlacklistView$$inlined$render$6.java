package com.avito.android.messenger.blacklist.mvi;

import a2.b.a.a.a;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererWithDiff;
import com.avito.android.util.Logs;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022*\u0010\u0006\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \u0005*\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "StateT", "Item", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "accept", "(Lkotlin/Pair;)V", "com/avito/android/messenger/channels/mvi/common/v4/rendering/RendererKt$render$4", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BlacklistFragment$bindBlacklistView$$inlined$render$6<T> implements Consumer<Pair<? extends BlacklistPresenter.State, ? extends DiffUtil.DiffResult>> {
    public final /* synthetic */ RendererWithDiff a;
    public final /* synthetic */ String b;
    public final /* synthetic */ BehaviorRelay c;

    public BlacklistFragment$bindBlacklistView$$inlined$render$6(RendererWithDiff rendererWithDiff, String str, BehaviorRelay behaviorRelay) {
        this.a = rendererWithDiff;
        this.b = str;
        this.c = behaviorRelay;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Pair<? extends BlacklistPresenter.State, ? extends DiffUtil.DiffResult> pair) {
        Object component1 = pair.component1();
        RendererWithDiff rendererWithDiff = this.a;
        rendererWithDiff.getLastRenderedState(rendererWithDiff);
        this.a.render(component1, (DiffUtil.DiffResult) pair.component2());
        String str = this.b;
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" Rendered ");
        sb.append(component1);
        Logs.info$default(str, sb.toString(), null, 4, null);
        this.c.accept(Unit.INSTANCE);
    }
}
