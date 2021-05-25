package ru.sravni.android.bankproduct.utils;

import a7.c.a.a.r.b;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinContext;
import org.kodein.di.KodeinTrigger;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0015\u001a\u00020\u00108V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u001a8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/utils/CommonFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/kodein/di/KodeinAware;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/View;", "view", "", "displayHome", "", "setupActionBar", "(Landroid/view/View;Z)V", "onResume", "()V", "setCurrentModule", "Lorg/kodein/di/Kodein;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getKodein", "()Lorg/kodein/di/Kodein;", "kodein", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", AuthSource.BOOKING_ORDER, "getPreviousModuleInfoForFragmentViewModel", "()Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousModuleInfoForFragmentViewModel", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public abstract class CommonFragment extends Fragment implements KodeinAware {
    public static final /* synthetic */ KProperty[] d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CommonFragment.class), "previousModuleInfoForFragmentViewModel", "getPreviousModuleInfoForFragmentViewModel()Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;"))};
    @NotNull
    public final Lazy a = c.lazy(new a(this));
    public final Lazy b = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.utils.CommonFragment$$special$$inlined$instance$1
    }), null).provideDelegate(this, d[0]);
    public HashMap c;

    public static final class a extends Lambda implements Function0<Kodein> {
        public final /* synthetic */ CommonFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CommonFragment commonFragment) {
            super(0);
            this.a = commonFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Kodein invoke() {
            return CommonFragment.access$previousInit(this.a);
        }
    }

    public static final Kodein access$previousInit(CommonFragment commonFragment) {
        Objects.requireNonNull(commonFragment);
        return Kodein.Companion.invoke$default(Kodein.Companion, false, new b(commonFragment), 1, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        View view = (View) this.c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Nullable
    public String getFragmentModuleName() {
        return null;
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public Kodein getKodein() {
        return (Kodein) this.a.getValue();
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public KodeinContext<?> getKodeinContext() {
        return KodeinAware.DefaultImpls.getKodeinContext(this);
    }

    @Override // org.kodein.di.KodeinAware
    @Nullable
    public KodeinTrigger getKodeinTrigger() {
        return KodeinAware.DefaultImpls.getKodeinTrigger(this);
    }

    @NotNull
    public abstract Kodein.Module initModule();

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setCurrentModule();
    }

    public final void setCurrentModule() {
        Lazy lazy = this.b;
        KProperty kProperty = d[0];
        ((IPreviousModuleInfoController) lazy.getValue()).setCurrentModuleName(getFragmentModuleName());
    }

    public final void setupActionBar(@NotNull View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((AppCompatActivity) activity).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ActionBar supportActionBar = ((AppCompatActivity) activity2).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(z);
                }
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    ActionBar supportActionBar2 = ((AppCompatActivity) activity3).getSupportActionBar();
                    if (supportActionBar2 != null) {
                        supportActionBar2.setDisplayShowHomeEnabled(z);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }
}
