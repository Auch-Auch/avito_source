package com.avito.android.publish.wizard.remote;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.WizardParameter;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Ji\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/wizard/remote/WizardApi;", "", "", "itemId", "", "navigation", "leaves", "stepId", "publishSessionId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/WizardParameter;", "getWizardParametersByNavigation", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface WizardApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.publish.wizard.remote.WizardApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable getWizardParametersByNavigation$default(WizardApi wizardApi, String str, Map map, Map map2, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = r.emptyMap();
                }
                if ((i & 8) != 0) {
                    str2 = null;
                }
                return wizardApi.getWizardParametersByNavigation(str, map, map2, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWizardParametersByNavigation");
        }
    }

    @NotNull
    @FormUrlEncoded
    @POST("1/dicts/navigation")
    Observable<TypedResult<WizardParameter>> getWizardParametersByNavigation(@Field("itemId") @Nullable String str, @FieldMap @NotNull Map<String, String> map, @FieldMap @NotNull Map<String, String> map2, @Field("stepId") @Nullable String str2, @Field("publishSessionId") @NotNull String str3);
}
