package a2.g.k.a0;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class c {
    public static final List<Class<? extends View>> a = new ArrayList(Arrays.asList(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class));

    public static List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends View> cls : a) {
            if (cls.isInstance(view)) {
                return arrayList;
            }
        }
        if (view.isClickable()) {
            arrayList.add(view);
        }
        for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
            arrayList.addAll(a(view2));
        }
        return arrayList;
    }

    public static JSONObject b(View view, View view2) {
        JSONObject jSONObject = new JSONObject();
        if (view == view2) {
            try {
                jSONObject.put(ViewHierarchyConstants.IS_INTERACTED_KEY, true);
            } catch (JSONException unused) {
            }
        }
        e(view, jSONObject);
        JSONArray jSONArray = new JSONArray();
        List<View> childrenOfView = ViewHierarchy.getChildrenOfView(view);
        for (int i = 0; i < childrenOfView.size(); i++) {
            jSONArray.put(b(childrenOfView.get(i), view2));
        }
        jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
        return jSONObject;
    }

    public static List<String> c(View view) {
        ArrayList arrayList = new ArrayList();
        for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
            String textOfView = ViewHierarchy.getTextOfView(view2);
            if (!textOfView.isEmpty()) {
                arrayList.add(textOfView);
            }
            arrayList.addAll(c(view2));
        }
        return arrayList;
    }

    public static String d(View view) {
        String textOfView = ViewHierarchy.getTextOfView(view);
        if (!textOfView.isEmpty()) {
            return textOfView;
        }
        return TextUtils.join(" ", c(view));
    }

    public static void e(View view, JSONObject jSONObject) {
        try {
            String textOfView = ViewHierarchy.getTextOfView(view);
            String hintOfView = ViewHierarchy.getHintOfView(view);
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getSimpleName());
            jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, ViewHierarchy.getClassTypeBitmask(view));
            if (!textOfView.isEmpty()) {
                jSONObject.put("text", textOfView);
            }
            if (!hintOfView.isEmpty()) {
                jSONObject.put("hint", hintOfView);
            }
            if (view instanceof EditText) {
                jSONObject.put(ViewHierarchyConstants.INPUT_TYPE_KEY, ((EditText) view).getInputType());
            }
        } catch (JSONException unused) {
        }
    }
}
