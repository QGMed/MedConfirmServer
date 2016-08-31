/**
 * Created by davidsilin on 4/5/16.
 */


import Metamap.MetaMapWrapper;
import Tools.LogObject;
import Tools.RemoveCrashableStrings;
import spark.Spark;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

//TODO: Modify MedicalWeights to not be static
public class Application {
    public static void main(String[] args){
        SemWeights.initializeHashMap();
        MetaMapWrapper mmw = new MetaMapWrapper();
        URLDecoder ud = new URLDecoder();
        //If local, allow for auto-refreshing
        init();

        Spark.get("/",(request,response)->{
             response.redirect("/index.html");
            return null;
        });


        Spark.get("/isMedical",(request, response) -> {
            String query = request.queryString();
            String text = URLDecoder.decode(query.substring(5,query.length()));
            System.out.println(text);
            List<String> sems = mmw.getSems(RemoveCrashableStrings.clean(text));
            double medEval = 0;
            for(int i=0; i<Math.min(sems.size(),35); i++){
                medEval+= SemWeights.getSemValue(sems.get(i));
            }
            System.out.println(medEval);
            return medEval>20;
        });


        //enable cors
        Spark.options("/*", (request,response)->{
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if(accessControlRequestMethod != null){
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        //also for enabling cors
        Spark.before((request,response)->{
            response.header("Access-Control-Allow-Origin", "*");
        });
    }

}
