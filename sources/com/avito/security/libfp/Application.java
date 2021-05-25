package com.avito.security.libfp;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.SystemProperties;
import com.avito.android.lib.design.input.FormatterType;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.InflaterOutputStream;
import kotlin.UShort;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
public class Application {
    private static byte[] A;
    private static boolean Iprx;
    private static Object[] kqfg;
    private static boolean l;
    private static Object wB;

    /* renamed from: com.avito.security.libfp.Application$Application  reason: collision with other inner class name */
    public class C0170Application extends ContextWrapper {

        /* renamed from: com.avito.security.libfp.Application$Application$Application  reason: collision with other inner class name */
        public final class C0171Application {
            private static final Class[] DroB = new Class[98];
            private static final Object[] EdDn = new Object[349];
            private static final int dcJg = Integer.parseInt(Application.Cewzfu("溰竴밅飾旗枉㸞줊▗"));
            private static final int fxD = Integer.parseInt(Application.Cewzfu("溬竽밀飴旝枊㸘줆▟"));
            private static final short[] t = new short[349];
            private static final int[] wCej = new int[349];

            /* renamed from: com.avito.security.libfp.Application$Application$Application$Application  reason: collision with other inner class name */
            public class C0172Application extends FilterInputStream {
                private byte[] ohs = new byte[1];
                public Application$Application$FingerprintService$a qf;

                /* renamed from: com.avito.security.libfp.Application$Application$Application$Application$Application  reason: collision with other inner class name */
                public class C0173Application {
                    public static native void d();

                    public static native void e();

                    public static native void f();

                    public static native void n();

                    public static native void r();

                    public static native void x();
                }

                public C0172Application(InputStream inputStream, Application$Application$FingerprintService$a application$Application$FingerprintService$a) {
                    super(inputStream);
                    this.qf = application$Application$FingerprintService$a;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public boolean markSupported() {
                    return false;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public synchronized int read() throws IOException {
                    int i;
                    i = -1;
                    if (read(this.ohs, 0, 1) != -1) {
                        i = this.ohs[0] & 255;
                    }
                    return i;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr) throws IOException {
                    return read(bArr, 0, bArr.length);
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int read = super.read(bArr, i, i2);
                    if (read > 0) {
                        this.qf.xnw(bArr, i, read);
                    }
                    return read;
                }
            }

            static {
                char[] charArray = Application.Cewzfu("졣䛻斩햗㢏맓쌌捣剅嘖ᷝ䶥菺멲ᨂ꓄蚩⑴롂獾梨滞?䩊뙴졐뉢ꬂ⥆ᬯ塋⪻伋瘈ቋ紃돌\u0016举屈롔?Ⓤ噏ᮛ廽摳ꏗ迖㑣鴞ﻦ칧ᷯ谙疥哾ꐗ镵鍪?扎䘽툮雞⾒鷖컛ઽᖭ?枧噮涥眰箹ʃᦒ≣㦢䜌㈟뻭᭻횒㟬嚛⓴뢮裂੉袹셵뭝螘ⳃ敳⮑?㮁䵀䕇產̑篨ね纣ḻ皃빸篟騱葳齐㴬驻㗰㌿酦郶鍱伅直쿁㢡ᠺ௑쇿ﺿ繏誧닎옘瘛嫘≷?讖蒨덩씨蛵?襲两ჽ䱪觍㱿둽眞哤馥읦?臧⧖뽊힗₍谤͐䗸ڝ맻瞓ᔫ⏓῵鏃놴녽旑ྥꕏꥄ몄쫐횠䍇숊蛿ᠵ썭焢楧지渲ꂘⅷ餧?耀婑垟쭌詠孋콚퇸඿ۍ臼꣚纊?끤讍ﻆ逍넟鮔Ꞔ긂怉鶶内᭘?෗魺䨎䃵된屉煄ꋻ研⁅ꡚ똵졌㒟揿ՠ廌㛍蛓욢ꉂ?헦뛓쬧䡿₏䪯᜜搞쯚㴅坬Ư粑ጪ㶁᛻琯峩ꌡ?言ꍨῐ鄰䭡碕ᫍ⌮㋦ㄾ?묑鷕闹儫꽗삣겢릒㝚♴傄鬊쬷?챿䕴驝婢˥ꡟ㼘ࢽ匂ಢ밼䝿㘯섧艘ᘭ?橥䀴㵓૵솿䪳⻚⾃䇫事㗛鷸⠺筧꽂饽ꤏ㜌㻇ᆘᎳ눏넽褼∇ꖷ듃繎ୖ⼳亇燚囀璑≢垧ṥḏ?㩹類㕲鏾徢뒚ᴕﲇ낊졢虽嘔⾥︋ᴎ봥涅밢﷘䥠᙭䠋舉ﴳۂ쐍ꢴ⎂뽮⵩㗫쵠ᓔ?鄁Ꜭ?貢ꉦ勋䬏됀혋볥㐲㾷䏁썩s귅髎⽰➢ᰫ撲冋䋮揪ꒄ뢔噜춵삺囹ಲꡦ뾟ⰱᎎ࿞?僭颤俆Ӱ?ථᛉ㡊넦ᡶ﫝盏ꂯ㹌座㖌?툊噉쉕㓵⥶֧ﺅࡾ冑䲆뒸墫륕?졕氙ꃞ𑕱ᭌᗠ耨䏪舑笰㴚箪뢽㬑ऱࢹ꩖匆逐箪늏裻ਃ遍몙䅸榣쳵艶뾥⸣π猌ꀣ僣諊뫾慪읧♆ə籱䟈棈ᝉ쑟檧哨ቘ䮂鿅?鯼웻ᤕ덓鹈㿏毎ꟾ脿ᦔ㳙鬭澄낛뻲데鹑舑뻓䠳ﯭ爄ꢊꑇ꺘⬳馾⻆귮䛶憠磎뒕?￲ꍴ⻚㟢ﻑﮱ玀瓌䇝쀲?郰⥶鲲鉉黲㋔丄⠊ꇷ絪ᯞ칰嶖郇䄗䆳䔰줍赠腷홴吇鞪닱铪෮镫轅칅⻇㞊苼酏ㆈ❑늋덪퀀㉃䈤桵㱦唘榉쫂ᐇ職꺟펾뭋ꊳ茼䍰뵒⡇脴욼弰ႇ끝ᷫ쪹ྉᲅ邡춅ᱸ?軹蹈?ᅁ関䬟䎼뭷ﳩ嬧侮뤶폮孨⒗뺫躚㸒操㜰⢡ꪡ構诤녔湊?㗋⵬垻樴").toCharArray();
                for (int i = 0; i < 349; i++) {
                    int i2 = i * 2;
                    wCej[i] = (charArray[i2 + 1] << 16) | charArray[i2];
                }
                char[] charArray2 = Application.Cewzfu("滐窘뱣飒旰枢㸌쥮▀输亲㖡㊫䦣캱氍刢쟜㟫屔샂谓⣴먂쏺ᓳ嫥撟㒫ٲ熝拙퇿๨哥⛽䩗䔚⨶㥊並쥳녷ꯕ햾ⱄ둇칚䗳昜ᢍ뮯꤇㴸㳫ሁꅊ怅畗蒈譏䨧랂フ림䳪㢕复穪ޟ筼橲꾌뾐ㆬӦ?෾娫㌹萆忕▬苰ᅈ郶谊虈뇗ᦇ᮵帽槣〜滃珦닢鈵溰都綤냭䦺醔ﾟ쳇粴׆ඩ䎔톺⢧誾晃뀦쯸胞꾄Ø卒冢鄺贂갭䇒ాᤓ룘ᡑꌂ줚䨠េᖻӼ঴ீ褔魌ꤠ쯵췈뛭屿쿺쵘䰑ꪍ쥹豞见䈭치黥톮붎뜨㴢⪧嶬ࢫ酭轆鏏㫁꺠㚻낍標뛬??董壂剑珉檑ǂ칇뗋爇썦墔揍ᓭ⨽扨ᝪṵꂌꂂ䗯왬埆ߛ첾㤝⠦ง딁㱈偦逗ш饰覒禨敓ꝏ獞윙䵡촄㖿㯖䂊篖듬켿憅㧑悰覟㴽䙰號?뚆▟ᚹ䙠税恟㘯臍蠔鎺鉵戋䌺탚≠䥓桄经娪￦劽歰܊컲戶섎뒰䚅棒ꌌ瘜韊ྻ㚑?୷뮭ᑛ˧㔦ﳿ櫨ࢅ℞麾??携鉬鐀咞㟯堕受鰕?厱涋鰍켌쑥╜?萇?⑆繜邒ᥰ퇠햹⾉罸⭋唨菃㮊巬ၯႚퟷ숼᫏ᴶấꯡѪ砐唪ጌ锬?깑䵢⇩⨜뗯蒷㕙").toCharArray();
                for (int i3 = 0; i3 < 349; i3++) {
                    t[i3] = (short) charArray2[i3];
                }
            }

            public static Object HwmxABqfwI(int i, Object[] objArr) {
                try {
                    int i2 = ((((i - -1920484018) ^ fxD) + 1583221770) ^ -2090518445) + dcJg;
                    int i3 = i2 >>> 16;
                    int i4 = i2 & 65535;
                    Class nIIloyAn = nIIloyAn(i4, i3);
                    Constructor<?> constructor = (Constructor) EdDn[i4];
                    if (constructor == null) {
                        int i5 = wCej[i4];
                        Constructor<?>[] declaredConstructors = nIIloyAn.getDeclaredConstructors();
                        int length = declaredConstructors.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            }
                            Constructor<?> constructor2 = declaredConstructors[i6];
                            int i7 = (i3 * 31) + 40;
                            Class<?>[] parameterTypes = constructor2.getParameterTypes();
                            for (int i8 = 0; i8 < parameterTypes.length; i8++) {
                                Class<?> cls = parameterTypes[i8];
                                if (i8 != 0) {
                                    i7 = (i7 * 31) + 44;
                                }
                                i7 = (i7 * 31) + cls.getName().hashCode();
                            }
                            if (i5 == (((i7 * 31) + 41) * 31) + i3) {
                                constructor2.setAccessible(true);
                                EdDn[i4] = constructor2;
                                constructor = constructor2;
                                break;
                            }
                            i6++;
                        }
                    }
                    if (constructor != null) {
                        return constructor.newInstance(objArr);
                    }
                    throw new NoSuchMethodError(Integer.toString(i4));
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }

            public static void ekypkbk(Object obj, int i, Object[] objArr) {
                int i2 = ((((i - -1920484018) ^ fxD) + 1583221770) ^ -2090518445) + dcJg;
                int i3 = i2 >>> 16;
                int i4 = i2 & 65535;
                Class nIIloyAn = nIIloyAn(i4, i3);
                Constructor<?> constructor = (Constructor) EdDn[i4];
                if (constructor == null) {
                    int i5 = wCej[i4];
                    Constructor<?>[] declaredConstructors = nIIloyAn.getDeclaredConstructors();
                    int length = declaredConstructors.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        Constructor<?> constructor2 = declaredConstructors[i6];
                        int i7 = (i3 * 31) + 40;
                        Class<?>[] parameterTypes = constructor2.getParameterTypes();
                        for (int i8 = 0; i8 < parameterTypes.length; i8++) {
                            Class<?> cls = parameterTypes[i8];
                            if (i8 != 0) {
                                i7 = (i7 * 31) + 44;
                            }
                            i7 = (i7 * 31) + cls.getName().hashCode();
                        }
                        if (i5 == (((i7 * 31) + 41) * 31) + i3) {
                            constructor2.setAccessible(true);
                            EdDn[i4] = constructor2;
                            constructor = constructor2;
                            break;
                        }
                        i6++;
                    }
                }
                if (constructor != null) {
                    StringBuilder sb = new StringBuilder();
                    Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                    for (int i9 = 0; i9 < parameterTypes2.length; i9++) {
                        sb.append(parameterTypes2[i9] == Boolean.TYPE ? Matrix.MATRIX_TYPE_ZERO : parameterTypes2[i9] == Byte.TYPE ? 'B' : parameterTypes2[i9] == Character.TYPE ? 'C' : parameterTypes2[i9] == Double.TYPE ? 'D' : parameterTypes2[i9] == Float.TYPE ? 'F' : parameterTypes2[i9] == Integer.TYPE ? 'I' : parameterTypes2[i9] == Long.TYPE ? 'J' : parameterTypes2[i9] == Short.TYPE ? 'S' : Matrix.MATRIX_TYPE_RANDOM_LT);
                    }
                    LibApplication.c(obj, constructor, sb.toString(), objArr);
                    return;
                }
                throw new NoSuchMethodError(Integer.toString(i4));
            }

