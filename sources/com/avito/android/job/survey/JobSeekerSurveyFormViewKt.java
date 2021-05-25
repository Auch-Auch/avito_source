package com.avito.android.job.survey;

import android.view.View;
import android.widget.LinearLayout;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.list_item.RadioListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"survey_release"}, k = 2, mv = {1, 4, 2})
public final class JobSeekerSurveyFormViewKt {
    public static final void access$findInputAndSetValue(LinearLayout linearLayout, String str) {
        int childCount = linearLayout.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = linearLayout.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt instanceof Input) {
                    Input.setText$default((Input) childAt, str, false, 2, null);
                }
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void access$findRadioButtonsAndUpdateIsChecked(LinearLayout linearLayout, String str) {
        int childCount = linearLayout.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = linearLayout.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt instanceof RadioListItem) {
                    RadioListItem radioListItem = (RadioListItem) childAt;
                    radioListItem.setChecked(Intrinsics.areEqual(radioListItem.getTag(), str));
                }
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
