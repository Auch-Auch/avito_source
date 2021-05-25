package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.text.Editable;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEvent;", "", "Landroid/widget/TextView;", "component1", "()Landroid/widget/TextView;", "Landroid/text/Editable;", "component2", "()Landroid/text/Editable;", "view", "editable", "copy", "(Landroid/widget/TextView;Landroid/text/Editable;)Lcom/jakewharton/rxbinding3/widget/TextViewAfterTextChangeEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Landroid/text/Editable;", "getEditable", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "getView", "<init>", "(Landroid/widget/TextView;Landroid/text/Editable;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class TextViewAfterTextChangeEvent {
    @NotNull
    public final TextView a;
    @Nullable
    public final Editable b;

    public TextViewAfterTextChangeEvent(@NotNull TextView textView, @Nullable Editable editable) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        this.a = textView;
        this.b = editable;
    }

    public static /* synthetic */ TextViewAfterTextChangeEvent copy$default(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent, TextView textView, Editable editable, int i, Object obj) {
        if ((i & 1) != 0) {
            textView = textViewAfterTextChangeEvent.a;
        }
        if ((i & 2) != 0) {
            editable = textViewAfterTextChangeEvent.b;
        }
        return textViewAfterTextChangeEvent.copy(textView, editable);
    }

    @NotNull
    public final TextView component1() {
        return this.a;
    }

    @Nullable
    public final Editable component2() {
        return this.b;
    }

    @NotNull
    public final TextViewAfterTextChangeEvent copy(@NotNull TextView textView, @Nullable Editable editable) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        return new TextViewAfterTextChangeEvent(textView, editable);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextViewAfterTextChangeEvent)) {
            return false;
        }
        TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
        return Intrinsics.areEqual(this.a, textViewAfterTextChangeEvent.a) && Intrinsics.areEqual(this.b, textViewAfterTextChangeEvent.b);
    }

    @Nullable
    public final Editable getEditable() {
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
        Editable editable = this.b;
        if (editable != null) {
            i = editable.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextViewAfterTextChangeEvent(view=");
        L.append(this.a);
        L.append(", editable=");
        L.append((Object) this.b);
        L.append(")");
        return L.toString();
    }
}
