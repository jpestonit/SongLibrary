/* 
 * 
 * 02/15
 * Joseph Pestonit
 * 
 */

package SongLibrary;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SongLib {

	public static void main(String[] args) throws ClassNotFoundException, IOException,FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Song> songs = new ArrayList<Song>();
		
	
		LibView main = new LibView(songs);
		main.setVisible(true);
		
	
	}
	

	


}
