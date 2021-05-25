package com.avito.android.messenger.conversation.adapter.file;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "value", "", "setName", "(Ljava/lang/CharSequence;)V", "", "sizeInBytes", "setSize", "(J)V", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "Lkotlin/Function0;", "onCancelClick", "setIconState", "(Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;Lkotlin/jvm/functions/Function0;)V", "IconState", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FileMessageView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull FileMessageView fileMessageView) {
            ItemView.DefaultImpls.onUnbind(fileMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "", "<init>", "()V", "DownloadButton", "FileIcon", "TransferInProgress", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState$FileIcon;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState$DownloadButton;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState$TransferInProgress;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class IconState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState$DownloadButton;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class DownloadButton extends IconState {
            @NotNull
            public static final DownloadButton INSTANCE = new DownloadButton();

            public DownloadButton() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState$FileIcon;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class FileIcon extends IconState {
            @NotNull
            public static final FileIcon INSTANCE = new FileIcon();

            public FileIcon() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState$TransferInProgress;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class TransferInProgress extends IconState {
            @NotNull
            public static final TransferInProgress INSTANCE = new TransferInProgress();

            public TransferInProgress() {
                super(null);
            }
        }

        public IconState() {
        }

        public IconState(j jVar) {
        }
    }

    void setIconState(@NotNull IconState iconState, @NotNull Function0<Unit> function0);

    void setName(@NotNull CharSequence charSequence);

    void setSize(long j);
}
