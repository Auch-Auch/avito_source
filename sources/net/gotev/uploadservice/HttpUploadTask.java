package net.gotev.uploadservice;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.BodyWriter;
import net.gotev.uploadservice.network.HttpRequest;
import net.gotev.uploadservice.network.HttpStack;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108D@\u0004X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lnet/gotev/uploadservice/HttpUploadTask;", "Lnet/gotev/uploadservice/UploadTask;", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "Lnet/gotev/uploadservice/network/HttpStack;", "httpStack", "", "upload", "(Lnet/gotev/uploadservice/network/HttpStack;)V", "", "shouldContinueWriting", "()Z", "", "bytesWritten", "onBytesWritten", "(I)V", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "k", "Lkotlin/Lazy;", "getHttpParams", "()Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "httpParams", "", "getBodyLength", "()J", "bodyLength", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public abstract class HttpUploadTask extends UploadTask implements HttpRequest.RequestBodyDelegate, BodyWriter.OnStreamWriteListener {
    @NotNull
    public final Lazy k = t6.c.lazy(new a(this));

    public static final class a extends Lambda implements Function0<HttpUploadTaskParameters> {
        public final /* synthetic */ HttpUploadTask a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HttpUploadTask httpUploadTask) {
            super(0);
            this.a = httpUploadTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public HttpUploadTaskParameters invoke() {
            return HttpUploadTaskParameters.Companion.createFromPersistableData(this.a.getParams().getAdditionalParameters());
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "Starting upload task";
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ ServerResponse a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ServerResponse serverResponse) {
            super(0);
            this.a = serverResponse;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("Server response: code ");
            L.append(this.a.getCode());
            L.append(", body ");
            L.append(this.a.getBodyString());
            return L.toString();
        }
    }

    public abstract long getBodyLength();

    @NotNull
    public final HttpUploadTaskParameters getHttpParams() {
        return (HttpUploadTaskParameters) this.k.getValue();
    }

    @Override // net.gotev.uploadservice.network.BodyWriter.OnStreamWriteListener
    public final void onBytesWritten(int i) {
        onProgress((long) i);
    }

    @Override // net.gotev.uploadservice.network.BodyWriter.OnStreamWriteListener
    public boolean shouldContinueWriting() {
        return getShouldContinue();
    }

    @Override // net.gotev.uploadservice.UploadTask
    @SuppressLint({"NewApi"})
    public void upload(@NotNull HttpStack httpStack) throws Exception {
        Intrinsics.checkNotNullParameter(httpStack, "httpStack");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, getParams().getId(), b.a);
        setAllFilesHaveBeenSuccessfullyUploaded(false);
        setTotalBytes(getBodyLength());
        HttpRequest newRequest = httpStack.newRequest(getParams().getId(), getHttpParams().getMethod(), getParams().getServerUrl());
        ArrayList<NameValue> requestHeaders = getHttpParams().getRequestHeaders();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(requestHeaders, 10));
        Iterator<T> it = requestHeaders.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().validateAsHeader());
        }
        ServerResponse response = newRequest.setHeaders(arrayList).setTotalBodyBytes(getTotalBytes(), getHttpParams().getUsesFixedLengthStreamingMode()).getResponse(this, this);
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName2, getParams().getId(), new c(response));
        if (getShouldContinue()) {
            if (response.isSuccessful()) {
                UploadTask.setAllFilesHaveBeenSuccessfullyUploaded$default(this, false, 1, null);
            }
            onResponseReceived(response);
        }
    }
}
