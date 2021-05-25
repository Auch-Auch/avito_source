package com.avito.android.messenger.conversation.adapter.file;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.IncomingMessageView;
import com.avito.android.messenger.conversation.adapter.OutgoingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.messenger.conversation.adapter.file.FileMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.android.persistence.messenger.TransferStatus;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessagePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;", "outgoingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;", "c", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;", "fileMessageClickListener", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/OutgoingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileMessagePresenter implements ItemPresenter<FileMessageView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final OutgoingMessagePresenter b;
    public final FileMessageClickListener c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FileMessagePresenter a;
        public final /* synthetic */ ChannelItem.Message b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FileMessagePresenter fileMessagePresenter, MessageBody messageBody, ChannelItem.Message message) {
            super(0);
            this.a = fileMessagePresenter;
            this.b = message;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.c.onFileMessageCancelClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public FileMessagePresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull OutgoingMessagePresenter outgoingMessagePresenter, @NotNull FileMessageClickListener fileMessageClickListener) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(outgoingMessagePresenter, "outgoingMessagePresenter");
        Intrinsics.checkNotNullParameter(fileMessageClickListener, "fileMessageClickListener");
        this.a = incomingMessagePresenter;
        this.b = outgoingMessagePresenter;
        this.c = fileMessageClickListener;
    }

    public void bindView(@NotNull FileMessageView fileMessageView, @NotNull ChannelItem.Message message, int i) {
        FileMessageView.IconState iconState;
        Intrinsics.checkNotNullParameter(fileMessageView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        if (fileMessageView instanceof IncomingMessageView) {
            this.a.bindView(fileMessageView, message, i);
        } else if (fileMessageView instanceof OutgoingMessageView) {
            this.b.bindView(fileMessageView, message, i);
        }
        MessageBody body = message.getBodyOrBubble().getBody();
        TransferStatus transferStatus = null;
        if (body instanceof MessageBody.File) {
            MessageBody.File file = (MessageBody.File) body;
            fileMessageView.setName(file.getName());
            fileMessageView.setSize(file.getSizeBytes());
            String str = message.getLocalMessage().remoteId;
            boolean z = false;
            if (!(str == null || m.isBlank(str))) {
                MessageMetaInfo metaInfo = message.getMetaInfo();
                String path = metaInfo != null ? metaInfo.getPath() : null;
                if (!(path == null || m.isBlank(path))) {
                    MessageMetaInfo metaInfo2 = message.getMetaInfo();
                    if ((metaInfo2 != null ? metaInfo2.getTransferStatus() : null) == TransferStatus.SUCCESS) {
                        iconState = FileMessageView.IconState.FileIcon.INSTANCE;
                    }
                }
                MessageMetaInfo metaInfo3 = message.getMetaInfo();
                String path2 = metaInfo3 != null ? metaInfo3.getPath() : null;
                if (path2 == null || m.isBlank(path2)) {
                    z = true;
                }
                if (z) {
                    MessageMetaInfo metaInfo4 = message.getMetaInfo();
                    if (metaInfo4 != null) {
                        transferStatus = metaInfo4.getTransferStatus();
                    }
                    if (transferStatus == null || message.getMetaInfo().getTransferStatus() == TransferStatus.NONE || message.getMetaInfo().getTransferStatus() == TransferStatus.ERROR) {
                        iconState = FileMessageView.IconState.DownloadButton.INSTANCE;
                    }
                }
                iconState = FileMessageView.IconState.TransferInProgress.INSTANCE;
            } else if (message.getLocalMessage().isFailed) {
                iconState = FileMessageView.IconState.FileIcon.INSTANCE;
            } else {
                iconState = FileMessageView.IconState.TransferInProgress.INSTANCE;
            }
            fileMessageView.setIconState(iconState, new a(this, body, message));
            return;
        }
        fileMessageView.setName("");
        fileMessageView.setSize(0);
        fileMessageView.setIconState(FileMessageView.IconState.TransferInProgress.INSTANCE, b.a);
        Logs.debug$default("FileMessagePresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}
