package files;

import java.util.ArrayList;
import java.util.List;

public class ParsingClass {
	private String xml;
	private String artist;
	private String name;
	private List<String> tracks;



	public ParsingClass(String xml) {
		this.xml = xml;
		this.artist = null;
		this.name = null;
		this.tracks = new ArrayList<>();
	}


	public void parse() {
		int artistStart = xml.indexOf("<artist>") + "<artist>".length();
		int artistEnd = xml.indexOf("</artist>");
		this.artist = xml.substring(artistStart, artistEnd);

		int nameStart = xml.indexOf("<name>") + "<name>".length();
		int nameEnd = xml.indexOf("</name>");
		this.name = xml.substring(nameStart, nameEnd);

		int listStart = xml.indexOf("<list>") + "<list>".length();
		int listEnd = xml.indexOf("</list>");
		String tracksString = xml.substring(listStart, listEnd);

		// Split tracksString into individual tracks
		String[] trackArray = tracksString.split("</track>");
		for (String track : trackArray) {
			// Remove leading "<track>" and add the track to the list
			this.tracks.add(track.substring(track.indexOf("<track>") + "<track>".length()));
		}

	}

	public Object getArtist() {
		// TODO Auto-generated method stub
		return this.artist;

	}

	public Object getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public List<String> getTracks() {
		// TODO Auto-generated method stub
		return this.tracks;
	}

}
