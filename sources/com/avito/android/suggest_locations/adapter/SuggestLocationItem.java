package com.avito.android.suggest_locations.adapter;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001:\u0003;<=B5\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b9\u0010:J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JF\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b#\u0010\u001eJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b(\u0010)R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\rR\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\nR\u0019\u0010\u0018\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0013¨\u0006>"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "Landroid/os/Parcelable;", "", "withIcon", "()Z", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/CaseText;", "component2", "()Lcom/avito/android/remote/model/CaseText;", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;", "component3", "()Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;", "component4", "()Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$SuggestType;", "component5", "()Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$SuggestType;", "id", "names", "from", "parent", "suggestType", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$SuggestType;)Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;", "getFrom", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "d", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;", "getParent", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/CaseText;", "getNames", "e", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$SuggestType;", "getSuggestType", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$SuggestType;)V", HttpHeaders.FROM, "Parent", "SuggestType", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationItem implements Parcelable {
    public static final Parcelable.Creator<SuggestLocationItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final CaseText b;
    @Nullable
    public final From c;
    @Nullable
    public final Parent d;
    @NotNull
    public final SuggestType e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestLocationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestLocationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SuggestLocationItem(parcel.readString(), (CaseText) parcel.readParcelable(SuggestLocationItem.class.getClassLoader()), parcel.readInt() != 0 ? From.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Parent.CREATOR.createFromParcel(parcel) : null, (SuggestType) Enum.valueOf(SuggestType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestLocationItem[] newArray(int i) {
            return new SuggestLocationItem[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "internalId", "name", MessageMetaInfo.COLUMN_PATH, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$From;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "c", "getPath", AuthSource.SEND_ABUSE, "getInternalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class From implements Parcelable {
        public static final Parcelable.Creator<From> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<From> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final From createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new From(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final From[] newArray(int i) {
                return new From[i];
            }
        }

        public From() {
            this(null, null, null, 7, null);
        }

        public From(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public static /* synthetic */ From copy$default(From from, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = from.a;
            }
            if ((i & 2) != 0) {
                str2 = from.b;
            }
            if ((i & 4) != 0) {
                str3 = from.c;
            }
            return from.copy(str, str2, str3);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final From copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            return new From(str, str2, str3);
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
            if (!(obj instanceof From)) {
                return false;
            }
            From from = (From) obj;
            return Intrinsics.areEqual(this.a, from.a) && Intrinsics.areEqual(this.b, from.b) && Intrinsics.areEqual(this.c, from.c);
        }

        @Nullable
        public final String getInternalId() {
            return this.a;
        }

        @Nullable
        public final String getName() {
            return this.b;
        }

        @Nullable
        public final String getPath() {
            return this.c;
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
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("From(internalId=");
            L.append(this.a);
            L.append(", name=");
            L.append(this.b);
            L.append(", path=");
            return a.t(L, this.c, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ From(String str, String str2, String str3, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/CaseText;", "component2", "()Lcom/avito/android/remote/model/CaseText;", "id", "names", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;)Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$Parent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/CaseText;", "getNames", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parent implements Parcelable {
        public static final Parcelable.Creator<Parent> CREATOR = new Creator();
        @Nullable
        public final String a;
        @NotNull
        public final CaseText b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Parent> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Parent createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Parent(parcel.readString(), (CaseText) parcel.readParcelable(Parent.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Parent[] newArray(int i) {
                return new Parent[i];
            }
        }

        public Parent() {
            this(null, null, 3, null);
        }

        public Parent(@Nullable String str, @NotNull CaseText caseText) {
            Intrinsics.checkNotNullParameter(caseText, "names");
            this.a = str;
            this.b = caseText;
        }

        public static /* synthetic */ Parent copy$default(Parent parent, String str, CaseText caseText, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent.a;
            }
            if ((i & 2) != 0) {
                caseText = parent.b;
            }
            return parent.copy(str, caseText);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final CaseText component2() {
            return this.b;
        }

        @NotNull
        public final Parent copy(@Nullable String str, @NotNull CaseText caseText) {
            Intrinsics.checkNotNullParameter(caseText, "names");
            return new Parent(str, caseText);
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
            if (!(obj instanceof Parent)) {
                return false;
            }
            Parent parent = (Parent) obj;
            return Intrinsics.areEqual(this.a, parent.a) && Intrinsics.areEqual(this.b, parent.b);
        }

        @Nullable
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final CaseText getNames() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            CaseText caseText = this.b;
            if (caseText != null) {
                i = caseText.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Parent(id=");
            L.append(this.a);
            L.append(", names=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Parent(String str, CaseText caseText, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new CaseText() : caseText);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem$SuggestType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "HISTORICAL", MessengerShareContentUtility.PREVIEW_DEFAULT, "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public enum SuggestType {
        HISTORICAL("history"),
        DEFAULT("default");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        SuggestType(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    public SuggestLocationItem(@NotNull String str, @NotNull CaseText caseText, @Nullable From from, @Nullable Parent parent, @NotNull SuggestType suggestType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(caseText, "names");
        Intrinsics.checkNotNullParameter(suggestType, "suggestType");
        this.a = str;
        this.b = caseText;
        this.c = from;
        this.d = parent;
        this.e = suggestType;
    }

    public static /* synthetic */ SuggestLocationItem copy$default(SuggestLocationItem suggestLocationItem, String str, CaseText caseText, From from, Parent parent, SuggestType suggestType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suggestLocationItem.a;
        }
        if ((i & 2) != 0) {
            caseText = suggestLocationItem.b;
        }
        if ((i & 4) != 0) {
            from = suggestLocationItem.c;
        }
        if ((i & 8) != 0) {
            parent = suggestLocationItem.d;
        }
        if ((i & 16) != 0) {
            suggestType = suggestLocationItem.e;
        }
        return suggestLocationItem.copy(str, caseText, from, parent, suggestType);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final CaseText component2() {
        return this.b;
    }

    @Nullable
    public final From component3() {
        return this.c;
    }

    @Nullable
    public final Parent component4() {
        return this.d;
    }

    @NotNull
    public final SuggestType component5() {
        return this.e;
    }

    @NotNull
    public final SuggestLocationItem copy(@NotNull String str, @NotNull CaseText caseText, @Nullable From from, @Nullable Parent parent, @NotNull SuggestType suggestType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(caseText, "names");
        Intrinsics.checkNotNullParameter(suggestType, "suggestType");
        return new SuggestLocationItem(str, caseText, from, parent, suggestType);
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
        if (!(obj instanceof SuggestLocationItem)) {
            return false;
        }
        SuggestLocationItem suggestLocationItem = (SuggestLocationItem) obj;
        return Intrinsics.areEqual(this.a, suggestLocationItem.a) && Intrinsics.areEqual(this.b, suggestLocationItem.b) && Intrinsics.areEqual(this.c, suggestLocationItem.c) && Intrinsics.areEqual(this.d, suggestLocationItem.d) && Intrinsics.areEqual(this.e, suggestLocationItem.e);
    }

    @Nullable
    public final From getFrom() {
        return this.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final CaseText getNames() {
        return this.b;
    }

    @Nullable
    public final Parent getParent() {
        return this.d;
    }

    @NotNull
    public final SuggestType getSuggestType() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CaseText caseText = this.b;
        int hashCode2 = (hashCode + (caseText != null ? caseText.hashCode() : 0)) * 31;
        From from = this.c;
        int hashCode3 = (hashCode2 + (from != null ? from.hashCode() : 0)) * 31;
        Parent parent = this.d;
        int hashCode4 = (hashCode3 + (parent != null ? parent.hashCode() : 0)) * 31;
        SuggestType suggestType = this.e;
        if (suggestType != null) {
            i = suggestType.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SuggestLocationItem(id=");
        L.append(this.a);
        L.append(", names=");
        L.append(this.b);
        L.append(", from=");
        L.append(this.c);
        L.append(", parent=");
        L.append(this.d);
        L.append(", suggestType=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    public final boolean withIcon() {
        return this.e == SuggestType.HISTORICAL;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        From from = this.c;
        if (from != null) {
            parcel.writeInt(1);
            from.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Parent parent = this.d;
        if (parent != null) {
            parcel.writeInt(1);
            parent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.e.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuggestLocationItem(String str, CaseText caseText, From from, Parent parent, SuggestType suggestType, int i, j jVar) {
        this(str, caseText, from, parent, (i & 16) != 0 ? SuggestType.DEFAULT : suggestType);
    }
}
