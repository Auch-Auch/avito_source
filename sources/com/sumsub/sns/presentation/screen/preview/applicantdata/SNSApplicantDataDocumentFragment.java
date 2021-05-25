package com.sumsub.sns.presentation.screen.preview.applicantdata;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import butterknife.BindView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.ApplicantDataField;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.FieldName;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bH\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005R\u001d\u0010\u0017\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010#\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'R\"\u0010=\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010*\u001a\u0004\b>\u0010,\"\u0004\b?\u0010.R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010\u001fR\"\u0010B\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010#\u001a\u0004\bC\u0010%\"\u0004\bD\u0010'R\"\u0010E\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010#\u001a\u0004\bF\u0010%\"\u0004\bG\u0010'¨\u0006J"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentFragment;", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewFragment;", "Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel;", "", AuthSource.BOOKING_ORDER, "()V", "", "direction", AuthSource.SEND_ABUSE, "(I)V", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentViewModel;", "viewModel", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "e", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "softKeyboardVisibilityListener", "", "", "c", "Ljava/util/Map;", "genders", "Landroid/widget/Button;", "btnContinue", "Landroid/widget/Button;", "getBtnContinue", "()Landroid/widget/Button;", "setBtnContinue", "(Landroid/widget/Button;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "Landroid/view/ViewGroup;", "vgContent", "Landroid/view/ViewGroup;", "getVgContent", "()Landroid/view/ViewGroup;", "setVgContent", "(Landroid/view/ViewGroup;)V", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "f", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "focusChangeListener", "btnNext", "getBtnNext", "setBtnNext", "tvSubtitle", "getTvSubtitle", "setTvSubtitle", "d", "countries", "btnPrev", "getBtnPrev", "setBtnPrev", "btnDone", "getBtnDone", "setBtnDone", "<init>", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSApplicantDataDocumentFragment extends SNSBaseDocumentPreviewFragment<SNSApplicantDataDocumentViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "SNSApplicantDataDocumentFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSApplicantDataDocumentViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$$special$$inlined$viewModels$2
        public final /* synthetic */ Function0 a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.a.invoke()).getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }, new f(this));
    @BindView(2070)
    public Button btnContinue;
    @BindView(2071)
    public Button btnDone;
    @BindView(2073)
    public Button btnNext;
    @BindView(2074)
    public Button btnPrev;
    public Map<String, String> c = r.emptyMap();
    public Map<String, String> d = r.emptyMap();
    public final ViewTreeObserver.OnGlobalLayoutListener e = new e(this);
    public final ViewTreeObserver.OnGlobalFocusChangeListener f = new b(this);
    @BindView(2481)
    public TextView tvSubtitle;
    @BindView(2483)
    public TextView tvTitle;
    @BindView(2492)
    public ViewGroup vgContent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/applicantdata/SNSApplicantDataDocumentFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Document;", "document", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Document;)Landroidx/fragment/app/Fragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Document document) {
            Intrinsics.checkNotNullParameter(document, "document");
            SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment = new SNSApplicantDataDocumentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSBaseDocumentPreviewFragment.ARGS_DOCUMENT, document);
            Unit unit = Unit.INSTANCE;
            sNSApplicantDataDocumentFragment.setArguments(bundle);
            return sNSApplicantDataDocumentFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FieldName.values();
            int[] iArr = new int[25];
            $EnumSwitchMapping$0 = iArr;
            FieldName fieldName = FieldName.gender;
            iArr[10] = 1;
            FieldName fieldName2 = FieldName.country;
            iArr[12] = 2;
            FieldName fieldName3 = FieldName.countryOfBirth;
            iArr[5] = 3;
            FieldName fieldName4 = FieldName.nationality;
            iArr[11] = 4;
            FieldName.values();
            int[] iArr2 = new int[25];
            $EnumSwitchMapping$1 = iArr2;
            FieldName fieldName5 = FieldName.dob;
            iArr2[7] = 1;
            iArr2[10] = 2;
            iArr2[12] = 3;
            iArr2[5] = 4;
            iArr2[11] = 5;
            FieldName fieldName6 = FieldName.email;
            iArr2[3] = 6;
            FieldName fieldName7 = FieldName.phone;
            iArr2[4] = 7;
            FieldName fieldName8 = FieldName.firstName;
            iArr2[0] = 8;
            FieldName fieldName9 = FieldName.lastName;
            iArr2[1] = 9;
            FieldName fieldName10 = FieldName.middleName;
            iArr2[2] = 10;
            FieldName fieldName11 = FieldName.state;
            iArr2[18] = 11;
            FieldName fieldName12 = FieldName.street;
            iArr2[13] = 12;
            FieldName fieldName13 = FieldName.subStreet;
            iArr2[14] = 13;
            FieldName fieldName14 = FieldName.town;
            iArr2[17] = 14;
            FieldName fieldName15 = FieldName.stateOfBirth;
            iArr2[6] = 15;
            FieldName fieldName16 = FieldName.placeOfBirth;
            iArr2[8] = 16;
            FieldName fieldName17 = FieldName.postCode;
            iArr2[19] = 17;
            FieldName fieldName18 = FieldName.legalName;
            iArr2[9] = 18;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                SNSApplicantDataDocumentFragment.access$submitValues((SNSApplicantDataDocumentFragment) this.b);
            } else if (i == 1) {
                SNSApplicantDataDocumentFragment.access$selectPrevField((SNSApplicantDataDocumentFragment) this.b);
            } else if (i == 2) {
                SNSApplicantDataDocumentFragment.access$selectNextField((SNSApplicantDataDocumentFragment) this.b);
            } else if (i == 3) {
                ExtensionsKt.hideKeyboard((View) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public final /* synthetic */ SNSApplicantDataDocumentFragment a;

        public b(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
            this.a = sNSApplicantDataDocumentFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            this.a.b();
        }
    }

    public static final class c extends Lambda implements Function1<View, SNSApplicantDataFieldView> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SNSApplicantDataFieldView invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return (SNSApplicantDataFieldView) view2;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = new d();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ SNSApplicantDataDocumentFragment a;

        public e(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
            this.a = sNSApplicantDataDocumentFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            View view = this.a.getView();
            if (view != null) {
                Intrinsics.checkNotNullExpressionValue(view, "view ?: return@OnGlobalLayoutListener");
                Rect rect = new Rect();
                view.getRootView().getWindowVisibleDisplayFrame(rect);
                View rootView = view.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "fragmentView.rootView");
                int height = rootView.getHeight();
                SNSApplicantDataDocumentFragment.access$updateFieldsNavigationVisibility(this.a, ((double) (height - rect.bottom)) > ((double) height) * 0.15d);
            }
        }
    }

    public static final class f extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSApplicantDataDocumentFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
            super(0);
            this.a = sNSApplicantDataDocumentFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment = this.a;
            return new SNSApplicantDataDocumentViewModelFactory(sNSApplicantDataDocumentFragment, sNSApplicantDataDocumentFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    public static final SNSApplicantDataFieldView access$asView(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment, ApplicantDataField applicantDataField, Context context, String str) {
        SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView;
        Objects.requireNonNull(sNSApplicantDataDocumentFragment);
        if (applicantDataField instanceof ApplicantDataField.Field) {
            ApplicantDataField.Field field = (ApplicantDataField.Field) applicantDataField;
            String str2 = "";
            switch (field.getName().ordinal()) {
                case 0:
                case 1:
                case 2:
                    SNSApplicantDataFieldView sNSApplicantDataFieldView = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataFieldView.setValue(str);
                    EditText editText = sNSApplicantDataFieldView.getEditText();
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView;
                    if (editText != null) {
                        editText.setInputType(8193);
                        sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView;
                        break;
                    }
                    break;
                case 3:
                    SNSApplicantDataFieldView sNSApplicantDataFieldView2 = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataFieldView2.setValue(str);
                    EditText editText2 = sNSApplicantDataFieldView2.getEditText();
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView2;
                    if (editText2 != null) {
                        editText2.setInputType(32);
                        sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView2;
                        break;
                    }
                    break;
                case 4:
                    SNSApplicantDataFieldView sNSApplicantDataFieldView3 = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataFieldView3.setValue(str);
                    EditText editText3 = sNSApplicantDataFieldView3.getEditText();
                    if (editText3 != null) {
                        editText3.setInputType(3);
                    }
                    EditText editText4 = sNSApplicantDataFieldView3.getEditText();
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView3;
                    if (editText4 != null) {
                        editText4.setFilters(new SNSApplicantDataDocumentFragment$asView$view$5$1[]{new InputFilter() { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$asView$view$5$1
                            @Override // android.text.InputFilter
                            @NotNull
                            public CharSequence filter(@NotNull CharSequence charSequence, int i, int i2, @Nullable Spanned spanned, int i3, int i4) {
                                Intrinsics.checkNotNullParameter(charSequence, "source");
                                StringBuilder sb = new StringBuilder();
                                int length = charSequence.length();
                                for (int i5 = 0; i5 < length; i5++) {
                                    char charAt = charSequence.charAt(i5);
                                    if (Character.isDigit(charAt) || charAt == '+') {
                                        sb.append(charAt);
                                    }
                                }
                                return sb;
                            }
                        }});
                        sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView3;
                        break;
                    }
                    break;
                case 5:
                case 11:
                case 12:
                    SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView2 = new SNSApplicantDataSelectionFieldView(context, null, 0, 0, 14, null);
                    Collator instance = Collator.getInstance(SNSMobileSDK.INSTANCE.getLocale());
                    List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sNSApplicantDataDocumentFragment.d.values());
                    Collections.sort(mutableList, instance);
                    Object[] array = mutableList.toArray(new String[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    sNSApplicantDataSelectionFieldView2.setItems((String[]) array);
                    String str3 = sNSApplicantDataDocumentFragment.d.get(str);
                    if (str3 == null) {
                        str3 = str2;
                    }
                    sNSApplicantDataSelectionFieldView2.setValue(str3);
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataSelectionFieldView2;
                    break;
                case 6:
                case 8:
                case 13:
                case 14:
                case 17:
                case 18:
                case 19:
                    SNSApplicantDataFieldView sNSApplicantDataFieldView4 = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataFieldView4.setValue(str);
                    EditText editText5 = sNSApplicantDataFieldView4.getEditText();
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView4;
                    if (editText5 != null) {
                        editText5.setInputType(8193);
                        sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView4;
                        break;
                    }
                    break;
                case 7:
                    SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView = new SNSApplicantDataCalendarFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataCalendarFieldView.setValue(str);
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataCalendarFieldView;
                    break;
                case 9:
                    SNSApplicantDataFieldView sNSApplicantDataFieldView5 = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataFieldView5.setValue(str);
                    EditText editText6 = sNSApplicantDataFieldView5.getEditText();
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView5;
                    if (editText6 != null) {
                        editText6.setInputType(8193);
                        sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView5;
                        break;
                    }
                    break;
                case 10:
                    SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView3 = r7;
                    SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView4 = new SNSApplicantDataSelectionFieldView(context, null, 0, 0, 14, null);
                    Collator instance2 = Collator.getInstance(SNSMobileSDK.INSTANCE.getLocale());
                    List mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) sNSApplicantDataDocumentFragment.c.values());
                    Collections.sort(mutableList2, instance2);
                    Object[] array2 = mutableList2.toArray(new String[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    sNSApplicantDataSelectionFieldView3.setItems((String[]) array2);
                    String str4 = sNSApplicantDataDocumentFragment.c.get(str);
                    if (str4 == null) {
                        str4 = str2;
                    }
                    sNSApplicantDataSelectionFieldView3.setValue(str4);
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataSelectionFieldView3;
                    break;
                case 15:
                case 16:
                default:
                    SNSApplicantDataFieldView sNSApplicantDataFieldView6 = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
                    sNSApplicantDataFieldView6.setValue(str);
                    sNSApplicantDataSelectionFieldView = sNSApplicantDataFieldView6;
                    break;
            }
            String format = String.format(SNSConstants.Resources.Key.APPLICANT_FIELD_KEY, Arrays.copyOf(new Object[]{field.getName().getValue()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            int stringIdentifier = ExtensionsKt.getStringIdentifier(context, format);
            CharSequence textResource = stringIdentifier != -1 ? sNSApplicantDataDocumentFragment.getTextResource(stringIdentifier) : field.getName().getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(textResource);
            if (field.isRequired()) {
                str2 = " *";
            }
            sb.append(str2);
            sNSApplicantDataSelectionFieldView.setTitle(sb.toString());
            sNSApplicantDataSelectionFieldView.setTag(field);
            sNSApplicantDataSelectionFieldView.setHint(sNSApplicantDataDocumentFragment.getTextResource(field.isRequired() ? R.string.sns_data_placeholder_required : R.string.sns_data_placeholder_optional));
            return sNSApplicantDataSelectionFieldView;
        } else if (applicantDataField instanceof ApplicantDataField.CustomField) {
            ApplicantDataField.CustomField customField = (ApplicantDataField.CustomField) applicantDataField;
            SNSApplicantDataFieldView sNSApplicantDataFieldView7 = new SNSApplicantDataFieldView(context, null, 0, 0, 14, null);
            boolean z = true;
            String format2 = String.format(SNSConstants.Resources.Key.APPLICANT_CUSTOM_FIELD_KEY, Arrays.copyOf(new Object[]{customField.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            CharSequence charSequence = null;
            CharSequence textResource$default = ExtensionsKt.getTextResource$default(context, format2, (String) null, 2, (Object) null);
            if (textResource$default.length() <= 0) {
                z = false;
            }
            if (z) {
                charSequence = textResource$default;
            }
            if (charSequence == null) {
                charSequence = customField.getDisplayName();
            }
            sNSApplicantDataFieldView7.setTitle(charSequence);
            sNSApplicantDataFieldView7.setTag(customField);
            sNSApplicantDataFieldView7.setHint(sNSApplicantDataDocumentFragment.getTextResource(customField.isRequired() ? R.string.sns_data_placeholder_required : R.string.sns_data_placeholder_optional));
            sNSApplicantDataFieldView7.setValue(str);
            return sNSApplicantDataFieldView7;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void access$selectNextField(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
        sNSApplicantDataDocumentFragment.a(130);
    }

    public static final void access$selectPrevField(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
        sNSApplicantDataDocumentFragment.a(33);
    }

    public static final void access$submitValues(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment) {
        SNSApplicantDataDocumentViewModel viewModel = sNSApplicantDataDocumentFragment.getViewModel();
        ViewGroup viewGroup = sNSApplicantDataDocumentFragment.vgContent;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgContent");
        }
        viewModel.submitApplicantData(SequencesKt___SequencesKt.mapNotNull(ViewGroupKt.getChildren(viewGroup), new a2.q.a.d.a.d.a.b(sNSApplicantDataDocumentFragment)));
    }

    public static final void access$updateFieldsNavigationVisibility(SNSApplicantDataDocumentFragment sNSApplicantDataDocumentFragment, boolean z) {
        int i = z ? 0 : 8;
        Button button = sNSApplicantDataDocumentFragment.btnPrev;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
        }
        button.setVisibility(i);
        Button button2 = sNSApplicantDataDocumentFragment.btnNext;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        }
        button2.setVisibility(i);
        Button button3 = sNSApplicantDataDocumentFragment.btnDone;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDone");
        }
        button3.setVisibility(i);
        if (z) {
            sNSApplicantDataDocumentFragment.b();
        }
    }

    public final void a(int i) {
        EditText editText;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        View currentFocus = requireActivity.getCurrentFocus();
        TextInputLayout textInputLayout = null;
        EditText focusSearch = currentFocus != null ? currentFocus.focusSearch(i) : null;
        if (focusSearch instanceof TextInputLayout) {
            textInputLayout = focusSearch;
        }
        TextInputLayout textInputLayout2 = textInputLayout;
        if (!(textInputLayout2 == null || (editText = textInputLayout2.getEditText()) == null)) {
            focusSearch = editText;
        }
        if (focusSearch != null) {
            focusSearch.requestFocus();
        }
    }

    public final void b() {
        Button button = this.btnPrev;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        View currentFocus = requireActivity.getCurrentFocus();
        View view = null;
        boolean z = true;
        button.setEnabled((currentFocus != null ? currentFocus.focusSearch(33) : null) != null);
        Button button2 = this.btnNext;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        }
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        View currentFocus2 = requireActivity2.getCurrentFocus();
        if (currentFocus2 != null) {
            view = currentFocus2.focusSearch(130);
        }
        if (view == null) {
            z = false;
        }
        button2.setEnabled(z);
    }

    @NotNull
    public final Button getBtnContinue() {
        Button button = this.btnContinue;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
        }
        return button;
    }

    @NotNull
    public final Button getBtnDone() {
        Button button = this.btnDone;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDone");
        }
        return button;
    }

    @NotNull
    public final Button getBtnNext() {
        Button button = this.btnNext;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        }
        return button;
    }

    @NotNull
    public final Button getBtnPrev() {
        Button button = this.btnPrev;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
        }
        return button;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_applicant_data_document;
    }

    @NotNull
    public final TextView getTvSubtitle() {
        TextView textView = this.tvSubtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        return textView;
    }

    @NotNull
    public final ViewGroup getVgContent() {
        ViewGroup viewGroup = this.vgContent;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgContent");
        }
        return viewGroup;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSApplicantDataDocumentViewModel getViewModel() {
        return (SNSApplicantDataDocumentViewModel) this.b.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        super.onPause();
        View view = getView();
        if (!(view == null || (viewTreeObserver2 = view.getViewTreeObserver()) == null)) {
            viewTreeObserver2.removeOnGlobalFocusChangeListener(this.f);
        }
        View view2 = getView();
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        super.onResume();
        View view = getView();
        if (!(view == null || (viewTreeObserver2 = view.getViewTreeObserver()) == null)) {
            viewTreeObserver2.addOnGlobalFocusChangeListener(this.f);
        }
        View view2 = getView();
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this.e);
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        textView.setText(getTextResource(R.string.sns_step_APPLICANT_DATA_title));
        TextView textView2 = this.tvSubtitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        textView2.setText(getTextResource(R.string.sns_step_APPLICANT_DATA_prompt));
        Button button = this.btnContinue;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
        }
        button.setText(getTextResource(R.string.sns_data_action_submit));
        Button button2 = this.btnContinue;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
        }
        button2.setOnClickListener(new a(0, this));
        Button button3 = this.btnPrev;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
        }
        button3.setText(getTextResource(R.string.sns_data_action_prev));
        Button button4 = this.btnPrev;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
        }
        button4.setOnClickListener(new a(1, this));
        Button button5 = this.btnNext;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        }
        button5.setText(getTextResource(R.string.sns_data_action_next));
        Button button6 = this.btnNext;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        }
        button6.setOnClickListener(new a(2, this));
        Button button7 = this.btnDone;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDone");
        }
        button7.setText(getTextResource(R.string.sns_data_action_done));
        Button button8 = this.btnDone;
        if (button8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDone");
        }
        button8.setOnClickListener(new a(3, view));
        LiveData<Map<String, String>> countries = getViewModel().getCountries();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        countries.observe(viewLifecycleOwner, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$1
            public final /* synthetic */ SNSApplicantDataDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.d = t;
                }
            }
        });
        LiveData<Map<String, String>> genders = getViewModel().getGenders();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        genders.observe(viewLifecycleOwner2, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$2
            public final /* synthetic */ SNSApplicantDataDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.c = t;
                }
            }
        });
        LiveData<Boolean> showProgress = getViewModel().getShowProgress();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        showProgress.observe(viewLifecycleOwner3, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$3
            public final /* synthetic */ SNSApplicantDataDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    boolean booleanValue = t.booleanValue();
                    FragmentActivity activity = this.a.getActivity();
                    if (!(activity instanceof SNSAppListener)) {
                        activity = null;
                    }
                    SNSAppListener sNSAppListener = (SNSAppListener) activity;
                    if (sNSAppListener != null) {
                        sNSAppListener.onProgress(booleanValue);
                    }
                }
            }
        });
        LiveData<Boolean> showContent = getViewModel().getShowContent();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        showContent.observe(viewLifecycleOwner4, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$4
            public final /* synthetic */ SNSApplicantDataDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ExtensionsKt.visibleIf(this.a.getVgContent(), t.booleanValue());
                }
            }
        });
        LiveData<List<SNSApplicantDataDocumentViewModel.ApplicantData>> fields = getViewModel().getFields();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        fields.observe(viewLifecycleOwner5, new SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$5(this));
        LiveData<List<SNSApplicantDataDocumentViewModel.ApplicantDataError>> errors = getViewModel().getErrors();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        errors.observe(viewLifecycleOwner6, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment$onViewCreated$$inlined$observe$6
            public final /* synthetic */ SNSApplicantDataDocumentFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                T t2;
                if (t != null) {
                    T t3 = t;
                    for (T t4 : t3) {
                        Iterator<T> it = SequencesKt___SequencesKt.map(ViewGroupKt.getChildren(this.a.getVgContent()), SNSApplicantDataDocumentFragment.c.a).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t2 = null;
                                break;
                            }
                            t2 = it.next();
                            if (Intrinsics.areEqual(t2.getTag(), t4.getField())) {
                                break;
                            }
                        }
                        T t5 = t2;
                        if (t5 != null) {
                            t5.setError(this.a.getTextResource(t4.getError()));
                        }
                    }
                    if (!t3.isEmpty()) {
                        new MaterialAlertDialogBuilder(this.a.requireContext()).setMessage(this.a.getTextResource(R.string.sns_data_alert_validationFailed)).setPositiveButton(this.a.getTextResource(R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) SNSApplicantDataDocumentFragment.d.a).create().show();
                    }
                }
            }
        });
    }

    public final void setBtnContinue(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnContinue = button;
    }

    public final void setBtnDone(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnDone = button;
    }

    public final void setBtnNext(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnNext = button;
    }

    public final void setBtnPrev(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnPrev = button;
    }

    public final void setTvSubtitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubtitle = textView;
    }

    public final void setTvTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }

    public final void setVgContent(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgContent = viewGroup;
    }
}
