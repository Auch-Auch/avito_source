package com.avito.android.inline_filters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/inline_filters/State;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/search/InlineFilters;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/search/InlineFilters;", "getInlineFilters", "()Lcom/avito/android/remote/model/search/InlineFilters;", "inlineFilters", "Lcom/avito/android/remote/model/SearchParams;", "c", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "()Lcom/avito/android/remote/model/SearchParams;", "searchParams", "d", "Landroid/os/Parcelable;", "getViewState", "()Landroid/os/Parcelable;", "viewState", "Lcom/avito/android/remote/model/search/Filter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/search/Filter;", "getOpenedFilter", "()Lcom/avito/android/remote/model/search/Filter;", "openedFilter", "<init>", "(Lcom/avito/android/remote/model/search/InlineFilters;Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/SearchParams;Landroid/os/Parcelable;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class State implements Parcelable {
    public static final Parcelable.Creator<State> CREATOR = new Creator();
    @Nullable
    public final InlineFilters a;
    @Nullable
    public final Filter b;
    @Nullable
    public final SearchParams c;
    @Nullable
    public final Parcelable d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<State> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final State createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new State((InlineFilters) parcel.readParcelable(State.class.getClassLoader()), (Filter) parcel.readParcelable(State.class.getClassLoader()), (SearchParams) parcel.readParcelable(State.class.getClassLoader()), parcel.readParcelable(State.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final State[] newArray(int i) {
            return new State[i];
        }
    }

    public State(@Nullable InlineFilters inlineFilters, @Nullable Filter filter, @Nullable SearchParams searchParams, @Nullable Parcelable parcelable) {
        this.a = inlineFilters;
        this.b = filter;
        this.c = searchParams;
        this.d = parcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final InlineFilters getInlineFilters() {
        return this.a;
    }

    @Nullable
    public final Filter getOpenedFilter() {
        return this.b;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.c;
    }

    @Nullable
    public final Parcelable getViewState() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }
}
