package com.avito.android.messenger.conversation.adapter.image;

import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.conversation.adapter.MessageViewStatus;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/ImageMessageView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatus;", "Lcom/avito/android/image_loader/Picture;", "picture", "thumbnail", "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatusClickListener", "(Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ImageMessageView extends ItemView, MessageViewStatus {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ImageMessageView imageMessageView) {
            ItemView.DefaultImpls.onUnbind(imageMessageView);
        }

        public static void setStatus(@NotNull ImageMessageView imageMessageView, @NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
        }

        public static void setStatusClickListener(@NotNull ImageMessageView imageMessageView, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
    }

    void setImage(@NotNull Picture picture, @Nullable Picture picture2);

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
    void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus);

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
    void setStatusClickListener(@NotNull Function0<Unit> function0);
}
