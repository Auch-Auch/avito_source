package com.avito.android.category;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategorySearch;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/avito/android/category/Element;", "", "<init>", "()V", "Category", "Header", "Shops", "Subcategory", "category_release"}, k = 1, mv = {1, 4, 2})
public abstract class Element {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0015\b\b\u0018\u0000 42\u00020\u0001:\u00014B5\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b2\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015JH\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u0010\u0010\u001f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001f\u0010\nJ\u001a\u0010\"\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b)\u0010*R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0012R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010\rR\"\u0010\u001b\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010(\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b1\u0010*¨\u00065"}, d2 = {"Lcom/avito/android/category/Element$Category;", "Lcom/avito/android/category/ListElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/CategorySearch;", "component3", "()Ljava/util/List;", "", "component4", "()Z", "component5", "id", "name", "children", "isChildrenVisible", "isLastCategory", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)Lcom/avito/android/category/Element$Category;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "d", "Z", "setChildrenVisible", "(Z)V", "c", "Ljava/util/List;", "getChildren", AuthSource.SEND_ABUSE, "getId", "e", "setLastCategory", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)V", "Companion", "category_release"}, k = 1, mv = {1, 4, 2})
    public static final class Category implements ListElement {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Category> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final List<CategorySearch> c;
        public boolean d;
        public boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/category/Element$Category$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/category/Element$Category;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "category_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Category> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Category invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
                String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
                List createParcelableList = ParcelsKt.createParcelableList(parcel2, CategorySearch.class);
                if (createParcelableList == null) {
                    createParcelableList = CollectionsKt__CollectionsKt.emptyList();
                }
                return new Category(u2, u22, createParcelableList, ParcelsKt.readBool(parcel2), ParcelsKt.readBool(parcel2));
            }
        }

        public Category(@NotNull String str, @NotNull String str2, @NotNull List<CategorySearch> list, boolean z, boolean z2) {
            a2.b.a.a.a.c1(str, "id", str2, "name", list, "children");
            this.a = str;
            this.b = str2;
            this.c = list;
            this.d = z;
            this.e = z2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.category.Element$Category */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Category copy$default(Category category, String str, String str2, List list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = category.a;
            }
            if ((i & 2) != 0) {
                str2 = category.b;
            }
            if ((i & 4) != 0) {
                list = category.c;
            }
            if ((i & 8) != 0) {
                z = category.d;
            }
            if ((i & 16) != 0) {
                z2 = category.e;
            }
            return category.copy(str, str2, list, z, z2);
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
        public final List<CategorySearch> component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        @NotNull
        public final Category copy(@NotNull String str, @NotNull String str2, @NotNull List<CategorySearch> list, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(list, "children");
            return new Category(str, str2, list, z, z2);
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
            if (!(obj instanceof Category)) {
                return false;
            }
            Category category = (Category) obj;
            return Intrinsics.areEqual(this.a, category.a) && Intrinsics.areEqual(this.b, category.b) && Intrinsics.areEqual(this.c, category.c) && this.d == category.d && this.e == category.e;
        }

        @NotNull
        public final List<CategorySearch> getChildren() {
            return this.c;
        }

        @NotNull
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final String getName() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<CategorySearch> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            int i2 = (hashCode2 + i) * 31;
            boolean z = this.d;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (i2 + i4) * 31;
            boolean z2 = this.e;
            if (!z2) {
                i3 = z2 ? 1 : 0;
            }
            return i7 + i3;
        }

        public final boolean isChildrenVisible() {
            return this.d;
        }

        public final boolean isLastCategory() {
            return this.e;
        }

        public final void setChildrenVisible(boolean z) {
            this.d = z;
        }

        public final void setLastCategory(boolean z) {
            this.e = z;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Category(id=");
            L.append(this.a);
            L.append(", name=");
            L.append(this.b);
            L.append(", children=");
            L.append(this.c);
            L.append(", isChildrenVisible=");
            L.append(this.d);
            L.append(", isLastCategory=");
            return a2.b.a.a.a.B(L, this.e, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            ParcelsKt.writeOptimizedParcelableList(parcel, this.c, i);
            ParcelsKt.writeBool(parcel, this.d);
            ParcelsKt.writeBool(parcel, this.e);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\r¨\u0006\""}, d2 = {"Lcom/avito/android/category/Element$Header;", "Lcom/avito/android/category/ListElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "name", "id", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/category/Element$Header;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getId", AuthSource.SEND_ABUSE, "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "category_release"}, k = 1, mv = {1, 4, 2})
    public static final class Header implements ListElement {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Header> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/category/Element$Header$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/category/Element$Header;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "category_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Header> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Header invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Header(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        public Header(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "id");
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ Header copy$default(Header header, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = header.a;
            }
            if ((i & 2) != 0) {
                str2 = header.b;
            }
            return header.copy(str, str2);
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
        public final Header copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "id");
            return new Header(str, str2);
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
            if (!(obj instanceof Header)) {
                return false;
            }
            Header header = (Header) obj;
            return Intrinsics.areEqual(this.a, header.a) && Intrinsics.areEqual(this.b, header.b);
        }

        @NotNull
        public final String getId() {
            return this.b;
        }

        @NotNull
        public final String getName() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Header(name=");
            L.append(this.a);
            L.append(", id=");
            return a2.b.a.a.a.t(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/category/Element$Shops;", "Lcom/avito/android/category/ListElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "c", "getDescription", "description", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "Companion", "category_release"}, k = 1, mv = {1, 4, 2})
    public static final class Shops implements ListElement {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Shops> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String a;
        @NotNull
        public final DeepLink b;
        @Nullable
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/category/Element$Shops$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/category/Element$Shops;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "category_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Shops> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Shops invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Shops(a2.b.a.a.a.u2(parcel2, "readString()!!"), (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2), parcel2.readString());
            }
        }

        public Shops(@NotNull String str, @NotNull DeepLink deepLink, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = str;
            this.b = deepLink;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.b;
        }

        @Nullable
        public final String getDescription() {
            return this.c;
        }

        @NotNull
        public final String getName() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 #2\u00020\u0001:\u0001#B3\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f¨\u0006$"}, d2 = {"Lcom/avito/android/category/Element$Subcategory;", "Lcom/avito/android/category/ListElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "c", "getParentId", "parentId", "", "d", "Z", "isLastChild", "()Z", "setLastChild", "(Z)V", "e", "isFictive", "setFictive", AuthSource.SEND_ABUSE, "getId", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "Companion", "category_release"}, k = 1, mv = {1, 4, 2})
    public static final class Subcategory implements ListElement {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Subcategory> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        public boolean d;
        public boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/category/Element$Subcategory$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/category/Element$Subcategory;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "category_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Subcategory> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Subcategory invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Subcategory(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.readBool(parcel2), ParcelsKt.readBool(parcel2));
            }
        }

        public Subcategory(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, boolean z2) {
            a2.b.a.a.a.Z0(str, "id", str2, "name", str3, "parentId");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = z2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
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
        public final String getParentId() {
            return this.c;
        }

        public final boolean isFictive() {
            return this.e;
        }

        public final boolean isLastChild() {
            return this.d;
        }

        public final void setFictive(boolean z) {
            this.e = z;
        }

        public final void setLastChild(boolean z) {
            this.d = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            ParcelsKt.writeBool(parcel, this.d);
            ParcelsKt.writeBool(parcel, this.e);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Subcategory(String str, String str2, String str3, boolean z, boolean z2, int i, j jVar) {
            this(str, str2, str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
        }
    }
}
