package sax;

public class Item {
	private String title;
	private String description;
	private String link;
	private int guid;
	private String pubDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Item: " + this.guid + "\nTitle: " + this.title + "\nDescription: " + this.description + "\nLink: " + this.link
				+ "\nPublish Date: " + this.pubDate + "\n-----------------------------------------------------------------------------------------";
	}
}
