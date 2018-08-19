package com.kennyscott.photoaudit.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhotosByMonth {

	private Map<String, Set<String>> months;
	public Map<String, Integer> monthsCount;

	public void addPhoto(Photo photo) {
		if (months == null) {
			months = new HashMap<String, Set<String>>();
			monthsCount = new HashMap<String, Integer>();
		}
		if (!months.containsKey(photo.getMonthyear())) {
			months.put(photo.getMonthyear(), new TreeSet<String>());
		}
		months.get(photo.getMonthyear()).add(photo.getFile());
		updateMonthsCount(photo);
	}

	private void updateMonthsCount(Photo photo) {
		monthsCount.put(photo.getMonthyear(), months.get(photo.getMonthyear()).size());
	}

	public Map<String, Integer> getMonthsCount() {
		return monthsCount;
	}

}
