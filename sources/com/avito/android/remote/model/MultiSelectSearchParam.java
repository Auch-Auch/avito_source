package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u001a2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/MultiSelectSearchParam;", "Lcom/avito/android/remote/model/SearchParam;", "", "", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "value", "Ljava/util/List;", "getValue", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MultiSelectSearchParam extends SearchParam<List<? extends String>> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MultiSelectSearchParam> CREATOR = Parcels.creator(MultiSelectSearchParam$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/MultiSelectSearchParam$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/MultiSelectSearchParam;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public MultiSelectSearchParam(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(value)");
        this.value = unmodifiableList;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List of values cannot be empty");
        }
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(MultiSelectSearchParam.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.MultiSelectSearchParam");
        return !(Intrinsics.areEqual(getValue(), ((MultiSelectSearchParam) obj).getValue()) ^ true);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MultiSelectSearchParam(value=");
        L.append(getValue());
        L.append(')');
        return L.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.os.Parcel */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeStringList(getValue());
    }

    /* Return type fixed from 'java.util.List<java.lang.String>' to match base method */
    @Override // com.avito.android.remote.model.SearchParam
    @NotNull
    public List<? extends String> getValue() {
        return this.value;
    }
}
