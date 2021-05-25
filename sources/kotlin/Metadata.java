package kotlin;

import com.avito.android.analytics.event.CallToSellerEventKt;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.firebase.messaging.Constants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0013\u0010\u0015\u001a\u00020\u000e8\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\n8\u0007@\u0007X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0007@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lkotlin/Metadata;", "", "", CallToSellerEventKt.CALL_SOURCE_XL_ITEM, "()Ljava/lang/String;", "extraString", "", "d2", "()[Ljava/lang/String;", "data2", "", "k", "()I", MessageBody.Location.KIND, "", "bv", "()[I", "bytecodeVersion", "pn", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "mv", "metadataVersion", "xi", "extraInt", "d1", "data1", "<init>", "(I[I[ILkotlin/Array;Lkotlin/Array;Ljava/lang/String;Ljava/lang/String;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public @interface Metadata {
    @JvmName(name = "bv")
    int[] bv() default {};

    @JvmName(name = "d1")
    String[] d1() default {};

    @JvmName(name = "d2")
    String[] d2() default {};

    @JvmName(name = "k")
    int k() default 1;

    @JvmName(name = "mv")
    int[] mv() default {};

    @JvmName(name = "pn")
    String pn() default "";

    @JvmName(name = "xi")
    int xi() default 0;

    @JvmName(name = CallToSellerEventKt.CALL_SOURCE_XL_ITEM)
    String xs() default "";
}
