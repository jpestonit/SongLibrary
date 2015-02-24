/* 
 * 
 *02/15
 * Joseph Pestonit
 * 
 */


package SongLibrary;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class LibView extends JFrame {
	public SLV slv;
	public ArrayList<Song> songs;
	public SongInfo si;
	public IO io;
	public File f;
	private final String fileName = "songFile.txt";
	
	public LibView(ArrayList<Song> songs) {
		super("Song Library");
		
		this.setLayout(new GridLayout(0, 3));
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				closeSave();
				System.exit(0);
			}
		});
		
		this.songs = songs;
		slv = new SLV(this);
		si = new SongInfo(this);
		io = new IO(this);
	
		fileLoad();
		
		getContentPane().add(slv);
		getContentPane().add(si);
		getContentPane().add(io);
		
		pack();
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		setSize(800, 600);
		setMinimumSize(new Dimension(350, 225));
	}
	
	public void updateDisplay(){
		if(!songs.isEmpty()){
			si.name_T.setText(songs.get(slv.list.getSelectedIndex()).getName());
			si.album_T.setText(songs.get(slv.list.getSelectedIndex()).getAlbum());
			si.artist_T.setText(songs.get(slv.list.getSelectedIndex()).getArtist());
			si.year_T.setText(songs.get(slv.list.getSelectedIndex()).getYear());
			io.display.setText(songs.get(slv.list.getSelectedIndex()).toString());
		}
	};
	
	public void addSong() {		
		Song s = new Song();
		if(si.name_T.getText().isEmpty()||si.artist_T.getText().isEmpty()){
			io.error.setText("Song name and artist are required");
		}else{
			s.setName(si.name_T.getText());
			s.setArtist(si.artist_T.getText());
			s.setAlbum(si.album_T.getText());
			s.setYear(si.year_T.getText());
			sortAdd(s);
		}
	}
	
	private void sortAdd(Song s){
		if(!songs.isEmpty()){
			for(int i=0;i<songs.size();i++){
				if(s.compareTo(songs.get(i))<0){
					songs.add(i,s);
					slv.listMod.add(i,s.getName());
					slv.list.setSelectedIndex(i);
					io.error.setText("Song successfully added.");
					break;
				}
				if(s.compareTo(songs.get(i))==0){
					io.error.setText("Song already exists");
					break;
				}
				if(i==songs.size()-1){
					songs.add(s);
					slv.listMod.add(i+1,s.getName());
					slv.list.setSelectedIndex(i+1);
					io.error.setText("Song successfully added.");
					break;
				}
			}
		}else{
			songs.add(s);
			slv.listMod.add(0, s.getName());
			slv.list.setSelectedIndex(0);
		}
	}
	
	public void deleteSong(){
		if(slv.listMod.isEmpty()){
			io.error.setText("Nothing to delete.");
		}else{
			int index = slv.list.getSelectedIndex();
			songs.remove(index);
			slv.listMod.removeElementAt(index);
			io.error.setText("Song successfully deleted.");
		}
	}
	
	public void editSong(){	
		if(slv.listMod.isEmpty()){
			io.error.setText("Nothing to edit.");
		}else{
			Song s = new Song();
			s.setName(si.name_T.getText());
			s.setArtist(si.artist_T.getText());
			s.setAlbum(si.album_T.getText());
			s.setYear(si.year_T.getText());
			deleteSong();
			sortAdd(s);
			io.error.setText("Song successfully edited.");
		}
	}
	
	private void closeSave(){
		try{
			f = new File(fileName);
		
			if(!f.exists()){
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0;i<songs.size();i++){
				bw.write(songs.get(i).getName()+',');
				bw.write(songs.get(i).getArtist()+',');
				bw.write(songs.get(i).getAlbum()+',');
				bw.write(songs.get(i).getYear());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private void fileLoad(){

		try {
			f = new File(fileName);
			String songLine;
			if(!f.exists()){
				return;
			}else{
				FileReader fr = new FileReader(f.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				while((songLine = br.readLine())!=null){
					StringTokenizer st = new StringTokenizer(songLine,",");
					Song s = new Song();
					s.setName(st.nextToken());
					s.setArtist(st.nextToken());
					s.setAlbum(st.nextToken());
					s.setYear(st.nextToken());
					sortAdd(s);
				}
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
