package net.gotev.uploadservice.observer.request;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.BroadcastData;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadStatus;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u001b\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0004\b!\u0010\"J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR=\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\u00020\u001b8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lnet/gotev/uploadservice/observer/request/BaseRequestObserver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "register", "()V", "unregister", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/data/UploadInfo;", "Lkotlin/ParameterName;", "name", "uploadInfo", "", "c", "Lkotlin/jvm/functions/Function1;", "getShouldAcceptEventsFrom$uploadservice_release", "()Lkotlin/jvm/functions/Function1;", "setShouldAcceptEventsFrom$uploadservice_release", "(Lkotlin/jvm/functions/Function1;)V", "shouldAcceptEventsFrom", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", AuthSource.BOOKING_ORDER, "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "getDelegate$uploadservice_release", "()Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "delegate", "<init>", "(Landroid/content/Context;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;Lkotlin/jvm/functions/Function1;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public class BaseRequestObserver extends BroadcastReceiver {
    public final Context a;
    @NotNull
    public final RequestObserverDelegate b;
    @NotNull
    public Function1<? super UploadInfo, Boolean> c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UploadStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[1] = 3;
            iArr[3] = 4;
        }
    }

    public BaseRequestObserver(@NotNull Context context, @NotNull RequestObserverDelegate requestObserverDelegate, @NotNull Function1<? super UploadInfo, Boolean> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestObserverDelegate, "delegate");
        Intrinsics.checkNotNullParameter(function1, "shouldAcceptEventsFrom");
        this.a = context;
        this.b = requestObserverDelegate;
        this.c = function1;
    }

    @NotNull
    public final RequestObserverDelegate getDelegate$uploadservice_release() {
        return this.b;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super net.gotev.uploadservice.data.UploadInfo, java.lang.Boolean>, kotlin.jvm.functions.Function1<net.gotev.uploadservice.data.UploadInfo, java.lang.Boolean> */
    @NotNull
    public final Function1<UploadInfo, Boolean> getShouldAcceptEventsFrom$uploadservice_release() {
        return this.c;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @Nullable Intent intent) {
        BroadcastData fromIntent;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null && !(!Intrinsics.areEqual(intent.getAction(), UploadServiceConfig.getBroadcastStatusAction())) && (fromIntent = BroadcastData.Companion.fromIntent(intent)) != null) {
            UploadInfo uploadInfo = fromIntent.getUploadInfo();
            if (this.c.invoke(uploadInfo).booleanValue()) {
                int ordinal = fromIntent.getStatus().ordinal();
                if (ordinal == 0) {
                    this.b.onProgress(context, uploadInfo);
                } else if (ordinal == 1) {
                    RequestObserverDelegate requestObserverDelegate = this.b;
                    ServerResponse serverResponse = fromIntent.getServerResponse();
                    Intrinsics.checkNotNull(serverResponse);
                    requestObserverDelegate.onSuccess(context, uploadInfo, serverResponse);
                } else if (ordinal == 2) {
                    RequestObserverDelegate requestObserverDelegate2 = this.b;
                    Throwable exception = fromIntent.getException();
                    Intrinsics.checkNotNull(exception);
                    requestObserverDelegate2.onError(context, uploadInfo, exception);
                } else if (ordinal == 3) {
                    this.b.onCompleted(context, uploadInfo);
                }
            }
        }
    }

    public void register() {
        this.a.registerReceiver(this, UploadServiceConfig.getBroadcastStatusIntentFilter());
    }

    public final void setShouldAcceptEventsFrom$uploadservice_release(@NotNull Function1<? super UploadInfo, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.c = function1;
    }

    public void unregister() {
        this.a.unregisterReceiver(this);
    }
}
