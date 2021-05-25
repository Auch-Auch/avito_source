package com.avito.android.advert_core.feature_teasers.common.dialog;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserOption;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "CheckedByAvito", "FeaturesList", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$CheckedByAvito;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$FeaturesList;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class AdvertDetailsFeatureTeaserDialogInfo implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u0017\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006\""}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$CheckedByAvito;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "getTitle", "()Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "title", "", "c", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "options", "", "d", "Ljava/lang/String;", "getBtnText", "()Ljava/lang/String;", "btnText", AuthSource.BOOKING_ORDER, "getSubtitle", MessengerShareContentUtility.SUBTITLE, "<init>", "(Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CheckedByAvito extends AdvertDetailsFeatureTeaserDialogInfo {
        public static final Parcelable.Creator<CheckedByAvito> CREATOR = new Creator();
        @NotNull
        public final AdvertDetailsFeatureTeaserOption a;
        @NotNull
        public final String b;
        @NotNull
        public final List<AdvertDetailsFeatureTeaserOption> c;
        @NotNull
        public final String d;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<CheckedByAvito> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CheckedByAvito createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                AdvertDetailsFeatureTeaserOption createFromParcel = AdvertDetailsFeatureTeaserOption.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(AdvertDetailsFeatureTeaserOption.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new CheckedByAvito(createFromParcel, readString, arrayList, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CheckedByAvito[] newArray(int i) {
                return new CheckedByAvito[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CheckedByAvito(@NotNull AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption, @NotNull String str, @NotNull List<AdvertDetailsFeatureTeaserOption> list, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserOption, "title");
            Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(list, "options");
            Intrinsics.checkNotNullParameter(str2, "btnText");
            this.a = advertDetailsFeatureTeaserOption;
            this.b = str;
            this.c = list;
            this.d = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getBtnText() {
            return this.d;
        }

        @NotNull
        public final List<AdvertDetailsFeatureTeaserOption> getOptions() {
            return this.c;
        }

        @NotNull
        public final String getSubtitle() {
            return this.b;
        }

        @NotNull
        public final AdvertDetailsFeatureTeaserOption getTitle() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a.writeToParcel(parcel, 0);
            parcel.writeString(this.b);
            Iterator n0 = a.n0(this.c, parcel);
            while (n0.hasNext()) {
                ((AdvertDetailsFeatureTeaserOption) n0.next()).writeToParcel(parcel, 0);
            }
            parcel.writeString(this.d);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo$FeaturesList;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getBlocks", "()Ljava/util/Map;", "blocks", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FeaturesList extends AdvertDetailsFeatureTeaserDialogInfo {
        public static final Parcelable.Creator<FeaturesList> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final Map<String, List<String>> b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FeaturesList> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FeaturesList createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    linkedHashMap.put(parcel.readString(), parcel.createStringArrayList());
                    readInt--;
                }
                return new FeaturesList(readString, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FeaturesList[] newArray(int i) {
                return new FeaturesList[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeaturesList(@NotNull String str, @NotNull Map<String, ? extends List<String>> map) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(map, "blocks");
            this.a = str;
            this.b = map;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Map<String, List<String>> getBlocks() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
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
                java.lang.String r4 = r2.a
                r3.writeString(r4)
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r2.b
                java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
            L_0x0010:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x002d
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                java.util.List r0 = (java.util.List) r0
                r3.writeStringList(r0)
                goto L_0x0010
            L_0x002d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo.FeaturesList.writeToParcel(android.os.Parcel, int):void");
        }
    }

    public AdvertDetailsFeatureTeaserDialogInfo() {
    }

    public AdvertDetailsFeatureTeaserDialogInfo(j jVar) {
    }
}
