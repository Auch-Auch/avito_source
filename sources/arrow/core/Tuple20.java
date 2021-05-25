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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u0000 w*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u0001*\u0006\b\u0005\u0010\u0006 \u0001*\u0006\b\u0006\u0010\u0007 \u0001*\u0006\b\u0007\u0010\b \u0001*\u0006\b\b\u0010\t \u0001*\u0006\b\t\u0010\n \u0001*\u0006\b\n\u0010\u000b \u0001*\u0006\b\u000b\u0010\f \u0001*\u0006\b\f\u0010\r \u0001*\u0006\b\r\u0010\u000e \u0001*\u0006\b\u000e\u0010\u000f \u0001*\u0006\b\u000f\u0010\u0010 \u0001*\u0006\b\u0010\u0010\u0011 \u0001*\u0006\b\u0011\u0010\u0012 \u0001*\u0006\b\u0012\u0010\u0013 \u0001*\u0006\b\u0013\u0010\u0014 \u00012\u000e\u0012\r\u0012\r\u0012ð\u000b\u0012í\u000b\u0012Ø\n\u0012Õ\n\u0012Ç\t\u0012Ä\t\u0012¾\b\u0012»\b\u0012¼\u0007\u0012¹\u0007\u0012Ç\u0006\u0012Ä\u0006\u0012á\u0005\u0012Þ\u0005\u0012\u0005\u0012þ\u0004\u0012§\u0004\u0012¤\u0004\u0012Ó\u0003\u0012Ð\u0003\u0012\u0003\u0012\u0003\u0012½\u0002\u0012º\u0002\u0012û\u0001\u0012ø\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0004\u0012\u00028\u00010\u0015j\u0014\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u0016`\u0017\u0012\u0004\u0012\u00028\u00020\u0015j\u001a\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018\u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a`\u0018\u0012\u0004\u0012\u00028\u00030\u0015j \u0012\u0004\u0012\u00028\u001b\u0012\u0004\u0012\u00028\u001c\u0012\u0004\u0012\u00028\u001d\u0012\u0004\u0012\u00028\u001e\u0012\u0004\u0012\u00028\u001f`\u0019\u0012\u0004\u0012\u00028\u00040\u0015j&\u0012\u0004\u0012\u00028 \u0012\u0004\u0012\u00028!\u0012\u0004\u0012\u00028\"\u0012\u0004\u0012\u00028#\u0012\u0004\u0012\u00028$\u0012\u0004\u0012\u00028%`\u001a\u0012\u0004\u0012\u00028\u00050\u0015j,\u0012\u0004\u0012\u00028&\u0012\u0004\u0012\u00028'\u0012\u0004\u0012\u00028(\u0012\u0004\u0012\u00028)\u0012\u0004\u0012\u00028*\u0012\u0004\u0012\u00028+\u0012\u0004\u0012\u00028,`\u001b\u0012\u0004\u0012\u00028\u00060\u0015j2\u0012\u0004\u0012\u00028-\u0012\u0004\u0012\u00028.\u0012\u0004\u0012\u00028/\u0012\u0004\u0012\u000280\u0012\u0004\u0012\u000281\u0012\u0004\u0012\u000282\u0012\u0004\u0012\u000283\u0012\u0004\u0012\u000284`\u001c\u0012\u0004\u0012\u00028\u00070\u0015j8\u0012\u0004\u0012\u000285\u0012\u0004\u0012\u000286\u0012\u0004\u0012\u000287\u0012\u0004\u0012\u000288\u0012\u0004\u0012\u000289\u0012\u0004\u0012\u00028:\u0012\u0004\u0012\u00028;\u0012\u0004\u0012\u00028<\u0012\u0004\u0012\u00028=`\u001d\u0012\u0004\u0012\u00028\b0\u0015j>\u0012\u0004\u0012\u00028>\u0012\u0004\u0012\u00028?\u0012\u0004\u0012\u00028@\u0012\u0004\u0012\u00028A\u0012\u0004\u0012\u00028B\u0012\u0004\u0012\u00028C\u0012\u0004\u0012\u00028D\u0012\u0004\u0012\u00028E\u0012\u0004\u0012\u00028F\u0012\u0004\u0012\u00028G`\u001e\u0012\u0004\u0012\u00028\t0\u0015jD\u0012\u0004\u0012\u00028H\u0012\u0004\u0012\u00028I\u0012\u0004\u0012\u00028J\u0012\u0004\u0012\u00028K\u0012\u0004\u0012\u00028L\u0012\u0004\u0012\u00028M\u0012\u0004\u0012\u00028N\u0012\u0004\u0012\u00028O\u0012\u0004\u0012\u00028P\u0012\u0004\u0012\u00028Q\u0012\u0004\u0012\u00028R`\u001f\u0012\u0004\u0012\u00028\n0\u0015jJ\u0012\u0004\u0012\u00028S\u0012\u0004\u0012\u00028T\u0012\u0004\u0012\u00028U\u0012\u0004\u0012\u00028V\u0012\u0004\u0012\u00028W\u0012\u0004\u0012\u00028X\u0012\u0004\u0012\u00028Y\u0012\u0004\u0012\u00028Z\u0012\u0004\u0012\u00028[\u0012\u0004\u0012\u00028\\\u0012\u0004\u0012\u00028]\u0012\u0004\u0012\u00028^` \u0012\u0004\u0012\u00028\u000b0\u0015jP\u0012\u0004\u0012\u00028_\u0012\u0004\u0012\u00028`\u0012\u0004\u0012\u00028a\u0012\u0004\u0012\u00028b\u0012\u0004\u0012\u00028c\u0012\u0004\u0012\u00028d\u0012\u0004\u0012\u00028e\u0012\u0004\u0012\u00028f\u0012\u0004\u0012\u00028g\u0012\u0004\u0012\u00028h\u0012\u0004\u0012\u00028i\u0012\u0004\u0012\u00028j\u0012\u0004\u0012\u00028k`!\u0012\u0004\u0012\u00028\f0\u0015jV\u0012\u0004\u0012\u00028l\u0012\u0004\u0012\u00028m\u0012\u0004\u0012\u00028n\u0012\u0004\u0012\u00028o\u0012\u0004\u0012\u00028p\u0012\u0004\u0012\u00028q\u0012\u0004\u0012\u00028r\u0012\u0004\u0012\u00028s\u0012\u0004\u0012\u00028t\u0012\u0004\u0012\u00028u\u0012\u0004\u0012\u00028v\u0012\u0004\u0012\u00028w\u0012\u0004\u0012\u00028x\u0012\u0004\u0012\u00028y`\"\u0012\u0004\u0012\u00028\r0\u0015je\u0012\u0004\u0012\u00028z\u0012\u0004\u0012\u00028{\u0012\u0004\u0012\u00028|\u0012\u0004\u0012\u00028}\u0012\u0004\u0012\u00028~\u0012\u0004\u0012\u00028\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001`#\u0012\u0004\u0012\u00028\u000e0\u0015jr\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001`$\u0012\u0004\u0012\u00028\u000f0\u0015jy\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038\u0001\u0012\u0005\u0012\u00038 \u0001\u0012\u0005\u0012\u00038¡\u0001\u0012\u0005\u0012\u00038¢\u0001\u0012\u0005\u0012\u00038£\u0001\u0012\u0005\u0012\u00038¤\u0001\u0012\u0005\u0012\u00038¥\u0001\u0012\u0005\u0012\u00038¦\u0001\u0012\u0005\u0012\u00038§\u0001\u0012\u0005\u0012\u00038¨\u0001\u0012\u0005\u0012\u00038©\u0001`%\u0012\u0004\u0012\u00028\u00100\u0015j\u0001\u0012\u0005\u0012\u00038ª\u0001\u0012\u0005\u0012\u00038«\u0001\u0012\u0005\u0012\u00038¬\u0001\u0012\u0005\u0012\u00038­\u0001\u0012\u0005\u0012\u00038®\u0001\u0012\u0005\u0012\u00038¯\u0001\u0012\u0005\u0012\u00038°\u0001\u0012\u0005\u0012\u00038±\u0001\u0012\u0005\u0012\u00038²\u0001\u0012\u0005\u0012\u00038³\u0001\u0012\u0005\u0012\u00038´\u0001\u0012\u0005\u0012\u00038µ\u0001\u0012\u0005\u0012\u00038¶\u0001\u0012\u0005\u0012\u00038·\u0001\u0012\u0005\u0012\u00038¸\u0001\u0012\u0005\u0012\u00038¹\u0001\u0012\u0005\u0012\u00038º\u0001\u0012\u0005\u0012\u00038»\u0001`&\u0012\u0004\u0012\u00028\u00110\u0015j\u0001\u0012\u0005\u0012\u00038¼\u0001\u0012\u0005\u0012\u00038½\u0001\u0012\u0005\u0012\u00038¾\u0001\u0012\u0005\u0012\u00038¿\u0001\u0012\u0005\u0012\u00038À\u0001\u0012\u0005\u0012\u00038Á\u0001\u0012\u0005\u0012\u00038Â\u0001\u0012\u0005\u0012\u00038Ã\u0001\u0012\u0005\u0012\u00038Ä\u0001\u0012\u0005\u0012\u00038Å\u0001\u0012\u0005\u0012\u00038Æ\u0001\u0012\u0005\u0012\u00038Ç\u0001\u0012\u0005\u0012\u00038È\u0001\u0012\u0005\u0012\u00038É\u0001\u0012\u0005\u0012\u00038Ê\u0001\u0012\u0005\u0012\u00038Ë\u0001\u0012\u0005\u0012\u00038Ì\u0001\u0012\u0005\u0012\u00038Í\u0001\u0012\u0005\u0012\u00038Î\u0001`'\u0012\u0004\u0012\u00028\u00120\u0015j\u0001\u0012\u0005\u0012\u00038Ï\u0001\u0012\u0005\u0012\u00038Ð\u0001\u0012\u0005\u0012\u00038Ñ\u0001\u0012\u0005\u0012\u00038Ò\u0001\u0012\u0005\u0012\u00038Ó\u0001\u0012\u0005\u0012\u00038Ô\u0001\u0012\u0005\u0012\u00038Õ\u0001\u0012\u0005\u0012\u00038Ö\u0001\u0012\u0005\u0012\u00038×\u0001\u0012\u0005\u0012\u00038Ø\u0001\u0012\u0005\u0012\u00038Ù\u0001\u0012\u0005\u0012\u00038Ú\u0001\u0012\u0005\u0012\u00038Û\u0001\u0012\u0005\u0012\u00038Ü\u0001\u0012\u0005\u0012\u00038Ý\u0001\u0012\u0005\u0012\u00038Þ\u0001\u0012\u0005\u0012\u00038ß\u0001\u0012\u0005\u0012\u00038à\u0001\u0012\u0005\u0012\u00038á\u0001\u0012\u0005\u0012\u00038â\u0001`(\u0012\u0004\u0012\u00028\u00130\u0015jz\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013`):\u0001wB§\u0001\u0012\u0006\u0010?\u001a\u00028\u0000\u0012\u0006\u0010@\u001a\u00028\u0001\u0012\u0006\u0010A\u001a\u00028\u0002\u0012\u0006\u0010B\u001a\u00028\u0003\u0012\u0006\u0010C\u001a\u00028\u0004\u0012\u0006\u0010D\u001a\u00028\u0005\u0012\u0006\u0010E\u001a\u00028\u0006\u0012\u0006\u0010F\u001a\u00028\u0007\u0012\u0006\u0010G\u001a\u00028\b\u0012\u0006\u0010H\u001a\u00028\t\u0012\u0006\u0010I\u001a\u00028\n\u0012\u0006\u0010J\u001a\u00028\u000b\u0012\u0006\u0010K\u001a\u00028\f\u0012\u0006\u0010L\u001a\u00028\r\u0012\u0006\u0010M\u001a\u00028\u000e\u0012\u0006\u0010N\u001a\u00028\u000f\u0012\u0006\u0010O\u001a\u00028\u0010\u0012\u0006\u0010P\u001a\u00028\u0011\u0012\u0006\u0010Q\u001a\u00028\u0012\u0012\u0006\u0010R\u001a\u00028\u0013¢\u0006\u0004\bu\u0010vJ\u0010\u0010*\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b,\u0010+J\u0010\u0010-\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b-\u0010+J\u0010\u0010.\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b.\u0010+J\u0010\u0010/\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b/\u0010+J\u0010\u00100\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b0\u0010+J\u0010\u00101\u001a\u00028\u0006HÆ\u0003¢\u0006\u0004\b1\u0010+J\u0010\u00102\u001a\u00028\u0007HÆ\u0003¢\u0006\u0004\b2\u0010+J\u0010\u00103\u001a\u00028\bHÆ\u0003¢\u0006\u0004\b3\u0010+J\u0010\u00104\u001a\u00028\tHÆ\u0003¢\u0006\u0004\b4\u0010+J\u0010\u00105\u001a\u00028\nHÆ\u0003¢\u0006\u0004\b5\u0010+J\u0010\u00106\u001a\u00028\u000bHÆ\u0003¢\u0006\u0004\b6\u0010+J\u0010\u00107\u001a\u00028\fHÆ\u0003¢\u0006\u0004\b7\u0010+J\u0010\u00108\u001a\u00028\rHÆ\u0003¢\u0006\u0004\b8\u0010+J\u0010\u00109\u001a\u00028\u000eHÆ\u0003¢\u0006\u0004\b9\u0010+J\u0010\u0010:\u001a\u00028\u000fHÆ\u0003¢\u0006\u0004\b:\u0010+J\u0010\u0010;\u001a\u00028\u0010HÆ\u0003¢\u0006\u0004\b;\u0010+J\u0010\u0010<\u001a\u00028\u0011HÆ\u0003¢\u0006\u0004\b<\u0010+J\u0010\u0010=\u001a\u00028\u0012HÆ\u0003¢\u0006\u0004\b=\u0010+J\u0010\u0010>\u001a\u00028\u0013HÆ\u0003¢\u0006\u0004\b>\u0010+JÐ\u0002\u0010S\u001az\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u00130\u00002\b\b\u0002\u0010?\u001a\u00028\u00002\b\b\u0002\u0010@\u001a\u00028\u00012\b\b\u0002\u0010A\u001a\u00028\u00022\b\b\u0002\u0010B\u001a\u00028\u00032\b\b\u0002\u0010C\u001a\u00028\u00042\b\b\u0002\u0010D\u001a\u00028\u00052\b\b\u0002\u0010E\u001a\u00028\u00062\b\b\u0002\u0010F\u001a\u00028\u00072\b\b\u0002\u0010G\u001a\u00028\b2\b\b\u0002\u0010H\u001a\u00028\t2\b\b\u0002\u0010I\u001a\u00028\n2\b\b\u0002\u0010J\u001a\u00028\u000b2\b\b\u0002\u0010K\u001a\u00028\f2\b\b\u0002\u0010L\u001a\u00028\r2\b\b\u0002\u0010M\u001a\u00028\u000e2\b\b\u0002\u0010N\u001a\u00028\u000f2\b\b\u0002\u0010O\u001a\u00028\u00102\b\b\u0002\u0010P\u001a\u00028\u00112\b\b\u0002\u0010Q\u001a\u00028\u00122\b\b\u0002\u0010R\u001a\u00028\u0013HÆ\u0001¢\u0006\u0004\bS\u0010TJ\u0010\u0010V\u001a\u00020UHÖ\u0001¢\u0006\u0004\bV\u0010WJ\u0010\u0010Y\u001a\u00020XHÖ\u0001¢\u0006\u0004\bY\u0010ZJ\u001a\u0010^\u001a\u00020]2\b\u0010\\\u001a\u0004\u0018\u00010[HÖ\u0003¢\u0006\u0004\b^\u0010_R\u0019\u0010F\u001a\u00028\u00078\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010`\u001a\u0004\ba\u0010+R\u0019\u0010R\u001a\u00028\u00138\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010`\u001a\u0004\bb\u0010+R\u0019\u0010J\u001a\u00028\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010`\u001a\u0004\bc\u0010+R\u0019\u0010?\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010`\u001a\u0004\bd\u0010+R\u0019\u0010G\u001a\u00028\b8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010`\u001a\u0004\be\u0010+R\u0019\u0010D\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010`\u001a\u0004\bf\u0010+R\u0019\u0010B\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010`\u001a\u0004\bg\u0010+R\u0019\u0010O\u001a\u00028\u00108\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010`\u001a\u0004\bh\u0010+R\u0019\u0010P\u001a\u00028\u00118\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010`\u001a\u0004\bi\u0010+R\u0019\u0010@\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010`\u001a\u0004\bj\u0010+R\u0019\u0010E\u001a\u00028\u00068\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010`\u001a\u0004\bk\u0010+R\u0019\u0010I\u001a\u00028\n8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010`\u001a\u0004\bl\u0010+R\u0019\u0010H\u001a\u00028\t8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010`\u001a\u0004\bm\u0010+R\u0019\u0010A\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010`\u001a\u0004\bn\u0010+R\u0019\u0010L\u001a\u00028\r8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010`\u001a\u0004\bo\u0010+R\u0019\u0010Q\u001a\u00028\u00128\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010`\u001a\u0004\bp\u0010+R\u0019\u0010K\u001a\u00028\f8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010`\u001a\u0004\bq\u0010+R\u0019\u0010C\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010`\u001a\u0004\br\u0010+R\u0019\u0010M\u001a\u00028\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010`\u001a\u0004\bs\u0010+R\u0019\u0010N\u001a\u00028\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010`\u001a\u0004\bt\u0010+¨\u0006x"}, d2 = {"Larrow/core/Tuple20;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "Larrow/Kind;", "Larrow/core/ForTuple20;", "Larrow/Kind2;", "Larrow/Kind3;", "Larrow/Kind4;", "Larrow/Kind5;", "Larrow/Kind6;", "Larrow/Kind7;", "Larrow/Kind8;", "Larrow/Kind9;", "Larrow/Kind10;", "Larrow/Kind11;", "Larrow/Kind12;", "Larrow/Kind13;", "Larrow/Kind14;", "Larrow/Kind15;", "Larrow/Kind16;", "Larrow/Kind17;", "Larrow/Kind18;", "Larrow/Kind19;", "Larrow/core/Tuple20Of;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "d", "e", "f", g.a, "h", "i", "j", "k", "l", AuthSource.OPEN_CHANNEL_LIST, "n", "o", "p", VKApiConst.Q, "r", "s", "t", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Larrow/core/Tuple20;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getH", "getT", "getL", "getA", "getI", "getF", "getD", "getQ", "getR", "getB", "getG", "getK", "getJ", "getC", "getN", "getS", "getM", "getE", "getO", "getP", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> implements Kind<Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends ForTuple20, ? extends A>, ? extends B>, ? extends C>, ? extends D>, ? extends E>, ? extends F>, ? extends G>, ? extends H>, ? extends I>, ? extends J>, ? extends K>, ? extends L>, ? extends M>, ? extends N>, ? extends O>, ? extends P>, ? extends Q>, ? extends R>, ? extends S>, T> {
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
    public final S s;
    public final T t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Larrow/core/Tuple20$Companion;", "", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Tuple20(A a3, B b2, C c2, D d2, E e2, F f2, G g2, H h2, I i2, J j2, K k2, L l2, M m2, N n2, O o2, P p2, Q q2, R r2, S s2, T t2) {
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
        this.s = s2;
        this.t = t2;
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
    /* JADX DEBUG: Multi-variable search result rejected for r36v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r37v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Tuple20 copy$default(Tuple20 tuple20, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, int i2, Object obj21) {
        return tuple20.copy((i2 & 1) != 0 ? tuple20.a : obj, (i2 & 2) != 0 ? tuple20.b : obj2, (i2 & 4) != 0 ? tuple20.c : obj3, (i2 & 8) != 0 ? tuple20.d : obj4, (i2 & 16) != 0 ? tuple20.e : obj5, (i2 & 32) != 0 ? tuple20.f : obj6, (i2 & 64) != 0 ? tuple20.g : obj7, (i2 & 128) != 0 ? tuple20.h : obj8, (i2 & 256) != 0 ? tuple20.i : obj9, (i2 & 512) != 0 ? tuple20.j : obj10, (i2 & 1024) != 0 ? tuple20.k : obj11, (i2 & 2048) != 0 ? tuple20.l : obj12, (i2 & 4096) != 0 ? tuple20.m : obj13, (i2 & 8192) != 0 ? tuple20.n : obj14, (i2 & 16384) != 0 ? tuple20.o : obj15, (i2 & 32768) != 0 ? tuple20.p : obj16, (i2 & 65536) != 0 ? tuple20.q : obj17, (i2 & 131072) != 0 ? tuple20.r : obj18, (i2 & 262144) != 0 ? tuple20.s : obj19, (i2 & 524288) != 0 ? tuple20.t : obj20);
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

    public final S component19() {
        return this.s;
    }

    public final B component2() {
        return this.b;
    }

    public final T component20() {
        return this.t;
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
    public final Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> copy(A a3, B b2, C c2, D d2, E e2, F f2, G g2, H h2, I i2, J j2, K k2, L l2, M m2, N n2, O o2, P p2, Q q2, R r2, S s2, T t2) {
        return new Tuple20<>(a3, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2, s2, t2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple20)) {
            return false;
        }
        Tuple20 tuple20 = (Tuple20) obj;
        return Intrinsics.areEqual(this.a, tuple20.a) && Intrinsics.areEqual(this.b, tuple20.b) && Intrinsics.areEqual(this.c, tuple20.c) && Intrinsics.areEqual(this.d, tuple20.d) && Intrinsics.areEqual(this.e, tuple20.e) && Intrinsics.areEqual(this.f, tuple20.f) && Intrinsics.areEqual(this.g, tuple20.g) && Intrinsics.areEqual(this.h, tuple20.h) && Intrinsics.areEqual(this.i, tuple20.i) && Intrinsics.areEqual(this.j, tuple20.j) && Intrinsics.areEqual(this.k, tuple20.k) && Intrinsics.areEqual(this.l, tuple20.l) && Intrinsics.areEqual(this.m, tuple20.m) && Intrinsics.areEqual(this.n, tuple20.n) && Intrinsics.areEqual(this.o, tuple20.o) && Intrinsics.areEqual(this.p, tuple20.p) && Intrinsics.areEqual(this.q, tuple20.q) && Intrinsics.areEqual(this.r, tuple20.r) && Intrinsics.areEqual(this.s, tuple20.s) && Intrinsics.areEqual(this.t, tuple20.t);
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

    public final S getS() {
        return this.s;
    }

    public final T getT() {
        return this.t;
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
        int hashCode18 = (hashCode17 + (r2 != null ? r2.hashCode() : 0)) * 31;
        S s2 = this.s;
        int hashCode19 = (hashCode18 + (s2 != null ? s2.hashCode() : 0)) * 31;
        T t2 = this.t;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        return hashCode19 + i2;
    }

    public String toString() {
        StringBuilder L = a.L("Tuple20(a=");
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
        L.append((Object) this.r);
        L.append(", s=");
        L.append((Object) this.s);
        L.append(", t=");
        return a.r(L, this.t, ")");
    }
}
