package com.avito.android.messenger.channels.mvi.presenter;

import a2.b.a.a.a;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "component2", "()Ljava/lang/Integer;", "text", "icon", "copy", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getText", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getIcon", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessagePreview {
    @NotNull
    public final CharSequence a;
    @Nullable
    public final Integer b;

    public MessagePreview(@NotNull CharSequence charSequence, @DrawableRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.a = charSequence;
        this.b = num;
    }

    public static /* synthetic */ MessagePreview copy$default(MessagePreview messagePreview, CharSequence charSequence, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = messagePreview.a;
        }
        if ((i & 2) != 0) {
            num = messagePreview.b;
        }
        return messagePreview.copy(charSequence, num);
    }

    @NotNull
    public final CharSequence component1() {
        return this.a;
    }

    @Nullable
    public final Integer component2() {
        return this.b;
    }

    @NotNull
    public final MessagePreview copy(@NotNull CharSequence charSequence, @DrawableRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        return new MessagePreview(charSequence, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagePreview)) {
            return false;
        }
        MessagePreview messagePreview = (MessagePreview) obj;
        return Intrinsics.areEqual(this.a, messagePreview.a) && Intrinsics.areEqual(this.b, messagePreview.b);
    }

    @Nullable
    public final Integer getIcon() {
        return this.b;
    }

    @NotNull
    public final CharSequence getText() {
        return this.a;
    }

    public int hashCode() {
        CharSequence charSequence = this.a;
        int i = 0;
        int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Integer num = this.b;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessagePreview(text=");
        L.append(this.a);
        L.append(", icon=");
        return a.p(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessagePreview(CharSequence charSequence, Integer num, int i, j jVar) {
        this(charSequence, (i & 2) != 0 ? null : num);
    }
}
