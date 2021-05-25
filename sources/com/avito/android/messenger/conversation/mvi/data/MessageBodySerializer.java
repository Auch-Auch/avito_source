package com.avito.android.messenger.conversation.mvi.data;

import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", SDKConstants.PARAM_A2U_BODY, "", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;)Ljava/lang/String;", "serializeType", "type", "jsonBody", "deserialize", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageBodySerializer {
    @NotNull
    MessageBody deserialize(@NotNull String str, @NotNull String str2);

    @NotNull
    String serialize(@NotNull MessageBody messageBody);

    @NotNull
    String serializeType(@NotNull MessageBody messageBody);
}
