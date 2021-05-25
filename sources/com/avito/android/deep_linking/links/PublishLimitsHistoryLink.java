package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001f\u001a\u00020\u000f8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0011¨\u0006$"}, d2 = {"Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;", "component1", "()Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;", "request", "copy", "(Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;)Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;", "getRequest", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, "<init>", "(Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;)V", "Companion", "Request", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsHistoryLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PublishLimitsHistoryLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/publish/limits/history";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final Request d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink;", "forAdvert", "(Ljava/lang/String;)Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink;", "draftId", "forDraft", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PublishLimitsHistoryLink forAdvert(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            return new PublishLimitsHistoryLink(new Request.AdvertId(str));
        }

        @NotNull
        public final PublishLimitsHistoryLink forDraft(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "draftId");
            return new PublishLimitsHistoryLink(new Request.DraftId(str));
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;", "Landroid/os/Parcelable;", "<init>", "()V", "AdvertId", "DraftId", "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request$AdvertId;", "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request$DraftId;", "models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Request implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request$AdvertId;", "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;", "", "component1", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "copy", "(Ljava/lang/String;)Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request$AdvertId;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class AdvertId extends Request {
            public static final Parcelable.Creator<AdvertId> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<AdvertId> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final AdvertId createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new AdvertId(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final AdvertId[] newArray(int i) {
                    return new AdvertId[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AdvertId(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
                this.a = str;
            }

            public static /* synthetic */ AdvertId copy$default(AdvertId advertId, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = advertId.a;
                }
                return advertId.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final AdvertId copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
                return new AdvertId(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof AdvertId) && Intrinsics.areEqual(this.a, ((AdvertId) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getAdvertId() {
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
                return a2.b.a.a.a.t(a2.b.a.a.a.L("AdvertId(advertId="), this.a, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request$DraftId;", "Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request;", "", "component1", "()Ljava/lang/String;", "draftId", "copy", "(Ljava/lang/String;)Lcom/avito/android/deep_linking/links/PublishLimitsHistoryLink$Request$DraftId;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDraftId", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class DraftId extends Request {
            public static final Parcelable.Creator<DraftId> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<DraftId> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final DraftId createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new DraftId(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final DraftId[] newArray(int i) {
                    return new DraftId[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DraftId(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "draftId");
                this.a = str;
            }

            public static /* synthetic */ DraftId copy$default(DraftId draftId, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = draftId.a;
                }
                return draftId.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final DraftId copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "draftId");
                return new DraftId(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof DraftId) && Intrinsics.areEqual(this.a, ((DraftId) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getDraftId() {
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
                return a2.b.a.a.a.t(a2.b.a.a.a.L("DraftId(draftId="), this.a, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        public Request() {
        }

        public Request(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, PublishLimitsHistoryLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PublishLimitsHistoryLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new PublishLimitsHistoryLink((Request) a2.b.a.a.a.z1(Request.class, parcel2));
        }
    }

    public PublishLimitsHistoryLink(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.d = request;
    }

    public static /* synthetic */ PublishLimitsHistoryLink copy$default(PublishLimitsHistoryLink publishLimitsHistoryLink, Request request, int i, Object obj) {
        if ((i & 1) != 0) {
            request = publishLimitsHistoryLink.d;
        }
        return publishLimitsHistoryLink.copy(request);
    }

    @NotNull
    public final Request component1() {
        return this.d;
    }

    @NotNull
    public final PublishLimitsHistoryLink copy(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new PublishLimitsHistoryLink(request);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof PublishLimitsHistoryLink) && Intrinsics.areEqual(this.d, ((PublishLimitsHistoryLink) obj).d);
        }
        return true;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final Request getRequest() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Request request = this.d;
        if (request != null) {
            return request.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("PublishLimitsHistoryLink(request=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.d, i);
    }
}
