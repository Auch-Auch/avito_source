package com.avito.android.messenger.channels.mvi.interactor;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0000 \u0003*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ChannelContext.Item.USER_ID, "Larrow/core/Option;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/String;)Larrow/core/Option;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorImpl$userIdOptionObservable$1<T, R> implements Function<String, Option<? extends String>> {
    public static final ChannelsListInteractorImpl$userIdOptionObservable$1 INSTANCE = new ChannelsListInteractorImpl$userIdOptionObservable$1();

    public final Option<String> apply(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        if (!(str.length() > 0)) {
            str = null;
        }
        return OptionKt.toOption(str);
    }
}
