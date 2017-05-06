package com.mkyong.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bennettzhou on 24/04/2017.
 */
public class TestUser {

    private Map<String, String[]> keys;
    //Default
    final String user_name="captionamerica";
    final String oauth_token="E2HZQCI0WSKBJZATGLSXO32R5SUO50OYZTNIPKWY";
    final String oauth_token_secret="YDVCDSAEWKVGHWNAOI145NTOMCZZO34JBSMVKXRJ";
    final String rawResponse="oauth_token="+oauth_token+"&oauth_token_secret="+oauth_token_secret;
    //Test user 1
    final String user_name1="iamsam";
    final String oauth_token1="5CDD3T1URGNCOH0XOLN20D4NRSW3O2YGQTCAHPWB";
    final String oauth_token_secret1="UKMXGW0PUEDRREJ5GM2CVEKNKB2UVSMDK3MEMMF4";
    final String rawResponse1="oauth_token="+oauth_token1+"&oauth_token_secret="+oauth_token_secret1;
    //Test user2
    final String user_name2="iamben";
    final String oauth_token2="EM3EJOIBMEE3KT1Q5P4L1WEN1AMNI1VWDYCXBXAR";
    final String oauth_token_secret2="GBQZ1Q03YVAMIXM04EOSPBBMWMORWUKHYPMORFHB";
    final String rawResponse2="oauth_token="+oauth_token1+"&oauth_token_secret="+oauth_token_secret1;

    public TestUser(){
        keys = new HashMap<String, String[]>();
        keys.put(user_name, new String[]{oauth_token, oauth_token_secret, rawResponse});
        keys.put(user_name1, new String[]{oauth_token1, oauth_token_secret1, rawResponse1});
        keys.put(user_name2, new String[]{oauth_token2, oauth_token_secret2, rawResponse2});
    }

    public Map<String, String[]> getKeys() {
        return keys;
    }
}
