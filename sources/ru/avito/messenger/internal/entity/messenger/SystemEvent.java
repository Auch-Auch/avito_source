package ru.avito.messenger.internal.entity.messenger;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002R\u0016\u0010\u0005\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/SystemEvent;", "T", "", "getValue", "()Ljava/lang/Object;", "value", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SystemEvent<T> {
    T getValue();
}
