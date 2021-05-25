package com.avito.android.util;

import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/util/MultiStateInputChangePayload;", "", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "c", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getHtmlNode", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "htmlNode", "Lcom/avito/android/items/ItemWithState$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "state", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "<init>", "(Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;Lcom/avito/android/html_formatter/MutableHtmlNode;Lcom/avito/android/remote/model/text/AttributedText;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateInputChangePayload {
    @Nullable
    public final ItemWithState.State a;
    @Nullable
    public final String b;
    @Nullable
    public final MutableHtmlNode c;
    @Nullable
    public final AttributedText d;

    public MultiStateInputChangePayload(@Nullable ItemWithState.State state, @Nullable String str, @Nullable MutableHtmlNode mutableHtmlNode, @Nullable AttributedText attributedText) {
        this.a = state;
        this.b = str;
        this.c = mutableHtmlNode;
        this.d = attributedText;
    }

    @Nullable
    public final MutableHtmlNode getHtmlNode() {
        return this.c;
    }

    @Nullable
    public final AttributedText getMotivation() {
        return this.d;
    }

    @Nullable
    public final ItemWithState.State getState() {
        return this.a;
    }

    @Nullable
    public final String getValue() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiStateInputChangePayload(ItemWithState.State state, String str, MutableHtmlNode mutableHtmlNode, AttributedText attributedText, int i, j jVar) {
        this(state, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : mutableHtmlNode, (i & 8) != 0 ? null : attributedText);
    }
}
