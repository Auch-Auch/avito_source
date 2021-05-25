package com.avito.android.messenger.widget.chat_list_element;

import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/SupportChatElement;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "hasNewIncomingUnreadMessages", "setHasNewUnreadMessage", "(Z)V", "Lcom/avito/android/remote/model/Image;", "image", "setChatIcon", "(Lcom/avito/android/remote/model/Image;)V", "Lkotlin/Function0;", "itemClickListener", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SupportChatElement {
    void setChatIcon(@Nullable Image image);

    void setHasNewUnreadMessage(boolean z);

    void setItemClickListener(@Nullable Function0<Unit> function0);

    void setTitle(@NotNull String str);
}
