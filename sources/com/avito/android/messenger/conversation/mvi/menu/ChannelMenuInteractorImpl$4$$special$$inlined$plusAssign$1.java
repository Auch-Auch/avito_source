package com.avito.android.messenger.conversation.mvi.menu;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.messenger.channels.mvi.common.v2.ActionSingle;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "oldState", "Lio/reactivex/Single;", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Single;", "com/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityKt$toMutatorSingle$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1 extends Lambda implements Function1<ChannelMenuInteractor.State, Single<ChannelMenuInteractor.State>> {
    public final /* synthetic */ ActionSingle a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1(ActionSingle actionSingle) {
        super(1);
        this.a = actionSingle;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Single<ChannelMenuInteractor.State> invoke(@NotNull final ChannelMenuInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        Single<ChannelMenuInteractor.State> onErrorReturn = ((Single) this.a.getBlock().invoke(state)).map(new Function<Object, ChannelMenuInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1.1
            /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // io.reactivex.functions.Function
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
                /*
                    r1 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.Object r2 = r3
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1.AnonymousClass1.apply(java.lang.Object):java.lang.Object");
            }
        }).onErrorReturn(new Function<Throwable, ChannelMenuInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1.2
            /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor$State] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor.State apply(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                /*
                    r1 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.Object r2 = r3
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractorImpl$4$$special$$inlined$plusAssign$1.AnonymousClass2.apply(java.lang.Throwable):java.lang.Object");
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState).map { ol…nErrorReturn { oldState }");
        return onErrorReturn;
    }
}
