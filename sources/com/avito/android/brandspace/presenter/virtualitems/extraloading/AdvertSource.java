package com.avito.android.brandspace.presenter.virtualitems.extraloading;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "Landroid/os/Parcelable;", "<init>", "()V", "LinkSource", "ParametersSource", "TabsSource", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public abstract class AdvertSource implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "", "component1", "()Ljava/lang/String;", "link", "copy", "(Ljava/lang/String;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLink", "<init>", "(Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class LinkSource extends AdvertSource {
        public static final Parcelable.Creator<LinkSource> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<LinkSource> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LinkSource createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new LinkSource(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LinkSource[] newArray(int i) {
                return new LinkSource[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LinkSource(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "link");
            this.a = str;
        }

        public static /* synthetic */ LinkSource copy$default(LinkSource linkSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = linkSource.a;
            }
            return linkSource.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final LinkSource copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "link");
            return new LinkSource(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof LinkSource) && Intrinsics.areEqual(this.a, ((LinkSource) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getLink() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("LinkSource(link="), this.a, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R%\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "", "", "component1", "()Ljava/util/Map;", "extraLoadingParameters", "copy", "(Ljava/util/Map;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getExtraLoadingParameters", "<init>", "(Ljava/util/Map;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class ParametersSource extends AdvertSource {
        public static final Parcelable.Creator<ParametersSource> CREATOR = new Creator();
        @NotNull
        public final Map<String, String> a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ParametersSource> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ParametersSource createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
                return new ParametersSource(linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ParametersSource[] newArray(int i) {
                return new ParametersSource[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParametersSource(@NotNull Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "extraLoadingParameters");
            this.a = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource$ParametersSource */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParametersSource copy$default(ParametersSource parametersSource, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = parametersSource.a;
            }
            return parametersSource.copy(map);
        }

        @NotNull
        public final Map<String, String> component1() {
            return this.a;
        }

        @NotNull
        public final ParametersSource copy(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "extraLoadingParameters");
            return new ParametersSource(map);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ParametersSource) && Intrinsics.areEqual(this.a, ((ParametersSource) obj).a);
            }
            return true;
        }

        @NotNull
        public final Map<String, String> getExtraLoadingParameters() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Map<String, String> map = this.a;
            if (map != null) {
                return map.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.x(a.L("ParametersSource(extraLoadingParameters="), this.a, ")");
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
            /*
                r2 = this;
                java.lang.String r4 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                java.util.Map<java.lang.String, java.lang.String> r4 = r2.a
                java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
            L_0x000b:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0028
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                java.lang.String r0 = (java.lang.String) r0
                r3.writeString(r0)
                goto L_0x000b
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource.ParametersSource.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\t¨\u0006%"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "", "component1", "()I", "", "", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/TabDetailsSource;", "component2", "()Ljava/util/Map;", "limit", "contentLinks", "copy", "(ILjava/util/Map;)Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "I", "getLimit", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getContentLinks", "<init>", "(ILjava/util/Map;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class TabsSource extends AdvertSource {
        public static final Parcelable.Creator<TabsSource> CREATOR = new Creator();
        public final int a;
        @NotNull
        public final Map<String, TabDetailsSource> b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<TabsSource> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final TabsSource createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    linkedHashMap.put(parcel.readString(), TabDetailsSource.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
                return new TabsSource(readInt, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final TabsSource[] newArray(int i) {
                return new TabsSource[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TabsSource(int i, @NotNull Map<String, TabDetailsSource> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "contentLinks");
            this.a = i;
            this.b = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource$TabsSource */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TabsSource copy$default(TabsSource tabsSource, int i, Map map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = tabsSource.a;
            }
            if ((i2 & 2) != 0) {
                map = tabsSource.b;
            }
            return tabsSource.copy(i, map);
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final Map<String, TabDetailsSource> component2() {
            return this.b;
        }

        @NotNull
        public final TabsSource copy(int i, @NotNull Map<String, TabDetailsSource> map) {
            Intrinsics.checkNotNullParameter(map, "contentLinks");
            return new TabsSource(i, map);
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
            if (!(obj instanceof TabsSource)) {
                return false;
            }
            TabsSource tabsSource = (TabsSource) obj;
            return this.a == tabsSource.a && Intrinsics.areEqual(this.b, tabsSource.b);
        }

        @NotNull
        public final Map<String, TabDetailsSource> getContentLinks() {
            return this.b;
        }

        public final int getLimit() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = this.a * 31;
            Map<String, TabDetailsSource> map = this.b;
            return i + (map != null ? map.hashCode() : 0);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("TabsSource(limit=");
            L.append(this.a);
            L.append(", contentLinks=");
            return a.x(L, this.b, ")");
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
            /*
                r2 = this;
                java.lang.String r4 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                int r4 = r2.a
                r3.writeInt(r4)
                java.util.Map<java.lang.String, com.avito.android.brandspace.presenter.virtualitems.extraloading.TabDetailsSource> r4 = r2.b
                java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
            L_0x0010:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x002e
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                com.avito.android.brandspace.presenter.virtualitems.extraloading.TabDetailsSource r0 = (com.avito.android.brandspace.presenter.virtualitems.extraloading.TabDetailsSource) r0
                r1 = 0
                r0.writeToParcel(r3, r1)
                goto L_0x0010
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource.TabsSource.writeToParcel(android.os.Parcel, int):void");
        }
    }

    public AdvertSource() {
    }

    public AdvertSource(j jVar) {
    }
}
