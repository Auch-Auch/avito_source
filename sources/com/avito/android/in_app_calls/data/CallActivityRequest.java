package com.avito.android.in_app_calls.data;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/calls_shared/CallId;", "getCallUuid", "()Ljava/lang/String;", "callUuid", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "()Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "Lcom/avito/android/calls_shared/CallSide;", "getCallSide", "()Lcom/avito/android/calls_shared/CallSide;", "callSide", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", "()Lcom/avito/android/calls_shared/ItemInfo;", "item", "<init>", "()V", "Dial", "Open", "Receive", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Open;", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class CallActivityRequest implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b1\u00102J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0012\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000eR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000bR \u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0005R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\b¨\u00063"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Open;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "", "Lcom/avito/android/calls_shared/CallId;", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/ItemInfo;", "component2", "()Lcom/avito/android/calls_shared/ItemInfo;", "Lcom/avito/android/calls_shared/AppCallScenario;", "component3", "()Lcom/avito/android/calls_shared/AppCallScenario;", "Lcom/avito/android/calls_shared/CallSide;", "component4", "()Lcom/avito/android/calls_shared/CallSide;", "callUuid", "item", "scenario", "callSide", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/calls_shared/AppCallScenario;Lcom/avito/android/calls_shared/CallSide;)Lcom/avito/android/in_app_calls/data/CallActivityRequest$Open;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/calls_shared/CallSide;", "getCallSide", "c", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallUuid", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/calls_shared/AppCallScenario;Lcom/avito/android/calls_shared/CallSide;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Open extends CallActivityRequest {
        public static final Parcelable.Creator<Open> CREATOR = new Creator();
        @NotNull
        public final String a;
        @Nullable
        public final ItemInfo b;
        @NotNull
        public final AppCallScenario c;
        @NotNull
        public final CallSide d;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Open> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Open createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Open(parcel.readString(), (ItemInfo) parcel.readParcelable(Open.class.getClassLoader()), (AppCallScenario) Enum.valueOf(AppCallScenario.class, parcel.readString()), (CallSide) Enum.valueOf(CallSide.class, parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Open[] newArray(int i) {
                return new Open[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Open(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull AppCallScenario appCallScenario, @NotNull CallSide callSide) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
            Intrinsics.checkNotNullParameter(callSide, "callSide");
            this.a = str;
            this.b = itemInfo;
            this.c = appCallScenario;
            this.d = callSide;
        }

        public static /* synthetic */ Open copy$default(Open open, String str, ItemInfo itemInfo, AppCallScenario appCallScenario, CallSide callSide, int i, Object obj) {
            if ((i & 1) != 0) {
                str = open.getCallUuid();
            }
            if ((i & 2) != 0) {
                itemInfo = open.getItem();
            }
            if ((i & 4) != 0) {
                appCallScenario = open.getScenario();
            }
            if ((i & 8) != 0) {
                callSide = open.getCallSide();
            }
            return open.copy(str, itemInfo, appCallScenario, callSide);
        }

        @NotNull
        public final String component1() {
            return getCallUuid();
        }

        @Nullable
        public final ItemInfo component2() {
            return getItem();
        }

        @NotNull
        public final AppCallScenario component3() {
            return getScenario();
        }

        @NotNull
        public final CallSide component4() {
            return getCallSide();
        }

        @NotNull
        public final Open copy(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull AppCallScenario appCallScenario, @NotNull CallSide callSide) {
            Intrinsics.checkNotNullParameter(str, "callUuid");
            Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
            Intrinsics.checkNotNullParameter(callSide, "callSide");
            return new Open(str, itemInfo, appCallScenario, callSide);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Open)) {
                return false;
            }
            Open open = (Open) obj;
            return Intrinsics.areEqual(getCallUuid(), open.getCallUuid()) && Intrinsics.areEqual(getItem(), open.getItem()) && Intrinsics.areEqual(getScenario(), open.getScenario()) && Intrinsics.areEqual(getCallSide(), open.getCallSide());
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @NotNull
        public CallSide getCallSide() {
            return this.d;
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @NotNull
        public String getCallUuid() {
            return this.a;
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @Nullable
        public ItemInfo getItem() {
            return this.b;
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @NotNull
        public AppCallScenario getScenario() {
            return this.c;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String callUuid = getCallUuid();
            int i = 0;
            int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
            ItemInfo item = getItem();
            int hashCode2 = (hashCode + (item != null ? item.hashCode() : 0)) * 31;
            AppCallScenario scenario = getScenario();
            int hashCode3 = (hashCode2 + (scenario != null ? scenario.hashCode() : 0)) * 31;
            CallSide callSide = getCallSide();
            if (callSide != null) {
                i = callSide.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Open(callUuid=");
            L.append(getCallUuid());
            L.append(", item=");
            L.append(getItem());
            L.append(", scenario=");
            L.append(getScenario());
            L.append(", callSide=");
            L.append(getCallSide());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c.name());
            parcel.writeString(this.d.name());
        }
    }

    public CallActivityRequest() {
    }

    @NotNull
    public abstract CallSide getCallSide();

    @NotNull
    public abstract String getCallUuid();

    @Nullable
    public abstract ItemInfo getItem();

    @NotNull
    public abstract AppCallScenario getScenario();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "Lcom/avito/android/calls_shared/CallSide;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/CallSide;", "getCallSide", "()Lcom/avito/android/calls_shared/CallSide;", "callSide", "<init>", "()V", "ByPreviousCall", "NewCall", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial$NewCall;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial$ByPreviousCall;", "core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Dial extends CallActivityRequest {
        @NotNull
        public final CallSide a = CallSide.OUTGOING;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b.\u0010/J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\bR \u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0005R\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010\u0005R\u001c\u0010\u0010\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\f¨\u00060"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial$ByPreviousCall;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "", "Lcom/avito/android/calls_shared/CallId;", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/ItemInfo;", "component2", "()Lcom/avito/android/calls_shared/ItemInfo;", "component3", "Lcom/avito/android/calls_shared/AppCallScenario;", "component4", "()Lcom/avito/android/calls_shared/AppCallScenario;", "callUuid", "item", "prevCallUuid", "scenario", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;)Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial$ByPreviousCall;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCallUuid", "d", "getPrevCallUuid", "e", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class ByPreviousCall extends Dial {
            public static final Parcelable.Creator<ByPreviousCall> CREATOR = new Creator();
            @NotNull
            public final String b;
            @Nullable
            public final ItemInfo c;
            @NotNull
            public final String d;
            @NotNull
            public final AppCallScenario e;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ByPreviousCall> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ByPreviousCall createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new ByPreviousCall(parcel.readString(), (ItemInfo) parcel.readParcelable(ByPreviousCall.class.getClassLoader()), parcel.readString(), (AppCallScenario) Enum.valueOf(AppCallScenario.class, parcel.readString()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ByPreviousCall[] newArray(int i) {
                    return new ByPreviousCall[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ByPreviousCall(String str, ItemInfo itemInfo, String str2, AppCallScenario appCallScenario, int i, j jVar) {
                this(str, (i & 2) != 0 ? null : itemInfo, str2, appCallScenario);
            }

            public static /* synthetic */ ByPreviousCall copy$default(ByPreviousCall byPreviousCall, String str, ItemInfo itemInfo, String str2, AppCallScenario appCallScenario, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = byPreviousCall.getCallUuid();
                }
                if ((i & 2) != 0) {
                    itemInfo = byPreviousCall.getItem();
                }
                if ((i & 4) != 0) {
                    str2 = byPreviousCall.d;
                }
                if ((i & 8) != 0) {
                    appCallScenario = byPreviousCall.getScenario();
                }
                return byPreviousCall.copy(str, itemInfo, str2, appCallScenario);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @Nullable
            public final ItemInfo component2() {
                return getItem();
            }

            @NotNull
            public final String component3() {
                return this.d;
            }

            @NotNull
            public final AppCallScenario component4() {
                return getScenario();
            }

            @NotNull
            public final ByPreviousCall copy(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull String str2, @NotNull AppCallScenario appCallScenario) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(str2, "prevCallUuid");
                Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
                return new ByPreviousCall(str, itemInfo, str2, appCallScenario);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ByPreviousCall)) {
                    return false;
                }
                ByPreviousCall byPreviousCall = (ByPreviousCall) obj;
                return Intrinsics.areEqual(getCallUuid(), byPreviousCall.getCallUuid()) && Intrinsics.areEqual(getItem(), byPreviousCall.getItem()) && Intrinsics.areEqual(this.d, byPreviousCall.d) && Intrinsics.areEqual(getScenario(), byPreviousCall.getScenario());
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public String getCallUuid() {
                return this.b;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @Nullable
            public ItemInfo getItem() {
                return this.c;
            }

            @NotNull
            public final String getPrevCallUuid() {
                return this.d;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public AppCallScenario getScenario() {
                return this.e;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                ItemInfo item = getItem();
                int hashCode2 = (hashCode + (item != null ? item.hashCode() : 0)) * 31;
                String str = this.d;
                int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                AppCallScenario scenario = getScenario();
                if (scenario != null) {
                    i = scenario.hashCode();
                }
                return hashCode3 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("ByPreviousCall(callUuid=");
                L.append(getCallUuid());
                L.append(", item=");
                L.append(getItem());
                L.append(", prevCallUuid=");
                L.append(this.d);
                L.append(", scenario=");
                L.append(getScenario());
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.b);
                parcel.writeParcelable(this.c, i);
                parcel.writeString(this.d);
                parcel.writeString(this.e.name());
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ByPreviousCall(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull String str2, @NotNull AppCallScenario appCallScenario) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(str2, "prevCallUuid");
                Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
                this.b = str;
                this.c = itemInfo;
                this.d = str2;
                this.e = appCallScenario;
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b5\u00106J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005JH\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0005R\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\bR\u001c\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u000bR \u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b4\u0010\u0005¨\u00067"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial$NewCall;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "", "Lcom/avito/android/calls_shared/CallId;", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/CallerInfo;", "component2", "()Lcom/avito/android/calls_shared/CallerInfo;", "Lcom/avito/android/calls_shared/ItemInfo;", "component3", "()Lcom/avito/android/calls_shared/ItemInfo;", "Lcom/avito/android/calls_shared/AppCallScenario;", "component4", "()Lcom/avito/android/calls_shared/AppCallScenario;", "component5", "callUuid", "recipient", "item", "scenario", "callAs", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/calls_shared/AppCallScenario;Ljava/lang/String;)Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial$NewCall;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Ljava/lang/String;", "getCallAs", "c", "Lcom/avito/android/calls_shared/CallerInfo;", "getRecipient", "e", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "d", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", AuthSource.BOOKING_ORDER, "getCallUuid", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/calls_shared/AppCallScenario;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class NewCall extends Dial {
            public static final Parcelable.Creator<NewCall> CREATOR = new Creator();
            @NotNull
            public final String b;
            @NotNull
            public final CallerInfo c;
            @NotNull
            public final ItemInfo d;
            @NotNull
            public final AppCallScenario e;
            @Nullable
            public final String f;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<NewCall> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NewCall createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new NewCall(parcel.readString(), (CallerInfo) parcel.readParcelable(NewCall.class.getClassLoader()), (ItemInfo) parcel.readParcelable(NewCall.class.getClassLoader()), (AppCallScenario) Enum.valueOf(AppCallScenario.class, parcel.readString()), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NewCall[] newArray(int i) {
                    return new NewCall[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ NewCall(String str, CallerInfo callerInfo, ItemInfo itemInfo, AppCallScenario appCallScenario, String str2, int i, j jVar) {
                this(str, callerInfo, itemInfo, appCallScenario, (i & 16) != 0 ? null : str2);
            }

            public static /* synthetic */ NewCall copy$default(NewCall newCall, String str, CallerInfo callerInfo, ItemInfo itemInfo, AppCallScenario appCallScenario, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = newCall.getCallUuid();
                }
                if ((i & 2) != 0) {
                    callerInfo = newCall.c;
                }
                if ((i & 4) != 0) {
                    itemInfo = newCall.getItem();
                }
                if ((i & 8) != 0) {
                    appCallScenario = newCall.getScenario();
                }
                if ((i & 16) != 0) {
                    str2 = newCall.f;
                }
                return newCall.copy(str, callerInfo, itemInfo, appCallScenario, str2);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @NotNull
            public final CallerInfo component2() {
                return this.c;
            }

            @NotNull
            public final ItemInfo component3() {
                return getItem();
            }

            @NotNull
            public final AppCallScenario component4() {
                return getScenario();
            }

            @Nullable
            public final String component5() {
                return this.f;
            }

            @NotNull
            public final NewCall copy(@NotNull String str, @NotNull CallerInfo callerInfo, @NotNull ItemInfo itemInfo, @NotNull AppCallScenario appCallScenario, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "recipient");
                Intrinsics.checkNotNullParameter(itemInfo, "item");
                Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
                return new NewCall(str, callerInfo, itemInfo, appCallScenario, str2);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NewCall)) {
                    return false;
                }
                NewCall newCall = (NewCall) obj;
                return Intrinsics.areEqual(getCallUuid(), newCall.getCallUuid()) && Intrinsics.areEqual(this.c, newCall.c) && Intrinsics.areEqual(getItem(), newCall.getItem()) && Intrinsics.areEqual(getScenario(), newCall.getScenario()) && Intrinsics.areEqual(this.f, newCall.f);
            }

            @Nullable
            public final String getCallAs() {
                return this.f;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public String getCallUuid() {
                return this.b;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public ItemInfo getItem() {
                return this.d;
            }

            @NotNull
            public final CallerInfo getRecipient() {
                return this.c;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public AppCallScenario getScenario() {
                return this.e;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                CallerInfo callerInfo = this.c;
                int hashCode2 = (hashCode + (callerInfo != null ? callerInfo.hashCode() : 0)) * 31;
                ItemInfo item = getItem();
                int hashCode3 = (hashCode2 + (item != null ? item.hashCode() : 0)) * 31;
                AppCallScenario scenario = getScenario();
                int hashCode4 = (hashCode3 + (scenario != null ? scenario.hashCode() : 0)) * 31;
                String str = this.f;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode4 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("NewCall(callUuid=");
                L.append(getCallUuid());
                L.append(", recipient=");
                L.append(this.c);
                L.append(", item=");
                L.append(getItem());
                L.append(", scenario=");
                L.append(getScenario());
                L.append(", callAs=");
                return a.t(L, this.f, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.b);
                parcel.writeParcelable(this.c, i);
                parcel.writeParcelable(this.d, i);
                parcel.writeString(this.e.name());
                parcel.writeString(this.f);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NewCall(@NotNull String str, @NotNull CallerInfo callerInfo, @NotNull ItemInfo itemInfo, @NotNull AppCallScenario appCallScenario, @Nullable String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "recipient");
                Intrinsics.checkNotNullParameter(itemInfo, "item");
                Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
                this.b = str;
                this.c = callerInfo;
                this.d = itemInfo;
                this.e = appCallScenario;
                this.f = str2;
            }
        }

        public Dial() {
            super(null);
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @NotNull
        public CallSide getCallSide() {
            return this.a;
        }

        public Dial(j jVar) {
            super(null);
        }
    }

    public CallActivityRequest(j jVar) {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "Lcom/avito/android/calls_shared/AppCallScenario;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "()Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "Lcom/avito/android/calls_shared/CallSide;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/CallSide;", "getCallSide", "()Lcom/avito/android/calls_shared/CallSide;", "callSide", "<init>", "()V", "PendingAction", "ReceiveCall", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive$ReceiveCall;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive$PendingAction;", "core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Receive extends CallActivityRequest {
        @NotNull
        public final AppCallScenario a = AppCallScenario.INCOMING_CALL;
        @NotNull
        public final CallSide b = CallSide.INCOMING;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\bR \u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0005¨\u0006,"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive$PendingAction;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive;", "", "Lcom/avito/android/calls_shared/CallId;", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/ItemInfo;", "component2", "()Lcom/avito/android/calls_shared/ItemInfo;", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "component3", "()Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "callUuid", "item", "pendingAction", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive$PendingAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "getPendingAction", "d", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", "c", "Ljava/lang/String;", "getCallUuid", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class PendingAction extends Receive {
            public static final Parcelable.Creator<PendingAction> CREATOR = new Creator();
            @NotNull
            public final String c;
            @Nullable
            public final ItemInfo d;
            @NotNull
            public final InAppCallPendingAction e;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<PendingAction> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final PendingAction createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new PendingAction(parcel.readString(), (ItemInfo) parcel.readParcelable(PendingAction.class.getClassLoader()), (InAppCallPendingAction) Enum.valueOf(InAppCallPendingAction.class, parcel.readString()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final PendingAction[] newArray(int i) {
                    return new PendingAction[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PendingAction(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull InAppCallPendingAction inAppCallPendingAction) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(inAppCallPendingAction, "pendingAction");
                this.c = str;
                this.d = itemInfo;
                this.e = inAppCallPendingAction;
            }

            public static /* synthetic */ PendingAction copy$default(PendingAction pendingAction, String str, ItemInfo itemInfo, InAppCallPendingAction inAppCallPendingAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = pendingAction.getCallUuid();
                }
                if ((i & 2) != 0) {
                    itemInfo = pendingAction.getItem();
                }
                if ((i & 4) != 0) {
                    inAppCallPendingAction = pendingAction.e;
                }
                return pendingAction.copy(str, itemInfo, inAppCallPendingAction);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @Nullable
            public final ItemInfo component2() {
                return getItem();
            }

            @NotNull
            public final InAppCallPendingAction component3() {
                return this.e;
            }

            @NotNull
            public final PendingAction copy(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull InAppCallPendingAction inAppCallPendingAction) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(inAppCallPendingAction, "pendingAction");
                return new PendingAction(str, itemInfo, inAppCallPendingAction);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PendingAction)) {
                    return false;
                }
                PendingAction pendingAction = (PendingAction) obj;
                return Intrinsics.areEqual(getCallUuid(), pendingAction.getCallUuid()) && Intrinsics.areEqual(getItem(), pendingAction.getItem()) && Intrinsics.areEqual(this.e, pendingAction.e);
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public String getCallUuid() {
                return this.c;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @Nullable
            public ItemInfo getItem() {
                return this.d;
            }

            @NotNull
            public final InAppCallPendingAction getPendingAction() {
                return this.e;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                ItemInfo item = getItem();
                int hashCode2 = (hashCode + (item != null ? item.hashCode() : 0)) * 31;
                InAppCallPendingAction inAppCallPendingAction = this.e;
                if (inAppCallPendingAction != null) {
                    i = inAppCallPendingAction.hashCode();
                }
                return hashCode2 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("PendingAction(callUuid=");
                L.append(getCallUuid());
                L.append(", item=");
                L.append(getItem());
                L.append(", pendingAction=");
                L.append(this.e);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.c);
                parcel.writeParcelable(this.d, i);
                parcel.writeString(this.e.name());
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b1\u00102J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\bR \u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0005R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u000e¨\u00063"}, d2 = {"Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive$ReceiveCall;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive;", "", "Lcom/avito/android/calls_shared/CallId;", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/ItemInfo;", "component2", "()Lcom/avito/android/calls_shared/ItemInfo;", "Lcom/avito/android/calls_shared/CallerInfo;", "component3", "()Lcom/avito/android/calls_shared/CallerInfo;", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "component4", "()Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "callUuid", "item", "caller", "pendingAction", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)Lcom/avito/android/in_app_calls/data/CallActivityRequest$Receive$ReceiveCall;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/avito/android/calls_shared/CallerInfo;", "getCaller", "d", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", "c", "Ljava/lang/String;", "getCallUuid", "f", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "getPendingAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/ItemInfo;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)V", "core_release"}, k = 1, mv = {1, 4, 2})
        public static final class ReceiveCall extends Receive {
            public static final Parcelable.Creator<ReceiveCall> CREATOR = new Creator();
            @NotNull
            public final String c;
            @Nullable
            public final ItemInfo d;
            @NotNull
            public final CallerInfo e;
            @Nullable
            public final InAppCallPendingAction f;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ReceiveCall> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ReceiveCall createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new ReceiveCall(parcel.readString(), (ItemInfo) parcel.readParcelable(ReceiveCall.class.getClassLoader()), (CallerInfo) parcel.readParcelable(ReceiveCall.class.getClassLoader()), parcel.readInt() != 0 ? (InAppCallPendingAction) Enum.valueOf(InAppCallPendingAction.class, parcel.readString()) : null);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ReceiveCall[] newArray(int i) {
                    return new ReceiveCall[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ReceiveCall(String str, ItemInfo itemInfo, CallerInfo callerInfo, InAppCallPendingAction inAppCallPendingAction, int i, j jVar) {
                this(str, (i & 2) != 0 ? null : itemInfo, callerInfo, (i & 8) != 0 ? null : inAppCallPendingAction);
            }

            public static /* synthetic */ ReceiveCall copy$default(ReceiveCall receiveCall, String str, ItemInfo itemInfo, CallerInfo callerInfo, InAppCallPendingAction inAppCallPendingAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = receiveCall.getCallUuid();
                }
                if ((i & 2) != 0) {
                    itemInfo = receiveCall.getItem();
                }
                if ((i & 4) != 0) {
                    callerInfo = receiveCall.e;
                }
                if ((i & 8) != 0) {
                    inAppCallPendingAction = receiveCall.f;
                }
                return receiveCall.copy(str, itemInfo, callerInfo, inAppCallPendingAction);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @Nullable
            public final ItemInfo component2() {
                return getItem();
            }

            @NotNull
            public final CallerInfo component3() {
                return this.e;
            }

            @Nullable
            public final InAppCallPendingAction component4() {
                return this.f;
            }

            @NotNull
            public final ReceiveCall copy(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull CallerInfo callerInfo, @Nullable InAppCallPendingAction inAppCallPendingAction) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "caller");
                return new ReceiveCall(str, itemInfo, callerInfo, inAppCallPendingAction);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ReceiveCall)) {
                    return false;
                }
                ReceiveCall receiveCall = (ReceiveCall) obj;
                return Intrinsics.areEqual(getCallUuid(), receiveCall.getCallUuid()) && Intrinsics.areEqual(getItem(), receiveCall.getItem()) && Intrinsics.areEqual(this.e, receiveCall.e) && Intrinsics.areEqual(this.f, receiveCall.f);
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @NotNull
            public String getCallUuid() {
                return this.c;
            }

            @NotNull
            public final CallerInfo getCaller() {
                return this.e;
            }

            @Override // com.avito.android.in_app_calls.data.CallActivityRequest
            @Nullable
            public ItemInfo getItem() {
                return this.d;
            }

            @Nullable
            public final InAppCallPendingAction getPendingAction() {
                return this.f;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                ItemInfo item = getItem();
                int hashCode2 = (hashCode + (item != null ? item.hashCode() : 0)) * 31;
                CallerInfo callerInfo = this.e;
                int hashCode3 = (hashCode2 + (callerInfo != null ? callerInfo.hashCode() : 0)) * 31;
                InAppCallPendingAction inAppCallPendingAction = this.f;
                if (inAppCallPendingAction != null) {
                    i = inAppCallPendingAction.hashCode();
                }
                return hashCode3 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("ReceiveCall(callUuid=");
                L.append(getCallUuid());
                L.append(", item=");
                L.append(getItem());
                L.append(", caller=");
                L.append(this.e);
                L.append(", pendingAction=");
                L.append(this.f);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.c);
                parcel.writeParcelable(this.d, i);
                parcel.writeParcelable(this.e, i);
                InAppCallPendingAction inAppCallPendingAction = this.f;
                if (inAppCallPendingAction != null) {
                    parcel.writeInt(1);
                    parcel.writeString(inAppCallPendingAction.name());
                    return;
                }
                parcel.writeInt(0);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ReceiveCall(@NotNull String str, @Nullable ItemInfo itemInfo, @NotNull CallerInfo callerInfo, @Nullable InAppCallPendingAction inAppCallPendingAction) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "caller");
                this.c = str;
                this.d = itemInfo;
                this.e = callerInfo;
                this.f = inAppCallPendingAction;
            }
        }

        public Receive() {
            super(null);
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @NotNull
        public CallSide getCallSide() {
            return this.b;
        }

        @Override // com.avito.android.in_app_calls.data.CallActivityRequest
        @NotNull
        public AppCallScenario getScenario() {
            return this.a;
        }

        public Receive(j jVar) {
            super(null);
        }
    }
}
