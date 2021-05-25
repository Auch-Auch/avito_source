package com.jakewharton.rxbinding4.widget;

import a2.b.a.a.a;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lcom/jakewharton/rxbinding4/widget/TextViewTextChangeEvent;", "", "Landroid/widget/TextView;", "component1", "()Landroid/widget/TextView;", "", "component2", "()Ljava/lang/CharSequence;", "", "component3", "()I", "component4", "component5", "view", "text", Tracker.Events.CREATIVE_START, "before", "count", "copy", "(Landroid/widget/TextView;Ljava/lang/CharSequence;III)Lcom/jakewharton/rxbinding4/widget/TextViewTextChangeEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "getView", "c", "I", "getStart", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "e", "getCount", "d", "getBefore", "<init>", "(Landroid/widget/TextView;Ljava/lang/CharSequence;III)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class TextViewTextChangeEvent {
    @NotNull
    public final TextView a;
    @NotNull
    public final CharSequence b;
    public final int c;
    public final int d;
    public final int e;

    public TextViewTextChangeEvent(@NotNull TextView textView, @NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        this.a = textView;
        this.b = charSequence;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public static /* synthetic */ TextViewTextChangeEvent copy$default(TextViewTextChangeEvent textViewTextChangeEvent, TextView textView, CharSequence charSequence, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            textView = textViewTextChangeEvent.a;
        }
        if ((i4 & 2) != 0) {
            charSequence = textViewTextChangeEvent.b;
        }
        if ((i4 & 4) != 0) {
            i = textViewTextChangeEvent.c;
        }
        if ((i4 & 8) != 0) {
            i2 = textViewTextChangeEvent.d;
        }
        if ((i4 & 16) != 0) {
            i3 = textViewTextChangeEvent.e;
        }
        return textViewTextChangeEvent.copy(textView, charSequence, i, i2, i3);
    }

    @NotNull
    public final TextView component1() {
        return this.a;
    }

    @NotNull
    public final CharSequence component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @NotNull
    public final TextViewTextChangeEvent copy(@NotNull TextView textView, @NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        return new TextViewTextChangeEvent(textView, charSequence, i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextViewTextChangeEvent)) {
            return false;
        }
        TextViewTextChangeEvent textViewTextChangeEvent = (TextViewTextChangeEvent) obj;
        return Intrinsics.areEqual(this.a, textViewTextChangeEvent.a) && Intrinsics.areEqual(this.b, textViewTextChangeEvent.b) && this.c == textViewTextChangeEvent.c && this.d == textViewTextChangeEvent.d && this.e == textViewTextChangeEvent.e;
    }

    public final int getBefore() {
        return this.d;
    }

    public final int getCount() {
        return this.e;
    }

    public final int getStart() {
        return this.c;
    }

    @NotNull
    public final CharSequence getText() {
        return this.b;
    }

    @NotNull
    public final TextView getView() {
        return this.a;
    }

    public int hashCode() {
        TextView textView = this.a;
        int i = 0;
        int hashCode = (textView != null ? textView.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            i = charSequence.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextViewTextChangeEvent(view=");
        L.append(this.a);
        L.append(", text=");
        L.append(this.b);
        L.append(", start=");
        L.append(this.c);
        L.append(", before=");
        L.append(this.d);
        L.append(", count=");
        return a.j(L, this.e, ")");
    }
}
