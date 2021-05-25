package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.view.KeyEvent;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEvent;", "", "Landroid/widget/TextView;", "component1", "()Landroid/widget/TextView;", "", "component2", "()I", "Landroid/view/KeyEvent;", "component3", "()Landroid/view/KeyEvent;", "view", "actionId", "keyEvent", "copy", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Lcom/jakewharton/rxbinding3/widget/TextViewEditorActionEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Landroid/view/KeyEvent;", "getKeyEvent", AuthSource.BOOKING_ORDER, "I", "getActionId", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "getView", "<init>", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class TextViewEditorActionEvent {
    @NotNull
    public final TextView a;
    public final int b;
    @Nullable
    public final KeyEvent c;

    public TextViewEditorActionEvent(@NotNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        this.a = textView;
        this.b = i;
        this.c = keyEvent;
    }

    public static /* synthetic */ TextViewEditorActionEvent copy$default(TextViewEditorActionEvent textViewEditorActionEvent, TextView textView, int i, KeyEvent keyEvent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            textView = textViewEditorActionEvent.a;
        }
        if ((i2 & 2) != 0) {
            i = textViewEditorActionEvent.b;
        }
        if ((i2 & 4) != 0) {
            keyEvent = textViewEditorActionEvent.c;
        }
        return textViewEditorActionEvent.copy(textView, i, keyEvent);
    }

    @NotNull
    public final TextView component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @Nullable
    public final KeyEvent component3() {
        return this.c;
    }

    @NotNull
    public final TextViewEditorActionEvent copy(@NotNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        return new TextViewEditorActionEvent(textView, i, keyEvent);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof TextViewEditorActionEvent) {
                TextViewEditorActionEvent textViewEditorActionEvent = (TextViewEditorActionEvent) obj;
                if (Intrinsics.areEqual(this.a, textViewEditorActionEvent.a)) {
                    if (!(this.b == textViewEditorActionEvent.b) || !Intrinsics.areEqual(this.c, textViewEditorActionEvent.c)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getActionId() {
        return this.b;
    }

    @Nullable
    public final KeyEvent getKeyEvent() {
        return this.c;
    }

    @NotNull
    public final TextView getView() {
        return this.a;
    }

    public int hashCode() {
        TextView textView = this.a;
        int i = 0;
        int hashCode = (((textView != null ? textView.hashCode() : 0) * 31) + this.b) * 31;
        KeyEvent keyEvent = this.c;
        if (keyEvent != null) {
            i = keyEvent.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextViewEditorActionEvent(view=");
        L.append(this.a);
        L.append(", actionId=");
        L.append(this.b);
        L.append(", keyEvent=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
