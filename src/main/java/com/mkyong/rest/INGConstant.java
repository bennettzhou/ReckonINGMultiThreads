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

    final static String DefaultUser="bennettzhou1";
    final static String apiKey="f1y3h5r2sqn02jz2mu2gljfcl5nqh3nxz0jcclte";
    final static String apiSecret="khtirqdmxqu5dmtmkk1fvuoayn11c21vqokmhcyc";

    //this field contains the single instance every initialized.
    private static INGConstant ingConstant;
    private static Vector<String> Credentials;
    private static int thread=0;

    private INGConstant () {
        //initialize
        if(Credentials == null) {
            Credentials = new Vector<String>();
            Credentials.add("0rtnu13khzngztzsfavye1o3g3txnfjz10e5d5aw:eav2uppqmxark3jzqfjwgw35d0uc41523z43yens");
            Credentials.add("mlcxrtes30tkgoxz15ao1wufbhme4ueizg3zahdr:kzefwj3jwvofmcfktdwbwvry1udspwp2vgx45atb");
            Credentials.add("3f4nzlnidfwubswxmec4bucmmoyjrand3c2umwxz:dgebrpphbml5gtxlxzeb450ezgqgfqypkyif3qvi");
            Credentials.add("jtlmbubg0co203azvwqsps4anb5fu4zbne2ncrsd:nsca5irl2miftjd1ir3fldzevclmaoeo4kymvqu3");
            Credentials.add("t2bkhqusrynonld2gam2gzabzcbjpqng4fkdxgkk:h4eyjmevbbhcwma5qdcbcnsstfwzc4ehmqiscjfd");
            Credentials.add("fr2syz5sjoe5onmg2q4s54aetcdyxfsklgdfzzxo:e4zfunslbejhzwim4jndvmhlbcp0evna1qmpeyqk");
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
            BanksShortName.put("at.03.1465.es", "Netherlands Bank");
            BanksShortName.put("at02-1465--01", "Netherlands Bank");
            BanksShortName.put("hsbc-test", "Hong Kong Bank");
            BanksShortName.put("rbs", "Scotland Bank");
            BanksShortName.put("deutche-test", "German Bank");
            BanksShortName.put("in-bank-y-2", "Indian Bank");
            BanksShortName.put("at03-0019", "German Bank");
            BanksShortName.put("at02-0049--01", "Spanish Bank");
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

    public OAuth10aService getService() {
        if(service == null){
            log.info("Initiating Service...");
            service = new ServiceBuilder()
                    .apiKey(apiKey)
                    .apiSecret(apiSecret)
                    .callback("oob")
                    .build(OBPApi.instance());
        }
        return service;
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
