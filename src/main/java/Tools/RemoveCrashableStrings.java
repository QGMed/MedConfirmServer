package Tools;

import java.io.IOException;

/**
 * Created by jason on 6/2/16.
 * Removes texts that crashes our system.
 */
public class RemoveCrashableStrings {
   public static String clean(String data){
        data = quoteFix(data);
        data = removeFigsAndTablesRefs(data);
        //data = removeAllDashNewLines(data);
        data = removeAllTitles(data);
        data = removeAllNumOnly(data);
        data = newLinesToSpace(data);
        data = removeNonASCII(data);
        return data;
    }


    public static String removeNonASCII(String output){
        try {
            output = replace_UTF8.ReplaceLooklike(output);
            return output.replaceAll("[^\\x20-\\x7e]", "");
        } catch (IOException e) {
            return output.replaceAll("[^\\x20-\\x7e]", "");
        }
    }

    public static String removeAllDashNewLines(String output) {
        for(int i=0; i<output.length();i++){
            if(output.charAt(i)=='\n'&& output.charAt(i-1)=='-'){
                output= output.substring(0,i-1)+output.substring(i+1,output.length());
            }
        }
        return output;
    }

    public static String breakOnPeriods(String output) {

        //return output.replaceAll(".", ".\n");
        for(int i=0; i<output.length();i++){
            if(output.charAt(i)=='.' ){
                if(output.length() > i+1 && output.charAt(i+1) == '\"'){
                    output= output.substring(0,i+2)+"\n"+output.substring(i+3,output.length());
                } else{
                    if(output.charAt(i+1) == ' '){
                        output= output.substring(0,i)+".\n"+output.substring(i+2,output.length());
                    } else{
                        output= output.substring(0,i+1)+"\n"+output.substring(i+1,output.length());
                    }
                }
            }
        }
        return output;
    }

    public static String removeAllCapsNewLines(String output) {
        return output = output.replaceAll("\n[A-Z\\s]*\n", "");
    }

    //TODO: This function appears not to work
    public static String removeAllNumOnly(String output) {
        return output.replaceAll("\n[0-9]*\n", "");
    }

    public static String newLinesToSpace(String output) {
        for(int i=0; i<output.length();i++){
            if(output.charAt(i)=='\n'){
                output= output.substring(0,i)+" "+output.substring(i+1,output.length());
            }
        }
        return output;
    }

    public static String removeFigsAndTablesRefs(String output) {
        //output = output.replaceAll(" \\(see Fig.\n[0-9]*-[0-9]*\\)", "");
        //output = output.replaceAll(" \\(Fig.\n[0-9]*-[0-9]*[A-Z]*[,]*[\\s]*[A-Z]*\\)", "");

        output = output.replaceAll("\\([A-z 0-9 \n;,.-]*Fig[A-z 0-9 \n;,.-]*\\)","");//\([A-z]*Fig[A-z 0-9 \n;,.-]*\)
        output = output.replaceAll("(FIGURE[A-z 0-9 \n;,.-]*[.])","");
        output = output.replaceAll("([(][A-z 0-9 \n;,.-]*arrow[A-z 0-9 \n;,.-]*[)])","");
        output = output.replaceAll("\n\n","\n");

        return output;
    }

    public static String removeAllTitles(String output) {
        output = output.replaceAll("\n([\\s* and but or the is of in vs.]*([A-Z][a-z]*)\\s*\n*)*\n", "");
        return output;
    }

    public static String quoteFix(String output) {
        output = output.replaceAll("‘‘", "\"");
        output = output.replaceAll("’’", "\"");
        return output;
    }
}
