package com.avito.android.analytics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.analytics.di.ClickStreamDeepLinkingDependencies;
import com.avito.android.analytics.di.DaggerClickStreamDeepLinkingComponent;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/analytics/ClickStreamDeepLinkActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "clickStreamLinkHandler", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "getClickStreamLinkHandler", "()Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "setClickStreamLinkHandler", "(Lcom/avito/android/deep_linking/ClickStreamLinkHandler;)V", "<init>", "()V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamDeepLinkActivity extends Activity {
    @Inject
    public ClickStreamLinkHandler clickStreamLinkHandler;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;

    public static final class a extends Lambda implements Function1<DeepLink, Unit> {
        public final /* synthetic */ ClickStreamDeepLinkActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ClickStreamDeepLinkActivity clickStreamDeepLinkActivity) {
            super(1);
            this.a = clickStreamDeepLinkActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullParameter(deepLink2, "redirectDeeplink");
            Intent intent = this.a.getDeepLinkIntentFactory().getIntent(deepLink2);
            if (intent != null) {
                this.a.startActivity(intent);
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final ClickStreamLinkHandler getClickStreamLinkHandler() {
        ClickStreamLinkHandler clickStreamLinkHandler2 = this.clickStreamLinkHandler;
        if (clickStreamLinkHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickStreamLinkHandler");
        }
        return clickStreamLinkHandler2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerClickStreamDeepLinkingComponent.factory().create((ClickStreamDeepLinkingDependencies) ComponentDependenciesKt.getDependencies(ClickStreamDeepLinkingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).inject(this);
        ClickStreamLinkHandler clickStreamLinkHandler2 = this.clickStreamLinkHandler;
        if (clickStreamLinkHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickStreamLinkHandler");
        }
        Parcelable parcelableExtra = getIntent().getParcelableExtra("click_stream_deeplink");
        Intrinsics.checkNotNull(parcelableExtra);
        clickStreamLinkHandler2.handleDeepLink((ClickStreamLink) parcelableExtra, new a(this));
        finish();
    }

    public final void setClickStreamLinkHandler(@NotNull ClickStreamLinkHandler clickStreamLinkHandler2) {
        Intrinsics.checkNotNullParameter(clickStreamLinkHandler2, "<set-?>");
        this.clickStreamLinkHandler = clickStreamLinkHandler2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }
}