            public static Object k(int i) {
                int i2 = ((((i - -1920484018) ^ fxD) + 1583221770) ^ -2090518445) + dcJg;
                return LibApplication.a(nIIloyAn(i2 & 65535, i2 >>> 16));
            }

            private static Field kI(int i) throws Throwable {
                int i2 = ((((i - -1920484018) ^ fxD) + 1583221770) ^ -2090518445) + dcJg;
                int i3 = i2 >>> 16;
                int i4 = i2 & 65535;
                Field field = (Field) EdDn[i4];
                if (field != null) {
                    return field;
                }
                int i5 = wCej[i4];
                for (Class nIIloyAn = nIIloyAn(i4, i3); nIIloyAn != null; nIIloyAn = nIIloyAn.getSuperclass()) {
                    Field[] declaredFields = nIIloyAn.getDeclaredFields();
                    for (Field field2 : declaredFields) {
                        if (i5 == ((field2.getType().getName().hashCode() + ((((field2.getName().hashCode() + (i3 * 31)) * 31) + 58) * 31)) * 31) + i3) {
                            field2.setAccessible(true);
                            EdDn[i4] = field2;
                            return field2;
                        }
                    }
                }
                return null;
            }

            private static Class nIIloyAn(int i, int i2) {
                int i3 = ((t[i] & UShort.MAX_VALUE) + i2) % 98;
                Class[] clsArr = DroB;
                Class cls = clsArr[i3];
                if (cls != null) {
                    return cls;
                }
                Class saDew = saDew(i3);
                clsArr[i3] = saDew;
                return saDew;
            }

            public static Object nxpB(int i, Object[] objArr) {
                try {
                    Method tvAczfyew = tvAczfyew(i);
                    if (tvAczfyew != null) {
                        return tvAczfyew.invoke(null, objArr);
                    }
                    throw new NoSuchMethodError(Integer.toString(i));
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }

            public static void nyizCqsyD(int i, Object obj) {
                teCHggwzq(null, i, obj);
            }

            public static Object oFJq(Object obj, int i, Object[] objArr) {
                try {
                    Method tvAczfyew = tvAczfyew(i);
                    if (tvAczfyew != null) {
                        return tvAczfyew.invoke(obj, objArr);
                    }
                    throw new NoSuchMethodError(Integer.toString(i));
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }

            public static Object rfdkigAIy(int i) {
                return sHoxwzyCw(null, i);
            }

            public static Object sHoxwzyCw(Object obj, int i) {
                Field kI = kI(i);
                if (kI != null) {
                    return kI.get(obj);
                }
                throw new NoSuchFieldError(Integer.toString(i));
            }

            private static Class saDew(int i) {
                String str;
                switch (i) {
                    case 0:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볕";
                        break;
                    case 1:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 2:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 3:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볒ՙ옭鄓䵘冋ﳺⲡ曖쪉摭禇㹲꙾ᬽ鐪␅騞딧ﵢ၁︗産ᛇ䏩垂慛谥♨Ⲯ?뿥⿷䅸ⷘ";
                        break;
                    case 4:
                        str = "ᴧย燹얆ᕳ夯⤤䂃늗攡쏆悞þ?斧ჭ닟쥩碦?볔";
                        break;
                    case 5:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏬惞ø?";
                        break;
                    case 6:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏺惄ÿ?斪ჿ닯쥵碻?볕";
                        break;
                    case 7:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 8:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 9:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 10:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?";
                        break;
                    case 11:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늋攡쏀惜£?斫ჿ";
                        break;
                    case 12:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볒";
                        break;
                    case 13:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늝攺쏇惄è?新Ⴖ닝쥭磼?병՜옉鄪䵆冁ﳼ";
                        break;
                    case 14:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?";
                        break;
                    case 15:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볞";
                        break;
                    case 16:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏺惄ÿ?斪ჿ";
                        break;
                    case 17:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볛";
                        break;
                    case 18:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볈";
                        break;
                    case 19:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볁";
                        break;
                    case 20:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볚";
                        break;
                    case 21:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 22:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늝攺쏇惄è?新Ⴖ닮쥯碼?볈";
                        break;
                    case 23:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늝攺쏇惄è?新Ⴖ닟쥥碡?볕Ն옞鄀䵍冔";
                        break;
                    case 24:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늋攡쏀惜£?断ძ닝쥬碳?볕՛옏鄐";
                        break;
                    case 25:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏤惑ù?";
                        break;
                    case 26:
                        str = "ᴖฏ燬얈ᔰ奨⤪䃛늸攼쏅惕";
                        break;
                    case 27:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?";
                        break;
                    case 28:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늝攺쏇惄è?新Ⴖ닝쥭磼?볓Ո옉鄮䵉冉ﳲⲥ曒쪏";
                        break;
                    case 29:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늑攦쎇惲ø?斨ჼ늉쥖碗?볹է";
                        break;
                    case 30:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏨惂ÿ?施ე닄쥳碦";
                        break;
                    case 31:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볙";
                        break;
                    case 32:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏠惞ù?斣ჽ닟";
                        break;
                    case 33:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 34:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볘";
                        break;
                    case 35:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 36:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏠惄è?斥ჺ닁쥥";
                        break;
                    case 37:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏠惄è?斥წ닂쥲";
                        break;
                    case 38:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?";
                        break;
                    case 39:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늎攧쏆惆ä?斡ც늃쥓碷?볙Վ왈鄰䵍冄ﳦⲰ曒";
                        break;
                    case 40:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늑攦쎇惲ø?斨ჼ";
                        break;
                    case 41:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏧情á?斔ჷ닄쥮碦?복Պ옜鄗䵁冈ﳽ";
                        break;
                    case 42:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늖攴쏛惔ú?斶ჽ늃쥓碷?볟դ옂鄂䵏冂ﳡ";
                        break;
                    case 43:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볖";
                        break;
                    case 44:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늖攴쏛惔ú?斶ჽ늃쥓碷?볟";
                        break;
                    case 45:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏺惉þ?斡ჵ";
                        break;
                    case 46:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏊惟ã?斱ც닟쥥碼?볤Մ옹鄍䵁冓";
                        break;
                    case 47:
                        str = "ᴖฏ燬얈ᔰ奨⤪䃛늬攴쏇惔â?斅჻닎쥥碡?볙Ռ";
                        break;
                    case 48:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏛惕ê?於Ⴖ닽쥡碦?볂";
                        break;
                    case 49:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏛惕ê?於Ⴖ닠쥡碦?볕";
                        break;
                    case 50:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏭惟ø?斨ჽ";
                        break;
                    case 51:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늟攥쏙悞Ì?新ჱ닛쥩碦?병Ո옉鄑䴌冪ﳶⲯ曘쪏摋禇㸰Ꙑ";
                        break;
                    case 52:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늟攥쏙悞Ì?新ჱ닛쥩碦?병Ո옉鄑";
                        break;
                    case 53:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늑攦쎇惵ã?断ც닂쥮碿?별";
                        break;
                    case 54:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 55:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늑攦쎇惣ù?新პ닞";
                        break;
                    case 56:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볒ՙ옪鄊䵆冀ﳶⲰ曇쪏摬禝㸅Ꙛᬿ鐬␀騔딡ﵷ";
                        break;
                    case 57:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏫惙ù?斡წ";
                        break;
                    case 58:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볗";
                        break;
                    case 59:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛늝攺쏇惄è?新Ⴖ닝쥭磼?변Հ옍鄗䵁冈ﳽⲋ曙쪛";
                        break;
                    case 60:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏥惟î?斨ჽ";
                        break;
                    case 61:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛느攰쏝悞ú?斢ჱ늃쥗碻?볽Շ옋鄆䵚";
                        break;
                    case 62:
                        str = "ᴝ฀燾얛ᕱ奨⤡䃛느攰쏝悞ú?斢ჱ늃쥗碻?볹Տ";
                        break;
                    case 63:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏥惙þ?";
                        break;
                    case 64:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏥惙þ?斍წ니쥲碳?볂";
                        break;
                    case 65:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏪惘ì?斗ჽ닜쥵碷?볕";
                        break;
                    case 66:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏪惟á?斡჻닙쥩碽";
                        break;
                    case 67:
                        str = "ᴖฏ燬얈ᔰ奯⤠䂁닐攛쏌惄ú?斶ჳ다쥮碦?볖Պ";
                        break;
                    case 68:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏪惟á?斡჻닙쥩碽?";
                        break;
                    case 69:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 70:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?변";
                        break;
                    case 71:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 72:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볔";
                        break;
                    case 73:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볂";
                        break;
                    case 74:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?병";
                        break;
                    case 75:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볃";
                        break;
                    case 76:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볇";
                        break;
                    case 77:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볅";
                        break;
                    case 78:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볓";
                        break;
                    case 79:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볟";
                        break;
                    case 80:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볆";
                        break;
                    case 81:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볝";
                        break;
                    case 82:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?별";
                        break;
                    case 83:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볜";
                        break;
                    case 84:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    case 85:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볒ՙ옪鄊䵆冀ﳶⲰ曇쪏摬禝㸅Ꙛᬿ鐬␀騔딡";
                        break;
                    case 86:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?볒ՙ옭鄓䵘冋ﳺⲡ曖쪉摭禇㹲꙾ᬽ鐪␅騞딧ﵢ၁︗産ᛇ䏩垂慛谥♨Ⲯ?뿥⿷䅸ⷘᴵ痷付献ꍽᘴｾਈ卑㣑ꄸ傣꬙缹⋂鍺討੒Ⱌ숯惥붦齦";
                        break;
                    case 87:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?";
                        break;
                    case 88:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏫惉ù?";
                        break;
                    case 89:
                        str = "ᴖฏ燬얈ᔰ奴⤱䂜늒敻쏨惂ÿ?施ძ";
                        break;
                    case 90:
                        str = "ᴖฏ燬얈ᔰ奭⤤䂛늙敻쏦惒ç?斧წ";
                        break;
                    case 91:
                        str = "ᴖฏ燬얈ᔰ奲⤠䂖늋攧쏀惄ô?斍ჶ닛쥡碾?볻Ր옔鄀䵍冗ﳧⲫ曘쪓";
                        break;
                    case 92:
                        str = "ᴖฏ燬얈ᔰ奨⤪䃛늼攬쏝惕Ì?斶ჹ닔쥉碼?별՝옉鄂䵅";
                        break;
                    case 93:
                        str = "ᴖฏ燬얈ᔰ奨⤪䃛늼攬쏝惕Ì?斶ჹ닔쥏碧?볅պ옞鄆䵉冊";
                        break;
                    case 94:
                        str = "ᴖฏ燬얈ᔰ奨⤪䃛늷攻쏙情ù?新ც니쥡碿";
                        break;
                    case 95:
                        str = "ᴖฏ燬얈ᔰ奨⤪䃛늱攠쏝惀ø?斗წ닟쥥碳";
                        break;
                    case 96:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼?";
                        break;
                    case 97:
                        str = "ᴟก燷엇ᕿ奷⤬䂁늑敻쏚惕î?斶ჱ닙쥹磼";
                        break;
                    default:
                        throw new NoClassDefFoundError(Integer.toString(i));
                }
                return Class.forName(Application.Cewzfu(str));
            }

            public static void teCHggwzq(Object obj, int i, Object obj2) throws Throwable {
                Field kI = kI(i);
                if (kI != null) {
                    kI.set(obj, obj2);
                    return;
                }
                throw new NoSuchFieldError(Integer.toString(i));
            }

            private static Method tvAczfyew(int i) {
                int i2 = ((((i - -1920484018) ^ fxD) + 1583221770) ^ -2090518445) + dcJg;
                int i3 = i2 >>> 16;
                int i4 = i2 & 65535;
                Method method = (Method) EdDn[i4];
                if (method != null) {
                    return method;
                }
                Class nIIloyAn = nIIloyAn(i4, i3);
                int i5 = wCej[i4];
                for (Class cls = nIIloyAn; cls != null; cls = cls.getSuperclass()) {
                    Method[] methods = cls.isInterface() ? cls.getMethods() : cls.getDeclaredMethods();
                    for (Method method2 : methods) {
                        int hashCode = ((method2.getName().hashCode() + (i3 * 31)) * 31) + 40;
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                            Class<?> cls2 = parameterTypes[i6];
                            if (i6 != 0) {
                                hashCode = (hashCode * 31) + 44;
                            }
                            hashCode = (hashCode * 31) + cls2.getName().hashCode();
                        }
                        if (i5 == ((method2.getReturnType().getName().hashCode() + (((hashCode * 31) + 41) * 31)) * 31) + i3) {
                            method2.setAccessible(true);
                            EdDn[i4] = method2;
                            return method2;
                        }
                    }
                }
                while (nIIloyAn != null) {
                    for (Class<?> cls3 : nIIloyAn.getInterfaces()) {
                        Method[] methods2 = cls3.getMethods();
                        for (Method method3 : methods2) {
                            int hashCode2 = ((method3.getName().hashCode() + (i3 * 31)) * 31) + 40;
                            Class<?>[] parameterTypes2 = method3.getParameterTypes();
                            for (int i7 = 0; i7 < parameterTypes2.length; i7++) {
                                Class<?> cls4 = parameterTypes2[i7];
                                if (i7 != 0) {
                                    hashCode2 = (hashCode2 * 31) + 44;
                                }
                                hashCode2 = (hashCode2 * 31) + cls4.getName().hashCode();
                            }
                            if (i5 == ((method3.getReturnType().getName().hashCode() + (((hashCode2 * 31) + 41) * 31)) * 31) + i3) {
                                method3.setAccessible(true);
                                EdDn[i4] = method3;
                                return method3;
                            }
                        }
                    }
                    nIIloyAn = nIIloyAn.getSuperclass();
                }
                return null;
            }
        }

