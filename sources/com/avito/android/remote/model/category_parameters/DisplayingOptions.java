package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bH\u0010IJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000bJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000bJ¤\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u0010\u0010)\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b/\u0010*J \u00104\u001a\u0002032\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b4\u00105R$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u0010\bR\u001e\u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010\u0013R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010:\u001a\u0004\b;\u0010\u000bR\u001e\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b<\u0010\u000bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010=\u001a\u0004\b>\u0010\u0004R\u001e\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010:\u001a\u0004\b?\u0010\u000bR\u001e\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010=\u001a\u0004\b@\u0010\u0004R\u001c\u0010\"\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010A\u001a\u0004\bB\u0010\u0016R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010=\u001a\u0004\bC\u0010\u0004R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\bD\u0010\u0004R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010E\u001a\u0004\bF\u0010\u0010R\u001e\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\bG\u0010\u000b¨\u0006J"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Boolean;", "component4", "component5", "", "component6", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/category_parameters/FormatterType;", "component7", "()Lcom/avito/android/remote/model/category_parameters/FormatterType;", "component8", "component9", "()Z", "component10", "component11", "component12", "type", "masks", "multiline", "prefix", "postfix", "length", "formatter", "visible", "hideTitle", "enabled", "defaultValue", "disableMask", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/category_parameters/FormatterType;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getMasks", "Lcom/avito/android/remote/model/category_parameters/FormatterType;", "getFormatter", "Ljava/lang/Boolean;", "getMultiline", "getEnabled", "Ljava/lang/String;", "getPostfix", "getDisableMask", "getDefaultValue", "Z", "getHideTitle", "getPrefix", "getType", "Ljava/lang/Integer;", "getLength", "getVisible", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/category_parameters/FormatterType;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DisplayingOptions implements Parcelable {
    public static final Parcelable.Creator<DisplayingOptions> CREATOR = new Creator();
    @SerializedName("defaultValue")
    @Nullable
    private final String defaultValue;
    @SerializedName("disableMask")
    @Nullable
    private final Boolean disableMask;
    @SerializedName("enabled")
    @Nullable
    private final Boolean enabled;
    @SerializedName("formatter")
    @Nullable
    private final FormatterType formatter;
    @SerializedName("hideTitle")
    private final boolean hideTitle;
    @SerializedName("length")
    @Nullable
    private final Integer length;
    @SerializedName("masks")
    @Nullable
    private final List<MaskInfo> masks;
    @SerializedName("multiline")
    @Nullable
    private final Boolean multiline;
    @SerializedName("postfix")
    @Nullable
    private final String postfix;
    @SerializedName("prefix")
    @Nullable
    private final String prefix;
    @SerializedName("type")
    @Nullable
    private final String type;
    @SerializedName("visible")
    @Nullable
    private final Boolean visible;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DisplayingOptions> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DisplayingOptions createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(MaskInfo.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            FormatterType formatterType = parcel.readInt() != 0 ? (FormatterType) Enum.valueOf(FormatterType.class, parcel.readString()) : null;
            if (parcel.readInt() != 0) {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool2 = null;
            }
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                bool3 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool3 = null;
            }
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool4 = Boolean.valueOf(z);
            } else {
                bool4 = null;
            }
            return new DisplayingOptions(readString, arrayList, bool, readString2, readString3, valueOf, formatterType, bool2, z2, bool3, readString4, bool4);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DisplayingOptions[] newArray(int i) {
            return new DisplayingOptions[i];
        }
    }

    public DisplayingOptions(@Nullable String str, @Nullable List<MaskInfo> list, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable FormatterType formatterType, @Nullable Boolean bool2, boolean z, @Nullable Boolean bool3, @Nullable String str4, @Nullable Boolean bool4) {
        this.type = str;
        this.masks = list;
        this.multiline = bool;
        this.prefix = str2;
        this.postfix = str3;
        this.length = num;
        this.formatter = formatterType;
        this.visible = bool2;
        this.hideTitle = z;
        this.enabled = bool3;
        this.defaultValue = str4;
        this.disableMask = bool4;
    }

    public static /* synthetic */ DisplayingOptions copy$default(DisplayingOptions displayingOptions, String str, List list, Boolean bool, String str2, String str3, Integer num, FormatterType formatterType, Boolean bool2, boolean z, Boolean bool3, String str4, Boolean bool4, int i, Object obj) {
        return displayingOptions.copy((i & 1) != 0 ? displayingOptions.type : str, (i & 2) != 0 ? displayingOptions.masks : list, (i & 4) != 0 ? displayingOptions.multiline : bool, (i & 8) != 0 ? displayingOptions.prefix : str2, (i & 16) != 0 ? displayingOptions.postfix : str3, (i & 32) != 0 ? displayingOptions.length : num, (i & 64) != 0 ? displayingOptions.formatter : formatterType, (i & 128) != 0 ? displayingOptions.visible : bool2, (i & 256) != 0 ? displayingOptions.hideTitle : z, (i & 512) != 0 ? displayingOptions.enabled : bool3, (i & 1024) != 0 ? displayingOptions.defaultValue : str4, (i & 2048) != 0 ? displayingOptions.disableMask : bool4);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final Boolean component10() {
        return this.enabled;
    }

    @Nullable
    public final String component11() {
        return this.defaultValue;
    }

    @Nullable
    public final Boolean component12() {
        return this.disableMask;
    }

    @Nullable
    public final List<MaskInfo> component2() {
        return this.masks;
    }

    @Nullable
    public final Boolean component3() {
        return this.multiline;
    }

    @Nullable
    public final String component4() {
        return this.prefix;
    }

    @Nullable
    public final String component5() {
        return this.postfix;
    }

    @Nullable
    public final Integer component6() {
        return this.length;
    }

    @Nullable
    public final FormatterType component7() {
        return this.formatter;
    }

    @Nullable
    public final Boolean component8() {
        return this.visible;
    }

    public final boolean component9() {
        return this.hideTitle;
    }

    @NotNull
    public final DisplayingOptions copy(@Nullable String str, @Nullable List<MaskInfo> list, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable FormatterType formatterType, @Nullable Boolean bool2, boolean z, @Nullable Boolean bool3, @Nullable String str4, @Nullable Boolean bool4) {
        return new DisplayingOptions(str, list, bool, str2, str3, num, formatterType, bool2, z, bool3, str4, bool4);
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
        if (!(obj instanceof DisplayingOptions)) {
            return false;
        }
        DisplayingOptions displayingOptions = (DisplayingOptions) obj;
        return Intrinsics.areEqual(this.type, displayingOptions.type) && Intrinsics.areEqual(this.masks, displayingOptions.masks) && Intrinsics.areEqual(this.multiline, displayingOptions.multiline) && Intrinsics.areEqual(this.prefix, displayingOptions.prefix) && Intrinsics.areEqual(this.postfix, displayingOptions.postfix) && Intrinsics.areEqual(this.length, displayingOptions.length) && Intrinsics.areEqual(this.formatter, displayingOptions.formatter) && Intrinsics.areEqual(this.visible, displayingOptions.visible) && this.hideTitle == displayingOptions.hideTitle && Intrinsics.areEqual(this.enabled, displayingOptions.enabled) && Intrinsics.areEqual(this.defaultValue, displayingOptions.defaultValue) && Intrinsics.areEqual(this.disableMask, displayingOptions.disableMask);
    }

    @Nullable
    public final String getDefaultValue() {
        return this.defaultValue;
    }

    @Nullable
    public final Boolean getDisableMask() {
        return this.disableMask;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final FormatterType getFormatter() {
        return this.formatter;
    }

    public final boolean getHideTitle() {
        return this.hideTitle;
    }

    @Nullable
    public final Integer getLength() {
        return this.length;
    }

    @Nullable
    public final List<MaskInfo> getMasks() {
        return this.masks;
    }

    @Nullable
    public final Boolean getMultiline() {
        return this.multiline;
    }

    @Nullable
    public final String getPostfix() {
        return this.postfix;
    }

    @Nullable
    public final String getPrefix() {
        return this.prefix;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Boolean getVisible() {
        return this.visible;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<MaskInfo> list = this.masks;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.multiline;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.prefix;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.postfix;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.length;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        FormatterType formatterType = this.formatter;
        int hashCode7 = (hashCode6 + (formatterType != null ? formatterType.hashCode() : 0)) * 31;
        Boolean bool2 = this.visible;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        boolean z = this.hideTitle;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode8 + i2) * 31;
        Boolean bool3 = this.enabled;
        int hashCode9 = (i5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str4 = this.defaultValue;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool4 = this.disableMask;
        if (bool4 != null) {
            i = bool4.hashCode();
        }
        return hashCode10 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DisplayingOptions(type=");
        L.append(this.type);
        L.append(", masks=");
        L.append(this.masks);
        L.append(", multiline=");
        L.append(this.multiline);
        L.append(", prefix=");
        L.append(this.prefix);
        L.append(", postfix=");
        L.append(this.postfix);
        L.append(", length=");
        L.append(this.length);
        L.append(", formatter=");
        L.append(this.formatter);
        L.append(", visible=");
        L.append(this.visible);
        L.append(", hideTitle=");
        L.append(this.hideTitle);
        L.append(", enabled=");
        L.append(this.enabled);
        L.append(", defaultValue=");
        L.append(this.defaultValue);
        L.append(", disableMask=");
        return a.o(L, this.disableMask, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        List<MaskInfo> list = this.masks;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((MaskInfo) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.multiline;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.prefix);
        parcel.writeString(this.postfix);
        Integer num = this.length;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        FormatterType formatterType = this.formatter;
        if (formatterType != null) {
            parcel.writeInt(1);
            parcel.writeString(formatterType.name());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.visible;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.hideTitle ? 1 : 0);
        Boolean bool3 = this.enabled;
        if (bool3 != null) {
            a.G0(parcel, 1, bool3);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.defaultValue);
        Boolean bool4 = this.disableMask;
        if (bool4 != null) {
            a.G0(parcel, 1, bool4);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DisplayingOptions(String str, List list, Boolean bool, String str2, String str3, Integer num, FormatterType formatterType, Boolean bool2, boolean z, Boolean bool3, String str4, Boolean bool4, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, bool, str2, str3, num, formatterType, bool2, (i & 256) != 0 ? false : z, (i & 512) != 0 ? null : bool3, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : bool4);
    }
}
