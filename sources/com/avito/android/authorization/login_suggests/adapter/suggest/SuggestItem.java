package com.avito.android.authorization.login_suggests.adapter.suggest;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.authorization.login_suggests.Suggest;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItem;", "Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/authorization/login_suggests/Suggest;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/login_suggests/Suggest;", "getSuggest", "()Lcom/avito/android/authorization/login_suggests/Suggest;", SocialButtonClickedEventKt.SUGGEST, "", "id", "<init>", "(JLcom/avito/android/authorization/login_suggests/Suggest;)V", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestItem extends LoginSuggestsItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SuggestItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Suggest b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SuggestItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SuggestItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new SuggestItem(parcel2.readLong(), (Suggest) a2.b.a.a.a.z1(Suggest.class, parcel2));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestItem(long j, @NotNull Suggest suggest) {
        super(j);
        Intrinsics.checkNotNullParameter(suggest, SocialButtonClickedEventKt.SUGGEST);
        this.b = suggest;
    }

    @NotNull
    public final Suggest getSuggest() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeParcelable(this.b, i);
    }
}