        public C0170Application(Context context) {
            super(context);
        }

        public static Context uFGzCfc() {
            Context context = (Context) Class.forName(Application.Cewzfu("矕䲝┚謠ⵅ蝨ኵ⯙យ쫏弋簢緮?Ḑ獕?儷踊뮊ǭ䲃栅籓ᤙ룹")).getDeclaredMethod(Application.Cewzfu("矗䲆┌謠ⵏ蝯እ⮶ឈ쫏弗籥緌?Ḑ獕?儰"), null).invoke(null, null);
            if (context == null) {
                context = zIikHv();
            }
            return new C0170Application(context);
        }

        private static Context zIikHv() {
            Thread thread = Looper.getMainLooper().getThread();
            Class<?> cls = Class.forName(Application.Cewzfu("턮ﲦ쥅⪇딬魍⚦充㗺텕蠂検?耖ᤗ긅犱晭璴蛫㕧?솽铻"));
            Field declaredField = thread.getClass().getDeclaredField(Application.Cewzfu("턣ﲧ쥂⪄딓鬏⚲児㗹"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(thread);
            Field declaredField2 = obj.getClass().getDeclaredField(Application.Cewzfu("턻ﲩ쥃⪍"));
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            for (int i = 1; i < objArr.length; i += 2) {
                Object obj2 = objArr[i];
                if (obj2 != null && obj2.getClass() == cls) {
                    return (Context) cls.getDeclaredMethod(Application.Cewzfu("턨ﲭ쥕⪘딵鬊⚤兔㗾턒蠬椑"), new Class[0]).invoke(obj2, new Object[0]);
                }
            }
            return null;
        }
    }

    static {
        char[] charArray = Cewzfu("Ꮧ癕씐똰뭷蓁懅픱暝ꞯ臬臫髢ไ翬ႅ佻は臫ⲍ悳?쿅隒禦⌿ꉱ臽婌䊒ꈬ㙨쵎䧨﫬稆ꋷ⚦㵈鸶劂⪌㊯辘鏪왅䫻죫??곎⺳ჷ푏뙺ᒤ遽㢱僃姙ꟲﺒ퉹⨷?굹와?ᩒ®䊫甲៳⣛麪㎣灥忚㛔볖뛖ㅳ㘽䴊抱ﴨ蜐駾큤㪅챒檣퓷ࣨ௧ﯨ仆榝빴ⱷ㥲վ㫩뻕ꪽ㎛鍙遟쀅뽖䴽绞艓씯硱劲败ఐ펈同᰷寈㽙Ო癨℠굣㏀儁ࢽ켪裺ン눷乛瞮ᖴꮞ彯웸ꔂᒽ겪榬渕䄤腧ऒᝲ츁䍹ꏂ㈋㛊툽녽裒谯莁젱헯Պ뮮ὲ轷啕衩艆띎⬩룖풔膢빬仔儭冗쵟Ő跈풜꜄툈髌赣뜀Ộ宼⌕칭ꡉЇソ邔ࡒ౔?嚐靔ꬄ㔠멾㚜鍶浺ꏈ諢넀。ﳩ⤘딇웺꣧柕閏র戚ꋠ蒈蹱䜮즋႒迂?돤湀睰ႌ앩賡䔓䭞䀘ر䀦戵፜뀯鐈蹬冧槹ᔼ竮凼⢢⊮腵ϯឍ퀼⪂ⲯꬊ꾮⬁確엺秷ⶐ䰞౭ꥡᓸ膋팎롒ᨄ翇⺸쟃푏ᱥ쮚뮨㋲큩뎹ᯚ柼褠ẞ拎헗㒹ⷑ䇄啶뀚ඬ퀲﫽ᤔ凊ᖕ闲㪣땂벼垒〛抬阹ꘗﺩ䙘篠탯ˠᖧ⹄鄥绩띄ꆧꆷ뉌汿輵Ꙁ蔝㺮ꘃ痏⪜唍膄蝷Եڏ볰귨惟ⷵ쭣?ꯈꥒꩼ᪇硥㱝匊죔᝴᷶琥ᗍち쳚䰵퍍偬蕺뽨덟颇Ꮮ鯜娻쑻쇪땽컃詵칬橪嘍銷⓰ᡣ⾱uꖞ僎꿍葌⊝??州詮섖헪珨ﱌ㟚ཊ仠臀拱뜪᡹坚푋汘ꙫ㺱荃醡딩ᅪ柕꣖鞾漼༳蒪쥱㷪랄慌톒䅜⾌᭵鸍羠쑑巰읯槼惵罜蟄䯏?裗峀撁Ⳋ寁椊鼓뒇Sᦎ뭚ꁳ??쪄吖㻇?魒ݩ㘻ퟰ㌼媶陌홫竣㱴叕㸴〈洧ꓫ꽴뾶傄䥶Ẩ୩䯲笾雳挿࣯㎲䱤ﾺ䃧嶒៽ꓟ⥔榮툁質㱁끁?큧襅⵹ꏺ൧䛡튜꿂矰遙塥ቔ蠕ⲥ≐⸧殂䊍靮⌖㘍퇽葾阎㈩噎整죥럷゠殪㛁榃겳騼礡盄瀛酇ઘ੾멟គ䘼臤觟ᔩ쯍咇嬶訅⇮?奧弊㈎鍻㓚돗ᝪ姫뤎?ꄢᆻ鰁፠혱撍轭?漫䀿툷㤯䫺摅藱ᮣ꼠럄䀩೥얉쾢‎౽跩ω垿钗請檴磵ᓹ賚汖琢栌챟墀ဘꃧ밖塭턺摦䲂⢶₷滺꽇圭렛ㄱ᭳ɵ⤇퍝ሙ뒽ᐢ敆承堡君㮎갋䏳搖괴瞩蘖ꈅᜏ快녻嫊텎ኖΡ㡙꺦凇⺭ꪚ쿿ꨈ擪븙詟䎊Ꭱ큍묎࿤榸褳鉩W⡮겅镲瓶)ᯥ?㺌澖俐䅄豅抺煈鰴裰ꪜ젞䲛磃닌ږ䶆೭뾩モ蓜偰嶼뽁쀭ṍ逜疃い旫麑䕙ݽ픙଼뿛霷煘踅ჴ㽭삩ྋ穚ꤤꑼ爒逞ắ濜珨訁遥텂᭨ᰒ淺唷ꓷ붹堷㒍콭⬩羻彴ꥫ累뭍㬈仙䊧ざ얪쩿崁鍐セՄ乫걽뮗砓蘄ಝ懋駇餝鞲㹃섓㲺鏢ꡬ崄ធ画詽䲵䊜혘䉱僃ﳳ១?⁀夀旻㜫贐颟♳ⴷ萇欓뫗艗怾ᴬ꤈식쨁ጂያ耭?䠘﫲䆀퉡霻뉻놌㌌꞉躼ึ♹㋚ꏽݴ鳓꼲果ꉬ匝谮⢯搋䉮࿿ᇴ胪楧?란㸆슳㿆ᭊ蕁䎺헾揰陬뱓齑ﬠꆅ츗鬹ᳫ销鮞㹻㔼̈́瞑枿鸰퉉殚ﱷɺ칦ꚦﷇM筼떞햘轸ᨿ쌸谺葜ꊙ嚒偁⚐ᰢ珏숞珿彪⬃旍餠?稷䯡틨ဲ轧潅ὢꃼᐸ袬왥煌魴冠녦穄獋∏벭ꫳ뛒꺸↘痞ꕿᝈ⨕琩╿⡭?ૢ픬銗郑䂉᫰㫘熇맃㚐?퓄뗘痑∦ᲊ禺躰N䌟借詡팰?稨ⵍ橑擄孼ꋠ㍯ꀐﭨ넿䥪즨繲鴂䭯罴¢耬ᐟ鴛㈂㪆➡隇滄뷢猿忽鶼鬾袺湱ʂ?උഖ㱺迹䱐ኾ㉸?䩚塂睍云꡸⦛⏕ﻑ겣힙풡ᮌ녥ɪ༹蕸ガꑓ뵹臐숡醇副璲㧛ࣅ爭꒩㑓⽥使愚球뛺먋堎愙酯䪇誾爯祯쳥䦣ꉒ㽞㪂ꛫ僙薱᱗盝ʯ춝含팿度፜　쁤嗤੬걡屔悘詬첮礕✪魋悽廼྅㇡䴳琈Թ䄰ꭞ뱞マ肢⮭魃연屢퟼䕄?ꗾ鄄먣朗茎싡鑿→ꮸ養웹胭䇋凙谂茦鼷豇垾媽?놴ｈᶨ꭬퉄剤銊?滐牝㠋䝿?喋㏗≂轨斺苾調쑇↓أȲ項쑧䔱슅腚冖᪗둨쪌፿钛꫸⿁䩨ú퍣請ৎ굖㜚趯센韗괪淤孠짒Տ喌똆붡䰷汛鰳閙쵅⩱㯝ﯻ꠼효ῒ兣쳇啧⇾黎컹꺜벋迋ꚳ녣❆ꈚ絰䗇幏ￊ⠆泪酗鍼䋷銧拦୬Ī啇⃸㘤폴繶ﱞ蓇ೂ숒⹩夹浦ꐒ㺩ὗ뒰὏＞襂ㇳ吢俵ꌥ粦䚗뻁圆足灓獥ᠺ蓁잙茝㶸햒磅Θ퉏쐨??闣ꋅ䎺髶ေ猦⡏꽠矚઴꘮Ꞃݿꎨ죖驑봢גּ蝣ᰨퟏ奅嚾뫨깸稊ⴒ₠렛ﳩ?唯푉觀ʅ?瓘淊쮮呄簮嫨汛귰仡㭤⿉ㄩ㨅뺆鰥鬋藽塥せ᳾䝯轶뽅Ⴎ噞烧싊춥잼紕穽쁶❏㖶怛ᓏ㜀㌝룏⇧䩧ᦞ應♀빞酯埛䈊騵먔㠽첎漅?蘼翂隳Ἔ㲭붴忢?圷̯ㆲ䰉鱄麆匑赨臓暇蚀꨾붿祧芫쯆?㬻ꉬ໣꽧腋㻎羿鲴茛ഊ術謈떒鈲쪑䡺郮蒘뉿倔掼뮧➚鳊굾ᝢ泆碥熰泓ﾲ⊸ק鬘㮹䦼䮃㶹槞኱ᯫ봧閭屬쉂࿏?⬂ꏁ弻⩪軡罍錖歘빾㠞먆ﾃ婩䆟ꇓ뛡ㅼ㞀ఘ⿬मኌ먢㭊?䛓㝥뤃壸惮ꔂ鯜첞缙䠮湙귫㠭顿禽敷ﲒ钽ힽ稜둕蝬⡵북酳憜윙냤ቃᄷ㠮㆛╒?ꎒ⹱盐뭬⾠ᣤ?ꑁ댺䏉⾚풾蘋빡▶̠⾬ༀ뮰땀螤ᄒﷶᡬ岇짮댰ꍢꜨ粈鮦▵썬纽맃₝ࢵ薐泹鯟梥?ŝ陨ƽ옂ဠ뮳䦩ꤤ闖䟯Ｃ䪌疇䑥夿싾楆頻䠋ﳛ弡픯楮൲൓呂ꌈ벖垄䯑넶猹?ᡁꣴꦨꢞ겕胗?׉﹂ꦹ缲맱曭ꦩ㗬૧䎈飁鷼앑⭇僥貢쁱軽蝼煆掎踰⊾ၒ﷿䀛瓗멺ꨚざ钤뼛⇟?䑭⠯᏶屯梶ᚴ㗾נ㯿棍怶醧쬹鍃ợź鉹⸡享茠崱ɕ䝦㉴悩?堰?㌵䓘ؑྉ㻹ᛷ샐ꐶ鼸ŵ玑߷밌縴甐ꅌឱ젿?爛퉊氤⸫顷띕絶要쵀⧐㟕ⴌ垹볂襔喝㟗̖ꖃ鍿슿ꀣ郜몆뒜䌟᪖椥ꮈ晕랗橳褸탸䟕섬6넻欍?쁀♶ኟ섑ひ뼸蟹琙?ꭇ嚮죤진䔻楒됙磇嬵㻔愼뵾魸졊飝굾ᣂ䎸힚캡튞蘭ᵭ⸰砙䲇ѻ䭝᜛倘체ἁ䒦㧀㙭钙ꅃ⬻?䏤㷻驀ਨ厛ජ鋡沵ݏᑋ暞횚㇤첧?䍈૫ఇⅠꊉ౾룫뚡硫믎ü웶貝ᡂ埨瀳儝휿堣삐㽎ⴍᚷ瞢걸괱?ﾗ羙䫌倷Ｒ緜곊逪㌫碭竱葓茽㖥倊䏱❓㰦ཌ鄭壬ﲷ?瀲䄜ຣ斦㍢딯ꔝ鯎杏눒鿦㩮筱연胋뤇ꢜ쩿閳騹ড姴㘼䌌輖쿛఼㙶球﨤莙筽ఌ馮㑕ﵟ쮶㚧謋?輜؍홽椧೤膧윈论ꛚ侰㼼噻噸೯䟌梖乱晼ᚭ贕ⳙ蔞ﾽ꽱ⷙ븯끅盳渭盌襆?ꆍݤᷥȪ̓琰ਰ䧄헸镡ꆀ䱫飷㔋予儁坽鶲⚘訰㌙䣜쓾蠿鎜咁씕쿑邨ꑖ蒦鸪훽юᇿ츕贂ꔌ严㸼㥶힦誵࿪陦?텣熈ᒨ꺵吅큜瞮ꈆ₦澼⦔儽ṇᭇ④ᷭ㢀锼鈝仸顲傘椨踵糩⹖ﯱ펵䨽蹤䔠ꠝἂ隐❴?⌎Ⓧ퓡손냤溓䝹鰧芜ᷦ趲聪?鵰⫆⼛Ꮙ夀━句眐限熢ꁱ뽈缆℗ṙ鏇쑷貑佮븭捱⮯፴♶꿂̿靯쀧Ꙋ芺啥띞⸶ч솜傣ẪԦ勉貪鬘옉竻ᕍ꾀晡烢Ɡ?Ⱪ?쿬푑櫐釈験㠅?鿎㙮髤뗭䷃㜑示㶓供법ࢺ沌ԩ?屾妸諎ݮ년険ᨕ糎耲?⁄뿞萝甪∋㏹ɔ乑閰聠捗픤ٲ媠㻽鞺髹蘞Řℾ䈍᫳桟䮞ᘫ乱吅낆Ꝡ뻋̏轗?퓠쩼碖륪趽맧ੳﰒꎌ䪅追쁨䎥㭶㎚䀬䱪☐ড䐮珷豳퓕ￊ䢷ﹹ鱾咠멸蚷髌ꂯ됌䦰䕌ņ㭯耢꤃⼐悥鹍㮷蔇₷?ԹꝈ䠬ⷞﺩ쎰?괈놀쟄갧M柉吡뉟싎?㭧텦坍훊๡䪮뿇拾㦙ᨤㄈ휩敨⻤봂〬ᐨᨽ촼놨⁡ﰸ藷䦑繼䞯ܯ?뮹椆℃蹇愈૗඼渚蚒撙鈺捸ͨ⍀，࿾?㧩闗≐껬ꣻ慀荇䆟?䄦肮푀﨏ﱴ퉼㢌渴ﰂﳭ铥㡩ꋂ䁙娥䢲ᕃ煅浅ⱹ䢗⿰伎鉾?갱귳똷‧Ɯ땈ఝ혝潉౴ấ?Ꝩ飚驗዁姒䎎塎햘⏪쇦㺈끗㺀훹榎?ბꂭٹ꛳픷斨≨쪈櫁邁ꡝ៟ੴᅛ햂㈋晤்鼇ꄻ櫐㬞六뷥坄밸管쁣䐂등ꭈឺ집賬ᑑ첂ቪ柦Ԑｨᖅ㭌ᣇ፼櫼팾堰ꢄ쳙휻肢烙昨㙮㏜䝱㦨曍釾␧쀧⻌俽혐䖉㉶㬳Ὠ偕?㐵탍⍇价샹履ⅵ㞽蛆췹Ԉ?丏癱䗂蠨蕐⾚邖ꋩ荫ꌵ蒔睦॥㊞녓駲䐖윊⾛㈞鉲풮⎨禍礻෮궀Ꝺ??ᨥ᳙ੂϛ㤥殺┩⤧鯜༦យ㵮㱓쬆⢯巁뵼ᔮ䈍휽܀㙤ߙ㐒氙ᢿ몰椥싴㷼嵋㲘韢曕黹毤草踉屙鏓㭶䕦쀉ꉈ௨ᳪ얏䣶䮬鴇灧쳼᳒搽测宪腘ἤ섒ᦽ⠻夲뒩\u0016╬㩭鰑䆳ꔨ髅ꖒ?膞긏樂訦璻ǀ阤篗䄋ꩶｕስ鄭?哾흘䎉汌⭨ऐꇴ玝줭ʣ᥊＜嶬먯鮍糏㩽鉃ᅷ뀋醬舳ో마뼺슽푧탰翺镩⸄㭈胳Ⱜ?蜞㈂췋ӟⲏ쐲춠캻窼松ፋ0㽑﫠࿰ỹᾨ?ꊻ컖鶋趓觥੔㯧䅩⌡훩䯥Ốག䵙Ⲃ鴕巪힐龦奉盒➹໱ᛤ拉⛗댢횝ʧ괜?る殷㤢땒箣纼돷띱拸⤭뉟㷣⦠㮌鶉惼服㚱뢴噸玒社腽洝嵅ﭗ뤜בּ߀䆉얹ށ륤楲쐽ₖ볅ꝙꢡ䖇퐫䜒?薸᧲ከ싉?竿赘絍᲍䔆ﰄﰠℷي닰腞რሐ熍몽췾쳀ຘ鋮᠊杼稦掼ସ칎갗툝痏봶혴鶡褒㱷㣬ぷ뤅澳梇ጚṞ䂪厐댰?꠭櫕헶ು騈狋⪾걂ᙩ駽?公栓꿲剁뛫ꐇ﷒氋ᗝ쬡猽ᡬ뼯嫋委迳Ꮇぅ௑帨雾詡堑⊿쯉Ⅻ怣?ﶩ᪕ᄭ㞯㟼㱧Ｊᶅ톴혠㟟㠣쯨ᾢ怄菜휿ꎌ蘞삫⍋놇㧾䟡黵ȩܪ墣줦嗤х뒺勼譂纟螬睉裭㝊せ墦肠守륮㓣ڟ떙?䩪㔳毅㖏獺ᒊ諐傝嵊鷔ⴾ딾隣㛮⦑墠⧗㣆ಘ䵷⁤ఊ썃諀棫较ꏜ—哆⨎冚籦ﭓ㍆䩶뵐ᳩ쁹㑾⪚綴恤姎⎠ᚬ㌆處彙?䥼妡곯茘鯅援꿏ᩱ㟎⇖㤫瞨넮犡楣壚⌍੄‛괄釛\u001a㢲?⏋ኑ汕筍萁洇些㉗☪譖홄纬倚쁖?扜ﯣᓷ፦哕⌥塊䦚ꁈ᧬糌ꈫᏇ⍲ꡠ呵捈㡜ꩴ셼䔊땚♽슍橸盍ꀮꈄż㛲㒖䦙䱡衵⊀츯剰讝햎赃穪삩欣榦⍈仡櫩阐ӵ⊳ᨋ몏屶貭婞Ꙟ?탵࢐繝倍⟊칧䜶䍴箊ᗯցދ뿚ꥅ戤㾢＝ꩈ쀲蚚滛䞵撲雧繙蕥籐〽嬫⼒磧㇆뺫玧ⅆﰄﰉ儉㰦펡┰꾷㳘顪ʔ㠵汤⸼Ὡࢭ㊵靟怄㜂쭎?ꀢ恻懓뜑毼総⯀鈳萴媅?轑㼚쟣㗉䙾ӕ긙你곟쟻☈筡鏏琂샼喍⸖鼎兆裰扽뼵ⵯ든爚Ꙋ䋆?ꇍ刖₶ሐ鯤ɀ뫣麉㝐㬭窫ⷜ⭗༹ᤥ?矔炏㸷暮솇壓慬홹斚뎑젶㩷奵焐만嗻뢴ମ渿訋浊豇ⳛ듀폗㤑ﰙ玬얍緅ﹱ픱䐵쪋쨹뫢팤鼵谹截喳濽ﭡ즇㨇㔡暤毿냳䃨䔇ख़ጊ毡ㅌ횱㸿釄਎鵞䟕䴸碠톜犊Ꟃꐎ쬆ﺟ悕灿峮⤡೿෫㭶㧅瓯⡒놐현붃嘢斪䘵᳉䆖胬ѭ뜞䌝೵涳튾棽谜轝ꁛꬔ䀔?緆聾㣴⎜ᾤꠓ镤裬昮࣋밐섘圯뿜ᓎ＄䖜䕕ᕣﲂ礽ඡ㎴똯ꯅ䕻ᷩ赐裸⧣ᡓ븴﫚饸ꁵ䳙?蜼課ꭡ幖쿪邜➞爚恂Მꐵ뒔⿒䆭鐃夕뻘頣벟쬞掄簖׭갥그烂ὂ儹ࢍ、蚭菬뾡͂뇇뭖묐誮棯秅ᛥ刋ࠀ䘶⑮뺭樍餙튼喴⏓迎䜽橝徧?ن䄐꫇ᵞ浌ㆶꗤ娑뙴멻㩑棛⑅䒜ɑᣣֲ露▢?﹣⺯䢙茶倡።汋ꎞ쪃퉳倛ᔲꄧ䱋唣濯㤭耬牓汸⤵ٮ쐱Ԙ嘣뇱漯㑜⒔놿ᢐ?漏鲆။맛䵳๫ㇿ錎⃮뎙ᙘ굖䜣䋀?닉弼鉵紣㔤䓴㇤쳑볌뿐搔鉓䖓埥ﾯ㭳않ᵕ냩ﻍ낎钛 牫ꓔ⏌鎜봡鏒泌쮉ꤜ?级遜♋Ð䫩ᦲ힏ﱚꅯ뱵银᧗袒龌⯎?벓姴荮쟏ܘ阻㠝ꕍ鈆뮠ֻ䟩尸Ꮙᑓ緱箢襸㋙듒蘨ﳲ돧龾䥥믩?ଝ犟ᕂἠ屪헍璪糙恮升鎾墵Ɱ䄉샥ॖ癃⸺͉県Ī扙૑䖻餋逗ᜧ⿙狯៼⽎幑鋥원坛ꣿ?佈豀餌ꤎ䫡㎩瓗ޱἐ䵻맞볈蜀훚鯣쉢轡ⱪᕱ㾮뺸옭㊁髿㎫㧹ᭆꀷ큕寪岖느ឩ厚飼赡?⡉䟂?꟱쐑ᢋ╢鎁쾝▕堟䯿컆⁖羡姯ﵷ᭍茲䇃⾄쒝ᡭ걐㱒䊵ᗳꦟ볎襮礘킧꠴聤殊﫡荰걁蔖饪⃍븦ɜᏼ?쳋㴠䨚ù䢜벽衝᪶᭫ꢹ耐㿨뿶穀簊뿔⥊甈老葲蛤횙錰ᐿ긋ワ㑠܆뒊橉梷⍆힙묯?ꊊ튳땡ꯪ튩뎎薑늖譎쭞瞨ꐋ啞⊸ᒓ䡪鵴癆鮛呂蟼炙ẉ瀍끚퐉ᑩළ堸᡻㻿鋧ﾫ㷌뭒繢횊⇅傢鿣醆갓堁崽⌗ꏔᄿ賙뺜숨叽롋ꯥ懪픆⼷⣾狅㰰滒籣뾕옪覣搃ޫﶞ퀛ネ鱟¦灶죇쾔涙ᤳ稠밇ꭲᐢ庩ᅽ꿨ﱮﷵ犴嬉忎蛲装䠖끒?ሃ䰷ヅ?梲宲ᑇ㞰닃ꠧ숹໫齿뭜⨕栲吱樼蛊捡깠藊楕븫玿케㢂䁝゠뷥琶஛モ搔풕뚡絍꜇翽咷薹缎젣䀆㴡糀㦋侬봞鹀蓆윂枆⁁᭭ᯌ隥㈯䘍ꩇ茓풂ꊀ∐祪褴觴ⲙꍜ﷯緢ㅸෘ?㑿ꡮ돠蟕捀캆﫼㴊눸蠯羒쌿벦ᥪ㈁舫怫ੲ灝豭병ᨍ㱃疈෷?曈㦢픧≔桨⿮늂䲢눺爰⹗㻵?ⴀ﮸ຉ薴綴?쏱ܯ軘䃛瓅ݏ釷㲛겶碂?턃蛫냪誎꣭ณ졺ꈇ뻫핒脟얋竑춫弿쑑쓧鍉謟룭墐瑾雷貢맳덠怣ߓ䄥뚥贡ÿ鶭ះ㱼伬踥┈⿽㵭ݞ刊쁵鑘䷏䷂빁㰨㾊ዝ舕Ჾ䔱渊낅덠뇉ո䩃씔七豶Қ䑑髽崕䆺眪뻾륪峟逿쑏罕ེ累텭嵏?겥??簈㖂ˑ퐴킴Tϩ৅Ḇ㥯酞?ꠓ荽中葴봟⼕ʅ摐⇥ｬ妑慓⸉鲱✞ⷋ褝츛睜翟声⛥恓깲쓀磥⣭◮ト肳댺瀅ﵢ璀펎焻ꟳ呰ꍈ箏鉺Რ\u000b޲鼐亀쁟쿶⧁洹휄廠赧뱢袐㙞朻ꭆ죄᱌딽㴖鑁໦鿙?暯磈ㄨ⭫튲뛈ᆥ쐏꺟펍䲂੔蒸嚲ꢐ㠺껪煮뾒쒗嚪頧ꗡ瓑ꏍ凌䅻덶턲袋퀭?圹㥙⍽썣蓇䄀Ỏ﩯ꝙꈸꃜࠅퟠ尚鴘嚄韉ϯ魏洘ᇎ姁⎁䶚ꮚ鋄蠇䧾⼉꿩ᗘ秴슳嬥⟚攓⍋疫䁭饩娰䝒〿믷雪擗癸恢鮾袕깩斀껾纚퐽뼘覆๚㣈息僅在ఫ뮐㽨䁷菻⧟ﶓ䲅兮팲茤憟焃鐅ｻ灛慁큱턳㴒艉삊฀䡺겋쎟園坃消뺑둺▱馿뿒㜨?⸑謧쎂絤樽拘숖촾쥍韌藴⅊䨂幍ঽ∉楎藴梄ﮊ蜛䣿䋯湽槖ﳄ鑸흲ꓴ᧰Ӳ婌즐缹沺沟비‧ꕜ鵎䚐﹈廍獱薸㬨⥰㕔୉렟ᣲ詔拑ꡭ橓꯷隺嫋舸Ếﲃ퓴ꊁ䗲鑡股앛⓭惹諣鶱﹆⊍揷ြŠ걵뀯졘㦏솻ᬣ㝆べ?熄⻫䊛璳交剖껆ꮠ쇜쌹膳좲얶ꡨ⃑ụ司⨩慤?냩ꓪ⪧吝矜ㅦᑂ⣩磦ꂳ孮➲昚ͺ늟Ἣ䔛흓᫲诬ᢜ鱳㯉㹇鑗᥊㬟垷䀈ꏫ䇉?Ƹ?ᮏⱴ蛟荖Ⲹ痵囆胓䃛嗆ㅓ⾗Ꟶ즃ㄊ鴙弦С㾟賔搐᫶쀬䃽瘸⎆ﴉ飦仈놌鞪췵蚳ᑍ᱊뉕梲㐤ꩈᬋ웄絞≝揃䇤渚窒ქ馰䬷㺬㳀揰먲䌞쫵顎拑?腘团㚀䩬鄟帏常䥓䙗樲㕚馅⿪轜쩨ⰯΎ뮴掄?藢耨衿?Ȧ포꩐ށ뱐?⪂헎䩦팕舾≮ᇔ脵暛쭿倎᠙觲好傽八⹉ꚟ꠳㲽츒వ茫胦䩶騘삐蒂浭숱?㒣䵪ų䁻꼀ᗈ냛또၊皆Ზ鋏忉Ựຈꦅ확Խ촣仮紻鬌薡슖㍖큿ﴹ㯩䴞䳕?㫅闎黨鳳꼷芲?⢕쵭뿖⤺槉阩琵㮳걗?—侬閽﬛㈎ꖙ矧黠١⃡㝝섇ᩯᮎ䛫急絷?⮭윰鴥撸蒐폪ا͆ꂬ⨼뻞彶ʔㇾܲ茍洓勈抧ᅕⲰ붍姷졲ꒋㇻꪝퟹ㮖젌栭钙ꗄ댊⭓Ꮽ隘鼈ꐂ咷瞚챨仫띧⛐꓄原錭꟩Ḅǲﻅ玀窞儂拣읡䗆坨舦䀐ኼ譟㱓䜥쌨끷綉맑硩軚㖏㋆怸㴈墴璓缞↪账ૡ筛ﲯ齀檜ꃸ謏䧯舋뎻㏉ᕒឱ?㕦憀붼鱃堶⊅㘭烶ি앏⎒囕䕝琉ⱨ斁䄴䛳얨㾯♀骙濵ุ갖禒덠旨刖맯ކ齯⁧歴ﴽ氩泻ꑱ睹셞뼔ʐ댥鿓佛῭ᮉ⮔恪꾍२ɦ磲蟇ᘋ毊醍ꗀ䘻摿ꊦ쳝⎗䗩곈?譖룽̵뉸ꎠ≀腒ꦩ׬鵰丏鬒률퍈⷏褃텄㻞뜡䩿ᱳ鮋钁ృⷣ၃砃ం熻쒲᤮?᠓외㱇吤똊穩䕓献ꂶ앬ﵩ앯辩敱ﭷ∀?䢸̲렃ꁚ쑾£栁?폶씋旿乀㙻箸ᰒ´檢䝚꼤첄璯⡡沈탕鸼卺?嵿풇ꕅ腚ᄫ輄ꉉ꒑緒㰣⫽ꢥ쑟俒꽃잵䭏⭌珞⛩佀᝿迸틝ȋ㒪榒䪙練腗䪟ꅇ⨜鯖쟢ஜ혣쯢쓗饍洞촬再辫儵⫞뿨ᮣล졪볎㲤扸搚껎ꦫ?팢錋?闐섟滽䔋祢圗濬句੽욀ꂑᗌ궵㈲汯─ꣶꭦ䝈瓧뚛䨍음睬䦐ᰁ挼杇㌗䓀穂獡沲䳡䊷㽦ꗫ㒜ᚩᯊ㉇䴏戏쩮뎒㌲ꢾ䷰苟㛕ဥ溞씩ㅍ腴깃鰁䄳㔱㿰䄃鋁蚜镔뤚騴Յ읷ᢱ瀋퓮ખ㡮͎潶픕ꅟ㝮慽䋫할앮Ꚛ妻ꉌ홵풲醨犈㶸絷﷑狇✼᪊뤆砆〽뛏샢싙鐎섌ᛴ咾↗?睇ఴ彳漸뫥鏩ⵒ࠾茭묎웷䧺혝㚸팬ॺ钞솳粇욺?ດ뿤풹ⶌꢌע괷ꀡ鄅翓ᰜ瘧燻ᰆ黡?妎䌺덌蓔⅔ৃ浳ﾰ?셦ⅎ䊪㨑먳ꪇ賋呪叛눟哄⺬撖淮퓕㯜叨尮쾳雄碮䪫㠱ᡩ褆⋲䢗毫瑠뭎灹⛸떠挳嫩௱ֶ苭夞믮횸唊蒋⨏㰨ꄓ篻铁⧬叉毽듵ᆳ⟂f㘗詏䏘趛Ѻ讲❷₠䁙ዡι᦬荼竚︂돖횽ꋈ옌함猜䟴迓笹족ꅡҝ굍늱㈂ઋ鬜ဤ鑝ﴮȺⱱ❠쁠铴㽛ྼ썶믛칤옙譝岶甘䌻꿻㯯慛?얹䴿쿇飄⎈ᦧ梀劚ܫ㖬篔緁汄遘趯䃩曭쵾怿뼳깧謹䅣軾㦵馚⏲∆됛쒄૙일࿤뵼춅ꎡ鐛ᦕ몵酭뫌譭ꔿꙓ檐錋⌳뾎䉓꣢栮윫뫨ⴀ㍟ԯ숂땫ǁ떆撑ꥯ珤뫽쳌뒛싾鯢ౡᲇ偏儣낉锚ꃢꜙ鹫囌誧ࠨ긯渋퉄䔞ﾘ血椮ⱞᬯꟂ㙤텙ᕥై㼒אּ㑢톷ꗩ⬽뺡ㅱ訩忀錄蘣೮玴ᅌ䘷씫槴뒝꾅붅ꤟ꾚ᥓໞ８罹┦嘯艺陂ὧꝲᖎ뜦鶙癡礕輿璏Łﮞݟꇼ豾횅〇䳀ᦨಯࡠ빥탮齹੺暇⿽⫇ᤫ庡雠凃豳릤Ꮮ?⹟㺽贼㲞ﱈ☮ᚘ㉿僉끤৬䣵㷹鐕ꝺ촃슈플肕呓閖숔Ⲏ튵뚵ꮬ膓皡젪蒑濲஢㥮涙훷쵳ʔ㔍钽꾂棘㭷囮?렩萘톝Ⳁ̶릓㤪ﳤ꼿娬㈛┨⛟╾퐫톄?峑?㖹쾇竻ḩ⩷搡둤豺橕멩叮魌䯗Ꮘꁑ咝砖뀆䜯?࿑礖霤❘㘵烉⣊腪骊ꏍ썪ꢏ裥抴㶚帓鹗崟ዅ烷荡䌦ﲫ뺂ꁑ鬭웘廉昈ꕅꤷ釱瓝︩Ĩ捞뜦ꍬ簤满堒춖䧘嶺⛬荨Ⰰ넋橍ᾟ沈댘㺋髻⾈?ꖰ딏윯뒏狓趐鬤適⇋垃V鍗攷쁼糡偩踮唧៹?⥘䝺쫿᡿᳅븈泴뢐尤䈼춁㘳ᦝ胯ᢛ혥憵滒ѭ࣬꽌ꏌ䯎틗⽘贅钤ᒛ貎?▔௴翘⢊媕蒞啺曳ꊢ᨝忠⠅쥙Ⓩ溒鼉꛳륕힦꽏꟩혬莯琯䒞뢲臵㮘䞿ꃚ쏩拶Ş䤫＃왱먟䎭냃ꌂⳐ㻣㇡謴ꋜ둊舟ꤔ긚죝䶾铔㗜⑫깱ᠡ龺ꬊ칔捑ￌ䋈飝늸볹厂㫗\u0003媬엙쵮詞ǆ嚺襊橉⌘쑷檠랡䙬ﬥ遇踱ڏ瞇ᠿ輫གྷ潘쭙쨉圝䬊簙顂ꐉ獵预暹忙냶㷲왂릻옉哞驪욐뢻뛯緯떓镀ꛆ莖ꠕ굼꩐ݞ靆?ࠑ㝏⣃࢓얹甞ᣎ趓茤뇾햨㥥쒡崎걏ⷣ㕅娽௏啐⻴묑ퟕ囍ຳ㡡윢馜븍釚씇輁蹱礮㗨⒡㍴춸摨戍쩀ඎ挫欶蓠Ⱋ?㛇衍?俠㽳㵱?㾥钘㍢⩕匭뀒⻠旨䩪렊谾眦酣⠫쮶捕ᦑ卡ꤱ獷ꢕㄽ㜊䵢㵨䢌园㒰僱᥆?஠乤뙘摩ϋ켛ᒉ溔㍬受㼞텴큄튼?⟦醳吜뤱䏀쿙㘞府덊脃?團䕊᮵䕟翠걌頣ㅣ㣪갠?톮叆欻濖裉㱫⛨㼨畹厭芳ö埾⇘Ꮐ⾸谘즠ꇛ蝸꺦슸윙⾑仫눩ⲕ㱝钮ㇼ哞嚡㸥翧曷既댣ꌇ뺰輝遦諞选᮷编䉙?唋ᰎ䄫﹟憹畿鹷帿铻诬儡ﯳ癹襙藮㠈ﷺ뉿譨噁䑠懲䕴싆砱쥖䠗檈孆ᩩ샇ꇺ厲뜸믕陦蝙珅뮍篵䠁ꤊ퉋⚐봶唼䲟༉ܒᶜỲ჉囐珞嗔쟫ཧബ뿐ꨘ﷊앒ꕰ鰧叨꺉넅횕ⲿ棌澗₤?捚ꦛ띢⵫쟻섿?坟ⷶ毪叱뼬馜熙禞ꈽ楖닳漇兵茢꽜᝘惲⏖鷊瑯齄➍쭟쩗벖粛呅ꂟ␘뿭⮊扑⾨罰㩉熹㔱䖗빧䦧僤柷ｰ왅攙￨Ἶ訰帮㯁ꠦ댿郫➚戅絈艁ѭ畇⎄倳搷㽶鱥ȍ愤䵫鋀㨾๜ପ搶ો䦚倷ןヹ袎㬃⁠넂᝝⥖䘂螞踤⃨䂄僫▝㣜ꨗ䂂⮪딨⾓㶏꿗粳넒앵릙㟧釀⍤Ổ玲嫞쵾澮㈜鶀髲ᐜ嶒䒻榶韚?拹弩㛚蟊ᥞ긷锬豕巴ঝ釬協လꞌ倌ⷶ밨ꈆ榌銟⤧ᡂ畦伦萗䮸ꊄ쫚ꋗḑ؂⬄Ṋﲄỏᢉ礅韗ᑝᜩ䛉뾢艽⹏埱卭ꘟ㕷৻姛瀖㳁㟦ࣂꚞด୕⎰ꨃ࿁?剐쿉ㆦ脎เ峞??縇㜒ゲ࢏ꊵ龌?Ꙁ댋ᣎ嵙﯊⸇䲏鏑楑쾀栀蘢欠癩䨋ऩ舗誏漒⮡ꊮ۷Ấ⒚갺૫鲢捬㨟펒큁嫧橌ﵸ圻뵪䵘먴؜䞜韮娵衁づ둁䱸骏짪ᚬ썿砶埘?죣?锠ꞅٯ뿻ℑ륉첎ⁱ≭뉫ἠﲍ糀屐꺣嬁矜ⶂ෷ꥎṰ漖軹მ憡ᇡ諏Č᭔ꋔƧ鯍ᎇ똟膸捀ⱺ㒁ퟖ鼊룏⨓?⪶⌱睨﫛ꖈ表陈俓ᴬ嘩骇Ӕ唙䲒䮜峟춡޳莏㲙ⱞℑᏻちꊡ礄咍쟌ﻏ活峇檶︔耇髚৿霝ᔌ쳢溧?索ⱝⅿ።磳ۦ菮⃦ఴ筝⇚꺶먓ﭵﲨᏩ퉾⹊찺煟渓?ĭ㎊爇Ồ솛釦ﴺ᫴뎙厲뤋䙼빌紲踗愝ꍊ൝࡫橳﹂쮑뱱较ၹꆈ⣲Ā﹫驖뀓㔴?孏ﰳꯋ唆㽼￝롒儙㎤뛳婀䩪㮷㠏Ħ?믒ཋ㰨⽳浯䯘ㆊ䀛龜硬꒡宧詫㿼㠻꫆䃭㥯ⶭ뻟䊵ꊂ叶譫▤礬ꞹӦ権畅폛ꍗ쾰牆聱몭⏙ᘆ琁扻伾䗡ꯙ㳔䁗?蛠힏뮐鑡쐷?䢘㧓⒰ⶕਕ牶ᔄ쮎꽻垰⛆ꙿ汿阅搢艦윚櫽첂Ғꢬꊞ?縊愁鵔᪻쨶ፊ썵徫틷먤ꀩ?瘰덩磑岌첦予ꖾᘨ譏넁泉പ擃ౕ骃醴悡糽揁尤꽘䡦?丵셗遗䈓퀁㩘ᰌ䔫嵲ﰺȸᰟ꭬ࠌ駙鲟올賘쑖㙤⎏ໄ⹅立?懧ॲ㍿쓵ࡖ᷑ᾋ䘡⍤Ⅿ◟킓揪쐧?흫鍾龢⻉㾷鹗ை鵡簴஦냁珚㯱鳋䅕갅ж䟖ζᒷ寲㹎璬屻歵ᢔ㆏肋?⯂畸?籹ኪ쟳騋璊꼙贓떞另ᣢ鷝쭍鍃㢮℧႟얕ᦄ눾臇炨ﱞ腁姝꤅塮챃").toCharArray();
        byte[] bArr = new byte[(charArray.length * 2)];
        for (int i = 0; i < charArray.length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) (charArray[i] & 255);
            bArr[i2 + 1] = (byte) ((charArray[i] & 65280) >> 8);
        }
        A = bArr;
    }

