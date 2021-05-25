package com.avito.android.messenger.conversation.mvi.reply_suggests;

import arrow.core.Either;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R.\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;", "", "Lio/reactivex/Observable;", "Larrow/core/Either;", "", "", "", "getReplySuggests", "()Lio/reactivex/Observable;", "replySuggests", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelReplySuggestsInteractor {
    @NotNull
    Observable<Either<Throwable, List<String>>> getReplySuggests();
}
