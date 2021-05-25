package com.avito.android.authorization.select_profile.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.Parcels;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\f\r\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "Lcom/avito/konveyor/blueprint/Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "CreateProfile", "Profile", "Text", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Text;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Profile;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$CreateProfile;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public abstract class SelectProfileField implements Item, Parcelable {
    public final long a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$CreateProfile;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "id", "<init>", "(JLjava/lang/String;)V", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreateProfile extends SelectProfileField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<CreateProfile> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$CreateProfile$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$CreateProfile;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, CreateProfile> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public CreateProfile invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new CreateProfile(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateProfile(long j, @NotNull String str) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.b = str;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Profile;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "getProfile", "()Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profile", "", "id", "<init>", "(JLcom/avito/android/remote/model/registration/RegisteredProfile;)V", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Profile extends SelectProfileField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Profile> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final RegisteredProfile b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Profile$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Profile;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Profile> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Profile invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Profile(parcel2.readLong(), (RegisteredProfile) a2.b.a.a.a.z1(RegisteredProfile.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Profile(long j, @NotNull RegisteredProfile registeredProfile) {
            super(j, null);
            Intrinsics.checkNotNullParameter(registeredProfile, "profile");
            this.b = registeredProfile;
        }

        @NotNull
        public final RegisteredProfile getProfile() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeParcelable(this.b, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Text;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "id", "<init>", "(JLjava/lang/String;)V", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Text extends SelectProfileField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Text> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Text$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField$Text;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Text> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Text invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Text(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(long j, @NotNull String str) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.b = str;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
        }
    }

    public SelectProfileField(long j, j jVar) {
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
