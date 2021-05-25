package com.avito.android.messenger.conversation.adapter.text;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.adapter.Highlightable;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0012J1\u0010\u000b\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/adapter/Highlightable;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;", "textList", "Lkotlin/Function1;", "", "", "onOpenInBrowser", "setMessage", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLinkLongClickListener", "(Lkotlin/jvm/functions/Function1;)V", "showCopiedMessage", "()V", "TextChunk", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface TextMessageView extends ItemView, Highlightable, MessageViewClicks {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TextMessageView textMessageView) {
            ItemView.DefaultImpls.onUnbind(textMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;", "", "", "getText", "()Ljava/lang/CharSequence;", "text", "<init>", "()V", "Emoji", HttpHeaders.LINK, "Text", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Text;", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Emoji;", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Link;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class TextChunk {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Emoji;", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;", "", "component1", "()Ljava/lang/CharSequence;", "text", "copy", "(Ljava/lang/CharSequence;)Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Emoji;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getText", "<init>", "(Ljava/lang/CharSequence;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Emoji extends TextChunk {
            @NotNull
            public final CharSequence a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Emoji(@NotNull CharSequence charSequence) {
                super(null);
                Intrinsics.checkNotNullParameter(charSequence, "text");
                this.a = charSequence;
            }

            public static /* synthetic */ Emoji copy$default(Emoji emoji, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = emoji.getText();
                }
                return emoji.copy(charSequence);
            }

            @NotNull
            public final CharSequence component1() {
                return getText();
            }

            @NotNull
            public final Emoji copy(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "text");
                return new Emoji(charSequence);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Emoji) && Intrinsics.areEqual(getText(), ((Emoji) obj).getText());
                }
                return true;
            }

            @Override // com.avito.android.messenger.conversation.adapter.text.TextMessageView.TextChunk
            @NotNull
            public CharSequence getText() {
                return this.a;
            }

            public int hashCode() {
                CharSequence text = getText();
                if (text != null) {
                    return text.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Emoji(text=");
                L.append(getText());
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Link;", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;", "", "component1", "()Ljava/lang/CharSequence;", "text", "copy", "(Ljava/lang/CharSequence;)Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Link;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getText", "<init>", "(Ljava/lang/CharSequence;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Link extends TextChunk {
            @NotNull
            public final CharSequence a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Link(@NotNull CharSequence charSequence) {
                super(null);
                Intrinsics.checkNotNullParameter(charSequence, "text");
                this.a = charSequence;
            }

            public static /* synthetic */ Link copy$default(Link link, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = link.getText();
                }
                return link.copy(charSequence);
            }

            @NotNull
            public final CharSequence component1() {
                return getText();
            }

            @NotNull
            public final Link copy(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "text");
                return new Link(charSequence);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Link) && Intrinsics.areEqual(getText(), ((Link) obj).getText());
                }
                return true;
            }

            @Override // com.avito.android.messenger.conversation.adapter.text.TextMessageView.TextChunk
            @NotNull
            public CharSequence getText() {
                return this.a;
            }

            public int hashCode() {
                CharSequence text = getText();
                if (text != null) {
                    return text.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Link(text=");
                L.append(getText());
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Text;", "Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk;", "", "component1", "()Ljava/lang/CharSequence;", "text", "copy", "(Ljava/lang/CharSequence;)Lcom/avito/android/messenger/conversation/adapter/text/TextMessageView$TextChunk$Text;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getText", "<init>", "(Ljava/lang/CharSequence;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Text extends TextChunk {
            @NotNull
            public final CharSequence a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Text(@NotNull CharSequence charSequence) {
                super(null);
                Intrinsics.checkNotNullParameter(charSequence, "text");
                this.a = charSequence;
            }

            public static /* synthetic */ Text copy$default(Text text, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = text.getText();
                }
                return text.copy(charSequence);
            }

            @NotNull
            public final CharSequence component1() {
                return getText();
            }

            @NotNull
            public final Text copy(@NotNull CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "text");
                return new Text(charSequence);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Text) && Intrinsics.areEqual(getText(), ((Text) obj).getText());
                }
                return true;
            }

            @Override // com.avito.android.messenger.conversation.adapter.text.TextMessageView.TextChunk
            @NotNull
            public CharSequence getText() {
                return this.a;
            }

            public int hashCode() {
                CharSequence text = getText();
                if (text != null) {
                    return text.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Text(text=");
                L.append(getText());
                L.append(")");
                return L.toString();
            }
        }

        public TextChunk() {
        }

        @NotNull
        public abstract CharSequence getText();

        public TextChunk(j jVar) {
        }
    }

    void setLinkLongClickListener(@NotNull Function1<? super String, Unit> function1);

    void setMessage(@NotNull List<? extends TextChunk> list, @NotNull Function1<? super String, Unit> function1);

    void showCopiedMessage();
}
