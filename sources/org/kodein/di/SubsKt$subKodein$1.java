package org.kodein.di;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lorg/kodein/di/Kodein$MainBuilder;", "", "invoke", "(Lorg/kodein/di/Kodein$MainBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class SubsKt$subKodein$1 extends Lambda implements Function1<Kodein.MainBuilder, Unit> {
    public final /* synthetic */ Kodein a;
    public final /* synthetic */ Copy b;
    public final /* synthetic */ Function1 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubsKt$subKodein$1(Kodein kodein, Copy copy, Function1 function1) {
        super(1);
        this.a = kodein;
        this.b = copy;
        this.c = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Kodein.MainBuilder mainBuilder) {
        invoke(mainBuilder);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Kodein.MainBuilder mainBuilder) {
        Intrinsics.checkParameterIsNotNull(mainBuilder, "$this$lazy");
        Kodein.MainBuilder.DefaultImpls.extend$default(mainBuilder, this.a, false, this.b, 2, (Object) null);
        this.c.invoke(mainBuilder);
    }
}
