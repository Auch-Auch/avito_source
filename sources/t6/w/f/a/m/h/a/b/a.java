package t6.w.f.a.m.h.a.b;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
public final class a extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ DeserializedClassDescriptor a;
    public final /* synthetic */ ProtoBuf.EnumEntry b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf.EnumEntry enumEntry) {
        super(0);
        this.a = deserializedClassDescriptor;
        this.b = enumEntry;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.toList(this.a.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.a.getThisAsProtoContainer$deserialization(), this.b));
    }
}
