package com.avito.android.payment.wallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.payment.R;
import com.avito.android.payment.di.component.DaggerWalletPageComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.module.WalletPageModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.payment.wallet.WalletPage;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\u0006J)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/payment/wallet/WalletPageActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "onSupportNavigateUp", "()Z", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/payment/wallet/WalletPageViewModelFactory;", "walletPageViewModelFactory", "Lcom/avito/android/payment/wallet/WalletPageViewModelFactory;", "getWalletPageViewModelFactory", "()Lcom/avito/android/payment/wallet/WalletPageViewModelFactory;", "setWalletPageViewModelFactory", "(Lcom/avito/android/payment/wallet/WalletPageViewModelFactory;)V", "Lcom/avito/android/payment/wallet/WalletPageViewModel;", "k", "Lcom/avito/android/payment/wallet/WalletPageViewModel;", "walletPageViewModel", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WalletPageActivity extends BaseActivity {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public WalletPageViewModel k;
    @Inject
    public WalletPageViewModelFactory walletPageViewModelFactory;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WalletPageActivity a;

        public a(WalletPageActivity walletPageActivity) {
            this.a = walletPageActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WalletPageViewModel.getWalletInfo$default(WalletPageActivity.access$getWalletPageViewModel$p(this.a), false, 1, null);
        }
    }

    public static final class b implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ WalletPageActivity a;

        public b(WalletPageActivity walletPageActivity) {
            this.a = walletPageActivity;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            WalletPageActivity.access$getWalletPageViewModel$p(this.a).getWalletInfo(true);
        }
    }

    public static final class c<T> implements Observer<WalletPage> {
        public final /* synthetic */ WalletPageActivity a;
        public final /* synthetic */ SwipeRefreshLayout b;
        public final /* synthetic */ FrameLayout c;
        public final /* synthetic */ LinearLayout d;
        public final /* synthetic */ TextView e;
        public final /* synthetic */ TextView f;
        public final /* synthetic */ Button g;
        public final /* synthetic */ Button h;

        public c(WalletPageActivity walletPageActivity, SwipeRefreshLayout swipeRefreshLayout, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2, Button button, Button button2) {
            this.a = walletPageActivity;
            this.b = swipeRefreshLayout;
            this.c = frameLayout;
            this.d = linearLayout;
            this.e = textView;
            this.f = textView2;
            this.g = button;
            this.h = button2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(WalletPage walletPage) {
            DeepLink deepLink;
            WalletPage walletPage2 = walletPage;
            if (walletPage2 != null) {
                Views.show(this.b);
                Views.hide(this.c);
                Views.hide(this.d);
                ActionBar supportActionBar = this.a.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle(walletPage2.getTitle());
                }
                TextView textView = this.e;
                if (textView != null) {
                    textView.setText(walletPage2.getBalance().getMoney());
                }
                String bonus = walletPage2.getBalance().getBonus();
                if (bonus != null) {
                    String c3 = a2.b.a.a.a.c3("+ ", bonus);
                    Views.show(this.f);
                    TextView textView2 = this.f;
                    Intrinsics.checkNotNullExpressionValue(textView2, "bonusBalanceTextView");
                    textView2.setText(c3);
                } else {
                    Views.conceal(this.f);
                }
                Action primaryAction = walletPage2.getPrimaryAction();
                if (primaryAction == null || (deepLink = primaryAction.getDeepLink()) == null) {
                    Views.conceal(this.g);
                } else {
                    Views.show(this.g);
                    this.g.setOnClickListener(new a2.a.a.t1.f.a(deepLink, this));
                }
                this.h.setOnClickListener(new a2.a.a.t1.f.b(this));
            }
        }
    }

    public static final class d<T> implements Observer<Unit> {
        public final /* synthetic */ SwipeRefreshLayout a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ LinearLayout c;

        public d(SwipeRefreshLayout swipeRefreshLayout, FrameLayout frameLayout, LinearLayout linearLayout) {
            this.a = swipeRefreshLayout;
            this.b = frameLayout;
            this.c = linearLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            if (unit != null) {
                Views.hide(this.a);
                Views.show(this.b);
                Views.hide(this.c);
            }
        }
    }

    public static final class e<T> implements Observer<ErrorResult> {
        public final /* synthetic */ SwipeRefreshLayout a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ LinearLayout c;
        public final /* synthetic */ TextView d;

        public e(SwipeRefreshLayout swipeRefreshLayout, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView) {
            this.a = swipeRefreshLayout;
            this.b = frameLayout;
            this.c = linearLayout;
            this.d = textView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(ErrorResult errorResult) {
            ErrorResult errorResult2 = errorResult;
            if (errorResult2 != null) {
                Views.hide(this.a);
                Views.hide(this.b);
                Views.show(this.c);
                TextView textView = this.d;
                Intrinsics.checkNotNullExpressionValue(textView, "errorTextView");
                textView.setText(errorResult2.getMessage());
            }
        }
    }

    public static final class f<T> implements Observer<Boolean> {
        public final /* synthetic */ SwipeRefreshLayout a;

        public f(SwipeRefreshLayout swipeRefreshLayout) {
            this.a = swipeRefreshLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            Boolean bool2 = bool;
            if (bool2 != null) {
                bool2.booleanValue();
                SwipeRefreshLayout swipeRefreshLayout = this.a;
                Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
                swipeRefreshLayout.setRefreshing(bool2.booleanValue());
            }
        }
    }

    public static final /* synthetic */ WalletPageViewModel access$getWalletPageViewModel$p(WalletPageActivity walletPageActivity) {
        WalletPageViewModel walletPageViewModel = walletPageActivity.k;
        if (walletPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        return walletPageViewModel;
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final WalletPageViewModelFactory getWalletPageViewModelFactory() {
        WalletPageViewModelFactory walletPageViewModelFactory2 = this.walletPageViewModelFactory;
        if (walletPageViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModelFactory");
        }
        return walletPageViewModelFactory2;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 0) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            WalletPageViewModel walletPageViewModel = this.k;
            if (walletPageViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
            }
            walletPageViewModel.getWalletInfo(true);
        } else if (i2 == 0 && intent != null && intent.hasExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT)) {
            String stringExtra = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT);
            Toast.makeText(this, "TOP UP FAIL: " + stringExtra, 1).show();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerWalletPageComponent.builder().paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).walletPageModule(new WalletPageModule()).build().inject(this);
        WalletPageViewModelFactory walletPageViewModelFactory2 = this.walletPageViewModelFactory;
        if (walletPageViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, walletPageViewModelFactory2).get(WalletPageViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.k = (WalletPageViewModel) viewModel;
        setContentView(R.layout.wallet_page_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        TextView textView = (TextView) findViewById(R.id.wallet_balance_money);
        TextView textView2 = (TextView) findViewById(R.id.wallet_balance_bonus);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wallet_page_error);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.wallet_page_loading_indicator);
        Button button = (Button) findViewById(R.id.wallet_balance_top_up_button);
        Button button2 = (Button) findViewById(R.id.wallet_balance_operations_history_button);
        TextView textView3 = (TextView) findViewById(R.id.error_text_view);
        Button button3 = (Button) findViewById(R.id.error_refresh_button);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(this, com.avito.android.lib.design.R.attr.white));
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setColorFilter(Contexts.getColorByAttr(this, com.avito.android.lib.design.R.attr.black), PorterDuff.Mode.SRC_ATOP);
        }
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        button3.setOnClickListener(new a(this));
        swipeRefreshLayout.setOnRefreshListener(new b(this));
        WalletPageViewModel walletPageViewModel = this.k;
        if (walletPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        walletPageViewModel.getWalletPage().observe(this, new c(this, swipeRefreshLayout, frameLayout, linearLayout, textView, textView2, button, button2));
        WalletPageViewModel walletPageViewModel2 = this.k;
        if (walletPageViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        walletPageViewModel2.getInitialLoading().observe(this, new d(swipeRefreshLayout, frameLayout, linearLayout));
        WalletPageViewModel walletPageViewModel3 = this.k;
        if (walletPageViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        walletPageViewModel3.getError().observe(this, new e(swipeRefreshLayout, frameLayout, linearLayout, textView3));
        WalletPageViewModel walletPageViewModel4 = this.k;
        if (walletPageViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        walletPageViewModel4.isRefreshing().observe(this, new f(swipeRefreshLayout));
        if (bundle == null) {
            WalletPageViewModel walletPageViewModel5 = this.k;
            if (walletPageViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
            }
            WalletPageViewModel.getWalletInfo$default(walletPageViewModel5, false, 1, null);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.os.Parcelable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // android.app.Activity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRestoreInstanceState(@org.jetbrains.annotations.NotNull android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r0 = "savedInstanceState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            super.onRestoreInstanceState(r4)
            com.avito.android.payment.wallet.WalletPageViewModel r0 = r3.k
            java.lang.String r1 = "walletPageViewModel"
            if (r0 != 0) goto L_0x0011
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0011:
            androidx.lifecycle.MutableLiveData r0 = r0.getMutableWalletPage()
            java.lang.String r2 = "STATE_WALLET_PAGE"
            android.os.Parcelable r2 = r4.getParcelable(r2)
            r0.setValue(r2)
            com.avito.android.payment.wallet.WalletPageViewModel r0 = r3.k
            if (r0 != 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0025:
            androidx.lifecycle.MutableLiveData r0 = r0.getMutableError()
            java.lang.String r1 = "STATE_ERROR_RESULT"
            android.os.Parcelable r4 = r4.getParcelable(r1)
            r0.setValue(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.payment.wallet.WalletPageActivity.onRestoreInstanceState(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        WalletPageViewModel walletPageViewModel = this.k;
        if (walletPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        bundle.putParcelable("STATE_WALLET_PAGE", walletPageViewModel.getWalletPage().getValue());
        WalletPageViewModel walletPageViewModel2 = this.k;
        if (walletPageViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPageViewModel");
        }
        bundle.putParcelable("STATE_ERROR_RESULT", walletPageViewModel2.getError().getValue());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setWalletPageViewModelFactory(@NotNull WalletPageViewModelFactory walletPageViewModelFactory2) {
        Intrinsics.checkNotNullParameter(walletPageViewModelFactory2, "<set-?>");
        this.walletPageViewModelFactory = walletPageViewModelFactory2;
    }
}
