package com.avito.android.messenger.conversation.adapter.link;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.link.IncomingLinkSnippetMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;", "getPresenter", "()Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/messenger/conversation/adapter/link/IncomingLinkSnippetMessageView$Impl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/link/LinkSnippetMessagePresenter;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class IncomingLinkSnippetMessageBlueprint implements ItemBlueprint<IncomingLinkSnippetMessageView, ChannelItem.Message> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<IncomingLinkSnippetMessageView.Impl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.messenger_link_snippet_bubble_incoming, a.a);
    @NotNull
    public final LinkSnippetMessagePresenter b;
    public final Features c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, IncomingLinkSnippetMessageView.Impl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public IncomingLinkSnippetMessageView.Impl invoke(ViewGroup viewGroup, View view) {
            ViewGroup viewGroup2 = viewGroup;
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup2, "parentView");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new IncomingLinkSnippetMessageView.Impl(view2, viewGroup2);
        }
    }

    public IncomingLinkSnippetMessageBlueprint(@NotNull LinkSnippetMessagePresenter linkSnippetMessagePresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(linkSnippetMessagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = linkSnippetMessagePresenter;
        this.c = features;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<IncomingLinkSnippetMessageView.Impl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        ChannelItem.Message.BodyOrBubble bodyOrBubble;
        MessageBody body;
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z = item instanceof ChannelItem.Message;
        MessageBody.Link link = null;
        ChannelItem.Message message = (ChannelItem.Message) (!z ? null : item);
        if (!(message == null || (bodyOrBubble = message.getBodyOrBubble()) == null || (body = bodyOrBubble.getBody()) == null)) {
            if (body instanceof MessageBody.Link) {
                link = body;
            }
            link = link;
        }
        return z && !((ChannelItem.Message) item).isMy() && link != null && (link.getPreview() instanceof MessageBody.Link.Preview.Snippet) && (link.getUrlsAreTrusted() || !this.c.getMessengerDoNotHighlightUntrustedUrls().invoke().booleanValue());
    }

    /* Return type fixed from 'com.avito.android.messenger.conversation.adapter.link.LinkSnippetMessagePresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<IncomingLinkSnippetMessageView, ChannelItem.Message> getPresenter() {
        return this.b;
    }
}
