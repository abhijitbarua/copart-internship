package com.challenge.copart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClosestYard {
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		double latitude, longditude;
		
		System.out.print("Enter Latitude: ");
		latitude = keyboard.nextDouble();
		
		System.out.print("Enter Longitude: ");
		longditude = keyboard.nextDouble();
		
		ArrayList<USAddress> usaddress = getListOfPickupLocation();
		
		double minDistance = 0;
		USAddress nearestUSLocation = null;
		
		for (int i = 1; i < usaddress.size(); i++) {
			
			USAddress usAddress = usaddress.get(i);
			
			try
			{
				double latitude2 = Double.parseDouble(usAddress.getLatitude());
				double longitude2 = Double.parseDouble(usAddress.getLongitude());
				double tempDistance = findDistance(latitude, longditude, latitude2, longitude2);
				
				if (minDistance == 0) {
					minDistance = tempDistance;
					nearestUSLocation = usAddress;
				}
				else if (tempDistance < minDistance) {
					
					minDistance = tempDistance;
					nearestUSLocation = usAddress;
				}
			}catch (Exception ex) {
				
			}
		}
		
		System.out.println("Nearest City is " +nearestUSLocation.getCity() + ", State: " + nearestUSLocation.getState() +", Zip: " +nearestUSLocation.getZipCode());
	
    }


	private static ArrayList<USAddress> getListOfPickupLocation() {
		
		String csvFile = "zip_codes_states.csv";
		int noOfFields = 6;
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<USAddress> usAddressList = new ArrayList<USAddress>();
        
        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                String[] address = line.split(cvsSplitBy);
                
                USAddress usaddress = new USAddress();
                
                //compare with noOfField. Proceed if a row has all the data
                if (address.length == noOfFields) { 
                	if (!address[0].isEmpty() && !address[1].isEmpty() && !address[2].isEmpty() 
                			&& !address[3].isEmpty() && !address[4].isEmpty() && !address[5].isEmpty()) {
	                	usaddress.setZipCode(address[0]);
	                	usaddress.setLatitude(address[1]);
	                	usaddress.setLongitude(address[2]);
	                	usaddress.setCity(address[3]);
	                	usaddress.setState(address[4]);
	                	usaddress.setCounty(address[5]);
	                	
	                	usAddressList.add(usaddress);
                	}
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return usAddressList;
	}

	private static double findDistance(double latitude1, double longditude1, double latitude2, double longditude2) {
		
		long earthRadius = 6371; // Radius of the earth in km
		double distLat = deg2rad(latitude2-latitude1);  // deg2rad below
		double distLong = deg2rad(longditude2-longditude1); 
		  
		double a = Math.sin(distLat/2) * Math.sin(distLong/2) +
					Math.cos(deg2rad(distLat)) * Math.cos(deg2rad(distLong)) * 
					Math.sin(distLong/2) * Math.sin(distLat/2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		double distance = earthRadius * c; // Distance in km
		  
		return distance;
	}
	
	private static double deg2rad(double deg) {
		  return deg * (Math.PI/180);
	}
	
	
}
