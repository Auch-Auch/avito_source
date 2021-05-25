package t6.w.f.a;

import a2.b.a.a.a;
import java.lang.reflect.Type;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
public final class c extends Lambda implements Function0<Type> {
    public final /* synthetic */ KotlinType a;
    public final /* synthetic */ KClassImpl.Data.j b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(KotlinType kotlinType, KClassImpl.Data.j jVar) {
        super(0);
        this.a = kotlinType;
        this.b = jVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Type invoke() {
        ClassifierDescriptor declarationDescriptor = this.a.getConstructor().mo425getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
            if (javaClass == null) {
                StringBuilder L = a.L("Unsupported superclass of ");
                L.append(this.b.a);
                L.append(": ");
                L.append(declarationDescriptor);
                throw new KotlinReflectionInternalError(L.toString());
            } else if (Intrinsics.areEqual(KClassImpl.this.getJClass().getSuperclass(), javaClass)) {
                Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                Intrinsics.checkNotNullExpressionValue(genericSuperclass, "jClass.genericSuperclass");
                return genericSuperclass;
            } else {
                Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                int indexOf = ArraysKt___ArraysKt.indexOf(interfaces, javaClass);
                if (indexOf >= 0) {
                    Type type = KClassImpl.this.getJClass().getGenericInterfaces()[indexOf];
                    Intrinsics.checkNotNullExpressionValue(type, "jClass.genericInterfaces[index]");
                    return type;
                }
                StringBuilder L2 = a.L("No superclass of ");
                L2.append(this.b.a);
                L2.append(" in Java reflection for ");
                L2.append(declarationDescriptor);
                throw new KotlinReflectionInternalError(L2.toString());
            }
        } else {
            throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
        }
    }
}
