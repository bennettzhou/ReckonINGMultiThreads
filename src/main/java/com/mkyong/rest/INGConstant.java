package com.mkyong.rest;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.mkyong.rest.OBPObjects.ResponseAccountById;
import com.mkyong.rest.TransactionHistById.TransactionHistBean;
import com.mkyong.rest.Utils.CacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by bennettzhou on 28/04/2017.
 */
public class INGConstant {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    final static String DefaultUser="captionamerica";


    //this field contains the single instance every initialized.
    private static INGConstant ingConstant;
    private static Vector<String> Credentials;
    private static int thread=0;

    private INGConstant () {
        //initialize
        if(Credentials == null) {
            Credentials = new Vector<String>();
            Credentials.add("4ynabm3l0uvbijpgg202sdg5xh5w4mcsp2yexncb:dnhza1xxje25dmauhgbcwgoydgi0ohht0x4q2dnm");
            Credentials.add("jldfdsj2tgpugmvs3q5rjcyisaro50mfokxhvzzk:pyl2yvjprppmqnx3xswhjawerd34kn2igms2ydjj");
            Credentials.add("fpals0435k42zgyameazpfqrxm0pdvxylk2gxadd:4hq0hhbofxyjpmhvxu4bg4rswse41fwz2pdgfexv");
            Credentials.add("ff5ozmaatrfeb00t0iufgy0io5gtbod4ld51yyum:bcluzbfmphrvr31pprarp2uetlzzfhqnwu235o1t");
            Credentials.add("g04y3vvisolazint0pt3jhnjl5yhw5ftpebiovpg:tll5mg0qrtgjvydbppvbggykgf5rpfikgkdchj03");
            Credentials.add("ev4lqvijt0ffepqbsbtl3yqfcodeqg0ltu3qtb2u:wpvf1gaculsmrc33wib1pwb0iqbgmsyvnk2gldol");
        }
        initiateServices();
        log.info("INGConstant created...");
    }

    //this is the method to obtain the single instance
    public static INGConstant getInstance () {
        if (ingConstant == null) {
            synchronized (INGConstant.class) {
                if (ingConstant == null) {
                    ingConstant = new INGConstant();
                }
            }
        }
        return ingConstant;
    }

    final private static TestUser testuser = new TestUser();
    private static HashMap<String, String> BANKS;
    private static HashMap<String, String> BanksShortName;
    private static OAuth10aService service;
    private static HashMap<String, String> accountMap;
    private static HashMap<Integer, OAuth10aService> serviceMap;

    public static ArrayList<ResponseAccountById> accountList = new ArrayList<ResponseAccountById>();;
    public static HashMap<String, TransactionHistBean> MyTransactionHist = new HashMap<String, TransactionHistBean>();;
    public static int count = 0;

    public synchronized ArrayList<ResponseAccountById> getAccountList() {
        return accountList;
    }

    public synchronized HashMap<String, TransactionHistBean> getMyTransactionHist() {
        return MyTransactionHist;
    }

    public synchronized int getCount(){
        return count;
    }

    public synchronized void clearCount(){
        count=0;
    }

    public synchronized void increaseCount(){
        count++;
    }

    public void setAccountList(ArrayList<ResponseAccountById> accountList) {
        INGConstant.accountList = accountList;
    }

    public String getDefaultUser() {
        return DefaultUser;
    }

    public HashMap<String, String> getBanksShortName() {
        if(BanksShortName == null){
            BanksShortName = new HashMap<String, String>();
            BanksShortName.put("at02-1465--01", "Netherlands Bank");
            BanksShortName.put("at02-0182--01", "Spanish Bank");
            BanksShortName.put("at02-0019--01", "German Bank");
            BanksShortName.put("at02-0049--01", "Santander Bank");
            BanksShortName.put("at02-0073--01", "Open Bank");
            BanksShortName.put("at02-0075--01", "Banco Popular");
        }
        return BanksShortName;
    }

    public TestUser getTestuser() {
        return testuser;
    }

    public HashMap<String, String> getBANKS() {
        return BANKS;
    }

    public void setBANKS(HashMap<String, String> BANKS) {
        INGConstant.BANKS = BANKS;
    }


    private void initiateServices() {
        serviceMap = new HashMap<Integer, OAuth10aService>();
        OAuth10aService tempService;
        int i = 0;
        for (String a : Credentials){
            tempService = new ServiceBuilder()
                    .apiKey(a.substring(0, a.indexOf(":")))
                    .apiSecret(a.substring(a.indexOf(":")+1))
                    .callback("oob")
                    .build(OBPApi.instance());
            serviceMap.put(i++, tempService);
        }
    }

    public synchronized OAuth10aService getServices(){
        if(thread==Credentials.size()) thread=0;
        System.out.println("Thread running "+thread);
        return serviceMap.get(thread++);
    }

    public HashMap<String, String> getAccountMap() {
        if(accountMap == null){
            accountMap = new HashMap<String, String>();
        }
        return accountMap;
    }

    public synchronized void setAccountMap(HashMap<String, String> accountMap) {
        INGConstant.accountMap = accountMap;
    }
}
