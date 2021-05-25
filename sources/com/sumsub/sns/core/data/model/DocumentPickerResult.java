package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJL\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010\u0004R\u0013\u0010/\u001a\u00020\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b/\u00100R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b2\u0010\u0007¨\u00065"}, d2 = {"Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "Ljava/io/File;", "component1", "()Ljava/io/File;", "component2", "component3", "component4", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "component5", "()Lcom/sumsub/sns/core/data/model/IdentitySide;", "document", "raw", "country", "type", "side", "copy", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;)Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "getSide", "c", "Ljava/lang/String;", "getCountry", AuthSource.BOOKING_ORDER, "Ljava/io/File;", "getRaw", "d", "getType", "isEmpty", "()Z", AuthSource.SEND_ABUSE, "getDocument", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class DocumentPickerResult implements Parcelable {
    public static final Parcelable.Creator<DocumentPickerResult> CREATOR = new Creator();
    @Nullable
    public final File a;
    @Nullable
    public final File b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final IdentitySide e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DocumentPickerResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DocumentPickerResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DocumentPickerResult((File) parcel.readSerializable(), (File) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (IdentitySide) Enum.valueOf(IdentitySide.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DocumentPickerResult[] newArray(int i) {
            return new DocumentPickerResult[i];
        }
    }

    public DocumentPickerResult() {
        this(null, null, null, null, null, 31, null);
    }

    public DocumentPickerResult(@Nullable File file, @Nullable File file2, @Nullable String str, @Nullable String str2, @Nullable IdentitySide identitySide) {
        this.a = file;
        this.b = file2;
        this.c = str;
        this.d = str2;
        this.e = identitySide;
    }

    public static /* synthetic */ DocumentPickerResult copy$default(DocumentPickerResult documentPickerResult, File file, File file2, String str, String str2, IdentitySide identitySide, int i, Object obj) {
        if ((i & 1) != 0) {
            file = documentPickerResult.a;
        }
        if ((i & 2) != 0) {
            file2 = documentPickerResult.b;
        }
        if ((i & 4) != 0) {
            str = documentPickerResult.c;
        }
        if ((i & 8) != 0) {
            str2 = documentPickerResult.d;
        }
        if ((i & 16) != 0) {
            identitySide = documentPickerResult.e;
        }
        return documentPickerResult.copy(file, file2, str, str2, identitySide);
    }

    @Nullable
    public final File component1() {
        return this.a;
    }

    @Nullable
    public final File component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final IdentitySide component5() {
        return this.e;
    }

    @NotNull
    public final DocumentPickerResult copy(@Nullable File file, @Nullable File file2, @Nullable String str, @Nullable String str2, @Nullable IdentitySide identitySide) {
        return new DocumentPickerResult(file, file2, str, str2, identitySide);
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
        if (!(obj instanceof DocumentPickerResult)) {
            return false;
        }
        DocumentPickerResult documentPickerResult = (DocumentPickerResult) obj;
        return Intrinsics.areEqual(this.a, documentPickerResult.a) && Intrinsics.areEqual(this.b, documentPickerResult.b) && Intrinsics.areEqual(this.c, documentPickerResult.c) && Intrinsics.areEqual(this.d, documentPickerResult.d) && Intrinsics.areEqual(this.e, documentPickerResult.e);
    }

    @Nullable
    public final String getCountry() {
        return this.c;
    }

    @Nullable
    public final File getDocument() {
        return this.a;
    }

    @Nullable
    public final File getRaw() {
        return this.b;
    }

    @Nullable
    public final IdentitySide getSide() {
        return this.e;
    }

    @Nullable
    public final String getType() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        File file = this.a;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        File file2 = this.b;
        int hashCode2 = (hashCode + (file2 != null ? file2.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        IdentitySide identitySide = this.e;
        if (identitySide != null) {
            i = identitySide.hashCode();
        }
        return hashCode4 + i;
    }

    public final boolean isEmpty() {
        return this.a == null || this.b == null;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("type=");
        L.append(this.d);
        L.append(", document=");
        File file = this.a;
        String str = null;
        L.append(file != null ? file.getAbsolutePath() : null);
        L.append(", raw=");
        File file2 = this.b;
        L.append(file2 != null ? file2.getAbsolutePath() : null);
        L.append(", side=");
        IdentitySide identitySide = this.e;
        if (identitySide != null) {
            str = identitySide.getValue();
        }
        L.append(str);
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.a);
        parcel.writeSerializable(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        IdentitySide identitySide = this.e;
        if (identitySide != null) {
            parcel.writeInt(1);
            parcel.writeString(identitySide.name());
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DocumentPickerResult(File file, File file2, String str, String str2, IdentitySide identitySide, int i, j jVar) {
        this((i & 1) != 0 ? null : file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : identitySide);
    }
}
