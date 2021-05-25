package net.gotev.uploadservice.protocols.multipart;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.HttpUploadTask;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.network.BodyWriter;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\t*\u00020\u00158B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0018\u001a\u00020\t*\u00020\u001d8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadTask;", "Lnet/gotev/uploadservice/HttpUploadTask;", "", "performInitialization", "()V", "Lnet/gotev/uploadservice/network/BodyWriter;", "bodyWriter", "onWriteRequestBody", "(Lnet/gotev/uploadservice/network/BodyWriter;)V", "", AuthSource.OPEN_CHANNEL_LIST, "[B", "boundaryBytes", "", "l", "Ljava/lang/String;", "boundary", "o", "newLineBytes", "n", "trailerBytes", "Lnet/gotev/uploadservice/data/NameValue;", "c", "(Lnet/gotev/uploadservice/data/NameValue;)[B", "multipartHeader", "", "getBodyLength", "()J", "bodyLength", "Lnet/gotev/uploadservice/data/UploadFile;", "d", "(Lnet/gotev/uploadservice/data/UploadFile;)[B", "<init>", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class MultipartUploadTask extends HttpUploadTask {
    public static final Companion Companion = new Companion(null);
    public final String l;
    public final byte[] m;
    public final byte[] n;
    public final byte[] o = StringExtensionsKt.getUtf8Bytes("\r\n");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadTask$Companion;", "", "", "BOUNDARY_SIGNATURE", "Ljava/lang/String;", "NEW_LINE", "TWO_HYPHENS", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public MultipartUploadTask() {
        StringBuilder L = a.L("-------UploadService4.5.2-");
        L.append(System.nanoTime());
        String sb = L.toString();
        this.l = sb;
        this.m = StringExtensionsKt.getAsciiByes("--" + sb + "\r\n");
        this.n = StringExtensionsKt.getAsciiByes("--" + sb + "--\r\n");
    }

    public final byte[] c(NameValue nameValue) {
        byte[] bArr = this.m;
        StringBuilder Q = a.Q("Content-Disposition: form-data; ", "name=\"");
        Q.append(nameValue.getName());
        Q.append("\"\r\n\r\n");
        Q.append(nameValue.getValue());
        Q.append("\r\n");
        return ArraysKt___ArraysJvmKt.plus(bArr, StringExtensionsKt.getUtf8Bytes(Q.toString()));
    }

    public final byte[] d(UploadFile uploadFile) {
        byte[] bArr = this.m;
        StringBuilder Q = a.Q("Content-Disposition: form-data; ", "name=\"");
        Q.append(UploadFileExtensionsKt.getParameterName(uploadFile));
        Q.append("\"; ");
        Q.append("filename=\"");
        Q.append(UploadFileExtensionsKt.getRemoteFileName(uploadFile));
        Q.append("\"\r\n");
        Q.append("Content-Type: ");
        Q.append(UploadFileExtensionsKt.getContentType(uploadFile));
        Q.append("\r\n\r\n");
        return ArraysKt___ArraysJvmKt.plus(bArr, StringExtensionsKt.getUtf8Bytes(Q.toString()));
    }

    @Override // net.gotev.uploadservice.HttpUploadTask
    public long getBodyLength() {
        ArrayList<NameValue> requestParameters = getHttpParams().getRequestParameters();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(requestParameters, 10));
        Iterator<T> it = requestParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf((long) c(it.next()).length));
        }
        long sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList);
        ArrayList<UploadFile> files = getParams().getFiles();
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(files, 10));
        for (T t : files) {
            arrayList2.add(Long.valueOf(t.getHandler().size(getContext()) + ((long) d(t).length) + ((long) this.o.length)));
        }
        return sumOfLong + CollectionsKt___CollectionsKt.sumOfLong(arrayList2) + ((long) this.n.length);
    }

    @Override // net.gotev.uploadservice.network.HttpRequest.RequestBodyDelegate
    public void onWriteRequestBody(@NotNull BodyWriter bodyWriter) {
        Intrinsics.checkNotNullParameter(bodyWriter, "bodyWriter");
        resetUploadedBytes();
        setAllFilesHaveBeenSuccessfullyUploaded(false);
        Iterator<T> it = getHttpParams().getRequestParameters().iterator();
        while (it.hasNext()) {
            bodyWriter.write(c(it.next()));
        }
        Iterator<UploadFile> it2 = getParams().getFiles().iterator();
        while (it2.hasNext()) {
            UploadFile next = it2.next();
            if (!getShouldContinue()) {
                break;
            }
            Intrinsics.checkNotNullExpressionValue(next, "file");
            bodyWriter.write(d(next));
            bodyWriter.writeStream(next.getHandler().stream(getContext()));
            bodyWriter.write(this.o);
        }
        bodyWriter.write(this.n);
    }

    @Override // net.gotev.uploadservice.UploadTask
    public void performInitialization() {
        ArrayList<NameValue> requestHeaders = getHttpParams().getRequestHeaders();
        StringBuilder L = a.L("multipart/form-data; boundary=");
        L.append(this.l);
        CollectionsExtensionsKt.addHeader(requestHeaders, "Content-Type", L.toString());
        CollectionsExtensionsKt.addHeader(requestHeaders, HttpHeaders.CONNECTION, getParams().getFiles().size() <= 1 ? "close" : "Keep-Alive");
    }
}
