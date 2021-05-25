package t6.w.f.a.m.h.a;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
public final class a extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    public final /* synthetic */ MemberDeserializer a;
    public final /* synthetic */ MessageLite b;
    public final /* synthetic */ AnnotatedCallableKind c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.a = memberDeserializer;
        this.b = messageLite;
        this.c = annotatedCallableKind;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public List<? extends AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        MemberDeserializer memberDeserializer = this.a;
        ProtoContainer a3 = memberDeserializer.a(memberDeserializer.a.getContainingDeclaration());
        if (a3 == null) {
            list = null;
        } else {
            list = this.a.a.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(a3, this.b, this.c);
        }
        return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
    }
}
