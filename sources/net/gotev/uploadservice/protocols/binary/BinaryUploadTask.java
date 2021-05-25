package net.gotev.uploadservice.protocols.binary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.HttpUploadTask;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import net.gotev.uploadservice.network.BodyWriter;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lnet/gotev/uploadservice/protocols/binary/BinaryUploadTask;", "Lnet/gotev/uploadservice/HttpUploadTask;", "", "performInitialization", "()V", "Lnet/gotev/uploadservice/network/BodyWriter;", "bodyWriter", "onWriteRequestBody", "(Lnet/gotev/uploadservice/network/BodyWriter;)V", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "l", "Lkotlin/Lazy;", "c", "()Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "file", "", "getBodyLength", "()J", "bodyLength", "<init>", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class BinaryUploadTask extends HttpUploadTask {
    public final Lazy l = c.lazy(new a(this));

    public static final class a extends Lambda implements Function0<SchemeHandler> {
        public final /* synthetic */ BinaryUploadTask a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BinaryUploadTask binaryUploadTask) {
            super(0);
            this.a = binaryUploadTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SchemeHandler invoke() {
            return ((UploadFile) CollectionsKt___CollectionsKt.first((List<? extends Object>) this.a.getParams().getFiles())).getHandler();
        }
    }

    public final SchemeHandler c() {
        return (SchemeHandler) this.l.getValue();
    }

    @Override // net.gotev.uploadservice.HttpUploadTask
    public long getBodyLength() {
        return c().size(getContext());
    }

    @Override // net.gotev.uploadservice.network.HttpRequest.RequestBodyDelegate
    public void onWriteRequestBody(@NotNull BodyWriter bodyWriter) {
        Intrinsics.checkNotNullParameter(bodyWriter, "bodyWriter");
        bodyWriter.writeStream(c().stream(getContext()));
    }

    @Override // net.gotev.uploadservice.UploadTask
    public void performInitialization() {
        ArrayList<NameValue> requestHeaders = getHttpParams().getRequestHeaders();
        boolean z = true;
        if (!(requestHeaders instanceof Collection) || !requestHeaders.isEmpty()) {
            Iterator<T> it = requestHeaders.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String name = it.next().getName();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, "content-type")) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            CollectionsExtensionsKt.addHeader(requestHeaders, "Content-Type", c().contentType(getContext()));
        }
    }
}
