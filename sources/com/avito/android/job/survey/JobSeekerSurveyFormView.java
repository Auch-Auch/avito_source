package com.avito.android.job.survey;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.job.survey.JobSeekerSurveyFormViewModel;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.lib.design.list_item.RadioListItem;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u00102\u001a\u00020%\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0018\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0018\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000403¢\u0006\u0004\b?\u0010@J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\nJ\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\nR\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001fR\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010'R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010'R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010+¨\u0006A"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormView;", "", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState;", "formViewState", "", "renderForm", "(Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState;)V", "", "value", "setValue", "(Ljava/lang/String;)V", "showLoading", "()V", "", "isLoading", "setButtonLoading", "(Z)V", "isEnabled", "setButtonEnabled", "setRefreshButtonLoadingState", "setFormEnabled", "message", "showError", "showErrorMessageSnackbar", "Lkotlin/Function1;", "Lcom/avito/android/deep_linking/links/DeepLink;", "l", "Lkotlin/jvm/functions/Function1;", "onDeeplink", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "subtitleTextView", "d", "titleTextView", "k", "onFormChanged", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "container", "Lcom/avito/android/lib/design/button/Button;", "i", "Lcom/avito/android/lib/design/button/Button;", "refreshButton", AuthSource.BOOKING_ORDER, "loading", "h", "errorTextView", "j", "parent", "Lkotlin/Function0;", AuthSource.OPEN_CHANNEL_LIST, "Lkotlin/jvm/functions/Function0;", "onRefreshButtonClick", "c", "error", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "fieldsContainer", g.a, "saveButton", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "survey_release"}, k = 1, mv = {1, 4, 2})
public final class JobSeekerSurveyFormView {
    public final View a;
    public final View b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public final LinearLayout f;
    public final Button g;
    public final TextView h;
    public final Button i;
    public final View j;
    public final Function1<String, Unit> k;
    public final Function1<DeepLink, Unit> l;
    public final Function0<Unit> m;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                Object tag = ((RadioListItem) this.b).getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                String str = (String) tag;
                JobSeekerSurveyFormViewKt.access$findRadioButtonsAndUpdateIsChecked(((JobSeekerSurveyFormView) this.c).f, str);
                ((JobSeekerSurveyFormView) this.c).k.invoke(str);
            } else if (i == 1) {
                ((JobSeekerSurveyFormView) this.b).l.invoke(((JobSeekerSurveyFormViewModel.ViewState.FormViewState) this.c).getAction().getDeeplink());
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ JobSeekerSurveyFormView a;

        public b(JobSeekerSurveyFormView jobSeekerSurveyFormView) {
            this.a = jobSeekerSurveyFormView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.m.invoke();
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ JobSeekerSurveyFormView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JobSeekerSurveyFormView jobSeekerSurveyFormView) {
            super(1);
            this.a = jobSeekerSurveyFormView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "value");
            this.a.k.invoke(str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.deep_linking.links.DeepLink, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public JobSeekerSurveyFormView(@NotNull View view, @NotNull Function1<? super String, Unit> function1, @NotNull Function1<? super DeepLink, Unit> function12, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "parent");
        Intrinsics.checkNotNullParameter(function1, "onFormChanged");
        Intrinsics.checkNotNullParameter(function12, "onDeeplink");
        Intrinsics.checkNotNullParameter(function0, "onRefreshButtonClick");
        this.j = view;
        this.k = function1;
        this.l = function12;
        this.m = function0;
        View findViewById = view.findViewById(R.id.scrollable_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parent.findViewById(R.id.scrollable_container)");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.loading);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "parent.findViewById(R.id.loading)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.error);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "parent.findViewById(R.id.error)");
        this.c = findViewById3;
        View findViewById4 = findViewById.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "container.findViewById(R.id.title)");
        this.d = (TextView) findViewById4;
        View findViewById5 = findViewById.findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "container.findViewById(R.id.subtitle)");
        this.e = (TextView) findViewById5;
        View findViewById6 = findViewById.findViewById(R.id.field_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "container.findViewById(R.id.field_container)");
        this.f = (LinearLayout) findViewById6;
        View findViewById7 = findViewById.findViewById(R.id.save_button);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "container.findViewById(R.id.save_button)");
        this.g = (Button) findViewById7;
        View findViewById8 = findViewById3.findViewById(R.id.error_text);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "error.findViewById(R.id.error_text)");
        this.h = (TextView) findViewById8;
        View findViewById9 = findViewById3.findViewById(R.id.refresh_button);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "error.findViewById(R.id.refresh_button)");
        Button button = (Button) findViewById9;
        this.i = button;
        button.setOnClickListener(new b(this));
    }

    public final void renderForm(@NotNull JobSeekerSurveyFormViewModel.ViewState.FormViewState formViewState) {
        Intrinsics.checkNotNullParameter(formViewState, "formViewState");
        Views.show(this.a);
        Views.hide(this.b);
        Views.hide(this.c);
        this.d.setText(formViewState.getTitle());
        this.e.setText(formViewState.getSubtitle());
        this.f.removeAllViews();
        JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState field = formViewState.getField();
        if (field instanceof JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.RadioGroupViewState) {
            this.f.setTag("radioGroup");
            for (T t : ((JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.RadioGroupViewState) field).getOptions()) {
                RadioListItem radioListItem = new RadioListItem(this.f.getContext());
                radioListItem.setTitle(t.getTitle());
                radioListItem.setTag(t.getValue());
                radioListItem.setPadding(ViewSizeKt.getDp(16), ViewSizeKt.getDp(0), ViewSizeKt.getDp(16), ViewSizeKt.getDp(0));
                radioListItem.setOnClickListener(new a(0, radioListItem, this));
                this.f.addView(radioListItem);
            }
        } else if (field instanceof JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.TextAreaViewState) {
            this.f.setTag("textArea");
            Context context = this.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fieldsContainer.context");
            Input input = new Input(context);
            Input.setMultiLine$default(input, 0, 5, 1, null);
            input.setHint(((JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.TextAreaViewState) field).getHint());
            input.setClearButton(true);
            InputExtensionsKt.addTextChangedListener(input, new c(this));
            LinearLayout linearLayout = this.f;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(ViewSizeKt.getDp(16), ViewSizeKt.getDp(0), ViewSizeKt.getDp(16), ViewSizeKt.getDp(0));
            linearLayout.addView(input, layoutParams);
        }
        this.g.setText(formViewState.getAction().getTitle());
        this.g.setOnClickListener(new a(1, this, formViewState));
    }

    public final void setButtonEnabled(boolean z) {
        this.g.setEnabled(z);
    }

    public final void setButtonLoading(boolean z) {
        this.g.setLoading(z);
    }

    public final void setFormEnabled(boolean z) {
        LinearLayout linearLayout = this.f;
        int childCount = linearLayout.getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = linearLayout.getChildAt(i2);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                childAt.setEnabled(z);
                if (i2 != childCount) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final void setRefreshButtonLoadingState(boolean z) {
        this.i.setLoading(z);
        this.i.setEnabled(!z);
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Object tag = this.f.getTag();
        if (Intrinsics.areEqual(tag, "radioGroup")) {
            JobSeekerSurveyFormViewKt.access$findRadioButtonsAndUpdateIsChecked(this.f, str);
        } else if (Intrinsics.areEqual(tag, "textArea")) {
            JobSeekerSurveyFormViewKt.access$findInputAndSetValue(this.f, str);
        }
    }

    public final void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.hide(this.a);
        Views.show(this.c);
        Views.hide(this.b);
        this.h.setText(str);
    }

    public final void showErrorMessageSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        SnackbarExtensionsKt.showSnackbar$default(this.j, str, 0, (String) null, 0, (Function0) null, 0, SnackbarPosition.OVERLAY_VIEW_TOP, SnackbarType.ERROR, 62, (Object) null);
    }

    public final void showLoading() {
        Views.hide(this.a);
        Views.hide(this.c);
        Views.show(this.b);
    }
}
