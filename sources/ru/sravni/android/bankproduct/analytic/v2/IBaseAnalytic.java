package ru.sravni.android.bankproduct.analytic.v2;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001JM\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\nJ7\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\f\u0010\rJW\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0018\u00010\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", "", "previousStep", "", "addedParams", "", "massiveParams", "", "sendOpenEvent", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "errorType", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "eventId", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getModuleName", "()Ljava/lang/String;", "moduleName", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IBaseAnalytic {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendEvent$default(IBaseAnalytic iBaseAnalytic, String str, String str2, Map map, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = null;
                }
                if ((i & 8) != 0) {
                    map2 = null;
                }
                iBaseAnalytic.sendEvent(str, str2, map, map2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendFailEvent$default(IBaseAnalytic iBaseAnalytic, String str, String str2, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = null;
                }
                iBaseAnalytic.sendFailEvent(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFailEvent");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendOpenEvent$default(IBaseAnalytic iBaseAnalytic, String str, Map map, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = null;
                }
                if ((i & 4) != 0) {
                    map2 = null;
                }
                iBaseAnalytic.sendOpenEvent(str, map, map2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendOpenEvent");
        }
    }

    @NotNull
    String getModuleName();

    void sendEvent(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2);

    void sendFailEvent(@NotNull String str, @NotNull String str2, @Nullable Map<String, String> map);

    void sendOpenEvent(@NotNull String str, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2);
}
