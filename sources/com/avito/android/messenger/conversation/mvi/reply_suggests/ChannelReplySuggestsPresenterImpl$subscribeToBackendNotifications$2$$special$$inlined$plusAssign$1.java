package com.avito.android.messenger.conversation.mvi.reply_suggests;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "oldState", "Lio/reactivex/Single;", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Single;", "com/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityKt$toMutatorSingle$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1 extends Lambda implements Function1<ChannelReplySuggestsView.State, Single<ChannelReplySuggestsView.State>> {
    public final /* synthetic */ Mutator a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1(Mutator mutator) {
        super(1);
        this.a = mutator;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Single<ChannelReplySuggestsView.State> invoke(@NotNull final ChannelReplySuggestsView.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        Single<ChannelReplySuggestsView.State> fromCallable = Single.fromCallable(new Callable<ChannelReplySuggestsView.State>(this) { // from class: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1.1
            public final /* synthetic */ ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1 a;

            {
                this.a = r1;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView$State, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView.State call() {
                /*
                    r2 = this;
                    com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1 r0 = r2.a
                    com.avito.android.messenger.channels.mvi.common.v2.Mutator r0 = r0.a
                    kotlin.jvm.functions.Function1 r0 = r0.getBlock()
                    java.lang.Object r1 = r2
                    java.lang.Object r0 = r0.invoke(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenterImpl$subscribeToBackendNotifications$2$$special$$inlined$plusAssign$1.AnonymousClass1.call():java.lang.Object");
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …block(oldState)\n        }");
        return fromCallable;
    }
}
