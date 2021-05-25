package arrow.core;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u0000 m*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u0001*\u0006\b\u0005\u0010\u0006 \u0001*\u0006\b\u0006\u0010\u0007 \u0001*\u0006\b\u0007\u0010\b \u0001*\u0006\b\b\u0010\t \u0001*\u0006\b\t\u0010\n \u0001*\u0006\b\n\u0010\u000b \u0001*\u0006\b\u000b\u0010\f \u0001*\u0006\b\f\u0010\r \u0001*\u0006\b\r\u0010\u000e \u0001*\u0006\b\u000e\u0010\u000f \u0001*\u0006\b\u000f\u0010\u0010 \u0001*\u0006\b\u0010\u0010\u0011 \u0001*\u0006\b\u0011\u0010\u0012 \u00012Ñ\u000b\u0012Ö\n\u0012Ó\n\u0012Å\t\u0012Â\t\u0012¼\b\u0012¹\b\u0012º\u0007\u0012·\u0007\u0012Ç\u0006\u0012Ä\u0006\u0012á\u0005\u0012Þ\u0005\u0012\u0005\u0012þ\u0004\u0012§\u0004\u0012¤\u0004\u0012Ó\u0003\u0012Ð\u0003\u0012\u0003\u0012\u0003\u0012½\u0002\u0012º\u0002\u0012û\u0001\u0012ø\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0004\u0012\u00028\u00010\u0013j\u0014\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014`\u0015\u0012\u0004\u0012\u00028\u00020\u0013j\u001a\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u0016\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018`\u0016\u0012\u0004\u0012\u00028\u00030\u0013j \u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a\u0012\u0004\u0012\u00028\u001b\u0012\u0004\u0012\u00028\u001c\u0012\u0004\u0012\u00028\u001d`\u0017\u0012\u0004\u0012\u00028\u00040\u0013j&\u0012\u0004\u0012\u00028\u001e\u0012\u0004\u0012\u00028\u001f\u0012\u0004\u0012\u00028 \u0012\u0004\u0012\u00028!\u0012\u0004\u0012\u00028\"\u0012\u0004\u0012\u00028#`\u0018\u0012\u0004\u0012\u00028\u00050\u0013j,\u0012\u0004\u0012\u00028$\u0012\u0004\u0012\u00028%\u0012\u0004\u0012\u00028&\u0012\u0004\u0012\u00028'\u0012\u0004\u0012\u00028(\u0012\u0004\u0012\u00028)\u0012\u0004\u0012\u00028*`\u0019\u0012\u0004\u0012\u00028\u00060\u0013j2\u0012\u0004\u0012\u00028+\u0012\u0004\u0012\u00028,\u0012\u0004\u0012\u00028-\u0012\u0004\u0012\u00028.\u0012\u0004\u0012\u00028/\u0012\u0004\u0012\u000280\u0012\u0004\u0012\u000281\u0012\u0004\u0012\u000282`\u001a\u0012\u0004\u0012\u00028\u00070\u0013j8\u0012\u0004\u0012\u000283\u0012\u0004\u0012\u000284\u0012\u0004\u0012\u000285\u0012\u0004\u0012\u000286\u0012\u0004\u0012\u000287\u0012\u0004\u0012\u000288\u0012\u0004\u0012\u000289\u0012\u0004\u0012\u00028:\u0012\u0004\u0012\u00028;`\u001b\u0012\u0004\u0012\u00028\b0\u0013j>\u0012\u0004\u0012\u00028<\u0012\u0004\u0012\u00028=\u0012\u0004\u0012\u00028>\u0012\u0004\u0012\u00028?\u0012\u0004\u0012\u00028@\u0012\u0004\u0012\u00028A\u0012\u0004\u0012\u00028B\u0012\u0004\u0012\u00028C\u0012\u0004\u0012\u00028D\u0012\u0004\u0012\u00028E`\u001c\u0012\u0004\u0012\u00028\t0\u0013jD\u0012\u0004\u0012\u00028F\u0012\u0004\u0012\u00028G\u0012\u0004\u0012\u00028H\u0012\u0004\u0012\u00028I\u0012\u0004\u0012\u00028J\u0012\u0004\u0012\u00028K\u0012\u0004\u0012\u00028L\u0012\u0004\u0012\u00028M\u0012\u0004\u0012\u00028N\u0012\u0004\u0012\u00028O\u0012\u0004\u0012\u00028P`\u001d\u0012\u0004\u0012\u00028\n0\u0013jJ\u0012\u0004\u0012\u00028Q\u0012\u0004\u0012\u00028R\u0012\u0004\u0012\u00028S\u0012\u0004\u0012\u00028T\u0012\u0004\u0012\u00028U\u0012\u0004\u0012\u00028V\u0012\u0004\u0012\u00028W\u0012\u0004\u0012\u00028X\u0012\u0004\u0012\u00028Y\u0012\u0004\u0012\u00028Z\u0012\u0004\u0012\u00028[\u0012\u0004\u0012\u00028\\`\u001e\u0012\u0004\u0012\u00028\u000b0\u0013jP\u0012\u0004\u0012\u00028]\u0012\u0004\u0012\u00028^\u0012\u0004\u0012\u00028_\u0012\u0004\u0012\u00028`\u0012\u0004\u0012\u00028a\u0012\u0004\u0012\u00028b\u0012\u0004\u0012\u00028c\u0012\u0004\u0012\u00028d\u0012\u0004\u0012\u00028e\u0012\u0004\u0012\u00028f\u0012\u0004\u0012\u00028g\u0012\u0004\u0012\u00028h\u0012\u0004\u0012\u00028i`\u001f\u0012\u0004\u0012\u00028\f0\u0013jV\u0012\u0004\u0012\u00028j\u0012\u0004\u0012\u00028k\u0012\u0004\u0012\u00028l\u0012\u0004\u0012\u00028m\u0012\u0004\u0012\u00028n\u0012\u0004\u0012\u00028o\u0012\u0004\u0012\u00028p\u0012\u0004\u0012\u00028q\u0012\u0004\u0012\u00028r\u0012\u0004\u0012\u00028s\u0012\u0004\u0012\u00028t\u0012\u0004\u0012\u00028u\u0012\u0004\u0012\u00028v\u0012\u0004\u0012\u00028w` \u0012\u0004\u0012\u00028\r0\u0013jc\u0012\u0004\u0012\u00028x\u0012\u0004\u0012\u00028y\u0012\u0004\u0012\u00028z\u0012\u0004\u0012\u00028{\u0012\u0004\u0012\u00028|\u0012\u0004\u0012\u00028}\u0012\u0004\u0012\u00028~\u0012\u0004\u0012\u00028\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001`!\u0012\u0004\u0012\u00028\u000e0\u0013jr\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001`\"\u0012\u0004\u0012\u00028\u000f0\u0013jy\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038 \u0001\u0012\u0005\u0012\u00038¡\u0001\u0012\u0005\u0012\u00038¢\u0001\u0012\u0005\u0012\u00038£\u0001\u0012\u0005\u0012\u00038¤\u0001\u0012\u0005\u0012\u00038¥\u0001\u0012\u0005\u0012\u00038¦\u0001\u0012\u0005\u0012\u00038§\u0001`#\u0012\u0004\u0012\u00028\u00100\u0013j\u0001\u0012\u0005\u0012\u00038¨\u0001\u0012\u0005\u0012\u00038©\u0001\u0012\u0005\u0012\u00038ª\u0001\u0012\u0005\u0012\u00038«\u0001\u0012\u0005\u0012\u00038¬\u0001\u0012\u0005\u0012\u00038­\u0001\u0012\u0005\u0012\u00038®\u0001\u0012\u0005\u0012\u00038¯\u0001\u0012\u0005\u0012\u00038°\u0001\u0012\u0005\u0012\u00038±\u0001\u0012\u0005\u0012\u00038²\u0001\u0012\u0005\u0012\u00038³\u0001\u0012\u0005\u0012\u00038´\u0001\u0012\u0005\u0012\u00038µ\u0001\u0012\u0005\u0012\u00038¶\u0001\u0012\u0005\u0012\u00038·\u0001\u0012\u0005\u0012\u00038¸\u0001\u0012\u0005\u0012\u00038¹\u0001`$\u0012\u0004\u0012\u00028\u00110\u0013jn\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011`%:\u0001mB\u0001\u0012\u0006\u00109\u001a\u00028\u0000\u0012\u0006\u0010:\u001a\u00028\u0001\u0012\u0006\u0010;\u001a\u00028\u0002\u0012\u0006\u0010<\u001a\u00028\u0003\u0012\u0006\u0010=\u001a\u00028\u0004\u0012\u0006\u0010>\u001a\u00028\u0005\u0012\u0006\u0010?\u001a\u00028\u0006\u0012\u0006\u0010@\u001a\u00028\u0007\u0012\u0006\u0010A\u001a\u00028\b\u0012\u0006\u0010B\u001a\u00028\t\u0012\u0006\u0010C\u001a\u00028\n\u0012\u0006\u0010D\u001a\u00028\u000b\u0012\u0006\u0010E\u001a\u00028\f\u0012\u0006\u0010F\u001a\u00028\r\u0012\u0006\u0010G\u001a\u00028\u000e\u0012\u0006\u0010H\u001a\u00028\u000f\u0012\u0006\u0010I\u001a\u00028\u0010\u0012\u0006\u0010J\u001a\u00028\u0011¢\u0006\u0004\bk\u0010lJ\u0010\u0010&\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b(\u0010'J\u0010\u0010)\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b)\u0010'J\u0010\u0010*\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b*\u0010'J\u0010\u0010+\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b+\u0010'J\u0010\u0010,\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b,\u0010'J\u0010\u0010-\u001a\u00028\u0006HÆ\u0003¢\u0006\u0004\b-\u0010'J\u0010\u0010.\u001a\u00028\u0007HÆ\u0003¢\u0006\u0004\b.\u0010'J\u0010\u0010/\u001a\u00028\bHÆ\u0003¢\u0006\u0004\b/\u0010'J\u0010\u00100\u001a\u00028\tHÆ\u0003¢\u0006\u0004\b0\u0010'J\u0010\u00101\u001a\u00028\nHÆ\u0003¢\u0006\u0004\b1\u0010'J\u0010\u00102\u001a\u00028\u000bHÆ\u0003¢\u0006\u0004\b2\u0010'J\u0010\u00103\u001a\u00028\fHÆ\u0003¢\u0006\u0004\b3\u0010'J\u0010\u00104\u001a\u00028\rHÆ\u0003¢\u0006\u0004\b4\u0010'J\u0010\u00105\u001a\u00028\u000eHÆ\u0003¢\u0006\u0004\b5\u0010'J\u0010\u00106\u001a\u00028\u000fHÆ\u0003¢\u0006\u0004\b6\u0010'J\u0010\u00107\u001a\u00028\u0010HÆ\u0003¢\u0006\u0004\b7\u0010'J\u0010\u00108\u001a\u00028\u0011HÆ\u0003¢\u0006\u0004\b8\u0010'J°\u0002\u0010K\u001an\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u00110\u00002\b\b\u0002\u00109\u001a\u00028\u00002\b\b\u0002\u0010:\u001a\u00028\u00012\b\b\u0002\u0010;\u001a\u00028\u00022\b\b\u0002\u0010<\u001a\u00028\u00032\b\b\u0002\u0010=\u001a\u00028\u00042\b\b\u0002\u0010>\u001a\u00028\u00052\b\b\u0002\u0010?\u001a\u00028\u00062\b\b\u0002\u0010@\u001a\u00028\u00072\b\b\u0002\u0010A\u001a\u00028\b2\b\b\u0002\u0010B\u001a\u00028\t2\b\b\u0002\u0010C\u001a\u00028\n2\b\b\u0002\u0010D\u001a\u00028\u000b2\b\b\u0002\u0010E\u001a\u00028\f2\b\b\u0002\u0010F\u001a\u00028\r2\b\b\u0002\u0010G\u001a\u00028\u000e2\b\b\u0002\u0010H\u001a\u00028\u000f2\b\b\u0002\u0010I\u001a\u00028\u00102\b\b\u0002\u0010J\u001a\u00028\u0011HÆ\u0001¢\u0006\u0004\bK\u0010LJ\u0010\u0010N\u001a\u00020MHÖ\u0001¢\u0006\u0004\bN\u0010OJ\u0010\u0010Q\u001a\u00020PHÖ\u0001¢\u0006\u0004\bQ\u0010RJ\u001a\u0010V\u001a\u00020U2\b\u0010T\u001a\u0004\u0018\u00010SHÖ\u0003¢\u0006\u0004\bV\u0010WR\u0019\u0010@\u001a\u00028\u00078\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010X\u001a\u0004\bY\u0010'R\u0019\u0010?\u001a\u00028\u00068\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010X\u001a\u0004\bZ\u0010'R\u0019\u0010D\u001a\u00028\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010X\u001a\u0004\b[\u0010'R\u0019\u0010G\u001a\u00028\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010X\u001a\u0004\b\\\u0010'R\u0019\u0010;\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010X\u001a\u0004\b]\u0010'R\u0019\u00109\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010X\u001a\u0004\b^\u0010'R\u0019\u0010=\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010X\u001a\u0004\b_\u0010'R\u0019\u0010A\u001a\u00028\b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010X\u001a\u0004\b`\u0010'R\u0019\u0010:\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010X\u001a\u0004\ba\u0010'R\u0019\u0010E\u001a\u00028\f8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010X\u001a\u0004\bb\u0010'R\u0019\u0010J\u001a\u00028\u00118\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010X\u001a\u0004\bc\u0010'R\u0019\u0010<\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010X\u001a\u0004\bd\u0010'R\u0019\u0010>\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010X\u001a\u0004\be\u0010'R\u0019\u0010C\u001a\u00028\n8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010X\u001a\u0004\bf\u0010'R\u0019\u0010F\u001a\u00028\r8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010X\u001a\u0004\bg\u0010'R\u0019\u0010H\u001a\u00028\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010X\u001a\u0004\bh\u0010'R\u0019\u0010B\u001a\u00028\t8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010X\u001a\u0004\bi\u0010'R\u0019\u0010I\u001a\u00028\u00108\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010X\u001a\u0004\bj\u0010'¨\u0006n"}, d2 = {"Larrow/core/Tuple18;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "Larrow/Kind;", "Larrow/core/ForTuple18;", "Larrow/Kind2;", "Larrow/Kind3;", "Larrow/Kind4;", "Larrow/Kind5;", "Larrow/Kind6;", "Larrow/Kind7;", "Larrow/Kind8;", "Larrow/Kind9;", "Larrow/Kind10;", "Larrow/Kind11;", "Larrow/Kind12;", "Larrow/Kind13;", "Larrow/Kind14;", "Larrow/Kind15;", "Larrow/Kind16;", "Larrow/Kind17;", "Larrow/core/Tuple18Of;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "d", "e", "f", g.a, "h", "i", "j", "k", "l", AuthSource.OPEN_CHANNEL_LIST, "n", "o", "p", VKApiConst.Q, "r", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Larrow/core/Tuple18;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getH", "getG", "getL", "getO", "getC", "getA", "getE", "getI", "getB", "getM", "getR", "getD", "getF", "getK", "getN", "getP", "getJ", "getQ", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> implements Kind<Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends ForTuple18, ? extends A>, ? extends B>, ? extends C>, ? extends D>, ? extends E>, ? extends F>, ? extends G>, ? extends H>, ? extends I>, ? extends J>, ? extends K>, ? extends L>, ? extends M>, ? extends N>, ? extends O>, ? extends P>, ? extends Q>, R> {
    public static final Companion Companion = new Companion(null);
    public final A a;
    public final B b;
    public final C c;
    public final D d;
    public final E e;
    public final F f;
    public final G g;
    public final H h;
    public final I i;
    public final J j;
    public final K k;
    public final L l;
    public final M m;
    public final N n;
    public final O o;
    public final P p;
    public final Q q;
    public final R r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Larrow/core/Tuple18$Companion;", "", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Tuple18(A a3, B b2, C c2, D d2, E e2, F f2, G g2, H h2, I i2, J j2, K k2, L l2, M m2, N n2, O o2, P p2, Q q2, R r2) {
        this.a = a3;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        this.e = e2;
        this.f = f2;
        this.g = g2;
        this.h = h2;
        this.i = i2;
        this.j = j2;
        this.k = k2;
        this.l = l2;
        this.m = m2;
        this.n = n2;
        this.o = o2;
        this.p = p2;
        this.q = q2;
        this.r = r2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r23v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r25v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r26v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r28v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r29v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r30v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r31v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r32v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r33v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r34v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r35v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Tuple18 copy$default(Tuple18 tuple18, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, int i2, Object obj19) {
        return tuple18.copy((i2 & 1) != 0 ? tuple18.a : obj, (i2 & 2) != 0 ? tuple18.b : obj2, (i2 & 4) != 0 ? tuple18.c : obj3, (i2 & 8) != 0 ? tuple18.d : obj4, (i2 & 16) != 0 ? tuple18.e : obj5, (i2 & 32) != 0 ? tuple18.f : obj6, (i2 & 64) != 0 ? tuple18.g : obj7, (i2 & 128) != 0 ? tuple18.h : obj8, (i2 & 256) != 0 ? tuple18.i : obj9, (i2 & 512) != 0 ? tuple18.j : obj10, (i2 & 1024) != 0 ? tuple18.k : obj11, (i2 & 2048) != 0 ? tuple18.l : obj12, (i2 & 4096) != 0 ? tuple18.m : obj13, (i2 & 8192) != 0 ? tuple18.n : obj14, (i2 & 16384) != 0 ? tuple18.o : obj15, (i2 & 32768) != 0 ? tuple18.p : obj16, (i2 & 65536) != 0 ? tuple18.q : obj17, (i2 & 131072) != 0 ? tuple18.r : obj18);
    }

    public final A component1() {
        return this.a;
    }

    public final J component10() {
        return this.j;
    }

    public final K component11() {
        return this.k;
    }

    public final L component12() {
        return this.l;
    }

    public final M component13() {
        return this.m;
    }

    public final N component14() {
        return this.n;
    }

    public final O component15() {
        return this.o;
    }

    public final P component16() {
        return this.p;
    }

    public final Q component17() {
        return this.q;
    }

    public final R component18() {
        return this.r;
    }

    public final B component2() {
        return this.b;
    }

    public final C component3() {
        return this.c;
    }

    public final D component4() {
        return this.d;
    }

    public final E component5() {
        return this.e;
    }

    public final F component6() {
        return this.f;
    }

    public final G component7() {
        return this.g;
    }

    public final H component8() {
        return this.h;
    }

    public final I component9() {
        return this.i;
    }

    @NotNull
    public final Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> copy(A a3, B b2, C c2, D d2, E e2, F f2, G g2, H h2, I i2, J j2, K k2, L l2, M m2, N n2, O o2, P p2, Q q2, R r2) {
        return new Tuple18<>(a3, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple18)) {
            return false;
        }
        Tuple18 tuple18 = (Tuple18) obj;
        return Intrinsics.areEqual(this.a, tuple18.a) && Intrinsics.areEqual(this.b, tuple18.b) && Intrinsics.areEqual(this.c, tuple18.c) && Intrinsics.areEqual(this.d, tuple18.d) && Intrinsics.areEqual(this.e, tuple18.e) && Intrinsics.areEqual(this.f, tuple18.f) && Intrinsics.areEqual(this.g, tuple18.g) && Intrinsics.areEqual(this.h, tuple18.h) && Intrinsics.areEqual(this.i, tuple18.i) && Intrinsics.areEqual(this.j, tuple18.j) && Intrinsics.areEqual(this.k, tuple18.k) && Intrinsics.areEqual(this.l, tuple18.l) && Intrinsics.areEqual(this.m, tuple18.m) && Intrinsics.areEqual(this.n, tuple18.n) && Intrinsics.areEqual(this.o, tuple18.o) && Intrinsics.areEqual(this.p, tuple18.p) && Intrinsics.areEqual(this.q, tuple18.q) && Intrinsics.areEqual(this.r, tuple18.r);
    }

    public final A getA() {
        return this.a;
    }

    public final B getB() {
        return this.b;
    }

    public final C getC() {
        return this.c;
    }

    public final D getD() {
        return this.d;
    }

    public final E getE() {
        return this.e;
    }

    public final F getF() {
        return this.f;
    }

    public final G getG() {
        return this.g;
    }

    public final H getH() {
        return this.h;
    }

    public final I getI() {
        return this.i;
    }

    public final J getJ() {
        return this.j;
    }

    public final K getK() {
        return this.k;
    }

    public final L getL() {
        return this.l;
    }

    public final M getM() {
        return this.m;
    }

    public final N getN() {
        return this.n;
    }

    public final O getO() {
        return this.o;
    }

    public final P getP() {
        return this.p;
    }

    public final Q getQ() {
        return this.q;
    }

    public final R getR() {
        return this.r;
    }

    public int hashCode() {
        A a3 = this.a;
        int i2 = 0;
        int hashCode = (a3 != null ? a3.hashCode() : 0) * 31;
        B b2 = this.b;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.c;
        int hashCode3 = (hashCode2 + (c2 != null ? c2.hashCode() : 0)) * 31;
        D d2 = this.d;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        E e2 = this.e;
        int hashCode5 = (hashCode4 + (e2 != null ? e2.hashCode() : 0)) * 31;
        F f2 = this.f;
        int hashCode6 = (hashCode5 + (f2 != null ? f2.hashCode() : 0)) * 31;
        G g2 = this.g;
        int hashCode7 = (hashCode6 + (g2 != null ? g2.hashCode() : 0)) * 31;
        H h2 = this.h;
        int hashCode8 = (hashCode7 + (h2 != null ? h2.hashCode() : 0)) * 31;
        I i3 = this.i;
        int hashCode9 = (hashCode8 + (i3 != null ? i3.hashCode() : 0)) * 31;
        J j2 = this.j;
        int hashCode10 = (hashCode9 + (j2 != null ? j2.hashCode() : 0)) * 31;
        K k2 = this.k;
        int hashCode11 = (hashCode10 + (k2 != null ? k2.hashCode() : 0)) * 31;
        L l2 = this.l;
        int hashCode12 = (hashCode11 + (l2 != null ? l2.hashCode() : 0)) * 31;
        M m2 = this.m;
        int hashCode13 = (hashCode12 + (m2 != null ? m2.hashCode() : 0)) * 31;
        N n2 = this.n;
        int hashCode14 = (hashCode13 + (n2 != null ? n2.hashCode() : 0)) * 31;
        O o2 = this.o;
        int hashCode15 = (hashCode14 + (o2 != null ? o2.hashCode() : 0)) * 31;
        P p2 = this.p;
        int hashCode16 = (hashCode15 + (p2 != null ? p2.hashCode() : 0)) * 31;
        Q q2 = this.q;
        int hashCode17 = (hashCode16 + (q2 != null ? q2.hashCode() : 0)) * 31;
        R r2 = this.r;
        if (r2 != null) {
            i2 = r2.hashCode();
        }
        return hashCode17 + i2;
    }

    public String toString() {
        StringBuilder L = a.L("Tuple18(a=");
        L.append((Object) this.a);
        L.append(", b=");
        L.append((Object) this.b);
        L.append(", c=");
        L.append((Object) this.c);
        L.append(", d=");
        L.append((Object) this.d);
        L.append(", e=");
        L.append((Object) this.e);
        L.append(", f=");
        L.append((Object) this.f);
        L.append(", g=");
        L.append((Object) this.g);
        L.append(", h=");
        L.append((Object) this.h);
        L.append(", i=");
        L.append((Object) this.i);
        L.append(", j=");
        L.append((Object) this.j);
        L.append(", k=");
        L.append((Object) this.k);
        L.append(", l=");
        L.append((Object) this.l);
        L.append(", m=");
        L.append((Object) this.m);
        L.append(", n=");
        L.append((Object) this.n);
        L.append(", o=");
        L.append((Object) this.o);
        L.append(", p=");
        L.append((Object) this.p);
        L.append(", q=");
        L.append((Object) this.q);
        L.append(", r=");
        return a.r(L, this.r, ")");
    }
}
