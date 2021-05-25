package net.gotev.uploadservice.observer.request;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.UploadRequest;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.data.UploadInfo;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BF\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lnet/gotev/uploadservice/observer/request/RequestObserver;", "Lnet/gotev/uploadservice/observer/request/BaseRequestObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "register", "()V", "unregister", "Lnet/gotev/uploadservice/UploadRequest;", "request", "subscribe", "(Lnet/gotev/uploadservice/UploadRequest;)V", "", "d", "Ljava/lang/String;", "subscribedUploadID", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "delegate", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/data/UploadInfo;", "Lkotlin/ParameterName;", "name", "uploadInfo", "", "shouldAcceptEventsFrom", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;Lkotlin/jvm/functions/Function1;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class RequestObserver extends BaseRequestObserver implements LifecycleObserver {
    public String d;

    public static final class a extends Lambda implements Function1<UploadInfo, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(UploadInfo uploadInfo) {
            Intrinsics.checkNotNullParameter(uploadInfo, "it");
            return Boolean.TRUE;
        }
    }

    public static final class b extends Lambda implements Function1<UploadInfo, Boolean> {
        public final /* synthetic */ RequestObserver a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RequestObserver requestObserver) {
            super(1);
            this.a = requestObserver;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(UploadInfo uploadInfo) {
            UploadInfo uploadInfo2 = uploadInfo;
            Intrinsics.checkNotNullParameter(uploadInfo2, "uploadInfo");
            String str = this.a.d;
            return Boolean.valueOf(str != null ? Intrinsics.areEqual(str, uploadInfo2.getUploadId()) : false);
        }
    }

    @JvmOverloads
    public RequestObserver(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull RequestObserverDelegate requestObserverDelegate) {
        this(context, lifecycleOwner, requestObserverDelegate, null, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestObserver(Context context, LifecycleOwner lifecycleOwner, RequestObserverDelegate requestObserverDelegate, Function1 function1, int i, j jVar) {
        this(context, lifecycleOwner, requestObserverDelegate, (i & 8) != 0 ? a.a : function1);
    }

    @Override // net.gotev.uploadservice.observer.request.BaseRequestObserver
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void register() {
        super.register();
        String str = this.d;
        if (str != null && !UploadService.Companion.getTaskList().contains(str)) {
            getDelegate$uploadservice_release().onCompletedWhileNotObserving();
        }
    }

    public final void subscribe(@NotNull UploadRequest<?> uploadRequest) {
        Intrinsics.checkNotNullParameter(uploadRequest, "request");
        this.d = uploadRequest.startUpload();
        setShouldAcceptEventsFrom$uploadservice_release(new b(this));
    }

    @Override // net.gotev.uploadservice.observer.request.BaseRequestObserver
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void unregister() {
        super.unregister();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RequestObserver(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull RequestObserverDelegate requestObserverDelegate, @NotNull Function1<? super UploadInfo, Boolean> function1) {
        super(context, requestObserverDelegate, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(requestObserverDelegate, "delegate");
        Intrinsics.checkNotNullParameter(function1, "shouldAcceptEventsFrom");
        lifecycleOwner.getLifecycle().addObserver(this);
    }
}
