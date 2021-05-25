package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.messenger.channels.mvi.common.v3.RxFairCompositeWriteLock;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.sync.ChannelsKey;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/LocalChannelEditorImpl;", "Lcom/avito/android/messenger/channels/mvi/sync/LocalChannelEditor;", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Completable;", "deleteContextActions", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "channelRepo", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "c", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;", "lock", "<init>", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeWriteLock;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LocalChannelEditorImpl implements LocalChannelEditor {
    public final ChannelRepo a;
    public final SchedulersFactory b;
    public final RxFairCompositeWriteLock<ChannelsKey> c;

    public LocalChannelEditorImpl(@NotNull ChannelRepo channelRepo, @NotNull SchedulersFactory schedulersFactory, @NotNull RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock) {
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(rxFairCompositeWriteLock, "lock");
        this.a = channelRepo;
        this.b = schedulersFactory;
        this.c = rxFairCompositeWriteLock;
    }

    @Override // com.avito.android.messenger.channels.mvi.sync.LocalChannelEditor
    @NotNull
    public Completable deleteContextActions(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable deleteChannelContextActions = this.a.deleteChannelContextActions(str, str2);
        RxFairCompositeWriteLock<ChannelsKey> rxFairCompositeWriteLock = this.c;
        Set<? extends ChannelsKey> of = x.setOf(new ChannelsKey.Id(str2));
        Scheduler computation = this.b.computation();
        Single<T> singleDefault = deleteChannelContextActions.toSingleDefault(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(singleDefault, "this.toSingleDefault(Unit)");
        Completable ignoreElement = rxFairCompositeWriteLock.callSingle(singleDefault, "removeContextActions", of, computation).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lock.callSingle(\n       …ler\n    ).ignoreElement()");
        return ignoreElement;
    }
}
