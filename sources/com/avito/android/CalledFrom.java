package com.avito.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0004\u0011\u0012\u0013\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/CalledFrom;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "from", "AndroidShortcuts", "AppLinking", "NotificationCenter", "Push", "analytics_release"}, k = 1, mv = {1, 4, 2})
public abstract class CalledFrom implements Parcelable {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/CalledFrom$AndroidShortcuts;", "Lcom/avito/android/CalledFrom;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class AndroidShortcuts extends CalledFrom {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<AndroidShortcuts> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/CalledFrom$AndroidShortcuts$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/CalledFrom$AndroidShortcuts;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, AndroidShortcuts> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public AndroidShortcuts invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new AndroidShortcuts(a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AndroidShortcuts(@NotNull String str) {
            super("android_shortcuts", null);
            Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
            this.b = str;
        }

        @NotNull
        public final String getPath() {
            return this.b;
        }

        @Override // com.avito.android.CalledFrom, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/CalledFrom$AppLinking;", "Lcom/avito/android/CalledFrom;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppLinking extends CalledFrom {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<AppLinking> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/CalledFrom$AppLinking$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/CalledFrom$AppLinking;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, AppLinking> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public AppLinking invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new AppLinking(a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppLinking(@NotNull String str) {
            super("appindexing", null);
            Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
            this.b = str;
        }

        @NotNull
        public final String getPath() {
            return this.b;
        }

        @Override // com.avito.android.CalledFrom, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/CalledFrom$NotificationCenter;", "Lcom/avito/android/CalledFrom;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "analyticParams", "<init>", "(Ljava/util/Map;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotificationCenter extends CalledFrom {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<NotificationCenter> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final Map<String, String> b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/CalledFrom$NotificationCenter$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/CalledFrom$NotificationCenter;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, NotificationCenter> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public NotificationCenter invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                Map createValueMap = ParcelUtils.createValueMap(parcel2, String.class, String.class);
                if (createValueMap == null) {
                    createValueMap = r.emptyMap();
                }
                return new NotificationCenter(createValueMap);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationCenter(@NotNull Map<String, String> map) {
            super("notification_center", null);
            Intrinsics.checkNotNullParameter(map, "analyticParams");
            this.b = map;
        }

        @NotNull
        public final Map<String, String> getAnalyticParams() {
            return this.b;
        }

        @Override // com.avito.android.CalledFrom, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeMap(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/CalledFrom$Push;", "Lcom/avito/android/CalledFrom;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/notification/Payload;", "c", "Lcom/avito/android/remote/model/notification/Payload;", "getPayload", "()Lcom/avito/android/remote/model/notification/Payload;", "payload", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/notification/Payload;)V", "Companion", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class Push extends CalledFrom {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Push> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;
        @Nullable
        public final Payload c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/CalledFrom$Push$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/CalledFrom$Push;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Push> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Push invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Push(a2.b.a.a.a.u2(parcel2, "readString()!!"), (Payload) parcel2.readParcelable(Payload.class.getClassLoader()));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Push(@NotNull String str, @Nullable Payload payload) {
            super("push", null);
            Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
            this.b = str;
            this.c = payload;
        }

        @NotNull
        public final String getPath() {
            return this.b;
        }

        @Nullable
        public final Payload getPayload() {
            return this.c;
        }

        @Override // com.avito.android.CalledFrom, android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.b);
            parcel.writeParcelable(this.c, i);
        }
    }

    public CalledFrom(String str, j jVar) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getFrom() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
    }
}
