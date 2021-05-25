package com.jakewharton.rxbinding3.appcompat;

import a2.b.a.a.a;
import androidx.appcompat.widget.SearchView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/jakewharton/rxbinding3/appcompat/SearchViewQueryTextEvent;", "", "Landroidx/appcompat/widget/SearchView;", "component1", "()Landroidx/appcompat/widget/SearchView;", "", "component2", "()Ljava/lang/CharSequence;", "", "component3", "()Z", "view", "queryText", "isSubmitted", "copy", "(Landroidx/appcompat/widget/SearchView;Ljava/lang/CharSequence;Z)Lcom/jakewharton/rxbinding3/appcompat/SearchViewQueryTextEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Z", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/SearchView;", "getView", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getQueryText", "<init>", "(Landroidx/appcompat/widget/SearchView;Ljava/lang/CharSequence;Z)V", "rxbinding-appcompat_release"}, k = 1, mv = {1, 4, 0})
public final class SearchViewQueryTextEvent {
    @NotNull
    public final SearchView a;
    @NotNull
    public final CharSequence b;
    public final boolean c;

    public SearchViewQueryTextEvent(@NotNull SearchView searchView, @NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        Intrinsics.checkParameterIsNotNull(charSequence, "queryText");
        this.a = searchView;
        this.b = charSequence;
        this.c = z;
    }

    public static /* synthetic */ SearchViewQueryTextEvent copy$default(SearchViewQueryTextEvent searchViewQueryTextEvent, SearchView searchView, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            searchView = searchViewQueryTextEvent.a;
        }
        if ((i & 2) != 0) {
            charSequence = searchViewQueryTextEvent.b;
        }
        if ((i & 4) != 0) {
            z = searchViewQueryTextEvent.c;
        }
        return searchViewQueryTextEvent.copy(searchView, charSequence, z);
    }

    @NotNull
    public final SearchView component1() {
        return this.a;
    }

    @NotNull
    public final CharSequence component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final SearchViewQueryTextEvent copy(@NotNull SearchView searchView, @NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        Intrinsics.checkParameterIsNotNull(charSequence, "queryText");
        return new SearchViewQueryTextEvent(searchView, charSequence, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SearchViewQueryTextEvent) {
                SearchViewQueryTextEvent searchViewQueryTextEvent = (SearchViewQueryTextEvent) obj;
                if (Intrinsics.areEqual(this.a, searchViewQueryTextEvent.a) && Intrinsics.areEqual(this.b, searchViewQueryTextEvent.b)) {
                    if (this.c == searchViewQueryTextEvent.c) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final CharSequence getQueryText() {
        return this.b;
    }

    @NotNull
    public final SearchView getView() {
        return this.a;
    }

    public int hashCode() {
        SearchView searchView = this.a;
        int i = 0;
        int hashCode = (searchView != null ? searchView.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            i = charSequence.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isSubmitted() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchViewQueryTextEvent(view=");
        L.append(this.a);
        L.append(", queryText=");
        L.append(this.b);
        L.append(", isSubmitted=");
        return a.B(L, this.c, ")");
    }
}
