package com.avito.android.messenger.conversation.adapter.text;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.text.IncomingTextMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/IncomingTextMessageBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/messenger/conversation/adapter/text/IncomingTextMessageView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;", "getPresenter", "()Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;", "presenter", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/messenger/conversation/adapter/text/IncomingTextMessageView$Impl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/text/TextMessagePresenter;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class IncomingTextMessageBlueprint implements ItemBlueprint<IncomingTextMessageView, ChannelItem.Message> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<IncomingTextMessageView.Impl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.messenger_text_bubble_incoming, a.a);
    @NotNull
    public final TextMessagePresenter b;
    public final Features c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, IncomingTextMessageView.Impl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public IncomingTextMessageView.Impl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new IncomingTextMessageView.Impl(view2);
        }
    }

    public IncomingTextMessageBlueprint(@NotNull TextMessagePresenter textMessagePresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(textMessagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = textMessagePresenter;
        this.c = features;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<IncomingTextMessageView.Impl> getViewHolderProvider() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r1 != null) goto L_0x0058;
     */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRelevantItem(@org.jetbrains.annotations.NotNull com.avito.konveyor.blueprint.Item r5) {
        /*
            r4 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r5 instanceof com.avito.android.messenger.conversation.ChannelItem.Message
            r1 = 0
            if (r0 != 0) goto L_0x000c
            r2 = r1
            goto L_0x000d
        L_0x000c:
            r2 = r5
        L_0x000d:
            com.avito.android.messenger.conversation.ChannelItem$Message r2 = (com.avito.android.messenger.conversation.ChannelItem.Message) r2
            if (r2 == 0) goto L_0x0025
            com.avito.android.messenger.conversation.ChannelItem$Message$BodyOrBubble r2 = r2.getBodyOrBubble()
            if (r2 == 0) goto L_0x0025
            com.avito.android.remote.model.messenger.message.MessageBody r2 = r2.getBody()
            if (r2 == 0) goto L_0x0025
            boolean r3 = r2 instanceof com.avito.android.remote.model.messenger.message.MessageBody.Link
            if (r3 != 0) goto L_0x0022
            r2 = r1
        L_0x0022:
            com.avito.android.remote.model.messenger.message.MessageBody$Link r2 = (com.avito.android.remote.model.messenger.message.MessageBody.Link) r2
            goto L_0x0026
        L_0x0025:
            r2 = r1
        L_0x0026:
            if (r0 == 0) goto L_0x0072
            com.avito.android.messenger.conversation.ChannelItem$Message r5 = (com.avito.android.messenger.conversation.ChannelItem.Message) r5
            boolean r0 = r5.isMy()
            if (r0 != 0) goto L_0x0072
            com.avito.android.messenger.conversation.ChannelItem$Message$BodyOrBubble r5 = r5.getBodyOrBubble()
            com.avito.android.remote.model.messenger.message.MessageBody r5 = r5.getBody()
            boolean r5 = r5 instanceof com.avito.android.remote.model.messenger.message.MessageBody.Text
            if (r5 != 0) goto L_0x0070
            if (r2 == 0) goto L_0x0072
            com.avito.android.remote.model.messenger.message.MessageBody$Link$Preview r5 = r2.getPreview()
            if (r5 == 0) goto L_0x0070
            com.avito.android.remote.model.messenger.message.MessageBody$Link$Preview r5 = r2.getPreview()
            boolean r5 = r5 instanceof com.avito.android.remote.model.messenger.message.MessageBody.Link.Preview.Image
            if (r5 == 0) goto L_0x0058
            com.avito.android.remote.model.messenger.message.MessageBody$Link$Preview r5 = r2.getPreview()
            if (r5 == 0) goto L_0x0056
            com.avito.android.remote.model.Image r1 = r5.getImage()
        L_0x0056:
            if (r1 == 0) goto L_0x0070
        L_0x0058:
            com.avito.android.Features r5 = r4.c
            com.avito.android.toggle.Feature r5 = r5.getMessengerDoNotHighlightUntrustedUrls()
            java.lang.Object r5 = r5.invoke()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0072
            boolean r5 = r2.getUrlsAreTrusted()
            if (r5 != 0) goto L_0x0072
        L_0x0070:
            r5 = 1
            goto L_0x0073
        L_0x0072:
            r5 = 0
        L_0x0073:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.adapter.text.IncomingTextMessageBlueprint.isRelevantItem(com.avito.konveyor.blueprint.Item):boolean");
    }

    /* Return type fixed from 'com.avito.android.messenger.conversation.adapter.text.TextMessagePresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<IncomingTextMessageView, ChannelItem.Message> getPresenter() {
        return this.b;
    }
}
