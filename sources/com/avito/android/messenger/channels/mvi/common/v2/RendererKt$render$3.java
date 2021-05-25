package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.recyclerview.widget.DiffUtil;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0006*\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "StateT", "Item", "Lkotlin/Pair;", "<name for destructuring parameter 0>", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Pair;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class RendererKt$render$3<T, R> implements Function<Pair<? extends StateT, ? extends StateT>, Pair<? extends StateT, ? extends DiffUtil.DiffResult>> {
    public final /* synthetic */ Differ a;

    public RendererKt$render$3(Differ differ) {
        this.a = differ;
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Pair) ((Pair) obj));
    }

    public final Pair<StateT, DiffUtil.DiffResult> apply(@NotNull Pair<? extends StateT, ? extends StateT> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        Object component1 = pair.component1();
        Object component2 = pair.component2();
        return TuplesKt.to(component2, Differ.calculateDiff$default(this.a, component1, component2, false, 4, null));
    }
}
