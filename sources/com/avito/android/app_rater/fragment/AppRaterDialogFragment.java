package com.avito.android.app_rater.fragment;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.app_rater.R;
import com.avito.android.app_rater.di.AppRaterDependencies;
import com.avito.android.app_rater.di.AppRaterDialogComponent;
import com.avito.android.app_rater.di.DaggerAppRaterDialogComponent;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragmentViewModel;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.ToastsKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/lib/design/dialog/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Lcom/avito/android/lib/design/dialog/Dialog;", "onDetach", "()V", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModelFactory;", "viewModelFactory", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModelFactory;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulersFactory", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModel;", "viewModel", "<init>", "Companion", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public final class AppRaterDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public AppRaterDialogFragmentViewModel a;
    public final CompositeDisposable b = new CompositeDisposable();
    @Inject
    public SchedulersFactory schedulersFactory;
    @Inject
    public AppRaterDialogFragmentViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/app_rater/fragment/AppRaterDialogFragment$Companion;", "", "Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;", "page", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragment;", "getInstance", "(Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;)Lcom/avito/android/app_rater/fragment/AppRaterDialogFragment;", "<init>", "()V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AppRaterDialogFragment getInstance(@NotNull AppRaterEventSourcePage appRaterEventSourcePage) {
            Intrinsics.checkNotNullParameter(appRaterEventSourcePage, "page");
            AppRaterDialogFragment appRaterDialogFragment = new AppRaterDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("event_source_page", appRaterEventSourcePage);
            Unit unit = Unit.INSTANCE;
            appRaterDialogFragment.setArguments(bundle);
            return appRaterDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error("Failed on click app rater positive button", th);
                ((AppRaterDialogFragment) this.b).dismiss();
            } else if (i == 1) {
                Logs.error("Failed on click app rater negative button", th);
                ((AppRaterDialogFragment) this.b).dismiss();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Integer> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Integer num) {
            int i = this.a;
            if (i == 0) {
                Integer num2 = num;
                AppRaterDialogFragmentViewModel access$getViewModel$p = AppRaterDialogFragment.access$getViewModel$p((AppRaterDialogFragment) this.b);
                Intrinsics.checkNotNullExpressionValue(num2, "score");
                access$getViewModel$p.goToGooglePlayStore(num2.intValue());
            } else if (i == 1) {
                Integer num3 = num;
                AppRaterDialogFragmentViewModel access$getViewModel$p2 = AppRaterDialogFragment.access$getViewModel$p((AppRaterDialogFragment) this.b);
                Intrinsics.checkNotNullExpressionValue(num3, "score");
                access$getViewModel$p2.goToFeedback(num3.intValue());
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Observer<AppRaterDialogFragmentViewModel.State> {
        public final /* synthetic */ AppRaterDialogFragment a;

        public c(AppRaterDialogFragment appRaterDialogFragment) {
            this.a = appRaterDialogFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(AppRaterDialogFragmentViewModel.State state) {
            AppRaterDialogFragmentViewModel.State state2 = state;
            if (state2 instanceof AppRaterDialogFragmentViewModel.State.RedirectToGooglePlay) {
                AppRaterDialogFragment.access$redirectToGooglePlayStore(this.a);
            } else if (state2 instanceof AppRaterDialogFragmentViewModel.State.RedirectToFeedback) {
                AppRaterDialogFragment.access$redirectToFeedback(this.a);
            } else if (state2 instanceof AppRaterDialogFragmentViewModel.State.Close) {
                this.a.dismiss();
            }
        }
    }

    public static final class d extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ AppRaterDialogFragment a;
        public final /* synthetic */ AppRaterWithEmojiDialogViewImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AppRaterDialogFragment appRaterDialogFragment, AppRaterWithEmojiDialogViewImpl appRaterWithEmojiDialogViewImpl) {
            super(2);
            this.a = appRaterDialogFragment;
            this.b = appRaterWithEmojiDialogViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface, "it");
            config2.setTitle(R.string.app_rater_with_emoji_title);
            config2.setCustomView(this.b.getView());
            config2.addDefaultButton(R.string.app_rater_remind_later, new a2.a.a.k.c.a(this));
            config2.setCancelable(false);
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ AppRaterDialogFragmentViewModel access$getViewModel$p(AppRaterDialogFragment appRaterDialogFragment) {
        AppRaterDialogFragmentViewModel appRaterDialogFragmentViewModel = appRaterDialogFragment.a;
        if (appRaterDialogFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return appRaterDialogFragmentViewModel;
    }

    public static final void access$redirectToFeedback(AppRaterDialogFragment appRaterDialogFragment) {
        FragmentActivity activity = appRaterDialogFragment.getActivity();
        if (activity != null) {
            ToastsKt.showToast(activity, R.string.app_rater_thank_you, 1);
        }
        appRaterDialogFragment.dismiss();
    }

    public static final void access$redirectToGooglePlayStore(AppRaterDialogFragment appRaterDialogFragment) {
        Application application;
        Context applicationContext;
        Application application2;
        Context applicationContext2;
        Objects.requireNonNull(appRaterDialogFragment);
        try {
            FragmentActivity activity = appRaterDialogFragment.getActivity();
            if (!(activity == null || (application2 = activity.getApplication()) == null || (applicationContext2 = application2.getApplicationContext()) == null || applicationContext2.getPackageName() == null)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=com.avito.android"));
                Unit unit = Unit.INSTANCE;
                appRaterDialogFragment.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            FragmentActivity activity2 = appRaterDialogFragment.getActivity();
            if (!(activity2 == null || (application = activity2.getApplication()) == null || (applicationContext = application.getApplicationContext()) == null || applicationContext.getPackageName() == null)) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.avito.android"));
                Unit unit2 = Unit.INSTANCE;
                appRaterDialogFragment.startActivity(intent2);
            }
        }
        appRaterDialogFragment.dismiss();
    }

    @NotNull
    public final SchedulersFactory getSchedulersFactory() {
        SchedulersFactory schedulersFactory2 = this.schedulersFactory;
        if (schedulersFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
        }
        return schedulersFactory2;
    }

    @NotNull
    public final AppRaterDialogFragmentViewModelFactory getViewModelFactory() {
        AppRaterDialogFragmentViewModelFactory appRaterDialogFragmentViewModelFactory = this.viewModelFactory;
        if (appRaterDialogFragmentViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return appRaterDialogFragmentViewModelFactory;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppRaterDialogComponent.Builder appRaterDependencies = DaggerAppRaterDialogComponent.builder().appRaterDependencies((AppRaterDependencies) ComponentDependenciesKt.getDependencies(AppRaterDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Bundle arguments = getArguments();
        AppRaterEventSourcePage appRaterEventSourcePage = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("event_source_page") : null;
        if (serializable instanceof AppRaterEventSourcePage) {
            appRaterEventSourcePage = serializable;
        }
        appRaterDependencies.withSourcePage(appRaterEventSourcePage).build().inject(this);
        AppRaterDialogFragmentViewModelFactory appRaterDialogFragmentViewModelFactory = this.viewModelFactory;
        if (appRaterDialogFragmentViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, appRaterDialogFragmentViewModelFactory).get(AppRaterDialogFragmentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(\n …entViewModel::class.java)");
        AppRaterDialogFragmentViewModel appRaterDialogFragmentViewModel = (AppRaterDialogFragmentViewModel) viewModel;
        this.a = appRaterDialogFragmentViewModel;
        if (appRaterDialogFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appRaterDialogFragmentViewModel.getState().observe(requireActivity(), new c(this));
        AppRaterDialogFragmentViewModel appRaterDialogFragmentViewModel2 = this.a;
        if (appRaterDialogFragmentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appRaterDialogFragmentViewModel2.init();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.b.clear();
        super.onDetach();
    }

    public final void setSchedulersFactory(@NotNull SchedulersFactory schedulersFactory2) {
        Intrinsics.checkNotNullParameter(schedulersFactory2, "<set-?>");
        this.schedulersFactory = schedulersFactory2;
    }

    public final void setViewModelFactory(@NotNull AppRaterDialogFragmentViewModelFactory appRaterDialogFragmentViewModelFactory) {
        Intrinsics.checkNotNullParameter(appRaterDialogFragmentViewModelFactory, "<set-?>");
        this.viewModelFactory = appRaterDialogFragmentViewModelFactory;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(requireActivity()).inflate(R.layout.app_rater_with_emoji_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater\n         …_with_emoji_dialog, null)");
        AppRaterWithEmojiDialogViewImpl appRaterWithEmojiDialogViewImpl = new AppRaterWithEmojiDialogViewImpl(inflate);
        Dialog.Companion companion = Dialog.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Dialog create$default = Dialog.Companion.create$default(companion, requireContext, 0, 0, new d(this, appRaterWithEmojiDialogViewImpl), 6, null);
        create$default.setCanceledOnTouchOutside(false);
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = appRaterWithEmojiDialogViewImpl.getPositiveButtonClicks().subscribe(new b(0, this), new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dialogView.positiveButto…     dismiss()\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        Disposable subscribe2 = appRaterWithEmojiDialogViewImpl.getNegativeButtonClicks().subscribe(new b(1, this), new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "dialogView.negativeButto…     dismiss()\n        })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        return create$default;
    }
}
