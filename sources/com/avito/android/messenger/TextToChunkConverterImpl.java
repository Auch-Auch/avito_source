package com.avito.android.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Patterns;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u00020\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/TextToChunkConverterImpl;", "Lcom/avito/android/messenger/TextToChunkConverter;", "", "text", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "convertToTextChunks", "(Ljava/lang/String;)Ljava/util/List;", "Ljava/util/regex/Pattern;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getLatinAlphaNumericOrPunctuationPattern", "()Ljava/util/regex/Pattern;", "latinAlphaNumericOrPunctuationPattern", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class TextToChunkConverterImpl implements TextToChunkConverter {
    public final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<Pattern> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Pattern invoke() {
            return new Regex("[[a-zA-Z0-9][\\\\!\"#$%&'\\(\\)\\*\\+,-\\./:;\\<\\=\\>\\?@\\[\\]\\^_`\\{\\|\\}~]]+").toPattern();
        }
    }

    public static final Pattern access$getLatinAlphaNumericOrPunctuationPattern$p(TextToChunkConverterImpl textToChunkConverterImpl) {
        return (Pattern) textToChunkConverterImpl.a.getValue();
    }

    @Override // com.avito.android.messenger.TextToChunkConverter
    @NotNull
    public List<MessageBody.Text.Chunk> convertToTextChunks(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        ArrayList arrayList = new ArrayList();
        int length = str.length() - 1;
        Matcher matcher = Patterns.INSTANCE.getWEB_URL().matcher(str);
        int i = -1;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end() - 1;
            if ((start <= 0 || str.charAt(start + -1) != '@') && (end >= str.length() - 1 || str.charAt(end + 1) != '@')) {
                Pattern access$getLatinAlphaNumericOrPunctuationPattern$p = access$getLatinAlphaNumericOrPunctuationPattern$p(this);
                String substring = str.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (access$getLatinAlphaNumericOrPunctuationPattern$p.matcher(substring).matches()) {
                    int i2 = i + 1;
                    int i3 = start - 1;
                    if (i3 - i2 >= 0) {
                        String substring2 = str.substring(i2, i3 + 1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (!m.isBlank(substring2)) {
                            while (t6.y.a.isWhitespace(str.charAt(i2))) {
                                i2++;
                            }
                            while (t6.y.a.isWhitespace(str.charAt(i3))) {
                                i3--;
                            }
                            arrayList.add(new MessageBody.Text.Chunk.Plain(i2, i3));
                        }
                    }
                    arrayList.add(new MessageBody.Text.Chunk.Link(start, end));
                    i = end;
                }
            }
        }
        int i4 = i + 1;
        if (length - i4 >= 0) {
            String substring3 = str.substring(i4, length + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (true ^ m.isBlank(substring3)) {
                while (t6.y.a.isWhitespace(str.charAt(i4))) {
                    i4++;
                }
                while (t6.y.a.isWhitespace(str.charAt(length))) {
                    length--;
                }
                arrayList.add(new MessageBody.Text.Chunk.Plain(i4, length));
            }
        }
        return arrayList;
    }
}
