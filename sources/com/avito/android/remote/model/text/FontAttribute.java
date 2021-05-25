package com.avito.android.remote.model.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/text/FontAttribute;", "Lcom/avito/android/remote/model/text/Attribute;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/text/FontParameter;", "component3", "()Ljava/util/List;", "name", "title", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/text/FontAttribute;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getParameters", "Ljava/lang/String;", "getName", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class FontAttribute extends Attribute {
    public static final Parcelable.Creator<FontAttribute> CREATOR = new Creator();
    @NotNull
    private final String name;
    @NotNull
    private final List<FontParameter> parameters;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FontAttribute> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FontAttribute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((FontParameter) parcel.readParcelable(FontAttribute.class.getClassLoader()));
                readInt--;
            }
            return new FontAttribute(readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FontAttribute[] newArray(int i) {
            return new FontAttribute[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.remote.model.text.FontParameter> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontAttribute(@NotNull String str, @NotNull String str2, @NotNull List<? extends FontParameter> list) {
        super(null);
        a.c1(str, "name", str2, "title", list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.name = str;
        this.title = str2;
        this.parameters = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.text.FontAttribute */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FontAttribute copy$default(FontAttribute fontAttribute, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fontAttribute.getName();
        }
        if ((i & 2) != 0) {
            str2 = fontAttribute.getTitle();
        }
        if ((i & 4) != 0) {
            list = fontAttribute.parameters;
        }
        return fontAttribute.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return getName();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @NotNull
    public final List<FontParameter> component3() {
        return this.parameters;
    }

    @NotNull
    public final FontAttribute copy(@NotNull String str, @NotNull String str2, @NotNull List<? extends FontParameter> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return new FontAttribute(str, str2, list);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FontAttribute)) {
            return false;
        }
        FontAttribute fontAttribute = (FontAttribute) obj;
        return Intrinsics.areEqual(getName(), fontAttribute.getName()) && Intrinsics.areEqual(getTitle(), fontAttribute.getTitle()) && Intrinsics.areEqual(this.parameters, fontAttribute.parameters);
    }

    @Override // com.avito.android.remote.model.text.Attribute
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public final List<FontParameter> getParameters() {
        return this.parameters;
    }

    @Override // com.avito.android.remote.model.text.Attribute
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String name2 = getName();
        int i = 0;
        int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        List<FontParameter> list = this.parameters;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("FontAttribute(name=");
        L.append(getName());
        L.append(", title=");
        L.append(getTitle());
        L.append(", parameters=");
        return a.w(L, this.parameters, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.parameters, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((FontParameter) n0.next(), i);
        }
    }
}
