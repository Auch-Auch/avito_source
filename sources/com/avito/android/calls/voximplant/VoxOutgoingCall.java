package com.avito.android.calls.voximplant;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.calls.OutgoingCall;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.IEndpoint;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxOutgoingCall;", "Lcom/avito/android/calls/voximplant/VoxCall;", "Lcom/avito/android/calls/OutgoingCall;", "", Tracker.Events.CREATIVE_START, "()V", "", "toString", "()Ljava/lang/String;", "h", "Ljava/lang/String;", "getItemId", "itemId", g.a, "getUuid", "uuid", "Lcom/voximplant/sdk/call/ICall;", "i", "Lcom/voximplant/sdk/call/ICall;", "call", "", "j", "Z", "getSupportVideo", "()Z", "supportVideo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/voximplant/sdk/call/ICall;Z)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxOutgoingCall extends VoxCall implements OutgoingCall {
    @NotNull
    public final String g;
    @Nullable
    public final String h;
    public final ICall i;
    public final boolean j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoxOutgoingCall(@NotNull String str, @Nullable String str2, @NotNull ICall iCall, boolean z) {
        super(z, iCall);
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(iCall, "call");
        this.g = str;
        this.h = str2;
        this.i = iCall;
        this.j = z;
    }

    @Override // com.avito.android.calls.Call
    @Nullable
    public String getItemId() {
        return this.h;
    }

    @Override // com.avito.android.calls.voximplant.VoxCall, com.avito.android.calls.Call
    public boolean getSupportVideo() {
        return this.j;
    }

    @Override // com.avito.android.calls.Call
    @NotNull
    public String getUuid() {
        return this.g;
    }

    @Override // com.avito.android.calls.OutgoingCall
    public void start() {
        try {
            this.i.start();
        } catch (CallException e) {
            handleOrThrow(e);
        }
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VoxOutgoingCall(id=");
        L.append(this.i.getCallId());
        L.append(", endpoints=");
        List<IEndpoint> endpoints = this.i.getEndpoints();
        Intrinsics.checkNotNullExpressionValue(endpoints, "call.endpoints");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(endpoints, 10));
        for (T t : endpoints) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(t.getEndpointId());
        }
        L.append(arrayList);
        return L.toString();
    }
}
