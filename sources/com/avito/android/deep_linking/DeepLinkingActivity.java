package com.avito.android.deep_linking;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.avito.android.CalledFrom;
import com.avito.android.deep_linking.di.DaggerDeepLinkingComponent;
import com.avito.android.deep_linking.di.DeepLinkingDependencies;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lastclick.LastClick;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.ui_components.R;
import com.avito.android.util.Intents;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkingActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;", "deepLinkContainerIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;", "getDeepLinkContainerIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;", "setDeepLinkContainerIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkingPresenter;", "presenter", "Lcom/avito/android/deep_linking/DeepLinkingPresenter;", "getPresenter", "()Lcom/avito/android/deep_linking/DeepLinkingPresenter;", "setPresenter", "(Lcom/avito/android/deep_linking/DeepLinkingPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "()V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkingActivity extends Activity {
    @Inject
    public DeepLinkContainerIntentFactory deepLinkContainerIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DeepLinkingPresenter presenter;

    @NotNull
    public final DeepLinkContainerIntentFactory getDeepLinkContainerIntentFactory() {
        DeepLinkContainerIntentFactory deepLinkContainerIntentFactory2 = this.deepLinkContainerIntentFactory;
        if (deepLinkContainerIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkContainerIntentFactory");
        }
        return deepLinkContainerIntentFactory2;
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
    public final DeepLinkingPresenter getPresenter() {
        DeepLinkingPresenter deepLinkingPresenter = this.presenter;
        if (deepLinkingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return deepLinkingPresenter;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LastClick.Updater.updateFromDeeplink();
        DaggerDeepLinkingComponent.builder().deepLinkDependencies((DeepLinkingDependencies) ComponentDependenciesKt.getDependencies(DeepLinkingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withRouter(new DeepLinkingRouter() { // from class: com.avito.android.deep_linking.DeepLinkingActivity$createRouter$1
            @Override // com.avito.android.deep_linking.DeepLinkingRouter
            public boolean openDeepLink(@NotNull DeepLink deepLink, @NotNull CalledFrom.AppLinking appLinking) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                Intrinsics.checkNotNullParameter(appLinking, "calledFrom");
                Intent intent = DeepLinkingActivity.this.getDeepLinkIntentFactory().getIntent(deepLink);
                if (intent == null) {
                    return false;
                }
                Intents.setCalledFrom(intent, appLinking);
                try {
                    DeepLinkingActivity.this.startActivity(IntentsKt.makeSafeForExternalApps(intent));
                    return true;
                } catch (Exception unused) {
                    ToastsKt.showToast$default(DeepLinkingActivity.this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
                    return false;
                }
            }

            @Override // com.avito.android.deep_linking.DeepLinkingRouter
            @NotNull
            public List<Boolean> openDeepLinkPackage(@NotNull DeepLinkContainer deepLinkContainer, @NotNull CalledFrom.AppLinking appLinking) {
                Intrinsics.checkNotNullParameter(deepLinkContainer, "deepLinkContainer");
                Intrinsics.checkNotNullParameter(appLinking, "calledFrom");
                List<Intent> intents = DeepLinkingActivity.this.getDeepLinkContainerIntentFactory().getIntents(deepLinkContainer);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(intents, 10));
                for (T t : intents) {
                    Intents.setCalledFrom(t, appLinking);
                    boolean z = false;
                    try {
                        DeepLinkingActivity.this.startActivity(IntentsKt.makeSafeForExternalApps(t));
                        z = true;
                    } catch (Exception unused) {
                        ToastsKt.showToast$default(DeepLinkingActivity.this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
                    }
                    arrayList.add(Boolean.valueOf(z));
                }
                DeepLinkingActivity.this.finish();
                return arrayList;
            }
        }).build().inject(this);
        DeepLinkingPresenter deepLinkingPresenter = this.presenter;
        if (deepLinkingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Uri data = intent.getData();
        Intrinsics.checkNotNull(data);
        Intrinsics.checkNotNullExpressionValue(data, "intent.data!!");
        deepLinkingPresenter.start(data);
    }

    public final void setDeepLinkContainerIntentFactory(@NotNull DeepLinkContainerIntentFactory deepLinkContainerIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkContainerIntentFactory2, "<set-?>");
        this.deepLinkContainerIntentFactory = deepLinkContainerIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull DeepLinkingPresenter deepLinkingPresenter) {
        Intrinsics.checkNotNullParameter(deepLinkingPresenter, "<set-?>");
        this.presenter = deepLinkingPresenter;
    }
}
