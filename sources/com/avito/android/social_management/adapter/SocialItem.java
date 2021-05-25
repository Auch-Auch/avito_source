package com.avito.android.social_management.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Parcels;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\f\r\u000e\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem;", "Lcom/avito/konveyor/blueprint/Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Available", "Connected", "Header", "Notification", "Lcom/avito/android/social_management/adapter/SocialItem$Connected;", "Lcom/avito/android/social_management/adapter/SocialItem$Available;", "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "Lcom/avito/android/social_management/adapter/SocialItem$Header;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public abstract class SocialItem implements Item, Parcelable {
    public final long a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Available;", "Lcom/avito/android/social_management/adapter/SocialItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/social/SocialNetwork;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/social/SocialNetwork;", "getSocial", "()Lcom/avito/android/remote/model/social/SocialNetwork;", "social", "", "id", "<init>", "(JLcom/avito/android/remote/model/social/SocialNetwork;)V", "Companion", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class Available extends SocialItem {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Available> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final SocialNetwork b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Available$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/social_management/adapter/SocialItem$Available;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Available> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Available invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Available(parcel2.readLong(), (SocialNetwork) a2.b.a.a.a.z1(SocialNetwork.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Available(long j, @NotNull SocialNetwork socialNetwork) {
            super(j, null);
            Intrinsics.checkNotNullParameter(socialNetwork, "social");
            this.b = socialNetwork;
        }

        @NotNull
        public final SocialNetwork getSocial() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeParcelable(this.b, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Connected;", "Lcom/avito/android/social_management/adapter/SocialItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/social/SocialNetwork;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/social/SocialNetwork;", "getSocial", "()Lcom/avito/android/remote/model/social/SocialNetwork;", "social", "", "id", "<init>", "(JLcom/avito/android/remote/model/social/SocialNetwork;)V", "Companion", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class Connected extends SocialItem {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Connected> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final SocialNetwork b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Connected$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/social_management/adapter/SocialItem$Connected;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Connected> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Connected invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Connected(parcel2.readLong(), (SocialNetwork) a2.b.a.a.a.z1(SocialNetwork.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Connected(long j, @NotNull SocialNetwork socialNetwork) {
            super(j, null);
            Intrinsics.checkNotNullParameter(socialNetwork, "social");
            this.b = socialNetwork;
        }

        @NotNull
        public final SocialNetwork getSocial() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeParcelable(this.b, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Header;", "Lcom/avito/android/social_management/adapter/SocialItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "id", "<init>", "(JLjava/lang/String;)V", "Companion", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class Header extends SocialItem {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Header> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Header$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/social_management/adapter/SocialItem$Header;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
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
                return new Header(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Header(long j, @NotNull String str) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.b = str;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "Lcom/avito/android/social_management/adapter/SocialItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getProvider", "()Ljava/lang/String;", GeoContract.PROVIDER, "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "()Lcom/avito/android/remote/model/text/AttributedText;", "text", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "", "id", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;)V", "Companion", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class Notification extends SocialItem {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Notification> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;
        @NotNull
        public final AttributedText c;
        @Nullable
        public final String d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialItem$Notification$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Notification> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Notification invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Notification(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), (AttributedText) a2.b.a.a.a.z1(AttributedText.class, parcel2), parcel2.readString());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Notification(long j, @NotNull String str, @NotNull AttributedText attributedText, @Nullable String str2) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(attributedText, "text");
            this.b = str;
            this.c = attributedText;
            this.d = str2;
        }

        @Nullable
        public final String getProvider() {
            return this.d;
        }

        @NotNull
        public final String getStringId() {
            return this.b;
        }

        @NotNull
        public final AttributedText getText() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
            parcel.writeParcelable(this.c, i);
            parcel.writeString(this.d);
        }
    }

    public SocialItem(long j, j jVar) {
        this.a = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }
}
