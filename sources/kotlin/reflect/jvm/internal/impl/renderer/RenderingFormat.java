package kotlin.reflect.jvm.internal.impl.renderer;

import com.avito.android.util.preferences.db_preferences.Types;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.y.m;
/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public abstract class RenderingFormat extends Enum<RenderingFormat> {
    public static final RenderingFormat HTML;
    public static final RenderingFormat PLAIN;
    public static final /* synthetic */ RenderingFormat[] a;

    public static final class a extends RenderingFormat {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Types.STRING);
            return m.replace$default(m.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }

    public static final class b extends RenderingFormat {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Types.STRING);
            return str;
        }
    }

    static {
        b bVar = new b("PLAIN", 0);
        PLAIN = bVar;
        a aVar = new a("HTML", 1);
        HTML = aVar;
        a = new RenderingFormat[]{bVar, aVar};
    }

    public RenderingFormat(String str, int i, j jVar) {
    }

    public static RenderingFormat valueOf(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, str);
    }

    public static RenderingFormat[] values() {
        RenderingFormat[] renderingFormatArr = a;
        RenderingFormat[] renderingFormatArr2 = new RenderingFormat[renderingFormatArr.length];
        System.arraycopy(renderingFormatArr, 0, renderingFormatArr2, 0, renderingFormatArr.length);
        return renderingFormatArr2;
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
