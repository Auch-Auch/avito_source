package a2.a.a.o1.d.a0.f;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadConfig;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadServiceStarterImpl;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.protocols.multipart.MultipartUploadRequest;
import ru.avito.messenger.internal.OkHttpMessengerImageUploaderKt;
public final class l implements Action {
    public final /* synthetic */ UploadServiceStarterImpl.a a;
    public final /* synthetic */ MessengerFileUploadConfig b;

    public static final class a extends Lambda implements Function2<Context, String, UploadNotificationConfig> {
        public final /* synthetic */ l a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l lVar) {
            super(2);
            this.a = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public UploadNotificationConfig invoke(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
            UploadServiceStarterImpl.a aVar = this.a.a;
            return UploadServiceStarterImpl.access$getNotificationConfig(aVar.a, aVar.d.getName());
        }
    }

    public l(UploadServiceStarterImpl.a aVar, MessengerFileUploadConfig messengerFileUploadConfig) {
        this.a = aVar;
        this.b = messengerFileUploadConfig;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        String httpUrl = this.b.getFileUploadEndpoint().newBuilder().addPathSegment("upload").addPathSegment("").addQueryParameter("id", this.a.b).build().toString();
        String path = this.a.c.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "file.path");
        ((MultipartUploadRequest) ((MultipartUploadRequest) ((MultipartUploadRequest) ((MultipartUploadRequest) ((MultipartUploadRequest) new MultipartUploadRequest(this.a.a.a, httpUrl).setMethod(ShareTarget.METHOD_POST)).addHeader(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER, this.b.getSessionId())).addHeader("Origin", this.b.getOrigin())).addFileToUpload(path, "file", this.a.d.getName(), this.a.d.getMimeType()).setNotificationConfig((Function2<? super Context, ? super String, UploadNotificationConfig>) new a(this))).setUploadID(this.a.e.toString())).startUpload();
    }
}
