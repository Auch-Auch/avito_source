package com.jakewharton.rxbinding4.widget;

import a2.b.a.a.a;
import android.view.View;
import android.widget.AdapterView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\r¨\u0006+"}, d2 = {"Lcom/jakewharton/rxbinding4/widget/AdapterViewItemSelectionEvent;", "Lcom/jakewharton/rxbinding4/widget/AdapterViewSelectionEvent;", "Landroid/widget/AdapterView;", "component1", "()Landroid/widget/AdapterView;", "Landroid/view/View;", "component2", "()Landroid/view/View;", "", "component3", "()I", "", "component4", "()J", "view", "selectedView", VKApiConst.POSITION, "id", "copy", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)Lcom/jakewharton/rxbinding4/widget/AdapterViewItemSelectionEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/widget/AdapterView;", "getView", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getSelectedView", "c", "I", "getPosition", "d", "J", "getId", "<init>", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class AdapterViewItemSelectionEvent extends AdapterViewSelectionEvent {
    @NotNull
    public final AdapterView<?> a;
    @Nullable
    public final View b;
    public final int c;
    public final long d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdapterViewItemSelectionEvent(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        super(null);
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.a = adapterView;
        this.b = view;
        this.c = i;
        this.d = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.jakewharton.rxbinding4.widget.AdapterViewItemSelectionEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdapterViewItemSelectionEvent copy$default(AdapterViewItemSelectionEvent adapterViewItemSelectionEvent, AdapterView adapterView, View view, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adapterView = adapterViewItemSelectionEvent.getView();
        }
        if ((i2 & 2) != 0) {
            view = adapterViewItemSelectionEvent.b;
        }
        if ((i2 & 4) != 0) {
            i = adapterViewItemSelectionEvent.c;
        }
        if ((i2 & 8) != 0) {
            j = adapterViewItemSelectionEvent.d;
        }
        return adapterViewItemSelectionEvent.copy(adapterView, view, i, j);
    }

    @NotNull
    public final AdapterView<?> component1() {
        return getView();
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
    public final AdapterViewItemSelectionEvent copy(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        return new AdapterViewItemSelectionEvent(adapterView, view, i, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdapterViewItemSelectionEvent)) {
            return false;
        }
        AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = (AdapterViewItemSelectionEvent) obj;
        return Intrinsics.areEqual(getView(), adapterViewItemSelectionEvent.getView()) && Intrinsics.areEqual(this.b, adapterViewItemSelectionEvent.b) && this.c == adapterViewItemSelectionEvent.c && this.d == adapterViewItemSelectionEvent.d;
    }

    public final long getId() {
        return this.d;
    }

    public final int getPosition() {
        return this.c;
    }

    @Nullable
    public final View getSelectedView() {
        return this.b;
    }

    @Override // com.jakewharton.rxbinding4.widget.AdapterViewSelectionEvent
    @NotNull
    public AdapterView<?> getView() {
        return this.a;
    }

    public int hashCode() {
        AdapterView<?> view = getView();
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        View view2 = this.b;
        if (view2 != null) {
            i = view2.hashCode();
        }
        return ((((hashCode + i) * 31) + this.c) * 31) + c.a(this.d);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdapterViewItemSelectionEvent(view=");
        L.append(getView());
        L.append(", selectedView=");
        L.append(this.b);
        L.append(", position=");
        L.append(this.c);
        L.append(", id=");
        return a.l(L, this.d, ")");
    }
}
