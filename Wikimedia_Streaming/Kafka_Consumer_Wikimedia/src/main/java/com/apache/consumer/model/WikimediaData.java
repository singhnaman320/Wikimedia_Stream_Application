package com.apache.consumer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "wikimedia")
public class WikimediaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wikId;
	
	@Lob // In order to store large data we use @Lob
	private String wikiEventData;

	public Long getWikId() {
		return wikId;
	}

	public void setWikId(Long wikId) {
		this.wikId = wikId;
	}

	public String getWikiEventData() {
		return wikiEventData;
	}

	public void setWikiEventData(String wikiEventData) {
		this.wikiEventData = wikiEventData;
	}

	public WikimediaData(Long wikId, String wikiEventData) {
		super();
		this.wikId = wikId;
		this.wikiEventData = wikiEventData;
	}

	public WikimediaData() {
		super();
	}

	@Override
	public String toString() {
		return "WikimediaData [wikId=" + wikId + ", wikiEventData=" + wikiEventData + "]";
	}
	
}
