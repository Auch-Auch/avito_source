package com.avito.android.category;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/category/CategoryInteractorState;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Location;", "component1", "()Lcom/avito/android/remote/model/Location;", "location", "copy", "(Lcom/avito/android/remote/model/Location;)Lcom/avito/android/category/CategoryInteractorState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Location;", "getLocation", "<init>", "(Lcom/avito/android/remote/model/Location;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryInteractorState implements Parcelable {
    public static final Parcelable.Creator<CategoryInteractorState> CREATOR = new Creator();
    @Nullable
    public final Location a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryInteractorState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryInteractorState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CategoryInteractorState((Location) parcel.readParcelable(CategoryInteractorState.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryInteractorState[] newArray(int i) {
            return new CategoryInteractorState[i];
        }
    }

    public CategoryInteractorState(@Nullable Location location) {
        this.a = location;
    }

    public static /* synthetic */ CategoryInteractorState copy$default(CategoryInteractorState categoryInteractorState, Location location, int i, Object obj) {
        if ((i & 1) != 0) {
            location = categoryInteractorState.a;
        }
        return categoryInteractorState.copy(location);
    }

    @Nullable
    public final Location component1() {
        return this.a;
    }

    @NotNull
    public final CategoryInteractorState copy(@Nullable Location location) {
        return new CategoryInteractorState(location);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof CategoryInteractorState) && Intrinsics.areEqual(this.a, ((CategoryInteractorState) obj).a);
        }
        return true;
    }

    @Nullable
    public final Location getLocation() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Location location = this.a;
        if (location != null) {
            return location.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryInteractorState(location=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
    }
}
