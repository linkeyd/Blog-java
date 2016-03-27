package Lin.blog.web.tool;
import java.io.UnsupportedEncodingException;


public class Unicore {
	 private static String changeCharSet(  
	            String str, String newCharset) throws UnsupportedEncodingException {  
	        if (str != null) {  
	            // 用默认字符编码解码字符串。  
	            byte[] bs = str.getBytes();  
	            // 用新的字符编码生成字符串  
	            return new String(bs, newCharset);  
	        }  
	        return str;  
	    }  
	      
	    /** 
	     * 字符串转化为UTF-8 
	     * @param str 
	     * @return 
	     */  
	    public static String toUTF8(String str){  
	        String result = str;  
	        try {  
	            result = changeCharSet(str, "UTF-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        return result;  
	    }  
	      
	    /** 
	     * 字节数组转化为UTF-8 
	     * @param bty 
	     * @return 
	     */  
	    public static String toUTF8(byte[] bty){  
	        try {  
	            if (bty.length > 0) {  
	                return new String(bty, "UTF-8");  
	            }  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        return new String(bty);  
	    }  
	    
	    /**
		 * 把中文转成Unicode码
		 * 
		 * @param str
		 * @return
		 */
		public static  String chinaToUnicode(String str) {
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				int chr1 = (char) str.charAt(i);
				if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
					result += "\\u" + Integer.toHexString(chr1);
				} else {
					result += str.charAt(i);
				}
			}
			return result;
		}
		
		/**
		 * 把Unicode码转成中文
		 * 
		 * @param s
		 * @return
		 */
		public static String unicode2String(String unicodeStr){
		    StringBuffer sb = new StringBuffer();
		    String str[] = unicodeStr.toUpperCase().split("\\\\U");
		    for(int i=0;i<str.length;i++){
		      if(str[i].equals("")) continue;
		      char c = (char)Integer.parseInt(str[i].trim(),16);
		      sb.append(c);
		    }
		    return sb.toString();
		  }

}
