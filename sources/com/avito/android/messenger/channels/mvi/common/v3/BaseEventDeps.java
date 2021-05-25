package com.avito.android.messenger.channels.mvi.common.v3;

import com.avito.android.util.SchedulersFactory;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001R\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEventDeps;", "", "PartialStateT", "", "getEntityTag", "()Ljava/lang/String;", "entityTag", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "Lkotlin/reflect/KMutableProperty0;", "getStateLock", "()Lcom/avito/android/messenger/channels/mvi/common/v3/RxFairCompositeReadWriteLock;", "stateLock", "Lio/reactivex/functions/Consumer;", "", "getPartialStatesConsumer", "()Lio/reactivex/functions/Consumer;", "partialStatesConsumer", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface BaseEventDeps<PartialStateT> {
    @NotNull
    String getEntityTag();

    @NotNull
    Consumer<Set<PartialStateT>> getPartialStatesConsumer();

    @NotNull
    SchedulersFactory getSchedulers();

    @NotNull
    RxFairCompositeReadWriteLock<KMutableProperty0<?>> getStateLock();
}
