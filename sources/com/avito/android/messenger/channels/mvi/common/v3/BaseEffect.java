package com.avito.android.messenger.channels.mvi.common.v3;

import com.avito.android.messenger.channels.mvi.common.v3.BaseEvent;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEffect;", "Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEvent;", "EventT", "", "Lio/reactivex/Observable;", "eventStream", "", "reactTo", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface BaseEffect<EventT extends BaseEvent> {
    @NotNull
    Observable<Unit> reactTo(@NotNull Observable<EventT> observable);
}
