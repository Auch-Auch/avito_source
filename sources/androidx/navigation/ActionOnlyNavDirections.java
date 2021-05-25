package androidx.navigation;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.annotation.NonNull;
public final class ActionOnlyNavDirections implements NavDirections {
    public final int a;

    public ActionOnlyNavDirections(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ActionOnlyNavDirections.class == obj.getClass() && getActionId() == ((ActionOnlyNavDirections) obj).getActionId();
    }

    @Override // androidx.navigation.NavDirections
    public int getActionId() {
        return this.a;
    }

    @Override // androidx.navigation.NavDirections
    @NonNull
    public Bundle getArguments() {
        return new Bundle();
    }

    public int hashCode() {
        return getActionId() + 31;
    }

    public String toString() {
        StringBuilder L = a.L("ActionOnlyNavDirections(actionId=");
        L.append(getActionId());
        L.append(")");
        return L.toString();
    }
}
