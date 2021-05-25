package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import a2.b.a.a.a;
import android.content.ClipData;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.R;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.analytics.MessengerCopyMessageTextEvent;
import com.avito.android.messenger.channels.mvi.common.v4.Action;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.ClipDataFactory;
import com.avito.android.util.Logs;
import com.avito.android.util.Uris;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002'(B1\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/ClickableMenuElementProvider;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "getMenuElement", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MenuElement;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "getReducible", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getActionId", "()Ljava/lang/String;", "actionId", "Lcom/avito/android/messenger/TextToChunkConverter;", "e", "Lcom/avito/android/messenger/TextToChunkConverter;", "textToChunkConverter", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/ClipDataFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/ClipDataFactory;", "clipDataFactory", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;", "d", "Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;", "callback", "<init>", "(Lcom/avito/android/util/ClipDataFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;Lcom/avito/android/messenger/TextToChunkConverter;Lcom/avito/android/Features;)V", "Callback", "CopyAction", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CopyToClipboardElementProvider implements ClickableMenuElementProvider {
    @NotNull
    public final String a = "copy";
    public final ClipDataFactory b;
    public final Analytics c;
    public final Callback d;
    public final TextToChunkConverter e;
    public final Features f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$Callback;", "", "Landroid/content/ClipData;", "data", "", "saveToClipboard", "(Landroid/content/ClipData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void saveToClipboard(@NotNull ClipData clipData);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider$CopyAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;)V", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "d", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "contextData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/CopyToClipboardElementProvider;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class CopyAction extends Action<MessageMenuPresenter.State> {
        public final MessageContextData d;
        public final /* synthetic */ CopyToClipboardElementProvider e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CopyAction(@NotNull CopyToClipboardElementProvider copyToClipboardElementProvider, MessageContextData messageContextData) {
            super(null, null, 3, null);
            Intrinsics.checkNotNullParameter(messageContextData, "contextData");
            this.e = copyToClipboardElementProvider;
            this.d = messageContextData;
        }

        public void invoke(@NotNull MessageMenuPresenter.State state) {
            Pair pair;
            String str;
            Intrinsics.checkNotNullParameter(state, "curState");
            MessageContextData messageContextData = this.d;
            if (messageContextData instanceof MessageContextData.Text) {
                if (((MessageContextData.Text) messageContextData).getUrlsAreTrusted() || !this.e.f.getMessengerDoNotHighlightUntrustedUrls().invoke().booleanValue()) {
                    pair = TuplesKt.to(((MessageContextData.Text) this.d).getText(), Boolean.TRUE);
                } else {
                    pair = TuplesKt.to(((MessageContextData.Text) this.d).getText(), Boolean.FALSE);
                }
            } else if (messageContextData instanceof MessageContextData.Item) {
                pair = TuplesKt.to(((MessageContextData.Item) messageContextData).getUrl(), Boolean.TRUE);
            } else if (messageContextData instanceof MessageContextData.Link) {
                pair = TuplesKt.to(((MessageContextData.Link) messageContextData).getUrl(), Boolean.TRUE);
            } else if (messageContextData instanceof MessageContextData.LinkInText) {
                pair = TuplesKt.to(((MessageContextData.LinkInText) messageContextData).getUrl(), Boolean.TRUE);
            } else if (messageContextData instanceof MessageContextData.Image) {
                pair = TuplesKt.to(((MessageContextData.Image) messageContextData).getUrl(), Boolean.TRUE);
            } else if (messageContextData instanceof MessageContextData.Location) {
                pair = TuplesKt.to(((MessageContextData.Location) messageContextData).getAddress(), Boolean.TRUE);
            } else if (!(messageContextData instanceof MessageContextData.LocalImage) && !(messageContextData instanceof MessageContextData.File)) {
                throw new NoWhenBranchMatchedException();
            } else {
                pair = TuplesKt.to("", Boolean.TRUE);
            }
            String str2 = (String) pair.component1();
            boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
            if (!m.isBlank(str2)) {
                boolean areEqual = Intrinsics.areEqual(this.d.getMessageData().getUserId(), this.d.getMessageData().getFromId());
                if (booleanValue || areEqual) {
                    str = str2;
                } else {
                    List<MessageBody.Text.Chunk> convertToTextChunks = this.e.e.convertToTextChunks(str2);
                    StringBuilder sb = new StringBuilder();
                    for (T t : convertToTextChunks) {
                        if (t instanceof MessageBody.Text.Chunk.Plain) {
                            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                            String substring = str2.substring(t.getStart(), t.getEnd() + 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            sb.append(substring);
                        } else if (t instanceof MessageBody.Text.Chunk.Link) {
                            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                            String substring2 = str2.substring(t.getStart(), t.getEnd() + 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            String[] url_schemes = Uris.getURL_SCHEMES();
                            int length = url_schemes.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    substring2 = a.t(new StringBuilder(), Uris.getURL_SCHEMES()[0], substring2);
                                    break;
                                }
                                String str3 = url_schemes[i];
                                if (!m.startsWith(substring2, str3, true)) {
                                    i++;
                                } else if (!m.startsWith(substring2, str3, false)) {
                                    StringBuilder L = a.L(str3);
                                    String substring3 = substring2.substring(str3.length());
                                    Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.String).substring(startIndex)");
                                    L.append(substring3);
                                    substring2 = L.toString();
                                }
                            }
                            if (!m.startsWith$default(substring2, "https://link.avito.ru/go?to=", false, 2, null)) {
                                substring2 = new Uri.Builder().scheme("https").authority("link.avito.ru").path("/go").appendQueryParameter("to", substring2).build().toString();
                                Intrinsics.checkNotNullExpressionValue(substring2, "Uri.Builder()\n          …              .toString()");
                            }
                            sb.append(substring2);
                        }
                        sb.append('\n');
                    }
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                    Objects.requireNonNull(sb2, "null cannot be cast to non-null type kotlin.CharSequence");
                    str = StringsKt__StringsKt.trim(sb2).toString();
                }
                this.e.d.saveToClipboard(this.e.b.plainText(str));
                String remoteId = this.d.getMessageData().getRemoteId();
                if (remoteId != null) {
                    this.e.c.track(new MessengerCopyMessageTextEvent(this.d.getMessageData().getChannelId(), remoteId, str2, !Intrinsics.areEqual(str2, str)));
                    return;
                }
                return;
            }
            Logs.verbose$default("CopyActionDescriptor", "Action was not performed, text is empty or blank", null, 4, null);
        }
    }

    @Inject
    public CopyToClipboardElementProvider(@NotNull ClipDataFactory clipDataFactory, @NotNull Analytics analytics, @NotNull Callback callback, @NotNull TextToChunkConverter textToChunkConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(clipDataFactory, "clipDataFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(textToChunkConverter, "textToChunkConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = clipDataFactory;
        this.c = analytics;
        this.d = callback;
        this.e = textToChunkConverter;
        this.f = features;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public String getActionId() {
        return this.a;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @Nullable
    public ActionConfirmation getConfirmation(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return ClickableMenuElementProvider.DefaultImpls.getConfirmation(this, messageContextData);
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MenuElementProvider
    @Nullable
    public MenuElement getMenuElement(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        if ((messageContextData instanceof MessageContextData.Link) || (messageContextData instanceof MessageContextData.LinkInText) || (messageContextData instanceof MessageContextData.Item) || (messageContextData instanceof MessageContextData.Image)) {
            return new MenuElement.Action(getActionId(), R.string.messenger_message_menu_copy_link, R.drawable.ic_messenger_link_menu_copy);
        }
        if ((messageContextData instanceof MessageContextData.Location) || (messageContextData instanceof MessageContextData.Text)) {
            return new MenuElement.Action(getActionId(), R.string.messenger_message_menu_copy, R.drawable.ic_messenger_link_menu_copy);
        }
        if ((messageContextData instanceof MessageContextData.LocalImage) || (messageContextData instanceof MessageContextData.File)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.ClickableMenuElementProvider
    @NotNull
    public Reducible<MessageMenuPresenter.State> getReducible(@NotNull MessageContextData messageContextData) {
        Intrinsics.checkNotNullParameter(messageContextData, "contextData");
        return new CopyAction(this, messageContextData);
    }
}
