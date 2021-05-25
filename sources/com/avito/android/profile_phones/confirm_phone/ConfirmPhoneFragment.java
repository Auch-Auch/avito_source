package com.avito.android.profile_phones.confirm_phone;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.code_confirmation.CodeReceiver;
import com.avito.android.code_confirmation.CodeReceiverImpl;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.lib.design.ticking_button.TickingButtonWrapper;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies;
import com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneModule;
import com.avito.android.profile_phones.confirm_phone.di.DaggerConfirmPhoneComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithIconAction;
import ru.avito.component.toolbar.AppbarClickListener;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\bU\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00108\u0002@\u0002X.¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/lib/design/ticking_button/TickingButtonWrapper;", "n", "Lcom/avito/android/lib/design/ticking_button/TickingButtonWrapper;", "tickerButton", "Lcom/avito/android/lib/design/input/Input;", "p", "Lcom/avito/android/lib/design/input/Input;", "codeInput", "Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "t", "Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "smsRetrieverClient", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "o", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "componentContainer", "Lcom/avito/android/util/KeyboardSubscription;", "k", "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "l", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "appBarLayout", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel;", VKApiConst.Q, "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel;", "viewModel", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "u", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/code_confirmation/CodeReceiver;", "r", "Lcom/avito/android/code_confirmation/CodeReceiver;", "codeReceiver", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/View;", "anchorView", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;", "viewModelFactory", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;)V", "Landroid/content/IntentFilter;", "s", "Landroid/content/IntentFilter;", "confirmationIntentFilter", "Lio/reactivex/disposables/Disposable;", "j", "Lio/reactivex/disposables/Disposable;", "disposable", "<init>", "Companion", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ConfirmPhoneFragment extends TabBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public Disposable j;
    public KeyboardSubscription k;
    public AppBarLayoutWithIconAction l;
    public View m;
    public TickingButtonWrapper n;
    public ComponentContainer o;
    public Input p;
    public ConfirmPhoneViewModel q;
    public CodeReceiver r;
    public final IntentFilter s = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
    public SmsRetrieverClient t;
    @NotNull
    public NavigationState u = new NavigationState(false);
    @Inject
    public ConfirmPhoneViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneFragment$Companion;", "", "", "phone", "", "codeLength", "", "timeoutSeconds", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneFragment;", "newInstance", "(Ljava/lang/String;IJ)Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneFragment;", "newInstanceWithCodeRequest", "(Ljava/lang/String;)Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneFragment;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ConfirmPhoneFragment newInstance(@NotNull String str, int i, long j) {
            Intrinsics.checkNotNullParameter(str, "phone");
            ConfirmPhoneFragment confirmPhoneFragment = new ConfirmPhoneFragment();
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putBoolean("code_request_needed", false);
            bundle.putInt("code_length", i);
            bundle.putLong("timeout", j);
            Unit unit = Unit.INSTANCE;
            confirmPhoneFragment.setArguments(bundle);
            return confirmPhoneFragment;
        }

        @NotNull
        public final ConfirmPhoneFragment newInstanceWithCodeRequest(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "phone");
            ConfirmPhoneFragment confirmPhoneFragment = new ConfirmPhoneFragment();
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putBoolean("code_request_needed", true);
            Unit unit = Unit.INSTANCE;
            confirmPhoneFragment.setArguments(bundle);
            return confirmPhoneFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<TResult> implements OnCompleteListener<Void> {
        public final /* synthetic */ ConfirmPhoneFragment a;

        public a(ConfirmPhoneFragment confirmPhoneFragment) {
            this.a = confirmPhoneFragment;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NotNull Task<Void> task) {
            Intrinsics.checkNotNullParameter(task, "it");
            String simpleName = this.a.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
            Logs.info$default(simpleName, "Sms retriever started", null, 4, null);
        }
    }

    public static final class b implements OnFailureListener {
        public final /* synthetic */ ConfirmPhoneFragment a;

        public b(ConfirmPhoneFragment confirmPhoneFragment) {
            this.a = confirmPhoneFragment;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            String simpleName = this.a.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
            Logs.error$default(simpleName, "Failed to start sms retriever", null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ ConfirmPhoneFragment a;

        public c(ConfirmPhoneFragment confirmPhoneFragment) {
            this.a = confirmPhoneFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            Input.setText$default(ConfirmPhoneFragment.access$getCodeInput$p(this.a), str, false, 2, null);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to receive sms from code receiver", th);
        }
    }

    public static final class e extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ ConfirmPhoneFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ConfirmPhoneFragment confirmPhoneFragment) {
            super(1);
            this.a = confirmPhoneFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            ConfirmPhoneFragment.access$getAppBarLayout$p(this.a).setExpanded(!bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ConfirmPhoneFragment a;

        public f(ConfirmPhoneFragment confirmPhoneFragment) {
            this.a = confirmPhoneFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConfirmPhoneFragment.access$getAppBarLayout$p(this.a).setExpanded(true);
        }
    }

    public static final /* synthetic */ View access$getAnchorView$p(ConfirmPhoneFragment confirmPhoneFragment) {
        View view = confirmPhoneFragment.m;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
        }
        return view;
    }

    public static final /* synthetic */ AppBarLayoutWithIconAction access$getAppBarLayout$p(ConfirmPhoneFragment confirmPhoneFragment) {
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = confirmPhoneFragment.l;
        if (appBarLayoutWithIconAction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayoutWithIconAction;
    }

    public static final /* synthetic */ Input access$getCodeInput$p(ConfirmPhoneFragment confirmPhoneFragment) {
        Input input = confirmPhoneFragment.p;
        if (input == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeInput");
        }
        return input;
    }

    public static final /* synthetic */ ComponentContainer access$getComponentContainer$p(ConfirmPhoneFragment confirmPhoneFragment) {
        ComponentContainer componentContainer = confirmPhoneFragment.o;
        if (componentContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("componentContainer");
        }
        return componentContainer;
    }

    public static final String access$getSubtitle(ConfirmPhoneFragment confirmPhoneFragment, String str) {
        Objects.requireNonNull(confirmPhoneFragment);
        String string = confirmPhoneFragment.getResources().getString(R.string.phone_confirm_subtitle_template, m.replace$default(str, ' ', (char) Typography.nbsp, false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …onBreakingPhone\n        )");
        return string;
    }

    public static final /* synthetic */ TickingButtonWrapper access$getTickerButton$p(ConfirmPhoneFragment confirmPhoneFragment) {
        TickingButtonWrapper tickingButtonWrapper = confirmPhoneFragment.n;
        if (tickingButtonWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tickerButton");
        }
        return tickingButtonWrapper;
    }

    public static final /* synthetic */ ConfirmPhoneViewModel access$getViewModel$p(ConfirmPhoneFragment confirmPhoneFragment) {
        ConfirmPhoneViewModel confirmPhoneViewModel = confirmPhoneFragment.q;
        if (confirmPhoneViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return confirmPhoneViewModel;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.u;
    }

    @NotNull
    public final ConfirmPhoneViewModelFactory getViewModelFactory() {
        ConfirmPhoneViewModelFactory confirmPhoneViewModelFactory = this.viewModelFactory;
        if (confirmPhoneViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return confirmPhoneViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        SmsRetrieverClient client = SmsRetriever.getClient((Activity) requireActivity());
        Intrinsics.checkNotNullExpressionValue(client, "SmsRetriever.getClient(requireActivity())");
        this.t = client;
        if (client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smsRetrieverClient");
        }
        client.startSmsRetriever().addOnCompleteListener(new a(this)).addOnFailureListener(new b(this));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        IntentFilter intentFilter = this.s;
        SmsRetrieverClient smsRetrieverClient = this.t;
        if (smsRetrieverClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smsRetrieverClient");
        }
        this.r = new CodeReceiverImpl(requireActivity, intentFilter, smsRetrieverClient);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.confirm_phone, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyboardSubscription keyboardSubscription = this.k;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        Input input = this.p;
        if (input == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeInput");
        }
        input.clearInputFocus();
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        TickingButtonWrapper tickingButtonWrapper = this.n;
        if (tickingButtonWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tickerButton");
        }
        bundle.putBundle("ticker_button_state", tickingButtonWrapper.saveState());
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ConfirmPhoneViewModelFactory confirmPhoneViewModelFactory = this.viewModelFactory;
        if (confirmPhoneViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, confirmPhoneViewModelFactory).get(ConfirmPhoneViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …iewModelImpl::class.java)");
        this.q = (ConfirmPhoneViewModel) viewModel;
        KeyboardSubscription keyboardSubscription = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("ticker_button_state") : null;
        View findViewById = view.findViewById(R.id.anchor_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.m = findViewById;
        View findViewById2 = view.findViewById(R.id.ticker_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        String string = getString(R.string.new_code_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.new_code_text)");
        TickingButtonWrapper tickingButtonWrapper = new TickingButtonWrapper((Button) findViewById2, string, null, bundle2, 4, null);
        this.n = tickingButtonWrapper;
        tickingButtonWrapper.setOnClickListener(new a2.a.a.c2.b.d(this));
        View findViewById3 = view.findViewById(R.id.phone_confirm_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.o = (ComponentContainer) findViewById3;
        View findViewById4 = view.findViewById(R.id.code_input);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById4;
        this.p = input;
        input.setInputType(2);
        Input input2 = this.p;
        if (input2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeInput");
        }
        input2.showKeyboard();
        ConfirmPhoneViewModel confirmPhoneViewModel = this.q;
        if (confirmPhoneViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Input input3 = this.p;
        if (input3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeInput");
        }
        confirmPhoneViewModel.subscribeToInputChanges(InputExtensionsKt.textChangesRx3(input3));
        View findViewById5 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type ru.avito.component.toolbar.AppBarLayoutWithIconAction");
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = (AppBarLayoutWithIconAction) findViewById5;
        this.l = appBarLayoutWithIconAction;
        appBarLayoutWithIconAction.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        AppBarLayoutWithIconAction appBarLayoutWithIconAction2 = this.l;
        if (appBarLayoutWithIconAction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        }
        appBarLayoutWithIconAction2.setClickListener(new AppbarClickListener() { // from class: com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment$initView$2
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                ConfirmPhoneFragment.access$getViewModel$p(ConfirmPhoneFragment.this).onBackClicked();
            }
        });
        ConfirmPhoneViewModel confirmPhoneViewModel2 = this.q;
        if (confirmPhoneViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        confirmPhoneViewModel2.navigation().observe(getViewLifecycleOwner(), new a2.a.a.c2.b.a(this));
        ConfirmPhoneViewModel confirmPhoneViewModel3 = this.q;
        if (confirmPhoneViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        confirmPhoneViewModel3.screenState().observe(getViewLifecycleOwner(), new a2.a.a.c2.b.b(this));
        ConfirmPhoneViewModel confirmPhoneViewModel4 = this.q;
        if (confirmPhoneViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        confirmPhoneViewModel4.codeRequestState().observe(getViewLifecycleOwner(), new a2.a.a.c2.b.c(this));
        CodeReceiver codeReceiver = this.r;
        if (codeReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeReceiver");
        }
        this.j = codeReceiver.connect().subscribe(new c(this), d.a);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getConfiguration().orientation;
        if (i == 1) {
            AppBarLayoutWithIconAction appBarLayoutWithIconAction3 = this.l;
            if (appBarLayoutWithIconAction3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayoutWithIconAction3.postDelayed(new f(this), 200);
        } else if (i == 2) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                keyboardSubscription = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) activity, false, (Function1) new e(this), 1, (Object) null);
            }
            this.k = keyboardSubscription;
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.u = navigationState;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        String string = requireArguments.getString("phone");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "args.getString(KEY_PHONE)!!");
        boolean z = requireArguments.getBoolean("code_request_needed");
        Long l2 = null;
        Integer valueOf = requireArguments.containsKey("code_length") ? Integer.valueOf(requireArguments.getInt("code_length")) : null;
        int intValue = valueOf != null ? valueOf.intValue() : 5;
        if (requireArguments.containsKey("timeout")) {
            l2 = Long.valueOf(requireArguments.getLong("timeout"));
        }
        long longValue = l2 != null ? l2.longValue() : 0;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DaggerConfirmPhoneComponent.builder().confirmPhoneModule(new ConfirmPhoneModule(resources, string, intValue, longValue, z)).confirmPhoneDependencies((ConfirmPhoneDependencies) ComponentDependenciesKt.getDependencies(ConfirmPhoneDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull ConfirmPhoneViewModelFactory confirmPhoneViewModelFactory) {
        Intrinsics.checkNotNullParameter(confirmPhoneViewModelFactory, "<set-?>");
        this.viewModelFactory = confirmPhoneViewModelFactory;
    }
}
