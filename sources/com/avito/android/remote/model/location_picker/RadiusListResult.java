package com.avito.android.remote.model.location_picker;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.SearchRadius;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/location_picker/RadiusListResult;", "", "<init>", "()V", "Error", NativeProtocol.ERROR_NETWORK_ERROR, "Ok", "Lcom/avito/android/remote/model/location_picker/RadiusListResult$Ok;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult$Error;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult$NetworkError;", "location_release"}, k = 1, mv = {1, 4, 2})
public abstract class RadiusListResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/location_picker/RadiusListResult$Error;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends RadiusListResult {
        @NotNull
        private final String errorMessage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.errorMessage = str;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/location_picker/RadiusListResult$NetworkError;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends RadiusListResult {
        public NetworkError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/location_picker/RadiusListResult$Ok;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult;", "", "Lcom/avito/android/remote/model/SearchRadius;", ResidentialComplexModuleKt.VALUES, "Ljava/util/List;", "getValues", "()Ljava/util/List;", "", "selectedValue", "Ljava/lang/String;", "getSelectedValue", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends RadiusListResult {
        @SerializedName("value")
        @NotNull
        private final String selectedValue;
        @SerializedName(ResidentialComplexModuleKt.VALUES)
        @NotNull
        private final List<SearchRadius> values;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull List<SearchRadius> list, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
            Intrinsics.checkNotNullParameter(str, "selectedValue");
            this.values = list;
            this.selectedValue = str;
        }

        @NotNull
        public final String getSelectedValue() {
            return this.selectedValue;
        }

        @NotNull
        public final List<SearchRadius> getValues() {
            return this.values;
        }
    }

    private RadiusListResult() {
    }

    public /* synthetic */ RadiusListResult(j jVar) {
        this();
    }
}
