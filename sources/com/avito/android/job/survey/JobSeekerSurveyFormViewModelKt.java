package com.avito.android.job.survey;

import com.avito.android.job.common.Action;
import com.avito.android.job.survey.JobSeekerSurveyFormViewModel;
import com.avito.android.job.survey.remote.model.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"survey_release"}, k = 2, mv = {1, 4, 2})
public final class JobSeekerSurveyFormViewModelKt {
    public static final JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.RadioGroupViewState access$toViewModel(Field.RadioGroupField radioGroupField, String str) {
        List<Field.RadioGroupField.Option> options = radioGroupField.getOptions();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(options, 10));
        for (T t : options) {
            arrayList.add(new JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.RadioGroupViewState.OptionViewState(t.getTitle(), t.getValue(), Intrinsics.areEqual(t.getValue(), str)));
        }
        return new JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.RadioGroupViewState(arrayList);
    }

    public static final JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.TextAreaViewState access$toViewModel(Field.TextAreaField textAreaField, String str) {
        return new JobSeekerSurveyFormViewModel.ViewState.FormViewState.FieldViewState.TextAreaViewState(str, textAreaField.getHint());
    }

    public static final JobSeekerSurveyFormViewModel.ViewState.FormViewState.ActionViewState access$toViewModel(Action action) {
        return new JobSeekerSurveyFormViewModel.ViewState.FormViewState.ActionViewState(action.getTitle(), action.getDeeplink());
    }
}
