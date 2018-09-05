package com.kennyscott.photoaudit.controller;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kennyscott.photoaudit.dao.JsonDataReader;
import com.kennyscott.photoaudit.entity.Photo;
import com.kennyscott.photoaudit.entity.PhotosByMonth;

@Controller
public class MyController {

	@Autowired
	private Gson gson;

	@Autowired
	private JsonDataReader jsonDataReader;

	final static Logger LOG = Logger.getLogger(MyController.class);

	final static String serverFilename = "data/server";

	@RequestMapping(value = "/monthSummaryController", method = RequestMethod.GET)
	@ResponseBody
	public String monthSummary() throws FileNotFoundException {
		String result = jsonDataReader.readData(serverFilename);
		Type listType = new TypeToken<ArrayList<Photo>>() {
		}.getType();
		List<Photo> photos = new Gson().fromJson(result, listType);
		PhotosByMonth photosByMonth = new PhotosByMonth();
		for (Photo photo : photos) {
			photosByMonth.addPhoto(photo);
		}
		return gson.toJson(photosByMonth.getMonthsCount());
	}

	@RequestMapping(value = "/heyJson", method = RequestMethod.GET)
	@ResponseBody
	public String fnarr() throws FileNotFoundException {
		LOG.info("fnarr running");
		String result = jsonDataReader.readData(serverFilename);
		// LOG.info(result);

		Type listType = new TypeToken<ArrayList<Photo>>() {
		}.getType();
		List<Photo> yourClassList = new Gson().fromJson(result, listType);
		LOG.info("There are " + yourClassList.size());
		for (Photo photo : yourClassList) {
			LOG.info(photo.getFile());
		}

		return gson.toJson(yourClassList);
	}

}
