package com.avito.android.messenger.conversation.mvi.messages;

import arrow.core.Option;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Larrow/core/Option;", "", "hasMorePagesOption", "test", "(Larrow/core/Option;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageUpdates$6<T> implements Predicate<Option<? extends Boolean>> {
    public static final MessageListPresenterImpl$subscribeToMessageUpdates$6 INSTANCE = new MessageListPresenterImpl$subscribeToMessageUpdates$6();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public /* bridge */ /* synthetic */ boolean test(Option<? extends Boolean> option) {
        return test((Option<Boolean>) option);
    }

    public final boolean test(@NotNull Option<Boolean> option) {
        Intrinsics.checkNotNullParameter(option, "hasMorePagesOption");
        return option.isDefined();
    }
}
