package Metamap;


import gov.nih.nlm.nls.metamap.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidsilin on 5/17/16.
 */
public class MetaMapWrapper{
    public MetaMapApi api;

    String ip = "104.197.4.20";  //GCloud Server
    String options = "-y";
    //static ArrayList<String> allIn = new ArrayList<String>();

    public MetaMapWrapper(){
      newMetaMapAPI();
    }


    private void newMetaMapAPI(){
        api = new MetaMapApiImpl(ip);
        api.setOptions(options);
    }


    /**
     * Sends string to String to metamap server to be parsed.
     * @param in
     * @return
     */
    public List<Result> parseString(String in){
        List<Result> ret = null;
        try {
            if (api == null) {
                System.out.println("Metamap not initialized");
                newMetaMapAPI();
            }
            ret = api.processCitationsFromString(in);

        }catch(Exception e){
            try {
                System.out.println("SLEEPING...");
                Thread.sleep(5000);
                api.disconnect();
                newMetaMapAPI();
                System.out.println("AWAKE.");
            } catch (InterruptedException t) {
            }
        }

        return ret;
    }

    public List<String> getSems(String in){
        List<Result> ret = parseString(in);
        Result res = ret.get(0);
        ArrayList<String> sems = new ArrayList<>();
        try {
            List<Utterance>utter = res.getUtteranceList();
            for (Utterance utterance : utter) {
                for (PCM pcm: utterance.getPCMList()) {
                    for (Mapping map: pcm.getMappingList()) {
                        for (Ev ev: map.getEvList()) {
                            sems.addAll(ev.getSemanticTypes());

                        }
                    }
                }

            }
            return sems;
        } catch (Exception e){

        }
        return new ArrayList<>();
    }


    public void disconnect(){
        System.out.println("disconnected..");
        api.disconnect();

    }

}
