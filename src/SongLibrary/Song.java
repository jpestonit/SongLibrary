/* 
 * 
 * 02/15
 * Joseph Pestonit
 * 
 */

package SongLibrary;



public class Song implements Comparable<Song>{
	/**
	 * 
	 */
	
	private String name;
	private String artist;
	private String album;
	private String year;
	
	public Song() {
		this.name = this.artist = this.album = this.year = "";
	}
	
	public Song(String name, String artist, String album, String year) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String toString() {
		return "Name:"+name+'\n' +" Artist: "+  artist + '\n' + " Album:" + album+'\n' + " Year:" + year;
	}

	public int compareTo(Song song) {
		if(name.compareToIgnoreCase(song.getName())!=0){
			return name.compareToIgnoreCase(song.getName());
		}else if(artist.compareToIgnoreCase(song.getArtist())!=0){
			return artist.compareToIgnoreCase(song.getArtist());
		}else{
			return 0;
		}
		
	}
	
}
