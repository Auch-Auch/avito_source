package com.avito.android.job.interview;

import a2.a.a.j1.b.h;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.JobInterviewInvitationViewModel;
import com.avito.android.job.interview.SingleEvent;
import com.avito.android.job.interview.State;
import com.avito.android.job.interview.ValidationResult;
import com.avito.android.job.interview.domain.DateEntry;
import com.avito.android.job.interview.domain.InterviewInvitationInteractor;
import com.avito.android.job.interview.domain.InvitationDraft;
import com.avito.android.job.interview.domain.Result;
import com.avito.android.job.interview.pickers.TimePickerResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.Disposables;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/job/interview/JobInterviewInvitationViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "c", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;", "i", "Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;", "interactor", "Lcom/avito/android/job/interview/domain/InvitationDraft;", "Lcom/avito/android/job/interview/domain/InvitationDraft;", AnalyticFieldsName.draft, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", g.a, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/job/interview/State;", "d", "Landroidx/lifecycle/MutableLiveData;", "_state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "state", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/job/interview/Action;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "getActions", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "actions", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/job/interview/SingleEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSingleEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "singleEvents", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;)V", "Factory", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class JobInterviewInvitationViewModel extends ViewModel {
    public InvitationDraft c;
    public final MutableLiveData<State> d = new MutableLiveData<>();
    @NotNull
    public final PublishRelay<Action> e;
    @NotNull
    public final SingleLiveEvent<SingleEvent> f;
    public final CompositeDisposable g;
    public final SchedulersFactory3 h;
    public final InterviewInvitationInteractor i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/job/interview/JobInterviewInvitationViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;", "interactor", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory implements ViewModelProvider.Factory {
        public final SchedulersFactory3 a;
        public final InterviewInvitationInteractor b;

        @Inject
        public Factory(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull InterviewInvitationInteractor interviewInvitationInteractor) {
            Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
            Intrinsics.checkNotNullParameter(interviewInvitationInteractor, "interactor");
            this.a = schedulersFactory3;
            this.b = interviewInvitationInteractor;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            if (cls.isAssignableFrom(JobInterviewInvitationViewModel.class)) {
                return new JobInterviewInvitationViewModel(this.a, this.b);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

    public static final class b<T> implements Consumer<State> {
        public final /* synthetic */ JobInterviewInvitationViewModel a;

        public b(JobInterviewInvitationViewModel jobInterviewInvitationViewModel) {
            this.a = jobInterviewInvitationViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(State state) {
            State state2 = state;
            if (state2 instanceof State.Content) {
                this.a.c = ((State.Content) state2).getDraft();
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public JobInterviewInvitationViewModel(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull InterviewInvitationInteractor interviewInvitationInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(interviewInvitationInteractor, "interactor");
        this.h = schedulersFactory3;
        this.i = interviewInvitationInteractor;
        PublishRelay<Action> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.e = create;
        this.f = new SingleLiveEvent<>();
        this.g = new CompositeDisposable();
        c();
        create.observeOn(schedulersFactory3.mainThread()).subscribe(new a2.a.a.j1.b.g(new Function1<Action, Unit>(this) { // from class: a2.a.a.j1.b.f
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Action action) {
                Action action2 = action;
                Intrinsics.checkNotNullParameter(action2, "p1");
                JobInterviewInvitationViewModel.access$handleAction((JobInterviewInvitationViewModel) this.receiver, action2);
                return Unit.INSTANCE;
            }
        }));
    }

    public static final /* synthetic */ InvitationDraft access$getDraft$p(JobInterviewInvitationViewModel jobInterviewInvitationViewModel) {
        InvitationDraft invitationDraft = jobInterviewInvitationViewModel.c;
        if (invitationDraft == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
        }
        return invitationDraft;
    }

    public static final void access$handleAction(JobInterviewInvitationViewModel jobInterviewInvitationViewModel, Action action) {
        DateEntry dateEntry;
        Object obj;
        Objects.requireNonNull(jobInterviewInvitationViewModel);
        if (action instanceof Action.ChangeDate) {
            Action.ChangeDate changeDate = (Action.ChangeDate) action;
            InvitationDraft invitationDraft = jobInterviewInvitationViewModel.c;
            if (invitationDraft == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.f.postValue(new SingleEvent.Navigation.DatePicker(changeDate.getPos(), invitationDraft.getDates().get(changeDate.getPos())));
        } else if (action instanceof Action.ChangeTime) {
            Action.ChangeTime changeTime = (Action.ChangeTime) action;
            InvitationDraft invitationDraft2 = jobInterviewInvitationViewModel.c;
            if (invitationDraft2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.f.postValue(new SingleEvent.Navigation.TimePicker(changeTime.getPos(), invitationDraft2.getDates().get(changeTime.getPos())));
        } else if (action instanceof Action.PickLocation) {
            jobInterviewInvitationViewModel.f.postValue(new SingleEvent.Navigation.LocationPicker(((Action.PickLocation) action).getLocation()));
        } else if (Intrinsics.areEqual(action, Action.Refresh.INSTANCE)) {
            jobInterviewInvitationViewModel.c();
        } else if (Intrinsics.areEqual(action, Action.Invite.INSTANCE)) {
            InvitationDraft invitationDraft3 = jobInterviewInvitationViewModel.c;
            if (invitationDraft3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            List<DateEntry> dates = invitationDraft3.getDates();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            int i2 = 0;
            for (T t : dates) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (t.getFromTime() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
                i2 = i3;
            }
            if (invitationDraft3.getLocation() != null) {
                z = true;
            }
            if (!arrayList.isEmpty() || !z) {
                obj = new ValidationResult.Invalid(arrayList, true ^ z);
            } else {
                obj = ValidationResult.Valid.INSTANCE;
            }
            if (obj instanceof ValidationResult.Invalid) {
                ValidationResult.Invalid invalid = (ValidationResult.Invalid) obj;
                jobInterviewInvitationViewModel.f.postValue(new SingleEvent.UiChange.InvalidResult(invalid.getDates(), invalid.isLocationInvalid()));
            } else if (Intrinsics.areEqual(obj, ValidationResult.Valid.INSTANCE)) {
                CompositeDisposable compositeDisposable = jobInterviewInvitationViewModel.g;
                InterviewInvitationInteractor interviewInvitationInteractor = jobInterviewInvitationViewModel.i;
                InvitationDraft invitationDraft4 = jobInterviewInvitationViewModel.c;
                if (invitationDraft4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
                }
                Disposable subscribe = interviewInvitationInteractor.invite(invitationDraft4).observeOn(jobInterviewInvitationViewModel.h.mainThread()).doOnSubscribe(new a2.a.a.j1.b.d(jobInterviewInvitationViewModel)).subscribe(new a2.a.a.j1.b.g(new Function1<TypedResult<Unit>, Unit>(jobInterviewInvitationViewModel) { // from class: a2.a.a.j1.b.e
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(TypedResult<Unit> typedResult) {
                        TypedResult<Unit> typedResult2 = typedResult;
                        Intrinsics.checkNotNullParameter(typedResult2, "p1");
                        JobInterviewInvitationViewModel.access$handleInviteResult((JobInterviewInvitationViewModel) this.receiver, typedResult2);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.invite(draft)…ibe(::handleInviteResult)");
                Disposables.plusAssign(compositeDisposable, subscribe);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (action instanceof Action.TimeChanged) {
            Action.TimeChanged timeChanged = (Action.TimeChanged) action;
            InvitationDraft invitationDraft5 = jobInterviewInvitationViewModel.c;
            if (invitationDraft5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            DateEntry dateEntry2 = invitationDraft5.getDates().get(timeChanged.getPos());
            TimePickerResult result = timeChanged.getResult();
            if (result instanceof TimePickerResult.Specific) {
                dateEntry = DateEntry.copy$default(dateEntry2, null, 0, 0, result.getTitle(), result.getTitle(), null, 39, null);
            } else if (result instanceof TimePickerResult.Interval) {
                String title = result.getTitle();
                TimePickerResult.Interval interval = (TimePickerResult.Interval) result;
                dateEntry = DateEntry.copy$default(dateEntry2, null, 0, 0, title, interval.getFrom(), interval.getTo(), 7, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            InvitationDraft invitationDraft6 = jobInterviewInvitationViewModel.c;
            if (invitationDraft6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) invitationDraft6.getDates());
            mutableList.set(timeChanged.getPos(), dateEntry);
            InvitationDraft invitationDraft7 = jobInterviewInvitationViewModel.c;
            if (invitationDraft7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.c = InvitationDraft.copy$default(invitationDraft7, mutableList, null, null, null, 14, null);
            jobInterviewInvitationViewModel.f.postValue(new SingleEvent.UiChange.TimeUpdate(timeChanged.getPos(), timeChanged.getResult().getTitle()));
        } else if (action instanceof Action.DateChanged) {
            Action.DateChanged dateChanged = (Action.DateChanged) action;
            InvitationDraft invitationDraft8 = jobInterviewInvitationViewModel.c;
            if (invitationDraft8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            DateEntry copy$default = DateEntry.copy$default(invitationDraft8.getDates().get(dateChanged.getPos()), dateChanged.getTitle(), dateChanged.getMonth(), dateChanged.getDay(), null, null, null, 56, null);
            InvitationDraft invitationDraft9 = jobInterviewInvitationViewModel.c;
            if (invitationDraft9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            List mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) invitationDraft9.getDates());
            mutableList2.set(dateChanged.getPos(), copy$default);
            InvitationDraft invitationDraft10 = jobInterviewInvitationViewModel.c;
            if (invitationDraft10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.c = InvitationDraft.copy$default(invitationDraft10, mutableList2, null, null, null, 14, null);
            jobInterviewInvitationViewModel.f.postValue(new SingleEvent.UiChange.DateUpdate(dateChanged.getPos(), dateChanged.getTitle()));
        } else if (action instanceof Action.LocationChanged) {
            Action.LocationChanged locationChanged = (Action.LocationChanged) action;
            AddressParameter.Value result2 = locationChanged.getResult();
            String text = locationChanged.getResult().getText();
            if (text == null) {
                text = "";
            }
            Location location = new Location(text, result2.getLat(), result2.getLng());
            InvitationDraft invitationDraft11 = jobInterviewInvitationViewModel.c;
            if (invitationDraft11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.c = InvitationDraft.copy$default(invitationDraft11, null, location, null, null, 13, null);
            jobInterviewInvitationViewModel.f.postValue(new SingleEvent.UiChange.LocationUpdate(location.getText()));
        } else if (action instanceof Action.PhoneChanged) {
            InvitationDraft invitationDraft12 = jobInterviewInvitationViewModel.c;
            if (invitationDraft12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.c = InvitationDraft.copy$default(invitationDraft12, null, null, ((Action.PhoneChanged) action).getPhone(), null, 11, null);
        } else if (action instanceof Action.MessageChanged) {
            InvitationDraft invitationDraft13 = jobInterviewInvitationViewModel.c;
            if (invitationDraft13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            jobInterviewInvitationViewModel.c = InvitationDraft.copy$default(invitationDraft13, null, null, null, ((Action.MessageChanged) action).getMessage(), 7, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void access$handleInviteResult(JobInterviewInvitationViewModel jobInterviewInvitationViewModel, TypedResult typedResult) {
        Objects.requireNonNull(jobInterviewInvitationViewModel);
        if (typedResult instanceof TypedResult.OfError) {
            MutableLiveData<State> mutableLiveData = jobInterviewInvitationViewModel.d;
            InvitationDraft invitationDraft = jobInterviewInvitationViewModel.c;
            if (invitationDraft == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            mutableLiveData.postValue(new State.Content(invitationDraft));
            jobInterviewInvitationViewModel.f.postValue(SingleEvent.UiChange.InviteError.INSTANCE);
        } else if (typedResult instanceof TypedResult.OfResult) {
            jobInterviewInvitationViewModel.f.postValue(SingleEvent.Navigation.Exit.INSTANCE);
        }
    }

    public static final State access$mapToState(JobInterviewInvitationViewModel jobInterviewInvitationViewModel, Result result) {
        Objects.requireNonNull(jobInterviewInvitationViewModel);
        if (result instanceof Result.Failure) {
            return State.Error.INSTANCE;
        }
        if (result instanceof Result.Success) {
            return new State.Content(((Result.Success) result).getInvitationDraft());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void c() {
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.i.loadInterviewInvitation().map(new h(new Function1<Result, State>(this) { // from class: com.avito.android.job.interview.JobInterviewInvitationViewModel.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public State invoke(Result result) {
                Result result2 = result;
                Intrinsics.checkNotNullParameter(result2, "p1");
                return JobInterviewInvitationViewModel.access$mapToState((JobInterviewInvitationViewModel) this.receiver, result2);
            }
        })).startWithItem((R) State.Loading.INSTANCE).subscribeOn(this.h.io()).observeOn(this.h.mainThread()).doOnNext(new b(this)).subscribe(new a2.a.a.j1.b.g(new Function1<State, Unit>(this.d) { // from class: com.avito.android.job.interview.JobInterviewInvitationViewModel.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(State state) {
                ((MutableLiveData) this.receiver).postValue(state);
                return Unit.INSTANCE;
            }
        }), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadInterview… err -> Logs.error(err) }");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final PublishRelay<Action> getActions() {
        return this.e;
    }

    @NotNull
    public final SingleLiveEvent<SingleEvent> getSingleEvents() {
        return this.f;
    }

    @NotNull
    public final LiveData<State> getState() {
        if (this.d.getValue() instanceof State.Content) {
            MutableLiveData<State> mutableLiveData = this.d;
            InvitationDraft invitationDraft = this.c;
            if (invitationDraft == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AnalyticFieldsName.draft);
            }
            mutableLiveData.setValue(new State.Content(invitationDraft));
        }
        return this.d;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.g.dispose();
    }
}
