package com.avito.android.shop.write_seller;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.write_seller.di.DaggerWriteSellerComponent;
import com.avito.android.shop.write_seller.di.WriteSellerComponent;
import com.avito.android.shop.write_seller.di.WriteSellerModule;
import com.avito.android.ui.activity.BaseActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/shop/write_seller/WriteSellerRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "setUpCustomToolbar", "()Z", "state", "onSaveInstanceState", "onDestroy", "closeScreen", "Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "presenter", "Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "getPresenter", "()Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "setPresenter", "(Lcom/avito/android/shop/write_seller/WriteSellerPresenter;)V", "<init>", "IntentFactory", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class WriteSellerActivity extends BaseActivity implements WriteSellerRouter {
    @Inject
    public WriteSellerPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerActivity$IntentFactory;", "", "Landroid/content/Context;", "context", "", "shopId", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class IntentFactory {
        @NotNull
        public final Intent create(@NotNull Context context, @NotNull String str) {
            return a.j1(context, "context", str, "shopId", context, WriteSellerActivity.class, "shopId", str, "context.createActivityIn…putExtra(SHOP_ID, shopId)");
        }
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerRouter
    public void closeScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.write_seller_layout;
    }

    @NotNull
    public final WriteSellerPresenter getPresenter() {
        WriteSellerPresenter writeSellerPresenter = this.presenter;
        if (writeSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return writeSellerPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        showDefaultActionBar(getString(R.string.write_email));
        View containerView = getContainerView();
        WriteSellerPresenter writeSellerPresenter = this.presenter;
        if (writeSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        WriteSellerViewImpl writeSellerViewImpl = new WriteSellerViewImpl(containerView, this, writeSellerPresenter);
        WriteSellerPresenter writeSellerPresenter2 = this.presenter;
        if (writeSellerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        writeSellerPresenter2.attachView(writeSellerViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WriteSellerPresenter writeSellerPresenter = this.presenter;
        if (writeSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        writeSellerPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "state");
        WriteSellerPresenter writeSellerPresenter = this.presenter;
        if (writeSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        writeSellerPresenter.onSaveState(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        WriteSellerPresenter writeSellerPresenter = this.presenter;
        if (writeSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        writeSellerPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        WriteSellerPresenter writeSellerPresenter = this.presenter;
        if (writeSellerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        writeSellerPresenter.detachRouter();
        super.onStop();
    }

    public final void setPresenter(@NotNull WriteSellerPresenter writeSellerPresenter) {
        Intrinsics.checkNotNullParameter(writeSellerPresenter, "<set-?>");
        this.presenter = writeSellerPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("shopId");
        WriteSellerComponent.Builder shopDetailedDependencies = DaggerWriteSellerComponent.builder().shopDetailedDependencies((ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Intrinsics.checkNotNullExpressionValue(stringExtra, "shopId");
        shopDetailedDependencies.writeSellerModule(new WriteSellerModule(this, stringExtra, bundle)).build().inject(this);
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}
