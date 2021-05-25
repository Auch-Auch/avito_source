package com.avito.android.brandspace.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceAboutParagraphElement;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()Ljava/lang/String;", "component2", "title", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/remote/model/BrandspaceAboutParagraphElement;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAboutParagraphElement implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceAboutParagraphElement> CREATOR = new Creator();
    @SerializedName("text")
    @Nullable
    private final String text;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceAboutParagraphElement> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAboutParagraphElement createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceAboutParagraphElement(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAboutParagraphElement[] newArray(int i) {
            return new BrandspaceAboutParagraphElement[i];
        }
    }

    public BrandspaceAboutParagraphElement(@Nullable String str, @Nullable String str2) {
        this.title = str;
        this.text = str2;
    }

    public static /* synthetic */ BrandspaceAboutParagraphElement copy$default(BrandspaceAboutParagraphElement brandspaceAboutParagraphElement, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brandspaceAboutParagraphElement.title;
        }
        if ((i & 2) != 0) {
            str2 = brandspaceAboutParagraphElement.text;
        }
        return brandspaceAboutParagraphElement.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final BrandspaceAboutParagraphElement copy(@Nullable String str, @Nullable String str2) {
        return new BrandspaceAboutParagraphElement(str, str2);
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
        if (!(obj instanceof BrandspaceAboutParagraphElement)) {
            return false;
        }
        BrandspaceAboutParagraphElement brandspaceAboutParagraphElement = (BrandspaceAboutParagraphElement) obj;
        return Intrinsics.areEqual(this.title, brandspaceAboutParagraphElement.title) && Intrinsics.areEqual(this.text, brandspaceAboutParagraphElement.text);
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceAboutParagraphElement(title=");
        L.append(this.title);
        L.append(", text=");
        return a.t(L, this.text, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.text);
    }
}
