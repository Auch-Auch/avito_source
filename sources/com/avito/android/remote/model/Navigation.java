package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.annotations.Field;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u0000 :2\u00020\u0001:\u0001:B\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010\u0012%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u0014\u0018\u00010\u0010¢\u0006\u0002\b\u0015\u0012\u001b\b\u0002\u0010\u001f\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u0015\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0016\u001a\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u0014\u0018\u00010\u0010¢\u0006\u0002\b\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J#\u0010\u0017\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00102%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u0014\u0018\u00010\u0010¢\u0006\u0002\b\u00152\u001b\b\u0002\u0010\u001f\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b$\u0010\fJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b)\u0010*R\u001e\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b,\u0010\u0004R$\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00108\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0012R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u000fR/\u0010\u001f\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u00158\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b2\u0010\u0018R9\u0010\u001e\u001a\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u0014\u0018\u00010\u0010¢\u0006\u0002\b\u00158\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b3\u0010\u0012R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b4\u0010\u0004R\u001e\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010+\u001a\u0004\b5\u0010\u0004R\u0013\u00106\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/remote/model/Navigation;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "component1", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/util/List;", "", "Lcom/avito/android/remote/model/Attribute;", "Lkotlinx/parcelize/RawValue;", "component4", "component5", "()Ljava/util/Map;", "component6", "component7", Navigation.GROUP, "categoryId", Navigation.CATEGORY_IDS, Navigation.ATTRIBUTES, Navigation.CONFIG, "title", "description", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/Navigation;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "Ljava/util/List;", "getCategoryIds", "Ljava/lang/Integer;", "getCategoryId", "Ljava/util/Map;", "getConfig", "getAttributes", "getGroup", "getTitle", "isEmpty", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Navigation implements Parcelable {
    @NotNull
    public static final String ATTRIBUTES = "attributes";
    @NotNull
    public static final String CATEGORY_ID = "categoryId";
    @NotNull
    public static final String CATEGORY_IDS = "categoryIds";
    @NotNull
    public static final String CONFIG = "config";
    public static final Parcelable.Creator<Navigation> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String DESCRIPTION = "description";
    @NotNull
    public static final String GROUP = "group";
    @NotNull
    public static final String TITLE = "title";
    @SerializedName(ATTRIBUTES)
    @Nullable
    private final List<Map<String, String>> attributes;
    @SerializedName("categoryId")
    @Nullable
    private final Integer categoryId;
    @SerializedName(CATEGORY_IDS)
    @Nullable
    private final List<Integer> categoryIds;
    @SerializedName(CONFIG)
    @Nullable
    private final Map<String, String> config;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName(GROUP)
    @Nullable
    private final String group;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/Navigation$Companion;", "", "", "ATTRIBUTES", "Ljava/lang/String;", "CATEGORY_ID", "CATEGORY_IDS", "CONFIG", ShareConstants.DESCRIPTION, "GROUP", ShareConstants.TITLE, "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Navigation> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Navigation createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            LinkedHashMap linkedHashMap = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    int readInt3 = parcel.readInt();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt3);
                    while (readInt3 != 0) {
                        readInt3 = a.U(parcel, linkedHashMap2, parcel.readString(), readInt3, -1);
                    }
                    arrayList2.add(linkedHashMap2);
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt4);
                while (readInt4 != 0) {
                    readInt4 = a.U(parcel, linkedHashMap, parcel.readString(), readInt4, -1);
                }
            }
            return new Navigation(readString, valueOf, arrayList, arrayList2, linkedHashMap, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Navigation[] newArray(int i) {
            return new Navigation[i];
        }
    }

    public Navigation() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends java.util.Map<java.lang.String, java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public Navigation(@Nullable String str, @Nullable Integer num, @Nullable List<Integer> list, @Nullable List<? extends Map<String, String>> list2, @Nullable Map<String, String> map, @Nullable String str2, @Nullable String str3) {
        this.group = str;
        this.categoryId = num;
        this.categoryIds = list;
        this.attributes = list2;
        this.config = map;
        this.title = str2;
        this.description = str3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.Navigation */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Navigation copy$default(Navigation navigation, String str, Integer num, List list, List list2, Map map, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = navigation.group;
        }
        if ((i & 2) != 0) {
            num = navigation.categoryId;
        }
        if ((i & 4) != 0) {
            list = navigation.categoryIds;
        }
        if ((i & 8) != 0) {
            list2 = navigation.attributes;
        }
        if ((i & 16) != 0) {
            map = navigation.config;
        }
        if ((i & 32) != 0) {
            str2 = navigation.title;
        }
        if ((i & 64) != 0) {
            str3 = navigation.description;
        }
        return navigation.copy(str, num, list, list2, map, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.group;
    }

    @Nullable
    public final Integer component2() {
        return this.categoryId;
    }

    @Nullable
    public final List<Integer> component3() {
        return this.categoryIds;
    }

    @Nullable
    public final List<Map<String, String>> component4() {
        return this.attributes;
    }

    @Nullable
    public final Map<String, String> component5() {
        return this.config;
    }

    @Nullable
    public final String component6() {
        return this.title;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @NotNull
    public final Navigation copy(@Nullable String str, @Nullable Integer num, @Nullable List<Integer> list, @Nullable List<? extends Map<String, String>> list2, @Nullable Map<String, String> map, @Nullable String str2, @Nullable String str3) {
        return new Navigation(str, num, list, list2, map, str2, str3);
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
        if (!Intrinsics.areEqual(Navigation.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.Navigation");
        Navigation navigation = (Navigation) obj;
        String str = this.group;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = navigation.group;
        if (str3 != null) {
            str2 = str3;
        }
        if ((!Intrinsics.areEqual(str, str2)) || (!Intrinsics.areEqual(this.categoryId, navigation.categoryId))) {
            return false;
        }
        List<Integer> list = this.categoryIds;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> list2 = navigation.categoryIds;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!Intrinsics.areEqual(list, list2)) {
            return false;
        }
        List<Map<String, String>> list3 = this.attributes;
        if (list3 == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        List<Map<String, String>> list4 = navigation.attributes;
        if (list4 == null) {
            list4 = CollectionsKt__CollectionsKt.emptyList();
        }
        return !(Intrinsics.areEqual(list3, list4) ^ true);
    }

    @Field(name = ATTRIBUTES)
    @Nullable
    public final List<Map<String, String>> getAttributes() {
        return this.attributes;
    }

    @Field(name = "categoryId")
    @Nullable
    public final Integer getCategoryId() {
        return this.categoryId;
    }

    @Field(name = CATEGORY_IDS)
    @Nullable
    public final List<Integer> getCategoryIds() {
        return this.categoryIds;
    }

    @Field(name = CONFIG)
    @Nullable
    public final Map<String, String> getConfig() {
        return this.config;
    }

    @Field(name = "description")
    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Field(name = GROUP)
    @Nullable
    public final String getGroup() {
        return this.group;
    }

    @Field(name = "title")
    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.group;
        if (str == null) {
            str = "";
        }
        int hashCode = str.hashCode() * 31;
        Integer num = this.categoryId;
        int intValue = (hashCode + (num != null ? num.intValue() : 0)) * 31;
        List<Integer> list = this.categoryIds;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        int hashCode2 = (list.hashCode() + intValue) * 31;
        List<Map<String, String>> list2 = this.attributes;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return list2.hashCode() + hashCode2;
    }

    public final boolean isEmpty() {
        String str = this.group;
        if (!(str == null || str.length() == 0) || this.categoryId != null) {
            return false;
        }
        List<Map<String, String>> list = this.attributes;
        if (!(list == null || list.isEmpty())) {
            return false;
        }
        List<Integer> list2 = this.categoryIds;
        return list2 == null || list2.isEmpty();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        String str = "";
        StringBuilder Q = a.Q(str, "g=");
        String str2 = this.group;
        if (str2 == null) {
            str2 = str;
        }
        a.k1(Q, str2, Typography.amp, "c=");
        Integer num = this.categoryId;
        String str3 = null;
        String valueOf = num != null ? String.valueOf(num.intValue()) : null;
        if (valueOf == null) {
            valueOf = str;
        }
        a.k1(Q, valueOf, Typography.amp, "cs=");
        List<Integer> list = this.categoryIds;
        String obj = list != null ? list.toString() : null;
        if (obj == null) {
            obj = str;
        }
        a.k1(Q, obj, Typography.amp, "a=");
        List<Map<String, String>> list2 = this.attributes;
        String access$joinToString = list2 != null ? NavigationKt.access$joinToString(list2) : null;
        if (access$joinToString == null) {
            access$joinToString = str;
        }
        a.k1(Q, access$joinToString, Typography.amp, "c=");
        Map<String, String> map = this.config;
        if (map != null) {
            str3 = NavigationKt.access$joinToString(map);
        }
        if (str3 != null) {
            str = str3;
        }
        Q.append(str);
        return Q.toString();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r6, int r7) {
        /*
            r5 = this;
            java.lang.String r7 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.String r7 = r5.group
            r6.writeString(r7)
            java.lang.Integer r7 = r5.categoryId
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0014
            a2.b.a.a.a.H0(r6, r0, r7)
            goto L_0x0017
        L_0x0014:
            r6.writeInt(r1)
        L_0x0017:
            java.util.List<java.lang.Integer> r7 = r5.categoryIds
            if (r7 == 0) goto L_0x0033
            java.util.Iterator r7 = a2.b.a.a.a.l0(r6, r0, r7)
        L_0x001f:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r7.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r6.writeInt(r2)
            goto L_0x001f
        L_0x0033:
            r6.writeInt(r1)
        L_0x0036:
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r7 = r5.attributes
            if (r7 == 0) goto L_0x006b
            java.util.Iterator r7 = a2.b.a.a.a.l0(r6, r0, r7)
        L_0x003e:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x006e
            java.lang.Object r2 = r7.next()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Iterator r2 = a2.b.a.a.a.o0(r2, r6)
        L_0x004e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r2.next()
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r6.writeString(r4)
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            r6.writeString(r3)
            goto L_0x004e
        L_0x006b:
            r6.writeInt(r1)
        L_0x006e:
            java.util.Map<java.lang.String, java.lang.String> r7 = r5.config
            if (r7 == 0) goto L_0x0093
            java.util.Iterator r7 = a2.b.a.a.a.m0(r6, r0, r7)
        L_0x0076:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0096
            java.lang.Object r0 = r7.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r6.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r6.writeString(r0)
            goto L_0x0076
        L_0x0093:
            r6.writeInt(r1)
        L_0x0096:
            java.lang.String r7 = r5.title
            r6.writeString(r7)
            java.lang.String r7 = r5.description
            r6.writeString(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.Navigation.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Navigation(String str, Integer num, List list, List list2, Map map, String str2, String str3, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3);
    }
}
