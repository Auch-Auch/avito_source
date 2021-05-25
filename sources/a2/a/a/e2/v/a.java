package a2.a.a.e2.v;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.publish.PublishState;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a {
    @NotNull
    public final CategoryParameters a;
    @Nullable
    public final PublishState b;

    public a(@NotNull CategoryParameters categoryParameters, @Nullable PublishState publishState) {
        Intrinsics.checkNotNullParameter(categoryParameters, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.a = categoryParameters;
        this.b = publishState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
    }

    public int hashCode() {
        CategoryParameters categoryParameters = this.a;
        int i = 0;
        int hashCode = (categoryParameters != null ? categoryParameters.hashCode() : 0) * 31;
        PublishState publishState = this.b;
        if (publishState != null) {
            i = publishState.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CategoryParametersWithState(parameters=");
        L.append(this.a);
        L.append(", state=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
