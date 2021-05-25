package kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
@Target({ElementType.METHOD})
@SinceKotlin(version = "1.2")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003ø\u0001\u0000\u0002\u0007\n\u0005\b(0\u0001¨\u0006\u0004"}, d2 = {"Lkotlin/jvm/JvmDefault;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
public @interface JvmDefault {
}
