package defpackage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
/* compiled from: kotlin-style lambda group */
/* renamed from: k5  reason: default package */
public final class k5 extends Lambda implements Function0<ParameterDescriptor> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k5(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final ParameterDescriptor invoke() {
        int i = this.a;
        if (i == 0) {
            return (ReceiverParameterDescriptor) this.b;
        }
        if (i == 1) {
            return (ReceiverParameterDescriptor) this.b;
        }
        throw null;
    }
}
