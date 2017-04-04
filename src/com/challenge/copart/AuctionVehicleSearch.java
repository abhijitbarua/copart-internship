package com.challenge.copart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class AuctionVehicleSearch {
	
	private static final String USER_AGENT = "Mozilla/5.0 (compatible; MSIE 5.0;Windows98;DigExt)";
	private static final String COUNTRY = "country";
	private static final String BRAND = "brand";
	private static final String AUCTION_DATE = "auctionDate";
	private static final String YARD_NUMBER = "yardNumber";

	public static void main (String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		String country, brand, auctionDate, yardNumber;
		
		System.out.print("Enter your preference for country: ");
		country = keyboard.nextLine();
		
		System.out.print("Enter your preference for Brand: ");
		brand = keyboard.nextLine();
		
		System.out.print("Enter auction date: ");
		auctionDate = keyboard.nextLine();
		
		System.out.print("Enter your yard number: ");
		yardNumber = keyboard.nextLine();
		
		
		try{
    		
			String urlString = "http://inventory.copart.io/v1/list";
            String urlParameters = COUNTRY +"=" + URLEncoder.encode(country, "UTF-8") +
                    "&" +BRAND +"=" + URLEncoder.encode(brand, "UTF-8") +
            		"&" +AUCTION_DATE +"=" + URLEncoder.encode(auctionDate, "UTF-8") +
            		"&" +YARD_NUMBER +"=" + URLEncoder.encode(yardNumber, "UTF-8");
            
			URL url = new URL(urlString +"?" +urlParameters);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            
            huc.setRequestMethod("GET");
            huc.setRequestProperty("User-Agent", USER_AGENT);
            huc.setRequestProperty("Content-Type", 
                    "application/x-www-form-urlencoded");
         			
            huc.setRequestProperty("Content-Length", "" + 
                        Integer.toString(urlParameters.getBytes().length));
            huc.setRequestProperty("Content-Language", "en-US");  
         			
            huc.setUseCaches(false);
            huc.setDoInput(true);
            huc.setDoOutput(true);
            

            System.out.println("Here I am " + huc);
            
            huc.connect();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
            }
            String result = stringBuilder.toString();
			  
			System.out.println("Response from service" + result); 
			
			//AuctionBean auctionBean = TestMapper.mapObject(result);
           
          }                        
          catch (Exception e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
          }

                     
            // TODO Auto-generated method stub

	}
		
        
}
	

