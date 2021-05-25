package kotlin.coroutines.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0015\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0013\u0010\u0017\u001a\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0013\u0010\u0019\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001c"}, d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "", AuthSource.OPEN_CHANNEL_LIST, "()Ljava/lang/String;", "methodName", "", "l", "()[I", "lineNumbers", "", "s", "()[Ljava/lang/String;", "spilled", "", VKApiConst.VERSION, "()I", "version", "n", "localNames", "c", "className", "i", "indexToLabel", "f", "sourceFile", "<init>", "(ILjava/lang/String;[ILkotlin/Array;Lkotlin/Array;[ILjava/lang/String;Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface DebugMetadata {
    @JvmName(name = "c")
    String c() default "";

    @JvmName(name = "f")
    String f() default "";

    @JvmName(name = "i")
    int[] i() default {};

    @JvmName(name = "l")
    int[] l() default {};

    @JvmName(name = AuthSource.OPEN_CHANNEL_LIST)
    String m() default "";

    @JvmName(name = "n")
    String[] n() default {};

    @JvmName(name = "s")
    String[] s() default {};

    @JvmName(name = VKApiConst.VERSION)
    int v() default 1;
}
