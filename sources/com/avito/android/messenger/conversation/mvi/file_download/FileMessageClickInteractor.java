package com.avito.android.messenger.conversation.mvi.file_download;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rj\u0002`\u000e0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\rj\u0002`\u00140\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "metaInfo", "", "onBubbleClick", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "onCancelClick", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)V", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "getRequestPermissionsForFileMessageStream", "()Landroidx/lifecycle/LiveData;", "requestPermissionsForFileMessageStream", "Landroid/net/Uri;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/UriAndMimeType;", "getFileMessageClickedStream", "fileMessageClickedStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FileMessageClickInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileMessageClickInteractor$State;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final State INSTANCE = new State();
    }

    @NotNull
    LiveData<Pair<Uri, String>> getFileMessageClickedStream();

    @NotNull
    LiveData<Pair<LocalMessage, MessageMetaInfo>> getRequestPermissionsForFileMessageStream();

    void onBubbleClick(@NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo);

    void onCancelClick(@NotNull LocalMessage localMessage);
}
