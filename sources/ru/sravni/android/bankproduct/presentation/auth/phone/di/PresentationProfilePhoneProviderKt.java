package ru.sravni.android.bankproduct.presentation.auth.phone.di;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/kodein/di/Kodein$Module;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Module;", "getPresentationProfilePhoneKodeinModule", "()Lorg/kodein/di/Kodein$Module;", "presentationProfilePhoneKodeinModule", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class PresentationProfilePhoneProviderKt {
    @NotNull
    public static final Kodein.Module a = new Kodein.Module("presentationProfilePhoneKodeinModule", false, null, a.a, 6, null);

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            builder2.Bind(TypesKt.TT(new PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$$special$$inlined$bind$1()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$$special$$inlined$provider$1()), a7.c.a.a.o.a.a.a.a.a));
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Kodein.Module getPresentationProfilePhoneKodeinModule() {
        return a;
    }
}
