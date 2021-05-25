package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class FilteredAnnotations implements Annotations {
    @NotNull
    public final Annotations a;
    public final boolean b;
    @NotNull
    public final Function1<FqName, Boolean> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.FqName, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(@NotNull Annotations annotations, boolean z, @NotNull Function1<? super FqName, Boolean> function1) {
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
        this.a = annotations;
        this.b = z;
        this.c = function1;
    }

    public final boolean a(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && this.c.invoke(fqName).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.c.invoke(fqName).booleanValue()) {
            return this.a.findAnnotation(fqName);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.c.invoke(fqName).booleanValue()) {
            return this.a.hasAnnotation(fqName);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        boolean z;
        Annotations annotations = this.a;
        if (!(annotations instanceof Collection) || !((Collection) annotations).isEmpty()) {
            Iterator it = annotations.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (a((AnnotationDescriptor) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!this.b) {
            return z;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations annotations = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : annotations) {
            if (a((AnnotationDescriptor) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilteredAnnotations(@NotNull Annotations annotations, @NotNull Function1<? super FqName, Boolean> function1) {
        this(annotations, false, function1);
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
    }
}
