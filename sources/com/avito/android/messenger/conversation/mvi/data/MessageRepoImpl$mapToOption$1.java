package com.avito.android.messenger.conversation.mvi.data;

import arrow.core.Option;
import arrow.core.OptionKt;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0005*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "", "it", "Larrow/core/Option;", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/List;)Larrow/core/Option;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageRepoImpl$mapToOption$1<T, R> implements Function<List<? extends T>, Option<? extends T>> {
    public static final MessageRepoImpl$mapToOption$1 INSTANCE = new MessageRepoImpl$mapToOption$1();

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((List) ((List) obj));
    }

    public final Option<T> apply(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return OptionKt.toOption(CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) list));
    }
}
