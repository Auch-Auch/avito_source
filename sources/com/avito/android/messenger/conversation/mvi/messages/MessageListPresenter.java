package com.avito.android.messenger.conversation.mvi.messages;

import android.net.Uri;
import android.view.ActionMode;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.MessageAvatarClickListener;
import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener;
import com.avito.android.messenger.conversation.adapter.file.FileMessageClickListener;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import com.avito.android.messenger.conversation.adapter.text.MessageLinkClickListener;
import com.avito.android.messenger.conversation.mvi.messages.MessageListView;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\fJ)\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH&¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\nH&¢\u0006\u0004\b\u0017\u0010\fR.\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019j\u0002`\u001c0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001eR.\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0019j\u0002`,0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001eR\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001eR\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001eR\u001c\u0010;\u001a\b\u0012\u0004\u0012\u0002090\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001e¨\u0006<"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView$Listener;", "Lcom/avito/android/messenger/conversation/adapter/MessageAvatarClickListener;", "Lcom/avito/android/messenger/conversation/adapter/text/MessageLinkClickListener;", "Lcom/avito/android/messenger/conversation/adapter/spam_actions/SpamActionsPresenter$Listener;", "Lcom/avito/android/messenger/conversation/adapter/app_call/AppCallMessageClickListener;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageClickListener;", "Landroid/view/ActionMode$Callback;", "", "refresh", "()V", "startPagination", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "metaInfo", "onMessageClick", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "callUser", "userInteractedWithList", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "Landroid/net/Uri;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/UriAndMimeType;", "getFileMessageClickedStream", "()Landroidx/lifecycle/LiveData;", "fileMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/LinkMenuData;", "getShowMenuForTextLinkStream", "showMenuForTextLinkStream", "getUnknownMessageClickedStream", "unknownMessageClickedStream", "getSystemUserAvatarClickedStream", "systemUserAvatarClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/OpenGalleryData;", "getImageMessageClickedStream", "imageMessageClickedStream", "getLinkMessageWithUrlClickedStream", "linkMessageWithUrlClickedStream", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "getRequestPermissionsForFileMessageStream", "requestPermissionsForFileMessageStream", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getLocationMessageClickedStream", "locationMessageClickedStream", "Lcom/avito/android/messenger/conversation/mvi/messages/PlatformMapData;", "getPlatformMapMessageClickedStream", "platformMapMessageClickedStream", "getErrorMessageStream", "errorMessageStream", "getFileDownloadFailsStream", "fileDownloadFailsStream", "Lcom/avito/android/messenger/conversation/mvi/messages/ItemMessageInfo;", "getItemMessageClickedStream", "itemMessageClickedStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageListPresenter extends MviEntity<MessageListView.State>, PaginationErrorView.Listener, MessageAvatarClickListener, MessageLinkClickListener, SpamActionsPresenter.Listener, AppCallMessageClickListener, FileMessageClickListener, ActionMode.Callback {
    void callUser();

    @NotNull
    LiveData<String> getErrorMessageStream();

    @NotNull
    LiveData<Unit> getFileDownloadFailsStream();

    @NotNull
    LiveData<Pair<Uri, String>> getFileMessageClickedStream();

    @NotNull
    LiveData<OpenGalleryData> getImageMessageClickedStream();

    @NotNull
    LiveData<ItemMessageInfo> getItemMessageClickedStream();

    @NotNull
    LiveData<String> getLinkMessageWithUrlClickedStream();

    @NotNull
    LiveData<MessageBody.Location> getLocationMessageClickedStream();

    @NotNull
    LiveData<PlatformMapData> getPlatformMapMessageClickedStream();

    @NotNull
    LiveData<Pair<LocalMessage, MessageMetaInfo>> getRequestPermissionsForFileMessageStream();

    @NotNull
    LiveData<LinkMenuData> getShowMenuForTextLinkStream();

    @NotNull
    LiveData<Unit> getSystemUserAvatarClickedStream();

    @NotNull
    LiveData<Unit> getUnknownMessageClickedStream();

    void onMessageClick(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo);

    void refresh();

    void startPagination();

    void userInteractedWithList();
}
