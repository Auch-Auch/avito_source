package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import w6.a;
import w6.b;
import w6.c;
import w6.d;
import w6.e;
@Metadata(bv = {1, 0, 3}, d1 = {"w6/c"}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class Okio {
    @NotNull
    public static final Sink appendingSink(@NotNull File file) throws FileNotFoundException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(file, "$this$appendingSink");
        return sink(new FileOutputStream(file, true));
    }

    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new a();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "$this$buffer");
        return new RealBufferedSink(sink);
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError assertionError) {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.contains$default(message, "getsockname failed", false, 2, null) : false;
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file, boolean z) throws FileNotFoundException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(file, "$this$sink");
        return sink(new FileOutputStream(file, z));
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        Logger logger = c.a;
        if ((i & 1) != 0) {
            z = false;
        }
        return sink(file, z);
    }

    @NotNull
    public static final Source source(@NotNull File file) throws FileNotFoundException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(file, "$this$source");
        return source(new FileInputStream(file));
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "$this$buffer");
        return new RealBufferedSource(source);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream) {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(outputStream, "$this$sink");
        return new d(outputStream, new Timeout());
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream) {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(inputStream, "$this$source");
        return new b(inputStream, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull Socket socket) throws IOException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(socket, "$this$sink");
        e eVar = new e(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return eVar.sink(new d(outputStream, eVar));
    }

    @NotNull
    public static final Source source(@NotNull Socket socket) throws IOException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(socket, "$this$source");
        e eVar = new e(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return eVar.source(new b(inputStream, eVar));
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(path, "$this$sink");
        Intrinsics.checkNotNullParameter(openOptionArr, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "Files.newOutputStream(this, *options)");
        return sink(newOutputStream);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        Logger logger = c.a;
        Intrinsics.checkNotNullParameter(path, "$this$source");
        Intrinsics.checkNotNullParameter(openOptionArr, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "Files.newInputStream(this, *options)");
        return source(newInputStream);
    }
}
