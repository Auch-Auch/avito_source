package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.view.View;
import android.widget.AdapterView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickEvent;", "", "Landroid/widget/AdapterView;", "component1", "()Landroid/widget/AdapterView;", "Landroid/view/View;", "component2", "()Landroid/view/View;", "", "component3", "()I", "", "component4", "()J", "view", "clickedView", VKApiConst.POSITION, "id", "copy", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)Lcom/jakewharton/rxbinding3/widget/AdapterViewItemLongClickEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/widget/AdapterView;", "getView", "c", "I", "getPosition", "d", "J", "getId", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getClickedView", "<init>", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class AdapterViewItemLongClickEvent {
    @NotNull
    public final AdapterView<?> a;
    @Nullable
    public final View b;
    public final int c;
    public final long d;

    public AdapterViewItemLongClickEvent(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.a = adapterView;
        this.b = view;
        this.c = i;
        this.d = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.jakewharton.rxbinding3.widget.AdapterViewItemLongClickEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdapterViewItemLongClickEvent copy$default(AdapterViewItemLongClickEvent adapterViewItemLongClickEvent, AdapterView adapterView, View view, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adapterView = adapterViewItemLongClickEvent.a;
        }
        if ((i2 & 2) != 0) {
            view = adapterViewItemLongClickEvent.b;
        }
        if ((i2 & 4) != 0) {
            i = adapterViewItemLongClickEvent.c;
        }
        if ((i2 & 8) != 0) {
            j = adapterViewItemLongClickEvent.d;
        }
        return adapterViewItemLongClickEvent.copy(adapterView, view, i, j);
    }

    @NotNull
    public final AdapterView<?> component1() {
        return this.a;
    }

    @Nullable
    public final View component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    @NotNull
    public final AdapterViewItemLongClickEvent copy(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        return new AdapterViewItemLongClickEvent(adapterView, view, i, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AdapterViewItemLongClickEvent) {
                AdapterViewItemLongClickEvent adapterViewItemLongClickEvent = (AdapterViewItemLongClickEvent) obj;
                if (Intrinsics.areEqual(this.a, adapterViewItemLongClickEvent.a) && Intrinsics.areEqual(this.b, adapterViewItemLongClickEvent.b)) {
                    if (this.c == adapterViewItemLongClickEvent.c) {
                        if (this.d == adapterViewItemLongClickEvent.d) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final View getClickedView() {
        return this.b;
    }

    public final long getId() {
        return this.d;
    }

    public final int getPosition() {
        return this.c;
    }

    @NotNull
    public final AdapterView<?> getView() {
        return this.a;
    }

    public int hashCode() {
        AdapterView<?> adapterView = this.a;
        int i = 0;
        int hashCode = (adapterView != null ? adapterView.hashCode() : 0) * 31;
        View view = this.b;
        if (view != null) {
            i = view.hashCode();
        }
        long j = this.d;
        return ((((hashCode + i) * 31) + this.c) * 31) + ((int) (j ^ (j >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdapterViewItemLongClickEvent(view=");
        L.append(this.a);
        L.append(", clickedView=");
        L.append(this.b);
        L.append(", position=");
        L.append(this.c);
        L.append(", id=");
        return a.l(L, this.d, ")");
    }
}
