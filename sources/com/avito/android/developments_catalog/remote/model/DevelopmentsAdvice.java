package com.avito.android.developments_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;", "Landroid/os/Parcelable;", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;", "component1", "()Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;", "component2", "teaser", "form", "copy", "(Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;)Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdvice;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;", "getTeaser", "getForm", "<init>", "(Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsAdvice implements Parcelable {
    public static final Parcelable.Creator<DevelopmentsAdvice> CREATOR = new Creator();
    @SerializedName("form")
    @NotNull
    private final DevelopmentsAdviceView form;
    @SerializedName("teaser")
    @NotNull
    private final DevelopmentsAdviceView teaser;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DevelopmentsAdvice> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsAdvice createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Parcelable.Creator<DevelopmentsAdviceView> creator = DevelopmentsAdviceView.CREATOR;
            return new DevelopmentsAdvice(creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DevelopmentsAdvice[] newArray(int i) {
            return new DevelopmentsAdvice[i];
        }
    }

    public DevelopmentsAdvice(@NotNull DevelopmentsAdviceView developmentsAdviceView, @NotNull DevelopmentsAdviceView developmentsAdviceView2) {
        Intrinsics.checkNotNullParameter(developmentsAdviceView, "teaser");
        Intrinsics.checkNotNullParameter(developmentsAdviceView2, "form");
        this.teaser = developmentsAdviceView;
        this.form = developmentsAdviceView2;
    }

    public static /* synthetic */ DevelopmentsAdvice copy$default(DevelopmentsAdvice developmentsAdvice, DevelopmentsAdviceView developmentsAdviceView, DevelopmentsAdviceView developmentsAdviceView2, int i, Object obj) {
        if ((i & 1) != 0) {
            developmentsAdviceView = developmentsAdvice.teaser;
        }
        if ((i & 2) != 0) {
            developmentsAdviceView2 = developmentsAdvice.form;
        }
        return developmentsAdvice.copy(developmentsAdviceView, developmentsAdviceView2);
    }

    @NotNull
    public final DevelopmentsAdviceView component1() {
        return this.teaser;
    }

    @NotNull
    public final DevelopmentsAdviceView component2() {
        return this.form;
    }

    @NotNull
    public final DevelopmentsAdvice copy(@NotNull DevelopmentsAdviceView developmentsAdviceView, @NotNull DevelopmentsAdviceView developmentsAdviceView2) {
        Intrinsics.checkNotNullParameter(developmentsAdviceView, "teaser");
        Intrinsics.checkNotNullParameter(developmentsAdviceView2, "form");
        return new DevelopmentsAdvice(developmentsAdviceView, developmentsAdviceView2);
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
        if (!(obj instanceof DevelopmentsAdvice)) {
            return false;
        }
        DevelopmentsAdvice developmentsAdvice = (DevelopmentsAdvice) obj;
        return Intrinsics.areEqual(this.teaser, developmentsAdvice.teaser) && Intrinsics.areEqual(this.form, developmentsAdvice.form);
    }

    @NotNull
    public final DevelopmentsAdviceView getForm() {
        return this.form;
    }

    @NotNull
    public final DevelopmentsAdviceView getTeaser() {
        return this.teaser;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DevelopmentsAdviceView developmentsAdviceView = this.teaser;
        int i = 0;
        int hashCode = (developmentsAdviceView != null ? developmentsAdviceView.hashCode() : 0) * 31;
        DevelopmentsAdviceView developmentsAdviceView2 = this.form;
        if (developmentsAdviceView2 != null) {
            i = developmentsAdviceView2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DevelopmentsAdvice(teaser=");
        L.append(this.teaser);
        L.append(", form=");
        L.append(this.form);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.teaser.writeToParcel(parcel, 0);
        this.form.writeToParcel(parcel, 0);
    }
}
