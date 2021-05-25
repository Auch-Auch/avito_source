package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B1\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0016\u0010\u0015\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lkotlin/Lazy;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "d", "Lkotlin/jvm/functions/Function0;", "factoryProducer", "Lkotlin/reflect/KClass;", AuthSource.BOOKING_ORDER, "Lkotlin/reflect/KClass;", "viewModelClass", "Landroidx/lifecycle/ViewModelStore;", "c", "storeProducer", "getValue", "()Landroidx/lifecycle/ViewModel;", "value", AuthSource.SEND_ABUSE, "Landroidx/lifecycle/ViewModel;", "cached", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    public VM a;
    public final KClass<VM> b;
    public final Function0<ViewModelStore> c;
    public final Function0<ViewModelProvider.Factory> d;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends androidx.lifecycle.ViewModelStore> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends androidx.lifecycle.ViewModelProvider$Factory> */
    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull KClass<VM> kClass, @NotNull Function0<? extends ViewModelStore> function0, @NotNull Function0<? extends ViewModelProvider.Factory> function02) {
        Intrinsics.checkNotNullParameter(kClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(function0, "storeProducer");
        Intrinsics.checkNotNullParameter(function02, "factoryProducer");
        this.b = kClass;
        this.c = function0;
        this.d = function02;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.a != null;
    }

    @Override // kotlin.Lazy
    @NotNull
    public VM getValue() {
        VM vm = this.a;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.c.invoke(), this.d.invoke()).get(JvmClassMappingKt.getJavaClass((KClass) this.b));
        this.a = vm2;
        Intrinsics.checkNotNullExpressionValue(vm2, "ViewModelProvider(store,…ed = it\n                }");
        return vm2;
    }
}
