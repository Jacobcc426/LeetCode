package HuaWeiExam;

public class Test {
    public static void main(String[] args) {
        System.out.println(yasuo("aabcccccaaa"));
        System.out.println(yasuo("abbccd"));
    }
    static String yasuo(String str){
        char[] chars = str.toCharArray();
        char pre =chars[0];
        int count = 1;
        StringBuffer result = new StringBuffer();
        for(int i=1;i<chars.length;i++){
            if(chars[i]==pre){
                count++;
            }else {
                result.append(""+pre+count);
                pre = chars[i];
                count=1;
            }
        }
        result.append(""+pre+count);
        return result.toString();
        
    }
}

