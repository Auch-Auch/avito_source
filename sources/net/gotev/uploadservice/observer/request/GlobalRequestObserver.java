package net.gotev.uploadservice.observer.request;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadInfo;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B>\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012#\b\u0002\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lnet/gotev/uploadservice/observer/request/GlobalRequestObserver;", "Lnet/gotev/uploadservice/observer/request/BaseRequestObserver;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "delegate", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/data/UploadInfo;", "Lkotlin/ParameterName;", "name", "uploadInfo", "", "shouldAcceptEventsFrom", "<init>", "(Landroid/app/Application;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;Lkotlin/jvm/functions/Function1;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class GlobalRequestObserver extends BaseRequestObserver {

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

    @JvmOverloads
    public GlobalRequestObserver(@NotNull Application application, @NotNull RequestObserverDelegate requestObserverDelegate) {
        this(application, requestObserverDelegate, null, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalRequestObserver(Application application, RequestObserverDelegate requestObserverDelegate, Function1 function1, int i, j jVar) {
        this(application, requestObserverDelegate, (i & 4) != 0 ? a.a : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlobalRequestObserver(@NotNull Application application, @NotNull RequestObserverDelegate requestObserverDelegate, @NotNull Function1<? super UploadInfo, Boolean> function1) {
        super(application, requestObserverDelegate, function1);
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(requestObserverDelegate, "delegate");
        Intrinsics.checkNotNullParameter(function1, "shouldAcceptEventsFrom");
        register();
    }
}
