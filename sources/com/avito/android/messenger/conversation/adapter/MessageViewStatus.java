package com.avito.android.messenger.conversation.adapter;

import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageViewStatus;", "", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatusClickListener", "(Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageViewStatus {
    void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus);

    void setStatusClickListener(@NotNull Function0<Unit> function0);
}
