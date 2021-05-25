package com.avito.android.messenger.search;

import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.search.ChannelsSearchView;
import com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter;
import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0014J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "Lcom/avito/android/messenger/search/adapter/channel/ChannelItemPresenter$Listener;", "Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter$Listener;", "", "query", "", "force", "", "search", "(Ljava/lang/String;Z)V", "retry", "()V", "requestNextPage", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter$ChatNavigationData;", "getChatNavigationStream", "()Landroidx/lifecycle/LiveData;", "chatNavigationStream", "ChatNavigationData", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsSearchPresenter extends MviEntity<ChannelsSearchView.State>, ChannelItemPresenter.Listener, SupportChannelItemPresenter.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchPresenter$ChatNavigationData;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", "", AuthSource.BOOKING_ORDER, "I", "getPosition", "()I", VKApiConst.POSITION, "c", "getMessageId", "messageId", "d", "getQuery", "query", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChatNavigationData {
        @NotNull
        public final String a;
        public final int b;
        @Nullable
        public final String c;
        @NotNull
        public final String d;

        public ChatNavigationData(@NotNull String str, int i, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str3, "query");
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
        }

        @NotNull
        public final String getChannelId() {
            return this.a;
        }

        @Nullable
        public final String getMessageId() {
            return this.c;
        }

        public final int getPosition() {
            return this.b;
        }

        @NotNull
        public final String getQuery() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void search$default(ChannelsSearchPresenter channelsSearchPresenter, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                channelsSearchPresenter.search(str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
        }
    }

    @NotNull
    LiveData<ChatNavigationData> getChatNavigationStream();

    void requestNextPage();

    void retry();

    void search(@NotNull String str, boolean z);
}
