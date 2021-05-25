package com.avito.android.job.interview;

import a2.a.a.j1.b.b;
import a2.a.a.j1.b.c;
import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.SingleEvent;
import com.avito.android.job.interview.State;
import com.avito.android.job.interview.domain.DateEntry;
import com.avito.android.job.interview.domain.InvitationDraft;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.CollapsingTitleAppBarLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010=\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020504¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001e\u0010\u001b\u001a\n \u000e*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001f\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010#\u001a\n \u000e*\u0004\u0018\u00010 0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\n \u000e*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010/\u001a\n \u000e*\u0004\u0018\u00010,0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010:\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010\u001eR\u001e\u0010<\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0010¨\u0006@"}, d2 = {"Lcom/avito/android/job/interview/JobInterviewInvitationRenderer;", "Lru/avito/component/toolbar/AppbarClickListener;", "", "onHomeClicked", "()V", "onActionClicked", "Lcom/avito/android/job/interview/State;", "state", "render", "(Lcom/avito/android/job/interview/State;)V", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "update", "(Lcom/avito/android/job/interview/SingleEvent$UiChange;)V", "Lcom/avito/android/lib/design/input/Input;", "kotlin.jvm.PlatformType", "h", "Lcom/avito/android/lib/design/input/Input;", "phoneInput", "Lcom/avito/android/lib/design/button/Button;", "k", "Lcom/avito/android/lib/design/button/Button;", "inviteButton", g.a, "locationInput", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "f", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "dateTimeContainer", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "contentContainer", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/app/Activity;", "l", "Landroid/app/Activity;", "activity", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "d", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "toolbar", "Landroid/view/LayoutInflater;", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/job/interview/Action;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "j", "buttonContainer", "i", "messageInput", "root", "<init>", "(Landroid/view/ViewGroup;Landroid/app/Activity;Lio/reactivex/rxjava3/functions/Consumer;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class JobInterviewInvitationRenderer implements AppbarClickListener {
    public final Context a;
    public final LayoutInflater b;
    public final ProgressOverlay c;
    public final CollapsingTitleAppBarLayout d;
    public final ViewGroup e;
    public final ComponentContainer f;
    public final Input g;
    public final Input h;
    public final Input i;
    public final ViewGroup j;
    public final Button k;
    public final Activity l;
    public final Consumer<Action> m;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ JobInterviewInvitationRenderer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JobInterviewInvitationRenderer jobInterviewInvitationRenderer) {
            super(0);
            this.a = jobInterviewInvitationRenderer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.m.accept(Action.Refresh.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public JobInterviewInvitationRenderer(@NotNull ViewGroup viewGroup, @NotNull Activity activity, @NotNull Consumer<Action> consumer) {
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        this.l = activity;
        this.m = consumer;
        Context context = viewGroup.getContext();
        this.a = context;
        this.b = LayoutInflater.from(context);
        View findViewById = viewGroup.findViewById(R.id.progress_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.progress_root)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        int i2 = R.id.content_container;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup2, i2, null, false, 0, 28, null);
        progressOverlay.setOnRefreshListener(new a(this));
        Unit unit = Unit.INSTANCE;
        this.c = progressOverlay;
        CollapsingTitleAppBarLayout collapsingTitleAppBarLayout = (CollapsingTitleAppBarLayout) viewGroup.findViewById(R.id.app_bar);
        this.d = collapsingTitleAppBarLayout;
        this.e = (ViewGroup) viewGroup.findViewById(i2);
        this.f = (ComponentContainer) viewGroup.findViewById(R.id.date_time_container);
        this.g = (Input) viewGroup.findViewById(R.id.location_input);
        this.h = (Input) viewGroup.findViewById(R.id.phone_input);
        this.i = (Input) viewGroup.findViewById(R.id.message_input);
        this.j = (ViewGroup) viewGroup.findViewById(R.id.button_container);
        this.k = (Button) viewGroup.findViewById(R.id.invite_button);
        collapsingTitleAppBarLayout.setClickListener(this);
    }

    @Override // ru.avito.component.toolbar.AppbarClickListener
    public void onActionClicked() {
    }

    @Override // ru.avito.component.toolbar.AppbarClickListener
    public void onHomeClicked() {
        this.l.finish();
    }

    public final void render(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(state, State.Loading.INSTANCE)) {
            this.c.showLoading();
            ViewGroup viewGroup = this.e;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "contentContainer");
            Keyboards.hideKeyboard$default(viewGroup, false, 1, null);
            Views.hide(this.j);
            this.d.setExpanded(false);
        } else if (state instanceof State.Content) {
            InvitationDraft draft = ((State.Content) state).getDraft();
            Input input = this.g;
            Location location = draft.getLocation();
            Input.setText$default(input, location != null ? location.getText() : null, false, 2, null);
            Input.setText$default(this.h, draft.getPhone(), false, 2, null);
            Input.setText$default(this.i, draft.getMessage(), false, 2, null);
            List<DateEntry> dates = draft.getDates();
            this.f.removeAllViews();
            int i2 = 0;
            for (T t : dates) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                View inflate = this.b.inflate(R.layout.interview_invitation_date_time_inputs, (ViewGroup) this.f, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "pickers");
                View findViewById = inflate.findViewById(R.id.day_input);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
                Input input2 = (Input) findViewById;
                input2.setTag("date_picker_" + i2);
                View findViewById2 = inflate.findViewById(R.id.time_input);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
                Input input3 = (Input) findViewById2;
                input3.setTag("time_picker_" + i2);
                Input.setText$default(input2, t2.getDateTitle(), false, 2, null);
                String timeTitle = t2.getTimeTitle();
                if (timeTitle != null) {
                    Input.setText$default(input3, timeTitle, false, 2, null);
                }
                this.f.addView(inflate);
                i2 = i3;
            }
            Views.show(this.j);
            this.d.setExpanded(true);
            this.c.showContent();
            Input input4 = this.g;
            input4.setOnClickListener(new b(this, draft));
            InputExtensionsKt.addTextChangedListener(input4, new o5(0, input4));
            Input input5 = this.h;
            Intrinsics.checkNotNullExpressionValue(input5, "phoneInput");
            InputExtensionsKt.addTextChangedListener(input5, new o5(1, this));
            Input input6 = this.i;
            Intrinsics.checkNotNullExpressionValue(input6, "messageInput");
            InputExtensionsKt.addTextChangedListener(input6, new o5(2, this));
            for (int i4 = 0; i4 < 2; i4++) {
                ViewGroup viewGroup2 = this.e;
                Input input7 = (Input) viewGroup2.findViewWithTag("date_picker_" + i4);
                input7.setOnClickListener(new f2(0, i4, this));
                InputExtensionsKt.addTextChangedListener(input7, new o5(3, input7));
                ViewGroup viewGroup3 = this.e;
                Input input8 = (Input) viewGroup3.findViewWithTag("time_picker_" + i4);
                input8.setOnClickListener(new f2(1, i4, this));
                InputExtensionsKt.addTextChangedListener(input8, new o5(4, input8));
            }
            this.k.setOnClickListener(new c(this));
        } else if (state instanceof State.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void update(@NotNull SingleEvent.UiChange uiChange) {
        Intrinsics.checkNotNullParameter(uiChange, "update");
        if (uiChange instanceof SingleEvent.UiChange.LocationUpdate) {
            Input.setText$default(this.g, ((SingleEvent.UiChange.LocationUpdate) uiChange).getTitle(), false, 2, null);
        } else if (uiChange instanceof SingleEvent.UiChange.TimeUpdate) {
            SingleEvent.UiChange.TimeUpdate timeUpdate = (SingleEvent.UiChange.TimeUpdate) uiChange;
            ViewGroup viewGroup = this.e;
            StringBuilder L = a2.b.a.a.a.L("time_picker_");
            L.append(timeUpdate.getPos());
            Input.setText$default((Input) viewGroup.findViewWithTag(L.toString()), timeUpdate.getTitle(), false, 2, null);
        } else if (uiChange instanceof SingleEvent.UiChange.DateUpdate) {
            SingleEvent.UiChange.DateUpdate dateUpdate = (SingleEvent.UiChange.DateUpdate) uiChange;
            ViewGroup viewGroup2 = this.e;
            StringBuilder L2 = a2.b.a.a.a.L("date_picker_");
            L2.append(dateUpdate.getPos());
            Input.setText$default((Input) viewGroup2.findViewWithTag(L2.toString()), dateUpdate.getTitle(), false, 2, null);
        } else if (uiChange instanceof SingleEvent.UiChange.InvalidResult) {
            SingleEvent.UiChange.InvalidResult invalidResult = (SingleEvent.UiChange.InvalidResult) uiChange;
            if (invalidResult.isLocationInvalid()) {
                this.g.setState(Input.Companion.getSTATE_ERROR());
            }
            if (!invalidResult.getDates().isEmpty()) {
                Iterator<T> it = invalidResult.getDates().iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    ComponentContainer componentContainer = this.f;
                    ((Input) componentContainer.findViewWithTag("time_picker_" + intValue)).setState(Input.Companion.getSTATE_ERROR());
                }
            }
        } else if (Intrinsics.areEqual(uiChange, SingleEvent.UiChange.InviteError.INSTANCE)) {
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = this.a.getString(R.string.interview_invitation_invite_error_snackbar);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…on_invite_error_snackbar)");
            Snackbar position = new Snackbar(context, string).setPosition(SnackbarPosition.ABOVE_VIEW);
            ViewGroup viewGroup3 = this.j;
            Intrinsics.checkNotNullExpressionValue(viewGroup3, "buttonContainer");
            position.setAnchorView(viewGroup3).show();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
