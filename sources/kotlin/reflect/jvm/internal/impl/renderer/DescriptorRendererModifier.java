package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL = ArraysKt___ArraysKt.toSet(values());
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final boolean a;

    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    static {
        DescriptorRendererModifier[] values = values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 14; i++) {
            DescriptorRendererModifier descriptorRendererModifier = values[i];
            if (descriptorRendererModifier.getIncludeByDefault()) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    /* access modifiers changed from: public */
    DescriptorRendererModifier(boolean z) {
        this.a = z;
    }

    public final boolean getIncludeByDefault() {
        return this.a;
    }
}
