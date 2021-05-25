package androidx.core.util;

import android.util.AtomicFile;
import androidx.annotation.RequiresApi;
import com.vk.sdk.api.VKApiConst;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a7\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/util/AtomicFile;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", VKApiConst.OUT, "", "block", "tryWrite", "(Landroid/util/AtomicFile;Lkotlin/jvm/functions/Function1;)V", "", "array", "writeBytes", "(Landroid/util/AtomicFile;[B)V", "", "text", "Ljava/nio/charset/Charset;", "charset", "writeText", "(Landroid/util/AtomicFile;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "readBytes", "(Landroid/util/AtomicFile;)[B", "readText", "(Landroid/util/AtomicFile;Ljava/nio/charset/Charset;)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull AtomicFile atomicFile) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$readBytes");
        byte[] readFully = atomicFile.readFully();
        Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull AtomicFile atomicFile, @NotNull Charset charset) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$readText");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull AtomicFile atomicFile, @NotNull Function1<? super FileOutputStream, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$tryWrite");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(startWrite, "stream");
            function1.invoke(startWrite);
            InlineMarker.finallyStart(1);
            atomicFile.finishWrite(startWrite);
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            atomicFile.failWrite(startWrite);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull AtomicFile atomicFile, @NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$writeBytes");
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(startWrite, "stream");
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull AtomicFile atomicFile, @NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$writeText");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }
}
