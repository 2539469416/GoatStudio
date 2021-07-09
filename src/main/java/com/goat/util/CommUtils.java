package com.goat.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 2016/11/16.
 */
public class CommUtils {
    /**
     * 时间单位
     */
    public static int TIME_UNIT_MINUTE = 0;
    public static int TIME_UNIT_HOUR = 1;
    public static int TIME_UNIT_DAY = 2;
    public static int TIME_UNIT_MONTH = 3;
    public static int TIME_UNIT_YEAR = 4;
    public static final String[] TIME_UNIT_DISPLAY = {"分钟", "小时", "天", "月", "年"};

    public static String makeAutoGUID() {
        UUID uuid = UUID.randomUUID();
        String GUID = uuid.toString();
        GUID = GUID.replaceAll("-", "");
        return GUID;
    }

    public static String get16GUID() {
        UUID id = UUID.randomUUID();
        String[] idd = id.toString().split("-");
        return idd[0] + idd[1] + idd[2];
    }

    public static String Md5(String text) {
        if(text == null) {
            return null;
        } else {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException var6) {
                var6.printStackTrace();
                return null;
            }

            byte[] b = md.digest(text.getBytes());
            StringBuffer buf = new StringBuffer();

            for(int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if(i < 0) {
                    i += 256;
                }
                if(i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i).toLowerCase());
            }

            return buf.toString();
        }
    }

    /*
     * 生成随机字符串
     * length表示生成字符串的长度
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString().toUpperCase();
    }

    public static Date strToDateForYYYYMMDD(String dstr) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dstr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToDateForYYYYMMDDHHMMSS(String dstr) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Date date = null;
        try {
            date = sdf.parse(dstr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 将日期类型改为东方日期的形式
     * @param date 日期类型参数
     * @return 东方日期形式的字符串 例如 2015-11-11 11:11:11
     */
    public static String dateTOYYYYMMDDHHMMSS(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static String dateTOYYYYMMDDHHMMSS1(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    /**
     * 将日期类型改为东方日期的形式
     * @param date 日期类型参数
     * @return 东方日期形式的字符串 例如 2015-11-11
     */
    public static String dateTOYYYYMMDD(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 将日期类型改为东方日期的形式
     * @param date 日期类型参数
     * @return 东方日期形式的字符串 例如 2015-11-11
     */
    public static String dateTOHHMMSS(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * Date运算
     * @throws NoSuchAlgorithmException
     */
    public static Date datePlus(Date date, int size, int unit) {
        GregorianCalendar gc=new GregorianCalendar();
        gc.setTime(date);
        // 单位为：分钟
        if (unit == TIME_UNIT_MINUTE) {
            gc.add(GregorianCalendar.MINUTE, size);

            // 单位为：小时
        } else if (unit == TIME_UNIT_HOUR) {
            gc.add(GregorianCalendar.HOUR_OF_DAY, size);

            // 单位为：天
        } else if (unit == TIME_UNIT_DAY) {
            gc.add(GregorianCalendar.DAY_OF_MONTH, size);
            // 单位为：月
        } else if (unit == TIME_UNIT_MONTH) {
            gc.add(GregorianCalendar.MONTH, size);
            // 单位为：年
        } else if (unit == TIME_UNIT_YEAR) {
            gc.add(GregorianCalendar.YEAR, size);
        }
        return gc.getTime();
    }

    /**
     * 获取价格字段（小数点保留两位）
     * @throws NoSuchAlgorithmException
     */
    public static BigDecimal getPriceValue(String value) {
        BigDecimal retVal = new BigDecimal(value);
        retVal = retVal.setScale(2, BigDecimal.ROUND_DOWN);
        return retVal;
    }

    /**
     * 检验文本 < > / 等
     * @param source
     * @return
     */
    public static String htmlEncode(String source) {
        if (source == null) {
            return "";
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            switch (c) {
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
                case '&':
                    buffer.append("&amp;");
                    break;
                case '"':
                    buffer.append("&quot;");
                    break;
                case 10:
                case 13:
                    break;
                default:
                    buffer.append(c);
            }
        }
        html = buffer.toString();
        return html;
    }

    /**
     * 格式化空格回车
     */
    public static String formatInputStringForHtml(String desp){
        desp = htmlEncode(desp);
        desp = desp.replaceAll(" ", "&nbsp;");
        desp = desp.replaceAll("\n", "<br/>");
        desp = desp.replaceAll("\r", "");
        return desp;
    }


    /**
     * 微信小程序转换格式化空格回车
     */
    public static String formatInputStringForWxLp(String desp){
        desp = desp.replaceAll(" ", "\t");
        desp = desp.replaceAll("\r", "");
        //desp = desp.replaceAll("\n", "<br/>");
        return desp;
    }

    /**
     * 生成4位随机数
     */
    public static String generateRadomByte4() {
        int radomNum = (int)((Math.random() * 9 + 1) * 1000);
        return String.valueOf(radomNum);
    }

    /**
     * 获取文件扩展名
     * @return
     */
    public static String getFileType(String filename) {
        int index = filename.lastIndexOf(".");

        if (index == -1) {
            return null;
        }
        String result = filename.substring(index + 1);
        return result.toLowerCase();
    }

    /**
     * 将以 ，分割的String转换为List
     * @param str 以逗号分割的字符串
     * @return
     */
    public static List<String> stringToList(String str){
        List<String> list = new ArrayList<>();
        String[] array = str.split(",");
        for (int i = 0; i < array.length; i++) {
            if(array[i] !=null && !array[i].equals("")){
                list.add(array[i]);
            }
        }
        return list;
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");

        if (index == -1) {
            return null;
        }
        String result = fileName.substring(0, index);
        return result;
    }
    /**
     * 获取固定间隔时刻集合
     * @param start 开始时间
     * @param end 结束时间
     * @param interval 时间间隔(单位：秒)
     * @return
     */
    public static List<Long> getIntervalTimeList(Date start, Date end, int interval){
        List<Long> list = new ArrayList<>();
        while(start.getTime()<=end.getTime()){
            Calendar calendar = Calendar.getInstance();
            list.add(start.getTime());
            calendar.setTime(start);
            calendar.add(Calendar.SECOND,interval);
            if(calendar.getTime().getTime()>end.getTime()){
                if(!start.equals(end)){
                    list.add(end.getTime());
                }
                start = calendar.getTime();
            }else{
                start = calendar.getTime();
            }

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(Calendar.SECOND,interval);
        list.add(start.getTime());
        return list;
    }

    //保存文件
    public static boolean saveFile(MultipartFile file, String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = path + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //获取三十天之后日期
    public static Date getDate(){
        //获取当前日期
        Date today = new Date();
        //获取三十天前日期
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        theCa.add(theCa.DATE, +30);//最后一个数字30可改，30天的意思
        Date start = theCa.getTime();
        return start;
    }


    public static void main(String[] args) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);
        String result = df.format((float) 9 / (float) 20 * 100);
        System.out.println(result);
    }
}
