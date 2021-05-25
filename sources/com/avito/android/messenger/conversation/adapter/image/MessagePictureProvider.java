package com.avito.android.messenger.conversation.adapter.image;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "messageBody", "", "imageId", "Lcom/avito/android/image_loader/Picture;", "getPicture", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;Ljava/lang/String;)Lcom/avito/android/image_loader/Picture;", "getThumbnail", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessagePictureProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Picture getPicture$default(MessagePictureProvider messagePictureProvider, MessageBody messageBody, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return messagePictureProvider.getPicture(messageBody, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPicture");
        }

        public static /* synthetic */ Picture getThumbnail$default(MessagePictureProvider messagePictureProvider, MessageBody messageBody, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return messagePictureProvider.getThumbnail(messageBody, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbnail");
        }
    }

    @NotNull
    Picture getPicture(@NotNull MessageBody messageBody, @Nullable String str);

    @NotNull
    Picture getThumbnail(@NotNull MessageBody messageBody, @Nullable String str);
}
