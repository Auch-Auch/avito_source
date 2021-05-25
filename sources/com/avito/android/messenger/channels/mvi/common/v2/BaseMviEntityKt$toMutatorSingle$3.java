package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "oldState", "Lio/reactivex/Single;", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Single;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BaseMviEntityKt$toMutatorSingle$3 extends Lambda implements Function1<S, Single<S>> {
    public final /* synthetic */ ActionSingle a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMviEntityKt$toMutatorSingle$3(ActionSingle actionSingle) {
        super(1);
        this.a = actionSingle;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Single<S> invoke(@NotNull final S s) {
        Intrinsics.checkNotNullParameter(s, "oldState");
        Single<S> onErrorReturn = ((Single) this.a.getBlock().invoke(s)).map(new Function<Object, S>() { // from class: com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityKt$toMutatorSingle$3.1
            @Override // io.reactivex.functions.Function
            public final S apply(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                return (S) s;
            }
        }).onErrorReturn(new Function<Throwable, S>() { // from class: com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityKt$toMutatorSingle$3.2
            public final S apply(@NotNull Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                return (S) s;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
        return onErrorReturn;
    }
}
