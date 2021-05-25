package com.avito.android.advert.item.questionnaire;

import a2.a.a.f.x.y.b;
import a2.a.a.f.x.y.c;
import a2.a.a.f.x.y.d;
import a2.g.r.g;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.questionnaire.di.QuestionnaireState;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Questionnaire;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenterImpl;", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter;", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "Landroid/view/View;", "view", "", "attachView", "(Landroid/view/View;)V", "detachView", "()V", "Lcom/avito/android/remote/model/Questionnaire;", "questionnaire", "showIfNeeded", "(Lcom/avito/android/remote/model/Questionnaire;)V", "Lcom/avito/android/remote/model/Questionnaire$Question;", "question", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Questionnaire;Lcom/avito/android/remote/model/Questionnaire$Question;)V", "Lcom/avito/android/advert/item/questionnaire/QuestionnaireView;", "c", "Lcom/avito/android/advert/item/questionnaire/QuestionnaireView;", "questionnaireView", "d", "Lcom/avito/android/remote/model/Questionnaire$Question;", "currentQuestion", "", "e", "Z", "wasCancelled", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Landroid/view/View;", "Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;", g.a, "Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;", "storage", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;", "f", "Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;", "getListener", "()Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;", "setListener", "(Lcom/avito/android/advert/item/questionnaire/QuestionnairePresenter$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "state", "<init>", "(Landroid/os/Bundle;Lcom/avito/android/advert/item/questionnaire/QuestionnaireStorage;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class QuestionnairePresenterImpl implements QuestionnairePresenter {
    public View a;
    public BottomSheetDialog b;
    public QuestionnaireView c;
    public Questionnaire.Question d;
    public boolean e;
    @Nullable
    public QuestionnairePresenter.Listener f;
    public final QuestionnaireStorage g;

    public static final class a extends Lambda implements Function1<Questionnaire.Answer, Unit> {
        public final /* synthetic */ QuestionnairePresenterImpl a;
        public final /* synthetic */ Questionnaire.Question b;
        public final /* synthetic */ Questionnaire c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire.Question question, Questionnaire questionnaire) {
            super(1);
            this.a = questionnairePresenterImpl;
            this.b = question;
            this.c = questionnaire;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Questionnaire.Answer answer) {
            Window window;
            Questionnaire.Answer answer2 = answer;
            Intrinsics.checkNotNullParameter(answer2, "answer");
            QuestionnairePresenter.Listener listener = this.a.getListener();
            if (listener != null) {
                listener.onQuestionAnswered(this.b, answer2);
            }
            BottomSheetDialog bottomSheetDialog = this.a.b;
            ViewGroup viewGroup = null;
            View decorView = (bottomSheetDialog == null || (window = bottomSheetDialog.getWindow()) == null) ? null : window.getDecorView();
            if (decorView instanceof ViewGroup) {
                viewGroup = decorView;
            }
            ViewGroup viewGroup2 = viewGroup;
            Questionnaire.Question access$getNextQuestion = QuestionnairePresenterImpl.access$getNextQuestion(this.a, this.c, this.b);
            if (answer2.isFinal() || access$getNextQuestion == null || viewGroup2 == null) {
                QuestionnairePresenterImpl.access$completeQuestionnaire(this.a, this.c);
                BottomSheetDialog bottomSheetDialog2 = this.a.b;
                if (bottomSheetDialog2 != null) {
                    bottomSheetDialog2.close();
                }
                QuestionnairePresenter.Listener listener2 = this.a.getListener();
                if (listener2 != null) {
                    listener2.onCompleted();
                }
            } else {
                QuestionnairePresenterImpl.access$showNextQuestion(this.a, this.c, access$getNextQuestion, viewGroup2);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public QuestionnairePresenterImpl(@QuestionnaireState @Nullable Bundle bundle, @NotNull QuestionnaireStorage questionnaireStorage) {
        Intrinsics.checkNotNullParameter(questionnaireStorage, "storage");
        this.g = questionnaireStorage;
        this.e = bundle != null ? bundle.getBoolean("questionnaire_was_cancelled", false) : false;
    }

    public static final void access$completeQuestionnaire(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire questionnaire) {
        questionnairePresenterImpl.g.setQuestionnaireCompleted(questionnaire.getId());
    }

    public static final Questionnaire.Question access$getNextQuestion(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire questionnaire, Questionnaire.Question question) {
        int i;
        Objects.requireNonNull(questionnairePresenterImpl);
        int indexOf = questionnaire.getQuestions().indexOf(question);
        if (indexOf == -1 || (i = indexOf + 1) >= questionnaire.getQuestions().size()) {
            return null;
        }
        return questionnaire.getQuestions().get(i);
    }

    public static final void access$onDismissed(QuestionnairePresenterImpl questionnairePresenterImpl) {
        questionnairePresenterImpl.c = null;
        questionnairePresenterImpl.b = null;
        questionnairePresenterImpl.d = null;
        questionnairePresenterImpl.setListener(null);
    }

    public static final void access$showNextQuestion(QuestionnairePresenterImpl questionnairePresenterImpl, Questionnaire questionnaire, Questionnaire.Question question, ViewGroup viewGroup) {
        Objects.requireNonNull(questionnairePresenterImpl);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new Fade(2));
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new Fade(1));
        TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
        questionnairePresenterImpl.a(questionnaire, question);
    }

    public final void a(Questionnaire questionnaire, Questionnaire.Question question) {
        this.d = question;
        QuestionnairePresenter.Listener listener = getListener();
        if (listener != null) {
            listener.onQuestionAppeared(question);
        }
        this.g.setLastOpenedQuestionId(questionnaire.getId(), question.getId());
        QuestionnaireView questionnaireView = this.c;
        if (questionnaireView != null) {
            questionnaireView.setQuestion(question, new a(this, question, questionnaire));
        }
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnairePresenter
    public void attachView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnairePresenter
    public void detachView() {
        this.a = null;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnairePresenter
    @Nullable
    public QuestionnairePresenter.Listener getListener() {
        return this.f;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnairePresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("questionnaire_was_cancelled", this.e);
        return bundle;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnairePresenter
    public void setListener(@Nullable QuestionnairePresenter.Listener listener) {
        this.f = listener;
    }

    @Override // com.avito.android.advert.item.questionnaire.QuestionnairePresenter
    public void showIfNeeded(@NotNull Questionnaire questionnaire) {
        T t;
        BottomSheetDialog bottomSheetDialog;
        Context context;
        T t2;
        boolean z;
        Intrinsics.checkNotNullParameter(questionnaire, "questionnaire");
        if (this.g.isQuestionnaireCompleted(questionnaire.getId())) {
            t = null;
        } else {
            int lastOpenedQuestionId = this.g.getLastOpenedQuestionId(questionnaire.getId());
            Iterator<T> it = questionnaire.getQuestions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2.getId() == lastOpenedQuestionId) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            t = t2;
            if (t == null) {
                t = (Questionnaire.Question) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) questionnaire.getQuestions());
            }
        }
        if (!this.e && (bottomSheetDialog = this.b) == null && t != null) {
            if (bottomSheetDialog != null) {
                bottomSheetDialog.close();
            }
            View view = this.a;
            if (view != null && (context = view.getContext()) != null) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.advert_questionnaire, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                this.c = new QuestionnaireView(inflate);
                BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(context, 0, 2, null);
                View inflate2 = LayoutInflater.from(bottomSheetDialog2.getContext()).inflate(R.layout.advert_questionnaire_header, (ViewGroup) null);
                Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) inflate2;
                TextView textView = (TextView) viewGroup.findViewById(R.id.title);
                View findViewById = viewGroup.findViewById(R.id.close);
                Intrinsics.checkNotNullExpressionValue(textView, "headerTitle");
                textView.setText(questionnaire.getTitle());
                findViewById.setOnClickListener(new d(bottomSheetDialog2));
                bottomSheetDialog2.setCustomHeader(viewGroup);
                bottomSheetDialog2.setContentView(inflate, true);
                BottomSheetDialog.setHeaderParams$default(bottomSheetDialog2, null, null, false, true, 7, null);
                bottomSheetDialog2.setFitContentPeekHeight(true);
                bottomSheetDialog2.setCancelable(true);
                bottomSheetDialog2.setCanceledOnTouchOutside(false);
                bottomSheetDialog2.setOnDismissListener(new a2.a.a.f.x.y.a(this, questionnaire, inflate));
                bottomSheetDialog2.setOnCancelListener(new b(this, questionnaire, inflate));
                bottomSheetDialog2.setOnCloseListener(new c(this, questionnaire, inflate));
                this.b = bottomSheetDialog2;
                a(questionnaire, t);
                BottomSheetDialog bottomSheetDialog3 = this.b;
                if (bottomSheetDialog3 != null) {
                    bottomSheetDialog3.show();
                }
            }
        }
    }
}
