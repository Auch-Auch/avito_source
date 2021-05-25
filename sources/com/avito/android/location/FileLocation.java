package com.avito.android.location;

import a2.g.r.g;
import android.util.SparseArray;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.parse.adapter.SparseArrayTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u00016Bc\u0012\u0006\u0010-\u001a\u00020\u001d\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u00100\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b4\u00105R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010-\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017R\u0019\u00103\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b2\u0010\u0017¨\u00067"}, d2 = {"Lcom/avito/android/location/FileLocation;", "", "", "j", "Ljava/lang/Boolean;", "getForcedLocationForRecommendation", "()Ljava/lang/Boolean;", "forcedLocationForRecommendation", "Lcom/avito/android/location/FileLocation$Parent;", g.a, "Lcom/avito/android/location/FileLocation$Parent;", "getParent", "()Lcom/avito/android/location/FileLocation$Parent;", "parent", "", "h", "J", "getTimestamp", "()J", "timestamp", "f", "Z", "getHasDistricts", "()Z", "hasDistricts", "d", "getHasChildren", "hasChildren", "Landroid/util/SparseArray;", "", AuthSource.BOOKING_ORDER, "Landroid/util/SparseArray;", "getNames", "()Landroid/util/SparseArray;", "names", "Lcom/avito/android/remote/model/Coordinates;", "i", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "coordinates", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "c", "getHasMetro", "hasMetro", "e", "getHasDirections", "hasDirections", "<init>", "(Ljava/lang/String;Landroid/util/SparseArray;ZZZZLcom/avito/android/location/FileLocation$Parent;JLcom/avito/android/remote/model/Coordinates;Ljava/lang/Boolean;)V", "Parent", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class FileLocation {
    @NotNull
    public final String a;
    @JsonAdapter(SparseArrayTypeAdapter.class)
    @NotNull
    public final SparseArray<String> b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    @Nullable
    public final Parent g;
    public final long h;
    @Nullable
    public final Coordinates i;
    @Nullable
    public final Boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/location/FileLocation$Parent;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Landroid/util/SparseArray;", AuthSource.BOOKING_ORDER, "Landroid/util/SparseArray;", "getNames", "()Landroid/util/SparseArray;", "names", "<init>", "(Ljava/lang/String;Landroid/util/SparseArray;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parent {
        @NotNull
        public final String a;
        @NotNull
        public final SparseArray<String> b;

        public Parent(@NotNull String str, @NotNull SparseArray<String> sparseArray) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(sparseArray, "names");
            this.a = str;
            this.b = sparseArray;
        }

        @NotNull
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final SparseArray<String> getNames() {
            return this.b;
        }
    }

    public FileLocation(@NotNull String str, @NotNull SparseArray<String> sparseArray, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Parent parent, long j2, @Nullable Coordinates coordinates, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(sparseArray, "names");
        this.a = str;
        this.b = sparseArray;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = parent;
        this.h = j2;
        this.i = coordinates;
        this.j = bool;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.i;
    }

    @Nullable
    public final Boolean getForcedLocationForRecommendation() {
        return this.j;
    }

    public final boolean getHasChildren() {
        return this.d;
    }

    public final boolean getHasDirections() {
        return this.e;
    }

    public final boolean getHasDistricts() {
        return this.f;
    }

    public final boolean getHasMetro() {
        return this.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final SparseArray<String> getNames() {
        return this.b;
    }

    @Nullable
    public final Parent getParent() {
        return this.g;
    }

    public final long getTimestamp() {
        return this.h;
    }
}
