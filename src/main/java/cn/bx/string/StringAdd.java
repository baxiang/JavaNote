package cn.bx.string;

public class StringAdd {
    public static void main(String[] args) {
//        String str = "";
//        StringBuffer stringBuffer = new StringBuffer("");
//        StringBuilder stringBuilder = new StringBuilder("");
//        long startTime = System.currentTimeMillis();
//        for (int i =0;i <50000;i++){
//            stringBuffer.append(String.valueOf(i));
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("StringBuffer的执行时间:" + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < 50000; i++) {
//            stringBuilder.append(String.valueOf(i));
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("StringBuilder的执行时间:" + (endTime - startTime));
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < 50000; i++) {
//            str = str + i;
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("String的执行时间:" + (endTime - startTime));
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < 50000; i++) {
//            str = str.concat(String.valueOf(i));
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("concat的执行时间:" + (endTime - startTime));



        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//
        System.out.println(sb);//
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
}
