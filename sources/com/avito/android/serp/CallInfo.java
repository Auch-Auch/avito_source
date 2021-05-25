package com.avito.android.serp;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/serp/CallInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getCallLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "callLink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/analytics/event/ContactSource;", "c", "Lcom/avito/android/analytics/event/ContactSource;", "getContactSource", "()Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class CallInfo implements Parcelable {
    public static final Parcelable.Creator<CallInfo> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final DeepLink b;
    @NotNull
    public final ContactSource c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CallInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CallInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CallInfo(parcel.readString(), (DeepLink) parcel.readParcelable(CallInfo.class.getClassLoader()), (ContactSource) Enum.valueOf(ContactSource.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CallInfo[] newArray(int i) {
            return new CallInfo[i];
        }
    }

    public CallInfo(@NotNull String str, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(deepLink, "callLink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.a = str;
        this.b = deepLink;
        this.c = contactSource;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final DeepLink getCallLink() {
        return this.b;
    }

    @NotNull
    public final ContactSource getContactSource() {
        return this.c;
    }

    @NotNull
    public final String getStringId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c.name());
    }
}
