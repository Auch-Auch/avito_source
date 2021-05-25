package com.avito.android.toggle;

import android.content.SharedPreferences;
import com.avito.android.util.feature.OptionSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"features_release"}, k = 2, mv = {1, 4, 2})
public final class PrefsFeatureKt {
    public static final OptionSet access$getOptionSet(SharedPreferences sharedPreferences, String str, OptionSet optionSet) {
        String string = sharedPreferences.getString(str, optionSet.getSelectedOption());
        if (string == null) {
            string = optionSet.getSelectedOption();
        }
        Intrinsics.checkNotNullExpressionValue(string, "getString(key, original.…: original.selectedOption");
        return new OptionSet(string, optionSet.getOptions());
    }

    public static final void access$putOptionSet(SharedPreferences.Editor editor, String str, OptionSet optionSet) {
        editor.putString(str, optionSet.getSelectedOption());
    }
}