    private static void Bo(String str, InputStream inputStream, OutputStream outputStream) throws Exception {
        char[] charArray = str.toCharArray();
        int[] iArr = {charArray[0] | (charArray[1] << 16), charArray[2] | (charArray[3] << 16), charArray[4] | (charArray[5] << 16), charArray[6] | (charArray[7] << 16)};
        int[] iArr2 = {charArray[8] | (charArray[9] << 16), (charArray[11] << 16) | charArray[10]};
        int[] hfEmIi = hfEmIi(iArr);
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                int i2 = i + read;
                int i3 = 0;
                while (i < i2) {
                    int i4 = i % 8;
                    int i5 = i4 / 4;
                    int i6 = i % 4;
                    if (i4 == 0) {
                        bHcCc(hfEmIi, iArr2);
                    }
                    bArr[i3] = (byte) (((byte) (iArr2[i5] >> (i6 * 8))) ^ bArr[i3]);
                    i++;
                    i3++;
                }
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static final String Cewzfu(String str) {
        char[] cArr;
        int i;
        int i2;
        int i3;
        if (kqfg == null) {
            uypvAioszm18273();
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int hashCode = (stackTrace[((Integer) kqfg[7]).intValue()].getClassName() + stackTrace[((Integer) kqfg[7]).intValue()].getMethodName()).hashCode();
        Object[] objArr = kqfg;
        int[] iArr = (int[]) objArr[6];
        char c = 0;
        int i4 = iArr[0] ^ hashCode;
        char c2 = 1;
        int i5 = iArr[1] ^ hashCode;
        char c3 = 2;
        int i6 = iArr[2] ^ hashCode;
        int i7 = hashCode ^ iArr[3];
        int[] iArr2 = (int[]) objArr[5];
        int[] iArr3 = (int[]) objArr[1];
        int[] iArr4 = (int[]) objArr[2];
        int[] iArr5 = (int[]) objArr[3];
        int[] iArr6 = (int[]) objArr[4];
        byte[] bArr = (byte[]) objArr[0];
        char[] charArray = str.toCharArray();
        for (boolean z = false; !z; z = true) {
            try {
                int length = charArray.length;
                int i8 = 0;
                while (i8 < length) {
                    try {
                        if (i8 % 8 == 0) {
                            int i9 = i4 ^ iArr2[c];
                            int i10 = i5 ^ iArr2[c2];
                            try {
                                int i11 = i9;
                                int i12 = i10;
                                int i13 = i6 ^ iArr2[c3];
                                int i14 = i7 ^ iArr2[3];
                                int i15 = 4;
                                while (i15 < 36) {
                                    try {
                                        i2 = i6;
                                    } catch (Exception unused) {
                                        i7 = i7;
                                        i4 = i4;
                                        i5 = i5;
                                        c = 0;
                                        c2 = 1;
                                        c3 = 2;
                                    }
                                    try {
                                        int i16 = (((iArr3[i11 & 255] ^ iArr4[(i12 >> 8) & 255]) ^ iArr5[(i13 >> 16) & 255]) ^ iArr6[i14 >>> 24]) ^ iArr2[i15];
                                        int i17 = (((iArr3[i12 & 255] ^ iArr4[(i13 >> 8) & 255]) ^ iArr5[(i14 >> 16) & 255]) ^ iArr6[i11 >>> 24]) ^ iArr2[i15 + 1];
                                        cArr = charArray;
                                        try {
                                            int i18 = (((iArr3[i13 & 255] ^ iArr4[(i14 >> 8) & 255]) ^ iArr5[(i11 >> 16) & 255]) ^ iArr6[i12 >>> 24]) ^ iArr2[i15 + 2];
                                            int i19 = (((iArr3[i14 & 255] ^ iArr4[(i11 >> 8) & 255]) ^ iArr5[(i12 >> 16) & 255]) ^ iArr6[i13 >>> 24]) ^ iArr2[i15 + 3];
                                            int i20 = i15 + 4;
                                            i11 = (((iArr3[i16 & 255] ^ iArr4[(i17 >> 8) & 255]) ^ iArr5[(i18 >> 16) & 255]) ^ iArr6[i19 >>> 24]) ^ iArr2[i20];
                                            i12 = (((iArr3[i17 & 255] ^ iArr4[(i18 >> 8) & 255]) ^ iArr5[(i19 >> 16) & 255]) ^ iArr6[i16 >>> 24]) ^ iArr2[i20 + 1];
                                            i13 = (((iArr3[i18 & 255] ^ iArr4[(i19 >> 8) & 255]) ^ iArr5[(i16 >> 16) & 255]) ^ iArr6[i17 >>> 24]) ^ iArr2[i20 + 2];
                                            i14 = (((iArr3[i19 & 255] ^ iArr4[(i16 >> 8) & 255]) ^ iArr5[(i17 >> 16) & 255]) ^ iArr6[i18 >>> 24]) ^ iArr2[i20 + 3];
                                            i15 = i20 + 4;
                                            i6 = i2;
                                            length = length;
                                            charArray = cArr;
                                        } catch (Exception unused2) {
                                            i7 = i7;
                                            i4 = i4;
                                            i5 = i5;
                                            i6 = i2;
                                            charArray = cArr;
                                            c = 0;
                                            c2 = 1;
                                            c3 = 2;
                                        }
                                    } catch (Exception unused3) {
                                        i7 = i7;
                                        i4 = i4;
                                        i5 = i5;
                                        i6 = i2;
                                        c = 0;
                                        c2 = 1;
                                        c3 = 2;
                                    }
                                }
                                i2 = i6;
                                i = length;
                                cArr = charArray;
                                int i21 = (((iArr3[i11 & 255] ^ iArr4[(i12 >> 8) & 255]) ^ iArr5[(i13 >> 16) & 255]) ^ iArr6[i14 >>> 24]) ^ iArr2[i15];
                                int i22 = (((iArr3[i12 & 255] ^ iArr4[(i13 >> 8) & 255]) ^ iArr5[(i14 >> 16) & 255]) ^ iArr6[i11 >>> 24]) ^ iArr2[i15 + 1];
                                int i23 = (((iArr3[i13 & 255] ^ iArr4[(i14 >> 8) & 255]) ^ iArr5[(i11 >> 16) & 255]) ^ iArr6[i12 >>> 24]) ^ iArr2[i15 + 2];
                                int i24 = (((iArr3[i14 & 255] ^ iArr4[(i11 >> 8) & 255]) ^ iArr5[(i12 >> 16) & 255]) ^ iArr6[i13 >>> 24]) ^ iArr2[i15 + 3];
                                int i25 = i15 + 4;
                                int i26 = ((((bArr[i21 & 255] & 255) ^ ((bArr[(i22 >> 8) & 255] & 255) << 8)) ^ ((bArr[(i23 >> 16) & 255] & 255) << 16)) ^ (bArr[i24 >>> 24] << Ascii.CAN)) ^ iArr2[i25 + 0];
                                try {
                                    i3 = ((((bArr[i22 & 255] & 255) ^ ((bArr[(i23 >> 8) & 255] & 255) << 8)) ^ ((bArr[(i24 >> 16) & 255] & 255) << 16)) ^ (bArr[i21 >>> 24] << Ascii.CAN)) ^ iArr2[i25 + 1];
                                } catch (Exception unused4) {
                                    i7 = i7;
                                    i4 = i26;
                                    i5 = i5;
                                    i6 = i2;
                                    charArray = cArr;
                                    c = 0;
                                    c2 = 1;
                                    c3 = 2;
                                }
                                try {
                                    int i27 = ((((bArr[i23 & 255] & 255) ^ ((bArr[(i24 >> 8) & 255] & 255) << 8)) ^ ((bArr[(i21 >> 16) & 255] & 255) << 16)) ^ (bArr[i22 >>> 24] << Ascii.CAN)) ^ iArr2[i25 + 2];
                                    try {
                                        i7 = ((((bArr[i24 & 255] & 255) ^ ((bArr[(i21 >> 8) & 255] & 255) << 8)) ^ ((bArr[(i22 >> 16) & 255] & 255) << 16)) ^ (bArr[i23 >>> 24] << Ascii.CAN)) ^ iArr2[i25 + 3];
                                        i4 = i26;
                                        i5 = i3;
                                        i6 = i27;
                                    } catch (Exception unused5) {
                                        i7 = i7;
                                        i4 = i26;
                                        i5 = i3;
                                        i6 = i27;
                                        charArray = cArr;
                                        c = 0;
                                        c2 = 1;
                                        c3 = 2;
                                    }
                                } catch (Exception unused6) {
                                    i7 = i7;
                                    i4 = i26;
                                    i5 = i3;
                                    i6 = i2;
                                    charArray = cArr;
                                    c = 0;
                                    c2 = 1;
                                    c3 = 2;
                                }
                            } catch (Exception unused7) {
                                c2 = 1;
                            }
                        } else {
                            i = length;
                            cArr = charArray;
                        }
                        char c4 = 0;
                        while (true) {
                            if (c4 == 0) {
                                try {
                                    switch (i8 % 8) {
                                        case 0:
                                            cArr[i8] = (char) ((i4 >> 16) ^ cArr[i8]);
                                            break;
                                        case 1:
                                            cArr[i8] = (char) (cArr[i8] ^ i4);
                                            break;
                                        case 2:
                                            cArr[i8] = (char) ((i5 >> 16) ^ cArr[i8]);
                                            break;
                                        case 3:
                                            cArr[i8] = (char) (cArr[i8] ^ i5);
                                            break;
                                        case 4:
                                            cArr[i8] = (char) ((i6 >> 16) ^ cArr[i8]);
                                            break;
                                        case 5:
                                            cArr[i8] = (char) (cArr[i8] ^ i6);
                                            break;
                                        case 6:
                                            cArr[i8] = (char) ((i7 >> 16) ^ cArr[i8]);
                                            break;
                                        case 7:
                                            cArr[i8] = (char) (cArr[i8] ^ i7);
                                            break;
                                    }
                                } catch (Exception unused8) {
                                    c4 = 3;
                                }
                            }
                        }
                        i8++;
                        length = i;
                        charArray = cArr;
                        c = 0;
                        c2 = 1;
                        c3 = 2;
                    } catch (Exception unused9) {
                        c2 = 1;
                    }
                }
                return new String(charArray);
            } catch (Exception unused10) {
                c2 = 1;
            }
        }
        return new String(charArray);
    }

    public static native void DGDHFIyv();

    private static native InputStream IhEiw(String str);

    private static void bHcCc(int[] iArr, int[] iArr2) {
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i3 = (((i2 << 24) | (i2 >>> 8)) + i) ^ iArr[0];
        int i4 = ((i >>> 29) | (i << 3)) ^ i3;
        int i5 = (((i3 << 24) | (i3 >>> 8)) + i4) ^ iArr[1];
        int i6 = ((i4 >>> 29) | (i4 << 3)) ^ i5;
        int i7 = (((i5 << 24) | (i5 >>> 8)) + i6) ^ iArr[2];
        int i8 = ((i6 >>> 29) | (i6 << 3)) ^ i7;
        int i9 = (((i7 << 24) | (i7 >>> 8)) + i8) ^ iArr[3];
        int i10 = ((i8 >>> 29) | (i8 << 3)) ^ i9;
        int i11 = (((i9 << 24) | (i9 >>> 8)) + i10) ^ iArr[4];
        int i12 = ((i10 >>> 29) | (i10 << 3)) ^ i11;
        int i13 = (((i11 << 24) | (i11 >>> 8)) + i12) ^ iArr[5];
        int i14 = ((i12 >>> 29) | (i12 << 3)) ^ i13;
        int i15 = (((i13 << 24) | (i13 >>> 8)) + i14) ^ iArr[6];
        int i16 = ((i14 >>> 29) | (i14 << 3)) ^ i15;
        int i17 = (((i15 << 24) | (i15 >>> 8)) + i16) ^ iArr[7];
        int i18 = ((i16 >>> 29) | (i16 << 3)) ^ i17;
        int i19 = (((i17 << 24) | (i17 >>> 8)) + i18) ^ iArr[8];
        int i20 = ((i18 >>> 29) | (i18 << 3)) ^ i19;
        int i21 = (((i19 << 24) | (i19 >>> 8)) + i20) ^ iArr[9];
        int i22 = ((i20 >>> 29) | (i20 << 3)) ^ i21;
        int i23 = (((i21 << 24) | (i21 >>> 8)) + i22) ^ iArr[10];
        int i24 = ((i22 >>> 29) | (i22 << 3)) ^ i23;
        int i25 = (((i23 << 24) | (i23 >>> 8)) + i24) ^ iArr[11];
        int i26 = ((i24 >>> 29) | (i24 << 3)) ^ i25;
        int i27 = (((i25 << 24) | (i25 >>> 8)) + i26) ^ iArr[12];
        int i28 = ((i26 >>> 29) | (i26 << 3)) ^ i27;
        int i29 = (((i27 << 24) | (i27 >>> 8)) + i28) ^ iArr[13];
        int i30 = ((i28 >>> 29) | (i28 << 3)) ^ i29;
        int i31 = (((i29 << 24) | (i29 >>> 8)) + i30) ^ iArr[14];
        int i32 = ((i30 >>> 29) | (i30 << 3)) ^ i31;
        int i33 = (((i31 << 24) | (i31 >>> 8)) + i32) ^ iArr[15];
        int i34 = ((i32 >>> 29) | (i32 << 3)) ^ i33;
        int i35 = (((i33 << 24) | (i33 >>> 8)) + i34) ^ iArr[16];
        int i36 = ((i34 >>> 29) | (i34 << 3)) ^ i35;
        int i37 = (((i35 << 24) | (i35 >>> 8)) + i36) ^ iArr[17];
        int i38 = ((i36 >>> 29) | (i36 << 3)) ^ i37;
        int i39 = (((i37 << 24) | (i37 >>> 8)) + i38) ^ iArr[18];
        int i40 = ((i38 >>> 29) | (i38 << 3)) ^ i39;
        int i41 = (((i39 << 24) | (i39 >>> 8)) + i40) ^ iArr[19];
        int i42 = ((i40 >>> 29) | (i40 << 3)) ^ i41;
        int i43 = (((i41 << 24) | (i41 >>> 8)) + i42) ^ iArr[20];
        int i44 = ((i42 >>> 29) | (i42 << 3)) ^ i43;
        int i45 = (((i43 << 24) | (i43 >>> 8)) + i44) ^ iArr[21];
        int i46 = ((i44 >>> 29) | (i44 << 3)) ^ i45;
        int i47 = (((i45 << 24) | (i45 >>> 8)) + i46) ^ iArr[22];
        int i48 = ((i46 >>> 29) | (i46 << 3)) ^ i47;
        int i49 = (((i47 << 24) | (i47 >>> 8)) + i48) ^ iArr[23];
        int i50 = ((i48 >>> 29) | (i48 << 3)) ^ i49;
        int i51 = (((i49 << 24) | (i49 >>> 8)) + i50) ^ iArr[24];
        int i52 = ((i50 >>> 29) | (i50 << 3)) ^ i51;
        int i53 = (((i51 << 24) | (i51 >>> 8)) + i52) ^ iArr[25];
        int i54 = ((i52 >>> 29) | (i52 << 3)) ^ i53;
        int i55 = iArr[26];
        int i56 = i55 ^ (((i53 << 24) | (i53 >>> 8)) + i54);
        iArr2[0] = ((i54 >>> 29) | (i54 << 3)) ^ i56;
        iArr2[1] = i56;
    }

    private static final int dndmg(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private static void evrtzj(Context context) {
        if (!l) {
            wB = context;
            SystemProperties.get(Cewzfu("煙꩘຿좙鹭꾴徉?畠冚⻭됊雊ḿɟ"), Cewzfu("焆"));
            SystemProperties.get(Cewzfu("煛ꨄຼ종鹽꾤径?甭冎⻹둈雝Ḵɝ期仮喬㣦僴?濩"), Cewzfu("焆"));
            Cewzfu("煯ꨎຟ좙鹽꾴徉?畱");
            Cewzfu("煭ꨘຨ좄鹹꾾従?産凘⺨됖隚ṭȇ會亠嗡㢳傳?澠姢頉ꓷࠫ");
            Cewzfu("焑");
            String str = Build.CPU_ABI;
            Cewzfu("焋");
            Cewzfu("焄");
            System.getProperty(Cewzfu("煁ꨀຮ좀鹤꾡徘?異冃⻷둊"), Cewzfu("焆"));
            Cewzfu("焄");
            Cewzfu("焋");
            String str2 = Build.FINGERPRINT;
            gIxgehFJ();
            Class<?> cls = Class.forName(Cewzfu("煁ꨀຮ좚鹨꾰忓?畡冀⻽둇雟"));
            Method declaredMethod = Class.forName(Cewzfu("煈ꨛ໡좀鹠꾸忓?畦冉⻭둖雂ḩɏ期仴喨㢪僾?澥妈顗꒬࠿㓜낞쿵菔㥏ஃ⶯믁ぞ罼팼ű⚌Ṯ롆튰빕䳆ꙻ鵉톁鱹ᑴ푋ㅑ")).getDeclaredMethod(Cewzfu("煑"), cls, cls, cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, wB, Cewzfu("蒧焾偷㽷⮥꟨蕂⌈䀚툞瑒﷔良"), Cewzfu("褠콞?"));
            DGDHFIyv();
            l = true;
        }
    }

    private static void gIxgehFJ() {
        File dir = ((Context) wB).getDir(Cewzfu("ꓻ?涐젨㦱"), 0);
        File file = new File(dir, Cewzfu("ꓸ?涆젨㦱૴篇嘬?旮鎤眅杫㭝응ᙗ룞햏ꠀ㜥") + Process.myPid() + Cewzfu("꒺?涋"));
        try {
            hwexsIord(file);
            System.load(file.getAbsolutePath());
        } finally {
            file.delete();
        }
    }

    private static int[] hfEmIi(int[] iArr) {
        int[] iArr2 = new int[27];
        int i = 0;
        int i2 = iArr[0];
        iArr2[0] = i2;
        int[] iArr3 = {iArr[1], iArr[2], iArr[3]};
        while (i < 26) {
            int i3 = i % 3;
            iArr3[i3] = (((iArr3[i3] >>> 8) | (iArr3[i3] << 24)) + i2) ^ i;
            i2 = ((i2 >>> 29) | (i2 << 3)) ^ iArr3[i3];
            i++;
            iArr2[i] = i2;
        }
        return iArr2;
    }

    private static final void htEClDAgA() {
        for (char c = 0; c == 0; c = 2) {
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int length = stackTrace.length;
                for (int i = 1; i < length; i++) {
                    StringBuilder sb = new StringBuilder();
                    char c2 = 0;
                    while (true) {
                        if (c2 == 0) {
                            try {
                                sb.append(stackTrace[i].getClassName());
                                sb.append(stackTrace[i].getMethodName());
                                if (sb.toString().hashCode() == 1177080783) {
                                    kqfg[7] = Integer.valueOf(i);
                                    return;
                                }
                            } catch (Exception unused) {
                                c2 = 2;
                            }
                        } else {
                            try {
                                kqfg[7] = 4;
                                if (sb.toString().hashCode() == 1177080783) {
                                    kqfg[7] = Integer.valueOf(i);
                                    return;
                                }
                            } catch (Throwable th) {
                                if (sb.toString().hashCode() == 1177080783) {
                                    kqfg[7] = Integer.valueOf(i);
                                    return;
                                }
                                throw th;
                            }
                        }
                    }
                }
                return;
            } catch (Exception unused2) {
            }
        }
        kqfg[7] = 3;
    }

    /* JADX INFO: finally extract failed */
    private static void hwexsIord(File file) throws Exception {
        String str;
        String str2;
        int tAb = tAb();
        if (tAb == 1) {
            str2 = Cewzfu("딕曠苠詅瘌ӧ❺展?戨θ餞");
            str = "큈ဟꤝ嫐徥㨥ꍓ?꧅灐ठ輿ଉ?娘拪钡";
        } else if (tAb == 2) {
            str2 = Cewzfu("譗후腃Ⱜ䄁킎웏誜㺭踷㟲");
            str = "큈ဟꤝ嫐徥㨥ꍐ?ꦝ灐४輣ଗ?婇拫钼ﱚﮔ丌";
        } else if (tAb == 3) {
            str2 = Cewzfu("?談箊䓕풏?絊䷤ꚹ");
            str = "큈ဟꤝ嫐徥㨥ꍐ?ꦒ灐४輣ଗ?婝拥钼ﱚﮔ丌";
        } else if (tAb == 4) {
            str2 = Cewzfu("鉾㻃샃僰钕䲬翙ꚛ빋㤌랸荫");
            str = "큈ဟꤝ嫉忯㩾ꍓ?꧅灐॰轵୉?娘拪钡";
        } else if (tAb == 5) {
            str2 = Cewzfu("慺鷠䃿疎阚?腤鄳ഠ⍲给");
            str = "큈ဟꤝ嫉忯㩾ꌢ?ꦞ灐४輣ଗ?婝拷钼ﱚﮔ丌";
        } else {
            throw new IllegalArgumentException();
        }
        InputStream open = ((Context) wB).getAssets().open(Cewzfu(str));
        try {
            InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(new FileOutputStream(file));
            try {
                Bo(str2, open, inflaterOutputStream);
                inflaterOutputStream.close();
            } catch (Throwable th) {
                inflaterOutputStream.close();
                throw th;
            }
        } finally {
            open.close();
        }
    }

    private static final int kDt(byte[] bArr, int i) {
        int i2 = bArr[14] << Ascii.DLE;
        char c = 0;
        char c2 = 0;
        while (c2 == 0) {
            c2 = 3;
            try {
                return (bArr[i & 255] & 255) | ((bArr[(i >> 8) & 255] & 255) << 8) | ((bArr[(i >> 16) & 255] & 255) << 16) | (bArr[(i >> 24) & 255] << Ascii.CAN);
            } catch (Exception unused) {
            }
        }
        while (c == 0) {
            c = 2;
            try {
                return bArr[i & 127] >> 8;
            } catch (Exception unused2) {
            }
        }
        return i2;
    }

    public static native int oxwCGhohtt(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native String s(String str);

    private static int tAb() {
        String str = Build.CPU_ABI;
        String str2 = SystemProperties.get(Cewzfu("꺯孯섳쫹幸裊瑳ꌚ弮狽䮞ヷﯧ訾儗⿄⸮"), "");
        String str3 = Cewzfu("꺨孮셶쫧幥裒瑹").equals(str2) ? str : str2;
        if (str3.startsWith(Cewzfu("꺼孲셰쫬幫裇瑾ꌏ彭"))) {
            return 2;
        }
        if (str3.startsWith(Cewzfu("꺼孲셰쪿帾袈瑡ꌘ"))) {
            return str3.equals(str) ? 3 : 2;
        }
        if (str3.startsWith(Cewzfu("꺼孲셰쫬幫裇瑾"))) {
            return 1;
        }
        if (str3.startsWith(Cewzfu("꺥嬸섫쫖帼袑"))) {
            return (str3.equals(str) || str.startsWith(Cewzfu("꺼孲셰쪿帾袈瑡ꌘ"))) ? 5 : 4;
        }
        if (str3.startsWith(Cewzfu("꺥嬸섫"))) {
            return 4;
        }
        throw new IllegalArgumentException(Cewzfu("꺞子셈쪳帪") + str2 + Cewzfu("껱嬠셰쫦幮裀琭") + str);
    }

    public static InputStream ujDHrrlF(Class cls, String str) {
        String str2;
        if (str == null) {
            return cls.getResourceAsStream(str);
        }
        if (str.charAt(0) == '/') {
            str2 = str.substring(1);
        } else {
            str2 = cls.getName().replace(FormatterType.defaultDecimalSeparator, '/') + '/' + str;
        }
        return IhEiw(str2);
    }

    private static final void uypvAioszm18273() {
        int i = 256;
        int[] iArr = new int[256];
        byte[] bArr = new byte[256];
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[256];
        int[] iArr4 = new int[256];
        int[] iArr5 = new int[256];
        int[] iArr6 = new int[30];
        int i2 = 1;
        for (int i3 = 0; i3 < 256; i3++) {
            iArr[i3] = i2;
            i2 ^= (i2 << 1) ^ ((i2 >>> 7) * 283);
        }
        bArr[0] = 99;
        char c = 0;
        while (true) {
            if (c != 0) {
                break;
            }
            for (int i4 = 0; i4 < 255; i4++) {
                try {
                    int i5 = iArr[255 - i4];
                    int i6 = i5 | (i5 << 8);
                    bArr[iArr[i4]] = (byte) ((i6 ^ ((((i6 >> 4) ^ (i6 >> 5)) ^ (i6 >> 6)) ^ (i6 >> 7))) ^ 99);
                } catch (Exception unused) {
                }
            }
            int i7 = 0;
            while (i7 < i) {
                int i8 = bArr[i7] & 255;
                int i9 = ((i8 >>> 7) * 283) ^ (i8 << 1);
                int i10 = (i9 ^ ((i8 << 8) ^ (((i8 ^ i9) << 24) ^ (i8 << 16)))) & -1;
                try {
                    iArr2[i7] = i10;
                    iArr3[i7] = (i10 << 8) | (i10 >>> -8);
                    iArr4[i7] = (i10 << 16) | (i10 >>> -16);
                    iArr5[i7] = (i10 >>> -24) | (i10 << 24);
                    i7++;
                    i = 256;
                } catch (Exception unused2) {
                    i = 256;
                }
            }
            int i11 = 1;
            for (int i12 = 0; i12 < 30; i12++) {
                iArr6[i12] = i11;
                i11 = ((i11 >>> 7) * 283) ^ (i11 << 1);
            }
            c = 2;
        }
        byte[] bArr2 = new byte[16];
        int i13 = 0;
        while (true) {
            if (i13 != 0) {
                bArr2[8] = -97;
                bArr2[9] = -114;
                bArr2[10] = -66;
                bArr2[11] = -116;
                bArr2[12] = 55;
                bArr2[13] = -37;
                bArr2[14] = 91;
                bArr2[15] = 52;
                break;
            }
            i13++;
            try {
                bArr2[0] = 39;
                bArr2[1] = 2;
                bArr2[2] = 102;
                bArr2[3] = 6;
                bArr2[4] = 82;
                bArr2[5] = 76;
                bArr2[6] = 75;
                bArr2[7] = -56;
                bArr2[8] = -97;
                bArr2[9] = -114;
                bArr2[10] = -66;
                bArr2[11] = -116;
                bArr2[12] = 55;
                bArr2[13] = -37;
                bArr2[14] = 91;
                bArr2[15] = 52;
                break;
            } catch (Exception unused3) {
            } catch (Throwable th) {
                bArr2[8] = -97;
                bArr2[9] = -114;
                bArr2[10] = -66;
                bArr2[11] = -116;
                bArr2[12] = 55;
                bArr2[13] = -37;
                bArr2[14] = 91;
                bArr2[15] = 52;
                throw th;
            }
        }
        int[] iArr7 = new int[44];
        int i14 = 0;
        loop6:
        while (i14 == 0) {
            i14 += 3;
            int i15 = 0;
            int i16 = 0;
            while (true) {
                int i17 = 0;
                while (i17 == 0) {
                    i17 += 3;
                    if (i15 >= 16) {
                        break;
                    }
                    try {
                        try {
                            iArr7[(((i16 >> 2) * 4) + i16) & 3] = ((bArr2[i15 + 1] & 255) << 8) | (bArr2[i15] & 255) | ((bArr2[i15 + 2] & 255) << 16) | (bArr2[i15 + 3] << Ascii.CAN);
                            i15 += 4;
                            i16++;
                        } catch (Exception unused4) {
                        }
                    } catch (Exception unused5) {
                    }
                }
                break;
            }
            for (int i18 = 4; i18 < 44; i18++) {
                int i19 = i18 - 1;
                try {
                    int i20 = iArr7[((i19 >> 2) * 4) + (i19 & 3)];
                    if (i18 % 4 == 0) {
                        i20 = kDt(bArr, dndmg(i20, 8)) ^ iArr6[(i18 / 4) - 1];
                    }
                    int i21 = i18 - 4;
                    iArr7[((i18 >> 2) * 4) + (i18 & 3)] = iArr7[((i21 >> 2) * 4) + (i21 & 3)] ^ i20;
                } catch (Exception unused6) {
                }
            }
            break loop6;
        }
        Object[] objArr = new Object[8];
        objArr[0] = bArr;
        objArr[1] = iArr2;
        objArr[2] = iArr3;
        objArr[3] = iArr4;
        objArr[4] = iArr5;
        objArr[5] = iArr7;
        objArr[6] = new int[]{552091731, 1710095889, 2001104874, 985698028};
        kqfg = objArr;
        htEClDAgA();
    }

    public static void vk(Context context) {
        evrtzj(context);
    }
}
