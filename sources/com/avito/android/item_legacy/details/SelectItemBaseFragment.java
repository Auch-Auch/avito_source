package com.avito.android.item_legacy.details;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectListener;
import com.avito.android.select.bottom_sheet.SelectBottomSheetFragmentKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b,\u0010\fJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00140\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/avito/android/item_legacy/details/SelectItemBaseFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/select/SelectListener;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/avito/android/select/Arguments;", "arguments", "showSelectScreen", "(Lcom/avito/android/select/Arguments;)V", "", "requestId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedItems", "sectionTitle", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "", "d", "Z", "keyboardShown", "Lcom/avito/android/util/KeyboardSubscription;", "e", "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "resultHandler", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "getResultHandler", "()Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "setResultHandler", "(Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;)V", "<init>", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public abstract class SelectItemBaseFragment extends BaseFragment implements SelectListener, SelectParameterClickListener.Router {
    public final Handler c = new Handler();
    public boolean d;
    public KeyboardSubscription e;
    @Inject
    public ItemDetailsSelectResultHandler resultHandler;

    public static final class a implements Runnable {
        public final /* synthetic */ SelectItemBaseFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;

        public a(SelectItemBaseFragment selectItemBaseFragment, String str, List list) {
            this.a = selectItemBaseFragment;
            this.b = str;
            this.c = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SelectListener.DefaultImpls.onSelected$default(this.a.getResultHandler(), this.b, this.c, null, 4, null);
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ SelectItemBaseFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SelectItemBaseFragment selectItemBaseFragment) {
            super(1);
            this.a = selectItemBaseFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.d = bool.booleanValue();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SelectItemBaseFragment a;
        public final /* synthetic */ Arguments b;

        public c(SelectItemBaseFragment selectItemBaseFragment, Arguments arguments) {
            this.a = selectItemBaseFragment;
            this.b = arguments;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SelectItemBaseFragment.access$showBottomSheetSelect(this.a, this.b);
        }
    }

    public static final void access$showBottomSheetSelect(SelectItemBaseFragment selectItemBaseFragment, Arguments arguments) {
        if (selectItemBaseFragment.isAdded()) {
            SelectBottomSheetFragmentKt.createSelectSheetDialogFragment(selectItemBaseFragment, arguments).show(selectItemBaseFragment.getParentFragmentManager(), "select_fragment");
        }
    }

    @NotNull
    public final ItemDetailsSelectResultHandler getResultHandler() {
        ItemDetailsSelectResultHandler itemDetailsSelectResultHandler = this.resultHandler;
        if (itemDetailsSelectResultHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultHandler");
        }
        return itemDetailsSelectResultHandler;
    }

    @Override // com.avito.android.select.SelectListener
    public void onCancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        SelectListener.DefaultImpls.onCancel(this, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KeyboardSubscription keyboardSubscription = this.e;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
    }

    @Override // com.avito.android.select.SelectListener
    public void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedItems");
        this.c.post(new a(this, str, list));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        KeyboardSubscription keyboardSubscription = null;
        if (activity != null) {
            keyboardSubscription = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) activity, false, (Function1) new b(this), 1, (Object) null);
        }
        this.e = keyboardSubscription;
    }

    public final void setResultHandler(@NotNull ItemDetailsSelectResultHandler itemDetailsSelectResultHandler) {
        Intrinsics.checkNotNullParameter(itemDetailsSelectResultHandler, "<set-?>");
        this.resultHandler = itemDetailsSelectResultHandler;
    }

    @Override // com.avito.android.item_legacy.details.SelectParameterClickListener.Router
    public void showSelectScreen(@NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (this.d) {
            View view = getView();
            if (view != null) {
                Keyboards.hideKeyboard$default(view, false, 1, null);
            }
            this.c.postDelayed(new c(this, arguments), 200);
        } else if (isAdded()) {
            SelectBottomSheetFragmentKt.createSelectSheetDialogFragment(this, arguments).show(getParentFragmentManager(), "select_fragment");
        }
    }
}
