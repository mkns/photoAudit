package com.kennyscott.photoaudit.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kennyscott.photoaudit.Foo;

@Controller
public class MyController {

	@Autowired
	private Foo foo;

	@Autowired
	private Gson gson;

	final static Logger LOG = Logger.getLogger(MyController.class);

	@RequestMapping(value = "/heyJson", method = RequestMethod.GET)
	@ResponseBody
	public String fnarr() throws FileNotFoundException {
		LOG.info("fnarr running");
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("data/server");
		String result = getStringFromInputStream(input);
		LOG.info(result);
		foo.setFoo("fnarr");
		return gson.toJson(foo);
	}

	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
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

		return sb.toString();

	}

}
