package com.avito.android.advert.consultation_form;

import a2.g.r.g;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_details.R;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.FormInput;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.LinkAttribute;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.TextViewsKt;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithTextAction;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00130\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010(R\u0016\u0010D\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010;¨\u0006I"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewImpl;", "Lcom/avito/android/advert/consultation_form/ConsultationFormView;", "", "name", "phone", "", "fillFieldsWithContactInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "errorMessage", "handleNameInputError", "(Ljava/lang/String;)V", "handlePhoneInputError", "message", "handleRequestError", "stopLoading", "()V", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "submitButtonClicks", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLinkClicks", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/ConsultationFormData;", "form", "initiateWithData", "(Lcom/avito/android/remote/model/ConsultationFormData;)V", "showErrorInSnackBar", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/lib/design/button/Button;", g.a, "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "c", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "nameContainer", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "k", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "deepLinksSubscription", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "rootView", "Lcom/avito/android/lib/design/input/Input;", "f", "Lcom/avito/android/lib/design/input/Input;", "phoneView", "d", "nameView", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "disclaimer", "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", AuthSource.BOOKING_ORDER, "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", "appBar", "e", "phoneContainer", "i", "subtitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormViewImpl implements ConsultationFormView {
    public final CoordinatorLayout a;
    public AppBarLayoutWithTextAction b;
    public final ComponentContainer c;
    public Input d;
    public final ComponentContainer e;
    public Input f;
    public Button g;
    public TextView h;
    public final TextView i;
    public final PublishRelay<DeepLink> j;
    public final CompositeDisposable k = new CompositeDisposable();

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullParameter(str, "it");
                ((ConsultationFormViewImpl) this.b).d.setState(Input.Companion.getSTATE_NORMAL());
                return Unit.INSTANCE;
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(str, "it");
                ((ConsultationFormViewImpl) this.b).f.setState(Input.Companion.getSTATE_NORMAL());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ ConsultationFormViewImpl a;

        public b(ConsultationFormViewImpl consultationFormViewImpl) {
            this.a = consultationFormViewImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.k.dispose();
        }
    }

    public static final class c<T> implements ObservableOnSubscribe<Pair<? extends String, ? extends String>> {
        public final /* synthetic */ ConsultationFormViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.g.setOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ c a;
            public final /* synthetic */ ObservableEmitter b;

            public b(c cVar, ObservableEmitter observableEmitter) {
                this.a = cVar;
                this.b = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a.g.setLoading(true);
                this.b.onNext(new Pair(this.a.a.d.getDeformattedText(), this.a.a.f.getDeformattedText()));
            }
        }

        public c(ConsultationFormViewImpl consultationFormViewImpl) {
            this.a = consultationFormViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.rxjava3.core.ObservableEmitter<kotlin.Pair<java.lang.String, java.lang.String>>] */
        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Pair<? extends String, ? extends String>> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.g.setOnClickListener(new b(this, observableEmitter));
        }
    }

    public static final class d<T> implements Consumer<DeepLink> {
        public final /* synthetic */ ConsultationFormViewImpl a;

        public d(ConsultationFormViewImpl consultationFormViewImpl) {
            this.a = consultationFormViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            this.a.j.accept(deepLink);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Error in subscription to attributedText ", th);
        }
    }

    public ConsultationFormViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.consultation_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.consultation_root)");
        this.a = (CoordinatorLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.app_bar)");
        this.b = (AppBarLayoutWithTextAction) findViewById2;
        View findViewById3 = view.findViewById(R.id.container_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.container_name)");
        this.c = (ComponentContainer) findViewById3;
        View findViewById4 = view.findViewById(R.id.input_name);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.input_name)");
        this.d = (Input) findViewById4;
        View findViewById5 = view.findViewById(R.id.container_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.container_phone)");
        this.e = (ComponentContainer) findViewById5;
        View findViewById6 = view.findViewById(R.id.input_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.input_phone)");
        this.f = (Input) findViewById6;
        View findViewById7 = view.findViewById(R.id.consultation_button);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.consultation_button)");
        this.g = (Button) findViewById7;
        View findViewById8 = view.findViewById(R.id.consultation_disclaimer);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.consultation_disclaimer)");
        this.h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.subtitle)");
        TextView textView = (TextView) findViewById9;
        this.i = textView;
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
        InputExtensionsKt.addTextChangedListener(this.d, new a(0, this));
        InputExtensionsKt.addTextChangedListener(this.f, new a(1, this));
        TextView textView2 = this.h;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        String string = resources.getString(R.string.consultation_form_disclaimer_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ion_form_disclaimer_text)");
        String string2 = resources.getString(R.string.consultation_form_disclaimer_link_name);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…orm_disclaimer_link_name)");
        String string3 = resources.getString(R.string.consultation_form_disclaimer_link_text);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…orm_disclaimer_link_text)");
        String string4 = resources.getString(R.string.consultation_form_disclaimer_link_url);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…form_disclaimer_link_url)");
        TextViewsKt.setAttributedText$default(textView2, new AttributedText(string, t6.n.d.listOf(new LinkAttribute(string2, string3, string4))), null, 2, null);
        this.h.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.b.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        this.b.setTitle(view.getResources().getString(R.string.consultation_form_title));
        AppBarLayoutWithTextAction appBarLayoutWithTextAction = this.b;
        appBarLayoutWithTextAction.setShortTitle(appBarLayoutWithTextAction.getTitle());
        create.doOnDispose(new b(this));
    }

    public final void a(AttributedText attributedText) {
        CompositeDisposable compositeDisposable = this.k;
        Disposable subscribe = InteropKt.toV3(attributedText.linkClicks()).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "attributedText.linkClick…)\n            }\n        )");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void fillFieldsWithContactInfo(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            Input.setText$default(this.d, str, false, 2, null);
        }
        if (str2 != null) {
            Input.setText$default(this.f, str2, false, 2, null);
        }
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void handleNameInputError(@Nullable String str) {
        stopLoading();
        if (str == null) {
            this.d.setState(Input.Companion.getSTATE_ERROR());
        } else {
            this.c.showErrorForAll(str, ComponentContainer.Condition.ALL_RESET);
        }
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void handlePhoneInputError(@Nullable String str) {
        stopLoading();
        if (str == null) {
            this.f.setState(Input.Companion.getSTATE_ERROR());
        } else {
            this.e.showErrorForAll(str, ComponentContainer.Condition.ALL_RESET);
        }
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void handleRequestError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        stopLoading();
        showErrorInSnackBar(str);
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void initiateWithData(@NotNull ConsultationFormData consultationFormData) {
        Intrinsics.checkNotNullParameter(consultationFormData, "form");
        String title = consultationFormData.getTitle();
        if (title != null) {
            this.b.setTitle(title);
            this.b.setShortTitle(title);
        }
        String subtitle = consultationFormData.getSubtitle();
        if (subtitle != null) {
            this.i.setText(subtitle);
        }
        AttributedText attributedSubtitle = consultationFormData.getAttributedSubtitle();
        if (attributedSubtitle != null) {
            TextViewsKt.setAttributedText$default(this.i, attributedSubtitle, null, 2, null);
            a(attributedSubtitle);
        }
        FormInput nameInput = consultationFormData.getNameInput();
        if (nameInput != null) {
            this.c.setTitle(nameInput.getTitle());
            this.d.setHint(nameInput.getHint());
            Input.setText$default(this.d, nameInput.getData(), false, 2, null);
        }
        FormInput phoneInput = consultationFormData.getPhoneInput();
        if (phoneInput != null) {
            this.e.setTitle(phoneInput.getTitle());
            this.f.setHint(phoneInput.getHint());
            Input.setText$default(this.f, phoneInput.getData(), false, 2, null);
        }
        AttributedText policy = consultationFormData.getPolicy();
        if (policy != null) {
            TextViewsKt.setAttributedText$default(this.h, policy, null, 2, null);
            a(policy);
        }
        String buttonTitle = consultationFormData.getButtonTitle();
        if (buttonTitle != null) {
            this.g.setText(buttonTitle);
        }
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void showErrorInSnackBar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Snackbar.make(this.a, str, -1).show();
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    public void stopLoading() {
        this.g.setLoading(false);
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    @NotNull
    public Observable<Pair<String, String>> submitButtonClicks() {
        Observable<Pair<String, String>> create = Observable.create(new c(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…dText()))\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        Observable<Unit> create = Observable.create(new ConsultationFormViewImpl$upButtonClicks$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.advert.consultation_form.ConsultationFormView
    @NotNull
    public PublishRelay<DeepLink> deepLinkClicks() {
        return this.j;
    }
}
