package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererWithDiff;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\t\u0010\b\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "U", "R", "t", "u", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/avito/android/messenger/channels/mvi/common/v4/rendering/RendererKt$render$$inlined$zipWith$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BlacklistFragment$bindBlacklistView$$inlined$render$4<T1, T2, R> implements BiFunction<BlacklistPresenter.State, Unit, R> {
    public final /* synthetic */ RendererWithDiff a;

    public BlacklistFragment$bindBlacklistView$$inlined$render$4(RendererWithDiff rendererWithDiff) {
        this.a = rendererWithDiff;
    }

    @Override // io.reactivex.functions.BiFunction
    public final R apply(BlacklistPresenter.State state, Unit unit) {
        RendererWithDiff rendererWithDiff = this.a;
        return (R) TuplesKt.to(rendererWithDiff.getLastRenderedState(rendererWithDiff), state);
    }
}
