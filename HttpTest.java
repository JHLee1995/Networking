// package com.gitee.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpTest {

	public static void main(String[] args) throws Exception {
		System.out.println("input website");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();// define Scanner

		URL url = new URL(str);//output URL

		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); //build connect

		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8")); //open URl
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);//output
		}

	}

}