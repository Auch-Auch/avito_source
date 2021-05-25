package com.avito.android.rec;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.db.FavoritesContract;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/rec/ScreenSource;", "Landroid/os/Parcelable;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "ADVERT", "BRANDSPACE", "EMPTY", "EXTENDED_PROFILE", "FAVORITES", "MAIN", "SERP", "Lcom/avito/android/rec/ScreenSource$EMPTY;", "Lcom/avito/android/rec/ScreenSource$SERP;", "Lcom/avito/android/rec/ScreenSource$MAIN;", "Lcom/avito/android/rec/ScreenSource$ADVERT;", "Lcom/avito/android/rec/ScreenSource$BRANDSPACE;", "Lcom/avito/android/rec/ScreenSource$EXTENDED_PROFILE;", "Lcom/avito/android/rec/ScreenSource$FAVORITES;", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ScreenSource implements Parcelable {
    @NotNull
    public final String a;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rec/ScreenSource$ADVERT;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ADVERT extends ScreenSource {
        public static final Parcelable.Creator<ADVERT> CREATOR = new Creator();
        @NotNull
        public static final ADVERT INSTANCE = new ADVERT();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ADVERT> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ADVERT createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return ADVERT.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ADVERT[] newArray(int i) {
                return new ADVERT[i];
            }
        }

        public ADVERT() {
            super("advert", null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rec/ScreenSource$BRANDSPACE;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class BRANDSPACE extends ScreenSource {
        public static final Parcelable.Creator<BRANDSPACE> CREATOR = new Creator();
        @NotNull
        public static final BRANDSPACE INSTANCE = new BRANDSPACE();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<BRANDSPACE> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BRANDSPACE createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return BRANDSPACE.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BRANDSPACE[] newArray(int i) {
                return new BRANDSPACE[i];
            }
        }

        public BRANDSPACE() {
            super(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rec/ScreenSource$EMPTY;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class EMPTY extends ScreenSource {
        public static final Parcelable.Creator<EMPTY> CREATOR = new Creator();
        @NotNull
        public static final EMPTY INSTANCE = new EMPTY();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<EMPTY> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EMPTY createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return EMPTY.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EMPTY[] newArray(int i) {
                return new EMPTY[i];
            }
        }

        public EMPTY() {
            super("empty", null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rec/ScreenSource$EXTENDED_PROFILE;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class EXTENDED_PROFILE extends ScreenSource {
        public static final Parcelable.Creator<EXTENDED_PROFILE> CREATOR = new Creator();
        @NotNull
        public static final EXTENDED_PROFILE INSTANCE = new EXTENDED_PROFILE();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<EXTENDED_PROFILE> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EXTENDED_PROFILE createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return EXTENDED_PROFILE.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EXTENDED_PROFILE[] newArray(int i) {
                return new EXTENDED_PROFILE[i];
            }
        }

        public EXTENDED_PROFILE() {
            super("extended_profile", null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rec/ScreenSource$FAVORITES;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FAVORITES extends ScreenSource {
        public static final Parcelable.Creator<FAVORITES> CREATOR = new Creator();
        @NotNull
        public static final FAVORITES INSTANCE = new FAVORITES();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FAVORITES> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FAVORITES createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return FAVORITES.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FAVORITES[] newArray(int i) {
                return new FAVORITES[i];
            }
        }

        public FAVORITES() {
            super(FavoritesContract.TABLE_NAME, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/rec/ScreenSource$MAIN;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "feedId", "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class MAIN extends ScreenSource {
        public static final Parcelable.Creator<MAIN> CREATOR = new Creator();
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<MAIN> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MAIN createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new MAIN(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MAIN[] newArray(int i) {
                return new MAIN[i];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public MAIN(@org.jetbrains.annotations.NotNull java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "feedId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                int r0 = r3.length()
                if (r0 <= 0) goto L_0x000d
                r0 = 1
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                java.lang.String r1 = "main"
                if (r0 == 0) goto L_0x0018
                r0 = 95
                java.lang.String r1 = a2.b.a.a.a.L2(r1, r0, r3)
            L_0x0018:
                r0 = 0
                r2.<init>(r1, r0)
                r2.b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rec.ScreenSource.MAIN.<init>(java.lang.String):void");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getFeedId() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.b);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rec/ScreenSource$SERP;", "Lcom/avito/android/rec/ScreenSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SERP extends ScreenSource {
        public static final Parcelable.Creator<SERP> CREATOR = new Creator();
        @NotNull
        public static final SERP INSTANCE = new SERP();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SERP> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SERP createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return SERP.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SERP[] newArray(int i) {
                return new SERP[i];
            }
        }

        public SERP() {
            super("catalog", null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    public ScreenSource(String str, j jVar) {
        this.a = str;
    }

    @NotNull
    public final String getSource() {
        return this.a;
    }
}
