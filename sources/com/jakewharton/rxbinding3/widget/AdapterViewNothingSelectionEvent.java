package com.jakewharton.rxbinding3.widget;

import a2.b.a.a.a;
import android.widget.AdapterView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0006\u001a\u00020\u00002\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewNothingSelectionEvent;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "Landroid/widget/AdapterView;", "component1", "()Landroid/widget/AdapterView;", "view", "copy", "(Landroid/widget/AdapterView;)Lcom/jakewharton/rxbinding3/widget/AdapterViewNothingSelectionEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/widget/AdapterView;", "getView", "<init>", "(Landroid/widget/AdapterView;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class AdapterViewNothingSelectionEvent extends AdapterViewSelectionEvent {
    @NotNull
    public final AdapterView<?> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdapterViewNothingSelectionEvent(@NotNull AdapterView<?> adapterView) {
        super(null);
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.a = adapterView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.jakewharton.rxbinding3.widget.AdapterViewNothingSelectionEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdapterViewNothingSelectionEvent copy$default(AdapterViewNothingSelectionEvent adapterViewNothingSelectionEvent, AdapterView adapterView, int i, Object obj) {
        if ((i & 1) != 0) {
            adapterView = adapterViewNothingSelectionEvent.getView();
        }
        return adapterViewNothingSelectionEvent.copy(adapterView);
    }

    @NotNull
    public final AdapterView<?> component1() {
        return getView();
    }

    @NotNull
    public final AdapterViewNothingSelectionEvent copy(@NotNull AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        return new AdapterViewNothingSelectionEvent(adapterView);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AdapterViewNothingSelectionEvent) && Intrinsics.areEqual(getView(), ((AdapterViewNothingSelectionEvent) obj).getView());
        }
        return true;
    }

    @Override // com.jakewharton.rxbinding3.widget.AdapterViewSelectionEvent
    @NotNull
    public AdapterView<?> getView() {
        return this.a;
    }

    public int hashCode() {
        AdapterView<?> view = getView();
        if (view != null) {
            return view.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdapterViewNothingSelectionEvent(view=");
        L.append(getView());
        L.append(")");
        return L.toString();
    }
}
