import java.util.HashMap;

/**
 * Created by ajason2 on 8/31/16.
 */
public class SemWeights {
    //Semantic weights

    //David Weighted (resetted)
    public static float ortf = 1f;  //organ or tissue function
    public static float fndg = 0f;   //finding
    public static float ftcn = 0f;    //functional group
    public static float dsyn = 5f;  //Disease or Syndrome
    public static float bpoc = 1f;  //body part or organ
    public static float tisu = 1f;  //tissue
    public static float bdsu = 1f;  //Body Substance
    public static float patf = .3f;   //Pathologic Function
    public static float anab = .3f;  //Anatomical Abnormality
    public static float neop = 5f;  //Neoplastic Process
    public static float geoa = 0f;	    //geographic area
    public static float emst = 5f;    //embryonic structure
    public static float phsu = 1f;     //pharmacological substance
    public static float diap = 2f;    //diagnostic procedure
    public static float sbst = .5f;     //substance
    public static float inpr = 0f; 	//intellectual product
    public static float topp = .5f;	    //Therapeutic or Preventive Procedure

    //DownWeighted


    //Jason weighted

    //These items are weighted down for temporary convenience. It should be weighted according to the sources classification.
    public static float fish = 1f;		//Fish*
    public static float medd =  5f;	    //medical device
    public static float sosy = .25f;   //sign or symptom

    //Total and complete shutdown of
    public static float idcn = 0f;		//Idea or Concept*
    public static float tmco = 0f; 	//temporal process
    public static float qlco = 0f;	    //qualitative concept
    public static float qnco = 0f; 	//quantitative concept
    public static float spco = 0f;	    //spacial concept
    public static float resa = 0f;		//Research Activity*
    public static float prog = 0f;		//Professional or Occupational Group*
    public static float acty = 0f;		//Activity*
    public static float cnce = 0f;		//Conceptual Entity*
    public static float clas = 0f;		//Classification*
    public static float ocac = 0f;		//Occupational Activity*
    public static float popg = 0f;		//Population Group*
    public static float famg = 0f;		//Family Group*
    public static float mnob = 0f;	    //manufactured object
    public static float aggp = 0f;     //age group
    public static String[] ignoreSems = {"idcn","tmco","qlco","qnco","spco","resa","prog","acty","cnce","clas","ocac","popg","famg","mnob","aggp"};


    //Banned semtypes that could be revived with a good complexity detection system
    public static float inbe = 0f;		//Individual Behavior*
    public static float menp = 0f;		//Mental Process*

    //Under scruitiny
    public static float orgt = 0f;		//Organization*


    //Still relatively unknown
    public static float aapp = 5f;		//Amino Acid, Peptide, or Protein*
    public static float acab = 1f;		//Acquired Abnormality*
    public static float amas = 5f;		//Amino Acid Sequence*
    public static float amph = 1f;		//Amphibian*
    public static float anim = 1f;		//Animal*
    public static float anst = 1f;		//Anatomical Structure*
    public static float antb = 3f;		//Antibiotic*
    public static float arch = 1f;		//Archaeon*
    public static float bacs = 3f;		//Biologically Active Substance*
    public static float bact = 5f;		//Bacterium*
    public static float bdsy = 1f;		//Body System*
    public static float bhvr = .25f;		//Behavior*
    public static float biof = .25f;		//Biologic Function*
    public static float bird = 1f;		//Bird*
    public static float blor = 1f;		//Body Location or Region*
    public static float bmod = 3f;		//Biomedical Occupation or Discipline*
    public static float bodm = 3f;		//Biomedical or Dental Material*
    public static float bsoj = 1f;		//Body Space or Junction*
    public static float carb = 2f;		//Carbohydrate*
    public static float celc = 3f;		//Cell Component*
    public static float celf = 3f;		//Cell Function*
    public static float cell = 3f;		//Cell*
    public static float cgab = 3f;		//Congenital Abnormality*
    public static float chem = 4f;		//Chemical*
    public static float chvf = 4f;		//Chemical Viewed Functionally*
    public static float chvs = 4f;		//Chemical Viewed Structurally*
    public static float clna = 4f;		//Clinical Attribute*
    public static float clnd = 4f;		//Clinical Drug*
    public static float comd = 4f;		//Cell or Molecular Dysfunction*
    public static float crbs = 4f;		//Carbohydrate Sequence*
    public static float dora = .5f;		//Daily or Recreational Activity*
    public static float drdd = 1.5f;	//Drug Delivery Device*
    public static float edac = .5f;		//Educational Activity*
    public static float eehu = .25f;	//Environmental Effect of Humans*
    public static float eico = 2f;		//Eicosanoid*
    public static float elii = 2f;		//Element, Ion, or Isotope*
    public static float emod = 3f;		//Experimental Model of Disease*
    public static float enty = 0f;		//Entity*
    public static float enzy = 5f;		//Enzyme*
    public static float euka = 5f;		//Eukaryote*
    public static float evnt = 0f;		//Event*
    public static float ffas = 3f;		//Fully Formed Anatomical Structure*
    public static float fngs = 3f;		//Fungus*
    public static float food = 1f;		//Food*
    public static float genf = 3f;		//Genetic Function*
    public static float gngm = 5f;		//Gene or Genome*
    public static float gora = .25f;	//Governmental or Regulatory Activity*
    public static float grpa = .25f;		//Group Attribute*
    public static float grup = .25f;		//Group*
    public static float hcpp = .5f;		//Human-caused Phenomenon or Process*
    public static float hcro = 5f;		//Health Care Related Organization*
    public static float hlca = 5f;		//Health Care Activity*
    public static float hops = 2f;		//Hazardous or Poisonous Substance*
    public static float horm = 5f;		//Hormone*
    public static float humn = .25f;		//Human*
    public static float imft = 5f;		//Immunologic Factor*
    public static float inch = 5f;		//Inorganic Chemical*
    public static float inpo = 1f;		//Injury or Poisoning*
    public static float irda = 1f;		//Indicator, Reagent, or Diagnostic Aid*
    public static float lang = .25f;		//Language*
    public static float lbpr = 1.5f;		//Laboratory Procedure*
    public static float lbtr = 1.5f;		//Laboratory or Test Result*
    public static float lipd = 2f;		//Lipid*
    public static float mamm = 1f;		//Mammal*
    public static float mbrt = 3f;		//Molecular Biology Research Technique*
    public static float mcha = 1f;		//Machine Activity*
    public static float mobd = 1.25f;		//Mental or Behavioral Dysfunction*
    public static float moft = 3f;		//Molecular Function*
    public static float mosq = 3f;		//Molecular Sequence*
    public static float nnon = 3f;		//Nucleic Acid, Nucleoside, or Nucleotide*
    public static float npop = .5f;		//Natural Phenomenon or Process*
    public static float nsba = 3f;		//Neuroreactive Substance or Biogenic Amine*
    public static float nusq = 5f;		//Nucleotide Sequence*
    public static float ocdi = .25f;		//Occupation or Discipline*
    public static float opco = 3f;		//Organophosphorus Compound*
    public static float orch = 1.5f;		//Organic Chemical*
    public static float orga = .3f;		//Organism Attribute*
    public static float orgf = .3f;		//Organism Function*
    public static float orgm = .3f;		//Organism*
    public static float phob = .3f;		//Physical Object*
    public static float phpr = .3f;		//Phenomenon or Process*
    public static float phsf = .3f;		//Physiologic Function*
    public static float plnt = 1f;		//Plant*
    public static float podg = 1f;		//Patient or Disabled Group*
    public static float pros = .5f;		//Professional Society*
    public static float rcpt = 1f;		//Receptor*
    public static float rept = 1f;		//Reptile*
    public static float resd = 2f;		//Research Device*
    public static float rnlw = .2f;		//Regulation or Law*
    public static float shro = .7f;		//Self-help or Relief Organization*
    public static float socb = .3f;		//Social Behavior*
    public static float strd = 4f;		//Steroid*
    public static float virs = 5f;		//Virus*
    public static float vita = 5f;		//Vitamin*
    public static float vtbt = 1f;		//Vertebrate


