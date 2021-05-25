package com.avito.android.messenger.conversation.mvi.context;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelContextInteractorImpl$subscribeToChatTypingEvents$2 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = new ChannelContextInteractorImpl$subscribeToChatTypingEvents$2();

    public ChannelContextInteractorImpl$subscribeToChatTypingEvents$2() {
        super(ChatTypingEvent.class, "fromId", "getFromId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    @Nullable
    public Object get(@Nullable Object obj) {
        return ((ChatTypingEvent) obj).getFromId();
    }
}
