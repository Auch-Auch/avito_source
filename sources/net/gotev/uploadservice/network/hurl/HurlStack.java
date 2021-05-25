package net.gotev.uploadservice.network.hurl;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.network.HttpRequest;
import net.gotev.uploadservice.network.HttpStack;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lnet/gotev/uploadservice/network/hurl/HurlStack;", "Lnet/gotev/uploadservice/network/HttpStack;", "", "uploadId", "method", "url", "Lnet/gotev/uploadservice/network/HttpRequest;", "newRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/network/HttpRequest;", "", "e", "I", "readTimeoutMillis", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "userAgent", "", "c", "Z", "useCaches", "d", "connectTimeoutMillis", AuthSource.BOOKING_ORDER, "followRedirects", "<init>", "(Ljava/lang/String;ZZII)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class HurlStack implements HttpStack {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;

    @JvmOverloads
    public HurlStack() {
        this(null, false, false, 0, 0, 31, null);
    }

    @JvmOverloads
    public HurlStack(@NotNull String str) {
        this(str, false, false, 0, 0, 30, null);
    }

    @JvmOverloads
    public HurlStack(@NotNull String str, boolean z) {
        this(str, z, false, 0, 0, 28, null);
    }

    @JvmOverloads
    public HurlStack(@NotNull String str, boolean z, boolean z2) {
        this(str, z, z2, 0, 0, 24, null);
    }

    @JvmOverloads
    public HurlStack(@NotNull String str, boolean z, boolean z2, int i) {
        this(str, z, z2, i, 0, 16, null);
    }

    @JvmOverloads
    public HurlStack(@NotNull String str, boolean z, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "userAgent");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = i;
        this.e = i2;
    }

    @Override // net.gotev.uploadservice.network.HttpStack
    @NotNull
    public HttpRequest newRequest(@NotNull String str, @NotNull String str2, @NotNull String str3) throws IOException {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new HurlStackRequest(this.a, str, str2, str3, this.b, this.c, this.d, this.e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HurlStack(String str, boolean z, boolean z2, int i, int i2, int i3, j jVar) {
        this((i3 & 1) != 0 ? UploadServiceConfig.defaultUserAgent : str, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS : i, (i3 & 16) != 0 ? HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT : i2);
    }
}
