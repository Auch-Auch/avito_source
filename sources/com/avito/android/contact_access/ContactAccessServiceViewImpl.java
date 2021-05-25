package com.avito.android.contact_access;

import a2.g.r.g;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.CollapsingTitleAppBarLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000eR\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0019\u0010-\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u00100\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0019\u00109\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b8\u0010,R\u0019\u0010?\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServiceViewImpl;", "Lcom/avito/android/contact_access/ContactAccessServiceView;", "", "showProgress", "()V", "hideProgress", "Lcom/avito/android/contact_access/PresentationAccessServiceModel;", "presentationModel", "setContent", "(Lcom/avito/android/contact_access/PresentationAccessServiceModel;)V", "networkError", "", "message", "serverError", "(Ljava/lang/String;)V", "", "formattedText", "setUpLegalTextView", "(Ljava/lang/CharSequence;)V", "showSnackbar", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", g.a, "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "getAppBar", "()Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "appBar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "i", "Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "presenter", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "name", "d", "getAgreementText", "agreementText", "Landroid/view/View;", "e", "Landroid/view/View;", "getContinueButton", "()Landroid/view/View;", "continueButton", "c", "getPrice", "price", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/contact_access/ContactAccessServicePresenter;Lcom/avito/android/analytics/Analytics;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessServiceViewImpl implements ContactAccessServiceView {
    @NotNull
    public final Context a;
    @NotNull
    public final TextView b;
    @NotNull
    public final TextView c;
    @NotNull
    public final TextView d;
    @NotNull
    public final View e;
    @NotNull
    public final ProgressOverlay f;
    @NotNull
    public final CollapsingTitleAppBarLayout g;
    public final ViewGroup h;
    public final ContactAccessServicePresenter i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ContactAccessServiceViewImpl a;

        public a(ContactAccessServiceViewImpl contactAccessServiceViewImpl) {
            this.a = contactAccessServiceViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.i.onContinueClicked();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ContactAccessServiceViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ContactAccessServiceViewImpl contactAccessServiceViewImpl) {
            super(0);
            this.a = contactAccessServiceViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i.retry();
            return Unit.INSTANCE;
        }
    }

    public ContactAccessServiceViewImpl(@NotNull ViewGroup viewGroup, @NotNull ContactAccessServicePresenter contactAccessServicePresenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(contactAccessServicePresenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = viewGroup;
        this.i = contactAccessServicePresenter;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        View findViewById = viewGroup.findViewById(R.id.name);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.agreement_text);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.select_payment_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.progress_root);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.progress_root)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById5, R.id.content_container, analytics, false, 0, 24, null);
        this.f = progressOverlay;
        View findViewById6 = viewGroup.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type ru.avito.component.toolbar.CollapsingTitleAppBarLayout");
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = (CollapsingTitleAppBarLayout) findViewById6;
        this.g = collapsingTitleAppBarLayout;
        findViewById4.setOnClickListener(new a(this));
        progressOverlay.setOnRefreshListener(new b(this));
        collapsingTitleAppBarLayout.setClickListener(new AppbarClickListener(this) { // from class: com.avito.android.contact_access.ContactAccessServiceViewImpl.3
            public final /* synthetic */ ContactAccessServiceViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                this.a.i.close();
            }
        });
    }

    @NotNull
    public final TextView getAgreementText() {
        return this.d;
    }

    @NotNull
    public final CollapsingTitleAppBarLayout getAppBar() {
        return this.g;
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    @NotNull
    public final View getContinueButton() {
        return this.e;
    }

    @NotNull
    public final TextView getName() {
        return this.b;
    }

    @NotNull
    public final TextView getPrice() {
        return this.c;
    }

    @NotNull
    public final ProgressOverlay getProgressOverlay() {
        return this.f;
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceView
    public void hideProgress() {
        this.f.showContent();
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceView
    public void networkError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceView
    public void serverError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
        ToastsKt.showToast$default(this.a, str, 0, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    @Override // com.avito.android.contact_access.ContactAccessServiceView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setContent(@org.jetbrains.annotations.NotNull com.avito.android.contact_access.PresentationAccessServiceModel r6) {
        /*
            r5 = this;
            java.lang.String r0 = "presentationModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r0 = r5.e
            com.avito.android.util.Views.show(r0)
            ru.avito.component.toolbar.CollapsingTitleAppBarLayout r0 = r5.g
            r1 = 1
            r0.setExpanded(r1)
            ru.avito.component.toolbar.CollapsingTitleAppBarLayout r0 = r5.g
            java.lang.String r2 = r6.getServiceTitle()
            r0.setTitle(r2)
            ru.avito.component.toolbar.CollapsingTitleAppBarLayout r0 = r5.g
            java.lang.String r2 = r6.getServiceTitle()
            r0.setShortTitle(r2)
            java.lang.String r0 = r6.getServiceSubtitle()
            r2 = 0
            if (r0 == 0) goto L_0x0036
            int r3 = r0.length()
            if (r3 <= 0) goto L_0x0031
            r3 = 1
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x003e
            ru.avito.component.toolbar.CollapsingTitleAppBarLayout r3 = r5.g
            r3.setSubTitle(r0)
        L_0x003e:
            android.widget.TextView r0 = r5.b
            java.lang.String r3 = r6.getName()
            r0.setText(r3)
            android.widget.TextView r0 = r5.c
            android.content.Context r3 = r5.a
            int r4 = com.avito.android.contact_access.R.string.final_price_template
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r6 = r6.getPrice()
            r1[r2] = r6
            java.lang.String r6 = r3.getString(r4, r1)
            r0.setText(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.contact_access.ContactAccessServiceViewImpl.setContent(com.avito.android.contact_access.PresentationAccessServiceModel):void");
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceView
    public void setUpLegalTextView(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            Views.hide(this.d);
            return;
        }
        Views.show(this.d);
        TextView textView = this.d;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(charSequence);
        Views.show(textView);
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceView
    public void showProgress() {
        this.f.showLoading();
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.h, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
