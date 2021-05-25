package com.avito.android.publish.cpa_tariff;

import a2.g.r.g;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.LinkAttribute;
import com.avito.android.util.text.TextViewsKt;
import com.google.android.material.snackbar.Snackbar;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithTextAction;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00120\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\rR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010&¨\u00062"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffViewImpl;", "Lcom/avito/android/publish/cpa_tariff/CpaTariffView;", "", "name", "phone", "", "fillFieldsWithContactInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "handleNameInputError", "()V", "handlePhoneInputError", "message", "handleRequestError", "(Ljava/lang/String;)V", "stopLoading", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "submitButtonClicks", "errorMessage", "showErrorInSnackBar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "disclaimer", g.a, "subtitleView", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", AuthSource.BOOKING_ORDER, "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", "appBar", "Lcom/avito/android/lib/design/input/Input;", "c", "Lcom/avito/android/lib/design/input/Input;", "nameView", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", AuthSource.SEND_ABUSE, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "rootView", "d", "phoneView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffViewImpl implements CpaTariffView {
    public final CoordinatorLayout a;
    public AppBarLayoutWithTextAction b;
    public Input c;
    public Input d;
    public Button e;
    public TextView f;
    public final TextView g;

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
                ((CpaTariffViewImpl) this.b).c.setState(Input.Companion.getSTATE_NORMAL());
                return Unit.INSTANCE;
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(str, "it");
                ((CpaTariffViewImpl) this.b).d.setState(Input.Companion.getSTATE_NORMAL());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements ObservableOnSubscribe<Pair<? extends String, ? extends String>> {
        public final /* synthetic */ CpaTariffViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.e.setOnClickListener(null);
            }
        }

        /* renamed from: com.avito.android.publish.cpa_tariff.CpaTariffViewImpl$b$b  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0151b implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ ObservableEmitter b;

            public View$OnClickListenerC0151b(b bVar, ObservableEmitter observableEmitter) {
                this.a = bVar;
                this.b = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a.e.setLoading(true);
                this.b.onNext(new Pair(this.a.a.c.getDeformattedText(), this.a.a.d.getDeformattedText()));
            }
        }

        public b(CpaTariffViewImpl cpaTariffViewImpl) {
            this.a = cpaTariffViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.rxjava3.core.ObservableEmitter<kotlin.Pair<java.lang.String, java.lang.String>>] */
        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Pair<? extends String, ? extends String>> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.e.setOnClickListener(new View$OnClickListenerC0151b(this, observableEmitter));
        }
    }

    public CpaTariffViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.cpa_tariff_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cpa_tariff_root)");
        this.a = (CoordinatorLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.app_bar)");
        this.b = (AppBarLayoutWithTextAction) findViewById2;
        View findViewById3 = view.findViewById(R.id.input_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.input_name)");
        this.c = (Input) findViewById3;
        View findViewById4 = view.findViewById(R.id.input_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.input_phone)");
        this.d = (Input) findViewById4;
        View findViewById5 = view.findViewById(R.id.cpa_tariff_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.cpa_tariff_button)");
        this.e = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.cpa_tariff_disclaimer);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.cpa_tariff_disclaimer)");
        this.f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.subtitle)");
        TextView textView = (TextView) findViewById7;
        this.g = textView;
        InputExtensionsKt.addTextChangedListener(this.c, new a(0, this));
        InputExtensionsKt.addTextChangedListener(this.d, new a(1, this));
        TextView textView2 = this.f;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        String string = resources.getString(R.string.cpa_tariff_disclaimer_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…a_tariff_disclaimer_text)");
        String string2 = resources.getString(R.string.cpa_tariff_disclaimer_link_name);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…iff_disclaimer_link_name)");
        String string3 = resources.getString(R.string.cpa_tariff_disclaimer_link_text);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…iff_disclaimer_link_text)");
        String string4 = resources.getString(R.string.cpa_tariff_disclaimer_link_url);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…riff_disclaimer_link_url)");
        TextViewsKt.setAttributedText$default(textView2, new AttributedText(string, d.listOf(new LinkAttribute(string2, string3, string4))), null, 2, null);
        this.f.setMovementMethod(LinkMovementMethod.getInstance());
        Resources resources2 = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        String string5 = resources2.getString(R.string.cpa_tariff_description_text);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…_tariff_description_text)");
        String string6 = resources2.getString(R.string.cpa_tariff_description_link_name);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st…ff_description_link_name)");
        String string7 = resources2.getString(R.string.cpa_tariff_description_link_text);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.st…ff_description_link_text)");
        String string8 = resources2.getString(R.string.cpa_tariff_description_link_url);
        Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(R.st…iff_description_link_url)");
        TextViewsKt.setAttributedText$default(textView, new AttributedText(string5, d.listOf(new LinkAttribute(string6, string7, string8))), null, 2, null);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.b.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        this.b.setTitle(view.getResources().getString(R.string.cpa_tariff_title));
        AppBarLayoutWithTextAction appBarLayoutWithTextAction = this.b;
        appBarLayoutWithTextAction.setShortTitle(appBarLayoutWithTextAction.getTitle());
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    public void fillFieldsWithContactInfo(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            Input.setText$default(this.c, str, false, 2, null);
        }
        if (str2 != null) {
            Input.setText$default(this.d, str2, false, 2, null);
        }
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    public void handleNameInputError() {
        stopLoading();
        this.c.setState(Input.Companion.getSTATE_ERROR());
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    public void handlePhoneInputError() {
        stopLoading();
        this.d.setState(Input.Companion.getSTATE_ERROR());
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    public void handleRequestError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        stopLoading();
        showErrorInSnackBar(str);
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    public void showErrorInSnackBar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Snackbar.make(this.a, str, -1).show();
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    public void stopLoading() {
        this.e.setLoading(false);
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    @NotNull
    public Observable<Pair<String, String>> submitButtonClicks() {
        Observable<Pair<String, String>> create = Observable.create(new b(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…dText()))\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.publish.cpa_tariff.CpaTariffView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        Observable<Unit> create = Observable.create(new CpaTariffViewImpl$upButtonClicks$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }
}