    public static float[] semWeights = {ortf,fndg,ftcn,aggp,sosy,dsyn,bpoc,tisu,bdsu,patf,anab,neop,tmco,qlco,qnco,spco,geoa,emst,phsu,diap,sbst,mnob,inpr,medd,topp,aapp,acab,acty,amas,amph,anim,anst,antb,arch,bacs,bact,bdsy,bhvr,biof,bird,blor,bmod,bodm,bsoj,carb,celc,celf,cell,cgab,chem,chvf,chvs,clas,clna,clnd,cnce,comd,crbs,dora,drdd,edac,eehu,eico,elii,emod,enty,enzy,euka,evnt,famg,ffas,fish,fngs,food,genf,gngm,gora,grpa,grup,hcpp,hcro,hlca,hops,horm,humn,idcn,imft,inbe,inch,inpo,irda,lang,lbpr,lbtr,lipd,mamm,mbrt,mcha,menp,mobd,moft,mosq,nnon,npop,nsba,nusq,ocac,ocdi,opco,orch,orga,orgf,orgm,orgt,phob,phpr,phsf,plnt,podg,popg,prog,pros,rcpt,rept,resa,resd,rnlw,shro,socb,strd,virs,vita,vtbt};
    public static String[] semLabel = {"ortf","fndg","ftcn","aggp","sosy","dsyn","bpoc","tisu","bdsu","patf","anab","neop","tmco","qlco","qnco","spco","geoa","emst","phsu","diap","sbst","mnob","inpr","medd","topp","aapp","acab","acty","amas","amph","anim","anst","antb","arch","bacs","bact","bdsy","bhvr","biof","bird","blor","bmod","bodm","bsoj","carb","celc","celf","cell","cgab","chem","chvf","chvs","clas","clna","clnd","cnce","comd","crbs","dora","drdd","edac","eehu","eico","elii","emod","enty","enzy","euka","evnt","famg","ffas","fish","fngs","food","genf","gngm","gora","grpa","grup","hcpp","hcro","hlca","hops","horm","humn","idcn","imft","inbe","inch","inpo","irda","lang","lbpr","lbtr","lipd","mamm","mbrt","mcha","menp","mobd","moft","mosq","nnon","npop","nsba","nusq","ocac","ocdi","opco","orch","orga","orgf","orgm","orgt","phob","phpr","phsf","plnt","podg","popg","prog","pros","rcpt","rept","resa","resd","rnlw","shro","socb","strd","virs","vita","vtbt"};
    public static HashMap<String, Float> semValue; //HashMap of semType string to weight value


    //Initializes the semValue HashMap
    public static void initializeHashMap(){
        semValue = new HashMap<String,Float>();
        for(int i = 0; i< semWeights.length; i++){
            semValue.put(semLabel[i], semWeights[i]);
        }
    }

    //Returns the semValue HashMap
    public static double getSemValue(String sem){
        if(semValue == null){
            initializeHashMap();
        }
        return semValue.get(sem);
    }


}
