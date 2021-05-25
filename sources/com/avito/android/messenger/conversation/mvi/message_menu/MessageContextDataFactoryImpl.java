package com.avito.android.messenger.conversation.mvi.message_menu;

import a2.b.a.a.a;
import android.content.Context;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.android.util.Uris;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.config.MessengerConfig;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactoryImpl;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextDataFactory;", "Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "bodyOrBubble", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "localMessage", "", "url", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "createContextData", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/Features;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageContextDataFactoryImpl implements MessageContextDataFactory {
    public final Context a;
    public final Features b;
    public final AttributedTextFormatter c;

    @Inject
    public MessageContextDataFactoryImpl(@NotNull Context context, @NotNull Features features, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = context;
        this.b = features;
        this.c = attributedTextFormatter;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextDataFactory
    @Nullable
    public MessageContextData createContextData(@NotNull MessengerConfig messengerConfig, @NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @Nullable String str) {
        MessageContextData item;
        T t;
        MessageContextData.Link link;
        T t2;
        Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
        Intrinsics.checkNotNullParameter(localMessage, "localMessage");
        boolean z = true;
        if (str != null) {
            String[] url_schemes = Uris.getURL_SCHEMES();
            int length = url_schemes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = a.t(new StringBuilder(), Uris.getURL_SCHEMES()[0], str);
                    break;
                }
                String str2 = url_schemes[i];
                if (!m.startsWith(str, str2, true)) {
                    i++;
                } else if (!m.startsWith(str, str2, false)) {
                    StringBuilder L = a.L(str2);
                    String substring = str.substring(str2.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    L.append(substring);
                    str = L.toString();
                }
            }
            MessageData from = MessageData.Companion.from(localMessage);
            MessageBody messageBody = localMessage.body;
            if (messageBody instanceof MessageBody.Text) {
                List<MessageBody.Text.Chunk> chunks = ((MessageBody.Text) messageBody).getChunks();
                if (chunks == null || chunks.size() != 1) {
                    return new MessageContextData.LinkInText(messengerConfig, from, str);
                }
                return new MessageContextData.Link(messengerConfig, from, str);
            } else if (messageBody instanceof MessageBody.Link) {
                return new MessageContextData.Link(messengerConfig, from, str);
            } else {
                return new MessageContextData.LinkInText(messengerConfig, from, str);
            }
        } else {
            MessageBody body = bodyOrBubble.getBody();
            String str3 = null;
            if (body instanceof MessageBody.ItemReference) {
                MessageData from2 = MessageData.Companion.from(localMessage);
                MessageBody.ItemReference itemReference = (MessageBody.ItemReference) body;
                String itemId = itemReference.getItemId();
                String builder = new Uri.Builder().scheme("https").authority("avito.ru").appendPath(itemReference.getItemId()).toString();
                Intrinsics.checkNotNullExpressionValue(builder, "Uri.Builder().scheme(\"ht…)\n            .toString()");
                item = new MessageContextData.Item(messengerConfig, from2, itemId, builder);
            } else if (body instanceof MessageBody.Item) {
                MessageData from3 = MessageData.Companion.from(localMessage);
                MessageBody.Item item2 = (MessageBody.Item) body;
                String id = item2.getId();
                String builder2 = new Uri.Builder().scheme("https").authority("avito.ru").appendPath(item2.getId()).toString();
                Intrinsics.checkNotNullExpressionValue(builder2, "Uri.Builder().scheme(\"ht…)\n            .toString()");
                item = new MessageContextData.Item(messengerConfig, from3, id, builder2);
            } else {
                if (body instanceof MessageBody.Link) {
                    if (this.b.getMessengerDoNotHighlightUntrustedUrls().invoke().booleanValue() && !((MessageBody.Link) body).getUrlsAreTrusted()) {
                        item = new MessageContextData.Text(messengerConfig, MessageData.Companion.from(localMessage), ((MessageBody.Link) body).getUrl(), false);
                    } else {
                        MessageData from4 = MessageData.Companion.from(localMessage);
                        String url = ((MessageBody.Link) body).getUrl();
                        String[] url_schemes2 = Uris.getURL_SCHEMES();
                        int length2 = url_schemes2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                url = a.t(new StringBuilder(), Uris.getURL_SCHEMES()[0], url);
                                break;
                            }
                            String str4 = url_schemes2[i2];
                            if (!m.startsWith(url, str4, true)) {
                                i2++;
                            } else if (!m.startsWith(url, str4, false)) {
                                StringBuilder L2 = a.L(str4);
                                String substring2 = url.substring(str4.length());
                                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                                L2.append(substring2);
                                url = L2.toString();
                            }
                        }
                        link = new MessageContextData.Link(messengerConfig, from4, url);
                    }
                } else {
                    String str5 = "";
                    if (body instanceof MessageBody.ImageBody) {
                        MessageData from5 = MessageData.Companion.from(localMessage);
                        Iterator<T> it = ((MessageBody.ImageBody) body).getImage().getVariants().entrySet().iterator();
                        if (!it.hasNext()) {
                            t2 = null;
                        } else {
                            t2 = it.next();
                            if (it.hasNext()) {
                                Size size = (Size) t2.getKey();
                                int width = size.getWidth() * size.getHeight();
                                do {
                                    T next = it.next();
                                    Size size2 = (Size) next.getKey();
                                    int width2 = size2.getWidth() * size2.getHeight();
                                    if (width < width2) {
                                        t2 = next;
                                        width = width2;
                                    }
                                } while (it.hasNext());
                            }
                        }
                        T t3 = t2;
                        Uri uri = t3 != null ? (Uri) t3.getValue() : null;
                        if (uri != null) {
                            str3 = uri.toString();
                        }
                        if (str3 != null) {
                            str5 = str3;
                        }
                        item = new MessageContextData.Image(messengerConfig, from5, str5);
                    } else if (body instanceof MessageBody.LocalImage) {
                        item = new MessageContextData.LocalImage(messengerConfig, MessageData.Companion.from(localMessage));
                    } else if (body instanceof MessageBody.Text) {
                        MessageData from6 = MessageData.Companion.from(localMessage);
                        MessageBody.Text text = (MessageBody.Text) body;
                        List<MessageBody.Text.Chunk> chunks2 = text.getChunks();
                        if (chunks2 == null) {
                            chunks2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        MessageBody.Text.Chunk chunk = (MessageBody.Text.Chunk) CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) chunks2);
                        boolean z2 = body instanceof MessageBody.Text.Regular;
                        MessageBody.Text.Regular regular = (MessageBody.Text.Regular) (!z2 ? null : body);
                        if (!(regular == null || regular.getUrlsAreTrusted() || !this.b.getMessengerDoNotHighlightUntrustedUrls().invoke().booleanValue()) || !(chunk instanceof MessageBody.Text.Chunk.Link)) {
                            String text2 = text.getText();
                            if (!z2) {
                                body = null;
                            }
                            MessageBody.Text.Regular regular2 = (MessageBody.Text.Regular) body;
                            if (regular2 != null && !regular2.getUrlsAreTrusted()) {
                                z = false;
                            }
                            return new MessageContextData.Text(messengerConfig, from6, text2, z);
                        }
                        String text3 = text.getText();
                        String[] url_schemes3 = Uris.getURL_SCHEMES();
                        int length3 = url_schemes3.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length3) {
                                text3 = a.t(new StringBuilder(), Uris.getURL_SCHEMES()[0], text3);
                                break;
                            }
                            String str6 = url_schemes3[i3];
                            if (!m.startsWith(text3, str6, true)) {
                                i3++;
                            } else if (!m.startsWith(text3, str6, false)) {
                                StringBuilder L3 = a.L(str6);
                                String substring3 = text3.substring(str6.length());
                                Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.String).substring(startIndex)");
                                L3.append(substring3);
                                text3 = L3.toString();
                            }
                        }
                        link = new MessageContextData.Link(messengerConfig, from6, text3);
                    } else if (body instanceof MessageBody.Location) {
                        item = new MessageContextData.Location(messengerConfig, MessageData.Companion.from(localMessage), ((MessageBody.Location) body).getTitle());
                    } else if (body instanceof MessageBody.File) {
                        item = new MessageContextData.File(messengerConfig, MessageData.Companion.from(localMessage));
                    } else {
                        MessageBody.SystemMessageBody.Platform.Bubble bubble = bodyOrBubble.getBubble();
                        if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Text) {
                            item = new MessageContextData.Text(messengerConfig, MessageData.Companion.from(localMessage), String.valueOf(this.c.format(this.a, ((MessageBody.SystemMessageBody.Platform.Bubble.Text) bubble).getText())), true);
                        } else if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Image) {
                            MessageData from7 = MessageData.Companion.from(localMessage);
                            Image image = ((MessageBody.SystemMessageBody.Platform.Bubble.Image) bubble).getImage();
                            if (image != null) {
                                Iterator<T> it2 = image.getVariants().entrySet().iterator();
                                if (!it2.hasNext()) {
                                    t = null;
                                } else {
                                    t = it2.next();
                                    if (it2.hasNext()) {
                                        Size size3 = (Size) t.getKey();
                                        int width3 = size3.getWidth() * size3.getHeight();
                                        do {
                                            T next2 = it2.next();
                                            Size size4 = (Size) next2.getKey();
                                            int width4 = size4.getWidth() * size4.getHeight();
                                            if (width3 < width4) {
                                                t = next2;
                                                width3 = width4;
                                            }
                                        } while (it2.hasNext());
                                    }
                                }
                                T t4 = t;
                                Uri uri2 = t4 != null ? (Uri) t4.getValue() : null;
                                if (uri2 != null) {
                                    str3 = uri2.toString();
                                }
                            }
                            if (str3 != null) {
                                str5 = str3;
                            }
                            return new MessageContextData.Image(messengerConfig, from7, str5);
                        } else {
                            if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation) {
                                if (!(localMessage.body instanceof MessageBody.SystemMessageBody.Platform.FromAvito)) {
                                    item = new MessageContextData.Location(messengerConfig, MessageData.Companion.from(localMessage), ((MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation) bubble).getTitle());
                                }
                            } else if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Item) {
                                MessageData from8 = MessageData.Companion.from(localMessage);
                                MessageBody.SystemMessageBody.Platform.Bubble.Item item3 = (MessageBody.SystemMessageBody.Platform.Bubble.Item) bubble;
                                String id2 = item3.getId();
                                String builder3 = new Uri.Builder().scheme("https").authority("avito.ru").appendPath(item3.getId()).toString();
                                Intrinsics.checkNotNullExpressionValue(builder3, "Uri.Builder().scheme(\"ht…)\n            .toString()");
                                item = new MessageContextData.Item(messengerConfig, from8, id2, builder3);
                            } else {
                                Logs.debug$default("ContextDataFactory", "Message body or bubble type is not supported: " + bodyOrBubble, null, 4, null);
                            }
                            return null;
                        }
                    }
                }
                return link;
            }
            return item;
        }
    }
}
