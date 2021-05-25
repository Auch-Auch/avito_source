package com.avito.android.category;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/avito/android/category/CategoryPresenterState;", "Landroid/os/Parcelable;", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/Location;", "", "cachedRequest", "()Lkotlin/Pair;", "", "Lcom/avito/android/category/ListElement;", "component1", "()Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "requestLocation", "requestCategory", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lcom/avito/android/category/CategoryPresenterState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getElements", "c", "Ljava/lang/String;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/Location;Ljava/lang/String;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryPresenterState implements Parcelable {
    public static final Parcelable.Creator<CategoryPresenterState> CREATOR = new Creator();
    @Nullable
    public final List<ListElement> a;
    public final Location b;
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryPresenterState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryPresenterState createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((ListElement) parcel.readParcelable(CategoryPresenterState.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CategoryPresenterState(arrayList, (Location) parcel.readParcelable(CategoryPresenterState.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryPresenterState[] newArray(int i) {
            return new CategoryPresenterState[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.category.ListElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public CategoryPresenterState(@Nullable List<? extends ListElement> list, @Nullable Location location, @Nullable String str) {
        this.a = list;
        this.b = location;
        this.c = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.category.CategoryPresenterState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryPresenterState copy$default(CategoryPresenterState categoryPresenterState, List list, Location location, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = categoryPresenterState.a;
        }
        if ((i & 2) != 0) {
            location = categoryPresenterState.b;
        }
        if ((i & 4) != 0) {
            str = categoryPresenterState.c;
        }
        return categoryPresenterState.copy(list, location, str);
    }

    @Nullable
    public final Pair<Location, String> cachedRequest() {
        Location location = this.b;
        if (location == null && this.c == null) {
            return null;
        }
        return new Pair<>(location, this.c);
    }

    @Nullable
    public final List<ListElement> component1() {
        return this.a;
    }

    @NotNull
    public final CategoryPresenterState copy(@Nullable List<? extends ListElement> list, @Nullable Location location, @Nullable String str) {
        return new CategoryPresenterState(list, location, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryPresenterState)) {
            return false;
        }
        CategoryPresenterState categoryPresenterState = (CategoryPresenterState) obj;
        return Intrinsics.areEqual(this.a, categoryPresenterState.a) && Intrinsics.areEqual(this.b, categoryPresenterState.b) && Intrinsics.areEqual(this.c, categoryPresenterState.c);
    }

    @Nullable
    public final List<ListElement> getElements() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<ListElement> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Location location = this.b;
        int hashCode2 = (hashCode + (location != null ? location.hashCode() : 0)) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryPresenterState(elements=");
        L.append(this.a);
        L.append(", requestLocation=");
        L.append(this.b);
        L.append(", requestCategory=");
        return a.t(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<ListElement> list = this.a;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((ListElement) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryPresenterState(List list, Location location, String str, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : location, (i & 4) != 0 ? null : str);
    }
}
