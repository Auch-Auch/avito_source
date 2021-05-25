package com.avito.android.messenger.search.adapter.supportchannel;

import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemView;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemView;Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;I)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "Listener", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SupportChannelItemPresenter implements ItemPresenter<SupportChannelItemView, ChannelsSearchListItem.SupportChannel> {
    public final Lazy<Listener> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemPresenter$Listener;", "", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "item", "", VKApiConst.POSITION, "", "onItemClick", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onItemClick(@NotNull ChannelsSearchListItem.SupportChannel supportChannel, int i);
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SupportChannelItemPresenter a;
        public final /* synthetic */ ChannelsSearchListItem.SupportChannel b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SupportChannelItemPresenter supportChannelItemPresenter, ChannelsSearchListItem.SupportChannel supportChannel, int i) {
            super(0);
            this.a = supportChannelItemPresenter;
            this.b = supportChannel;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((Listener) this.a.a.get()).onItemClick(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SupportChannelItemPresenter(@NotNull Lazy<Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull SupportChannelItemView supportChannelItemView, @NotNull ChannelsSearchListItem.SupportChannel supportChannel, int i) {
        Intrinsics.checkNotNullParameter(supportChannelItemView, "view");
        Intrinsics.checkNotNullParameter(supportChannel, "item");
        supportChannelItemView.setClickListener(new a(this, supportChannel, i));
        supportChannelItemView.render(supportChannel);
    }
}
