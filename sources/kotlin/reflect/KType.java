package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getClassifier$annotations", "()V", "classifier", "", "isMarkedNullable", "()Z", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "getArguments$annotations", "arguments", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public interface KType extends KAnnotatedElement {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getArguments$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void getClassifier$annotations() {
        }
    }

    @NotNull
    List<KTypeProjection> getArguments();

    @Nullable
    KClassifier getClassifier();

    boolean isMarkedNullable();
}
