package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB%\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/SellerVerification;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SellerVerification$VerificationItem;", "internal", "Lcom/avito/android/remote/model/SellerVerification$VerificationItem;", "getInternal", "()Lcom/avito/android/remote/model/SellerVerification$VerificationItem;", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "getAwards", "()Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "external", "getExternal", "<init>", "(Lcom/avito/android/remote/model/SellerVerification$VerificationItem;Lcom/avito/android/remote/model/SellerVerification$VerificationItem;Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "AwardsItem", "BaseVerificationItem", "VerificationItem", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SellerVerification implements Parcelable {
    public static final Parcelable.Creator<SellerVerification> CREATOR = new Creator();
    @SerializedName("autoDealerOfTheYear")
    @Nullable
    private final AwardsItem awards;
    @SerializedName("external")
    @Nullable
    private final VerificationItem external;
    @SerializedName("internal")
    @Nullable
    private final VerificationItem internal;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0017\u0018\u00010\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R0\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0017\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "Lcom/avito/android/remote/model/SellerVerification$BaseVerificationItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class AwardsItem implements BaseVerificationItem, Parcelable {
        public static final Parcelable.Creator<AwardsItem> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final Action action;
        @SerializedName("data")
        @Nullable
        private final Map<String, List<String>> data;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AwardsItem> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AwardsItem createFromParcel(@NotNull Parcel parcel) {
                LinkedHashMap linkedHashMap;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Action action = (Action) parcel.readParcelable(AwardsItem.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        linkedHashMap.put(parcel.readString(), parcel.createStringArrayList());
                        readInt--;
                    }
                } else {
                    linkedHashMap = null;
                }
                return new AwardsItem(readString, readString2, action, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AwardsItem[] newArray(int i) {
                return new AwardsItem[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> */
        /* JADX WARN: Multi-variable type inference failed */
        public AwardsItem(@NotNull String str, @Nullable String str2, @Nullable Action action2, @Nullable Map<String, ? extends List<String>> map) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.description = str2;
            this.action = action2;
            this.data = map;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.SellerVerification.BaseVerificationItem
        @Nullable
        public Action getAction() {
            return this.action;
        }

        @Nullable
        public final Map<String, List<String>> getData() {
            return this.data;
        }

        @Override // com.avito.android.remote.model.SellerVerification.BaseVerificationItem
        @Nullable
        public String getDescription() {
            return this.description;
        }

        @Override // com.avito.android.remote.model.SellerVerification.BaseVerificationItem
        @NotNull
        public String getTitle() {
            return this.title;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = r2.title
                r3.writeString(r0)
                java.lang.String r0 = r2.description
                r3.writeString(r0)
                com.avito.android.remote.model.Action r0 = r2.action
                r3.writeParcelable(r0, r4)
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r2.data
                if (r4 == 0) goto L_0x003a
                r0 = 1
                java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
            L_0x001d:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003e
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                java.util.List r0 = (java.util.List) r0
                r3.writeStringList(r0)
                goto L_0x001d
            L_0x003a:
                r4 = 0
                r3.writeInt(r4)
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.SellerVerification.AwardsItem.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/SellerVerification$BaseVerificationItem;", "", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "", "getTitle", "()Ljava/lang/String;", "title", "getDescription", "description", "models_release"}, k = 1, mv = {1, 4, 2})
    public interface BaseVerificationItem {
        @Nullable
        Action getAction();

        @Nullable
        String getDescription();

        @NotNull
        String getTitle();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SellerVerification> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerVerification createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AwardsItem awardsItem = null;
            VerificationItem createFromParcel = parcel.readInt() != 0 ? VerificationItem.CREATOR.createFromParcel(parcel) : null;
            VerificationItem createFromParcel2 = parcel.readInt() != 0 ? VerificationItem.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                awardsItem = AwardsItem.CREATOR.createFromParcel(parcel);
            }
            return new SellerVerification(createFromParcel, createFromParcel2, awardsItem);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerVerification[] newArray(int i) {
            return new SellerVerification[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/SellerVerification$VerificationItem;", "Lcom/avito/android/remote/model/SellerVerification$BaseVerificationItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "descriptionTitle", "Ljava/lang/String;", "getDescriptionTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "title", "getTitle", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationItem implements BaseVerificationItem, Parcelable {
        public static final Parcelable.Creator<VerificationItem> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final Action action;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("descriptionTitle")
        @Nullable
        private final String descriptionTitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<VerificationItem> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final VerificationItem createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new VerificationItem(parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(VerificationItem.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final VerificationItem[] newArray(int i) {
                return new VerificationItem[i];
            }
        }

        public VerificationItem(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Action action2) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.description = str2;
            this.descriptionTitle = str3;
            this.action = action2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.SellerVerification.BaseVerificationItem
        @Nullable
        public Action getAction() {
            return this.action;
        }

        @Override // com.avito.android.remote.model.SellerVerification.BaseVerificationItem
        @Nullable
        public String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getDescriptionTitle() {
            return this.descriptionTitle;
        }

        @Override // com.avito.android.remote.model.SellerVerification.BaseVerificationItem
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.descriptionTitle);
            parcel.writeParcelable(this.action, i);
        }
    }

    public SellerVerification(@Nullable VerificationItem verificationItem, @Nullable VerificationItem verificationItem2, @Nullable AwardsItem awardsItem) {
        this.internal = verificationItem;
        this.external = verificationItem2;
        this.awards = awardsItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AwardsItem getAwards() {
        return this.awards;
    }

    @Nullable
    public final VerificationItem getExternal() {
        return this.external;
    }

    @Nullable
    public final VerificationItem getInternal() {
        return this.internal;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        VerificationItem verificationItem = this.internal;
        if (verificationItem != null) {
            parcel.writeInt(1);
            verificationItem.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        VerificationItem verificationItem2 = this.external;
        if (verificationItem2 != null) {
            parcel.writeInt(1);
            verificationItem2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AwardsItem awardsItem = this.awards;
        if (awardsItem != null) {
            parcel.writeInt(1);
            awardsItem.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
