/* 
 * 
 * 02/15
 * Joseph Pestonit
 * 
 */

package SongLibrary;


import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
public class SLV extends JPanel {
	public JList<String> list;
	public DefaultListModel<String> listMod;
	public JScrollPane scrollPane;
	
	public SLV(final LibView l) {
		super(new BorderLayout());
		
		this.listMod = new DefaultListModel<String>();
		this.list = new JList<String>(this.listMod);
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				if(list.getSelectedIndex()<0){
					list.setSelectedIndex(0);
				}
				l.updateDisplay();
			}
		});
		scrollPane = new JScrollPane(list);
		super.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void removeSongAtIndex(int index) {
		this.listMod.remove(index);
	}
	
	public void addSong(Song song) {
		this.listMod.addElement(song.getName());
	}
}

