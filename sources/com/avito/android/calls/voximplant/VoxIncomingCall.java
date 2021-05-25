package com.avito.android.calls.voximplant;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.calls.IncomingCall;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.IEndpoint;
import com.voximplant.sdk.call.RejectMode;
import com.voximplant.sdk.call.VideoFlags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\r¨\u0006\""}, d2 = {"Lcom/avito/android/calls/voximplant/VoxIncomingCall;", "Lcom/avito/android/calls/voximplant/VoxCall;", "Lcom/avito/android/calls/IncomingCall;", "", "decline", "()V", "busy", "", "enableVideo", "answer", "(Z)V", "", "toString", "()Ljava/lang/String;", "getCallerId", "callerId", "Lcom/voximplant/sdk/call/CallSettings;", "j", "Lcom/voximplant/sdk/call/CallSettings;", "callSettings", "h", "Ljava/lang/String;", "getItemId", "itemId", "Lcom/voximplant/sdk/call/ICall;", "i", "Lcom/voximplant/sdk/call/ICall;", "call", g.a, "getUuid", "uuid", "supportVideo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/voximplant/sdk/call/ICall;Lcom/voximplant/sdk/call/CallSettings;Z)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxIncomingCall extends VoxCall implements IncomingCall {
    @NotNull
    public final String g;
    @Nullable
    public final String h;
    public final ICall i;
    public final CallSettings j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoxIncomingCall(@NotNull String str, @Nullable String str2, @NotNull ICall iCall, @NotNull CallSettings callSettings, boolean z) {
        super(z, iCall);
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(iCall, "call");
        Intrinsics.checkNotNullParameter(callSettings, "callSettings");
        this.g = str;
        this.h = str2;
        this.i = iCall;
        this.j = callSettings;
    }

    @Override // com.avito.android.calls.IncomingCall
    public void answer(boolean z) {
        try {
            VideoFlags videoFlags = new VideoFlags(z, z);
            CallSettings callSettings = this.j;
            callSettings.videoFlags = videoFlags;
            this.i.answer(callSettings);
        } catch (CallException e) {
            handleOrThrow(e);
        }
    }

    @Override // com.avito.android.calls.IncomingCall
    public void busy() {
        try {
            this.i.reject(RejectMode.BUSY, null);
        } catch (CallException e) {
            handleOrThrow(e);
        }
    }

    @Override // com.avito.android.calls.IncomingCall
    public void decline() {
        try {
            this.i.reject(RejectMode.DECLINE, null);
        } catch (CallException e) {
            handleOrThrow(e);
        }
    }

    @Override // com.avito.android.calls.IncomingCall
    @NotNull
    public String getCallerId() {
        List<IEndpoint> endpoints = this.i.getEndpoints();
        Intrinsics.checkNotNullExpressionValue(endpoints, "call.endpoints");
        IEndpoint iEndpoint = (IEndpoint) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) endpoints);
        String userName = iEndpoint != null ? iEndpoint.getUserName() : null;
        return userName != null ? userName : "";
    }

    @Override // com.avito.android.calls.Call
    @Nullable
    public String getItemId() {
        return this.h;
    }

    @Override // com.avito.android.calls.Call
    @NotNull
    public String getUuid() {
        return this.g;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VoxIncomingCall(id=");
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
