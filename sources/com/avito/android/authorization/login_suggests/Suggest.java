package com.avito.android.authorization.login_suggests;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/authorization/login_suggests/Suggest;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lcom/avito/android/remote/model/Image;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "Login", "Social", "Lcom/avito/android/authorization/login_suggests/Suggest$Login;", "Lcom/avito/android/authorization/login_suggests/Suggest$Social;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public abstract class Suggest implements Parcelable {
    @NotNull
    public final String a;
    @Nullable
    public final Image b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/avito/android/authorization/login_suggests/Suggest$Login;", "Lcom/avito/android/authorization/login_suggests/Suggest;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "c", "Ljava/lang/String;", "getLogin", "()Ljava/lang/String;", "login", "name", "Lcom/avito/android/remote/model/Image;", "avatar", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Login extends Suggest {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Login> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login_suggests/Suggest$Login$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/authorization/login_suggests/Suggest$Login;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Login> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Login invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Login(a2.b.a.a.a.u2(parcel2, "readString()!!"), (Image) parcel2.readParcelable(Image.class.getClassLoader()), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Login(@NotNull String str, @Nullable Image image, @NotNull String str2) {
            super(str, image, null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "login");
            this.c = str2;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Login)) {
                return super.equals(obj);
            }
            Login login = (Login) obj;
            return Intrinsics.areEqual(getName(), login.getName()) && Intrinsics.areEqual(getAvatar(), login.getAvatar()) && Intrinsics.areEqual(this.c, login.c);
        }

        @NotNull
        public final String getLogin() {
            return this.c;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int hashCode = getName().hashCode() * 31;
            Image avatar = getAvatar();
            return this.c.hashCode() + ((hashCode + (avatar != null ? avatar.hashCode() : 0)) * 31);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(getName());
            parcel.writeParcelable(getAvatar(), i);
            parcel.writeString(this.c);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/avito/android/authorization/login_suggests/Suggest$Social;", "Lcom/avito/android/authorization/login_suggests/Suggest;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "c", "Ljava/lang/String;", "getSocial", "()Ljava/lang/String;", "social", "d", "getSocialId", "socialId", "name", "Lcom/avito/android/remote/model/Image;", "avatar", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Social extends Suggest {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Social> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String c;
        @Nullable
        public final String d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login_suggests/Suggest$Social$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/authorization/login_suggests/Suggest$Social;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Social> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Social invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Social(a2.b.a.a.a.u2(parcel2, "readString()!!"), (Image) parcel2.readParcelable(Image.class.getClassLoader()), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Social(@NotNull String str, @Nullable Image image, @NotNull String str2, @Nullable String str3) {
            super(str, image, null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "social");
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Social)) {
                return super.equals(obj);
            }
            Social social = (Social) obj;
            return Intrinsics.areEqual(getName(), social.getName()) && Intrinsics.areEqual(getAvatar(), social.getAvatar()) && Intrinsics.areEqual(this.c, social.c) && Intrinsics.areEqual(this.d, social.d);
        }

        @NotNull
        public final String getSocial() {
            return this.c;
        }

        @Nullable
        public final String getSocialId() {
            return this.d;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int hashCode = getName().hashCode() * 31;
            Image avatar = getAvatar();
            int i = 0;
            int B0 = a2.b.a.a.a.B0(this.c, (hashCode + (avatar != null ? avatar.hashCode() : 0)) * 31, 31);
            String str = this.d;
            if (str != null) {
                i = str.hashCode();
            }
            return B0 + i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(getName());
            parcel.writeParcelable(getAvatar(), i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
        }
    }

    public Suggest(String str, Image image, j jVar) {
        this.a = str;
        this.b = image;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Image getAvatar() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }
}
