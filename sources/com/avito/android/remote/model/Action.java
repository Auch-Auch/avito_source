package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0012\b\b\u0018\u0000 32\u00020\u0001:\u000234BG\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b!\u0010\rJ\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u001a\u0010%\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010\u0010R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u0013R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010\rR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b-\u0010\rR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b0\u0010\r¨\u00065"}, d2 = {"Lcom/avito/android/remote/model/Action;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/Action$Confirmation;", "component3", "()Lcom/avito/android/remote/model/Action$Confirmation;", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "title", "deepLink", "confirmation", "type", "rawUri", "closesElement", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Action$Confirmation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/Action;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "Lcom/avito/android/remote/model/Action$Confirmation;", "getConfirmation", "Ljava/lang/String;", "getRawUri", "getType", "Ljava/lang/Boolean;", "getClosesElement", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Action$Confirmation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion", "Confirmation", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Action implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Action> CREATOR = Parcels.creator(Action$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Boolean closesElement;
    @Nullable
    private final Confirmation confirmation;
    @NotNull
    private final DeepLink deepLink;
    @Nullable
    private final String rawUri;
    @NotNull
    private final String title;
    @Nullable
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Action$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Action;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B'\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0013\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b \u0010\rR\u001c\u0010\u0011\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b!\u0010\rR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\"\u0010\r¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/Action$Confirmation;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "title", "description", "ok", "cancel", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/Action$Confirmation;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOk", "getCancel", "getTitle", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Confirmation implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Confirmation> CREATOR = Parcels.creator(Action$Confirmation$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("cancel")
        @NotNull
        private final String cancel;
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("ok")
        @NotNull
        private final String ok;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Action$Confirmation$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Action$Confirmation;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Confirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            a.b1(str, "title", str2, "description", str3, "ok", str4, "cancel");
            this.title = str;
            this.description = str2;
            this.ok = str3;
            this.cancel = str4;
        }

        public static /* synthetic */ Confirmation copy$default(Confirmation confirmation, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = confirmation.title;
            }
            if ((i & 2) != 0) {
                str2 = confirmation.description;
            }
            if ((i & 4) != 0) {
                str3 = confirmation.ok;
            }
            if ((i & 8) != 0) {
                str4 = confirmation.cancel;
            }
            return confirmation.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.description;
        }

        @NotNull
        public final String component3() {
            return this.ok;
        }

        @NotNull
        public final String component4() {
            return this.cancel;
        }

        @NotNull
        public final Confirmation copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "ok");
            Intrinsics.checkNotNullParameter(str4, "cancel");
            return new Confirmation(str, str2, str3, str4);
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
            if (!(obj instanceof Confirmation)) {
                return false;
            }
            Confirmation confirmation = (Confirmation) obj;
            return Intrinsics.areEqual(this.title, confirmation.title) && Intrinsics.areEqual(this.description, confirmation.description) && Intrinsics.areEqual(this.ok, confirmation.ok) && Intrinsics.areEqual(this.cancel, confirmation.cancel);
        }

        @NotNull
        public final String getCancel() {
            return this.cancel;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getOk() {
            return this.ok;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.ok;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.cancel;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Confirmation(title=");
            L.append(this.title);
            L.append(", description=");
            L.append(this.description);
            L.append(", ok=");
            L.append(this.ok);
            L.append(", cancel=");
            return a.t(L, this.cancel, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.ok);
            parcel.writeString(this.cancel);
        }
    }

    public Action(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable Confirmation confirmation2, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.title = str;
        this.deepLink = deepLink2;
        this.confirmation = confirmation2;
        this.type = str2;
        this.rawUri = str3;
        this.closesElement = bool;
    }

    public static /* synthetic */ Action copy$default(Action action, String str, DeepLink deepLink2, Confirmation confirmation2, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = action.title;
        }
        if ((i & 2) != 0) {
            deepLink2 = action.deepLink;
        }
        if ((i & 4) != 0) {
            confirmation2 = action.confirmation;
        }
        if ((i & 8) != 0) {
            str2 = action.type;
        }
        if ((i & 16) != 0) {
            str3 = action.rawUri;
        }
        if ((i & 32) != 0) {
            bool = action.closesElement;
        }
        return action.copy(str, deepLink2, confirmation2, str2, str3, bool);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final DeepLink component2() {
        return this.deepLink;
    }

    @Nullable
    public final Confirmation component3() {
        return this.confirmation;
    }

    @Nullable
    public final String component4() {
        return this.type;
    }

    @Nullable
    public final String component5() {
        return this.rawUri;
    }

    @Nullable
    public final Boolean component6() {
        return this.closesElement;
    }

    @NotNull
    public final Action copy(@NotNull String str, @NotNull DeepLink deepLink2, @Nullable Confirmation confirmation2, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        return new Action(str, deepLink2, confirmation2, str2, str3, bool);
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
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return Intrinsics.areEqual(this.title, action.title) && Intrinsics.areEqual(this.deepLink, action.deepLink) && Intrinsics.areEqual(this.confirmation, action.confirmation) && Intrinsics.areEqual(this.type, action.type) && Intrinsics.areEqual(this.rawUri, action.rawUri) && Intrinsics.areEqual(this.closesElement, action.closesElement);
    }

    @Nullable
    public final Boolean getClosesElement() {
        return this.closesElement;
    }

    @Nullable
    public final Confirmation getConfirmation() {
        return this.confirmation;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getRawUri() {
        return this.rawUri;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DeepLink deepLink2 = this.deepLink;
        int hashCode2 = (hashCode + (deepLink2 != null ? deepLink2.hashCode() : 0)) * 31;
        Confirmation confirmation2 = this.confirmation;
        int hashCode3 = (hashCode2 + (confirmation2 != null ? confirmation2.hashCode() : 0)) * 31;
        String str2 = this.type;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rawUri;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.closesElement;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Action(title=");
        L.append(this.title);
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", confirmation=");
        L.append(this.confirmation);
        L.append(", type=");
        L.append(this.type);
        L.append(", rawUri=");
        L.append(this.rawUri);
        L.append(", closesElement=");
        return a.o(L, this.closesElement, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.deepLink, i);
        parcel.writeParcelable(this.confirmation, i);
        ParcelsKt.writeNullableValue(parcel, this.type);
        ParcelsKt.writeNullableValue(parcel, this.rawUri);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Action(String str, DeepLink deepLink2, Confirmation confirmation2, String str2, String str3, Boolean bool, int i, j jVar) {
        this(str, deepLink2, (i & 4) != 0 ? null : confirmation2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : bool);
    }
}
