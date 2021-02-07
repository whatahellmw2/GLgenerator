/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccjni;

import collections.ExemplosCollection;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.unitex.jni.UnitexJni;


/**
 *
 * @author thiago
 */
public class UnitexFunctions {
    //private static ArrayList<String> exemplos=new ArrayList();
         
    private static final String pathSeparator = UnitexJni.isUnderWindows() ? "\\" : "/";

      public static final String getVirtualFilePfx()
      {
        if (UnitexJni.unitexAbstractPathExists("*"))
            return "*";

        if (UnitexJni.unitexAbstractPathExists("$:"))
            return "$:";

        return null;
      }
      public void NormalizeGrf(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
          String cmdNorm = "Normalize " + UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"corpus.txt") + " -r "+UnitexJni.combineUnitexFileComponentWithQuote(othersResDir,"Norm.txt") + " --output_offsets="+ UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"offset1.txt") ;
          UnitexJni.execUnitexTool("UnitexTool " + cmdNorm);
      }
      public void Tokenize(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
          String cmdTok = "Tokenize " + UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"corpus.txt") + " -a "+ UnitexJni.combineUnitexFileComponentWithQuote(othersResDir,"Alphabet.txt") + " --input_offsets="+ UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"offset1.txt") + " --output_offsets="+ UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"offset2.txt") ;
          UnitexJni.execUnitexTool("UnitexTool " + cmdTok);
      }
       
      public void Dico(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
          String cmdDico = "Dico -t "+ UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"corpus.snt")+ " -a " + UnitexJni.combineUnitexFileComponentWithQuote(othersResDir,"Alphabet.txt")+" "+UnitexJni.combineUnitexFileComponentWithQuote(workingDicoFileName);
          UnitexJni.execUnitexTool("UnitexTool " + cmdDico); 
      }
      public void Txt2Tfst(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
         String cmdTxt2Tfst = "Txt2Tfst " + UnitexJni.combineUnitexFileComponentWithQuote(corpusPath,"corpus.snt")+" -a " + UnitexJni.combineUnitexFileComponentWithQuote(othersResDir,"Alphabet.txt") + " --clean"; 
         UnitexJni.execUnitexTool("UnitexTool " + cmdTxt2Tfst);
      }
      
      public void Tfst2Grf(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
          String cmdTfst2Grf = "Tfst2Grf " + UnitexJni.combineUnitexFileComponentWithQuote(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus_snt"),"text.tfst")+" -s1";
          UnitexJni.execUnitexTool("UnitexTool " + cmdTfst2Grf);
      }
      public void Grf2Fst2(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
          String cmdGrf2Fst2 = "Grf2Fst2 " + UnitexJni.combineUnitexFileComponentWithQuote(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus_snt"),"cursentence.grf");
          UnitexJni.execUnitexTool("UnitexTool " + cmdGrf2Fst2);
      }
      public void Fst2List(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText){
          String cmdFst2List = "Fst2List "+"-l 1000 -a s -o "+UnitexJni.combineUnitexFileComponent(corpusPath, "list.txt")+" "+ UnitexJni.combineUnitexFileComponentWithQuote(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus_snt"),"cursentence.fst2");
          UnitexJni.execUnitexTool("UnitexTool " + cmdFst2List);
      }
      public void implodeTfst(String corpusPath){
          String cmdImplodeTfst = "implodeTfst "+UnitexJni.combineUnitexFileComponentWithQuote(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus_snt"),"text.tfst");
          UnitexJni.execUnitexTool("UnitexTool "+cmdImplodeTfst);
      }
      public void deleteFolder(String folder){
          UnitexJni.removeUnitexFolder(folder);
      }
      private String processUnitexWork(String othersResDir,String workingDicoFileName, String workingGraphFileName,String workingNormGrfFileName,String corpusPath,String corpusText)
      {
          String pSep = pathSeparator;
          UnitexJni.writeUnitexFile(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus.txt"),corpusText);
		  
		  // we create offsets file offset1.txt and offset2.txt to get position against the original corpus in the xml file
          NormalizeGrf(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          Tokenize(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          Dico(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          Txt2Tfst(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          
          //implodeTfst(corpusPath);
          
          Tfst2Grf(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          Grf2Fst2(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          Fst2List(othersResDir, workingDicoFileName, workingGraphFileName, workingNormGrfFileName, corpusPath, corpusText);
          
         
          String merged =  UnitexJni.getUnitexFileString(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus.txt"));
          String xml = UnitexJni.getUnitexFileString(UnitexJni.combineUnitexFileComponent(corpusPath,"corpus_snt","concord.xml"));
          return xml;
      }
      public void configUnitex(String [] args, String text, int nbCosrpusWorkPath) {
          
        //exemplos = ExemplosCollection.getListaExemplos();
        //System.out.println(UnitexJni.combineUnitexFileComponent("A","b","c"));
        //System.out.println(UnitexJni.combineUnitexFileComponentWithQuote("b","c"));
		
        System.out.println("is ms-windows:"+UnitexJni.isUnderWindows()+" : "+System.getProperty("os.name")+ " "+java.io.File.separator);
        System.out.println("Usage : UnitexJniDemo [ressource_dir] [base_work_dir] [nb_loop] [param]");
        System.out.println("  param=0 : no vfs and no persistance");
        System.out.println("  param=1 : vfs and no persistance");
        System.out.println("  param=2 : no vfs and persistance");
        System.out.println("  param=3 : vfs and persistance (fastest)");
        System.out.println("");


        String baseWorkDir = ".";
        String ressourceDir = UnitexJni.isUnderWindows() ? ".\\demojnires": "./demojnires";
        int nbLoop=1;
        int cfgParam = 0;


        if (args.length>=1)
            ressourceDir=args[0];

        if (args.length>=2)
            baseWorkDir=args[1];

        if (args.length>=3)
            nbLoop=Integer.parseInt(args[2]);
        if (nbLoop<1)
            nbLoop=1;

        if (args.length>=4)
            cfgParam=Integer.parseInt(args[3]);

        System.out.println("resource path : '"+ressourceDir+"' and work path is '"+baseWorkDir+"' and "+nbLoop+" executions");

        String graphResDir = UnitexJni.combineUnitexFileComponent(ressourceDir, "graph");
        String dictionnaryResDir = UnitexJni.combineUnitexFileComponent(ressourceDir, "dictionnary");
        String othersResDir = UnitexJni.combineUnitexFileComponent(ressourceDir, "others");
        String normResDir = UnitexJni.combineUnitexFileComponent(ressourceDir, "normalization");

		UnitexJni.setStdOutTrashMode(true);
        //UnitexJni.setStdErrTrashMode(false);

        //////////////

        boolean fusevfs=(cfgParam == 1) || (cfgParam == 3);
        boolean fusepersist=(cfgParam == 2) || (cfgParam == 3);
        String PrefixVFS = "";
        System.out.println("use vfs:"+fusevfs+ (fusevfs ? (" on '"+getVirtualFilePfx()+"'") : "")) ;
        System.out.println("use persist:"+fusepersist);
        if (fusevfs)
        {
            PrefixVFS = getVirtualFilePfx();
            baseWorkDir=PrefixVFS+baseWorkDir;

            UnitexJni.copyUnitexFile(UnitexJni.combineUnitexFileComponent(othersResDir,"Alphabet.txt"),
                    UnitexJni.combineUnitexFileComponent(PrefixVFS+othersResDir,"Alphabet.txt"));
            UnitexJni.copyUnitexFile(UnitexJni.combineUnitexFileComponent(othersResDir,"Norm.txt"),
                    UnitexJni.combineUnitexFileComponent(PrefixVFS+othersResDir,"Norm.txt"));

            othersResDir=PrefixVFS+othersResDir;

            if (!fusepersist)
            {
                UnitexJni.copyUnitexFile(UnitexJni.combineUnitexFileComponent(dictionnaryResDir,"DELAF_PB_2015.bin"),
                                                UnitexJni.combineUnitexFileComponent(PrefixVFS+dictionnaryResDir,"DELAF_PB_2015.bin"));
                UnitexJni.copyUnitexFile(UnitexJni.combineUnitexFileComponent(dictionnaryResDir,"DELAF_PB_2015.inf"),
                        UnitexJni.combineUnitexFileComponent(PrefixVFS+dictionnaryResDir,"DELAF_PB_2015.inf"));
                dictionnaryResDir=PrefixVFS+dictionnaryResDir;

                UnitexJni.copyUnitexFile(UnitexJni.combineUnitexFileComponent(graphResDir,"AAA-hours-demo.fst2"),
                                                UnitexJni.combineUnitexFileComponent(PrefixVFS+graphResDir,"AAA-hours-demo.fst2"));
                graphResDir=PrefixVFS+graphResDir;
            }
        }

        String dicoFileName = UnitexJni.combineUnitexFileComponent(dictionnaryResDir,"DELAF_PB_2015.bin");
        String graphFileName = UnitexJni.combineUnitexFileComponent(graphResDir,"AAA-hours-demo.fst2");
        String normGrfFileName = UnitexJni.combineUnitexFileComponent(normResDir,"Norm.fst2");
        String workingGraphFileName;
        String workingDicoFileName;
        if (fusepersist)
        {
            workingDicoFileName = UnitexJni.loadPersistentDictionary(dicoFileName);
            workingGraphFileName = UnitexJni.loadPersistentFst2(graphFileName);
        }
        else
        {
            workingDicoFileName = dicoFileName;
            workingGraphFileName = graphFileName;
        }



        ////////////
       

        String CorpusWorkPath = UnitexJni.combineUnitexFileComponent(baseWorkDir, "workUnitex" + nbCosrpusWorkPath);

        System.out.println("will work on "+CorpusWorkPath);
        UnitexJni.createUnitexFolder(CorpusWorkPath);
        UnitexJni.createUnitexFolder(UnitexJni.combineUnitexFileComponent(CorpusWorkPath,"corpus_snt"));
        String res="";

        long startT = System.currentTimeMillis();
        //System.out.println("size"+exemplos.size());
        for (int i=0;i<nbLoop;i++)
        {
			// there is two space after watch, to check the offsets
            //System.out.println(i+exemplos.get(i));
            System.out.println(text);
            res=processUnitexWork(othersResDir,workingDicoFileName,workingGraphFileName,normGrfFileName,CorpusWorkPath,
                       text);
        }
        long endT = System.currentTimeMillis();

		
		// debug : you can remove this line to inspect files
        //UnitexJni.removeUnitexFolder(CorpusWorkPath);

        if (fusepersist)
        {
            UnitexJni.freePersistentDictionary(workingDicoFileName);
            UnitexJni.freePersistentFst2(workingGraphFileName);
        }

        System.out.println("");
        System.out.println("result:");
        System.out.println(res);
        System.out.println("time : "+(endT-startT)+" ms (average "+ ((endT-startT)/nbLoop)+" ms per iteration)");
        
    }
}
