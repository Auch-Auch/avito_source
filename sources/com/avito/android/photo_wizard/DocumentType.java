package com.avito.android.photo_wizard;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/photo_wizard/DocumentType;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/photo_wizard/PictureType;", "component3", "()Lcom/avito/android/photo_wizard/PictureType;", "", "component4", "()Z", "id", "name", "pictureType", "isSelected", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/photo_wizard/PictureType;Z)Lcom/avito/android/photo_wizard/DocumentType;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "d", "Z", "c", "Lcom/avito/android/photo_wizard/PictureType;", "getPictureType", AuthSource.BOOKING_ORDER, "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/photo_wizard/PictureType;Z)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class DocumentType {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final PictureType c;
    public final boolean d;

    public DocumentType(@NotNull String str, @NotNull String str2, @NotNull PictureType pictureType, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(pictureType, "pictureType");
        this.a = str;
        this.b = str2;
        this.c = pictureType;
        this.d = z;
    }

    public static /* synthetic */ DocumentType copy$default(DocumentType documentType, String str, String str2, PictureType pictureType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentType.a;
        }
        if ((i & 2) != 0) {
            str2 = documentType.b;
        }
        if ((i & 4) != 0) {
            pictureType = documentType.c;
        }
        if ((i & 8) != 0) {
            z = documentType.d;
        }
        return documentType.copy(str, str2, pictureType, z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final PictureType component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final DocumentType copy(@NotNull String str, @NotNull String str2, @NotNull PictureType pictureType, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(pictureType, "pictureType");
        return new DocumentType(str, str2, pictureType, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentType)) {
            return false;
        }
        DocumentType documentType = (DocumentType) obj;
        return Intrinsics.areEqual(this.a, documentType.a) && Intrinsics.areEqual(this.b, documentType.b) && Intrinsics.areEqual(this.c, documentType.c) && this.d == documentType.d;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final String getName() {
        return this.b;
    }

    @NotNull
    public final PictureType getPictureType() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PictureType pictureType = this.c;
        if (pictureType != null) {
            i = pictureType.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isSelected() {
        return this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DocumentType(id=");
        L.append(this.a);
        L.append(", name=");
        L.append(this.b);
        L.append(", pictureType=");
        L.append(this.c);
        L.append(", isSelected=");
        return a.B(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DocumentType(String str, String str2, PictureType pictureType, boolean z, int i, j jVar) {
        this(str, str2, pictureType, (i & 8) != 0 ? false : z);
    }
}
