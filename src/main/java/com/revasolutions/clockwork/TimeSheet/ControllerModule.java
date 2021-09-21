package com.revasolutions.clockwork.TimeSheet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ControllerModule {


	final static String endpoint = "https://api.clockwork.report/v1/worklogs";
	final static String authToken = "Token w5fyYAUTAGiJdeX5xabGJDF4cQ+wssBIJFRzA"
			+ "DKJhgC3YrkUhIfbR5eOq4pRmEOTr00Sj1QdxKajJmGj7L6JVZQyFcvn5xM9"
			+ "JCyAfg==--23DUKxUEbCxhi+xC--gWGVMNenSnRikiJ60myNKw==";
	
	public void getWholeWorkLog() throws Exception {
		StringBuilder ep = new StringBuilder();
		ep.append(endpoint)
		.append("?expand=emails");		

		sendGetRequest(ep.toString());	
		System.out.println("Total time taken = "+Entity.getTotalTime()+" hours");


	}



	public void getSpecificUserDetails(String[] userDetails) {
		// TODO Auto-generated method stub
		StringBuilder ep = new StringBuilder(endpoint);
		ep.append("?expand=emails,authors")
		.append("&starting_at="+userDetails[0])
		.append("&ending_at="+userDetails[1])
		.append("&user_query="+userDetails[2]);

		sendGetRequest(ep.toString());
		System.out.println("Total time taken = "+Entity.getTotalTime()+ " hours");
	}

	



	public static void sendGetRequest(String url) {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("Authorization", authToken)
				.uri(URI.create(url))
				.build();



		Entity entities[];
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			entities = new ObjectMapper()
					.readerFor(Entity[].class)
					.readValue(response.body());
			System.out.println(Arrays.toString(entities));
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
