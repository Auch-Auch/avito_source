package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a©\u0005\u0010\u0016\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0\u0015\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t*\u0004\u0012Ó\u0003\u0012Ð\u0003\u0012\u0003\u0012\u0003\u0012½\u0002\u0012º\u0002\u0012û\u0001\u0012ø\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00010\nj\u0014\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f`\f\u0012\u0004\u0012\u00028\u00020\nj\u001a\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010`\r\u0012\u0004\u0012\u00028\u00030\nj \u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015`\u000e\u0012\u0004\u0012\u00028\u00040\nj&\u0012\u0004\u0012\u00028\u0016\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018\u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a\u0012\u0004\u0012\u00028\u001b`\u000f\u0012\u0004\u0012\u00028\u00050\nj,\u0012\u0004\u0012\u00028\u001c\u0012\u0004\u0012\u00028\u001d\u0012\u0004\u0012\u00028\u001e\u0012\u0004\u0012\u00028\u001f\u0012\u0004\u0012\u00028 \u0012\u0004\u0012\u00028!\u0012\u0004\u0012\u00028\"`\u0010\u0012\u0004\u0012\u00028\u00060\nj2\u0012\u0004\u0012\u00028#\u0012\u0004\u0012\u00028$\u0012\u0004\u0012\u00028%\u0012\u0004\u0012\u00028&\u0012\u0004\u0012\u00028'\u0012\u0004\u0012\u00028(\u0012\u0004\u0012\u00028)\u0012\u0004\u0012\u00028*`\u0011\u0012\u0004\u0012\u00028\u00070\nj8\u0012\u0004\u0012\u00028+\u0012\u0004\u0012\u00028,\u0012\u0004\u0012\u00028-\u0012\u0004\u0012\u00028.\u0012\u0004\u0012\u00028/\u0012\u0004\u0012\u000280\u0012\u0004\u0012\u000281\u0012\u0004\u0012\u000282\u0012\u0004\u0012\u000283`\u0012\u0012\u0004\u0012\u00028\b0\nj>\u0012\u0004\u0012\u000284\u0012\u0004\u0012\u000285\u0012\u0004\u0012\u000286\u0012\u0004\u0012\u000287\u0012\u0004\u0012\u000288\u0012\u0004\u0012\u000289\u0012\u0004\u0012\u00028:\u0012\u0004\u0012\u00028;\u0012\u0004\u0012\u00028<\u0012\u0004\u0012\u00028=`\u0013\u0012\u0004\u0012\u00028\t0\nj>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t`\u0014H\b¢\u0006\u0004\b\u0016\u0010\u0017*å\u0004\u0010\u0019\u001a\u0004\b\u0000\u0010\u0000\u001a\u0004\b\u0001\u0010\u0001\u001a\u0004\b\u0002\u0010\u0002\u001a\u0004\b\u0003\u0010\u0003\u001a\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0005\u001a\u0004\b\u0006\u0010\u0006\u001a\u0004\b\u0007\u0010\u0007\u001a\u0004\b\b\u0010\b\u001a\u0004\b\t\u0010\t\"D\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t`\u00182Þ\u0003\u0012Ó\u0003\u0012Ð\u0003\u0012\u0003\u0012\u0003\u0012½\u0002\u0012º\u0002\u0012û\u0001\u0012ø\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00010\nj\u0014\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f`\f\u0012\u0004\u0012\u00028\u00020\nj\u001a\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010`\r\u0012\u0004\u0012\u00028\u00030\nj \u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015`\u000e\u0012\u0004\u0012\u00028\u00040\nj&\u0012\u0004\u0012\u00028\u0016\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018\u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a\u0012\u0004\u0012\u00028\u001b`\u000f\u0012\u0004\u0012\u00028\u00050\nj,\u0012\u0004\u0012\u00028\u001c\u0012\u0004\u0012\u00028\u001d\u0012\u0004\u0012\u00028\u001e\u0012\u0004\u0012\u00028\u001f\u0012\u0004\u0012\u00028 \u0012\u0004\u0012\u00028!\u0012\u0004\u0012\u00028\"`\u0010\u0012\u0004\u0012\u00028\u00060\nj2\u0012\u0004\u0012\u00028#\u0012\u0004\u0012\u00028$\u0012\u0004\u0012\u00028%\u0012\u0004\u0012\u00028&\u0012\u0004\u0012\u00028'\u0012\u0004\u0012\u00028(\u0012\u0004\u0012\u00028)\u0012\u0004\u0012\u00028*`\u0011\u0012\u0004\u0012\u00028\u00070\nj8\u0012\u0004\u0012\u00028+\u0012\u0004\u0012\u00028,\u0012\u0004\u0012\u00028-\u0012\u0004\u0012\u00028.\u0012\u0004\u0012\u00028/\u0012\u0004\u0012\u000280\u0012\u0004\u0012\u000281\u0012\u0004\u0012\u000282\u0012\u0004\u0012\u000283`\u0012\u0012\u0004\u0012\u00028\b0\nj>\u0012\u0004\u0012\u000284\u0012\u0004\u0012\u000285\u0012\u0004\u0012\u000286\u0012\u0004\u0012\u000287\u0012\u0004\u0012\u000288\u0012\u0004\u0012\u000289\u0012\u0004\u0012\u00028:\u0012\u0004\u0012\u00028;\u0012\u0004\u0012\u00028<\u0012\u0004\u0012\u00028=`\u0013\u0012\u0004\u0012\u00028\t0\n*\u0004\u0010\u001a\u001a\u0004\b\u0000\u0010\u0000\u001a\u0004\b\u0001\u0010\u0001\u001a\u0004\b\u0002\u0010\u0002\u001a\u0004\b\u0003\u0010\u0003\u001a\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0005\u001a\u0004\b\u0006\u0010\u0006\u001a\u0004\b\u0007\u0010\u0007\u001a\u0004\b\b\u0010\b\">\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b`\u00132\u0003\u0012\u0003\u0012\u0003\u0012½\u0002\u0012º\u0002\u0012û\u0001\u0012ø\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00010\nj\u0014\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b`\f\u0012\u0004\u0012\u00028\u00020\nj\u001a\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f`\r\u0012\u0004\u0012\u00028\u00030\nj \u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014`\u000e\u0012\u0004\u0012\u00028\u00040\nj&\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u0016\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018\u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a`\u000f\u0012\u0004\u0012\u00028\u00050\nj,\u0012\u0004\u0012\u00028\u001b\u0012\u0004\u0012\u00028\u001c\u0012\u0004\u0012\u00028\u001d\u0012\u0004\u0012\u00028\u001e\u0012\u0004\u0012\u00028\u001f\u0012\u0004\u0012\u00028 \u0012\u0004\u0012\u00028!`\u0010\u0012\u0004\u0012\u00028\u00060\nj2\u0012\u0004\u0012\u00028\"\u0012\u0004\u0012\u00028#\u0012\u0004\u0012\u00028$\u0012\u0004\u0012\u00028%\u0012\u0004\u0012\u00028&\u0012\u0004\u0012\u00028'\u0012\u0004\u0012\u00028(\u0012\u0004\u0012\u00028)`\u0011\u0012\u0004\u0012\u00028\u00070\nj8\u0012\u0004\u0012\u00028*\u0012\u0004\u0012\u00028+\u0012\u0004\u0012\u00028,\u0012\u0004\u0012\u00028-\u0012\u0004\u0012\u00028.\u0012\u0004\u0012\u00028/\u0012\u0004\u0012\u000280\u0012\u0004\u0012\u000281\u0012\u0004\u0012\u000282`\u0012\u0012\u0004\u0012\u00028\b0\n¨\u0006\u001b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "Larrow/Kind;", "Larrow/core/ForTuple10;", "Larrow/Kind2;", "Larrow/Kind3;", "Larrow/Kind4;", "Larrow/Kind5;", "Larrow/Kind6;", "Larrow/Kind7;", "Larrow/Kind8;", "Larrow/Kind9;", "Larrow/core/Tuple10Of;", "Larrow/core/Tuple10;", "fix", "(Larrow/Kind;)Larrow/core/Tuple10;", "Larrow/Kind10;", "Tuple10Of", "Tuple10PartialOf", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class Higherkind_arrow_core_Tuple10Kt {
    @NotNull
    public static final <A, B, C, D, E, F, G, H, I, J> Tuple10<A, B, C, D, E, F, G, H, I, J> fix(@NotNull Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<ForTuple10, ? extends A>, ? extends B>, ? extends C>, ? extends D>, ? extends E>, ? extends F>, ? extends G>, ? extends H>, ? extends I>, ? extends J> kind) {
        Intrinsics.checkParameterIsNotNull(kind, "$receiver");
        return (Tuple10) kind;
    }
}
