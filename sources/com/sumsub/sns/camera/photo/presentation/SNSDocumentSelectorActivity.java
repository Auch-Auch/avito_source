package com.sumsub.sns.camera.photo.presentation;

import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.transition.TransitionManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.camera.SNSCameraActivity;
import com.sumsub.sns.camera.photo.R;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.data.model.IdentityTypeKt;
import com.sumsub.sns.core.presentation.BaseActivity;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.dialog.SupportBottomSheet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000210B\u0007¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u00028T@\u0014X\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0016\u0010'\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0016\u0010+\u001a\u00020(8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b,\u0010\u0019¨\u00062"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/SNSDocumentSelectorActivity;", "Lcom/sumsub/sns/core/presentation/BaseActivity;", "Lcom/sumsub/sns/camera/photo/presentation/SNSDocumentSelectorViewModel;", "", "getLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/widget/AutoCompleteTextView;", "h", "Landroid/widget/AutoCompleteTextView;", "edCountry", "Landroid/view/View;", "l", "Landroid/view/View;", "btnClose", "Landroid/view/ViewGroup;", "k", "Landroid/view/ViewGroup;", "vgDocuments", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "tvDocumentsEmpty", "n", "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/camera/photo/presentation/SNSDocumentSelectorViewModel;", "viewModel", "Lcom/google/android/material/textfield/TextInputLayout;", g.a, "Lcom/google/android/material/textfield/TextInputLayout;", "ilCountry", "f", "tvCountryTitle", AuthSource.OPEN_CHANNEL_LIST, "tvFooter", "", AuthSource.SEND_ABUSE, "()Ljava/lang/String;", "documentType", "i", "tvDocumentsTitle", "<init>", "()V", "Companion", "BitapFilterAdapter", "sns-camera-photo-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSDocumentSelectorActivity extends BaseActivity<SNSDocumentSelectorViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_APPLICANT = "extra_applicant";
    @NotNull
    public static final String EXTRA_DOCUMENT_TYPE = "extra_document_type";
    @NotNull
    public static final String RESULT_SELECTED_COUNTRY = "result_selected_country";
    @NotNull
    public static final String RESULT_SELECTED_ID_DOC_TYPE = "result_selected_id_doc_type";
    public TextView f;
    public TextInputLayout g;
    public AutoCompleteTextView h;
    public TextView i;
    public TextView j;
    public ViewGroup k;
    public View l;
    public TextView m;
    @NotNull
    public final Lazy n = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SNSDocumentSelectorViewModel.class), new Function0<ViewModelStore>(this) { // from class: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$$special$$inlined$viewModels$2
        public final /* synthetic */ ComponentActivity a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.a.getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }, new c(this));

    public static final class BitapFilterAdapter extends ArrayAdapter<String> {
        @NotNull
        public final List<String> a;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BitapFilterAdapter(android.content.Context r1, int r2, java.util.List r3, int r4, int r5) {
            /*
                r0 = this;
                r5 = r5 & 8
                if (r5 == 0) goto L_0x0007
                r4 = 16908308(0x1020014, float:2.3877285E-38)
            L_0x0007:
                java.lang.String r5 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
                java.lang.String r5 = "items"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
                r0.<init>(r1, r2, r4)
                r0.a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity.BitapFilterAdapter.<init>(android.content.Context, int, java.util.List, int, int):void");
        }

        @Override // android.widget.ArrayAdapter, android.widget.Filterable
        @NotNull
        public Filter getFilter() {
            return new SNSDocumentSelectorActivity$BitapFilterAdapter$getFilter$1(this);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/SNSDocumentSelectorActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "documentType", "Landroid/content/Intent;", "newIntent", "(Landroid/content/Context;Lcom/sumsub/sns/core/common/SNSSession;Lcom/sumsub/sns/core/data/model/Applicant;Ljava/lang/String;)Landroid/content/Intent;", SNSCameraActivity.EXTRA_APPLICANT, "Ljava/lang/String;", SNSCameraActivity.EXTRA_DOCUMENT_TYPE, "RESULT_SELECTED_COUNTRY", "RESULT_SELECTED_ID_DOC_TYPE", "<init>", "()V", "sns-camera-photo-document-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent newIntent(@NotNull Context context, @NotNull SNSSession sNSSession, @NotNull Applicant applicant, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(str, "documentType");
            Intent intent = new Intent(context, SNSDocumentSelectorActivity.class);
            intent.putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
            intent.putExtra(SNSDocumentSelectorActivity.EXTRA_APPLICANT, applicant);
            intent.putExtra(SNSDocumentSelectorActivity.EXTRA_DOCUMENT_TYPE, str);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ SNSDocumentSelectorActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSDocumentSelectorActivity sNSDocumentSelectorActivity) {
            super(1);
            this.a = sNSDocumentSelectorActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.getViewModel().onLinkClicked(str2);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SNSDocumentSelectorActivity a;

        public b(SNSDocumentSelectorActivity sNSDocumentSelectorActivity) {
            this.a = sNSDocumentSelectorActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onBackPressed();
        }
    }

    public static final class c extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSDocumentSelectorActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSDocumentSelectorActivity sNSDocumentSelectorActivity) {
            super(0);
            this.a = sNSDocumentSelectorActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSDocumentSelectorActivity sNSDocumentSelectorActivity = this.a;
            ServiceLocator serviceLocator = sNSDocumentSelectorActivity.getServiceLocator();
            Intent intent = this.a.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            return new SNSDocumentSelectorViewModelFactory(sNSDocumentSelectorActivity, serviceLocator, intent.getExtras());
        }
    }

    public static final /* synthetic */ AutoCompleteTextView access$getEdCountry$p(SNSDocumentSelectorActivity sNSDocumentSelectorActivity) {
        AutoCompleteTextView autoCompleteTextView = sNSDocumentSelectorActivity.h;
        if (autoCompleteTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("edCountry");
        }
        return autoCompleteTextView;
    }

    public static final void access$inflateDocuments(SNSDocumentSelectorActivity sNSDocumentSelectorActivity, List list) {
        TextView textView = sNSDocumentSelectorActivity.j;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsEmpty");
        }
        textView.setVisibility(8);
        boolean z = true;
        if (!list.isEmpty()) {
            String H = a2.b.a.a.a.H(new Object[]{sNSDocumentSelectorActivity.a()}, 1, SNSConstants.Resources.Key.IDENTITY_SELECTOR_DOCUMENT_TITLE, "java.lang.String.format(format, *args)");
            String string = sNSDocumentSelectorActivity.getString(R.string.sns_step_IDENTITY_selector_iddoc_prompt);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sns_s…TY_selector_iddoc_prompt)");
            String stringResource = ExtensionsKt.getStringResource(sNSDocumentSelectorActivity, H, string);
            if (stringResource.length() <= 0) {
                z = false;
            }
            if (z) {
                TextView textView2 = sNSDocumentSelectorActivity.i;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsTitle");
                }
                textView2.setVisibility(0);
                TextView textView3 = sNSDocumentSelectorActivity.i;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsTitle");
                }
                textView3.setText(stringResource);
            } else {
                TextView textView4 = sNSDocumentSelectorActivity.i;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsTitle");
                }
                textView4.setVisibility(8);
            }
            ViewGroup viewGroup = sNSDocumentSelectorActivity.k;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
            }
            TransitionManager.beginDelayedTransition(viewGroup);
            ViewGroup viewGroup2 = sNSDocumentSelectorActivity.k;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
            }
            viewGroup2.removeAllViews();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String r0 = ((IdentityType) it.next()).m209unboximpl();
                CharSequence r1 = IdentityType.m206getTitleimpl(r0, sNSDocumentSelectorActivity);
                LayoutInflater layoutInflater = sNSDocumentSelectorActivity.getLayoutInflater();
                int i2 = R.layout.sns_list_item_iddoc;
                ViewGroup viewGroup3 = sNSDocumentSelectorActivity.k;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
                }
                View inflate = layoutInflater.inflate(i2, viewGroup3, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "item");
                inflate.setTag(IdentityType.m201boximpl(r0));
                TextView textView5 = (TextView) inflate.findViewById(16908308);
                if (textView5 != null) {
                    textView5.setText(r1);
                }
                ImageView imageView = (ImageView) inflate.findViewById(16908294);
                if (imageView != null) {
                    imageView.setImageResource(IdentityTypeKt.m216getIconwYDFDDU(r0));
                }
                inflate.setOnClickListener(new a2.q.a.b.c.a.a(r0, sNSDocumentSelectorActivity));
                ViewGroup viewGroup4 = sNSDocumentSelectorActivity.k;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
                }
                viewGroup4.addView(inflate);
            }
            ViewGroup viewGroup5 = sNSDocumentSelectorActivity.k;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
            }
            viewGroup5.setVisibility(0);
            return;
        }
        TextView textView6 = sNSDocumentSelectorActivity.i;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsTitle");
        }
        textView6.setVisibility(8);
        ViewGroup viewGroup6 = sNSDocumentSelectorActivity.k;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
        }
        viewGroup6.removeAllViews();
        ViewGroup viewGroup7 = sNSDocumentSelectorActivity.k;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgDocuments");
        }
        viewGroup7.setVisibility(8);
        AutoCompleteTextView autoCompleteTextView = sNSDocumentSelectorActivity.h;
        if (autoCompleteTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("edCountry");
        }
        Editable text = autoCompleteTextView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "edCountry.text");
        if (text.length() > 0) {
            String H2 = a2.b.a.a.a.H(new Object[]{sNSDocumentSelectorActivity.a()}, 1, SNSConstants.Resources.Key.IDENTITY_SELECTOR_DOCUMENT_LIST_EMPTY, "java.lang.String.format(format, *args)");
            String string2 = sNSDocumentSelectorActivity.getString(R.string.sns_step_IDENTITY_selector_iddoc_listIsEmpty);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.sns_s…lector_iddoc_listIsEmpty)");
            String stringResource2 = ExtensionsKt.getStringResource(sNSDocumentSelectorActivity, H2, string2);
            if (stringResource2.length() <= 0) {
                z = false;
            }
            if (z) {
                TextView textView7 = sNSDocumentSelectorActivity.j;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsEmpty");
                }
                textView7.setText(ExtensionsKt.asHtml(stringResource2));
                TextView textView8 = sNSDocumentSelectorActivity.j;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDocumentsEmpty");
                }
                textView8.setVisibility(0);
            }
        }
    }

    public final String a() {
        String stringExtra = getIntent().getStringExtra(EXTRA_DOCUMENT_TYPE);
        return stringExtra != null ? stringExtra : "";
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    public int getLayoutId() {
        return R.layout.sns_activity_document_selector;
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    @NotNull
    public SNSDocumentSelectorViewModel getViewModel() {
        return (SNSDocumentSelectorViewModel) this.n.getValue();
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.countryTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.countryTitle)");
        TextView textView = (TextView) findViewById;
        this.f = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCountryTitle");
        }
        boolean z = true;
        String H = a2.b.a.a.a.H(new Object[]{a()}, 1, SNSConstants.Resources.Key.IDENTITY_SELECTOR_COUNTRY_TITLE, "java.lang.String.format(format, *args)");
        String string = getString(R.string.sns_step_IDENTITY_selector_country_prompt);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sns_s…_selector_country_prompt)");
        textView.setText(ExtensionsKt.getStringResource(this, H, string));
        View findViewById2 = findViewById(R.id.countyInputLayout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.countyInputLayout)");
        TextInputLayout textInputLayout = (TextInputLayout) findViewById2;
        this.g = textInputLayout;
        if (textInputLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilCountry");
        }
        EditText editText = textInputLayout.getEditText();
        Objects.requireNonNull(editText, "null cannot be cast to non-null type android.widget.AutoCompleteTextView");
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        if (autoCompleteTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("edCountry");
        }
        String H2 = a2.b.a.a.a.H(new Object[]{a()}, 1, SNSConstants.Resources.Key.IDENTITY_SELECTOR_COUNTRY_HINT, "java.lang.String.format(format, *args)");
        String string2 = getString(R.string.sns_step_IDENTITY_selector_country_placeholder);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.sns_s…ctor_country_placeholder)");
        autoCompleteTextView.setHint(ExtensionsKt.getStringResource(this, H2, string2));
        View findViewById3 = findViewById(R.id.documentsTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.documentsTitle)");
        this.i = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.documentsEmpty);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.documentsEmpty)");
        this.j = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.vgDocuments);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.vgDocuments)");
        this.k = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.btnClose);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.btnClose)");
        this.l = findViewById6;
        if (findViewById6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        }
        findViewById6.setOnClickListener(new b(this));
        View findViewById7 = findViewById(R.id.tvFooter);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tvFooter)");
        this.m = (TextView) findViewById7;
        String H3 = a2.b.a.a.a.H(new Object[]{a()}, 1, SNSConstants.Resources.Key.IDENTITY_SELECTOR_FOOTER, "java.lang.String.format(format, *args)");
        String string3 = getString(R.string.sns_step_IDENTITY_selector_footerHtml);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.sns_s…TITY_selector_footerHtml)");
        String stringResource = ExtensionsKt.getStringResource(this, H3, string3);
        if (stringResource.length() <= 0) {
            z = false;
        }
        if (!z) {
            stringResource = null;
        }
        if (stringResource != null) {
            TextView textView2 = this.m;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
            }
            textView2.setText(ExtensionsKt.asHtml(stringResource));
            TextView textView3 = this.m;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
            }
            textView3.setVisibility(0);
            TextView textView4 = this.m;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
            }
            ExtensionsKt.handleUrlClicks(textView4, new a(this));
            TextView textView5 = this.m;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
            }
            textView5.setMovementMethod(new LinkMovementMethod());
        }
        getViewModel().getShowSupport().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$onCreate$$inlined$observeEvent$1
            public final /* synthetic */ SNSDocumentSelectorActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null && this.a.getSupportFragmentManager().findFragmentByTag(SupportBottomSheet.TAG) == null) {
                    SupportBottomSheet.Companion.newInstance().show(this.a.getSupportFragmentManager(), SupportBottomSheet.TAG);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getCountries().observe(this, new SNSDocumentSelectorActivity$onCreate$$inlined$observe$1(this));
        getViewModel().getDocuments().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$onCreate$$inlined$observe$2
            public final /* synthetic */ SNSDocumentSelectorActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    SNSDocumentSelectorActivity.access$inflateDocuments(this.a, t);
                }
            }
        });
        getViewModel().getSelection().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$onCreate$$inlined$observe$3
            public final /* synthetic */ SNSDocumentSelectorActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    String r62 = ((IdentityType) t2.component2()).m209unboximpl();
                    this.a.setResult(-1, new Intent().putExtra(SNSDocumentSelectorActivity.RESULT_SELECTED_COUNTRY, (String) t2.component1()).putExtra(SNSDocumentSelectorActivity.RESULT_SELECTED_ID_DOC_TYPE, r62));
                    this.a.finish();
                }
            }
        });
        setResult(0);
    }
}
