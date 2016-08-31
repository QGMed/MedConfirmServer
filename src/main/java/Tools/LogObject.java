package Tools;

/**
 * Created by jason on 7/13/16.
 * Used to sout complex objects
 */
public class LogObject {
    public static void StringArray(String[] strArr){
        String out = "[";
        for(int i=0; i<strArr.length;i++){
            out+=strArr[i]+",";
        }
        out = out.substring(0,out.length()-1);
        out+="]";
        System.out.println(out);
    }

    public static void StringArrayNumerical(String[] res) {
        String out = "";
        for(int i=0; i<res.length;i++){
            System.out.println(i+": "+res[i]);
        }
    }
}
