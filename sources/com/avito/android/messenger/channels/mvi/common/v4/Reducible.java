package com.avito.android.messenger.channels.mvi.common.v4;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "", ExifInterface.LATITUDE_SOUTH, "Lio/reactivex/functions/Consumer;", "reducerStream", "", "sendToReducer", "(Lio/reactivex/functions/Consumer;)V", "oldState", "Lio/reactivex/Single;", "execute", "(Ljava/lang/Object;)Lio/reactivex/Single;", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface Reducible<S> {
    @NotNull
    Single<S> execute(@NotNull S s);

    void sendToReducer(@NotNull Consumer<Reducible<S>> consumer);
}
