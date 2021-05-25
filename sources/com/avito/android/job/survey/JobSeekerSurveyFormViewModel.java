package com.avito.android.job.survey;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.job.survey.remote.model.Field;
import com.avito.android.job.survey.remote.model.JobSeekerSurveyFormResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001NB\u0017\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\bL\u0010MJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\tJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\tR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001f\u00107\u001a\b\u0012\u0004\u0012\u00020\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010%R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010,R\u001f\u0010B\u001a\b\u0012\u0004\u0012\u00020?028\u0006@\u0006¢\u0006\f\n\u0004\b@\u00104\u001a\u0004\bA\u00106R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0011\u001a\u0004\bH\u0010\u0013R\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010%¨\u0006O"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel;", "Landroidx/lifecycle/ViewModel;", "", "jobApplyId", "", "createSurvey", "(Ljava/lang/String;)V", "recreateSurvey", "onSaveButtonClick", "()V", "value", "setValue", "onCleared", "onSaveState", "Landroidx/lifecycle/LiveData;", "", "l", "Landroidx/lifecycle/LiveData;", "getButtonLoadingStateLiveData", "()Landroidx/lifecycle/LiveData;", "buttonLoadingStateLiveData", "h", "getValueLiveData", "valueLiveData", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState;", "j", "getViewStateLiveData", "viewStateLiveData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "p", "getRefreshButtonLoadingStateLiveData", "refreshButtonLoadingStateLiveData", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "mutableViewStateLiveData", "o", "mutableRefreshButtonLoadingStateLiveData", "k", "mutableButtonLoadingStateLiveData", "e", "Ljava/lang/String;", "formId", "Lcom/avito/android/job/survey/SurveyFormInteractor;", "t", "Lcom/avito/android/job/survey/SurveyFormInteractor;", "surveyFormInteractor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "r", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getToastLiveData", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "toastLiveData", g.a, "mutableValueLiveData", "", "d", "I", "surveyId", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", VKApiConst.Q, "getDeepLinkLiveData", "deepLinkLiveData", "Lcom/avito/android/util/SchedulersFactory3;", "s", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "n", "getButtonEnabledStateLiveData", "buttonEnabledStateLiveData", AuthSource.OPEN_CHANNEL_LIST, "mutableButtonEnabledStateLiveData", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/job/survey/SurveyFormInteractor;)V", "ViewState", "survey_release"}, k = 1, mv = {1, 4, 2})
public final class JobSeekerSurveyFormViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public int d;
    public String e;
    public String f = "";
    public final MutableLiveData<String> g;
    @NotNull
    public final LiveData<String> h;
    public final MutableLiveData<ViewState> i;
    @NotNull
    public final LiveData<ViewState> j;
    public final MutableLiveData<Boolean> k;
    @NotNull
    public final LiveData<Boolean> l;
    public final MutableLiveData<Boolean> m;
    @NotNull
    public final LiveData<Boolean> n;
    public final MutableLiveData<Boolean> o;
    @NotNull
    public final LiveData<Boolean> p;
    @NotNull
    public final SingleLiveEvent<DeepLink> q;
    @NotNull
    public final SingleLiveEvent<String> r;
    public final SchedulersFactory3 s;
    public final SurveyFormInteractor t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState;", "", "<init>", "()V", "Error", "FormViewState", "Loading", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$Loading;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$Error;", "survey_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$Error;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "survey_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ViewState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB)\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;", "c", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;", "getField", "()Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;", AnalyticFieldsName.field, "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getSubtitle", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$ActionViewState;", "d", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$ActionViewState;", "getAction", "()Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$ActionViewState;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$ActionViewState;)V", "ActionViewState", "FieldViewState", "survey_release"}, k = 1, mv = {1, 4, 2})
        public static final class FormViewState extends ViewState {
            @NotNull
            public final String a;
            @Nullable
            public final String b;
            @NotNull
            public final FieldViewState c;
            @NotNull
            public final ActionViewState d;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$ActionViewState;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "survey_release"}, k = 1, mv = {1, 4, 2})
            public static final class ActionViewState {
                @NotNull
                public final String a;
                @NotNull
                public final DeepLink b;

                public ActionViewState(@NotNull String str, @NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(str, "title");
                    Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                    this.a = str;
                    this.b = deepLink;
                }

                @NotNull
                public final DeepLink getDeeplink() {
                    return this.b;
                }

                @NotNull
                public final String getTitle() {
                    return this.a;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;", "", "<init>", "()V", "RadioGroupViewState", "TextAreaViewState", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState$RadioGroupViewState;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState$TextAreaViewState;", "survey_release"}, k = 1, mv = {1, 4, 2})
            public static abstract class FieldViewState {

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState$RadioGroupViewState;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;", "", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState$RadioGroupViewState$OptionViewState;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "options", "<init>", "(Ljava/util/List;)V", "OptionViewState", "survey_release"}, k = 1, mv = {1, 4, 2})
                public static final class RadioGroupViewState extends FieldViewState {
                    @NotNull
                    public final List<OptionViewState> a;

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState$RadioGroupViewState$OptionViewState;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "c", "Z", "isChecked", "()Z", AuthSource.BOOKING_ORDER, "getValue", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "survey_release"}, k = 1, mv = {1, 4, 2})
                    public static final class OptionViewState {
                        @NotNull
                        public final String a;
                        @NotNull
                        public final String b;
                        public final boolean c;

                        public OptionViewState(@NotNull String str, @NotNull String str2, boolean z) {
                            Intrinsics.checkNotNullParameter(str, "title");
                            Intrinsics.checkNotNullParameter(str2, "value");
                            this.a = str;
                            this.b = str2;
                            this.c = z;
                        }

                        @NotNull
                        public final String getTitle() {
                            return this.a;
                        }

                        @NotNull
                        public final String getValue() {
                            return this.b;
                        }

                        public final boolean isChecked() {
                            return this.c;
                        }
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public RadioGroupViewState(@NotNull List<OptionViewState> list) {
                        super(null);
                        Intrinsics.checkNotNullParameter(list, "options");
                        this.a = list;
                    }

                    @NotNull
                    public final List<OptionViewState> getOptions() {
                        return this.a;
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState$TextAreaViewState;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$FormViewState$FieldViewState;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "hint", AuthSource.SEND_ABUSE, "getValue", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "survey_release"}, k = 1, mv = {1, 4, 2})
                public static final class TextAreaViewState extends FieldViewState {
                    @Nullable
                    public final String a;
                    @NotNull
                    public final String b;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public TextAreaViewState(@Nullable String str, @NotNull String str2) {
                        super(null);
                        Intrinsics.checkNotNullParameter(str2, "hint");
                        this.a = str;
                        this.b = str2;
                    }

                    @NotNull
                    public final String getHint() {
                        return this.b;
                    }

                    @Nullable
                    public final String getValue() {
                        return this.a;
                    }
                }

                public FieldViewState() {
                }

                public FieldViewState(j jVar) {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FormViewState(@NotNull String str, @Nullable String str2, @NotNull FieldViewState fieldViewState, @NotNull ActionViewState actionViewState) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(fieldViewState, AnalyticFieldsName.field);
                Intrinsics.checkNotNullParameter(actionViewState, "action");
                this.a = str;
                this.b = str2;
                this.c = fieldViewState;
                this.d = actionViewState;
            }

            @NotNull
            public final ActionViewState getAction() {
                return this.d;
            }

            @NotNull
            public final FieldViewState getField() {
                return this.c;
            }

            @Nullable
            public final String getSubtitle() {
                return this.b;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState$Loading;", "Lcom/avito/android/job/survey/JobSeekerSurveyFormViewModel$ViewState;", "<init>", "()V", "survey_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ JobSeekerSurveyFormViewModel a;

        public a(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
            this.a = jobSeekerSurveyFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.i.setValue(ViewState.Loading.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer<TypedResult<JobSeekerSurveyFormResponse>> {
        public final /* synthetic */ JobSeekerSurveyFormViewModel a;

        public b(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
            this.a = jobSeekerSurveyFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<JobSeekerSurveyFormResponse> typedResult) {
            TypedResult<JobSeekerSurveyFormResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.setValue("");
                JobSeekerSurveyFormViewModel.access$handleForm(this.a, (TypedResult.OfResult) typedResult2);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.i.setValue(new ViewState.Error(((TypedResult.OfError) typedResult2).getError().getMessage()));
            }
        }
    }

    public static final class c<T> implements Consumer<Disposable> {
        public final /* synthetic */ JobSeekerSurveyFormViewModel a;

        public c(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
            this.a = jobSeekerSurveyFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.k.setValue(Boolean.TRUE);
            this.a.m.setValue(Boolean.FALSE);
        }
    }

    public static final class d<T> implements Consumer<TypedResult<JobSeekerSurveyFormResponse>> {
        public final /* synthetic */ JobSeekerSurveyFormViewModel a;

        public d(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
            this.a = jobSeekerSurveyFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r3v9, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<JobSeekerSurveyFormResponse> typedResult) {
            TypedResult<JobSeekerSurveyFormResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.setValue("");
                JobSeekerSurveyFormViewModel.access$handleForm(this.a, (TypedResult.OfResult) typedResult2);
                this.a.k.setValue(Boolean.FALSE);
                this.a.m.setValue(Boolean.TRUE);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.k.setValue(Boolean.FALSE);
                this.a.m.setValue(Boolean.TRUE);
                this.a.getToastLiveData().setValue(((TypedResult.OfError) typedResult2).getError().getMessage());
            }
        }
    }

    public static final class e<T> implements Consumer<Disposable> {
        public final /* synthetic */ JobSeekerSurveyFormViewModel a;

        public e(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
            this.a = jobSeekerSurveyFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.o.setValue(Boolean.TRUE);
        }
    }

    public static final class f<T> implements Consumer<TypedResult<JobSeekerSurveyFormResponse>> {
        public final /* synthetic */ JobSeekerSurveyFormViewModel a;

        public f(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel) {
            this.a = jobSeekerSurveyFormViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<JobSeekerSurveyFormResponse> typedResult) {
            TypedResult<JobSeekerSurveyFormResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.setValue("");
                JobSeekerSurveyFormViewModel.access$handleForm(this.a, (TypedResult.OfResult) typedResult2);
                this.a.o.setValue(Boolean.FALSE);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.o.setValue(Boolean.FALSE);
                this.a.getToastLiveData().setValue(((TypedResult.OfError) typedResult2).getError().getMessage());
            }
        }
    }

    public JobSeekerSurveyFormViewModel(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull SurveyFormInteractor surveyFormInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(surveyFormInteractor, "surveyFormInteractor");
        this.s = schedulersFactory3;
        this.t = surveyFormInteractor;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.g = mutableLiveData;
        this.h = mutableLiveData;
        MutableLiveData<ViewState> mutableLiveData2 = new MutableLiveData<>();
        this.i = mutableLiveData2;
        this.j = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this.k = mutableLiveData3;
        this.l = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.m = mutableLiveData4;
        this.n = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this.o = mutableLiveData5;
        this.p = mutableLiveData5;
        this.q = new SingleLiveEvent<>();
        this.r = new SingleLiveEvent<>();
    }

    public static final void access$handleForm(JobSeekerSurveyFormViewModel jobSeekerSurveyFormViewModel, TypedResult.OfResult ofResult) {
        Objects.requireNonNull(jobSeekerSurveyFormViewModel);
        JobSeekerSurveyFormResponse jobSeekerSurveyFormResponse = (JobSeekerSurveyFormResponse) ofResult.getResult();
        if (jobSeekerSurveyFormResponse instanceof JobSeekerSurveyFormResponse.NextStep) {
            JobSeekerSurveyFormResponse.NextStep nextStep = (JobSeekerSurveyFormResponse.NextStep) jobSeekerSurveyFormResponse;
            jobSeekerSurveyFormViewModel.d = nextStep.getSurveyId();
            jobSeekerSurveyFormViewModel.e = nextStep.getFormId();
            Field field = nextStep.getField();
            if (field instanceof Field.RadioGroupField) {
                jobSeekerSurveyFormViewModel.i.setValue(new ViewState.FormViewState(nextStep.getTitle(), nextStep.getSubtitle(), JobSeekerSurveyFormViewModelKt.access$toViewModel((Field.RadioGroupField) field, jobSeekerSurveyFormViewModel.g.getValue()), JobSeekerSurveyFormViewModelKt.access$toViewModel(nextStep.getAction())));
            } else if (field instanceof Field.TextAreaField) {
                jobSeekerSurveyFormViewModel.i.setValue(new ViewState.FormViewState(nextStep.getTitle(), nextStep.getSubtitle(), JobSeekerSurveyFormViewModelKt.access$toViewModel((Field.TextAreaField) field, jobSeekerSurveyFormViewModel.g.getValue()), JobSeekerSurveyFormViewModelKt.access$toViewModel(nextStep.getAction())));
            }
        } else if (jobSeekerSurveyFormResponse instanceof JobSeekerSurveyFormResponse.Completed) {
            jobSeekerSurveyFormViewModel.q.setValue(((JobSeekerSurveyFormResponse.Completed) jobSeekerSurveyFormResponse).getDeeplink());
        }
    }

    public final void createSurvey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jobApplyId");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.t.createSurvey(str).throttleFirst(300, TimeUnit.MILLISECONDS).subscribeOn(this.s.io()).observeOn(this.s.mainThread()).doOnSubscribe(new a(this)).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "surveyFormInteractor\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<Boolean> getButtonEnabledStateLiveData() {
        return this.n;
    }

    @NotNull
    public final LiveData<Boolean> getButtonLoadingStateLiveData() {
        return this.l;
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getDeepLinkLiveData() {
        return this.q;
    }

    @NotNull
    public final LiveData<Boolean> getRefreshButtonLoadingStateLiveData() {
        return this.p;
    }

    @NotNull
    public final SingleLiveEvent<String> getToastLiveData() {
        return this.r;
    }

    @NotNull
    public final LiveData<String> getValueLiveData() {
        return this.h;
    }

    @NotNull
    public final LiveData<ViewState> getViewStateLiveData() {
        return this.j;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
    }

    public final void onSaveButtonClick() {
        CompositeDisposable compositeDisposable = this.c;
        SurveyFormInteractor surveyFormInteractor = this.t;
        int i2 = this.d;
        String str = this.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formId");
        }
        Disposable subscribe = surveyFormInteractor.saveForm(i2, str, this.f).throttleFirst(300, TimeUnit.MILLISECONDS).subscribeOn(this.s.io()).observeOn(this.s.mainThread()).doOnSubscribe(new c(this)).subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "surveyFormInteractor\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void onSaveState() {
        this.g.setValue(this.f);
    }

    public final void recreateSurvey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jobApplyId");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.t.createSurvey(str).throttleFirst(300, TimeUnit.MILLISECONDS).subscribeOn(this.s.io()).observeOn(this.s.mainThread()).doOnSubscribe(new e(this)).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "surveyFormInteractor\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f = str;
        this.m.setValue(Boolean.valueOf(!m.isBlank(str)));
    }
}
