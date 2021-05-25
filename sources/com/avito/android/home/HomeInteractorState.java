package com.avito.android.home;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/home/HomeInteractorState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Location;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "location", "", "c", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "Lcom/avito/android/remote/model/Shortcuts;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Shortcuts;", "getShortcuts", "()Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "<init>", "(Lcom/avito/android/remote/model/Shortcuts;Lcom/avito/android/remote/model/Location;Ljava/lang/String;)V", "Companion", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeInteractorState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<HomeInteractorState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public final Shortcuts a;
    @Nullable
    public final Location b;
    @Nullable
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/home/HomeInteractorState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/home/HomeInteractorState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, HomeInteractorState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public HomeInteractorState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new HomeInteractorState((Shortcuts) parcel2.readParcelable(Shortcuts.class.getClassLoader()), (Location) parcel2.readParcelable(Location.class.getClassLoader()), parcel2.readString());
        }
    }

    public HomeInteractorState(@Nullable Shortcuts shortcuts, @Nullable Location location, @Nullable String str) {
        this.a = shortcuts;
        this.b = location;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Location getLocation() {
        return this.b;
    }

    @Nullable
    public final Shortcuts getShortcuts() {
        return this.a;
    }

    @Nullable
    public final String getUserId() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
    }
}
