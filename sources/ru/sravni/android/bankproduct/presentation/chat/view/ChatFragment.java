package ru.sravni.android.bankproduct.presentation.chat.view;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IButtonAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditDetailAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditOffersAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IGoToDashboardAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOffersAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOrderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/view/ChatFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "", "onCreateOptionsMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "onPause", "()V", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IPassportScanAnswerViewModel;", "f", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IPassportScanAnswerViewModel;", "passportScanViewModel", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "h", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "Lru/sravni/android/bankproduct/databinding/ChatFragmentSravniBinding;", "e", "Lru/sravni/android/bankproduct/databinding/ChatFragmentSravniBinding;", "savedBinding", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", g.a, "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", "chatViewModel", "i", "Z", "restartEnabled", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatFragment extends CommonFragment {
    public ChatFragmentSravniBinding e;
    public IPassportScanAnswerViewModel f;
    public IChatViewModel g;
    public IKeyboardHider h;
    public boolean i;
    public HashMap j;

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
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationChatProviderKt.getPresentationChatKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Observer<Boolean> {
        public final /* synthetic */ ChatFragment a;

        public b(ChatFragment chatFragment) {
            this.a = chatFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            ChatFragment.access$changeRestartActivation(this.a, bool);
        }
    }

    public static final void access$changeRestartActivation(ChatFragment chatFragment, Boolean bool) {
        Objects.requireNonNull(chatFragment);
        chatFragment.i = Intrinsics.areEqual(bool, Boolean.TRUE);
        FragmentActivity activity = chatFragment.getActivity();
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
    }

    public static final /* synthetic */ IChatViewModel access$getChatViewModel$p(ChatFragment chatFragment) {
        IChatViewModel iChatViewModel = chatFragment.g;
        if (iChatViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatViewModel");
        }
        return iChatViewModel;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @Nullable
    public String getFragmentModuleName() {
        return BaseAnalyticKt.ANALYTIC_MODULE_PRODUCT;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @NotNull
    public Kodein.Module initModule() {
        return new Kodein.Module("ChatFragmentModule", false, null, a.a, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        Intrinsics.checkParameterIsNotNull(menuInflater, "inflater");
        menuInflater.inflate(R.menu.chat_menu_sravni, menu);
        MenuItem item = menu.getItem(0);
        Intrinsics.checkExpressionValueIsNotNull(item, "menu.getItem(0)");
        item.setVisible(this.i);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.h = (IKeyboardHider) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardHider>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$1
        }), null);
        this.f = (IPassportScanAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IPassportScanAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$2
        }), null);
        setCurrentModule();
        this.g = (IChatViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IChatViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$3
        }), null);
        if (this.e == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.chat_fragment_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
            ChatFragmentSravniBinding chatFragmentSravniBinding = (ChatFragmentSravniBinding) inflate;
            chatFragmentSravniBinding.setButtonAnswerViewModel((IButtonAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IButtonAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$4
            }), null));
            chatFragmentSravniBinding.setFreeTextAnswerViewModel((IFreeTextAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IFreeTextAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$5
            }), null));
            chatFragmentSravniBinding.setSliderAnswerViewModel((ISliderAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ISliderAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$6
            }), null));
            chatFragmentSravniBinding.setMaskTextAnswerViewModel((IMaskTextAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IMaskTextAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$7
            }), null));
            chatFragmentSravniBinding.setCreditOffersAnswerViewModel((ICreditOffersAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ICreditOffersAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$8
            }), null));
            chatFragmentSravniBinding.setSuggestionAnswerViewModel((ISuggestionAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ISuggestionAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$9
            }), null));
            chatFragmentSravniBinding.setOsagoOffersAnswerViewModel((IOsagoOffersAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IOsagoOffersAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$10
            }), null));
            chatFragmentSravniBinding.setOsagoOrderAnswerViewModel((IOsagoOrderAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IOsagoOrderAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$11
            }), null));
            chatFragmentSravniBinding.setGoToDashboardAnswerViewModel((IGoToDashboardAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IGoToDashboardAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$12
            }), null));
            chatFragmentSravniBinding.setCreditDetailAnswerViewModel((ICreditDetailAnswerViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ICreditDetailAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$$inlined$instance$13
            }), null));
            IPassportScanAnswerViewModel iPassportScanAnswerViewModel = this.f;
            if (iPassportScanAnswerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passportScanViewModel");
            }
            chatFragmentSravniBinding.setPassportScanAnswerViewModel(iPassportScanAnswerViewModel);
            IChatViewModel iChatViewModel = this.g;
            if (iChatViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatViewModel");
            }
            chatFragmentSravniBinding.setChatViewModel(iChatViewModel);
            chatFragmentSravniBinding.setChatLifecycleOwner(this);
            chatFragmentSravniBinding.setLifecycleOwner(this);
            setHasOptionsMenu(true);
            IChatViewModel iChatViewModel2 = this.g;
            if (iChatViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatViewModel");
            }
            iChatViewModel2.getRestartChatActive().observe(getViewLifecycleOwner(), new b(this));
            View root = chatFragmentSravniBinding.getRoot();
            Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
            setupActionBar(root, true);
            this.e = chatFragmentSravniBinding;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        requireActivity.getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(this, true) { // from class: ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment$onCreateView$2
            public final /* synthetic */ ChatFragment c;

            {
                this.c = r1;
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.c.requireActivity().finish();
            }
        });
        ChatFragmentSravniBinding chatFragmentSravniBinding2 = this.e;
        if (chatFragmentSravniBinding2 == null) {
            Intrinsics.throwNpe();
        }
        return chatFragmentSravniBinding2.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != R.id.actionChatRestart) {
            return super.onOptionsItemSelected(menuItem);
        }
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        new MaterialAlertDialogBuilder(context).setTitle((CharSequence) getString(R.string.start_again)).setMessage((CharSequence) getString(R.string.start_again_chat_message)).setPositiveButton(R.string.Yes, (DialogInterface.OnClickListener) new a7.c.a.a.o.c.b.a(this)).setNegativeButton(R.string.No, (DialogInterface.OnClickListener) a7.c.a.a.o.c.b.b.a).show();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IKeyboardHider iKeyboardHider = this.h;
        if (iKeyboardHider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardHider");
        }
        iKeyboardHider.hideKeyboard();
        super.onPause();
    }
}
