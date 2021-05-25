package com.avito.android.messenger.channels.mvi.presenter;

import arrow.core.Either;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0007\u001a\u00020\u00022&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Larrow/core/Either;", "", "", "kotlin.jvm.PlatformType", "result", "accept", "(Larrow/core/Either;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListPresenterImpl$subscribeToChannelDeleteResults$1<T> implements Consumer<Either<? extends Throwable, ? extends Unit>> {
    public final /* synthetic */ ChannelsListPresenterImpl a;

    public ChannelsListPresenterImpl$subscribeToChannelDeleteResults$1(ChannelsListPresenterImpl channelsListPresenterImpl) {
        this.a = channelsListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Either<? extends Throwable, ? extends Unit> either) {
        accept((Either<? extends Throwable, Unit>) either);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.Formatter */
    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Either<? extends Throwable, Unit> either) {
        if (either instanceof Either.Right) {
            Unit unit = (Unit) ((Either.Right) either).getB();
            this.a.getChannelDeletedStream().postValue(Unit.INSTANCE);
        } else if (either instanceof Either.Left) {
            this.a.getErrorMessageStream().postValue(this.a.x.format((Throwable) ((Either.Left) either).getA()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
