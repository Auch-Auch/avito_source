package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.remote.model.User;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/remote/model/User;", "user", "", "invoke", "(Lcom/avito/android/remote/model/User;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextPresenterImpl$chatTitle$2 extends Lambda implements Function1<User, CharSequence> {
    public static final ChannelContextPresenterImpl$chatTitle$2 INSTANCE = new ChannelContextPresenterImpl$chatTitle$2();

    public ChannelContextPresenterImpl$chatTitle$2() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        String name = user.getName();
        return name != null ? name : "";
    }
}
