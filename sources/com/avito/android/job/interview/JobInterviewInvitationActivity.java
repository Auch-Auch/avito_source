package com.avito.android.job.interview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.SingleEvent;
import com.avito.android.job.interview.di.DaggerInterviewInvitationComponent;
import com.avito.android.job.interview.di.InterviewInvitationDependencies;
import com.avito.android.job.interview.pickers.DatePickerDialog;
import com.avito.android.job.interview.pickers.TimePickerDialog;
import com.avito.android.location_picker.LocationPickerActivity;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.ui.activity.BaseActivity;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/job/interview/JobInterviewInvitationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;", "viewModel", "Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;", "getViewModel", "()Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;", "setViewModel", "(Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;)V", "<init>", "()V", "Companion", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class JobInterviewInvitationActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public JobInterviewInvitationViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/job/interview/JobInterviewInvitationActivity$Companion;", "", "Landroid/content/Context;", "context", "", "id", "Landroid/content/Intent;", "getIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_INVITATION_ID", "Ljava/lang/String;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent getIntent(@NotNull Context context, @NotNull String str) {
            return a2.b.a.a.a.j1(context, "context", str, "id", context, JobInterviewInvitationActivity.class, "interview_invitation_id", str, "Intent(context, JobInter…(EXTRA_INVITATION_ID, id)");
        }

        public Companion(j jVar) {
        }
    }

    public static final class b<T> implements Observer<SingleEvent> {
        public final /* synthetic */ JobInterviewInvitationActivity a;
        public final /* synthetic */ JobInterviewInvitationRenderer b;

        public b(JobInterviewInvitationActivity jobInterviewInvitationActivity, JobInterviewInvitationRenderer jobInterviewInvitationRenderer) {
            this.a = jobInterviewInvitationActivity;
            this.b = jobInterviewInvitationRenderer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(SingleEvent singleEvent) {
            SingleEvent singleEvent2 = singleEvent;
            JobInterviewInvitationActivity jobInterviewInvitationActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(singleEvent2, "it");
            JobInterviewInvitationActivity.access$handle(jobInterviewInvitationActivity, singleEvent2, this.b);
        }
    }

    public static final void access$handle(JobInterviewInvitationActivity jobInterviewInvitationActivity, SingleEvent singleEvent, JobInterviewInvitationRenderer jobInterviewInvitationRenderer) {
        Objects.requireNonNull(jobInterviewInvitationActivity);
        if (singleEvent instanceof SingleEvent.Navigation) {
            SingleEvent.Navigation navigation = (SingleEvent.Navigation) singleEvent;
            JobInterviewInvitationViewModel jobInterviewInvitationViewModel = jobInterviewInvitationActivity.viewModel;
            if (jobInterviewInvitationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            PublishRelay<Action> actions = jobInterviewInvitationViewModel.getActions();
            if (navigation instanceof SingleEvent.Navigation.LocationPicker) {
                Location location = ((SingleEvent.Navigation.LocationPicker) navigation).getLocation();
                jobInterviewInvitationActivity.startActivityForResult(LocationPickerActivity.Companion.createLocationPickerActivityIntent$default(LocationPickerActivity.Companion, jobInterviewInvitationActivity, location != null ? new AddressParameter.Value(location.getLat(), location.getLng(), location.getText(), null, 8, null) : null, null, null, null, null, null, null, null, 508, null), 1234);
            } else if (navigation instanceof SingleEvent.Navigation.DatePicker) {
                SingleEvent.Navigation.DatePicker datePicker = (SingleEvent.Navigation.DatePicker) navigation;
                new DatePickerDialog(jobInterviewInvitationActivity, datePicker.getPos(), actions, datePicker.getDateEntry()).show();
            } else if (navigation instanceof SingleEvent.Navigation.TimePicker) {
                new TimePickerDialog(jobInterviewInvitationActivity, ((SingleEvent.Navigation.TimePicker) navigation).getPos(), actions, null, 8, null).show();
            } else if (navigation instanceof SingleEvent.Navigation.Exit) {
                jobInterviewInvitationActivity.finish();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (singleEvent instanceof SingleEvent.UiChange) {
            jobInterviewInvitationRenderer.update((SingleEvent.UiChange) singleEvent);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final JobInterviewInvitationViewModel getViewModel() {
        JobInterviewInvitationViewModel jobInterviewInvitationViewModel = this.viewModel;
        if (jobInterviewInvitationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return jobInterviewInvitationViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1234) {
            AddressParameter.Value value = intent != null ? (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT) : null;
            if (value != null) {
                JobInterviewInvitationViewModel jobInterviewInvitationViewModel = this.viewModel;
                if (jobInterviewInvitationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                jobInterviewInvitationViewModel.getActions().accept(new Action.LocationChanged(value));
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.interview_invitation_activity);
        String stringExtra = getIntent().getStringExtra("interview_invitation_id");
        Intrinsics.checkNotNull(stringExtra);
        DaggerInterviewInvitationComponent.factory().buildComponent((InterviewInvitationDependencies) ComponentDependenciesKt.getDependencies(InterviewInvitationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)), stringExtra, this).inject(this);
        View findViewById = findViewById(R.id.root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        JobInterviewInvitationViewModel jobInterviewInvitationViewModel = this.viewModel;
        if (jobInterviewInvitationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        JobInterviewInvitationRenderer jobInterviewInvitationRenderer = new JobInterviewInvitationRenderer(viewGroup, this, jobInterviewInvitationViewModel.getActions());
        JobInterviewInvitationViewModel jobInterviewInvitationViewModel2 = this.viewModel;
        if (jobInterviewInvitationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        jobInterviewInvitationViewModel2.getState().observe(this, new a2.a.a.j1.b.a(new Function1<State, Unit>(jobInterviewInvitationRenderer) { // from class: com.avito.android.job.interview.JobInterviewInvitationActivity.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(State state) {
                State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "p1");
                ((JobInterviewInvitationRenderer) this.receiver).render(state2);
                return Unit.INSTANCE;
            }
        }));
        JobInterviewInvitationViewModel jobInterviewInvitationViewModel3 = this.viewModel;
        if (jobInterviewInvitationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        jobInterviewInvitationViewModel3.getSingleEvents().observe(this, new b(this, jobInterviewInvitationRenderer));
    }

    public final void setViewModel(@NotNull JobInterviewInvitationViewModel jobInterviewInvitationViewModel) {
        Intrinsics.checkNotNullParameter(jobInterviewInvitationViewModel, "<set-?>");
        this.viewModel = jobInterviewInvitationViewModel;
    }
}
