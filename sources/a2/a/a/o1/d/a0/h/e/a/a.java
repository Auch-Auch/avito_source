package a2.a.a.o1.d.a0.h.e.a;

import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraserImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.functions.Action;
public final class a implements Action {
    public final /* synthetic */ MessageEraserImpl a;
    public final /* synthetic */ MessageBody b;
    public final /* synthetic */ LocalMessage c;

    public a(MessageEraserImpl messageEraserImpl, MessageBody messageBody, LocalMessage localMessage) {
        this.a = messageEraserImpl;
        this.b = messageBody;
        this.c = localMessage;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        MessageBody messageBody = this.b;
        if (messageBody instanceof MessageBody.LocalImage) {
            this.a.b.delete(String.valueOf(((MessageBody.LocalImage) this.b).getUploadId()));
            this.a.c.delete(((MessageBody.LocalImage) this.b).getSource());
        } else if (messageBody instanceof MessageBody.File) {
            MessengerFileUploadCanceller messengerFileUploadCanceller = this.a.e;
            LocalMessage localMessage = this.c;
            messengerFileUploadCanceller.cancelUpload(new UploadUniqueInfo(localMessage.localId, localMessage.userId, localMessage.channelId));
        }
    }
}
