package com.avito.android.lib.design.input;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B3\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\tR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\f¨\u00060"}, d2 = {"Lcom/avito/android/lib/design/input/FormatterType;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Integer;", "Lcom/avito/android/lib/design/input/MaskParameters;", "component4", "()Lcom/avito/android/lib/design/input/MaskParameters;", "id", "allowedSymbols", "inputType", "maskParameters", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Lcom/avito/android/lib/design/input/MaskParameters;)Lcom/avito/android/lib/design/input/FormatterType;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "I", "getId", "c", "Ljava/lang/Integer;", "getInputType", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getAllowedSymbols", "d", "Lcom/avito/android/lib/design/input/MaskParameters;", "getMaskParameters", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Lcom/avito/android/lib/design/input/MaskParameters;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public final class FormatterType implements Parcelable {
    public static final Parcelable.Creator<FormatterType> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion;
    public static final char defaultDecimalSeparator = '.';
    @NotNull
    public static final FormatterType e = new FormatterType(0, null, null, new MaskParameters(null, false, null, null, false, null, false, false, null, null, 0, 0, 4095, null), 6, null);
    @NotNull
    public static final FormatterType f = new FormatterType(1, "0123456789", 2, new MaskParameters("", false, "", null, false, "### ### ### ### ### ### ###", true, false, null, "0", 0, 0, 3354, null));
    @NotNull
    public static final FormatterType g = new FormatterType(2, "+0123456789", 2, new MaskParameters("+7", true, null, null, false, "### ###-##-##", false, true, CollectionsKt__CollectionsKt.arrayListOf("+7", "8"), null, 0, 0, 3676, null));
    @NotNull
    public static final FormatterType h;
    public final int a;
    @NotNull
    public final String b;
    @Nullable
    public final Integer c;
    @Nullable
    public final MaskParameters d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u0019\u0010\r\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/input/FormatterType$Companion;", "", "", "id", "Lcom/avito/android/lib/design/input/FormatterType;", "byId", "(I)Lcom/avito/android/lib/design/input/FormatterType;", "FLOATING_POINT", "Lcom/avito/android/lib/design/input/FormatterType;", "getFLOATING_POINT", "()Lcom/avito/android/lib/design/input/FormatterType;", "SIMPLE", "getSIMPLE", "DECIMAL", "getDECIMAL", "MOBILE_PHONE", "getMOBILE_PHONE", "", "defaultDecimalSeparator", "C", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final char access$getDecimalSeparator$p(Companion companion) {
            Objects.requireNonNull(companion);
            DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(Locale.getDefault());
            Intrinsics.checkNotNullExpressionValue(instance, "DecimalFormatSymbols.get…ance(Locale.getDefault())");
            return instance.getDecimalSeparator();
        }

        @NotNull
        public final FormatterType byId(int i) {
            if (i == getSIMPLE().getId()) {
                return getSIMPLE();
            }
            if (i == getDECIMAL().getId()) {
                return getDECIMAL();
            }
            if (i == getMOBILE_PHONE().getId()) {
                return getMOBILE_PHONE();
            }
            if (i == getFLOATING_POINT().getId()) {
                return getFLOATING_POINT();
            }
            return getSIMPLE();
        }

        @NotNull
        public final FormatterType getDECIMAL() {
            return FormatterType.f;
        }

        @NotNull
        public final FormatterType getFLOATING_POINT() {
            return FormatterType.h;
        }

        @NotNull
        public final FormatterType getMOBILE_PHONE() {
            return FormatterType.g;
        }

        @NotNull
        public final FormatterType getSIMPLE() {
            return FormatterType.e;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FormatterType> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FormatterType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            MaskParameters maskParameters = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                maskParameters = MaskParameters.CREATOR.createFromParcel(parcel);
            }
            return new FormatterType(readInt, readString, valueOf, maskParameters);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FormatterType[] newArray(int i) {
            return new FormatterType[i];
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        StringBuilder L = a.L("0123456789");
        L.append(Companion.access$getDecimalSeparator$p(companion));
        L.append(defaultDecimalSeparator);
        h = new FormatterType(3, L.toString(), 8194, new MaskParameters("", false, "", null, false, "### ### ### ### ### ### ###", true, false, null, "0", Companion.access$getDecimalSeparator$p(companion), 0, 2330, null));
    }

    public FormatterType() {
        this(0, null, null, null, 15, null);
    }

    public FormatterType(int i, @NotNull String str, @Nullable Integer num, @Nullable MaskParameters maskParameters) {
        Intrinsics.checkNotNullParameter(str, "allowedSymbols");
        this.a = i;
        this.b = str;
        this.c = num;
        this.d = maskParameters;
    }

    public static /* synthetic */ FormatterType copy$default(FormatterType formatterType, int i, String str, Integer num, MaskParameters maskParameters, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = formatterType.a;
        }
        if ((i2 & 2) != 0) {
            str = formatterType.b;
        }
        if ((i2 & 4) != 0) {
            num = formatterType.c;
        }
        if ((i2 & 8) != 0) {
            maskParameters = formatterType.d;
        }
        return formatterType.copy(i, str, num, maskParameters);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Integer component3() {
        return this.c;
    }

    @Nullable
    public final MaskParameters component4() {
        return this.d;
    }

    @NotNull
    public final FormatterType copy(int i, @NotNull String str, @Nullable Integer num, @Nullable MaskParameters maskParameters) {
        Intrinsics.checkNotNullParameter(str, "allowedSymbols");
        return new FormatterType(i, str, num, maskParameters);
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
        if (!(obj instanceof FormatterType)) {
            return false;
        }
        FormatterType formatterType = (FormatterType) obj;
        return this.a == formatterType.a && Intrinsics.areEqual(this.b, formatterType.b) && Intrinsics.areEqual(this.c, formatterType.c) && Intrinsics.areEqual(this.d, formatterType.d);
    }

    @NotNull
    public final String getAllowedSymbols() {
        return this.b;
    }

    public final int getId() {
        return this.a;
    }

    @Nullable
    public final Integer getInputType() {
        return this.c;
    }

    @Nullable
    public final MaskParameters getMaskParameters() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.c;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        MaskParameters maskParameters = this.d;
        if (maskParameters != null) {
            i2 = maskParameters.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("FormatterType(id=");
        L.append(this.a);
        L.append(", allowedSymbols=");
        L.append(this.b);
        L.append(", inputType=");
        L.append(this.c);
        L.append(", maskParameters=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        Integer num = this.c;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        MaskParameters maskParameters = this.d;
        if (maskParameters != null) {
            parcel.writeInt(1);
            maskParameters.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormatterType(int i, String str, Integer num, MaskParameters maskParameters, int i2, j jVar) {
        this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : maskParameters);
    }
}
