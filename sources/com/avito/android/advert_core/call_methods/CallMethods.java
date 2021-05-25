package com.avito.android.advert_core.call_methods;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0002&'B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/advert_core/call_methods/CallMethods;", "Landroid/os/Parcelable;", "Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;", "component1", "()Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;", "Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;", "component2", "()Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;", "phone", "inApp", "copy", "(Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;)Lcom/avito/android/advert_core/call_methods/CallMethods;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;", "getInApp", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;", "getPhone", "<init>", "(Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;)V", "InApp", "Phone", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CallMethods implements Parcelable {
    public static final Parcelable.Creator<CallMethods> CREATOR = new Creator();
    @Nullable
    public final Phone a;
    @Nullable
    public final InApp b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CallMethods> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CallMethods createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            InApp inApp = null;
            Phone createFromParcel = parcel.readInt() != 0 ? Phone.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                inApp = InApp.CREATOR.createFromParcel(parcel);
            }
            return new CallMethods(createFromParcel, inApp);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CallMethods[] newArray(int i) {
            return new CallMethods[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\r\u0010\t¨\u0006*"}, d2 = {"Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "callUuid", "callTo", "callAs", "isNew", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/advert_core/call_methods/CallMethods$InApp;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCallTo", "c", "getCallAs", AuthSource.SEND_ABUSE, "getCallUuid", "d", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class InApp implements Parcelable {
        public static final Parcelable.Creator<InApp> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        public final boolean d;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InApp> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InApp createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InApp(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InApp[] newArray(int i) {
                return new InApp[i];
            }
        }

        public InApp(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(str2, "callTo");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
        }

        public static /* synthetic */ InApp copy$default(InApp inApp, String str, String str2, String str3, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inApp.a;
            }
            if ((i & 2) != 0) {
                str2 = inApp.b;
            }
            if ((i & 4) != 0) {
                str3 = inApp.c;
            }
            if ((i & 8) != 0) {
                z = inApp.d;
            }
            return inApp.copy(str, str2, str3, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final InApp copy(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(str2, "callTo");
            return new InApp(str, str2, str3, z);
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
            if (!(obj instanceof InApp)) {
                return false;
            }
            InApp inApp = (InApp) obj;
            return Intrinsics.areEqual(this.a, inApp.a) && Intrinsics.areEqual(this.b, inApp.b) && Intrinsics.areEqual(this.c, inApp.c) && this.d == inApp.d;
        }

        @Nullable
        public final String getCallAs() {
            return this.c;
        }

        @NotNull
        public final String getCallTo() {
            return this.b;
        }

        @NotNull
        public final String getCallUuid() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            if (str3 != null) {
                i = str3.hashCode();
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

        public final boolean isNew() {
            return this.d;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("InApp(callUuid=");
            L.append(this.a);
            L.append(", callTo=");
            L.append(this.b);
            L.append(", callAs=");
            L.append(this.c);
            L.append(", isNew=");
            return a.B(L, this.d, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component2", "()Ljava/lang/String;", "deepLink", "formattedPhone", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)Lcom/avito/android/advert_core/call_methods/CallMethods$Phone;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFormattedPhone", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Phone implements Parcelable {
        public static final Parcelable.Creator<Phone> CREATOR = new Creator();
        @NotNull
        public final DeepLink a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Phone> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Phone createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Phone((DeepLink) parcel.readParcelable(Phone.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Phone[] newArray(int i) {
                return new Phone[i];
            }
        }

        public Phone(@NotNull DeepLink deepLink, @Nullable String str) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
            this.b = str;
        }

        public static /* synthetic */ Phone copy$default(Phone phone, DeepLink deepLink, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLink = phone.a;
            }
            if ((i & 2) != 0) {
                str = phone.b;
            }
            return phone.copy(deepLink, str);
        }

        @NotNull
        public final DeepLink component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Phone copy(@NotNull DeepLink deepLink, @Nullable String str) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            return new Phone(deepLink, str);
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
            if (!(obj instanceof Phone)) {
                return false;
            }
            Phone phone = (Phone) obj;
            return Intrinsics.areEqual(this.a, phone.a) && Intrinsics.areEqual(this.b, phone.b);
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }

        @Nullable
        public final String getFormattedPhone() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            DeepLink deepLink = this.a;
            int i = 0;
            int hashCode = (deepLink != null ? deepLink.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Phone(deepLink=");
            L.append(this.a);
            L.append(", formattedPhone=");
            return a.t(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            parcel.writeString(this.b);
        }
    }

    public CallMethods(@Nullable Phone phone, @Nullable InApp inApp) {
        this.a = phone;
        this.b = inApp;
    }

    public static /* synthetic */ CallMethods copy$default(CallMethods callMethods, Phone phone, InApp inApp, int i, Object obj) {
        if ((i & 1) != 0) {
            phone = callMethods.a;
        }
        if ((i & 2) != 0) {
            inApp = callMethods.b;
        }
        return callMethods.copy(phone, inApp);
    }

    @Nullable
    public final Phone component1() {
        return this.a;
    }

    @Nullable
    public final InApp component2() {
        return this.b;
    }

    @NotNull
    public final CallMethods copy(@Nullable Phone phone, @Nullable InApp inApp) {
        return new CallMethods(phone, inApp);
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
        if (!(obj instanceof CallMethods)) {
            return false;
        }
        CallMethods callMethods = (CallMethods) obj;
        return Intrinsics.areEqual(this.a, callMethods.a) && Intrinsics.areEqual(this.b, callMethods.b);
    }

    @Nullable
    public final InApp getInApp() {
        return this.b;
    }

    @Nullable
    public final Phone getPhone() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Phone phone = this.a;
        int i = 0;
        int hashCode = (phone != null ? phone.hashCode() : 0) * 31;
        InApp inApp = this.b;
        if (inApp != null) {
            i = inApp.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CallMethods(phone=");
        L.append(this.a);
        L.append(", inApp=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Phone phone = this.a;
        if (phone != null) {
            parcel.writeInt(1);
            phone.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        InApp inApp = this.b;
        if (inApp != null) {
            parcel.writeInt(1);
            inApp.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
