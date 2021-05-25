package com.avito.android.remote.parse.adapter.messenger.platform;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u000b\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/platform/PlatformFromUserMessageBodyTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/messenger/platform/PlatformMessageBodyTypeAdapter;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromUser;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", MessageBody.SystemMessageBody.Platform.CHUNKS, "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", MessageBody.SystemMessageBody.Platform.CONTEXT_ACTIONS, "", "flow", "fallbackText", "createBody", "(Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromUser;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformFromUserMessageBodyTypeAdapter extends PlatformMessageBodyTypeAdapter<MessageBody.SystemMessageBody.Platform.FromUser> {
    public PlatformFromUserMessageBodyTypeAdapter() {
        super("PlatformFromUserMessageBodyTypeAdapter");
    }

    @Override // com.avito.android.remote.parse.adapter.messenger.platform.PlatformMessageBodyTypeAdapter
    @NotNull
    public MessageBody.SystemMessageBody.Platform.FromUser createBody(@NotNull List<? extends MessageBody.SystemMessageBody.Platform.Bubble> list, @Nullable PlatformActions platformActions, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, MessageBody.SystemMessageBody.Platform.CHUNKS);
        return new MessageBody.SystemMessageBody.Platform.FromUser(list, platformActions, str, str2);
    }
}
