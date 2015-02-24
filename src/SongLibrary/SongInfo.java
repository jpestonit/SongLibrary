/* 
 * 
 * YoungCheol Shin
 * Joseph Pestonit
 * 
 */

package SongLibrary;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SongInfo extends JPanel {
	public JLabel nameLabel;
	public JLabel artistLabel;
	public JLabel albumLabel;
	public JLabel yearLabel;
	public JTextField name_T;
	public JTextField artist_T;
	public JTextField album_T ;
	public JTextField year_T;
		
	public SongInfo(final LibView l) {
		super();
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(gridbag);
		
		this.nameLabel = new JLabel("Song: ");
		this.artistLabel = new JLabel("Artist: ");
		this.albumLabel = new JLabel("Album: ");
		this.yearLabel = new JLabel("Year: ");
		this.name_T = new JTextField("Name");
		this.artist_T = new JTextField("Artist");
		this.album_T = new JTextField("Album");
		this.year_T= new JTextField("Year");
		
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth=1;
		c.weighty = 1;
		c.weightx = 0;
		this.addLabel(this.nameLabel, Component.LEFT_ALIGNMENT);
		
		gridbag.setConstraints(nameLabel, c);
		add(nameLabel);
		
		c.weightx = 1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		gridbag.setConstraints(name_T, c);
		add(name_T);
		
		
		this.addLabel(this.artistLabel, Component.LEFT_ALIGNMENT);
		
		gridbag.setConstraints(artistLabel, c);
		add(artistLabel);
		
		c.weightx = 1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		gridbag.setConstraints(artist_T, c);
		add(artist_T);
		
		this.addLabel(this.albumLabel, Component.LEFT_ALIGNMENT);
		
		gridbag.setConstraints(albumLabel, c);
		add(albumLabel);
		
		c.weightx = 1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		gridbag.setConstraints(album_T, c);
		add(album_T);
		
		this.addLabel(this.yearLabel, Component.LEFT_ALIGNMENT);
		
		gridbag.setConstraints(yearLabel, c);
		add(yearLabel);
		
		c.weightx = 1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		gridbag.setConstraints(year_T, c);
		add(year_T);
		
	
		

	}
	
	private void addLabel(JLabel label, float alignmentX) {
		label.setAlignmentX(alignmentX);
		this.add(label);
	}
	
	
	public void setSong(Song song) {
		this.nameLabel.setText("Song: " + song.getName());
		this.artistLabel.setText("Artist: " + song.getArtist());
		this.albumLabel.setText("Album: " + song.getAlbum());
		this.yearLabel.setText("Year: " + song.getYear());
	}
}