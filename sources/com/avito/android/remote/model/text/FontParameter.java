package com.avito.android.remote.model.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Color;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "<init>", "()V", "ColorParameter", "ParagraphSpacingRelativeParameter", "StrikethroughParameter", "StyleParameter", "TextStyleParameter", "UseParagraphingParameter", "Lcom/avito/android/remote/model/text/FontParameter$ColorParameter;", "Lcom/avito/android/remote/model/text/FontParameter$StyleParameter;", "Lcom/avito/android/remote/model/text/FontParameter$TextStyleParameter;", "Lcom/avito/android/remote/model/text/FontParameter$StrikethroughParameter;", "Lcom/avito/android/remote/model/text/FontParameter$UseParagraphingParameter;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class FontParameter implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter$ColorParameter;", "Lcom/avito/android/remote/model/text/FontParameter;", "Lcom/avito/android/remote/model/Color;", "component1", "()Lcom/avito/android/remote/model/Color;", "component2", "", "component3", "()Ljava/lang/String;", "color", "colorDark", "colorKey", "copy", "(Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;)Lcom/avito/android/remote/model/text/FontParameter$ColorParameter;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "getColorDark", "getColor", "Ljava/lang/String;", "getColorKey", "<init>", "(Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ColorParameter extends FontParameter {
        public static final Parcelable.Creator<ColorParameter> CREATOR = new Creator();
        @SerializedName("value")
        @NotNull
        private final Color color;
        @SerializedName("valueDark")
        @Nullable
        private final Color colorDark;
        @SerializedName("valueName")
        @Nullable
        private final String colorKey;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ColorParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ColorParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                Parcelable.Creator<Color> creator = Color.CREATOR;
                return new ColorParameter(creator.createFromParcel(parcel), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ColorParameter[] newArray(int i) {
                return new ColorParameter[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ColorParameter(@NotNull Color color2, @Nullable Color color3, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(color2, "color");
            this.color = color2;
            this.colorDark = color3;
            this.colorKey = str;
        }

        public static /* synthetic */ ColorParameter copy$default(ColorParameter colorParameter, Color color2, Color color3, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                color2 = colorParameter.color;
            }
            if ((i & 2) != 0) {
                color3 = colorParameter.colorDark;
            }
            if ((i & 4) != 0) {
                str = colorParameter.colorKey;
            }
            return colorParameter.copy(color2, color3, str);
        }

        @NotNull
        public final Color component1() {
            return this.color;
        }

        @Nullable
        public final Color component2() {
            return this.colorDark;
        }

        @Nullable
        public final String component3() {
            return this.colorKey;
        }

        @NotNull
        public final ColorParameter copy(@NotNull Color color2, @Nullable Color color3, @Nullable String str) {
            Intrinsics.checkNotNullParameter(color2, "color");
            return new ColorParameter(color2, color3, str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColorParameter)) {
                return false;
            }
            ColorParameter colorParameter = (ColorParameter) obj;
            return Intrinsics.areEqual(this.color, colorParameter.color) && Intrinsics.areEqual(this.colorDark, colorParameter.colorDark) && Intrinsics.areEqual(this.colorKey, colorParameter.colorKey);
        }

        @NotNull
        public final Color getColor() {
            return this.color;
        }

        @Nullable
        public final Color getColorDark() {
            return this.colorDark;
        }

        @Nullable
        public final String getColorKey() {
            return this.colorKey;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Color color2 = this.color;
            int i = 0;
            int hashCode = (color2 != null ? color2.hashCode() : 0) * 31;
            Color color3 = this.colorDark;
            int hashCode2 = (hashCode + (color3 != null ? color3.hashCode() : 0)) * 31;
            String str = this.colorKey;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ColorParameter(color=");
            L.append(this.color);
            L.append(", colorDark=");
            L.append(this.colorDark);
            L.append(", colorKey=");
            return a.t(L, this.colorKey, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.color.writeToParcel(parcel, 0);
            Color color2 = this.colorDark;
            if (color2 != null) {
                parcel.writeInt(1);
                color2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.colorKey);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter$ParagraphSpacingRelativeParameter;", "Lcom/avito/android/remote/model/text/FontParameter$UseParagraphingParameter;", "", "component1", "()F", "value", "copy", "(F)Lcom/avito/android/remote/model/text/FontParameter$ParagraphSpacingRelativeParameter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "F", "getValue", "<init>", "(F)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ParagraphSpacingRelativeParameter extends UseParagraphingParameter {
        public static final Parcelable.Creator<ParagraphSpacingRelativeParameter> CREATOR = new Creator();
        @SerializedName("value")
        private final float value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ParagraphSpacingRelativeParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ParagraphSpacingRelativeParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ParagraphSpacingRelativeParameter(parcel.readFloat());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ParagraphSpacingRelativeParameter[] newArray(int i) {
                return new ParagraphSpacingRelativeParameter[i];
            }
        }

        public ParagraphSpacingRelativeParameter(float f) {
            this.value = f;
        }

        public static /* synthetic */ ParagraphSpacingRelativeParameter copy$default(ParagraphSpacingRelativeParameter paragraphSpacingRelativeParameter, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = paragraphSpacingRelativeParameter.value;
            }
            return paragraphSpacingRelativeParameter.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        @NotNull
        public final ParagraphSpacingRelativeParameter copy(float f) {
            return new ParagraphSpacingRelativeParameter(f);
        }

        @Override // com.avito.android.remote.model.text.FontParameter, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ParagraphSpacingRelativeParameter) && Float.compare(this.value, ((ParagraphSpacingRelativeParameter) obj).value) == 0;
            }
            return true;
        }

        public final float getValue() {
            return this.value;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ParagraphSpacingRelativeParameter(value=");
            L.append(this.value);
            L.append(")");
            return L.toString();
        }

        @Override // com.avito.android.remote.model.text.FontParameter.UseParagraphingParameter, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeFloat(this.value);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter$StrikethroughParameter;", "Lcom/avito/android/remote/model/text/FontParameter;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class StrikethroughParameter extends FontParameter {
        public static final Parcelable.Creator<StrikethroughParameter> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<StrikethroughParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final StrikethroughParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new StrikethroughParameter();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final StrikethroughParameter[] newArray(int i) {
                return new StrikethroughParameter[i];
            }
        }

        public StrikethroughParameter() {
            super(null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter$StyleParameter;", "Lcom/avito/android/remote/model/text/FontParameter;", "", "component1", "()Ljava/lang/String;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/text/FontParameter$StyleParameter;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getStyle", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class StyleParameter extends FontParameter {
        public static final Parcelable.Creator<StyleParameter> CREATOR = new Creator();
        @SerializedName("value")
        @NotNull
        private final String style;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<StyleParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final StyleParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new StyleParameter(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final StyleParameter[] newArray(int i) {
                return new StyleParameter[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StyleParameter(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            this.style = str;
        }

        public static /* synthetic */ StyleParameter copy$default(StyleParameter styleParameter, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = styleParameter.style;
            }
            return styleParameter.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.style;
        }

        @NotNull
        public final StyleParameter copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            return new StyleParameter(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof StyleParameter) && Intrinsics.areEqual(this.style, ((StyleParameter) obj).style);
            }
            return true;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.style;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("StyleParameter(style="), this.style, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.style);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter$TextStyleParameter;", "Lcom/avito/android/remote/model/text/FontParameter;", "", "component1", "()Ljava/lang/String;", "component2", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "attribute", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/text/FontParameter$TextStyleParameter;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAttribute", "getStyle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class TextStyleParameter extends FontParameter {
        public static final Parcelable.Creator<TextStyleParameter> CREATOR = new Creator();
        @SerializedName("value")
        @Nullable
        private final String attribute;
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @Nullable
        private final String style;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<TextStyleParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final TextStyleParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new TextStyleParameter(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final TextStyleParameter[] newArray(int i) {
                return new TextStyleParameter[i];
            }
        }

        public TextStyleParameter(@Nullable String str, @Nullable String str2) {
            super(null);
            this.style = str;
            this.attribute = str2;
        }

        public static /* synthetic */ TextStyleParameter copy$default(TextStyleParameter textStyleParameter, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textStyleParameter.style;
            }
            if ((i & 2) != 0) {
                str2 = textStyleParameter.attribute;
            }
            return textStyleParameter.copy(str, str2);
        }

        @Nullable
        public final String component1() {
            return this.style;
        }

        @Nullable
        public final String component2() {
            return this.attribute;
        }

        @NotNull
        public final TextStyleParameter copy(@Nullable String str, @Nullable String str2) {
            return new TextStyleParameter(str, str2);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextStyleParameter)) {
                return false;
            }
            TextStyleParameter textStyleParameter = (TextStyleParameter) obj;
            return Intrinsics.areEqual(this.style, textStyleParameter.style) && Intrinsics.areEqual(this.attribute, textStyleParameter.attribute);
        }

        @Nullable
        public final String getAttribute() {
            return this.attribute;
        }

        @Nullable
        public final String getStyle() {
            return this.style;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.style;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.attribute;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("TextStyleParameter(style=");
            L.append(this.style);
            L.append(", attribute=");
            return a.t(L, this.attribute, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.style);
            parcel.writeString(this.attribute);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/text/FontParameter$UseParagraphingParameter;", "Lcom/avito/android/remote/model/text/FontParameter;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static class UseParagraphingParameter extends FontParameter {
        public static final Parcelable.Creator<UseParagraphingParameter> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<UseParagraphingParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UseParagraphingParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new UseParagraphingParameter();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UseParagraphingParameter[] newArray(int i) {
                return new UseParagraphingParameter[i];
            }
        }

        public UseParagraphingParameter() {
            super(null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    private FontParameter() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public /* synthetic */ FontParameter(j jVar) {
        this();
    }
}
