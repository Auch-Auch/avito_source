package ru.sravni.android.bankproduct.utils.extlib;

import a7.c.a.a.r.d.b;
import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.repository.token.ITokenDataStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "isSravniTokenAvailable", "(Landroid/app/Application;)Z", "", "clearSravniToken", "(Landroid/app/Application;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class LibUtilKt {
    public static final void clearSravniToken(@NotNull Application application) {
        Intrinsics.checkParameterIsNotNull(application, MimeTypes.BASE_TYPE_APPLICATION);
        Kodein invoke$default = Kodein.Companion.invoke$default(Kodein.Companion, false, new b(application), 1, null);
        ((ITokenDataStorage) KodeinAwareKt.getDirect(invoke$default).getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenDataStorage>() { // from class: ru.sravni.android.bankproduct.utils.extlib.LibUtilKt$clearSravniToken$$inlined$instance$2
        }), "Memory")).clear();
        ((ITokenDataStorage) KodeinAwareKt.getDirect(invoke$default).getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenDataStorage>() { // from class: ru.sravni.android.bankproduct.utils.extlib.LibUtilKt$clearSravniToken$$inlined$instance$1
        }), "SharedPreference")).clear();
    }

    public static final boolean isSravniTokenAvailable(@NotNull Application application) {
        Intrinsics.checkParameterIsNotNull(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (((ITokenDataStorage) KodeinAwareKt.getDirect(Kodein.Companion.invoke$default(Kodein.Companion, false, new b(application), 1, null)).getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenDataStorage>() { // from class: ru.sravni.android.bankproduct.utils.extlib.LibUtilKt$isSravniTokenAvailable$$inlined$instance$1
        }), "SharedPreference")).getTokenData() != null) {
            return true;
        }
        return false;
    }
}
