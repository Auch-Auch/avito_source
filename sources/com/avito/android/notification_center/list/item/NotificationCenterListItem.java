package com.avito.android.notification_center.list.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItem;", "Lcom/avito/konveyor/blueprint/Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "<init>", "()V", "ErrorSnippet", "Notification", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet;", "notification_release"}, k = 1, mv = {1, 4, 2})
public abstract class NotificationCenterListItem implements Item, Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(JLjava/lang/String;)V", "Companion", "notification_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorSnippet extends NotificationCenterListItem {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<ErrorSnippet> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final long a;
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$ErrorSnippet;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "notification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, ErrorSnippet> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public ErrorSnippet invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new ErrorSnippet(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorSnippet(long j, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = j;
            this.b = str;
        }

        @Override // com.avito.konveyor.blueprint.Item
        public long getId() {
            return this.a;
        }

        @NotNull
        public final String getMessage() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001,B7\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b*\u0010+J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010&\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "e", "getDate", "setDate", "(J)V", Sort.DATE, AuthSource.BOOKING_ORDER, "getNotificationId", "notificationId", "d", "getDescription", "setDescription", "description", "", "f", "Z", "isRead", "()Z", "setRead", "(Z)V", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "Companion", "notification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Notification extends NotificationCenterListItem {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Notification> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final long a;
        @NotNull
        public final String b;
        @NotNull
        public String c;
        @NotNull
        public String d;
        public long e;
        public boolean f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "notification_release"}, k = 1, mv = {1, 4, 2})
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
                return new Notification(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readLong(), ParcelsKt.readBool(parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Notification(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, long j2, boolean z) {
            super(null);
            a2.b.a.a.a.Z0(str, "notificationId", str2, "title", str3, "description");
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = j2;
            this.f = z;
        }

        public final long getDate() {
            return this.e;
        }

        @NotNull
        public final String getDescription() {
            return this.d;
        }

        @Override // com.avito.konveyor.blueprint.Item
        public long getId() {
            return this.a;
        }

        @NotNull
        public final String getNotificationId() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }

        public final boolean isRead() {
            return this.f;
        }

        public final void setDate(long j) {
            this.e = j;
        }

        public final void setDescription(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }

        public final void setRead(boolean z) {
            this.f = z;
        }

        public final void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeLong(this.e);
            ParcelsKt.writeBool(parcel, this.f);
        }
    }

    public NotificationCenterListItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NotificationCenterListItem(j jVar) {
    }
}
